package org.timmc.johnny;


/**
 * Whole-URL formatter.
 */
public class UrlFormatter { //TODO convert to interface?

    private final StringEncoder fragEnc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_FRAGMENT));

    /**
     * Format a {@link Url} to a string.
     */
    public String format(Url url) {
        StringBuilder build = new StringBuilder();
        build.append(url.getScheme()).append("://");
        if (url.getUserInfoRaw() != null) {
            build.append(url.getUserInfoRaw()).append("@");
        }
        build.append(url.getHostRaw());
        if (url.getPort() != null) {
            build.append(":").append(url.getPort());
        }
        build.append(url.getPathRaw());
        if (url.getQueryRaw() != null) {
            build.append("?").append(url.getQueryRaw());
        }
        if (url.getFragment() != null) {
            build.append("#").append(fragEnc.encode(url.getFragment()));
        }
        return build.toString();
    }
}
