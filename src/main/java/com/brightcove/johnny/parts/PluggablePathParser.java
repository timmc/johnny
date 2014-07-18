package com.brightcove.johnny.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Parse a path with all features enabled (path parameters, empty segments).
 */
public class PluggablePathParser<E> implements PathParser<E> {

    private final Parser<E> segmentParser;

    public PluggablePathParser(Parser<E> segmentParser) {
        this.segmentParser = segmentParser;
    }

    @SuppressWarnings("unchecked")
    public Collection<E> parse(String pathRaw) {
        if (pathRaw.isEmpty() || pathRaw.equals("/")) {
            return Collections.EMPTY_LIST;
        }
        if (pathRaw.startsWith("/")) {
            pathRaw = pathRaw.substring(1);
        }
        List<E> ret = new ArrayList<E>();
        for (String piece : pathRaw.split("/")) {
            ret.add(segmentParser.parse(piece));
        }
        return Collections.unmodifiableList(ret);
    }
}
