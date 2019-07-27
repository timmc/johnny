package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParseErrorsTest {
    @Test
    public void relativePath() {
        try {
            Urls.parse("/.well-known/robots.txt");
            fail("Expected decode exception for relative URI");
        } catch (UrlDecodeException ude) {
            // do nothing
        }
    }

    @Test
    public void hostlessUri() {
        try {
            Urls.parse("tel:+1-800-222-1222");
            fail("Expected decode exception for hostless URI scheme");
        } catch (UrlDecodeException ude) {
            // do nothing
        }
    }
}
