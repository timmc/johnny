package com.brightcove.johnny.http;

import com.brightcove.johnny.Ascii7Oracle;
import com.brightcove.johnny.ByCharPercentEncoder;
import com.brightcove.johnny.Constants;
import com.brightcove.johnny.StringEncoder;

/**
 * Whole-URL encoder.
 */
public class UrlEncoder { //TODO convert to interface?

    private final StringEncoder enc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_FRAGMENT));

    /**
     * Encode a {@link Url} to a string.
     */
    public String encode(Url url) {
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
            build.append("#").append(enc.encode(url.getFragment()));
        }
        return build.toString();
    }
}
