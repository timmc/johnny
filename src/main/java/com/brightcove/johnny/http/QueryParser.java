package com.brightcove.johnny.http;

import java.util.Map;

/**
 * A parser for query components that are composed of keys and optional
 * values. Implementations may handle repeated keys and null values as
 * they wish.
 */
public interface QueryParser {
    /**
     * Parse a query to an intermediate form.
     * @param queryRaw Undecoded query as retrieved from
     *   {@link Url#getQueryRaw()}, possibly null.
     * @return Sequence of keys and values, where values may be null.
     */
    public Iterable<Map.Entry<String, String>> parseAs(String queryRaw);
}
