package org.timmc.johnny.parts;

/**
 * Formatter of {@link Host} instances into raw host component strings.
 */
public class HostFormatter {
    /**
     * Format a Host instance into a string suitable for use directly as a URL's host component.
     * @param host Non-null host
     * @return Non-null
     */
    public String format(Host host) {
        switch (host.type) {
            case REG_NAME:
                return host.regNameRaw;
            case IP_V4:
                return host.ipv4address.toString();
            case IP_V6:
                return host.ipv6address.toString();
            case IP_UNKNOWN:
                return host.ipUnknownRaw;
            default:
                throw new IllegalArgumentException("Host must be of a known type, given: " + host.type);
        }
    }
}
