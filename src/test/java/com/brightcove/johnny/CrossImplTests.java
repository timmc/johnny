package com.brightcove.johnny;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

public class CrossImplTests {

    /**
     * Example from http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding
     */
    @Test
    public void testDifferentialPlusEncoding() throws MalformedURLException {
        String original = "http://example.com/blue+light%20blue?blue%2Blight+blue";
        HttpUrl decoded = HttpUrls.from(original);
        //TODO: pending path and QS decoding
    }

    /**
     * Example from http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding
     * @throws MalformedURLException
     */
    @Test
    public void testLunatechMinimality() throws MalformedURLException {
        String original = "http://example.com/:@-._~!$&'()*+,=;:@-._~!$&'()*+,=:@-._~!$&'()*+,==?/?:@-._~!$'()*+,;=/?:@-._~!$'()*+,;==#/?:@-._~!$&'()*+,;=";
        assertEquals(original, HttpUrls.from(original).unparse());
    }

    /** Regression test against {@link java.net.URL}. */
    @Test
    public void testPortAlternativeNumerics() {
        String template = "http://google.com:%s/";
        String latin = "80";
        String devanagari = "\u096E\u0966"; // ८०
        try {
            HttpUrls.from(String.format(template, latin));
        } catch (MalformedURLException murle) {
            fail("Latin-port should have worked");
        }
        try {
            HttpUrls.from(String.format(template, devanagari));
            fail("Devanagari-port should have failed");
        } catch (MalformedURLException murle) {
            // expected
        }
    }
}
