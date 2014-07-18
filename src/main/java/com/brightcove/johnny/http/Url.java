package com.brightcove.johnny.http;

import java.util.Collection;

import clojure.lang.Util;

import com.brightcove.johnny.coll.ClojureHelper;
import com.brightcove.johnny.parts.Host;
import com.brightcove.johnny.parts.Params;
import com.brightcove.johnny.parts.QueryParser;
import com.brightcove.johnny.parts.TextPath;
import com.brightcove.johnny.parts.UserInfo;

/**
 * A base class for manipulating piecemeal URLs with a chaining API.
 *
 * "Setters" return a {@link Url} instance instead of returning void. The old
 * instance should be discarded unless the relying code is using a known
 * implementation class that relies on mutation. Client code should always use
 * a chaining technique, which will work with mutable versions as well:
 * <p>
 * <code>url.withScheme("http").withHost("example.net").unparse()</code>
 * <p>
 * Implementations SHOULD have the following:
 * <ul>
 *   <li>constructor <code>(String scheme, String host)</code></li>
 *   <li>factory method <code>from(String url, UrlParser parser)</code></li>
 *   <li>constructor <code>(String scheme, String userInfoRaw, String host,
 *       Integer port, String pathRaw, String queryRaw, String fragment)</code>
 *       </li>
 * </ul>
 *
 * @author timmc
 */
public abstract class Url {

    static { ClojureHelper.init(); }

    /*== Convenience ==*/

    /**
     * Convenience method to re-encode a URL.
     */
    public String unparse() {
        return Urls.DEFAULT_CODECS.urlEncoder.encode(this);
    }

    /**
     * Parse user information component as a {@link UserInfo} object, if present.
     * @return User info, or null if missing.
     */
    public UserInfo getUserInfo() {
        String raw = getUserInfoRaw();
        return raw == null ? null : Urls.DEFAULT_CODECS.userInfoParser.parse(raw);
    }

    /**
     * Set raw userinfo by encoding provided userinfo with standard userinfo encoder.
     * @param userInfo Nullable
     */
    public Url withUserInfo(UserInfo userInfo) {
        return withUserInfoRaw(userInfo == null ? null : Urls.DEFAULT_CODECS.userInfoEncoder.unparse(userInfo));
    }

    /**
     * Get host decoded using standard parser.
     */
    public Host getHost() {
        return Urls.DEFAULT_CODECS.hostParser.parse(getHostRaw());
    }

    /**
     * Parse and return the path component.
     * @return Non-null
     */
    public TextPath getPath() {
        return Urls.parsePath(getPathRaw());
    }

    /**
     * Set raw path by encoding provided path with standard path encoder.
     * @param path Non-null
     */
    public Url withPath(TextPath path) {
        return withPathRaw(Urls.DEFAULT_CODECS.pathEncoder.unparse(path.getSegments()));
    }

    /**
     * Get query decoded using standard parser. Assumes ampersand-separated
     * key-value pairs and treats missing values as empty strings. May not
     * preserve order of keys, but will preserve order of values.
     * @return Decoded query, or null
     */
    public Params getQuery() {
        String raw = getQueryRaw();
        return raw == null ? null : Urls.parseQuery(raw);
    }

    /**
     * Set raw query by encoding provided query with standard query encoder.
     * @param q Possibly null Query
     */
    public Url withQuery(Params q) {
        return withQueryRaw(Urls.DEFAULT_CODECS.queryEncoder.unparse(q));
    }

    /**
     * Convenience method for {@link Params#replace(String, String)}; for heavy
     * manipulation, use a {@link QueryParser} to produce a {@link Params},
     * which can be manipulated more efficiently. Uses {@link #getQuery()}.
     *
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    public Url querySetKey(String key, String value) {
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
    public Collection<String> queryGet(String key) {
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
    public String queryGetLast(String key) {
        if (key == null) {
            throw new NullPointerException("Cannot search for null query key");
        }
        return getQuery().getLast(key);
    }

    @Override
    public String toString() {
        return unparse();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Url)) {
            return false;
        }
        Url other = (Url) o;
        return Util.equiv(getScheme(), other.getScheme()) &&
                Util.equiv(getUserInfoRaw(), other.getUserInfoRaw()) &&
                Util.equiv(getHost(), other.getHost()) &&
                Util.equiv(getPort(), other.getPort()) &&
                Util.equiv(getPathRaw(), other.getPathRaw()) &&
                Util.equiv(getQueryRaw(), other.getQueryRaw()) &&
                Util.equiv(getFragment(), other.getFragment());
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
        cachedHashCode = Util.hash(getScheme()) + Util.hash(getUserInfoRaw()) +
                Util.hash(getHostRaw()) + Util.hash(getPort()) +
                Util.hash(getPathRaw()) + Util.hash(getQueryRaw()) + Util.hash(getFragment());
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

    /** Port of host, in valid range. Nullable. */
    public abstract Integer getPort();

    /** See {@link #getPort()}. */
    public abstract Url withPort(Integer port);

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

    /** Fragment portion of URL, excluding "#" separator. Nullable. */
    public abstract String getFragment();

    /** See {@link #getFragment()}. */
    public abstract Url withFragment(String fragment);

}