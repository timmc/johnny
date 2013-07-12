package com.brightcove.johnny.http;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

/** Demonstrate basic usage. */
public class SyntaxDemoTest {

    /**
     * Demonstrate setter workflow.
     */
    @Test
    public void testWorkflow() throws MalformedURLException {
        // NOTICE: All the real tests are in src/main/clojure -- this is just a demo.
        Url orig = Urls.parse("http://brightcove.com/login?email=jrh@example.net");
        Url actual = orig.withPort(8443).withProtocol("https").querySetKey("unicode", "☃");
        assertEquals("https://brightcove.com:8443/login?email=jrh%40example.net&unicode=%E2%98%83", actual.unparse());
    }

}
