package com.brightcove.johnny.parts;

import com.google.common.net.InetAddresses;

/**
 * Encoder of {@link Host} instances into raw host component strings.
 */
public class HostEncoder {
    /**
     * Convert a Host instance into a string suitable for use directly as a URL's host component.
     * @param host Non-null host
     * @return Non-null
     */
    public String unparse(Host host) {
        if (host.isDomain()) {
            return host.getDomain().name(); // TODO: Encode unicode?
        } else {
            return InetAddresses.toUriString(host.getIp());
        }
    }
}
