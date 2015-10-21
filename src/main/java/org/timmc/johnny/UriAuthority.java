package org.timmc.johnny;

import java.util.regex.Pattern;

/**
 * RFC 3986 URI authority component representation and parsing.
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

        //TODO validate

        this.userinfoRaw = userinfoRaw;
        this.hostRaw = hostRaw;
        this.portRaw = portRaw;
    }

    private static final Pattern digits = Pattern.compile("[0-9]*");

    /**
     * Parse a URI based on generic syntax (not scheme-specific.)
     */
    public static UriAuthority parseGeneric(String authority) {
        if (authority == null) { throw new NullPointerException("authority may not be null."); }
        String userinfo, host, port;

        String[] findUserinfo = authority.split("@", 2);
        String remaining;
        if (findUserinfo.length == 2) {
            userinfo = findUserinfo[0];
            remaining = findUserinfo[1];
        } else {
            userinfo = null;
            remaining = authority;
        }

        int lastColon = remaining.lastIndexOf(':');
        if (lastColon == -1) {
            host = remaining;
            port = null;
        } else {
            String possiblePort = remaining.substring(lastColon + 1);
            if (digits.matcher(possiblePort).matches()) {
                host = remaining.substring(0, lastColon);
                port = possiblePort;
            } else {
                host = remaining;
                port = null;
            }
        }

        return new UriAuthority(userinfo, host, port);
    }
}
