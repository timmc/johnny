package org.timmc.johnny;

import java.util.Collection;

import org.timmc.johnny.parts.Host;
import org.timmc.johnny.parts.Params;
import org.timmc.johnny.parts.QueryParser;
import org.timmc.johnny.parts.TextPath;
import org.timmc.johnny.parts.UserInfo;
import org.timmc.johnny.parts.UserInfoParser;

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
        return Urls.format(this);
    }

    /**
     * Retrieve case-folded scheme component, if present.
     * @return Lowercased scheme, or null if missing.
     */
    public String getScheme() {
        String raw = getSchemeRaw();
        return raw == null ? null : raw.toLowerCase(); // TODO choose locale?
    }

    /**
     * Set scheme component. This is no different from {@link #withSchemeRaw(String)}
     * and is included only for completeness.
     * @param scheme Nullable
     */
    public Url withScheme(String scheme) {
        return withSchemeRaw(scheme);
    }

    /**
     * Parse user information component as a {@link UserInfo} object with
     * username and password, or null if userinfo missing.
     * @return User info, or null if missing.
     */
    public UserInfo getUserInfoAsUserPass() throws UrlDecodeException {
        String raw = getUserInfoRaw();
        return raw == null ? null : UserInfoParser.parseUserPass(raw);
    }

    /**
     * Set raw userinfo by encoding provided userinfo with standard userinfo encoder.
     * @param userInfo Nullable
     */
    public Url withUserInfo(UserInfo userInfo) {
        return withUserInfoRaw(userInfo == null ? null : userInfo.format());
    }

    /** Port of host, in valid range. Nullable. */ // TODO: must be valid?
    public Integer getPort() throws UrlDecodeException {
        try {
            String portRaw = getPortRaw();
            return portRaw == null || portRaw.isEmpty() ? null : Integer.parseInt(portRaw);
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
        return withPathRaw(path.format());
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
        return withQueryRaw(Urls.queryFormatter.format(q));
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
        return String.format("#<Url %s>", format());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Url)) {
            return false;
        }
        Url other = (Url) o;
        return Util.equiv(getSchemeRaw(), other.getSchemeRaw()) &&
                Util.equiv(getUserInfoRaw(), other.getUserInfoRaw()) &&
                Util.equiv(getHost(), other.getHost()) &&
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
        if (cachedHashCode != null) {
            return cachedHashCode;
        }
        cachedHashCode = Util.hash(getSchemeRaw()) + Util.hash(getUserInfoRaw()) +
                Util.hash(getHost().getRaw()) + Util.hash(getPortRaw()) +
                Util.hash(getPathRaw()) + Util.hash(getQueryRaw()) + Util.hash(getFragmentRaw());
        return cachedHashCode;
    }

    /*== Accessors ==*/

    /** Raw, unnormalized scheme of URL. (Might not be all lowercase.) Not null. */
    public abstract String getSchemeRaw();

    /** See {@link #getSchemeRaw()}. */
    public abstract Url withSchemeRaw(String schemeRaw);

    /**
     * Undecoded user info of URL, excluding "@" separator. Nullable.
     * If you expect a colon-delimited username/password pair, use
     * {@link UserInfo} to decode it correctly. If this is instead expected
     * to be a single field, use {@link Codecs#percentDecode(String)}.
     */
    public abstract String getUserInfoRaw();

    /** See {@link #getUserInfoRaw()}. */
    public abstract Url withUserInfoRaw(String userInfoRaw);

    /** Host address (domain or IP address). Not null. */
    public abstract Host getHost();

    /** See {@link #getHost()}. */
    public abstract Url withHost(Host host);

    /** Unparsed host component. */
    public abstract String getHostRaw();

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
}
