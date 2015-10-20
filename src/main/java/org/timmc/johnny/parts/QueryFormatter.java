package org.timmc.johnny.parts;

import org.timmc.johnny.Url;

/**
 * Query formatter. Implementations are free to choose character sets,
 * reserved characters, and delimiters.
 */
public interface QueryFormatter {
    /**
     * Format a query as a raw query string.
     * @param q Query object (nullable)
     * @return String (possibly null) suitable for
     *  {@link Url#withQueryRaw(String)}
     */
    public String format(Params q);
}
