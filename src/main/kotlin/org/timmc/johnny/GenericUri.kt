package org.timmc.johnny

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

    /** Path component, non-null but may be empty. */
    val path: String,

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
)
