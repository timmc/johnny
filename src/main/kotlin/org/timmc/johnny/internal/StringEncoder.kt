package org.timmc.johnny.internal

/** Generic encoder: A function of strings to strings.  */
interface StringEncoder {
    /** Encode the non-null input string to a non-null output string.  */
    fun encode(input: String): String
    //TODO: Also support Reader in/out?
}
