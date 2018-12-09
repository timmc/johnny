package org.timmc.johnny

/**
 * A key-value parameter listing. Implementations are free to make decisions
 * about repeated keys, ordering, and null values.
 * <p>
 * Mutator methods that return a {@link Params} expect that the returned
 * instance be used for further mutations; the original instance may not
 * reflect the mutation.
 * <p>
 * Implementations are expected to have a public nullary constructor which
 * can be used in conjunction with {@link #appendAll(Iterable)}.
 */
interface Params: Iterable<Map.Entry<String, String?>> {

    /*== Value accessors ==*/

    /**
     * Check if key is present.
     * @param key Key string, not null.
     * @return True iff key is present (has at least one value.)
     */
    fun hasKey(key: String): Boolean

    /**
     * Check if key-value pair is present.
     * @param key Key string, not null.
     * @param value Value string, nullable.
     * @return True iff key-value pair is present.
     */
    fun hasPair(key: String, value: String?): Boolean

    /**
     * Get the last value for the specified key.
     * @param key Key string, not null.
     * @return last value for key, null if missing or the value is null.
     * @see #hasKey(String)
     */
    fun getLast(key: String): String?

    /**
     * Get all values for the key.
     * @param key Key string, not null.
     * @return Collection of zero or more param values, some of which may be null.
     */
    fun getAll(key: String): List<String?>

    /**
     * Produce a key-value pair representation.
     * @return non-null collection of key-value pairs
     */
    fun getPairs(): List<Map.Entry<String, String?>>

    /*== Size ==*/

    /**
     * Count unique keys.
     */
    fun countKeys(): Int

    /**
     * Count key-value pairs.
     */
    fun countPairs(): Int

    /*== Mutation ==*/

    /**
     * Remove all key-value pairs.
     * @return An empty Params of the same type (or at least with the same
     *  behaviors).
     */
    fun empty(): Params

    /**
     * Remove all values for this key.
     * @param key Key string, not null.
     * @return Params on which {@link #hasKey(String)} will return false for
     *  <code>key</code>.
     */
    fun removeAll(key: String): Params

    /**
     * Remove all pairs matching this key and value.
     * @param key Key string, not null.
     * @param value Value string, nullable.
     * @return Params on which {@link #getAll(String)} with <code>key</code>
     *  will return a collection that does not contain <code>val</code>.
     */
    fun removeAll(key: String, value: String?): Params

    /**
     * Append an additional key-value pair.
     * @param key Key string, not null.
     * @param value Value string, nullable.
     * @return Params on which {@link #getLast(String)} with <code>key</code>
     *  will return <code>val</code> and on which {@link #getAll(String)}
     *  will be larger by 1.
     */
    fun append(key: String, value: String?): Params

    /**
     * Append a sequence of key-value pairs.
     * @param source Non-null iterable of key-value pairs
     */
    fun appendAll(source: Iterable<Map.Entry<String, String?>>): Params

    /**
     * Replace all <code>key</code> pairs with a single pair containing
     * <code>val</code> as the value.
     * @param key Key string, not null.
     * @param value New value string, nullable.
     * @return Params on which {@link #getAll(String)} with <code>key</code>
     *  will return a one-element collection containing <code>val</code>.
     */
    fun replace(key: String, value: String?): Params

    /**
     * Remove last value of key (if present) and add new value.
     * @param key Key string, not null.
     * @param value New value string, nullable.
     * @return Params on which {@link #getLast(String)} with <code>key</code>
     *  will return <code>val</code> and on which
     *  {@link #getAll(String)} will return a collection containing
     *  <code>val</code> (for all implementations.)
     */
    fun replaceLast(key: String, value: String?): Params
}
