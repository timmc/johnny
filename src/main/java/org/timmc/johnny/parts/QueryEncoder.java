package org.timmc.johnny.parts;

import org.timmc.johnny.Url;

/**
 * Query encoder. Implementations are free to choose character sets,
 * reserved characters, and delimiters.
 */
public interface QueryEncoder {
    /**
     * Encode a query to a raw query string.
     * @param q Query object (nullable)
     * @return String (possibly null) suitable for
     *  {@link Url#withQueryRaw(String)}
     */
    public String unparse(Params q);
}
