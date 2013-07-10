package com.brightcove.johnny.parts;

import java.util.Collection;
import java.util.Map;

/**
 * A decoded query component.
 *
 * Mutator methods that return a {@link Query} expect that the returned
 * instance be used for fruther mutations; the original instance may not
 * reflect the mutation.
 *
 */
public interface Query {

    /*== Value accessors ==*/

    /**
     * Check if key is present in query.
     * @param key Key string, not null.
     * @return True iff key is present.
     */
    public boolean hasKey(String key);

    /**
     * Get the last value for the specified key.
     * @param key Key string, not null.
     * @return last value for key, null if missing or the value is null.
     * @see #hasKey(String)
     */
    public String getLast(String key);

    /**
     * Get all values for the key.
     * @param key Key string, not null.
     * @return Collection of zero or more query values, some of which may be null.
     */
    public Collection<String> getAll(String key);

    /**
     * Produce a key-value pair representation of this query.
     */
    public Collection<Map.Entry<String, String>> getPairs();

    /*== Size ==*/

    /**
     * Count unique keys in query.
     */
    public int countKeys();

    /**
     * Count key-value pairs in query.
     */
    public int countPairs();

    /*== Mutation ==*/

    /**
     * Remove all values for this key.
     * @param key Key string, not null.
     * @return Query on which {@link #hasKey(String)} will return false for
     *  <code>key</code>.
     */
    public Query removeAll(String key);

    /**
     * Remove all pairs matching this key and value.
     * @param key Key string, not null.
     * @param val Value string, nullable.
     * @return Query on which {@link #getAll(String)} with <code>key</code>
     *  will return a collection that does not contain <code>val</code>.
     */
    public Query removeAll(String key, String val);

    /**
     * Append an additional key-value pair.
     * @param key Key string, not null.
     * @param val Value string, nullable.
     * @return Query on which {@link #getLast(String)} with <code>key</code>
     *  will return <code>val</code> and on which {@link #getAll(String)}
     *  will be larger by 1.
     */
    public Query append(String key, String val);

    /**
     * Replace all <code>key</code> pairs with a single pair containing
     * <code>val</code> as the value.
     * @param key Key string, not null.
     * @param val New value string, nullable.
     * @return Query on which {@link #getAll(String)} with <code>key</code>
     *  will return a one-element collection containing <code>val</code>.
     */
    public Query replace(String key, String val);

    /**
     * Remove last value of key (if present) and add new value.
     * @param key Key string, not null.
     * @param val New value string, nullable.
     * @return Query on which {@link #getLast(String)} with <code>key</code>
     *  will return <code>val</code>.
     */
    public Query replaceLast(String key, String val);
}
