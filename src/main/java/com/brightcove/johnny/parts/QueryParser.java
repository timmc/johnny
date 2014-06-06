package com.brightcove.johnny.parts;

import java.util.Map;

import com.brightcove.johnny.http.Url;

/**
 * A parser for query components that are composed of keys and optional
 * values. Implementations may handle repeated keys and null values as
 * they wish.
 */
public interface QueryParser {
    /**
     * Parse a query to an intermediate form.
     * @param queryRaw Undecoded query as retrieved from
     *   {@link Url#getQueryRaw()}, not null.
     * @return Sequence of keys and values, where values may be null.
     */
    public Iterable<Map.Entry<String, String>> parse(String queryRaw);
}
