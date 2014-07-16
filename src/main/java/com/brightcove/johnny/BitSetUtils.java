package com.brightcove.johnny;

import java.util.BitSet;

/**
 * Utilities for creating and manipulating bitsets.
 */
public class BitSetUtils {

    /**
     * Create a bitset by turning on bits indexed by the int values of chars in the string.
     */
    public static ImmutableBitSet fromChars(String included) {
        return fromChars(included.toCharArray());
    }

    /**
     * Same as {@link #fromChars(String)}, but directly given a char array.
     */
    public static ImmutableBitSet fromChars(char[] included) {
        // TODO: Is there a way to chain to the Iterable version?
        BitSet mutate = new BitSet(0);
        for (char c : included) {
            mutate.set((int) c);
        }
        return new ImmutableBitSet(mutate);
    }

    /**
     * Same as {@link #fromChars(String)}, but given an iterable of Character.
     */
    public static <T extends Iterable<Character>> ImmutableBitSet fromChars(T included) {
        BitSet mutate = new BitSet(0);
        for (Character c : included) {
            mutate.set((int) c);
        }
        return new ImmutableBitSet(mutate);
    }
}
