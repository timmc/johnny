package org.timmc.johnny.parts;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;

import org.timmc.johnny.Codecs;
import org.timmc.johnny.parts.Host.HostType;

/**
 * Host parser that is generally more restrictive, e.g. not allowing IPv6 hosts without brackets.
 * TODO: Characterize strictness.
 */
public class StrictHostParser implements HostParser {

    public Host parse(String hostRaw) {
        String host = Codecs.percentDecode(hostRaw); // XXX Bzzzt, must decode *after* unpacking IPv6 (due to zone id delimiter)
        boolean isBracketed = host.startsWith("[") && host.endsWith("]");
        // Assume a dotted-quad is an IPv4 address and not a domain with a numeric TLD. (RFC 3986 §3.2.2)
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
