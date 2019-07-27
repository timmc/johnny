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
            return uri.toHostedUri()
        } catch (e: Exception) {
            throw UrlDecodeException("Valid URI, but does not have a host component")
        }
    }
}
