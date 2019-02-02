package org.timmc.johnny.internal

import org.timmc.johnny.Url
import org.timmc.johnny.UrlDecodeException

/**
 * A full-URL parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URL components, and whether to canonicalize components (such as
 * case-folding of scheme and host.)
 */
interface UrlParser {
    /**
     * Parse a full URL into an intermediate representation that a [Url]
     * implementation can read.
     * @return Array of values suitable for return from [Url.schemeRaw],
     * [Url.userInfoRaw], [Url.hostRaw], [Url.portRaw],
     * [Url.pathRaw], [Url.queryRaw], [Url.fragmentRaw].
     * @throws UrlDecodeException if the URL is not well-formed
     */
    @Throws(UrlDecodeException::class)
    fun parse(url: String): Url
}
