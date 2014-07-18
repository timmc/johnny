package com.brightcove.johnny.http;

import com.brightcove.johnny.parts.Parser;

public class TextPathSegmentParser implements Parser<String> {

    public static final TextPathSegmentParser INSTANCE = new TextPathSegmentParser();

    public String parse(String segmentRaw) {
        return Codecs.percentDecode(segmentRaw);
    }
}
