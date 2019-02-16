package org.timmc.johnny.internal

import org.timmc.johnny.HostedUri
import org.timmc.johnny.UriAuthority
import org.timmc.johnny.UrlDecodeException

/**
 * A URL parser based on the generic [Rfc3986Uri] parser.
 */
class SchemeSpecificUriParser : UrlParser {

    @Throws(UrlDecodeException::class)
    override fun parseHostedUri(input: String): HostedUri {
        val authority: UriAuthority
        val uri = Rfc3986Uri.parseGeneric(input)
        if (uri.authority == null) {
            throw UrlDecodeException("Generic URI did not have an authority component.")
        } else {
            authority = uri.parseAuthority()
        }
        return HostedUri(
            uri.scheme, authority.userinfoRaw, authority.host, authority.portRaw,
            uri.path, uri.query, uri.fragment
        )
    }

}
