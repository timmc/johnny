package org.timmc.johnny

import org.timmc.johnny.internal.Codecs
import org.timmc.johnny.internal.UserPassParser

/**
 * A base class for manipulating piecemeal URLs with a chaining API.
 *
 * "Setters" return a [Url] instance instead of returning void. The old
 * instance should be discarded unless the relying code is using a known
 * implementation class that relies on mutation. Client code should always use
 * a chaining technique, which will work with mutable versions as well:
 *
 *
 * `url.withScheme("http").withHost("example.net").format()`
 *
 *
 * Implementations SHOULD have the following:
 *
 *  * constructor `(String scheme, String host)`
 *  * factory method `from(String url, UrlParser parser)`
 *  * constructor `(String scheme, String userInfoRaw, String host,
 *    String portRaw, String pathRaw, String queryRaw, String fragmentRaw)`
 */
abstract class Url {

    /**
     * Retrieve case-folded scheme component, if present.
     * @return Lowercased scheme, or null if missing.
     */

    val scheme: String?
        get() {
            return schemeRaw?.toLowerCase() // TODO choose locale?
        }

    /**
     * Parse user information component as a [UserPass] object with
     * username and optional password, or null if userinfo missing.
     * @return User info, or null if missing.
     */
    val userPass: UserPass?
        @Throws(UrlDecodeException::class)
        get() {
            return userInfoRaw?.let{ UserPassParser.parse(it) }
        }

    /** Port of host, in valid range. Nullable.  */ // TODO: must be valid?
    val port: Int?
        @Throws(UrlDecodeException::class)
        get() {
            try {
                val portRaw = portRaw
                return if (portRaw == null || portRaw.isEmpty())
                    null
                else
                    Integer.parseInt(portRaw)
            } catch (nfe: NumberFormatException) {
                throw UrlDecodeException("Could not parse port as integer", nfe)
            }

        }

    /**
     * Parse and return the path component.
     * @return Non-null
     */
    val path: TextPath
        @Throws(UrlDecodeException::class)
        get() = Urls.parsePath(pathRaw)

    /**
     * Get query decoded using standard parser. Assumes ampersand-separated
     * key-value pairs and treats missing values as empty strings. May not
     * preserve order of keys, but will preserve order of values.
     * @return Decoded query, or null
     */
    val query: Params?
        @Throws(UrlDecodeException::class)
        get() {
            val raw = queryRaw
            return if (raw == null) null else Urls.parseQuery(raw)
        }

    /**
     * Get fragment contents, decoded using standard parser.
     * @return Decoded fragment, or null if no fragment
     */
    val fragment: String?
        @Throws(UrlDecodeException::class)
        get() {
            val fragmentRaw = fragmentRaw
            return if (fragmentRaw == null) null else Codecs.percentDecode(fragmentRaw)
        }

    /*== Accessors ==*/

    /** Raw, unnormalized scheme of URL. (Might not be all lowercase.) Not null.  */
    abstract val schemeRaw: String? // TODO Should this be nullable?

    /** Undecoded user info of URL, excluding "@" separator. Nullable.  */
    abstract val userInfoRaw: String?

    /** Host address (domain or IP address). Not null.  */
    abstract val host: Host

    /** Unparsed host component.  */
    abstract val hostRaw: String

    /** Undecoded port of host. Nullable.  */
    abstract val portRaw: String?

    /**
     * Undecoded path portion of URL, possibly empty. If not empty, must
     * start with `/`. Not null.
     * To decode a path into segments and path parameters, use
     * [TextPath]. Do not simply percent-decode the raw path,
     * as that may expose encoded slashes.
     */
    abstract val pathRaw: String

    /**
     * Undecoded query portion of URL, excluding "?" separator. Nullable.
     * To decode a query into keys and values, use [.getQuery].
     */
    abstract val queryRaw: String?

    /** Undecoded fragment portion of URL, excluding "#" separator. Nullable.  */
    abstract val fragmentRaw: String?

    /*== Convenience ==*/

    /**
     * Format this URL back into a string using default settings.
     */
    fun format(): String {
        return Urls.format(this)
    }

    /**
     * Set scheme component. This is no different from [.withSchemeRaw]
     * and is included only for completeness.
     * @param scheme Nullable
     */
    fun withScheme(scheme: String): Url {
        return withSchemeRaw(scheme)
    }

    /**
     * Set raw userinfo by encoding provided userinfo with standard userinfo encoder.
     * @param userInfo Nullable
     */
    fun withUserPass(userInfo: UserPass?): Url {
        return withUserInfoRaw(userInfo?.format())
    }

    /** See [.getPort].  */
    fun withPort(port: Int?): Url {
        val portRaw = if (port == null) null else Integer.toString(port)
        return withPortRaw(portRaw)
    }

    /**
     * Set raw path by encoding provided path with standard path encoder. (TODO: Different language for with*)
     * @param path Non-null
     */
    fun withPath(path: TextPath): Url {
        return withPathRaw(path.format())
    }

    /**
     * Set raw query by encoding provided query with standard query encoder.
     * @param q Possibly null Query
     */
    fun withQuery(q: Params): Url {
        return withQueryRaw(Queries.formatQuery(q))
    }

    /**
     * Set raw fragment by encoding provided fragment with standard encoder.
     * @param fragment Possibly null fragment string
     */
    fun withFragment(fragment: String?): Url {
        val fragmentRaw = if (fragment == null) null else Codecs.percentEncodeFragment(fragment)
        return withFragmentRaw(fragmentRaw)
    }

    /*== Convenience: Query-specific ==*/

    /**
     * Convenience method for [Params.replace]; for heavy
     * manipulation, use [.getQuery] and [.withQuery].
     *
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    @Throws(UrlDecodeException::class)
    fun querySetKey(key: String?, value: String): Url {
        if (key == null) {
            throw NullPointerException("Cannot append null query key")
        }
        return withQuery(query!!.replace(key, value))
    }

    /**
     * Convenience method for [Params.getAll]; for heavy
     * inspection use [.getQuery].
     *
     * @param key Non-null query param key (may be empty)
     * @return Possibly empty collection of values for key
     */
    @Throws(UrlDecodeException::class)
    fun queryGet(key: String?): Collection<String?> {
        if (key == null) {
            throw NullPointerException("Cannot search for null query key")
        }
        return query!!.getAll(key)
    }

    /**
     * Convenience method for [Params.getLast]; for heavy
     * inspection use [.getQuery].
     *
     * @param key Non-null query param key (may be empty)
     * @return Last value for key, null iff key not present.
     */
    @Throws(UrlDecodeException::class)
    fun queryGetLast(key: String?): String? {
        if (key == null) {
            throw NullPointerException("Cannot search for null query key")
        }
        return query!!.getLast(key)
    }

    /** See [.getSchemeRaw].  */
    abstract fun withSchemeRaw(schemeRaw: String): Url

    /** See [.getUserInfoRaw].  */
    abstract fun withUserInfoRaw(userInfoRaw: String?): Url

    /** See [.getHost].  */
    abstract fun withHost(host: Host): Url

    /** See [.getPortRaw].  */
    abstract fun withPortRaw(portRaw: String?): Url

    /** See [.getPathRaw].  */
    abstract fun withPathRaw(pathRaw: String): Url

    /** See [.getQueryRaw].  */
    abstract fun withQueryRaw(queryRaw: String?): Url

    /** See [.getFragmentRaw].  */
    abstract fun withFragmentRaw(fragmentRaw: String?): Url
}
