package com.brightcove.johnny.parts;

import java.util.Collection;

/**
 * A parser for URL path components. Implementations may handle empty segments
 * (e.g. in "/foo//bar") and path parameters ("/foo;page=5/bar") as they wish.
 */
public interface PathParser<E> {
    /**
     * Parse an undecoded path from a URL into a possibly-empty series of path segments.
     * @param pathRaw Raw path component of a URL (not null, may be empty, should start with "/")
     */
    public Collection<E> parse(String pathRaw);
}
