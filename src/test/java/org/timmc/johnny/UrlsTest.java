package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Locale;

class UrlsTest {
    @Test
    void schemeChecking() {
        // Hosted URIs
        assertEquals("http", Urls.parse("http://localhost/foo").getScheme());
        assertEquals("https", Urls.parse("https://localhost/foo").getScheme());
        assertEquals("ipns", Urls.parse("ipns://example.com").getScheme());

        // Non-hosted URIs
        assertThrows(UriDecodeException.class, () -> Urls.parse("mailto:foo@example.com?subject=hi"));
        assertThrows(UriDecodeException.class, () -> Urls.parse("tel:1-800-222-1222"));
        assertEquals("mailto", Urls.parseGeneric("mailto:foo@example.com?subject=hi").getSchemeRaw());
        assertEquals("tel", Urls.parseGeneric("tel:1-800-222-1222").getSchemeRaw());

        // RFC 3986:
        //
        // « Scheme names consist of a sequence of characters beginning with a
        // letter and followed by any combination of letters, digits, plus
        // ("+"), period ("."), or hyphen ("-"). »

        // Actual, unusual schemes
        assertEquals("coaps+ws", Urls.parse("coaps+ws://example.org/weather").getScheme());
        assertEquals("h323", Urls.parse("h323://rfc3508.example.org/").getScheme());
        assertEquals("soap.beep", Urls.parse("soap.beep://rfc4227.example.com").getScheme());
        assertEquals("ms-settings", Urls.parseGeneric("ms-settings:screenrotation").getSchemeRaw());

        // Nonexistent schemes are still allowed
        assertEquals("a", Urls.parseGeneric("a://example.net").getSchemeRaw());
        assertEquals("axjm283y2", Urls.parse("aXjm283y2://example.net").getScheme());

        // Invalid
        assertThrows(UriDecodeException.class, () -> Urls.parseGeneric("2spooky://example.net"));
        assertThrows(UriDecodeException.class, () -> Urls.parseGeneric(".net://example.net"));
        assertThrows(UriDecodeException.class, () -> Urls.parseGeneric("http_s://example.net"));
        assertThrows(UriDecodeException.class, () -> Urls.parseGeneric("://example.net"));
        assertThrows(UriDecodeException.class, () -> Urls.parseGeneric("mailtó:foo@example.com"));
    }

    // Scheme is supposed to be case-insensitive
    @Test
    void schemeCase() {
        String ipfsUpperRaw = "IPFS://BAFYBEICZSSCDSBS7FFQZ55ASQDF3SMV6KLCW3GOFSZVWLYARCI47BGF354/";

        HostedUri ipfsUpper = Urls.parse(ipfsUpperRaw);
        assertEquals("IPFS", ipfsUpper.getSchemeRaw());
        assertEquals("ipfs", ipfsUpper.getScheme());
        // Just to show why this raw/parsed distinction matters. Turkish maps I/i case conversions
        // differently from English, so the case-folding happening above
        // could very well produce "ıpfs" instead.
        Locale oldLocale = Locale.getDefault();
        Locale turkish = new Locale("tr", "TR");
        Locale.setDefault(turkish);
        try {
            // Demonstrate that Turkish case-folding is in effect
            assertEquals("\u0131pfs", ipfsUpper.getSchemeRaw().toLowerCase());
            // But johnny still produces the expected result, even under this locale
            assertEquals("ipfs", ipfsUpper.getScheme());
        } finally {
            Locale.setDefault(oldLocale);
        }

        assertEquals("IPFS", Urls.parseGeneric(ipfsUpperRaw).getSchemeRaw());
    }

    @Test
    void construction() {
        assertEquals("http://example.com", Urls.from("http", new RegNameHost("example.com")).format());

        assertThrows(Exception.class, () -> Urls.from("_bad_scheme_", new RegNameHost("example.com")));
    }
}
