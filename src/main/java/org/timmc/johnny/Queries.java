package org.timmc.johnny;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.timmc.johnny.internal.ImmutableOrderedParams;
import org.timmc.johnny.internal.PairQueryFormatter;
import org.timmc.johnny.internal.coll.MapEntry;

/**
 * Convenience methods for working with {@link Params} for use in queries, fragments, or even paths.
 */
public class Queries {

    private static final Params emptyParams = ImmutableOrderedParams.EMPTY;
    private static final PairQueryFormatter formatter = new PairQueryFormatter();

    /**
     * Yield an empty param collection.
     */
    public static Params empty() {
        return emptyParams;
    }

    /**
     * Create a param collection with a single key-value pair.
     * 
     * @param key Non-null
     * @param val Nullable
     */
    public static Params from(String key, String val) {
        if (key == null) {
            throw new NullPointerException("Param key may not be null");
        }
        return emptyParams.append(key, val);
    }

    /**
     * Create a param collection of a key to a list of values, a.k.a. <em>n</em> key-value pairs all
     * with the same key.
     * 
     * @param key Non-null
     * @param vals Non-null array of nullable strings, each to be associated with key
     * @return Param collection of as many entries as there were vals, each associating a val with
     *         the key
     */
    public static Params from(String key, Iterable<String> vals) {
        if (key == null) {
            throw new NullPointerException("Param key may not be null");
        }
        List<MapEntry<String, String>> pairs = new ArrayList<>();
        for (String val : vals) {
            pairs.add(new MapEntry<>(key, val));
        }
        return emptyParams.appendAll(pairs);
    }

    /**
     * Create a param collection from a map of keys to single values.
     * 
     * @param mapping Non-null.
     */
    public static Params from(Map<String, String> mapping) {
        return emptyParams.appendAll(mapping.entrySet());
    }

    /**
     * Format a param collection as a raw query.
     */
    public static String formatQuery(Params p) {
        return formatter.format(p);
    }
}
