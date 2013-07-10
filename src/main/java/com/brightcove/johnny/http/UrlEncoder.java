package com.brightcove.johnny.http;

/**
 * Whole-URL encoder.
 */
public class UrlEncoder { //TODO convert to interface?

    /**
     * Encode a {@link Url} to a string.
     */
    public String encode(Url url) {
        StringBuilder build = new StringBuilder();
        build.append(url.getProtocol()).append("://");
        if (url.getUserInfoRaw() != null) {
            build.append(url.getUserInfoRaw()).append("@");
        }
        build.append(url.getHost());
        if (url.getPort() != null) {
            build.append(":").append(url.getPort());
        }
        build.append(url.getPathRaw());
        if (url.getQueryRaw() != null) {
            build.append("?").append(url.getQueryRaw());
        }
        if (url.getFragment() != null) {
            build.append("#").append(Urls.encodeFragment(url.getFragment()));
        }
        return build.toString();
    }
}
