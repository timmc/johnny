package org.timmc.johnny;

import java.util.Collection;

import org.timmc.johnny.parts.Params;
import org.timmc.johnny.parts.QueryParser;
import org.timmc.johnny.parts.TextPath;
import org.timmc.johnny.parts.UserInfo;

/**
 * A base class for manipulating piecemeal URLs with a chaining API.
 *
 * "Setters" return a {@link Url} instance instead of returning void. The old
 * instance should be discarded unless the relying code is using a known
 * implementation class that relies on mutation. Client code should always use
 * a chaining technique, which will work with mutable versions as well:
 * <p>
 * <code>url.withScheme("http").withHost("example.net").format()</code>
 * <p>
 * Implementations SHOULD have the following:
 * <ul>
 *   <li>constructor <code>(String scheme, String host)</code></li>
 *   <li>factory method <code>from(String url, UrlParser parser)</code></li>
 *   <li>constructor <code>(String scheme, String userInfoRaw, String host,
 *       String portRaw, String pathRaw, String queryRaw, String fragmentRaw)</code>
 *       </li>
 * </ul>
 *
 * @author timmc
 */
public abstract class Url {

    /*== Convenience ==*/

    /**
     * Format this URL back into a string using default settings.
     */
    public String format() {
        return Urls.DEFAULT_CODECS.urlFormatter.format(this);
    }

    /**
     * Parse user information component as a {@link UserInfo} object, if present.
     * @return User info, or null if missing.
     */
    public UserInfo getUserInfo() throws UrlDecodeException {
        String raw = getUserInfoRaw();
        return raw == null ? null : Urls.DEFAULT_CODECS.userInfoParser.parse(raw);
    }

    /**
     * Set raw userinfo by encoding provided userinfo with standard userinfo encoder.
     * @param userInfo Nullable
     */
    public Url withUserInfo(UserInfo userInfo) {
        return withUserInfoRaw(userInfo == null ? null : Urls.DEFAULT_CODECS.userInfoFormatter.format(userInfo));
    }

    /** Port of host, in valid range. Nullable. */ // TODO: must be valid?
    public Integer getPort() throws UrlDecodeException {
        try {
            String portRaw = getPortRaw();
            return portRaw == null ? null : Integer.parseInt(portRaw);
        } catch (NumberFormatException nfe) {
            throw new UrlDecodeException("Could not parse port as integer", nfe);
        }
    }

    /** See {@link #getPort()}. */
    public Url withPort(Integer port) {
        String portRaw = port == null ? null : Integer.toString(port);
        return withPortRaw(portRaw);
    }

    /**
     * Parse and return the path component.
     * @return Non-null
     */
    public TextPath getPath() throws UrlDecodeException {
        return Urls.parsePath(getPathRaw());
    }

    /**
     * Set raw path by encoding provided path with standard path encoder. (TODO: Different language for with*)
     * @param path Non-null
     */
    public Url withPath(TextPath path) {
        return withPathRaw(Urls.DEFAULT_CODECS.pathFormatter.format(path.getSegments()));
    }

    /**
     * Get query decoded using standard parser. Assumes ampersand-separated
     * key-value pairs and treats missing values as empty strings. May not
     * preserve order of keys, but will preserve order of values.
     * @return Decoded query, or null
     */
    public Params getQuery() throws UrlDecodeException {
        String raw = getQueryRaw();
        return raw == null ? null : Urls.parseQuery(raw);
    }

    /**
     * Set raw query by encoding provided query with standard query encoder.
     * @param q Possibly null Query
     */
    public Url withQuery(Params q) {
        return withQueryRaw(Urls.DEFAULT_CODECS.queryFormatter.format(q));
    }

    /**
     * Get fragment contents, decoded using standard parser.
     * @return Decoded fragment, or null if no fragment
     */
    public String getFragment() throws UrlDecodeException {
        String fragmentRaw = getFragmentRaw();
        return fragmentRaw == null ? null : Codecs.percentDecode(fragmentRaw);
    }

    /**
     * Set raw fragment by encoding provided fragment with standard encoder.
     * @param fragment Possibly null fragment string
     */
    public Url withFragment(String fragment) {
        String fragmentRaw = fragment == null ? null : Codecs.percentEncodeFragment(fragment);
        return withFragmentRaw(fragmentRaw);
    }

    /*== Convenience: Query-specific ==*/

