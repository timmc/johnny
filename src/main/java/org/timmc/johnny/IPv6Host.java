package org.timmc.johnny;

import lombok.NonNull;
import org.timmc.johnny.internal.Codecs;

/**
 * IPv6 host component of a URI, represented as IPv6 address and optional zone identifier.
 */
public class IPv6Host extends Host {
    /**
     * The IPv6 address itself, with no square bracket adornments. May take
     * various forms as permitted by RFC 3986 and RFC 6874.
     */
    public final String address;
    /**
     * IPv6 zone identifier, e.g. <code>"eth0"</code>. This is rarely seen. Nullable.
     */
    public final String zone;

    private final String raw;

    /**
     * Create IPv6 host representation from plain address.
     * @param address Just the IPv6 address -- no brackets or zone
     */
    public IPv6Host(@NonNull String address) {
        this(address, null);
    }

    /**
     * Create IPv6 host representation from plain address and zone. Infers raw form.
     * @param address Just the IPv6 address -- no brackets or zone
     * @param zone Optional zone identifier, nullable (very rare)
     */
    public IPv6Host(@NonNull String address, String zone) {
        this(address, zone, IPv6Host.format(address, zone));
    }

    /**
     * Create IPv6 host representation from plain address and zone, with original raw form.
     * @param address Just the IPv6 address -- no brackets or zone
     * @param zone Optional zone identifier, nullable (very rare)
     * @param raw Raw form of address, properly encoded and bracketed
     */
    public IPv6Host(@NonNull String address, String zone, @NonNull String raw) {
        this.address = address;
        this.zone = zone;
        this.raw = raw;
    }

    public static String format(@NonNull String address, String zone) {
        String zonepart = zone == null ? "" : "%25" + Codecs.percentEncodeIPv6Zone(zone);
        return String.format("[%s%s]", address, zonepart);
    }

    @Override
    public String format() {
        return IPv6Host.format(address, zone);
    }

    @Override
    public String getRaw() {
        return raw;
    }
}
