package org.timmc.johnny.internal

import org.timmc.johnny.HostedUri
import org.timmc.johnny.GenericUri
import org.timmc.johnny.UrlDecodeException

/**
 * A full-URL parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URL components, and whether to canonicalize components (such as
 * case-folding of scheme and host.)
 */
interface UrlParser {

    /**
     * Parse a generic URI.
     * @throws UrlDecodeException if the URL is not well-formed
     */
    @Throws(UrlDecodeException::class)
    fun parseGenericUri(input: String): GenericUri

    /**
     * Parse a URI with a host component.
     * @throws UrlDecodeException if the URL is not well-formed
     */
    @Throws(UrlDecodeException::class)
    fun parseHostedUri(input: String): HostedUri {
        val uri = parseGenericUri(input)
        try {
            return narrowToHostedUri(uri)
        } catch(e: Exception) {
            throw UrlDecodeException("Valid URI, but does not have a host component")
        }
    }
}

/**
 * Convert a [GenericUri] to a [HostedUri] if possible, else throw an
 * IllegalArgumentException (specifically, if the generic URI
 * lacks an authority component.)
 */
@Throws(IllegalArgumentException::class)
fun narrowToHostedUri(generic: GenericUri): HostedUri {
    if (generic.authority == null) {
        throw IllegalArgumentException("URI does not have a host component")
    }
    return HostedUri(
        schemeRaw = generic.schemeRaw,
        userInfoRaw = generic.authority.userinfoRaw,
        host = generic.authority.host,
        portRaw = generic.authority.portRaw,
        pathRaw = generic.pathRaw,
        queryRaw = generic.queryRaw,
        fragmentRaw = generic.fragmentRaw
    )
}
