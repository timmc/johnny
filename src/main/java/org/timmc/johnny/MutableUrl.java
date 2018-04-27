package org.timmc.johnny;

/**
 * A non-concurrency-safe UrlBits implementation. Use with <strong>great
 * caution</strong>. Not only are methods generally not thread-safe, but
 * instances should not be shared outside of the scope they are created
 * in unless you can guarantee the behavior of the other scope: Consumers
 * of Url objects might assume they are immutable and call with* methods
 * on them not knowing that they are mutating the object.
 * <p>
 * Even though the "setters" always return the same instance they are called on,
 * client code should still use a chaining technique (allowing a safe and easy
 * transition to supporting immutable {@link Url} implementations as well):
 * <p>
 * <code>mutableUrl.withScheme("http").withHostRaw("example.net").format()</code>
 * <p>
 * Methods beginning with "set" are provided only for bean compability and
 * should have the same performance characteristics as the "with" methods.
 */
public class MutableUrl extends Url {
    private String scheme;
    private String userInfoRaw;
    private String hostRaw;
    private String portRaw;
    private String pathRaw;
    private String queryRaw;
    private String fragmentRaw;

    /**
     * Create an invalid URL (null scheme and host). Provided for bean
     * compatibility.
     */
    public MutableUrl() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Create a URL piecewise, with no validation. See accessors for
     * allowable values; parameters are here only described as nullable
     * or not.
     * @param scheme Non-null
     * @param userInfoRaw Nullable
     * @param hostRaw Non-null
     * @param portRaw Nullable
     * @param pathRaw Non-null
     * @param queryRaw Nullable
     * @param fragmentRaw Nullable
     */
    public MutableUrl(String scheme, String userInfoRaw, String hostRaw,
                      String portRaw, String pathRaw, String queryRaw,
                      String fragmentRaw) {
        this.scheme = scheme;
        this.userInfoRaw = userInfoRaw;
        this.hostRaw = hostRaw;
        this.portRaw = portRaw;
        this.pathRaw = pathRaw;
        this.queryRaw = queryRaw;
        this.fragmentRaw = fragmentRaw;
    }

    /** Parse a string as a URL and extract the fields. */
    public static MutableUrl from(String url, UrlParser parser) throws UrlDecodeException {
        Object[] args = parser.parse(url);
        return new MutableUrl((String) args[0], (String) args[1],
                (String) args[2], (String) args[3], (String) args[4],
                (String) args[5], (String) args[6]);
    }

    @Override
    public String getScheme() { return scheme; }
    /** Setter provided for bean compatibility. */
    public void setScheme(String scheme) { this.scheme = scheme; }

    @Override
    public MutableUrl withScheme(String scheme) {
        setScheme(scheme);
        return this;
    }

    @Override
    public String getUserInfoRaw() { return userInfoRaw; }
    /** Setter provided for bean compatibility. */
    public void setUserInfoRaw(String userInfoRaw) { this.userInfoRaw = userInfoRaw; }

    @Override
    public MutableUrl withUserInfoRaw(String userInfoRaw) {
        setUserInfoRaw(userInfoRaw);
        return this;
    }

    @Override
    public String getHostRaw() { return hostRaw; }
    /** Setter provided for bean compatibility. */
    public void setHostRaw(String hostRaw) { this.hostRaw = hostRaw; }

    @Override
    public MutableUrl withHostRaw(String hostRaw) {
        setHostRaw(hostRaw);
        return this;
    }

    @Override
    public String getPortRaw() { return portRaw; }
    /** Setter provided for bean compatibility. */
    public void setPortRaw(String portRaw) { this.portRaw = portRaw; }

    @Override
    public MutableUrl withPortRaw(String portRaw) {
        setPortRaw(portRaw);
        return this;
    }

    @Override
    public String getPathRaw() { return pathRaw; }
    /** Setter provided for bean compatibility. */
    public void setPathRaw(String pathRaw) { this.pathRaw = pathRaw; }

    @Override
    public MutableUrl withPathRaw(String pathRaw) {
        setPathRaw(pathRaw);
        return this;
    }

    @Override
    public String getQueryRaw() { return queryRaw; }
    /** Setter provided for bean compatibility. */
    public void setQueryRaw(String queryRaw) { this.queryRaw = queryRaw; }

    @Override
    public MutableUrl withQueryRaw(String queryRaw) {
        setQueryRaw(queryRaw);
        return this;
    }

    @Override
    public String getFragmentRaw() { return fragmentRaw; }
    /** Setter provided for bean compatibility. */
    public void setFragmentRaw(String fragmentRaw) { this.fragmentRaw = fragmentRaw; }

    @Override
    public MutableUrl withFragmentRaw(String fragmentRaw) {
        setFragmentRaw(fragmentRaw);
        return this;
    }

    @Override
    public boolean implImmutable() {
        return false;
    }
}