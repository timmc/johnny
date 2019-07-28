package org.timmc.johnny

import org.timmc.johnny.internal.Codecs

/**
 * Main entrance point for http(s) URL parsing and manipulation.
 *
 * Start by calling [parse], then use builder methods on the returned `HostedUri`
 * instance. The `HostedUri` may be inspected, manipulated, and re-encoded
 * without mutation, including the path and query subcomponents.
 *
 * ```
 * HostedUri orig = Urls.parse("https://example.com/login?a=b=c&amp;a=?d");
 * HostedUri result = orig.withQuery(orig.getQuery()
 *                                 .append("foo", "bar")
 *                                 .replace("a", null));
 * result.format(); // "https://example.com/login?foo=bar&amp;a"
 * ```
 */
object Urls {

    /**
     * Parse a URI from a string, assuming it is of a type that specifies a
     * host, e.g. HTTP and FTP URLs.
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parse(uri: String): HostedUri {
        return Codecs.uriParser.parseHostedUri(uri)
    }

    /**
     * Parse a URI of any sort from a string.
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parseGeneric(uri: String): GenericUri {
        return Codecs.uriParser.parseGenericUri(uri)
    }

    /**
     * Create a URL piecewise with the bare minimum of components.
     */
    @JvmStatic
    fun from(scheme: String, host: Host): HostedUri {
        // NB: We're passing in scheme for the schemeRaw
        return HostedUri(scheme, null, host, null, "", null, null)
    }

    /**
     * Parse a path to the default piecewise URI query representation
     * using the default parser.
     * @param pathRaw Non-null path component (may be empty)
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parsePath(pathRaw: String): TextPath {
        return Paths.parse(pathRaw)
    }

    /**
     * Parse a query string (convenience passthrough for
     * [Queries.parse]).
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parseQuery(queryRaw: String): Params {
        return Queries.parse(queryRaw)
    }
}
