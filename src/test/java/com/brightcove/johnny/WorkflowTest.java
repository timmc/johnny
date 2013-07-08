package com.brightcove.johnny;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

/**
 * Test standard workflows.
 */
public class WorkflowTest {

    @Test
    public void testReadmeExample() throws MalformedURLException {
        WebUrl actual = WebUrl.from("http://google.com/search?q=url#fragment")
                              .withHost("brightcove.com")
                              .addQueryParam("foo", "bar");
        assertEquals("http://brightcove.com/search?q=url&foo=bar#fragment", actual.toString());
    }

}
