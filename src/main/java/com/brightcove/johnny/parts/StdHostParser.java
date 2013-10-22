package com.brightcove.johnny.parts;

import java.net.Inet6Address;
import java.net.InetAddress;

import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;

import com.brightcove.johnny.http.Codecs;

public class StdHostParser implements HostParser {

    public Host parse(String hostRaw) {
        String host = Codecs.percentDecode(hostRaw);
        boolean isBracketed = host.startsWith("[") && host.endsWith("]");
        if (InetAddresses.isUriInetAddress(host)) {
            InetAddress ip = InetAddresses.forUriString(host);
            if (ip instanceof Inet6Address && !isBracketed) {
                throw new IllegalArgumentException("IPv6 addresses must be [square-bracketed] in URL host components.");
            }
            return new Host(ip);
        } else {
            return new Host(InternetDomainName.from(host));
        }
    }
}
