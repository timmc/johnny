package org.timmc.johnny.internal

/**
 * Constants used throughout Johnny.
 */
object Constants {
    /** The set of lower ASCII characters.  */
    @JvmField
    val ASCII = ImmutableBitSet.EMPTY.set(0x00, 0x80)
    /** The set of C0 control characters (\x00 to \x31, inclusive). This does not include DEL.  */
    @JvmField
    val ASCII_C0 = ImmutableBitSet.EMPTY.set(0x00, 0x20)
    /** The set of ASCII control characters (C0 and DEL.)  */
    @JvmField
    val ASCII_CONTROL = ASCII_C0.set(0x7f)
    /** The set of printable ASCII characters.  */
    @JvmField
    val ASCII_PRINTABLE = ImmutableBitSet.EMPTY.set(0x20, 0x7f)

    /** Set of lowercase alphabetic characters in ASCII.  */
    @JvmField
    val ASCII_ALPHA_LOWER = ImmutableBitSet.EMPTY.set('a'.toInt(), 'z'.toInt() + 1)
    /** Set of uppercase alphabetic characters in ASCII.  */
    @JvmField
    val ASCII_ALPHA_UPPER = ImmutableBitSet.EMPTY.set('A'.toInt(), 'Z'.toInt() + 1)
    /** Set of alphabetic characters in ASCII.  */
    @JvmField
    val ASCII_ALPHA = ASCII_ALPHA_LOWER.or(ASCII_ALPHA_UPPER)
    /** Set of numeric characters in ASCII.  */
    @JvmField
    val ASCII_NUMERIC = ImmutableBitSet.EMPTY.set('0'.toInt(), '9'.toInt() + 1)
    /** Set of alphabetic and numeric characters in ASCII.  */
    @JvmField
    val ASCII_ALPHANUMERIC = ASCII_ALPHA.or(ASCII_NUMERIC)
    @JvmField
    val ASCII_HEXDIG = BitSetUtils.fromChars("abcdefABCDEF").or(ASCII_NUMERIC)

    /** Generic component delimiters in RFC 3986 URIs.  */
    @JvmField
    val RFC3986_GEN_DELIMS = BitSetUtils.fromChars(":/?#[]@")
    /** Subcomponent delimiters in RFC 3986 URIs.  */
    @JvmField
    val RFC3986_SUB_DELIMS = BitSetUtils.fromChars("!$&'()*+,;=")
    /** Reserved characters in RFC 3986 URIs.  */
    @JvmField
    val RFC3986_RESERVED = RFC3986_GEN_DELIMS.or(RFC3986_SUB_DELIMS)
    /** Unreserved characters in RFC 3986 URIs.  */
    @JvmField
    val RFC3986_UNRESERVED = ASCII_ALPHANUMERIC.or(BitSetUtils.fromChars("-._~"))
    /** Characters allowed in an RFC 3986 scheme component.  */
    @JvmField
    val RFC3986_SCHEME_ALLOWED = ASCII_ALPHANUMERIC.or(BitSetUtils.fromChars("+-."))
    /** Characters involved in percent-encoding.  */
    @JvmField
    val RFC3986_PERCENT_ENCODED = ASCII_HEXDIG.or(BitSetUtils.fromChars("%"))
    /**
     * Characters allowed to be left unencoded in an RFC 3986 userinfo
     * subcomponent. Includes ':', although that must be encoded in the
     * username subcomponent to avoid ambiguity.
     */
    @JvmField
    val RFC3986_UNENCODED_USERINFO = RFC3986_UNRESERVED.or(RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars(":"))
    // TODO Review the below docstring, does that description make sense?
    /**
     * Characters allowed to be left unencoded in an RFC 6874 IPv6 zone identifier.
     */
    @JvmField
    val RFC6874_UNENCODED_ZONE = RFC3986_UNRESERVED.or(RFC3986_PERCENT_ENCODED)
    /**
     * Characters allowed to be left unencoded in an RFC 3986 path segment.
     */
    @JvmField
    val RFC3986_UNENCODED_PATH_SEGMENT = RFC3986_UNRESERVED.or(RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars(":@"))
    /**
     * Characters allowed to be left unencoded in an RFC 3986 query.
     */
    @JvmField
    val RFC3986_UNENCODED_QUERY = RFC3986_UNRESERVED.or(RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars("/?"))
    /**
     * Characters allowed to be left unencoded in an RFC 3986 fragment.
     */
    @JvmField
    val RFC3986_UNENCODED_FRAGMENT = RFC3986_UNRESERVED.or(RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars("/?"))
}
