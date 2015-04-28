package org.timmc.johnny;

import java.nio.charset.Charset;

/**
 * Percent-encodes a string a character at a time, referring to a
 * {@link CharOracle} to determine which to allow through unencoded.
 */
public class ByCharPercentEncoder implements StringEncoder {
    private final CharOracle passthrough;
    private final Charset encoding;

    /**
     * Construct and encoder with the specified passthrough oracle and UTF-8 encoding.
     */
    public ByCharPercentEncoder(CharOracle passthrough) {
        this(passthrough, Constants.UTF_8);
    }

    /**
     * Construct an encoder with the specified passthrough oracle and output encoding.
     *
     * @param passthrough Set of characters to pass through unencoded. Non-null.
     * @param encoding Output encoding. Warning: Use of UTF-16 may result
     *  in spurious Byte Order Marks. For now, that charset is permitted
     *  but not supported. (TODO) Non-null.
     */
    public ByCharPercentEncoder(CharOracle passthrough, Charset encoding) {
        if (passthrough == null) { throw new NullPointerException("Passthrough must not be null."); }
        if (encoding == null) { throw new NullPointerException("Character encoding must not be null."); }
        this.passthrough = passthrough;
        this.encoding = encoding;
    }

    /*== Accessors ==*/

    /** Return set of characters to pass through unencoded. */
    public CharOracle getPassthrough() {
        return passthrough;
    }

    /** Return character encoding used for hex output of characters. */
    public Charset getEncoding() {
        return encoding;
    }

    /*== Implementation ==*/

    public String encode(String in) {
        StringBuilder ret = new StringBuilder();
        int len = in.length();
        for (int offset = 0; offset < len; ) {
            int cp = in.codePointAt(offset);
            int charLen = Character.charCount(cp);
            if (passthrough.containsCodePoint(cp)) {
                ret.appendCodePoint(cp);
            } else {
                String sub = in.substring(offset, offset + charLen);
                byte[] raw = sub.getBytes(encoding); // TODO: Support throwing instead of using replacement characters?
                for (byte b : raw) {
                    ret.append('%').append(String.format("%02X", b));
                }
            }
            offset += charLen;
        }
        return ret.toString();
    }
}
