package com.brightcove.johnny.http;

import java.net.MalformedURLException;

import com.brightcove.johnny.parts.BasicQueryEncoder;
import com.brightcove.johnny.parts.HostEncoder;
import com.brightcove.johnny.parts.HostParser;
import com.brightcove.johnny.parts.Path;
import com.brightcove.johnny.parts.PathEncoder;
import com.brightcove.johnny.parts.PathParser;
import com.brightcove.johnny.parts.StdPathParser;
import com.brightcove.johnny.parts.StdPath;
import com.brightcove.johnny.parts.StrictHostParser;
import com.brightcove.johnny.parts.NullIsEmptyQueryParser;
import com.brightcove.johnny.parts.PersistentOrderedParams;
import com.brightcove.johnny.parts.Params;
import com.brightcove.johnny.parts.QueryEncoder;
import com.brightcove.johnny.parts.QueryParser;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    public static final UrlParser DEFAULT_URL_PARSER = new JNUriParser();
    public static final UrlEncoder DEFAULT_URL_ENCODER = new UrlEncoder();
    public static final HostParser DEFAULT_HOST_PARSER = new StrictHostParser();
    public static final HostEncoder DEFAULT_HOST_ENCODER = new HostEncoder();
    public static final PathParser DEFAULT_PATH_PARSER = new StdPathParser();
    public static final Path DEFAULT_EMPTY_PATH = StdPath.EMPTY;
    public static final PathEncoder DEFAULT_PATH_ENCODER = new PathEncoder();
    public static final QueryParser DEFAULT_QUERY_PARSER = new NullIsEmptyQueryParser();
    public static final Params DEFAULT_EMPTY_PARAMS = PersistentOrderedParams.EMPTY;
    public static final QueryEncoder DEFAULT_QUERY_ENCODER = new BasicQueryEncoder();

    private Urls() { }

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    public static Url parse(String url) throws MalformedURLException {
        return ImmutableUrl.from(url, DEFAULT_URL_PARSER);
    }

    /**
     * Parse a path to the default piecewise URI query representation
     * using the default parser.
     * @param pathRaw Non-null path component
     */
    public static Path parsePath(String pathRaw) {
        return DEFAULT_EMPTY_PATH.addSegments(DEFAULT_PATH_PARSER.parse(pathRaw));
    }

    /**
     * Parse a query string to the default piecewise URI query representation
     * using the default parser.
     */
    public static Params parseQuery(String queryRaw) {
        if (queryRaw == null) {
            return null;
        }
        return new PersistentOrderedParams().appendAll(DEFAULT_QUERY_PARSER.parse(queryRaw));
    }
}
