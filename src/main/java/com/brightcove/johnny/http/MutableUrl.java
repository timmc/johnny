package com.brightcove.johnny.http;

import java.net.MalformedURLException;

/**
 * A non-concurrency-safe UrlBits implementation. Methods are generally not
 * thread-safe, and instances should not be shared outside of the scope they
 * are created in (as a best practice.)
 * <p>
 * Even though the "setters" always return the same instance they are called on,
 * client code should still use a chaining technique (allowing a safe and easy
 * transition to supporting immutable {@link Url} implementations as well):
 * <p>
 * <code>mutableUrl.withProtocol("http").withHost("example.net").unparse()</code>
 * <p>
 * Methods beginning with "set" are provided only for bean compability and
 * should have the same performance characteristics as the "with" methods.
 */
public class MutableUrl extends Url {
    private String protocol;
    private String userInfoRaw;
    private String host;
    private Long port;
    private String pathRaw;
    private String queryRaw;
    private String fragment;

    /**
     * Create an invalid URL (null protocol and host). Provided for bean
     * compatibility.
     */
    public MutableUrl() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Create a URL piecewise, with no validation. See accessors for
     * allowable values; parameters are here only described as nullable
     * or not.
     * @param protocol Non-null
     * @param userInfoRaw Nullable
     * @param host Non-null
     * @param port Nullable
     * @param pathRaw Non-null
     * @param queryRaw Nullable
     * @param fragment Nullable
     */
    public MutableUrl(String protocol, String userInfoRaw, String host,
                      Long port, String pathRaw, String queryRaw,
                      String fragment) {
        this.protocol = protocol;
        this.userInfoRaw = userInfoRaw;
        this.host = host;
        this.port = port;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragment = fragment;
    }

    /** Parse a string as a URL and extract the fields. */
    public static MutableUrl from(String url, UrlParser parser) throws MalformedURLException {
        Object[] args = parser.parse(url);
        return new MutableUrl((String) args[0], (String) args[1],
                (String) args[2], (Long) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    public String getProtocol() { return protocol; }
    /** Setter provided for bean compatibility. */
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public MutableUrl withProtocol(String protocol) {
        setProtocol(protocol);
        return this;
    }

    public String getUserInfoRaw() { return userInfoRaw; }
    /** Setter provided for bean compatibility. */
    public void setUserInfoRaw(String userInfoRaw) { this.userInfoRaw = userInfoRaw; }

    public MutableUrl withUserInfoRaw(String userInfoRaw) {
        setUserInfoRaw(userInfoRaw);
        return this;
    }

    public String getHost() { return host; }
    /** Setter provided for bean compatibility. */
    public void setHost(String host) { this.host = host; }

    public MutableUrl withHost(String host) {
        setHost(host);
        return this;
    }

    public Long getPort() { return port; }
    /** Setter provided for bean compatibility. */
    public void setPort(Long port) { this.port = port; }

    public MutableUrl withPort(Long port) {
        setPort(port);
        return this;
    }

    public String getPathRaw() { return pathRaw; }
    /** Setter provided for bean compatibility. */
    public void setPathRaw(String pathRaw) { this.pathRaw = pathRaw; }

    public MutableUrl withPathRaw(String pathRaw) {
        setPathRaw(pathRaw);
        return this;
    }

    public String getQueryRaw() { return queryRaw; }
    /** Setter provided for bean compatibility. */
    public void setQueryRaw(String queryRaw) { this.queryRaw = queryRaw; }

    public Url withQueryRaw(String queryRaw) {
        setQueryRaw(queryRaw);
        return this;
    }

    public String getFragment() { return fragment; }
    /** Setter provided for bean compatibility. */
    public void setFragment(String fragment) { this.fragment = fragment; }

    public Url withFragment(String fragment) {
        setFragment(fragment);
        return this;
    }
}