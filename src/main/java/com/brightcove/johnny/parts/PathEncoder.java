package com.brightcove.johnny.parts;

import java.util.Map;

import com.brightcove.johnny.http.Codecs;

/**
 * Encoder for {@link Path}s.
 */
public class PathEncoder {

    /**
     * Encode a {@link Path} into a raw path string.
     * @param path Nullable.
     * @return Raw path string starting with "/".
     */
    public String unparse(Path path) {
        if (path == null || path.getSegments() == null || path.getSegments().isEmpty()) {
            return "/";
        }
        StringBuilder ret = new StringBuilder();
        for (PathSegment seg : path.getSegments()) {
            ret.append('/').append(Codecs.encodePathSegment(seg.text));
            unparseSegment(seg, ret);
        }
        return ret.toString();
    }

    protected void unparseSegment(PathSegment segment, StringBuilder ret) {
        for (Map.Entry<String, String> pair : segment.params.getPairs()) {
            ret.append(';').append(Codecs.encodePathParamKey(pair.getKey()));
            if (pair.getValue() != null) {
                ret.append('=').append(Codecs.encodePathParamValue(pair.getValue()));
            }
        }
    }

    protected String unparseSegment(PathSegment segment) {
        StringBuilder ret = new StringBuilder();
        unparseSegment(segment, ret);
        return ret.toString();
    }
}
