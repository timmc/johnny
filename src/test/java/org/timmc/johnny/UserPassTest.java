package org.timmc.johnny;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserPassTest {
    @Test
    public void hasPassword() {
        assertTrue(new UserPass("username", "password").hasPassword());
        assertTrue(new UserPass("username", "").hasPassword());
        assertFalse(new UserPass("username", null).hasPassword());
        assertFalse(new UserPass("username").hasPassword());
    }
}
