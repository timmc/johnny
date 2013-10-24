package com.brightcove.johnny.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.brightcove.johnny.coll.ClojureHelper;

import clojure.lang.APersistentVector;
import clojure.lang.PersistentVector;

/**
 * A path representation that provides an uninterpreted view of a path string,
 * including per-segment parameters and empty segments.
 */
public class StdPath extends Path {

    /** A reusable empty instance. */
    public static final Path EMPTY = new StdPath();

    /** Possibly-empty collection of {@link PathSegment}. */
    private final APersistentVector segments;

    /** Creates an empty path. It is preferable to reuse {@link #EMPTY}. */
    public StdPath() {
        this(PersistentVector.EMPTY);
    }

    private StdPath(APersistentVector segments) {
        this.segments = segments;
    }

    @SuppressWarnings("unchecked")
    public List<PathSegment> getSegments() {
        return segments;
    }

    @SuppressWarnings("unchecked")
    public List<String> getSegmentsText() {
        List<String> ret = new ArrayList<String>();
        for (PathSegment seg : (Collection<PathSegment>) segments) {
            ret.add(seg.text);
        }
        return Collections.unmodifiableList(ret);
    }

    public StdPath addSegments(Iterable<PathSegment> more) {
        return new StdPath(ClojureHelper.into(segments, more.iterator()));
    }
}
