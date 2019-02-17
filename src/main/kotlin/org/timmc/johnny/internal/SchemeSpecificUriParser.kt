package org.timmc.johnny.internal

import org.timmc.johnny.*
import java.util.regex.Pattern

/**
 * Handwritten URI parser for RFC 3986 (prefer [AntlrUriParser] to this.)
 */
class SchemeSpecificUriParser : UrlParser {

    @Throws(UrlDecodeException::class)
    override fun parseGenericUri(input: String): GenericUri {
        return parseTopLevel(input)
    }

    companion object {
        // TODO don't allow empty scheme
        // TODO validate scheme starting with alpha char, and other character set validity?
//        if (!Constants.ASCII_ALPHA.get(scheme[0].toInt())) {
//            throw UrlDecodeException("Scheme component must start with an alphabetic character")
//        }
//        if (!BitSetUtils.fromChars(scheme).andNot(Constants.RFC3986_SCHEME_ALLOWED).isEmpty()) {
//            throw UrlDecodeException("Scheme component contained an illegal char")
//        }
        private val absSyntax = Pattern.compile("^([^:]*?):([^?#]*?)(\\?([^#]*))?(#(.*))?$")

        /**
         * Parse a URI based on generic syntax (not scheme-specific.)
         */
        @JvmStatic
        @Throws(UrlDecodeException::class)
        fun parseTopLevel(uri: String): GenericUri {
            val m = absSyntax.matcher(uri)
            if (!m.find()) {
                throw UrlDecodeException("Could not determine basic structure of URI")
            }
            val scheme = m.group(1)
            val hierarchy = m.group(2)
            val query = m.group(4)
            val fragment = m.group(6)

            val authorityRaw: String?
            val pathRaw: String
            if (hierarchy.startsWith("//")) {
                // We have an authority
                val firstSlash = hierarchy.indexOf('/', 2)
                if (firstSlash == -1) {
                    authorityRaw = hierarchy.substring(2)
                    pathRaw = ""
                } else {
                    authorityRaw = hierarchy.substring(2, firstSlash)
                    pathRaw = hierarchy.substring(firstSlash)
                }
            } else {
                authorityRaw = null
                pathRaw = hierarchy
            }

            return GenericUri(
                schemeRaw = scheme,
                authority = authorityRaw?.let{ parseAuthority(it) },
                pathRaw = pathRaw,
                queryRaw = query,
                fragmentRaw = fragment
            )
        }

        private val digitsOrEmpty = Pattern.compile("[0-9]*")
        private val ipv6 = Pattern.compile("^\\[([0-9a-fA-F:.]+)(%25(.*))?]$")
        private val ipv4 = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)$")
        private val ipvFuture = Pattern.compile("^\\[[vV]([0-9a-fA-F]+)\\.(.+)]")

        /**
         * Parse a URI based on generic syntax (not scheme-specific.)
         */
        @JvmStatic
        @Throws(UrlDecodeException::class)
        fun parseAuthority(authority: String): UriAuthority {
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
        fun parseHost(hostRaw: String): Host {
            val ipv4Match = ipv4.matcher(hostRaw)
            if (ipv4Match.find()) {
                val segs = (1..4).map {
                    val decOctet = ipv4Match.group(it)
                    if (decOctet.startsWith('0') && decOctet.length > 1) {
                        null
                    } else {
                        val seg = try {
                            Integer.parseInt(decOctet)
                        } catch(e: NumberFormatException) {
                            null
                        }
                        if (seg == null || seg > 255) {
                            null
                        } else {
                            seg
                        }
                    }
                }.filterNotNull()

                if (segs.size == 4) {
                    return IPv4Host(segs, hostRaw)
                } else {
                    return RegNameHost(hostRaw)
                }
            }

            val ipvFutureMatch = ipvFuture.matcher(hostRaw)
            if (ipvFutureMatch.find()) {
                val formatVersion = Integer.parseInt(ipvFutureMatch.group(1), 16)
                val data = ipvFutureMatch.group(2)
                return IPvFutureHost(formatVersion, data, hostRaw)
            }

            val ipv6Match = ipv6.matcher(hostRaw)
            if (ipv6Match.find()) {
                val addr = ipv6Match.group(1)
                val zoneRaw = ipv6Match.group(3)
                val zone = zoneRaw?.let { Codecs.percentDecode(it) }
                return IPv6Host(addr, zone, hostRaw)
            }

            // TODO Currently acting as catchall, without filtering on things like "[blah"
            return RegNameHost(hostRaw)
        }
    }
}
