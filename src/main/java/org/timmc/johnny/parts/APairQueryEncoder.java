package org.timmc.johnny.parts;

import java.util.Map;

import org.timmc.johnny.http.Url;

/**
 * Adds the assumption that a Query is made of key-value pairs.
 */
public abstract class APairQueryEncoder implements QueryEncoder {
    /**
     * Encode query pairs to a raw query string.
     * @param pairs Key-value pairs (possibly with null values)
     * @return String suitable for {@link Url#withQueryRaw(String)}
     */
    public abstract String unparse(Iterable<Map.Entry<String, String>> pairs);
}