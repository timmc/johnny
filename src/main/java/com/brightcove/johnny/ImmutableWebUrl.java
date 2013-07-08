package com.brightcove.johnny;

import java.net.MalformedURLException;

/**
 * A concurrency-safe UrlBits implementation. Methods are generally
 * thread-safe, and instances may be freely shared outside of the scope they
 * are created in.
 *
 * Setters return a new instance instead of mutating the instance they are
 * called on. Client code can use a chaining technique, which will work with
 * mutable versions as well:
 *
 * <code>immutableUrl.withProtocol("http").withHost("example.net").unparse()</code>
 */
public class ImmutableWebUrl extends WebUrl {
    private final String protocol;
    private final String userInfo;
    private final String host;
    private final Long port;
    private final String pathRaw;
    private final String queryRaw;
    private final String fragment;

    private ImmutableWebUrl(String protocol, String userInfo, String host,
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
    public static ImmutableWebUrl fromFullUrl(String url) throws MalformedURLException {
        Object[] args = parseFullUrl(url);
        validateAllParts(args);
        return new ImmutableWebUrl((String) args[0], (String) args[1],
                (String) args[2], (Long) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    @Override
    public String getProtocol() { return protocol; }

    @Override
    public WebUrl withProtocol(String protocol) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public String getUserInfo() { return userInfo; }

    @Override
    public WebUrl withUserInfo(String userInfo) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public String getHost() { return host; }

    @Override
    public WebUrl withHost(String host) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public Long getPort() { return port; }

    @Override
    public WebUrl withPort(Long port) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public String getPathRaw() { return pathRaw; }

    @Override
    public WebUrl withPathRaw(String pathRaw) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public String getQueryRaw() { return queryRaw; }

    @Override
    public WebUrl withQueryRaw(String queryRaw) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    @Override
    public String getFragment() { return fragment; }

    @Override
    public WebUrl withFragment(String fragment) {
        return new ImmutableWebUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }
}