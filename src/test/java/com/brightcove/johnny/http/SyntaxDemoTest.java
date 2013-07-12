package com.brightcove.johnny.http;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

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
    public void testWorkflow() throws MalformedURLException {
        Url result = Urls.parse("http://brightcove.com/login?email=jrh@example.net")
                         .withPort(8443)
                         .withProtocol("https")
                         .querySetKey("unicode", "☃");
        assertEquals("https://brightcove.com:8443/login?email=jrh%40example.net&unicode=%E2%98%83", result.unparse());
    }

    /**
     * Demonstrate query manipulation.
     */
    @Test
    public void testQS() throws MalformedURLException {
        Url orig = Urls.parse("http://brightcove.com/login?a=b=c&a=?d");
        Url result = orig.withQuery(orig.getQuery()
                                        .append("foo", "bar")
                                        .replace("a", null));
        assertEquals("http://brightcove.com/login?a&foo=bar", result.unparse());
    }
}