    /**
     * Convenience method for {@link Params#replace(String, String)}; for heavy
     * manipulation, use a {@link QueryParser} to produce a {@link Params},
     * which can be manipulated more efficiently. Uses {@link #getQuery()}.
     *
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    public Url querySetKey(String key, String value) throws UrlDecodeException {
        if (key == null) {
            throw new NullPointerException("Cannot append null query key");
        }
        return withQuery(getQuery().replace(key, value));
    }

    /**
     * Convenience method for {@link Params#getAll(String)}; for heavy
     * inspection use a {@link QueryParser} to produce a {@link Params},
     * which can be inspected more efficiently. Uses {@link #getQuery()}.
     *
     * @param key Non-null query param key (may be empty)
     * @return Possibly empty collection of values for key
     */
    public Collection<String> queryGet(String key) throws UrlDecodeException {
        if (key == null) {
            throw new NullPointerException("Cannot search for null query key");
        }
        return getQuery().getAll(key);
    }

    /**
     * Convenience method for {@link Params#getLast(String)}; for heavy
     * inspection use a {@link QueryParser} to produce a {@link Params},
     * which can be inspected more efficiently. Uses {@link #getQuery()}.
     *
     * @param key Non-null query param key (may be empty)
     * @return Last value for key, null iff key not present.
     */
    public String queryGetLast(String key) throws UrlDecodeException {
        if (key == null) {
            throw new NullPointerException("Cannot search for null query key");
        }
        return getQuery().getLast(key);
    }

    /*== Object overrides ==*/

    @Override
    public String toString() {
        return format();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Url)) {
            return false;
        }
        Url other = (Url) o;
        return Util.equiv(getScheme(), other.getScheme()) &&
                Util.equiv(getUserInfoRaw(), other.getUserInfoRaw()) &&
                Util.equiv(getHostRaw(), other.getHostRaw()) &&
                Util.equiv(getPortRaw(), other.getPortRaw()) &&
                Util.equiv(getPathRaw(), other.getPathRaw()) &&
                Util.equiv(getQueryRaw(), other.getQueryRaw()) &&
                Util.equiv(getFragmentRaw(), other.getFragmentRaw());
    }

    private Integer cachedHashCode = null;

    @Override
    public int hashCode() {
        // No need for synchronization, this is just an optimization. (Even if
        // this is changed to write a primitive int, that's a 32-bit operation
        // and therefore still atomic. (Writes to longs are not atomic.)
        if (implImmutable() && cachedHashCode != null) {
            return cachedHashCode;
        }
        cachedHashCode = Util.hash(getScheme()) + Util.hash(getUserInfoRaw()) +
                Util.hash(getHostRaw()) + Util.hash(getPortRaw()) +
                Util.hash(getPathRaw()) + Util.hash(getQueryRaw()) + Util.hash(getFragmentRaw());
        return cachedHashCode;
    }

    /*== Accessors ==*/

    /** Scheme of URL: http or https. Not null. */
    public abstract String getScheme();

    /** See {@link #getScheme()}. */
    public abstract Url withScheme(String scheme);

    /**
     * Undecoded user info of URL, excluding "@" separator. Nullable.
     * If you expect a colon-delimited username/password pair, use
     * {@link UserInfo} to decode it correctly. If this is instead expected
     * to be a single field, use {@link Codecs#percentDecode(String)}.
     */
    public abstract String getUserInfoRaw();

    /** See {@link #getUserInfoRaw()}. */
    public abstract Url withUserInfoRaw(String userInfoRaw);

    /** Unencoded host address (domain or IP address). Not null. */
    public abstract String getHostRaw();

    /** See {@link #getHostRaw()}. */
    public abstract Url withHostRaw(String hostRaw);

    /** Undecoded port of host. Nullable. */
    public abstract String getPortRaw();

    /** See {@link #getPortRaw()}. */
    public abstract Url withPortRaw(String portRaw);

    /**
     * Undecoded path portion of URL, possibly empty. If not empty, must
     * start with <code>/</code>. Not null.
     * To decode a path into segments and path parameters, use
     * {@link TextPath}. Do not simply percent-decode the raw path,
     * as that may expose encoded slashes.
     */
    public abstract String getPathRaw();

    /** See {@link #getPathRaw()}. */
    public abstract Url withPathRaw(String pathRaw);

    /**
     * Undecoded query portion of URL, excluding "?" separator. Nullable.
     * To decode a query into keys and values, use a {@link QueryParser}.
     */
    public abstract String getQueryRaw();

    /** See {@link #getQueryRaw()}. */
    public abstract Url withQueryRaw(String queryRaw);

    /** Undecoded fragment portion of URL, excluding "#" separator. Nullable. */
    public abstract String getFragmentRaw();

    /** See {@link #getFragmentRaw()}. */
    public abstract Url withFragmentRaw(String fragmentRaw);

    /*== Implementation inspectors ==*/

    /**
     * Answer if implementation is immutable. Consumers of Url objects from third-party code MAY use
     * this before deciding whether to use with* methods on the original object instead of copying
     * into an immutable version first, but are not required to.
     * 
     * @return true only if this implementation is immutable
     */
    public abstract boolean implImmutable();
}