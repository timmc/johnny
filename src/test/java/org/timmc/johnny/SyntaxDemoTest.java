package org.timmc.johnny;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/** Demonstrate basic usage. */
public class SyntaxDemoTest {

    /*
     * NOTICE: All the real tests are in src/main/clojure -- this is just
     * a demo.
     */

    /*
     * Also note that these tests are fragile to hashing order -- they'd need
     * to be rewritten for anything beyond a demo.
     */

    /**
     * Demonstrate setter workflow.
     */
    @Test
    public void testWorkflow() throws UrlDecodeException {
        HostedUri result = Urls.parse("http://brightcove.com/login?email=jrh@example.net")
                         .withPort(8443)
                         .withScheme("https")
                         .querySetKey("unicode", "☃");
        assertEquals("https://brightcove.com:8443/login?email=jrh%40example.net&unicode=%E2%98%83", result.format());
    }

    /**
     * Demonstrate query manipulation.
     */
    @Test
    public void testQS() throws UrlDecodeException {
        HostedUri orig = Urls.parse("http://brightcove.com/login?a=b=c&a=?d");
        HostedUri result = orig.withQuery(orig.getQuery()
                                        .append("foo", "bar")
                                        .replace("a", null));
        assertTrue(Arrays.<String>asList(
                "http://brightcove.com/login?foo=bar&a",
                "http://brightcove.com/login?a&foo=bar"
                ).contains(result.format()));
    }

    /**
     * Demonstrate construction with structured components.
     */
    @Test
    public void testConstruction() {
        HostedUri u = Urls.from("https", new RegNameHost("brightcove.com"))
            .withPath(Paths.from("v1", "api", "123"))
            .withQuery(Queries.from("foo", "bar"));
        assertEquals(u.format(), "https://brightcove.com/v1/api/123?foo=bar");
    }
}
