package org.timmc.johnny.parts;

/**
 * The host component of a URI using a future IP literal format. This is a
 * syntax reservation which, as of this writing, has no specification.
 *
 * <p>Note, in particular, that the "version" field of this format does
 * <em>not</em> refer to the IP version, but the format version.</p>
 */
public class IPvFutureHost extends Host {
    /**
     * Raw string of IP literal.
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
