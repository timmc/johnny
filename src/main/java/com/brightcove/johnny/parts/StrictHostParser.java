package com.brightcove.johnny.parts;

import java.net.Inet6Address;
import java.net.InetAddress;

import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;

import com.brightcove.johnny.http.Codecs;

public class StrictHostParser implements HostParser {

    public Host parse(String hostRaw) {
        String host = Codecs.percentDecode(hostRaw);
        boolean isBracketed = host.startsWith("[") && host.endsWith("]");
        // Assume a dotted-quad is an IPv4 address and not a domain with a numeric TLD.
        if (InetAddresses.isUriInetAddress(host)) {
            InetAddress ip = InetAddresses.forUriString(host);
            if (ip instanceof Inet6Address && !isBracketed) {
                throw new IllegalArgumentException("IPv6 addresses must be [square-bracketed] in URL host components.");
            }
            return new Host(ip);
        } else if (InternetDomainName.isValid(host)) {
            return new Host(InternetDomainName.from(host));
        } else {
            throw new IllegalArgumentException("Could not parse host as an IPv4/6 address or a domain name.");
        }
    }
}
