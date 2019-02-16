package org.timmc.johnny.internal

import org.timmc.johnny.HostedUri
import org.timmc.johnny.UrlDecodeException

/**
 * A full-URL parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URL components, and whether to canonicalize components (such as
 * case-folding of scheme and host.)
 */
interface UrlParser {
    /**
     * Parse an absolute URL.
     * @throws UrlDecodeException if the URL is not well-formed
     */
    @Throws(UrlDecodeException::class)
    fun parse(url: String): HostedUri
}
