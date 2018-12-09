package org.timmc.johnny.internal

/**
 * Character set that is limited to 7-bit ASCII. Immutable.
 *
 * Implementation note: This class exists to bridge ImmutableBitSet and
 * CharOracle while deferring the question of how to handle Unicode
 * surrogate pairs. (FIXME)
 */
class Ascii7Oracle
/**
 * Create a char set including the indexes of all the set bits in the input.
 * @throws IllegalArgumentException if any characters are outside of 7-bit ASCII
 */
constructor (
    /**
     * Actual backing bitset, where the index of each set bit corresponds to
     * a Java char included in the char set.
     */
    val backing: ImmutableBitSet
) : CharOracle {
    init {
        validateBitSet(backing)
    }

    /*== Specified by interfaces ==*/

    override fun containsChar(c: Char): Boolean {
        return backing.get(c.toInt())
    }

    override fun containsCodePoint(cp: Int): Boolean {
        return backing.get(cp)
    }

    companion object {
        /** The empty set, for convenience.  */
        @JvmField
        val EMPTY = Ascii7Oracle(ImmutableBitSet.EMPTY)

        private fun validateBitSet(bs: ImmutableBitSet) {
            val bad = bs.nextSetBit(0x80)
            if (bad != -1) {
                throw IllegalArgumentException(
                    String.format("Non-lower-ASCII character provided: U+%06X", bad)
                )
            }
        }
    }
}
