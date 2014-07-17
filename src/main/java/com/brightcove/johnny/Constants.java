package com.brightcove.johnny;

import java.nio.charset.Charset;

/**
 * Constants used throughout Johnny.
 */
public class Constants {
    /** UTF-8 character encoding. */
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /** The set of lower ASCII characters. */
    public static final ImmutableBitSet ASCII = ImmutableBitSet.EMPTY.set(0x00, 0x80);
    /** The set of C0 control characters (\x00 to \x31, inclusive). This does not include DEL. */
    public static final ImmutableBitSet ASCII_C0 = ImmutableBitSet.EMPTY.set(0x00, 0x20);
    /** The set of ASCII control characters (C0 and DEL.) */
    public static final ImmutableBitSet ASCII_CONTROL = ASCII_C0.set(0x7f);
    /** The set of printable ASCII characters. */
    public static final ImmutableBitSet ASCII_PRINTABLE = ImmutableBitSet.EMPTY.set(0x20, 0x7f);

    /** Set of lowercase alphabetic characters in ASCII. */
    public static final ImmutableBitSet ASCII_ALPHA_LOWER = ImmutableBitSet.EMPTY.set('a', 'z' + 1);
    /** Set of uppercase alphabetic characters in ASCII. */
    public static final ImmutableBitSet ASCII_ALPHA_UPPER = ImmutableBitSet.EMPTY.set('A', 'Z' + 1);
    /** Set of alphabetic characters in ASCII. */
    public static final ImmutableBitSet ASCII_ALPHA = ASCII_ALPHA_LOWER.or(ASCII_ALPHA_UPPER);
    /** Set of numeric characters in ASCII. */
    public static final ImmutableBitSet ASCII_NUMERIC = ImmutableBitSet.EMPTY.set('0', '9' + 1);
    /** Set of alphabetic and numeric characters in ASCII. */
    public static final ImmutableBitSet ASCII_ALPHANUMERIC = ASCII_ALPHA.or(ASCII_NUMERIC);

    /** Generic component delimiters in RFC 3986 URIs. */
    public static final ImmutableBitSet RFC3986_GEN_DELIMS = BitSetUtils.fromChars(":/?#[]@");
    /** Subcomponent delimiters in RFC 3986 URIs. */
    public static final ImmutableBitSet RFC3986_SUB_DELIMS = BitSetUtils.fromChars("!$&'()*+,;=");
    /** Reserved characters in RFC 3986 URIs. */
    public static final ImmutableBitSet RFC3986_RESERVED = RFC3986_GEN_DELIMS.or(RFC3986_SUB_DELIMS);
    /** Unreserved characters in RFC 3986 URIs. */
    public static final ImmutableBitSet RFC3986_UNRESERVED = ASCII_ALPHANUMERIC.or(BitSetUtils.fromChars("-._~"));
    /**
     * Characters allowed to be left unencoded in an RFC 3986 userinfo
     * subcomponent. Includes ':', although that must be encoded in the
     * username subcomponent to avoid ambiguity.
     */
    public static final ImmutableBitSet RFC3986_UNENCODED_USERINFO = RFC3986_UNRESERVED.or(RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars(":"));

}
