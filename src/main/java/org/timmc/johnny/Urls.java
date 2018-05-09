package org.timmc.johnny;

import org.timmc.johnny.parts.*;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    public static final UrlParser urlParser = new AntlrUriParser();
    public static final TextPathParser pathParser = new TextPathParser();
    public static final TextPath emptyPath = TextPath.EMPTY;
    public static final QueryParser queryParser = new NullableValueQueryParser();
    public static final Params emptyParams = ImmutableOrderedParams.EMPTY;
    public static final QueryFormatter queryFormatter = new PairQueryFormatter();

    private Urls() { }

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    public static Url parse(String url) throws UrlDecodeException {
        if (url == null) { throw new NullPointerException("url may not be null."); }

        return Urls.urlParser.parse(url);
    }

    /**
     * Create a URL piecewise with the bare minimum of components.
     */
    public static Url from(String scheme, Host host) {
        // NB: We're passing in scheme for the schemeRaw
        return new ImmutableUrl(scheme, null, host, null, "", null, null);
    }

    /**
     * Format a {@link Url} to a string.
     */
    public static String format(Url url) {
        StringBuilder build = new StringBuilder();
        build.append(url.getSchemeRaw()).append("://");
        if (url.getUserInfoRaw() != null) {
            build.append(url.getUserInfoRaw()).append("@");
        }
        build.append(url.getHostRaw());
        String portRaw = url.getPortRaw();
        if (portRaw != null && !portRaw.isEmpty()) {
            build.append(":").append(portRaw);
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

    /**
     * Parse a path to the default piecewise URI query representation
     * using the default parser.
     * @param pathRaw Non-null path component
     */
    public static TextPath parsePath(String pathRaw) throws UrlDecodeException {
        return TextPath.EMPTY.addSegments(Urls.pathParser.parse(pathRaw));
    }

    /**
     * Parse a query string to the default piecewise URI query representation
     * using the default parser.
     * @param queryRaw Query component, or null
     * @return Params, or null if input was null
     */
    public static Params parseQuery(String queryRaw) throws UrlDecodeException {
        if (queryRaw == null) {
            return null;
        }
        return ImmutableOrderedParams.EMPTY.appendAll(Urls.queryParser.parse(queryRaw));
    }
}
