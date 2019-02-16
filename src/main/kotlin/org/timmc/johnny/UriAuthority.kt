package org.timmc.johnny

/**
 * URI authority component, containing at minimum a host component.
 */
data class UriAuthority(
    /** Userinfo component. */
    @JvmField
    val userinfoRaw: String?,
    /** Host component */
    @JvmField
    val host: Host,
    /** Raw port component, nullable and possibly empty. */
    @JvmField
    val portRaw: String?
)
