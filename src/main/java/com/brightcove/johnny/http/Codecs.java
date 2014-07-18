package com.brightcove.johnny.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Encoders and decoders for HTTP land.
 */
public class Codecs {

    /*== Decoders ==*/

    /**
     * Naïvely decode a percent-encoded string. This is generally not safe
     * to perform on an entire path, query, or user info component, since it may
     * expose spurious delimiters. For example, using this to decode the path
     * <code>/one%2Fpart</code> will produce <code>/one/part</code>, which is
     * certainly not correct. Instead, use a component-specific decoder.
     * @param part Nullable
     * @return Percent-decoded string, or null if input was null
     */
    //TODO: List component-specific decoders.
    public static String percentDecode(String part) {
        if (part == null) {
            return null;
        } else {
            try {
                return URLDecoder.decode(part.replace("+", "%2B"), "UTF-8");
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("Unexpected decoding exception: UTF-8 not available?");
            }
        }
    }
}
