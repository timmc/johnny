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
public class ImmutableHttpUrl extends HttpUrl {
    private final String protocol;
    private final String userInfo;
    private final String host;
    private final Long port;
    private final String pathRaw;
    private final String queryRaw;
    private final String fragment;

    private ImmutableHttpUrl(String protocol, String userInfo, String host,
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

    /** Parse a string as a URL and extract the fields. */
    public static ImmutableHttpUrl fromFullUrl(String url) throws MalformedURLException {
        Object[] args = HttpUrls.parseFullUrl(url);
        HttpUrls.validateAllParts(args);
        return new ImmutableHttpUrl((String) args[0], (String) args[1],
                (String) args[2], (Long) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    public String getProtocol() { return protocol; }

    public HttpUrl withProtocol(String protocol) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public String getUserInfo() { return userInfo; }

    public HttpUrl withUserInfo(String userInfo) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public String getHost() { return host; }

    public HttpUrl withHost(String host) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public Long getPort() { return port; }

    public HttpUrl withPort(Long port) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public String getPathRaw() { return pathRaw; }

    public HttpUrl withPathRaw(String pathRaw) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public String getQueryRaw() { return queryRaw; }

    public HttpUrl withQueryRaw(String queryRaw) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }

    public String getFragment() { return fragment; }

    public HttpUrl withFragment(String fragment) {
        return new ImmutableHttpUrl(protocol, userInfo, host, port, pathRaw, queryRaw, fragment);
    }
}