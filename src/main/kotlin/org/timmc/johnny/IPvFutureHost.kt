package org.timmc.johnny

/**
 * The host component of a URI using a future IP literal format. This is a
 * syntax reservation which, as of this writing, has no specification.
 *
 * IPvFuture addresses take the form of `vHEX.DATA` where `HEX` is a
 * hexadecimal format version field and `DATA` is a non-empty string to
 * be interpreted according to the format version.
 *
 * Note carefully that the "version" field of this format does *not* refer
 * to the IP version, but the format version. (If you see `v4.abcd`, that
 * would not be an IPv4 address, but rather something as of yet undefined.)
 */
data class IPvFutureHost(
    /**
     * The IP literal format version (not to be confused with Internet
     * Protocol address version!)
     */
    val formatVersion: Int,
    /**
     * The uninterpreted contents of the IP address, which excludes the
     * framing.
     */
    val data: String,
    /**
     * Raw string of IP literal.
     * This has not been decoded or normalized in any way; it's up to you.
     */
    override val raw: String
): Host() {
    override fun format(): String {
        return raw
    }
}
