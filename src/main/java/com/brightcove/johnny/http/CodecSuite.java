package com.brightcove.johnny.http;

import com.brightcove.johnny.parts.HostEncoder;
import com.brightcove.johnny.parts.HostParser;
import com.brightcove.johnny.parts.PathEncoder;
import com.brightcove.johnny.parts.Params;
import com.brightcove.johnny.parts.Path;
import com.brightcove.johnny.parts.PathParser;
import com.brightcove.johnny.parts.QueryEncoder;
import com.brightcove.johnny.parts.QueryParser;
import com.brightcove.johnny.parts.UserInfoEncoder;
import com.brightcove.johnny.parts.UserInfoParser;

/**
 * An immutable collection of parsers, representations, encoders, and defaults.
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
            UrlEncoder urlEncoder,
            UserInfoParser userInfoParser,
            UserInfoEncoder userInfoEncoder,
            HostParser hostParser,
            HostEncoder hostEncoder,
            PathParser pathParser,
            Path emptyPath,
            PathEncoder pathEncoder,
            QueryParser queryParser,
            Params emptyParams,
            QueryEncoder queryEncoder) {
        super();
        this.urlParser = urlParser;
        this.urlRepresentation = urlRepresentation;
        this.urlEncoder = urlEncoder;
        this.userInfoParser = userInfoParser;
        this.userInfoEncoder = userInfoEncoder;
        this.hostParser = hostParser;
        this.hostEncoder = hostEncoder;
        this.pathParser = pathParser;
        this.emptyPath = emptyPath;
        this.pathEncoder = pathEncoder;
        this.queryParser = queryParser;
        this.emptyParams = emptyParams;
        this.queryEncoder = queryEncoder;
    }

    /** Set the default URL parser. */
    public final UrlParser urlParser;
    /** Set the default URL representation class. */
    public final Class<? extends Url> urlRepresentation;
    /** Set the default URL encoder. */
    public final UrlEncoder urlEncoder;
    /** Set the default userinfo parser. */
    public final UserInfoParser userInfoParser;
    /** Set the default userinfo encoder. */
    public final UserInfoEncoder userInfoEncoder;
    /** Set the default host parser. */
    public final HostParser hostParser;
    /** Set the default host encoder. */
    public final HostEncoder hostEncoder;
    /** Set the default path parser. */
    public final PathParser pathParser;
    /** Set the default empty path value. */
    public final Path emptyPath; // TODO refactor this?
    /** Set the default path encoder. */
    public final PathEncoder pathEncoder;
    /** Set the default quey parser. */
    public final QueryParser queryParser;
    /** Set the default empty params value. */
    public final Params emptyParams;
    /** Set the default query encoder. */
    public final QueryEncoder queryEncoder;

    /** Return a new suite with the specified URL parser. */
    public CodecSuite withUrlParser(UrlParser urlParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified URL representation class. */
    public CodecSuite withUrlRepresentation(Class<? extends Url> urlRepresentation) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified URL encoder. */
    public CodecSuite withUrlEncoder(UrlEncoder urlEncoder) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified userinfo parser. */
    public CodecSuite withUserInfoParser(UserInfoParser userInfoParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified userinfo encoder. */
    public CodecSuite withUserInfoEncoder(UserInfoEncoder userInfoEncoder) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified host parser. */
    public CodecSuite withHostParser(HostParser hostParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified host encoder. */
    public CodecSuite withHostEncoder(HostEncoder hostEncoder) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified path parser. */
    public CodecSuite withPathParser(PathParser pathParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified empty path value. */
    public CodecSuite withEmptyPath(Path emptyPath) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified path encoder. */
    public CodecSuite withPathEncoder(PathEncoder pathEncoder) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified query parser. */
    public CodecSuite withQueryParser(QueryParser queryParser) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified empty params value. */
    public CodecSuite withEmptyParams(Params emptyParams) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }

    /** Return a new suite with the specified query encoder. */
    public CodecSuite withQueryEncoder(QueryEncoder queryEncoder) {
        return new CodecSuite(urlParser, urlRepresentation, urlEncoder, userInfoParser, userInfoEncoder, hostParser, hostEncoder, pathParser, emptyPath, pathEncoder, queryParser, emptyParams, queryEncoder);
    }
}
