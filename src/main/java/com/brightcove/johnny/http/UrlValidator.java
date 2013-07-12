package com.brightcove.johnny.http;

import com.google.common.net.InternetDomainName;

/**
 * Deeper validation of Url components.
 */
public class UrlValidator {

    /** Validate {@link Url} constructor arguments by parts. */
    void validateAllParts(Object[] args) {
        validateProtocol((String) args[0]);
        validateUserInfoRaw((String) args[1]);
        validateHost((String) args[2]);
        validatePort((Integer) args[3]);
        validatePathRaw((String) args[4]);
        validateQueryRaw((String) args[5]);
        // fragment does not need validation
    }

    /*== Validations for arguments. ==*/

    void validateProtocol(String protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol must not be null");
        } else if (!protocol.equals("http") && !protocol.equals("https")) {
            throw new IllegalArgumentException("protocol must be http or https"); //XXX -- true?
        }
    }

    void validateUserInfoRaw(String userInfoRaw) {
        //TODO: Find unencoded delimiters
    }

    void validateHost(String host) {
        if (host == null) {
            throw new IllegalArgumentException("host must not be null");
        }
        if (!InternetDomainName.isValidLenient(host)) {
            //TODO: IPv4 serializations
            //TODO: IPv6 serializations, including scope and future formats
        }
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
