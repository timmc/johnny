package org.timmc.johnny;

/**
 * A concurrency-safe UrlBits implementation. Methods are generally
 * thread-safe, and instances may be freely shared outside of the scope they
 * are created in.
 */
public class ImmutableUrl extends Url {
    private final String schemeRaw;
    private final String userInfoRaw;
    private final String hostRaw;
    private final String portRaw;
    private final String pathRaw;
    private final String queryRaw;
    private final String fragmentRaw;

    /**
     * Create a URL piecewise, with no validation. See accessors for
     * allowable values; parameters are here only described as nullable
     * or not.
     * @param schemeRaw Non-null
     * @param userInfoRaw Nullable
     * @param hostRaw Non-null
     * @param portRaw Nullable
     * @param pathRaw Non-null
     * @param queryRaw Nullable
     * @param fragmentRaw Nullable
     */
    public ImmutableUrl(String schemeRaw, String userInfoRaw, String hostRaw,
                        String portRaw, String pathRaw, String queryRaw,
                        String fragmentRaw) {
        this.schemeRaw = schemeRaw;
        this.userInfoRaw = userInfoRaw;
        this.hostRaw = hostRaw;
        this.portRaw = portRaw;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragmentRaw = fragmentRaw;
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
    public static ImmutableUrl from(String url, UrlParser parser) throws UrlDecodeException {
        Object[] args = parser.parse(url);
        return new ImmutableUrl((String) args[0], (String) args[1],
                (String) args[2], (String) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    @Override
    public String getSchemeRaw() { return schemeRaw; }

    @Override
    public ImmutableUrl withSchemeRaw(String schemeRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getUserInfoRaw() { return userInfoRaw; }

    @Override
    public ImmutableUrl withUserInfoRaw(String userInfoRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getHostRaw() { return hostRaw; }

    @Override
    public ImmutableUrl withHostRaw(String hostRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getPortRaw() { return portRaw; }

    @Override
    public ImmutableUrl withPortRaw(String portRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getPathRaw() { return pathRaw; }

    @Override
    public ImmutableUrl withPathRaw(String pathRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getQueryRaw() { return queryRaw; }

    @Override
    public ImmutableUrl withQueryRaw(String queryRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getFragmentRaw() { return fragmentRaw; }

    @Override
    public ImmutableUrl withFragmentRaw(String fragmentRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, hostRaw, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public boolean implImmutable() {
        return true;
    }
}