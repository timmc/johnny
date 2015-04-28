package org.timmc.johnny;

/**
 * Character set that is limited to 7-bit ASCII. Immutable.
 *
 * Implementation note: This class exists to bridge ImmutableBitSet and
 * CharOracle while deferring the question of how to handle Unicode
 * surrogate pairs. (FIXME)
 */
public class Ascii7Oracle implements CharOracle {

    /** The empty set, for convenience (and preferable to {@link #Ascii7Oracle()}.) */
    public static final Ascii7Oracle EMPTY = new Ascii7Oracle();

    /**
     * Actual backing bitset, where the index of each set bit corresponds to
     * a Java char included in the char set.
     */
    public final ImmutableBitSet backing;

    /*== Constructors ==*/

    /**
     * Create an empty set. Prefer {@link Ascii7Oracle#EMPTY}.
     */
    public Ascii7Oracle() {
        this(ImmutableBitSet.EMPTY);
    }

    /**
     * Create a char set including the indexes of all the set bits in the input.
     * @throws IllegalArgumentException if any characters are outside of 7-bit ASCII
     */
    public Ascii7Oracle(ImmutableBitSet included) {
        validateBitSet(included);
        this.backing = included;
    }

    private static void validateBitSet(ImmutableBitSet bs) {
        int bad = bs.nextSetBit(0x80);
        if (bad != -1) {
            throw new IllegalArgumentException(
                    String.format("Non-lower-ASCII character provided: U+%06X", bad));
        }
    }

    /*== Specified by interfaces ==*/

    public boolean containsChar(char c) {
        return backing.get((int) c);
    }

    public boolean containsCodePoint(int cp) {
        return backing.get(cp);
    }
}
