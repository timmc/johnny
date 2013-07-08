package com.brightcove.johnny;

import java.net.MalformedURLException;

/**
 * A non-concurrency-safe UrlBits implementation. Methods are generally not
 * thread-safe, and instances should not be shared outside of the scope they
 * are created in (as a best practice.)
 *
 * Even though the setters always return the same instance they are called on,
 * client code should still use a chaining technique (allowing a safe and easy
 * transition to supporting immutable UrlBits implementations as well):
 *
 * <code>mutableUrl.withProtocol("http").withHost("example.net").unparse()</code>
 */
public class MutableHttpUrl extends HttpUrl {
    private String protocol;
    private String userInfoRaw;
    private String host;
    private Long port;
    private String pathRaw;
    private String queryRaw;
    private String fragment;

    private MutableHttpUrl(String protocol, String userInfoRaw, String host,
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
    public static MutableHttpUrl fromFullUrl(String url) throws MalformedURLException {
        Object[] args = HttpUrls.parseFullUrl(url);
        HttpUrls.validateAllParts(args);
        return new MutableHttpUrl((String) args[0], (String) args[1],
                (String) args[2], (Long) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public MutableHttpUrl withProtocol(String protocol) {
        setProtocol(protocol);
        return this;
    }

    public String getUserInfoRaw() { return userInfoRaw; }
    public void setUserInfoRaw(String userInfoRaw) { this.userInfoRaw = userInfoRaw; }

    public MutableHttpUrl withUserInfoRaw(String userInfoRaw) {
        setUserInfoRaw(userInfoRaw);
        return this;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public MutableHttpUrl withHost(String host) {
        setHost(host);
        return this;
    }

    public Long getPort() { return port; }
    public void setPort(Long port) { this.port = port; }

    public MutableHttpUrl withPort(Long port) {
        setPort(port);
        return this;
    }

    public String getPathRaw() { return pathRaw; }
    public void setPathRaw(String pathRaw) { this.pathRaw = pathRaw; }

    public MutableHttpUrl withPathRaw(String pathRaw) {
        setPathRaw(pathRaw);
        return this;
    }

    public String getQueryRaw() { return queryRaw; }
    public void setQueryRaw(String queryRaw) { this.queryRaw = queryRaw; }

    public HttpUrl withQueryRaw(String queryRaw) {
        setQueryRaw(queryRaw);
        return this;
    }

    public String getFragment() { return fragment; }
    public void setFragment(String fragment) { this.fragment = fragment; }

    public HttpUrl withFragment(String fragment) {
        setFragment(fragment);
        return this;
    }
}