package com.brightcove.johnny.http;

import com.brightcove.johnny.parts.Parser;

public interface PathSegmentParser<E> extends Parser<E> {
    public E parse(String segmentRaw);
}
