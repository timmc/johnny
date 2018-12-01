package org.timmc.johnny.internal;

import org.timmc.johnny.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RFC 3986 + RFC 6874 URI authority component representation and parsing.
 * 
 * This is not split out as a separate Parser/Formatter pair because it is specific to a certain
 * UrlParser.
 */
public class UriAuthority {
    /** Userinfo component, nullable. */
    public final String userinfoRaw;
    /** Host component, not null. */
    public final Host host;
    /** Raw port component, nullable and possibly empty. */
    public final String portRaw;

    /**
     * Create a URI authority component from raw subcomponents.
     */
    public UriAuthority(String userinfoRaw, Host host, String portRaw) {
        if (host == null) { throw new NullPointerException("Host may not be null."); }

        this.userinfoRaw = userinfoRaw;
        this.host = host;
        this.portRaw = portRaw;
    }

    private static final Pattern digitsOrEmpty = Pattern.compile("[0-9]*");
    private static final Pattern ipv6 = Pattern.compile("^\\[([0-9a-fA-F:/.]+)(%25.*)?\\]$");
    private static final Pattern ipv4 = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)\\$");
    private static final Pattern ipvFuture = Pattern.compile("^\\[[vV]([0-9a-fA-F]+)\\..*\\]");

    /**
     * Parse a URI based on generic syntax (not scheme-specific.)
     */
    public static UriAuthority parseGeneric(String authority) throws UrlDecodeException {
        if (authority == null) { throw new NullPointerException("authority may not be null."); }
        String userinfo, hostRaw, port;

        // Split off userinfo
        String[] findUserinfo = authority.split("@", 2);
        String remaining;
        if (findUserinfo.length == 2) {
            userinfo = findUserinfo[0];
            remaining = findUserinfo[1];
        } else {
            userinfo = null;
            remaining = authority;
        }

        // TODO: Revisit this hand-built parser for correctness and optimal error reporting
        // Split off port
        int lastColon = remaining.lastIndexOf(':');
        if (lastColon == -1) {
            hostRaw = remaining;
            port = null;
        } else {
            // There's some difficulty here... we can't tell if there's a port unless we at
            // least *peek* at the host, but we don't want to fully parse it if we don't have to.
            // Also, Guava doesn't know how to parse IPv6 addresses with zone identifiers.
            String possiblePort = remaining.substring(lastColon + 1);
            if (possiblePort.endsWith("]")) {
                // We probably have an IPv6 or IPvFuture address, no port
                hostRaw = remaining;
                port = null;
            } else if (digitsOrEmpty.matcher(possiblePort).matches()) {
                hostRaw = remaining.substring(0, lastColon);
                port = possiblePort;
            } else {
                throw new UrlDecodeException("URI authority section ends in invalid port (or is unbracketed IPv6 address)");
            }
        }

        return new UriAuthority(userinfo, parseHost(hostRaw), port);
    }

    // TODO: Revisit this hand-built parser for correctness and optimal error reporting
    private static Host parseHost(String hostRaw) {
        Matcher ipv4Match = ipv4.matcher(hostRaw);
        if (ipv4Match.find()) {
            List<Integer> quad = new ArrayList<>();
            quad.add(Integer.parseInt(ipv4Match.group(1)));
            quad.add(Integer.parseInt(ipv4Match.group(2)));
            quad.add(Integer.parseInt(ipv4Match.group(3)));
            quad.add(Integer.parseInt(ipv4Match.group(4)));
            return new IPv4Host(quad, hostRaw);
        }

        Matcher ipvFutureMatch = ipvFuture.matcher(hostRaw);
        if (ipvFutureMatch.find()) {
            int formatVersion = Integer.parseInt(ipvFutureMatch.group(1));
            return new IPvFutureHost(formatVersion, hostRaw);
        }

        Matcher ipv6Match = ipv6.matcher(hostRaw);
        if (ipv6Match.find()) {
            String addr = ipv6Match.group(1);
            String zoneRaw = ipv6Match.group(2);
            String zone = zoneRaw == null ? null : Codecs.percentDecode(zoneRaw);
            return new IPv6Host(addr, zone, hostRaw);
        }

        // TODO Currently acting as catchall, without filtering on things like "[blah"
        return new RegNameHost(hostRaw);
    }
}
