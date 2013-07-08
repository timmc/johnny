package com.brightcove.johnny;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

public class DifferentialEncodingTest {

    /**
     * Example from http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding
     * @throws MalformedURLException 
     */
    @Test
    public void testPlus() throws MalformedURLException {
        String original = "http://example.com/blue+light%20blue?blue%2Blight+blue";
        WebUrl decoded = WebUrl.from(original);
        //TODO: pending path and QS decoding
    }

}
