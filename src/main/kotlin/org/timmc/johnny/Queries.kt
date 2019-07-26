package org.timmc.johnny

import java.util.ArrayList

import org.timmc.johnny.internal.ImmutableOrderedParams
import org.timmc.johnny.internal.NullableValueQueryParser
import org.timmc.johnny.internal.PairQueryFormatter
import org.timmc.johnny.internal.coll.MapEntry

/**
 * Convenience methods for working with [Params] for use in queries, fragments, or even paths.
 */
object Queries {

    private val queryParser = NullableValueQueryParser()
    private val emptyParams = ImmutableOrderedParams.EMPTY
    private val formatter = PairQueryFormatter()

    /**
     * Yield an empty param collection.
     */
    @JvmStatic
    fun empty(): Params {
        return emptyParams
    }

    /**
     * Parse a query string to the default piecewise URI query representation
     * using the default parser.
     * @param queryRaw Query component, not null
     * @return Params, possibly empty
     */
    @JvmStatic
    @Throws(UrlDecodeException::class)
    fun parse(queryRaw: String): Params {
        return emptyParams.appendAll(queryParser.parse(queryRaw))
    }

    /**
     * Create a param collection with a single key-value pair.
     *
     * @param key Non-null
     * @param value Nullable
     */
    @JvmStatic
    fun from(key: String, value: String?): Params {
        return emptyParams.append(key, value)
    }

    /**
     * Create a param collection of a key to a list of values, a.k.a. *n* key-value pairs all
     * with the same key.
     *
     * @param key Non-null
     * @param vals Non-null array of nullable strings, each to be associated with key
     * @return Param collection of as many entries as there were vals, each associating a val with
     * the key
     */
    @JvmStatic
    fun from(key: String?, vals: Iterable<String>): Params {
        if (key == null) {
            throw NullPointerException("Param key may not be null")
        }
        val pairs = ArrayList<MapEntry<String, String>>()
        for (`val` in vals) {
            pairs.add(MapEntry(key, `val`))
        }
        return emptyParams.appendAll(pairs)
    }

    /**
     * Create a param collection from a map of keys to single values.
     *
     * @param mapping Non-null.
     */
    @JvmStatic
    fun from(mapping: Map<String, String>): Params {
        return emptyParams.appendAll(mapping.entries)
    }

    /**
     * Format a param collection as a raw query.
     */
    @JvmStatic
    fun formatQuery(p: Params): String {
        return formatter.format(p)
    }
}
