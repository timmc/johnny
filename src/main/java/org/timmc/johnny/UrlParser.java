package org.timmc.johnny;

/**
 * A full-URL parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URL components, and whether to canonicalize components (such as
 * case-folding of scheme and host.)
 */
public interface UrlParser {
    /**
     * Parse a full URL into an intermediate representation that a {@link Url}
     * implementation can read.
     * @return Array of values suitable for return from {@link Url#getScheme()},
     *  {@link Url#getUserInfoRaw()}, {@link Url#getHostRaw()}, {@link Url#getPort()},
     *  {@link Url#getPathRaw()}, {@link Url#getQueryRaw()}, {@link Url#getFragment()}.
     * @throws UrlDecodeException if the URL is not well-formed
     */
    public Object[] parse(String url) throws UrlDecodeException;
}
