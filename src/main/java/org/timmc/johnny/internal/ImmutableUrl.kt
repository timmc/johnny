package org.timmc.johnny.internal

import org.timmc.johnny.Host
import org.timmc.johnny.Url

/**
 * A concurrency-safe Url implementation. Methods are generally
 * thread-safe, and instances may be freely shared outside of the scope they
 * are created in.
 */
data class ImmutableUrl
/**
 * Create a URL piecewise, with no validation.
 */
constructor (
    override val schemeRaw: String,
    override val userInfoRaw: String?,
    override val host: Host,
    override val portRaw: String?,
    override val pathRaw: String,
    override val queryRaw: String?,
    override val fragmentRaw: String?
) : Url() {

    override val hostRaw: String
        get() = host.raw

    override fun withSchemeRaw(schemeRaw: String): ImmutableUrl {
        return copy(schemeRaw = schemeRaw)
    }

    override fun withUserInfoRaw(userInfoRaw: String?): ImmutableUrl {
        return copy(userInfoRaw = userInfoRaw)
    }

    override fun withHost(host: Host): ImmutableUrl {
        return copy(host = host)
    }

    override fun withPortRaw(portRaw: String?): ImmutableUrl {
        return copy(portRaw = portRaw)
    }

    override fun withPathRaw(pathRaw: String): ImmutableUrl {
        return copy(pathRaw = pathRaw)
    }

    override fun withQueryRaw(queryRaw: String?): ImmutableUrl {
        return copy(queryRaw = queryRaw)
    }

    override fun withFragmentRaw(fragmentRaw: String?): ImmutableUrl {
        return copy(fragmentRaw = fragmentRaw)
    }
}
