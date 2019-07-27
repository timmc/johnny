package org.timmc.johnny.internal

import org.timmc.johnny.HostedUri
import org.timmc.johnny.GenericUri
import org.timmc.johnny.UriDecodeException

/**
 * A full-URI parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URI components, and whether to canonicalize components (such as
 * case-folding of scheme and host.)
 */
interface UriParser {

    /**
     * Parse a generic URI.
     * @throws UriDecodeException if the URI is not well-formed
     */
    @Throws(UriDecodeException::class)
    fun parseGenericUri(input: String): GenericUri

    /**
     * Parse a URI with a host component.
     * @throws UriDecodeException if the URI is not well-formed
     */
    @Throws(UriDecodeException::class)
    fun parseHostedUri(input: String): HostedUri {
        val uri = parseGenericUri(input)
        try {
            return uri.toHostedUri()
        } catch (e: Exception) {
            throw UriDecodeException("Valid URI, but does not have a host component")
        }
    }

    /** Check if a proposed scheme component is valid; throw if not. */
    @Throws(UriDecodeException::class)
    fun validateScheme(input: String)
}
