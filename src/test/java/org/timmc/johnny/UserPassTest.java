package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserPassTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
        // Normal cases
        "foo|foo|", "foo:bar|foo|bar",
        // Only first colon is used for splitting
        "foo:bar:baz|foo|bar:baz", "::::|''|:::",
        // Degenerate cases
        "''|''|", ":|''|''", // '' is empty string
        // Decoding is done after splitting
        "%25|%|", "ab%3Acd:ef%3Agh:ij|ab:cd|ef:gh:ij",
        // UTF-8 assumed
        "%E0%A5%AE:%E0%A5%AF|\u096e|\u096f",
        // Minimal encoding (note pass is user + colon)
        "-._~!$&'()*+,;=:-._~!$&'()*+,;=:|-._~!$&'()*+,;=|-._~!$&'()*+,;=:"
    })
    void parsing(String input, String expectedUser, String expectedPass) {
        assertEquals(new UserPass(expectedUser, expectedPass),
            Urls.parse("http://" + input + "@localhost").getUserPass());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
        // Normal cases
        "foo||foo", "foo|bar|foo:bar",
        // Encoding is done before concatenation
        "%||%25", "ab:cd|ef:gh:ij|ab%3Acd:ef:gh:ij",
        // Subsequent colons not encoded
        "foo|bar:baz|foo:bar:baz", "''|:::|::::",
        // Degenerate cases
        "''||''", "''|''|:", // '' is empty string
        // UTF-8 assumed
        "\u096e|\u096f|%E0%A5%AE:%E0%A5%AF",
        // Minimal encoding (note pass is user + colon)
        "-._~!$&'()*+,;=|-._~!$&'()*+,;=:|-._~!$&'()*+,;=:-._~!$&'()*+,;=:"
    })
    void formatting(String user, String pass, String expectedUserinfo) {
        assertEquals("http://" + expectedUserinfo + "@localhost",
            Urls.from("http", new RegNameHost("localhost"))
                .withUserPass(new UserPass(user, pass))
                .format());
    }

    @Test
    void hasPassword() {
        assertTrue(new UserPass("username", "password").hasPassword());
        assertTrue(new UserPass("username", "").hasPassword());
        assertFalse(new UserPass("username", null).hasPassword());
        assertFalse(new UserPass("username").hasPassword());
    }

    @Test
    void equality() {
        assertEquals(new UserPass("foo", "bar"), new UserPass("foo", "bar_".substring(0, 3)));
        assertEquals(new UserPass("foo", null), new UserPass("foo"));
        // empty is not null
        assertNotEquals(new UserPass("foo", ""), new UserPass("foo", null));
    }
}
