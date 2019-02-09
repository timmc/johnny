package org.timmc.johnny.internal;

import java.nio.charset.Charset;

/**
 * Percent-encodes a string a character at a time, referring to a
 * {@link CharOracle} to determine which to allow through unencoded.
 */
class ByCharPercentEncoder
@JvmOverloads constructor(
    /** Set of characters to pass through unencoded. */
    val passthrough: CharOracle,
    /**
     * Character encoding used for hex output of characters. Warning: Use
     * of UTF-16 may result in spurious Byte Order Marks. For now, that
     * charset is permitted but not supported.
     */
    val encoding: Charset = Charsets.UTF_8
): StringEncoder {

    override fun encode(input: String): String {
        val ret = StringBuilder()
        val len = input.length
        var offset = 0
        while (offset < len) {
            val cp = input.codePointAt(offset);
            val charLen = Character.charCount(cp);
            if (passthrough.containsCodePoint(cp)) {
                ret.appendCodePoint(cp);
            } else {
                val sub: String = input.substring(offset, offset + charLen);
                val raw = sub.toByteArray(encoding); // TODO: Support throwing instead of using replacement characters?
                for (b in raw) {
                    ret.append('%').append(String.format("%02X", b));
                }
            }
            offset += charLen;
        }
        return ret.toString();
    }
}
