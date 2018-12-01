package org.timmc.johnny.internal;

import org.timmc.johnny.Url;

/**
 * Deeper validation of Url components.
 */
public class UrlValidator {

    /** Validate {@link Url} constructor arguments by parts. */
    void validateAllParts(Object[] args) {
        validateScheme((String) args[0]);
        validateUserInfoRaw((String) args[1]);
        validateHostRaw((String) args[2]);
        validatePort((Integer) args[3]);
        validatePathRaw((String) args[4]);
        validateQueryRaw((String) args[5]);
        // fragment does not need validation
    }

    /*== Validations for arguments. ==*/

    void validateScheme(String scheme) {
        if (scheme == null) {
            throw new IllegalArgumentException("scheme must not be null");
        } else if (!scheme.equals("http") && !scheme.equals("https")) {
            throw new IllegalArgumentException("scheme must be http or https"); //XXX -- true?
        }
    }

    void validateUserInfoRaw(String userInfoRaw) {
        //TODO: Find unencoded delimiters
    }

    void validateHostRaw(String hostRaw) {
        if (hostRaw == null) {
            throw new IllegalArgumentException("host must not be null");
        }
        if (hostRaw.isEmpty()) {
            throw new IllegalArgumentException("host must not be empty");
        }
        //TODO Rationalize with HostParser
    }

    void validatePort(Integer port) {
        if (port == null) { return; }
        int port_i = port;
        if (port_i < 0) {
            throw new IllegalArgumentException("port must not be negative"); // TODO: Is 0 allowed?
        } else if (port_i > 65535) { 
            throw new IllegalArgumentException("port must not be greater than 65535"); // TODO Maximum port value?
        }
    }

    void validatePathRaw(String pathRaw) {
        if (pathRaw == null) {
            throw new IllegalArgumentException("pathRaw must not be null");
        }
        if (pathRaw.isEmpty()) {
            return;
        }
        if (pathRaw.charAt(0) != '/') {
            throw new IllegalArgumentException("pathRaw must start with / if not empty");
        }
        //TODO: Find unencoded delimiters
    }

    void validateQueryRaw(String pathRaw) {
        //TODO: Find unencoded delimiters
    }
}
