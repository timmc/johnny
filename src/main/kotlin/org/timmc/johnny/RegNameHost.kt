package org.timmc.johnny

import org.timmc.johnny.internal.Codecs

/**
 * A URI host that is a name, e.g. a domain name.
 */
data class RegNameHost(
    // TODO: Should we accept decoded name instead? When is that safe?
    override val raw: String
): Host() {

    // TODO: parseDomain that parses into a sequence of domain labels,
    // reified as a class. Should also expose local/absolute re: empty
    // final segment. Need to decide what to do about percent-encoded
    // octets; they're supposed to represent non-ASCII, but what if
    // there's an encoded period? Should we split on period first,
    // decode first, or just prohibit encoded periods? (RFC 3986 §3.2.2
    // doesn't give any instruction.)

    // TODO Under what circumstances is it possible for a *valid* regname to need decoding?
    /**
     * @throws UrlDecodeException
     */
    fun getName(): String {
        return Codecs.percentDecode(raw)
    }

    // TODO Should we return a potentially cleaner version that has been round-tripped through decode/encode?
    override fun format(): String {
        return raw
    }
}
