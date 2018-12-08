package org.timmc.johnny.internal

import java.util.regex.Pattern

import org.timmc.johnny.UrlDecodeException
import org.timmc.johnny.internal.coll.MapEntry

/**
 * A parser for query components that are composed of keys and optional
 * values. In `?a=5&a&b=7`, the second `a` is
 * an example of a missing value. This call uses a null value to represent them.
 *
 * **Warning:**: Do not use this for parsing POST bodies of
 * HTTP requests! `application/x-www-form-urlencoded` uses a
 * slightly different encoding, specifically around the "+" character.
 */
class NullableValueQueryParser
@JvmOverloads constructor(
    /**
     * Pattern on which to split keys from values. Canonically this is either
     * an ampersand or a semicolon; defaults to ampersand.
     */
    private val pairSep: Pattern = AMPERSAND
) {
    @Throws(UrlDecodeException::class)
    fun parse(queryRaw: String): Iterable<Map.Entry<String, String?>> {
        return pairSep.split(queryRaw).mapNotNull { pair ->
            if (pair.isEmpty()) {
                null
            } else {
                val kv = EQUALS.split(pair, 2)
                val k = Codecs.percentDecode(kv[0])
                val v = if (kv.size == 1) null else Codecs.percentDecode(kv[1])
                MapEntry(k, v)
            }
        }
    }

    companion object {
        @JvmStatic
        private val EQUALS = Pattern.compile("=")

        /** Pattern that finds ampersands.  */
        @JvmStatic
        private val AMPERSAND = Pattern.compile("&")
    }
}
