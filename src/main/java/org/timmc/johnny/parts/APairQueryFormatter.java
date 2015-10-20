package org.timmc.johnny.parts;

import java.util.Map.Entry;

import org.timmc.johnny.Url;

/**
 * Adds the assumption that a Query is made of key-value pairs.
 */
public abstract class APairQueryFormatter implements QueryFormatter {
    /**
     * Format query pairs to a raw query string.
     * @param pairs Key-value pairs (possibly with null values)
     * @return String suitable for {@link Url#withQueryRaw(String)}
     */
    public abstract String format(Iterable<Entry<String, String>> pairs);
}
