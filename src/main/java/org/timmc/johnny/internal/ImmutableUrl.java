package org.timmc.johnny.internal;

import org.timmc.johnny.Host;
import org.timmc.johnny.Url;

/**
 * A concurrency-safe Url implementation. Methods are generally
 * thread-safe, and instances may be freely shared outside of the scope they
 * are created in.
 */
public class ImmutableUrl extends Url {
    private final String schemeRaw;
    private final String userInfoRaw;
    private final Host host;
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
     * @param host Non-null
     * @param portRaw Nullable
     * @param pathRaw Non-null
     * @param queryRaw Nullable
     * @param fragmentRaw Nullable
     */
    public ImmutableUrl(String schemeRaw, String userInfoRaw, Host host,
                        String portRaw, String pathRaw, String queryRaw,
                        String fragmentRaw) {
        this.schemeRaw = schemeRaw;
        this.userInfoRaw = userInfoRaw;
        this.host = host;
        this.portRaw = portRaw;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragmentRaw = fragmentRaw;
    }

    @Override
    public String getSchemeRaw() { return schemeRaw; }

    @Override
    public ImmutableUrl withSchemeRaw(String schemeRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getUserInfoRaw() { return userInfoRaw; }

    @Override
    public ImmutableUrl withUserInfoRaw(String userInfoRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getHostRaw() { return host.getRaw(); }

    @Override
    public Host getHost() { return host; }

    @Override
    public ImmutableUrl withHost(Host host) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getPortRaw() { return portRaw; }

    @Override
    public ImmutableUrl withPortRaw(String portRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getPathRaw() { return pathRaw; }

    @Override
    public ImmutableUrl withPathRaw(String pathRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getQueryRaw() { return queryRaw; }

    @Override
    public ImmutableUrl withQueryRaw(String queryRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    @Override
    public String getFragmentRaw() { return fragmentRaw; }

    @Override
    public ImmutableUrl withFragmentRaw(String fragmentRaw) {
        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }
}
