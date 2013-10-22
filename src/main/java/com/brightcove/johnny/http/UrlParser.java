package com.brightcove.johnny.http;

import java.net.MalformedURLException;

/**
 * A full-URL parser. Implementations have the freedom to choose which
 * character set they use for percent-decoding, how carefully to validate
 * various URL components, and whether to canonicalize components (such as
 * case-folding of protocol and host.)
 */
public interface UrlParser {
    /**
     * Parse a full URL into an intermediate representation that a {@link Url}
     * implementation can read.
     * @return Array of values suitable for return from {@link Url#getProtocol()},
     *  {@link Url#getUserInfoRaw()}, {@link Url#getHostRaw()}, {@link Url#getPort()},
     *  {@link Url#getPathRaw()}, {@link Url#getQueryRaw()}, {@link Url#getFragment()}.
     * @throws MalformedURLException if the URL is not well-formed
     */
    public Object[] parse(String url) throws MalformedURLException;
}
