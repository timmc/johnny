package org.timmc.johnny;


/**
 * Whole-URL formatter.
 */
public class UrlFormatter { //TODO convert to interface?

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
        if (url.getPortRaw() != null) {
            build.append(":").append(url.getPortRaw());
        }
        build.append(url.getPathRaw());
        if (url.getQueryRaw() != null) {
            build.append("?").append(url.getQueryRaw());
        }
        if (url.getFragmentRaw() != null) {
            build.append("#").append(url.getFragmentRaw());
        }
        return build.toString();
    }
}
