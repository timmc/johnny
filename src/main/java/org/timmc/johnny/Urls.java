package org.timmc.johnny;

import java.net.MalformedURLException;

import org.timmc.johnny.parts.PairQueryFormatter;
import org.timmc.johnny.parts.HostFormatter;
import org.timmc.johnny.parts.ImmutableOrderedParams;
import org.timmc.johnny.parts.TextPathFormatter;
import org.timmc.johnny.parts.PluggableUserInfoFormatter;
import org.timmc.johnny.parts.StrictHostParser;
import org.timmc.johnny.parts.NullIsEmptyQueryParser;
import org.timmc.johnny.parts.Params;
import org.timmc.johnny.parts.StdUserInfoParser;
import org.timmc.johnny.parts.TextPath;
import org.timmc.johnny.parts.TextPathParser;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    /** Default suite of parsers, representations, and encoders. */
    public static final CodecSuite DEFAULT_CODECS = new CodecSuite(
            new JNUriParser(),
            ImmutableUrl.class,
            new UrlFormatter(),
            new StdUserInfoParser(),
            PluggableUserInfoFormatter.INSTANCE,
            new StrictHostParser(),
            new HostFormatter(),
            TextPathParser.INSTANCE,
            TextPath.EMPTY,
            TextPathFormatter.INSTANCE,
            new NullIsEmptyQueryParser(),
            ImmutableOrderedParams.EMPTY,
            new PairQueryFormatter());

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
