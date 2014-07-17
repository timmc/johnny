package com.brightcove.johnny;

/**
 * Represents a set of characters, either positive or negative.
 * (Does not provide a way to characterize or enumerate the set.)
 */
public interface CharOracle {
    /** True iff set contains the character. */
    boolean containsChar(char c);

    /** True iff set contains the code point. */
    boolean containsCodePoint(int cp);
}
