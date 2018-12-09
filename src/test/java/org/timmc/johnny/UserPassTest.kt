package org.timmc.johnny

import org.junit.Assert.*
import org.junit.Test

class UserPassTest {
    @Test
    fun hasPassword() {
        assertTrue(UserPass("username", "password").hasPassword())
        assertTrue(UserPass("username", "").hasPassword())
        assertFalse(UserPass("username", null).hasPassword())
        assertFalse(UserPass("username").hasPassword())
    }
}
