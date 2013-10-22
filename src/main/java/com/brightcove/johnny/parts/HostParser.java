package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Urls;

/**
 * A parser for host components.
 *
 * @see Urls#STANDARD_HOST_PARSER
 */
public interface HostParser {
    public Host parse(String hostRaw);
}
