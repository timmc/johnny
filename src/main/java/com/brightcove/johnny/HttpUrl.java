package com.brightcove.johnny;

/**
 * A base class for piecemeal URLs.
 *
 * @author timmc
 */
public abstract class HttpUrl {

    /*== To/from String ==*/

    /**
     * Emit the string form of this URL.
     */
    public String unparse() {
        StringBuilder build = new StringBuilder();
        build.append(getProtocol()).append("://");
        if (getUserInfoRaw() != null) {
            build.append(getUserInfoRaw()).append("@");
        }
        build.append(getHost());
        if (getPort() != null) {
            build.append(":").append(getPort());
        }
        build.append(getPathRaw());
        if (getQueryRaw() != null) {
            build.append("?").append(getQueryRaw());
        }
        if (getFragment() != null) {
            build.append("#").append(Urls.encodeFragment(getFragment()));
        }
        return build.toString();
    }

    @Override
    public String toString() {
        return unparse();
    }

    /*== Convenience ==*/

    /**
     * Add a query parameter in the standard fashion. (<code>&amp;</code>-delimited)
     * @param key Non-null query param key (may be empty)
     * @param value Nullable query param value
     */
    public HttpUrl addQueryParam(String key, String value) {
        if (key == null) {
            throw new NullPointerException("Cannot append null query key");
        }
        // TODO: Extract into StandardQS#appendKV(String, String)
        String oldQS = getQueryRaw();
        StringBuilder newQS = new StringBuilder();
        if (oldQS != null) {
            newQS.append(oldQS);
        }
        if (!oldQS.endsWith("&")) {
            newQS.append('&');
        }
        newQS.append(key);
        if (value != null) {
            newQS.append('=').append(value);
        }
        return withQueryRaw(newQS.toString());
    }

    /*== Accessors ==*/

    /** Protocol (scheme) of URL: http or https. Not null. */
    public abstract String getProtocol();

    /** See {@link #getProtocol()}. */
    public abstract HttpUrl withProtocol(String protocol);

    /**
     * Undecoded user info of URL, excluding "@" separator. Nullable.
     * If you expect a :-delimited username/password pair, use
     * {@link UserInfo} to decode it correctly. If this is instead expected
     * to be a single field, use {@link Urls#percentDecode(String)}.
     */
    public abstract String getUserInfoRaw();

    /** See {@link #getUserInfoRaw()}. */
    public abstract HttpUrl withUserInfoRaw(String userInfoRaw);

    /** Host address (domain or IP address). Not null. */
    public abstract String getHost();

    /** See {@link #getHost()}. */
    public abstract HttpUrl withHost(String host);

    /** Port of host, in valid range. Nullable. */
    public abstract Long getPort();

    /** See {@link #getPort()}. */
    public abstract HttpUrl withPort(Long port);

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
    public abstract HttpUrl withPathRaw(String pathRaw);

    /**
     * Undecoded query portion of URL, excluding "?" separator. Nullable.
     * To decode a query into keys and values, use {@link Query}.
     */
    //TODO Query
    public abstract String getQueryRaw();

    /** See {@link #getQueryRaw()}. */
    public abstract HttpUrl withQueryRaw(String queryRaw);

    /** Fragment portion of URL, excluding "#" separator. Nullable. */
    public abstract String getFragment();

    /** See {@link #getFragment()}. */
    public abstract HttpUrl withFragment(String fragment);

}