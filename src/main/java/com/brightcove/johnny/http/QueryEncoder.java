package com.brightcove.johnny.http;

import com.brightcove.johnny.parts.Query;

/**
 * Query encoder. Implementations are free to choose character sets,
 * reserved characters, and delimiters.
 */
public interface QueryEncoder {
    /**
     * Encode a query to a raw query string.
     * @param q Query object
     * @return String suitable for {@link Url#withQueryRaw(String)}
     */
    public String unparse(Query q);
}
