package org.timmc.johnny.internal;

/**
 * Represents a set of characters, either positive or negative.
 * (Does not provide a way to characterize or enumerate the set.)
 */
interface CharOracle {
    /** True iff set contains the character. */
    fun containsChar(c: Char): Boolean

    /** True iff set contains the code point. */
    fun containsCodePoint(cp: Int): Boolean
}
