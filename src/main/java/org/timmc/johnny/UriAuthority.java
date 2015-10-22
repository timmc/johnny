package org.timmc.johnny;

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
    /** Raw host component, not null. */
    public final String hostRaw;
    /** Raw port component, nullable and possibly empty. */
    public final String portRaw;

    /**
     * Create a URI authority component from raw subcomponents.
     */
    public UriAuthority(String userinfoRaw, String hostRaw, String portRaw) {
        if (hostRaw == null) { throw new NullPointerException("Host may not be null."); }

        this.userinfoRaw = userinfoRaw;
        this.hostRaw = hostRaw;
        this.portRaw = portRaw;
    }

    private static final Pattern digitsOrEmpty = Pattern.compile("[0-9]*");

    /**
     * Parse a URI based on generic syntax (not scheme-specific.)
     */
    public static UriAuthority parseGeneric(String authority) {
        if (authority == null) { throw new NullPointerException("authority may not be null."); }
        String userinfo, host, port;

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

        // Split off port
        int lastColon = remaining.lastIndexOf(':');
        if (lastColon == -1) {
            host = remaining;
            port = null;
        } else {
            // There's some difficulty here... we can't tell if there's a port unless we at
            // least *peek* at the host, but we don't want to fully parse it if we don't have to.
            // Also, Guava doesn't know how to parse IPv6 addresses with zone identifiers.
            String possiblePort = remaining.substring(lastColon + 1);
            if (possiblePort.endsWith("]")) {
                // We probably have an IPv6 or IPvFuture address, no port
                host = remaining;
                port = null;
            } else if (digitsOrEmpty.matcher(possiblePort).matches()) {
                host = remaining.substring(0, lastColon);
                port = possiblePort;
            } else {
                throw new IllegalArgumentException("URI authority section ends in invalid port (or is unbracketed IPv6 address)");
            }
        }

        return new UriAuthority(userinfo, host, port);
    }
}
