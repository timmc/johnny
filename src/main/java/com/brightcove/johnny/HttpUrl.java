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
        if (getUserInfo() != null) {
            build.append(getUserInfo()).append("@");
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
            build.append("#").append(getFragment()); //FIXME: Encode properly
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

    /** User info of URL, excluding "@" separator. Nullable. */
    public abstract String getUserInfo(); // TODO: raw vs. decoded

    /** See {@link #getUserInfo()}. */
    public abstract HttpUrl withUserInfo(String userInfo);

    /** Host address (domain or IP address). Not null. */
    public abstract String getHost();

    /** See {@link #getHost()}. */
    public abstract HttpUrl withHost(String host);

    /** Port of host, in valid range. Nullable. */
    public abstract Long getPort();

    /** See {@link #getPort()}. */
    public abstract HttpUrl withPort(Long port);

    /** Undecoded path portion of URL, possibly empty. Not null. */
    public abstract String getPathRaw();

    /** See {@link #getPathRaw()}. */
    public abstract HttpUrl withPathRaw(String pathRaw);

    /** Undecoded query portion of URL, excluding "?" separator. Nullable. */ //TODO link to decomposer
    public abstract String getQueryRaw();

    /** See {@link #getQueryRaw()}. */
    public abstract HttpUrl withQueryRaw(String queryRaw);

    /** Fragment portion of URL, excluding "#" separator. Nullable. */
    public abstract String getFragment(); // TODO: raw vs. decoded

    /** See {@link #getFragment()}. */
    public abstract HttpUrl withFragment(String fragment);

}