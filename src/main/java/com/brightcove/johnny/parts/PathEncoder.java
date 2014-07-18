package com.brightcove.johnny.parts;

import com.brightcove.johnny.Encoder;

/**
 * Encoder for {@link Path}s.
 */
public interface PathEncoder<E> {
    /**
     * Encode a {@link Path} into a raw path string.
     * @param path Not null.
     * @return Raw path string, either empty or starting with "/".
     */
    String unparse(Path<E> path, Encoder<E> segmentEncoder);
}
