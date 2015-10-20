package org.timmc.johnny;

import org.timmc.johnny.parts.HostFormatter;
import org.timmc.johnny.parts.HostParser;
import org.timmc.johnny.parts.TextPathFormatter;
import org.timmc.johnny.parts.Params;
import org.timmc.johnny.parts.TextPath;
import org.timmc.johnny.parts.TextPathParser;
import org.timmc.johnny.parts.QueryFormatter;
import org.timmc.johnny.parts.QueryParser;
import org.timmc.johnny.parts.UserInfoFormatter;
import org.timmc.johnny.parts.UserInfoParser;

/**
 * An immutable collection of parsers, representations, formatters, and defaults.
 * Use the with* methods (e.g. {@link #withUrlParser(UrlParser)}) to derive
 * variations without affecting the original suite.
 *
 * @see Urls#DEFAULT_CODECS
 */
public class CodecSuite {
    /**
     * Create a new suite by specifying all fields. It may be more convenient
     * to instead start with {@link Urls#DEFAULT_CODECS} and use with* methods
     * to derive a variation of it.
     */
    public CodecSuite(
            UrlParser urlParser,
            Class<? extends Url> urlRepresentation,
            UrlFormatter urlFormatter,
            UserInfoParser userInfoParser,
            UserInfoFormatter userInfoFormatter,
            HostParser hostParser,
            HostFormatter hostFormatter,
            TextPathParser pathParser,
            TextPath emptyPath,
            TextPathFormatter pathFormatter,
            QueryParser queryParser,
            Params emptyParams,
            QueryFormatter queryFormatter) {
        super();
        this.urlParser = urlParser;
        this.urlRepresentation = urlRepresentation;
        this.urlFormatter = urlFormatter;
        this.userInfoParser = userInfoParser;
        this.userInfoFormatter = userInfoFormatter;
        this.hostParser = hostParser;
        this.hostFormatter = hostFormatter;
        this.pathParser = pathParser;
        this.emptyPath = emptyPath;
        this.pathFormatter = pathFormatter;
        this.queryParser = queryParser;
        this.emptyParams = emptyParams;
        this.queryFormatter = queryFormatter;
    }

    /** Set the default URL parser. */
    public final UrlParser urlParser;
    /** Set the default URL representation class. */
    public final Class<? extends Url> urlRepresentation;
    /** Set the default URL formatter. */
    public final UrlFormatter urlFormatter;
    /** Set the default userinfo parser. */
    public final UserInfoParser userInfoParser;
    /** Set the default userinfo formatter. */
    public final UserInfoFormatter userInfoFormatter;
    /** Set the default host parser. */
    public final HostParser hostParser;
    /** Set the default host formatter. */
    public final HostFormatter hostFormatter;
    /** Set the default path parser. */
    public final TextPathParser pathParser;
    /** Set the default empty path value. */
    public final TextPath emptyPath; // TODO refactor this?
    /** Set the default path formatter. */
    public final TextPathFormatter pathFormatter;
    /** Set the default quey parser. */
    public final QueryParser queryParser;
    /** Set the default empty params value. */
    public final Params emptyParams;
    /** Set the default query formatter. */
    public final QueryFormatter queryFormatter;

    /** Return a new suite with the specified URL parser. */
    public CodecSuite withUrlParser(UrlParser urlParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified URL representation class. */
    public CodecSuite withUrlRepresentation(Class<? extends Url> urlRepresentation) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified URL formatter. */
    public CodecSuite withUrlFormatter(UrlFormatter urlFormatter) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified userinfo parser. */
    public CodecSuite withUserInfoParser(UserInfoParser userInfoParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified userinfo formatter. */
    public CodecSuite withUserInfoFormatter(UserInfoFormatter userInfoFormatter) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified host parser. */
    public CodecSuite withHostParser(HostParser hostParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified host formatter. */
    public CodecSuite withHostFormatter(HostFormatter hostFormatter) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified path parser. */
    public CodecSuite withPathParser(TextPathParser pathParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified empty path value. */
    public CodecSuite withEmptyPath(TextPath emptyPath) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified path formatter. */
    public CodecSuite withPathFormatter(TextPathFormatter pathFormatter) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified query parser. */
    public CodecSuite withQueryParser(QueryParser queryParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified empty params value. */
    public CodecSuite withEmptyParams(Params emptyParams) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }

    /** Return a new suite with the specified query formatter. */
    public CodecSuite withQueryFormatter(QueryFormatter queryFormatter) {
        return new CodecSuite(urlParser, urlRepresentation, urlFormatter, userInfoParser, userInfoFormatter, hostParser, hostFormatter, pathParser, emptyPath, pathFormatter, queryParser, emptyParams, queryFormatter);
    }
}
