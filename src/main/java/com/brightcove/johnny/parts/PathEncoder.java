package com.brightcove.johnny.parts;

/**
 * Encoder for {@link Path}s.
 */
public interface PathEncoder {
    /**
     * Encode just one segment of a path to its raw form.
     * @param segment Non-null.
     * @return Raw path segment. Must not contain any "/" characters.
     */
    String unparseSegment(PathSegment segment);

    /**
     * Encode a {@link Path} into a raw path string.
     * @param path Not null.
     * @return Raw path string, either empty or starting with "/".
     */
    String unparse(Path path);
}
