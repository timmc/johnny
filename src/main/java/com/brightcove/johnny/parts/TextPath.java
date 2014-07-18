package com.brightcove.johnny.parts;

import java.util.Arrays;
import java.util.List;

import clojure.lang.APersistentVector;
import clojure.lang.IPersistentVector;
import clojure.lang.PersistentVector;
import clojure.lang.RT;

import com.brightcove.johnny.Paths;
import com.brightcove.johnny.Paths.PathEffect;
import com.brightcove.johnny.coll.ClojureHelper;
import com.brightcove.johnny.http.Urls;

/**
 * The path component of a URL, consisting of a possibly-empty series of
 * decoded segments. For example, the path <code>/foo/bar/ba%2fz/</code>
 * contains the segments <code>["foo", "bar", "ba/z", ""]</code>.
 * <p>
 * TextPath will attempt to keep itself in normalized form.
 */
public class TextPath {

    /** A non-null sequence of non-null, non-empty Strings. */
    private final APersistentVector segments;

    /** Empty path instance. */
    public static final TextPath EMPTY = new TextPath();

    /**
     * Assumes segments is normalized and non-null.
     * The {@link Void} arg is to distinguish the constructor signature.
     */
    private TextPath(APersistentVector segments, Void _) {
        this.segments = segments;
    }

    /**
     * Create a new TextPath from a list of segments.
     * @param segments Non-null list of non-null decoded segments.
     */
    public TextPath(List<String> segments) {
        this(normComponent(segments), null);
    }

    TextPath() {
        this(PersistentVector.EMPTY, null);
    }

    /** Normalize (if necessary) and cast or convert to {@link APersistentVector}. */
    private static APersistentVector normComponent(Iterable<String> input) {
        if (input == null) { throw new NullPointerException("segments may not be null"); }
        if (!Paths.isNormalized(input)) {
            input = Paths.normalize(input);
        }
        return input instanceof APersistentVector
                ? (APersistentVector) input
                : ClojureHelper.into(PersistentVector.EMPTY, input.iterator());
    }

    /**
     * Get the sequence of segments in this path. For a path
     * <code>/foo/bar</code>, this would be <code>["foo", "bar"]</code>.
     * @return Non-null, possibly empty normalized sequence of non-null
     *  segments.
     */
    @SuppressWarnings("unchecked")
    public List<String> getSegments() {
        return segments;
    }

    private TextPath applyEffect(PathEffect effect) {
        IPersistentVector build = segments;
        if (effect.absolute) { // won't happen here
            build = ClojureHelper.into((APersistentVector) segments.empty(), effect.added.iterator());
        } else {
            if (effect.backwards > 0) {
                build = RT.subvec(build, 0, build.length() - effect.backwards);
            }
            for (String addl : effect.added) {
                build = build.cons(addl);
            }
        }
        return new TextPath((APersistentVector) build, null);
    }

    /**
     * Append the provided (decoded) segments to the path.
     * @param more Nullable collection of non-null segments.
     */
    public TextPath addSegments(Iterable<String> more) {
        return applyEffect(Paths.effectOf(more));
    }

    /**
     * Append or replace with the provided path.
     * @param rawRelative Absolute or relative path.
     */
    public TextPath addRawPath(String rawRelative) {
        return applyEffect(Paths.effectOf(rawRelative));
    }

    /**
     * Append more segments to a path.
     * @param more Further path segments, or null.
     */
    public TextPath addPath(TextPath more) {
        return more == null ? this : addSegments(more.getSegments());
    }

    /**
     * Add one text segment to a path.
     * @param text Text of the path segment (non-null)
     */
    public TextPath addOneSegment(String text) {
        return addSegments(Arrays.asList(text));
    }

    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.pathEncoder.unparse(getSegments());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TextPath)) {
            return false;
        }
        TextPath other = (TextPath) o;
        return segments.equals(other.segments);
    }

    @Override
    public int hashCode() {
        return segments.hashCode();
    }
}
