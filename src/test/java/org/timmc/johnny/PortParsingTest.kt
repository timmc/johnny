package org.timmc.johnny

import org.junit.Test
import kotlin.test.assertEquals

class PortParsingTest {
    @Test
    fun basic() {
        val uri = Urls.parse("http://example.com:8080/path")
        assertEquals("8080", uri.portRaw)
        assertEquals(8080, uri.port)
        assertEquals("http://example.com:8080/path", uri.format())
    }

    // TODO: Test what happens with giant port numbers (e.g. greater than
    // Long/MAX_VALUE) in URI vs. HttpUrl parsing (latter should limit to
    // [0,65535])

    @Test
    fun asLowAsZero() {
        // TODO Revisit: Is a zero port acceptable?
        val uri = Urls.parse("http://example.com:0/path")
        assertEquals("0", uri.portRaw)
        assertEquals(0, uri.port)
        assertEquals("http://example.com:0/path", uri.format())
    }

    @Test
    fun asHighAsMaxInt() {
        // TODO Revisit: Is a port value over 65535 acceptable?
        val uri = Urls.parse("http://example.com:2147483647/path")
        assertEquals("2147483647", uri.portRaw)
        assertEquals(Int.MAX_VALUE, uri.port)
        assertEquals("http://example.com:2147483647/path", uri.format())
    }

    /** Strip leading zeroes, and parse in decimal */
    @Test
    fun zeroNormalization() {
        val uri = Urls.parse("http://example.com:0020/path")
        assertEquals("0020", uri.portRaw)
        assertEquals(20, uri.port)
        // TODO assertEquals("http://example.com:20/path", uri.format())
    }

    /** Scheme-based normalization of default port numbers */
    @Test
    fun defaultPortNormalization() {
        // RFC 3986 §3.2.3: URI producers and normalizers should omit the
        // port component and its ":" delimiter if port is empty or if its
        // value would be the same as that of the scheme's default.
        val empty = Urls.parse("http://example.com:/path")
        assertEquals("", empty.portRaw)
        assertEquals(null, empty.port)
        assertEquals("http://example.com/path", empty.format())

        val missing = Urls.parse("http://example.com/path")
        assertEquals(null, missing.portRaw)
        assertEquals(null, missing.port)
        assertEquals("http://example.com/path", missing.format())

        // TODO: Test that ports 80 and 443 are omitted when formatting
        // http and https URIs, respectively. Maybe other common
        // protocols? Or do we skip that?
    }
}
