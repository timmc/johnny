package com.brightcove.johnny.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Codecs {

    /*== Decoders ==*/

    /**
     * Naïvely decode a percent-encoded string. This is generally not safe
     * to perform on a path, query, or user info component, since it may
     * expose spurious delimiters. For example, using this to decode the path
     * <code>/one%2Fpart</code> will produce <code>/one/part</code>, which is
     * certainly not correct. Instead, use a component-specific decoder.
     */
    //TODO: List component-specific decoders.
    public static String percentDecode(String part) {
        if (part == null) {
            return ""; // TODO Correct behavior?
        } else {
            try {
                return URLDecoder.decode(part, "UTF-8");
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("Unexpected decoding exception: UTF-8 not available?");
            }
        }
    }

    /*== Encoders ==*/

    /** Naively percent-encode for inclusion in any portion of a URL. */
    private static String naivePercentEncode(String part) {
        if (part == null) {
            return ""; // TODO Correct behavior?
        } else {
            try {
                return URLEncoder.encode(part, "UTF-8");
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("Unexpected encoding exception: UTF-8 not available?");
            }
        }
    }

    /**
     * Minimally encode username portion of HTTP URL.
     */
    public static String encodeUsername(String username) {
        return naivePercentEncode(username); //FIXME use minimal encoder
    }

    /**
     * Minimally encode password portion of HTTP URL.
     */
    public static String encodePassword(String password) {
        return naivePercentEncode(password); //FIXME use minimal encoder
    }

    /**
     * Minimally encode path portion of HTTP URL.
     */
    public static String encodePathSegment(String pathSegment) {
        return naivePercentEncode(pathSegment); //FIXME use minimal encoder
    }

    /**
     * Minimally encode path parameter key for an HTTP URL.
     */
    public static String encodePathParamKey(String pathParamKey) {
        return naivePercentEncode(pathParamKey); //FIXME use minimal encoder
    }

    /**
     * Minimally encode path parameter value for an HTTP URL.
     */
    public static String encodePathParamValue(String pathParamValue) {
        return naivePercentEncode(pathParamValue); //FIXME use minimal encoder
    }

    /**
     * Minimally encode query parameter key for an HTTP URL.
     */
    public static String encodeQueryKey(String queryKey) {
        return naivePercentEncode(queryKey); //FIXME use minimal encoder
    }

    /**
     * Minimally encode query parameter value for an HTTP URL.
     */
    public static String encodeQueryValue(String queryValue) {
        return naivePercentEncode(queryValue); //FIXME use minimal encoder
    }

    /**
     * Minimally encode fragment portion of HTTP URL.
     */
    public static String encodeFragment(String fragment) {
        return naivePercentEncode(fragment); //FIXME use minimal encoder
    }
}
