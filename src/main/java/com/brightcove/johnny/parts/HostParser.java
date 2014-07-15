package com.brightcove.johnny.parts;

/**
 * A parser for host components.
 */
public interface HostParser {
    /**
     * Parse a raw host component string into a {@link Host} instance.
     * @param hostRaw Non-nullable
     * @return Non-null
     */
    public Host parse(String hostRaw);
}
