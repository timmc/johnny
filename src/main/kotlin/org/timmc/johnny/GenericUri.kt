package org.timmc.johnny

import org.timmc.johnny.internal.Codecs

/**
 * A generic URI, where the only component guaranteed to exist is the scheme.
 */
data class GenericUri
/**
 * Create a URI piecewise, with no validation.
 */
constructor(
    /**
     * Raw, unnormalized scheme of URI. (Might not be all lowercase.) Not
     * null.
     */
    val schemeRaw: String,

    /** Authority component, nullable. */
    val authority: UriAuthority?,

    /** Undecoded path component, non-null but may be empty. */
    val pathRaw: String,

    /**
     * Undecoded query portion of URL, excluding "?" separator. Null indicates
     * it is entirely missing, whereas empty string represents the presence of
     * a "?" separator with no query data beyond it. These are not necessarily
     * meaningfully different.
     */
    val queryRaw: String?,

    /**
     * Undecoded fragment portion of URL, excluding "#" separator. Nullable,
     * with same implications as in [queryRaw].
     */
    val fragmentRaw: String?
) {
    init {
        Codecs.urlParser.validateScheme(schemeRaw)
    }

    /**
     * Convert to a [HostedUri] if possible, else throw an
     * IllegalArgumentException (specifically, if the generic URI
     * lacks an authority component.)
     */
    @Throws(IllegalArgumentException::class)
    fun toHostedUri(): HostedUri {
        if (authority == null) {
            throw IllegalArgumentException("URI does not have a host component")
        }
        return HostedUri(
            schemeRaw = schemeRaw,
            userInfoRaw = authority.userinfoRaw,
            host = authority.host,
            portRaw = authority.portRaw,
            pathRaw = pathRaw,
            queryRaw = queryRaw,
            fragmentRaw = fragmentRaw
        )
    }
}
