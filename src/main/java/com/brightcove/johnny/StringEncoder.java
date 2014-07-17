package com.brightcove.johnny;

/** Generic encoder: A function of strings to strings. */
public interface StringEncoder {
    /** Encode the non-null input string to a non-null output string. */
    String encode(String in);
    //TODO: Also support Reader in/out?
}
