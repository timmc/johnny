package org.timmc.johnny.internal;

import java.util.Map;

import org.timmc.johnny.Url;
import org.timmc.johnny.UrlDecodeException;

/**
 * A parser for query components that are composed of keys and optional
 * values. Implementations may handle repeated keys and null values as
 * they wish.
 * <p>
 * <strong>Warning:</strong>: Do not use this for parsing POST bodies of
 * HTTP requests! <code>application/x-www-form-urlencoded</code> uses a
 * slightly different encoding, specifically around the "+" character.
 */
public interface QueryParser {
    /**
     * Parse a query to an intermediate form.
     * @param queryRaw Undecoded query as retrieved from
     *   {@link Url#getQueryRaw()}, not null.
     * @return Sequence of keys and values, where values may be null.
     */
    public Iterable<Map.Entry<String, String>> parse(String queryRaw) throws UrlDecodeException;
}
