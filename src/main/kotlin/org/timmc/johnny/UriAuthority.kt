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
) {
    /** Format back into a string. */
    fun format(): String {
        val build = StringBuilder()
        if (userinfoRaw != null) {
            build.append(userinfoRaw).append('@')
        }
        build.append(host.format())
        if (portRaw != null && portRaw.isNotEmpty()) {
            build.append(':').append(portRaw)
        }
        return build.toString()
    }
}
