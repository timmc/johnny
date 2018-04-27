package org.timmc.johnny.parts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.timmc.johnny.Paths;
import org.timmc.johnny.UrlDecodeException;
import org.timmc.johnny.Urls;
import org.timmc.johnny.Paths.PathEffect;

/**
 * The path component of a URL, consisting of a possibly-empty series of
 * decoded segments. For example, the path <code>/foo/bar/ba%2fz/</code>
 * contains the segments <code>["foo", "bar", "ba/z", ""]</code>.
 * <p>
 * TextPath will attempt to keep itself in normalized form.
 * <p>
 * This implementation of path parsing does *not* respect path parameters.
 */
public class TextPath {

    /** A non-null sequence of non-null, non-empty Strings. */
    private final List<String> segments;

    /** Empty path instance. */
    public static final TextPath EMPTY = new TextPath();

    /**
     * Assumes segments is normalized and non-null.
     * The {@link Void} arg is to distinguish the constructor signature.
     */
    private TextPath(List<String> segments, Void _unused) {
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
        this(Collections.<String> emptyList(), null);
    }

    /** Normalize (if necessary). */
    private static List<String> normComponent(List<String> input) {
        if (input == null) { throw new NullPointerException("segments may not be null"); }
        if (!Paths.isNormalized(input)) {
            return Paths.normalize(input);
        }
        return input;
    }

    /**
     * Get the sequence of segments in this path. For a path
     * <code>/foo/bar</code>, this would be <code>["foo", "bar"]</code>.
     * @return Non-null, possibly empty normalized sequence of non-null
     *  segments.
     */
    public List<String> getSegments() {
        return segments;
    }

    private TextPath applyEffect(PathEffect effect) {
        List<String> build = new ArrayList<String>(segments);
        if (effect.absolute) { // won't happen here
            build = new ArrayList<String>(effect.added);
        } else {
            if (effect.backwards > 0) {
                int lastIndex = build.size() - 1;
                int truncateTo = build.size() - effect.backwards;
                for (int i = lastIndex; i >= truncateTo; i++) {
                    build.remove(i);
                }
            }
            for (String addl : effect.added) {
                build.add(addl);
            }
        }
        return new TextPath(build, null);
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
    public TextPath addRawPath(String rawRelative) throws UrlDecodeException {
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
        return Urls.DEFAULT_CODECS.pathFormatter.format(getSegments());
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
