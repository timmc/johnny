package org.timmc.johnny.internal

import org.timmc.johnny.UrlDecodeException

import java.io.UnsupportedEncodingException
import java.net.URLDecoder

/**
 * Encoders and decoders needed internally by Johnny.
 */
object Codecs {

    internal val urlParser: UrlParser =
        if (System.getProperty("org.timmc.johnny.Urls.testing.altParser") == "true")
            // Hand-written parser, only used in testing. Use in tests:
            // mvn test -DargLine="-Dorg.timmc.johnny.Urls.testing.altParser=true"
            SchemeSpecificUriParser()
        else
            // Default, uses grammar from RFCs
            AntlrUriParser()

    private val fragEnc = ByCharPercentEncoder(Ascii7Oracle(Constants.RFC3986_UNENCODED_FRAGMENT))
    private val zoneEnc = ByCharPercentEncoder(Ascii7Oracle(Constants.RFC6874_UNENCODED_ZONE))

    /*== Decoders ==*/

    /**
     * Naïvely decode a percent-encoded string. This is generally not safe
     * to perform on an entire path, query, or user info component, since it may
     * expose spurious delimiters. For example, using this to decode the path
     * `/one%2Fpart` will produce `/one/part`, which is
     * certainly not correct. Instead, use the appropriate component-specific parser.
     * @param part Some percent-encoded string (non-null)
     * @return Percent-decoded string (non-null)
     * @throws UrlDecodeException if there are invalid percent-escapes
     */
    @JvmStatic
    @Throws(UrlDecodeException::class)
    fun percentDecode(part: String): String {
        try {
            return URLDecoder.decode(part.replace("+", "%2B"), "UTF-8")
        } catch (uee: UnsupportedEncodingException) {
            throw RuntimeException("Unexpected decoding exception: UTF-8 not available?")
        } catch (iae: IllegalArgumentException) {
            throw UrlDecodeException("Could not percent-decode URL component", iae)
        }

    }

    /*== Encoders ==*/

    @JvmStatic
    fun percentEncodeFragment(fragment: String): String {
        return fragEnc.encode(fragment)
    }

    @JvmStatic
    fun percentEncodeIPv6Zone(zone: String): String {
        return zoneEnc.encode(zone)
    }
}
