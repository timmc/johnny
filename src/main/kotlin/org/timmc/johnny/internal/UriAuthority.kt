package org.timmc.johnny.internal

import org.timmc.johnny.*

import java.util.regex.Pattern

/**
 * RFC 3986 + RFC 6874 URI authority component representation and parsing.
 *
 * This is not split out as a separate Parser/Formatter pair because it is specific to a certain
 * UrlParser.
 */
data class UriAuthority(
    /** Userinfo component. */
    @JvmField
    val userinfoRaw: String?,
    /** Host component */
    @JvmField
    val host: Host,
    /** Raw port component, nullable and possibly empty. */
    @JvmField
    val portRaw: String?
) {
    companion object {

        private val digitsOrEmpty = Pattern.compile("[0-9]*")
        private val ipv6 = Pattern.compile("^\\[([0-9a-fA-F:/.]+)(%25.*)?\\]$")
        private val ipv4 = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)\\$")
        private val ipvFuture = Pattern.compile("^\\[[vV]([0-9a-fA-F]+)\\..*\\]")

        /**
         * Parse a URI based on generic syntax (not scheme-specific.)
         */
        @JvmStatic
        @Throws(UrlDecodeException::class)
        fun parseGeneric(authority: String): UriAuthority {
            val userinfo: String?
            val hostRaw: String
            val port: String?

            // Split off userinfo
            val findUserinfo = authority.split("@".toRegex(), 2).toTypedArray()
            val remaining: String
            if (findUserinfo.size == 2) {
                userinfo = findUserinfo[0]
                remaining = findUserinfo[1]
            } else {
                userinfo = null
                remaining = authority
            }

            // TODO: Revisit this hand-built parser for correctness and optimal error reporting
            // Split off port
            val lastColon = remaining.lastIndexOf(':')
            if (lastColon == -1) {
                hostRaw = remaining
                port = null
            } else {
                // There's some difficulty here... we can't tell if there's a port unless we at
                // least *peek* at the host, but we don't want to fully parse it if we don't have to.
                // Also, Guava doesn't know how to parse IPv6 addresses with zone identifiers.
                val possiblePort = remaining.substring(lastColon + 1)
                if (possiblePort.endsWith("]")) {
                    // We probably have an IPv6 or IPvFuture address, no port
                    hostRaw = remaining
                    port = null
                } else if (digitsOrEmpty.matcher(possiblePort).matches()) {
                    hostRaw = remaining.substring(0, lastColon)
                    port = possiblePort
                } else {
                    throw UrlDecodeException("URI authority section ends in invalid port (or is unbracketed IPv6 address)")
                }
            }

            return UriAuthority(userinfo, parseHost(hostRaw), port)
        }

        // TODO: Revisit this hand-built parser for correctness and optimal error reporting
        @JvmStatic
        private fun parseHost(hostRaw: String): Host {
            val ipv4Match = ipv4.matcher(hostRaw)
            if (ipv4Match.find()) {
                return IPv4Host(
                    Integer.parseInt(ipv4Match.group(1)),
                    Integer.parseInt(ipv4Match.group(2)),
                    Integer.parseInt(ipv4Match.group(3)),
                    Integer.parseInt(ipv4Match.group(4)),
                    hostRaw
                )
            }

            val ipvFutureMatch = ipvFuture.matcher(hostRaw)
            if (ipvFutureMatch.find()) {
                val formatVersion = Integer.parseInt(ipvFutureMatch.group(1))
                return IPvFutureHost(formatVersion, hostRaw)
            }

            val ipv6Match = ipv6.matcher(hostRaw)
            if (ipv6Match.find()) {
                val addr = ipv6Match.group(1)
                val zoneRaw = ipv6Match.group(2)
                val zone = if (zoneRaw == null) null else Codecs.percentDecode(zoneRaw)
                return IPv6Host(addr, zone, hostRaw)
            }

            // TODO Currently acting as catchall, without filtering on things like "[blah"
            return RegNameHost(hostRaw)
        }
    }
}
