package com.brightcove.johnny;

/**
 * An encoder of objects to strings.
 * @param <T> The type of object this encoder can handle.
 */
public interface Encoder<T> {
    /** Encode the input to a non-null output string. */
    public String encode(T in);
}