package org.timmc.johnny.parts;

/**
 * The host component of a URI using a future IP version.
 */
public class IPvFutureHost extends Host {
    /**
     * Raw string of IP address of some unknown, future version.
     * This has not been decoded or normalized in any way; it's up to you.
     */
    public final String raw;

    public IPvFutureHost(String raw) {
        if (raw == null) {
            throw new NullPointerException("IPvFuture host must not be null");
        }
        this.raw = raw;
    }

    @Override
    public String format() {
        return raw;
    }

    @Override
    public String getRaw() {
        return raw;
    }
}
