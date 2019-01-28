package org.timmc.johnny

import org.timmc.johnny.internal.ImmutableUrl
import org.timmc.johnny.internal.AntlrUriParser


/**
 * Main entrance point for http(s) URL parsing and manipulation.
 *
 * Start by calling [.parse], then use builder methods on the returned `Url`
 * instance. The `Url` may be inspected, manipulated, and re-encoded
 * without mutation, including the path and query subcomponents.
 *
 * ```
 * Url orig = Urls.parse("https://example.com/login?a=b=c&amp;a=?d");
 * Url result = orig.withQuery(orig.getQuery()
 *                                 .append("foo", "bar")
 *                                 .replace("a", null));
 * result.format(); // "https://example.com/login?foo=bar&amp;a"
 * ```
 */
object Urls {

    private val urlParser = AntlrUriParser()

    /**
     * Parse a URL string to the default piecewise HTTP URL representation
     * using the default parser.
     */
    @JvmStatic
    @Throws(UrlDecodeException::class)
    fun parse(url: String?): Url {
        if (url == null) {
            throw NullPointerException("url may not be null.")
        }

        return Urls.urlParser.parse(url)
    }

    /**
     * Create a URL piecewise with the bare minimum of components.
     */
    @JvmStatic
    fun from(scheme: String, host: Host): Url {
        // NB: We're passing in scheme for the schemeRaw
        return ImmutableUrl(scheme, null, host, null, "", null, null)
    }

    /**
     * Format a [Url] to a string.
     */
    @JvmStatic
    fun format(url: Url): String {
        val build = StringBuilder()
        build.append(url.schemeRaw).append("://")
        if (url.userInfoRaw != null) {
            build.append(url.userInfoRaw).append("@")
        }
        build.append(url.hostRaw)
        val portRaw = url.portRaw
        if (portRaw != null && !portRaw.isEmpty()) {
            build.append(":").append(portRaw)
        }
        build.append(url.pathRaw)
        if (url.queryRaw != null) {
            build.append("?").append(url.queryRaw)
        }
        if (url.fragmentRaw != null) {
            build.append("#").append(url.fragmentRaw)
        }
        return build.toString()
    }

    /**
     * Parse a path to the default piecewise URI query representation
     * using the default parser.
     * @param pathRaw Non-null path component
     */
    @JvmStatic
    @Throws(UrlDecodeException::class)
    fun parsePath(pathRaw: String): TextPath {
        return Paths.parse(pathRaw)
    }

    /**
     * Parse a query string (convenience passthrough for
     * [Queries.parse]).
     */
    @JvmStatic
    @Throws(UrlDecodeException::class)
    fun parseQuery(queryRaw: String?): Params? {
        return Queries.parse(queryRaw)
    }
}
