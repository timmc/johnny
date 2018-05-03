package org.timmc.johnny.parts;

import org.timmc.johnny.Codecs;
import org.timmc.johnny.UrlDecodeException;

/**
 * A URI host that is a name, e.g. a domain name.
 */
public class RegNameHost extends Host {
    private final String raw;

    public RegNameHost(String raw) { // TODO: Should we accept decoded name instead? When is that safe?
        if (raw == null) {
            throw new NullPointerException("Registered-name host must not be null");
        }
        this.raw = raw;
    }

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
