package com.brightcove.johnny.parts;

import java.util.List;

import com.brightcove.johnny.Paths;

/**
 * A parser for URL path components. Empty segments will be removed and
 * relative segments ("." and "..") will be cancelled out. Trailing slashes
 * will be dropped.
 */
public class TextPathParser {

    /** Shared instance of path parser. */
    public static final TextPathParser INSTANCE = new TextPathParser();

    /**
     * Parse an undecoded path from a URL into a possibly-empty series of decoded path segments.
     * @param pathRaw Raw path component of a URL (not null, may be empty, must start with "/")
     * @return Sequence of decoded path components suitable for adding to a {@link TextPath}.
     */
    public List<String> parse(String pathRaw) {
        if (pathRaw == null) {
            throw new NullPointerException("Raw path must not be null.");
        }
        return Paths.decode(pathRaw);
    }
}
