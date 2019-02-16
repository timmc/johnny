package org.timmc.johnny;

/**
 * The host component of a URI using a future IP literal format. This is a
 * syntax reservation which, as of this writing, has no specification.
 *
 * <p>Note, in particular, that the "version" field of this format does
 * <em>not</em> refer to the IP version, but the format version.</p>
 */
data class IPvFutureHost(
    /**
     * The IP literal format version (not to be confused with Internet
     * Protocol address version!)
     */
    val formatVersion: Int,
    /**
     * Raw string of IP literal.
     * This has not been decoded or normalized in any way; it's up to you.
     */
    // TODO extract data portion as well
    override val raw: String
): Host() {
    override fun format(): String {
        return raw;
    }
}
