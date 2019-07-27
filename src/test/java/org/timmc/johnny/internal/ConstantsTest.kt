package org.timmc.johnny.internal

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ConstantsTest {
    @Test
    fun bitsets() {
        assertEquals(128, Constants.ASCII.cardinality())
        assertEquals(32, Constants.ASCII_C0.cardinality())
        assertEquals(33, Constants.ASCII_CONTROL.cardinality())
        assertFalse(Constants.ASCII_CONTROL.intersects(Constants.ASCII_PRINTABLE))
        assertEquals(charsToIntSet(('a'..'z').plus('A'..'Z').plus('0'..'9')),
            Constants.ASCII_ALPHANUMERIC.toSet())

        // I don't actually remember where I was going with this
        assertEquals(charsToIntSet(" \"%<>\\^`{|}".toCharArray().toList()),
            Constants.ASCII_PRINTABLE
                .andNot(Constants.RFC3986_RESERVED)
                .andNot(Constants.RFC3986_UNRESERVED)
                .toSet())
    }

    fun charsToIntSet(chars: List<Char>): Set<Int> {
        return chars.map { it.toInt() }.toSet()
    }
}
