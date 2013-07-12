package com.brightcove.johnny.http;

import java.util.Collection;

import com.brightcove.johnny.parts.PersistentMultimapQuery;
import com.brightcove.johnny.parts.Query;

/**
 * A base class for manipulating piecemeal URLs with a chaining API.
 *
 * "Setters" return a {@link Url} instance instead of returning void. The old
 * instance should be discarded unless the relying code is using a known
 * implementation class that relies on mutation. Client code should always use
 * a chaining technique, which will work with mutable versions as well:
 * <p>
 * <code>url.withProtocol("http").withHost("example.net").unparse()</code>
 * <p>
 * Implementations SHOULD have the following:
 * <ul>
 *   <li>constructor <code>(String protocol, String host)</code></li>
 *   <li>factory method <code>from(String url, UrlParser parser)</code></li>
 *   <li>constructor <code>(String protocol, String userInfoRaw, String host,
 *       Long port, String pathRaw, String queryRaw, String fragment)</code>
 *       </li>
 * </ul>
 *
 * @author timmc
 */
public abstract class Url {

    @Override
    public String toString() {
        return unparse();
    }

    /*== Convenience ==*/

    /**
     * Convenience method to re-encode a URL.
     */
    public String unparse() {
        return Urls.STANDARD_URL_ENCODER.encode(this);
    }

    /**
     * Convenience method for {@link Query#replace(String, String)}; for heavy
     * manipulation, use a {@link QueryParser} to produce a {@link Query},
     * which can be manipulated more efficiently. Assumes ampersand-separated
     * key-value pairs with nullable values.
     *
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    public Url querySetKey(String key, String value) {
        if (key == null) {
            throw new NullPointerException("Cannot append null query key");
        }
        String oldQS = getQueryRaw();
        Query q = new PersistentMultimapQuery(Urls.STANDARD_QUERY_PARSER.parseAs(oldQS));
        q = q.replace(key, value);
        return withQueryRaw(Urls.STANDARD_QUERY_ENCODER.unparse(q));
    }

    /**
     * Convenience method for {@link Query#getAll(String)}; for heavy
     * inspection use a {@link QueryParser} to produce a {@link Query},
     * which can be inspected more efficiently. Treats missing values
     * as empty strings.
     *
     * @param key Non-null query param key (may be empty)
     * @return Possibly empty collection of values for key
     */
    public Collection<String> queryGet(String key) {
        if (key == null) {
            throw new NullPointerException("Cannot search for null query key");
        }
        Query q = new PersistentMultimapQuery(Urls.STANDARD_QUERY_PARSER.parseAs(getQueryRaw()));
        return q.getAll(key);
    }

    /**
     * Convenience method for {@link Query#getLast(String)}; for heavy
     * inspection use a {@link QueryParser} to produce a {@link Query},
     * which can be inspected more efficiently. Treats missing values
     * as empty strings.
     *
     * @param key Non-null query param key (may be empty)
     * @return Last value for key, null iff key not present.
     */
    public String queryGetLast(String key) {
        if (key == null) {
            throw new NullPointerException("Cannot search for null query key");
        }
        Query q = new PersistentMultimapQuery(Urls.STANDARD_QUERY_PARSER.parseAs(getQueryRaw()));
        return q.getLast(key);
    }

    /*== Accessors ==*/

    /** Protocol (scheme) of URL: http or https. Not null. */
    public abstract String getProtocol();

    /** See {@link #getProtocol()}. */
    public abstract Url withProtocol(String protocol);

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
    public abstract String getHost();

    /** See {@link #getHost()}. */
    public abstract Url withHost(String host);

    /** Port of host, in valid range. Nullable. */
    public abstract Long getPort();

    /** See {@link #getPort()}. */
    public abstract Url withPort(Long port);

    /**
     * Undecoded path portion of URL, possibly empty. If not empty, must
     * start with <code>/</code>. Not null.
     * To decode a path into segments and path parameters, use
     * {@link Path}. Do not simply percent-decode the raw path,
     * as that may exposed encoded slashes.
     */
    //TODO: implement SimplePath and MatrixPath
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