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
public class MutableWebUrl extends WebUrl {
    private String protocol;
    private String userInfo;
    private String host;
    private Long port;
    private String pathRaw;
    private String queryRaw;
    private String fragment;

    private MutableWebUrl(String protocol, String userInfo, String host,
                          Long port, String pathRaw, String queryRaw,
                          String fragment) {
        this.protocol = protocol;
        this.userInfo = userInfo;
        this.host = host;
        this.port = port;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragment = fragment;
    }

    /** Parse a string as a {@link java.net.URL} and use the fields. */
    public static MutableWebUrl fromFullUrl(String url) throws MalformedURLException {
        Object[] args = parseFullUrl(url);
        validateAllParts(args);
        return new MutableWebUrl((String) args[0], (String) args[1],
                (String) args[2], (Long) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    @Override
    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    @Override
    public WebUrl withProtocol(String protocol) {
        setProtocol(protocol);
        return this;
    }

    @Override
    public String getUserInfo() { return userInfo; }
    public void setUserInfo(String userInfo) { this.userInfo = userInfo; }

    @Override
    public WebUrl withUserInfo(String userInfo) {
        setUserInfo(userInfo);
        return this;
    }

    @Override
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    @Override
    public WebUrl withHost(String host) {
        setHost(host);
        return this;
    }

    @Override
    public Long getPort() { return port; }
    public void setPort(Long port) { this.port = port; }

    @Override
    public WebUrl withPort(Long port) {
        setPort(port);
        return this;
    }

    @Override
    public String getPathRaw() { return pathRaw; }
    public void setPathRaw(String pathRaw) { this.pathRaw = pathRaw; }

    @Override
    public WebUrl withPathRaw(String pathRaw) {
        setPathRaw(pathRaw);
        return this;
    }

    @Override
    public String getQueryRaw() { return queryRaw; }
    public void setQueryRaw(String queryRaw) { this.queryRaw = queryRaw; }

    @Override
    public WebUrl withQueryRaw(String queryRaw) {
        setQueryRaw(queryRaw);
        return this;
    }

    @Override
    public String getFragment() { return fragment; }
    public void setFragment(String fragment) { this.fragment = fragment; }

    @Override
    public WebUrl withFragment(String fragment) {
        setFragment(fragment);
        return this;
    }
}