package org.timmc.johnny;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Encoders and decoders needed internally by Johnny.
 */
public class Codecs {

    private static final StringEncoder fragEnc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_FRAGMENT));
    private static final StringEncoder zoneEnc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC6874_UNENCODED_ZONE));

    /*== Decoders ==*/

    /**
     * Naïvely decode a percent-encoded string. This is generally not safe
     * to perform on an entire path, query, or user info component, since it may
     * expose spurious delimiters. For example, using this to decode the path
     * <code>/one%2Fpart</code> will produce <code>/one/part</code>, which is
     * certainly not correct. Instead, use the appropriate component-specific parser.
     * @param part Some percent-encoded string (non-null)
     * @return Percent-decoded string (non-null)
     * @throws UrlDecodeException if there are invalid percent-escapes
     */
    public static String percentDecode(String part) throws UrlDecodeException {
        try {
            return URLDecoder.decode(part.replace("+", "%2B"), "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Unexpected decoding exception: UTF-8 not available?");
        } catch (IllegalArgumentException iae) {
            throw new UrlDecodeException("Could not percent-decode URL component", iae);
        }
    }

    /*== Encoders ==*/

    public static String percentEncodeFragment(String fragment) {
        return fragEnc.encode(fragment);
    }

    public static String percentEncodeIPv6Zone(String zone) { return zoneEnc.encode(zone); }
}
