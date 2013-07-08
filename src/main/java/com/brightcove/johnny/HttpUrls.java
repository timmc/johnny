package com.brightcove.johnny;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.common.net.InternetDomainName;

/**
 * Main entrance point for http(s) URL parsing and manipulation.
 */
public class HttpUrls {

    /*== Convenience ==*/ 

    /**
     * Parse a URL string to a piecewise URL representation.
     */
    public static HttpUrl from(String url) throws MalformedURLException {
        return ImmutableHttpUrl.fromFullUrl(url);
    }

    /*== Constructor assistance ==*/

    /** Parse a URL into arguments required for UrlBits constructors. */
    static Object[] parseFullUrl(String url) throws MalformedURLException {
        Object[] args = new Object[7];
        URL parsed = new URL(url); // FIXME: Will happily accept http://google.com:८०/
        args[0] = parsed.getProtocol();
        args[1] = parsed.getUserInfo();
        args[2] = parsed.getHost();
        args[3] = parsed.getPort() == -1 ? null : Long.valueOf(parsed.getPort());
        args[4] = parsed.getPath();
        args[5] = parsed.getQuery();
        args[6] = parsed.getRef();
        return args;
    }

    /** Validate constructor arguments by parts. */
    static void validateAllParts(Object[] args) {
        validateProtocol((String) args[0]);
        validateUserInfo((String) args[1]);
        validateHost((String) args[2]);
        validatePort((Long) args[3]);
        validatePathRaw((String) args[4]);
        validateQueryRaw((String) args[5]);
        // fragment does not need validation
    }

    /*== Validations for arguments. ==*/

    static void validateProtocol(String protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol must not be null");
        } else if (!protocol.equals("http") && !protocol.equals("https")) {
            throw new IllegalArgumentException("protocol must be http or https"); //XXX -- true?
        }
    }

    static void validateUserInfo(String userInfo) {
        //TODO: Find unencoded delimiters
    }

    static void validateHost(String host) {
        if (host == null) {
            throw new IllegalArgumentException("host must not be null");
        }
        if (!InternetDomainName.isValidLenient(host)) {
            //TODO: IPv4 serializations
            //TODO: IPv6 serializations, including scope and future formats
        }
    }

    static void validatePort(Long port) {
        if (port == null) { return; }
        long port_i = port;
        if (port_i < 0) {
            throw new IllegalArgumentException("port must not be negative"); // TODO: Is 0 allowed?
        } else if (port_i > 65535) { 
            throw new IllegalArgumentException("port must not be greater than 65535"); // TODO Maximum port value?
        }
    }

    static void validatePathRaw(String pathRaw) {
        if (pathRaw == null) {
            throw new IllegalArgumentException("pathRaw must not be null");
        }
        //TODO: Find unencoded delimiters
    }

    static void validateQueryRaw(String pathRaw) {
        //TODO: Find unencoded delimiters
    }

    /*== Encoders ==*/

    /** Naively percent-encode for inclusion in any portion of a URL. */
    private static String naivePercentEncode(String part) {
        if (part == null) {
            return "";
        } else {
            try {
                return URLEncoder.encode(part, "UTF-8");
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("Unexpected encoding exception: UTF-8 not available?");
            }
        }
    }

    public static String encodeUser(String user) {
        return naivePercentEncode(user); //FIXME use minimal encoder
    }

    public static String encodePassword(String password) {
        return naivePercentEncode(password); //FIXME use minimal encoder
    }

    public static String encodePathSegment(String pathSegment) {
        return naivePercentEncode(pathSegment); //FIXME use minimal encoder
    }

    public static String encodePathParamKey(String pathParamKey) {
        return naivePercentEncode(pathParamKey); //FIXME use minimal encoder
    }

    public static String encodePathParamValue(String pathParamValue) {
        return naivePercentEncode(pathParamValue); //FIXME use minimal encoder
    }

    public static String encodeQueryKey(String queryKey) {
        return naivePercentEncode(queryKey); //FIXME use minimal encoder
    }

    public static String encodeQueryValue(String queryValue) {
        return naivePercentEncode(queryValue); //FIXME use minimal encoder
    }

    public static String encodeFragment(String fragment) {
        return naivePercentEncode(fragment); //FIXME use minimal encoder
    }
}
