package org.timmc.johnny.internal

import java.util.BitSet

/**
 * Utilities for creating and manipulating bitsets.
 */
object BitSetUtils {

    /**
     * Create a bitset by turning on bits indexed by the int values of
     * chars in the string.
     */
    @JvmStatic
    fun fromChars(included: String): ImmutableBitSet {
        return fromChars(included.toCharArray())
    }

    /**
     * Same as [.fromChars], but directly given a char array.
     */
    @JvmStatic
    fun fromChars(included: CharArray): ImmutableBitSet {
        // TODO: Is there a way to chain to the Iterable version?
        val mutate = BitSet(0)
        for (c in included) {
            mutate.set(c.toInt())
        }
        return ImmutableBitSet(mutate)
    }
}
