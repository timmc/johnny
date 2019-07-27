package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserPassTest {
    @Test
    public void hasPassword() {
        assertTrue(new UserPass("username", "password").hasPassword());
        assertTrue(new UserPass("username", "").hasPassword());
        assertFalse(new UserPass("username", null).hasPassword());
        assertFalse(new UserPass("username").hasPassword());
    }
}
