package com.brightcove.johnny.http;

import java.net.MalformedURLException;

import com.brightcove.johnny.coll.ClojureHelper;
import com.brightcove.johnny.parts.BasicQueryEncoder;
import com.brightcove.johnny.parts.HostEncoder;
import com.brightcove.johnny.parts.TextPathEncoder;
import com.brightcove.johnny.parts.PluggableUserInfoEncoder;
import com.brightcove.johnny.parts.StrictHostParser;
import com.brightcove.johnny.parts.NullIsEmptyQueryParser;
import com.brightcove.johnny.parts.PersistentOrderedParams;
import com.brightcove.johnny.parts.Params;
import com.brightcove.johnny.parts.StdUserInfoParser;
import com.brightcove.johnny.parts.TextPath;
import com.brightcove.johnny.parts.TextPathParser;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    static {
        ClojureHelper.init(); // XXX but see init()'s docs
    }

    /** Default suite of parsers, representations, and encoders. */
    public static final CodecSuite DEFAULT_CODECS = new CodecSuite(
            new JNUriParser(),
            ImmutableUrl.class,
            new UrlEncoder(),
            new StdUserInfoParser(),
            PluggableUserInfoEncoder.INSTANCE,
            new StrictHostParser(),
            new HostEncoder(),
            TextPathParser.INSTANCE,
            TextPath.EMPTY,
            TextPathEncoder.INSTANCE,
            new NullIsEmptyQueryParser(),
            PersistentOrderedParams.EMPTY,
            new BasicQueryEncoder());

    private Urls() { }

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    public static Url parse(String url) throws MalformedURLException {
        return ImmutableUrl.from(url, DEFAULT_CODECS.urlParser);
    }

    /**
     * Parse a path to the default piecewise URI query representation
     * using the default parser.
     * @param pathRaw Non-null path component
     */
    public static TextPath parsePath(String pathRaw) {
        return DEFAULT_CODECS.emptyPath.addSegments(DEFAULT_CODECS.pathParser.parse(pathRaw));
    }

    /**
     * Parse a query string to the default piecewise URI query representation
     * using the default parser.
     * @param queryRaw Query component, or null
     * @return Params, or null if input was null
     */
    public static Params parseQuery(String queryRaw) {
        if (queryRaw == null) {
            return null;
        }
        return DEFAULT_CODECS.emptyParams.appendAll(DEFAULT_CODECS.queryParser.parse(queryRaw));
    }
}
