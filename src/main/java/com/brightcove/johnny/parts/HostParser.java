package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Urls;

/**
 * A parser for host components.
 *
 * TODO Use https://tools.ietf.org/html/rfc6874 to parse out IPv6 zone IDs
 *
 * @see Urls#DEFAULT_HOST_PARSER
 */
public interface HostParser {
    public Host parse(String hostRaw);
}
