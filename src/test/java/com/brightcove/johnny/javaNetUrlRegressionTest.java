package com.brightcove.johnny;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

public class javaNetUrlRegressionTest {

    @Test
    public void testPortNumerics() {
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
