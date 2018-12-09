package org.timmc.johnny.internal

import kotlin.collections.Map.Entry

import org.timmc.johnny.*

/**
 * Query formatter whcih encodes queries in the standard fashion, defaulting
 * to ampersand and equals as delimiters and allowing null values.
 */
class PairQueryFormatter @JvmOverloads constructor(
    /** Key-value pair separator, defaulting to ampersand.  */
    private val pairSep: String = "&"
) {
    private val kSep = '='

    private val keyEnc: StringEncoder
    private val valEnc: StringEncoder

    init {
        keyEnc =
            ByCharPercentEncoder(Ascii7Oracle(Constants.RFC3986_UNENCODED_QUERY.or(BitSetUtils.fromChars(pairSep + kSep))))
        valEnc =
            ByCharPercentEncoder(Ascii7Oracle(Constants.RFC3986_UNENCODED_QUERY.or(BitSetUtils.fromChars(pairSep))))
    }

    /**
     * Format a query as a raw query string.
     * @param q Query object (nullable)
     * @return String (possibly null) suitable for
     * [Url.withQueryRaw]
     */
    fun format(q: Params?): String? {
        return if (q == null) null else format(q.getPairs())
    }

    /**
     * Format query pairs to a raw query string.
     * @param pairs Key-value pairs (possibly with null values)
     * @return String suitable for [Url.withQueryRaw]
     */
    fun format(pairs: Iterable<Entry<String, String?>>): String {
        val ret = StringBuilder()
        var writtenFirst = false
        for (e in pairs) {
            if (writtenFirst) {
                ret.append(pairSep)
            } else {
                writtenFirst = true
            }
            ret.append(keyEnc.encode(e.key))
            e.value?.let {
                ret.append(kSep).append(valEnc.encode(it))
            }
        }
        return ret.toString()
    }
}
