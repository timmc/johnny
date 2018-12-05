package org.timmc.johnny;

import lombok.NonNull;
import org.timmc.johnny.internal.Codecs;

/**
 * A URI host that is a name, e.g. a domain name.
 */
public class RegNameHost extends Host {
    private final String raw;

    public RegNameHost(@NonNull String raw) { // TODO: Should we accept decoded name instead? When is that safe?
        this.raw = raw;
    }

    // TODO: parseDomain that parses into a sequence of domain labels,
    // reified as a class. Should also expose local/absolute re: empty
    // final segment. Need to decide what to do about percent-encoded
    // octets; they're supposed to represent non-ASCII, but what if
    // there's an encoded period? Should we split on period first,
    // decode first, or just prohibit encoded periods? (RFC 3986 §3.2.2
    // doesn't give any instruction.)

    // TODO Under what circumstances is it possible for a *valid* regname to need decoding?
    public String getName() throws UrlDecodeException {
        return Codecs.percentDecode(raw);
    }

    @Override
    public String format() {
        // TODO Should we return a potentially cleaner version that has been round-tripped through decode/encode?
        return raw;
    }

    @Override
    public String getRaw() {
        return raw;
    }
}
