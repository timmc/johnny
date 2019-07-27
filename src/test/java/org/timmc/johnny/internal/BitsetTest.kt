package org.timmc.johnny.internal

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

// TODO generative testing for behavioral equivalency to j.u.BitSet

class BitsetTest {
    private fun elements(bs: ImmutableBitSet): List<Int> {
        return bs.iterator().asSequence().toList()
    }

    private val e = ImmutableBitSet.EMPTY

    @Test
    fun `base case`() {
        assertTrue(e.isEmpty())
        assertEquals(0, e.length())
        assertEquals(0, e.cardinality())
        assertEquals(false, e.get(5))
        assertEquals(e, e.get(20, 30))
        assertEquals(e.set(3), e.flip(3))
        assertEquals(e.set(3, true), e.flip(3))
        assertEquals(e, e.set(3, false))
        assertEquals(e, e.clear(3))
        assertEquals(e.set(3, 5), e.flip(3, 5))
        assertEquals(e.set(3, 5, true), e.flip(3, 5))
        assertEquals(e, e.set(3, 5, false))
        assertEquals(e, e.clear(3, 5))
        assertEquals(e, e.clear())
        assertEquals(e, e.and(e))
        assertEquals(e, e.or(e))
        assertEquals(e, e.andNot(e))
        assertEquals(e, e.xor(e))
        assertFalse(e.intersects(e))
        assertEquals(emptyList(), elements(e))
        assertEquals(-1, e.nextSetBit(0))
        assertEquals(0, e.nextClearBit(0))
    }

    @Test
    fun `solid run`() {
        val ten = e.set(0, 10)

        assertFalse(ten.isEmpty())
        assertEquals(10, ten.length())
        assertEquals(10, ten.cardinality())
        assertEquals(true, ten.get(5))
        assertEquals(e.set(0, 3), ten.get(7, 15))
        assertEquals(e.set(0, 3).or(e.set(4, 10)), ten.flip(3))
        assertEquals(e.set(0, 3).or(e.set(4, 10)), ten.set(3, false))
        assertEquals(e.set(0, 3).or(e.set(4, 10)), ten.clear(3))
        assertEquals(e.set(0, 3).or(e.set(5, 10)), ten.flip(3, 5))
        assertEquals(e.set(0, 3).or(e.set(5, 10)), ten.set(3, 5, false))
        assertEquals(e.set(0, 3).or(e.set(5, 10)), ten.clear(3, 5))
        assertEquals(e.set(0, 11), ten.flip(10))
        assertEquals(e.set(0, 11), ten.set(10))
        assertEquals(e.set(0, 11), ten.set(10, true))
        assertEquals(e, ten.clear())
        assertEquals(ten, ten.and(ten))
        assertEquals(ten, ten.or(ten))
        assertEquals(e, ten.andNot(ten))
        assertEquals(e, ten.xor(ten))
        assertTrue(ten.intersects(ten))
        assertFalse(ten.intersects(e.set(50)))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), elements(ten))
        assertEquals(0, ten.nextSetBit(0))
        assertEquals(10, ten.nextClearBit(0))
    }

    @Test
    fun `more interesting`() {
        val ten = e.set(0, 10)
        val fives = e.set(5).set(10).set(15)

        assertEquals(listOf(5), elements(ten.and(fives)))
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15), elements(ten.or(fives)))
        assertEquals(listOf(0, 1, 2, 3, 4,    6, 7, 8, 9), elements(ten.andNot(fives)))
        assertEquals(listOf(0, 1, 2, 3, 4,    6, 7, 8, 9, 10, 15), elements(ten.xor(fives)))
        assertTrue(ten.intersects(fives))
    }

    @Test
    fun `object overrides`() {
        val ten = e.set(0, 10)

        assertEquals(ten.hashCode(), e.set(0, 5).set(5, 10).hashCode())
        assertNotEquals(ten.hashCode(), e.set(0, 9).hashCode())
        assertEquals(ten, ten.clone())
    }

    @Test
    fun `char utils`() {
        assertEquals(e, BitSetUtils.fromChars(""))
        assertEquals(e.set(0), BitSetUtils.fromChars("\u0000"))
        assertEquals(e.set(0x20).set(0x2120), BitSetUtils.fromChars(" ℠"))

        assertEquals(e, BitSetUtils.fromChars(CharArray(0)))
        assertEquals(e.set(0x68).set(0x65).set(0x6c).set(0x6f),
            BitSetUtils.fromChars("hello".toCharArray()))

        // TODO: Test surrogate pairs, or leave unspecified?
    }
}
