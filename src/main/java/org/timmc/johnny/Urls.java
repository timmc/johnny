package org.timmc.johnny;

import org.timmc.johnny.parts.*;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    public static final UrlParser urlParser = new AntlrUriParser();
    public static final UrlFormatter urlFormatter = new UrlFormatter();
    public static final UserInfoParser userInfoParser = new StdUserInfoParser();
    public static final UserInfoFormatter userInfoFormatter = new PluggableUserInfoFormatter();
    public static final TextPathParser pathParser = new TextPathParser();
    public static final TextPath emptyPath = TextPath.EMPTY;
    public static final TextPathFormatter pathFormatter = new TextPathFormatter();
    public static final QueryParser queryParser = new NullableValueQueryParser();
    public static final Params emptyParams = ImmutableOrderedParams.EMPTY;
    public static final QueryFormatter queryFormatter = new PairQueryFormatter();

    private Urls() { }

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    public static Url parse(String url) throws UrlDecodeException {
        if (url == null) { throw new NullPointerException("uri may not be null."); }

        return ImmutableUrl.from(url, Urls.urlParser);
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
