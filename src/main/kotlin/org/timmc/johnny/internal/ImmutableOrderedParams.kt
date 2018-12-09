package org.timmc.johnny.internal

import org.timmc.johnny.Params
import org.timmc.johnny.internal.coll.MapEntry

/**
 * An immutable params representation that maintains the original order
 * of key-value pairs, appends to the end, and can replace existing
 * pairs in-place. Accepts null values. Finding the last value for a key
 * takes linear time in the # of values for the key.
 */
data class ImmutableOrderedParams(
    private val entries: List<Pair<String, String?>>

// TODO: Consider a more optimized version with the following fields (see
// earlier implementation for code that can be converted over):

//    /**
//     * Ordered list of key-value entries, with nulls indicating
//     * deleted entries. NB: Null param values are not the same as null entries
//     * in this collection.
//     */
//    private val entries: List<Pair<String, String?>?>,
//
//    /**
//     * Number of nil entries in {@link #entries}.
//     */
//    private val deleted: Int,
//
//    /**
//     * Map of string keys to non-empty set
//     * of {@link #entries} indices ({@link Integer}) where values lie.
//     */
//    private val keylocs: Map<String, NavigableSet<Int>>

): Params {

    /** Create a new, empty params (prefer to use {@link #empty()}.) */
    private constructor(): this(emptyList())

    /*== Interface implementation ==*/

    override fun hasKey(key: String): Boolean {
        return entries.find { it.first == key } != null
    }

    override fun hasPair(key: String, value: String?): Boolean {
        return entries.contains(key to value)
    }

    override fun getLast(key: String): String? {
        return entries.reversed().find { it.first == key }?.second
    }

    override fun getAll(key: String): List<String?> {
        return entries.filter { it.first == key }.map { it.second }
    }

    override fun getPairs(): List<Map.Entry<String, String?>> {
        return entries.map { MapEntry(it.first, it.second) }
    }

    override fun countKeys(): Int {
        return entries.map { it.first }.distinct().size
    }

    override fun countPairs(): Int {
        return entries.size
    }

    override fun empty(): ImmutableOrderedParams {
        return EMPTY
    }

    override fun removeAll(key: String): ImmutableOrderedParams {
        return ImmutableOrderedParams(entries.filter { it.first != key })
    }

    override fun removeAll(key: String, value: String?): ImmutableOrderedParams {
        return ImmutableOrderedParams(entries.filter {
            !(it.first == key && it.second == value)
        })
    }

    override fun append(key: String, value: String?): ImmutableOrderedParams {
        return ImmutableOrderedParams(entries + listOf(key to value))
    }

    override fun appendAll(source: Iterable<Map.Entry<String, String?>>)
        : ImmutableOrderedParams
    {
        val extra = source.map { it.key to it.value }
        return ImmutableOrderedParams(entries + extra)
    }

    override fun replace(key: String, value: String?): ImmutableOrderedParams {
        return removeAll(key).append(key, value)
    }

    override fun replaceLast(key: String, value: String?): ImmutableOrderedParams {
        var hasFound = false
        val withReplaced = entries.reversed().map {
            if (!hasFound && it.first == key) {
                hasFound = true
                key to value
            } else {
                it
            }
        }.reversed()
        return if (hasFound)
            ImmutableOrderedParams(withReplaced)
        else
            ImmutableOrderedParams(withReplaced + listOf(key to value))
    }

    override fun iterator(): Iterator<Map.Entry<String, String?>> {
        return getPairs().iterator()
    }

    companion object {
        /**
         * A blank instance.
         */
        @JvmField
        val EMPTY: ImmutableOrderedParams = ImmutableOrderedParams()
    }
}
