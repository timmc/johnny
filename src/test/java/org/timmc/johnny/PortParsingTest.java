package org.timmc.johnny;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PortParsingTest {
    @Test
    void basic() {
        HostedUri uri = Urls.parse("http://example.com:8080/path");
        assertEquals("8080", uri.getPortRaw());
        assertEquals(8080, (int) uri.getPort());
        assertEquals("http://example.com:8080/path", uri.format());
    }

    // TODO: Test what happens with giant port numbers (e.g. greater than
    // Long/MAX_VALUE) in URI vs. HttpUrl parsing (latter should limit to
    // [0,65535])

    @Test
    void asLowAsZero() {
        // TODO Revisit: Is a zero port acceptable?
        HostedUri uri = Urls.parse("http://example.com:0/path");
        assertEquals("0", uri.getPortRaw());
        assertEquals(0, (int) uri.getPort());
        assertEquals("http://example.com:0/path", uri.format());
    }

    // TODO Port number with giant numeric sequence

    @Test
    void asHighAsMaxInt() {
        // TODO Revisit: Is a port value over 65535 acceptable?
        HostedUri uri = Urls.parse("http://example.com:2147483647/path");
        assertEquals("2147483647", uri.getPortRaw());
        assertEquals(Integer.MAX_VALUE, (int) uri.getPort());
        assertEquals("http://example.com:2147483647/path", uri.format());
    }

    /** Strip leading zeroes, and parse in decimal */
    @Test
    void zeroNormalization() {
        HostedUri uri = Urls.parse("http://example.com:0020/path");
        assertEquals("0020", uri.getPortRaw());
        assertEquals(20, (int) uri.getPort());
        // TODO assertEquals("http://example.com:20/path", uri.format());
    }

    /** Scheme-based normalization of default port numbers */
    @Test
    void defaultPortNormalization() {
        // RFC 3986 §3.2.3: URI producers and normalizers should omit the
        // port component and its ":" delimiter if port is empty or if its
        // value would be the same as that of the scheme's default.
        HostedUri empty = Urls.parse("http://example.com:/path");
        assertEquals("", empty.getPortRaw());
        assertNull(empty.getPort());
        assertEquals("http://example.com/path", empty.format());

        HostedUri missing = Urls.parse("http://example.com/path");
        assertNull(missing.getPortRaw());
        assertNull(missing.getPort());
        assertEquals("http://example.com/path", missing.format());

        // TODO: Test that ports 80 and 443 are omitted when formatting
        // http and https URIs, respectively. Maybe other common
        // protocols? Or do we skip that?
    }
}
