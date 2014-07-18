package com.brightcove.johnny.parts;

import java.util.Arrays;
import java.util.List;

import com.brightcove.johnny.Encoder;
import com.brightcove.johnny.http.Urls;

/**
 * The path component of a URL, consisting of a possibly-empty series of
 * segments. Segments may be string or they may be text + parameters.
 * @param <E> Type of segment (usually String)
 */
public abstract class Path<E> {

    /**
     * Get the encoder for the segment type this path is composed of.
     */
    public abstract Encoder<E> getSegmentEncoder();

    /**
     * Get the sequence of segments in this path.
     * @return Non-null, possibly empty collection of non-null values.
     */
    public abstract List<E> getSegments();

    /**
     * Append the provided segments to the path.
     * @param more Nullable collection of non-null segments.
     */
    public abstract Path<E> addSegments(Iterable<E> more);

    /**
     * Append more segments to a path.
     * @param more Further path segments, or null.
     */
    public Path<E> addPath(Path<E> more) {
        return more == null ? this : addSegments(more.getSegments());
    }

    /**
     * Add one text segment to a path.
     * @param segment Path segment (non-null)
     */
    @SuppressWarnings("unchecked")
    public Path<E> addOneSegment(E segment) {
        return addSegments(Arrays.asList(segment));
    }

    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.pathEncoder.unparse(this);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Path)) {
            return false;
        }
        Path other = (Path) o;
        return getSegments().equals(other.getSegments());
    }

    @Override
    public int hashCode() {
        return getSegments().hashCode();
    }
}
