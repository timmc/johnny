package com.brightcove.johnny.parts;

public interface Parser<T> {
    public T parse(String raw);
}
