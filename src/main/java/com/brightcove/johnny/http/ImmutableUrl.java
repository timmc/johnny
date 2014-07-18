package com.brightcove.johnny.http;

import java.net.MalformedURLException;

/**
 * A concurrency-safe UrlBits implementation. Methods are generally
 * thread-safe, and instances may be freely shared outside of the scope they
 * are created in.
 */
public class ImmutableUrl extends Url {
    private final String scheme;
    private final String userInfoRaw;
    private final String hostRaw;
    private final Integer port;
    private final String pathRaw;
    private final String queryRaw;
    private final String fragment;

    /**
     * Create a URL piecewise, with no validation. See accessors for
     * allowable values; parameters are here only described as nullable
     * or not.
     * @param scheme Non-null
     * @param userInfoRaw Nullable
     * @param hostRaw Non-null
     * @param port Nullable
     * @param pathRaw Non-null
     * @param queryRaw Nullable
     * @param fragment Nullable
     */
    public ImmutableUrl(String scheme, String userInfoRaw, String hostRaw,
                        Integer port, String pathRaw, String queryRaw,
                        String fragment) {
        this.scheme = scheme;
        this.userInfoRaw = userInfoRaw;
        this.hostRaw = hostRaw;
        this.port = port;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragment = fragment;
    }

    /**
     * Create a URL piecewise with the bare minimum of components, with no
     * validation. See accessors for allowable values. No parameters may
     * by null.
     */
    public ImmutableUrl(String scheme, String hostRaw) {
        this(scheme, null, hostRaw, null, "", null, null);
    }

    /** Parse a string as a URL and extract the fields. */
    public static ImmutableUrl from(String url, UrlParser parser) throws MalformedURLException {
        Object[] args = parser.parse(url);
        return new ImmutableUrl((String) args[0], (String) args[1],
                (String) args[2], (Integer) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    public String getScheme() { return scheme; }

    public ImmutableUrl withScheme(String scheme) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public String getUserInfoRaw() { return userInfoRaw; }

    public ImmutableUrl withUserInfoRaw(String userInfoRaw) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public String getHostRaw() { return hostRaw; }

    public ImmutableUrl withHostRaw(String hostRaw) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public Integer getPort() { return port; }

    public ImmutableUrl withPort(Integer port) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public String getPathRaw() { return pathRaw; }

    public ImmutableUrl withPathRaw(String pathRaw) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public String getQueryRaw() { return queryRaw; }

    public ImmutableUrl withQueryRaw(String queryRaw) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }

    public String getFragment() { return fragment; }

    public ImmutableUrl withFragment(String fragment) {
        return new ImmutableUrl(scheme, userInfoRaw, hostRaw, port, pathRaw, queryRaw, fragment);
    }
}