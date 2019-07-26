package org.timmc.johnny

import org.timmc.johnny.internal.Codecs
import org.timmc.johnny.internal.UserPassParser

/**
 * A URI with a host component (usually synonymous with URL).
 *
 * This is a concurrency-safe class for manipulating URLs with a chaining API.
 * Methods are thread-safe, and instances may be freely shared outside of
 * the scope they are created in.
 */
data class HostedUri
    /**
     * Create a URL piecewise, with no validation.
     */
    constructor(
        /**
         * Raw, unnormalized scheme of URL. (Might not be all lowercase.) Not
         * null.
         */
        val schemeRaw: String,

        /** Undecoded user info of URL, excluding "@" separator. Nullable. */
        val userInfoRaw: String?,

        /** Host address (domain or IP address). Not null. */
        val host: Host,

        /** Undecoded port of host. Nullable. */
        val portRaw: String?,

        /**
         * Undecoded path portion of URL, possibly empty. If not empty, must
         * start with `/`. Not null.
         * To decode a path into segments and path parameters, use
         * [TextPath]. Do not simply percent-decode the raw path,
         * as that may expose encoded slashes.
         */
        val pathRaw: String,

        /**
         * Undecoded query portion of URL, excluding "?" separator. Nullable.
         * To decode a query into keys and values, use [query].
         */
        val queryRaw: String?,

        /**
         * Undecoded fragment portion of URL, excluding "#" separator. Nullable.
         */
        val fragmentRaw: String?
) {
    /**
     * Retrieve case-folded scheme component, if present.
     * @return Lowercased scheme, or null if missing.
     */

    val scheme: String
        get() {
            // Scheme is only supposed to be ASCII alphanumeric, so locale
            // shouldn't *generally* matter, but it's possible that a user
            // in a Turkish locale might have "IPFS".toLowerCase() -> "ıpfs"
            // (dotless lowercase I). So, use the so-called "empty locale"
            // to pin to English-like behavior.
            return schemeRaw.toLowerCase(Locale.ROOT)
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

    /** Unparsed host component. */
    val hostRaw: String?
        get() = host.raw


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
    val path: TextPath?
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

    /*== Convenience ==*/

    /**
     * Format this URL back into a string using default settings.
     */
    fun format(): String {
        return Urls.format(this)
    }

    /**
     * Set scheme component. This is no different from [withSchemeRaw]
     * and is included only for completeness.
     * @param scheme Nullable
     */
    fun withScheme(scheme: String): HostedUri {
        return withSchemeRaw(scheme)
    }

    /**
     * Set raw userinfo by encoding provided userinfo with standard userinfo encoder.
     * @param userInfo Nullable
     */
    fun withUserPass(userInfo: UserPass?): HostedUri {
        return withUserInfoRaw(userInfo?.format())
    }

    /** See [port].  */
    fun withPort(port: Int?): HostedUri {
        val portRaw = if (port == null) null else Integer.toString(port)
        return withPortRaw(portRaw)
    }

    /**
     * Set raw path by encoding provided path with standard path encoder. (TODO: Different language for with*)
     * @param path Non-null
     */
    fun withPath(path: TextPath): HostedUri {
        return withPathRaw(path.format())
    }

    /**
     * Set raw query by encoding provided query with standard query encoder.
     * @param q Possibly null Query
     */
    fun withQuery(q: Params): HostedUri {
        return withQueryRaw(Queries.formatQuery(q))
    }

    /**
     * Set raw fragment by encoding provided fragment with standard encoder.
     * @param fragment Possibly null fragment string
     */
    fun withFragment(fragment: String?): HostedUri {
        val fragmentRaw = if (fragment == null) null else Codecs.percentEncodeFragment(fragment)
        return withFragmentRaw(fragmentRaw)
    }

    /*== Convenience: Query-specific ==*/

    /**
     * Convenience method for [Params.replace]; for heavy
     * manipulation, use [query] and [withQuery].
     *
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    @Throws(UrlDecodeException::class)
    fun querySetKey(key: String?, value: String): HostedUri {
        if (key == null) {
            throw NullPointerException("Cannot append null query key")
        }
        return withQuery(query!!.replace(key, value))
    }

    /**
     * Convenience method for [Params.getAll]; for heavy
     * inspection use [query].
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
     * inspection use [query].
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

    /** See [schemeRaw]. */
    fun withSchemeRaw(schemeRaw: String): HostedUri {
        return copy(schemeRaw = schemeRaw)
    }

    /** See [userInfoRaw]. */
    fun withUserInfoRaw(userInfoRaw: String?): HostedUri  {
        return copy(userInfoRaw = userInfoRaw)
    }

    /** See [host]. */
    fun withHost(host: Host): HostedUri  {
        return copy(host = host)
    }

    /** See [portRaw]. */
    fun withPortRaw(portRaw: String?): HostedUri  {
        return copy(portRaw = portRaw)
    }

    /** See [pathRaw]. */
    fun withPathRaw(pathRaw: String): HostedUri  {
        return copy(pathRaw = pathRaw)
    }

    /** See [queryRaw]. */
    fun withQueryRaw(queryRaw: String?): HostedUri  {
        return copy(queryRaw = queryRaw)
    }

    /** See [fragmentRaw]. */
    fun withFragmentRaw(fragmentRaw: String?): HostedUri  {
        return copy(fragmentRaw = fragmentRaw)
    }
}
