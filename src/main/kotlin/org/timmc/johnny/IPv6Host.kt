package org.timmc.johnny

import org.timmc.johnny.internal.Codecs

/**
 * IPv6 host component of a URI, represented as IPv6 address and optional
 * zone identifier.
 */
data class IPv6Host @JvmOverloads constructor (
    /**
     * The IPv6 address itself, with no square bracket adornments. May take
     * various forms as permitted by RFC 3986 and RFC 6874.
     */
    val address: String,

    /**
     * IPv6 zone identifier, e.g. <code>"eth0"</code>. This is rarely seen.
     */
    val zone: String? = null,

    /**
     * Raw form of address, properly encoded and bracketed
     */
    override val raw: String = IPv6Host.format(address, zone)

) : Host() {

    override fun format(): String {
        return IPv6Host.format(address, zone)
    }

    companion object {
        fun format(address: String, zone: String?): String {
            val zonepart = if (zone == null)
                ""
            else
                "%25" + Codecs.percentEncodeIPv6Zone(zone)
            return "[$address$zonepart]"
        }
    }
}
