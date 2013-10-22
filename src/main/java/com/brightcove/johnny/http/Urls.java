package com.brightcove.johnny.http;

import java.net.MalformedURLException;

import com.brightcove.johnny.parts.BasicQueryEncoder;
import com.brightcove.johnny.parts.HostParser;
import com.brightcove.johnny.parts.StdHostParser;
import com.brightcove.johnny.parts.NullIsEmptyQueryParser;
import com.brightcove.johnny.parts.PersistentOrderedQuery;
import com.brightcove.johnny.parts.Query;
import com.brightcove.johnny.parts.QueryEncoder;
import com.brightcove.johnny.parts.QueryParser;


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 * Start by calling {@link #parse(String)}, then use builder methods on the return value.
 */
public class Urls {

    public static final UrlParser STANDARD_URL_PARSER = new JNUriParser();
    public static final UrlEncoder STANDARD_URL_ENCODER = new UrlEncoder();
    public static final HostParser STANDARD_HOST_PARSER = new StdHostParser();
    public static final QueryParser STANDARD_QUERY_PARSER = new NullIsEmptyQueryParser();
    public static final QueryEncoder STANDARD_QUERY_ENCODER = new BasicQueryEncoder();

    private Urls() { }

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    public static Url parse(String url) throws MalformedURLException {
        return ImmutableUrl.from(url, STANDARD_URL_PARSER);
    }

    /**
     * Parse a query string to the default piecewise URI query representation
     * using the default parser.
     */
    public static Query parseQuery(String queryRaw) {
        if (queryRaw == null) {
            return null;
        }
        return new PersistentOrderedQuery().appendAll(STANDARD_QUERY_PARSER.parse(queryRaw));
    }
}
