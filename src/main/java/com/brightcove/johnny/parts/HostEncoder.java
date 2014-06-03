package com.brightcove.johnny.parts;

import com.google.common.net.InetAddresses;

public class HostEncoder {
    public String unparse(Host host) {
        if (host.isDomain()) {
            return host.getDomain().name(); // TODO: Encode unicode?
        } else {
            return InetAddresses.toUriString(host.getIp());
        }
    }
}
