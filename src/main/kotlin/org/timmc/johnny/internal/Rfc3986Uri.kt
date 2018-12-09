package org.timmc.johnny.internal

import org.timmc.johnny.UrlDecodeException

import java.util.regex.Pattern

/**
 * RFC 3986 URI representation and parsing.
 */
data class Rfc3986Uri
@Throws(UrlDecodeException::class)
constructor(
    /** Scheme component */
    @JvmField
    val scheme: String,
    /** Raw authority component */
    @JvmField
    val authority: String?,
    /** Raw path component */
    @JvmField
    val path: String,
    /** Raw query component */
    @JvmField
    val query: String?,
    /** Raw fragment component */
    @JvmField
    val fragment: String?
) {
    init {
        if (scheme.isEmpty()) {
            throw UrlDecodeException("Scheme component was empty")
        }
        if (!Constants.ASCII_ALPHA.get(scheme[0].toInt())) {
            throw UrlDecodeException("Scheme component must start with an alphabetic character")
        }
        if (!BitSetUtils.fromChars(scheme).andNot(Constants.RFC3986_SCHEME_ALLOWED).isEmpty()) {
            throw UrlDecodeException("Scheme component contained an illegal char")
        }
        //TODO validate and characterize path
    }

    /**
     * Parse the authority component. Throws if authority is null.
     */
    @Throws(UrlDecodeException::class)
    fun parseAuthority(): UriAuthority {
        return UriAuthority.parseGeneric(authority!!)
    }

    companion object {

        private val absSyntax = Pattern.compile("^([^:]*?):([^?#]*?)(\\?([^#]*))?(#(.*))?$")

        /**
         * Parse a URI based on generic syntax (not scheme-specific.)
         */
        @JvmStatic
        @Throws(UrlDecodeException::class)
        fun parseGeneric(uri: String?): Rfc3986Uri {
            if (uri == null) {
                throw NullPointerException("uri may not be null.")
            }

            val m = absSyntax.matcher(uri)
            if (!m.find()) {
                throw UrlDecodeException("Could not determine basic structure of URI")
            }
            val scheme = m.group(1)
            val hierarchy = m.group(2)
            val query = m.group(4)
            val fragment = m.group(6)

            val authority: String?
            val path: String
            if (hierarchy.startsWith("//")) {
                // We have an authority
                val firstSlash = hierarchy.indexOf('/', 2)
                if (firstSlash == -1) {
                    authority = hierarchy.substring(2)
                    path = ""
                } else {
                    authority = hierarchy.substring(2, firstSlash)
                    path = hierarchy.substring(firstSlash)
                }
            } else {
                authority = null
                path = hierarchy
            }

            return Rfc3986Uri(scheme, authority, path, query, fragment)
        }
    }
}
