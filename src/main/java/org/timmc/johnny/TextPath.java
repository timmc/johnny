package org.timmc.johnny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.timmc.johnny.internal.Ascii7Oracle;
import org.timmc.johnny.internal.ByCharPercentEncoder;
import org.timmc.johnny.internal.Codecs;
import org.timmc.johnny.internal.Constants;
import org.timmc.johnny.internal.StringEncoder;

/**
 * The path component of a URL, consisting of a series of
 * decoded segments. For example, the path <code>/foo/bar/ba%2fz/</code>
 * contains the segments <code>["foo", "bar", "ba/z"]</code> and has a flag
 * set indicating the trailing slash.
 * <p>
 * TextPath will attempt to keep itself in normalized form.
 * <p>
 * This implementation of path parsing does *not* respect path parameters.
 */
public class TextPath {

    /** Encoder for path segments. */
    private static final StringEncoder SEGMENT_ENCODER =
            new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_PATH_SEGMENT));

    /** Empty path instance. */
    public static final TextPath EMPTY = new TextPath(Collections.<String>emptyList(), false);

    /** A non-null sequence of non-null, non-empty Strings. */
    private final List<String> segments;

    private final boolean trailingSlash;

    /**
     * Create a new TextPath from a list of segments.
     * @param segments Non-null list of non-empty decoded segments.
     * @param trailingSlash True if the last segment is followed by a slash
     *     (also controls presence of slash in empty path)
     */
    private TextPath(List<String> segments, boolean trailingSlash) {
        this.segments = normComponent(segments);
        this.trailingSlash = trailingSlash;
    }

    /**
     * Tell whether this path has a trailing slash or not. In the edge case
     * of a path with no segments, this is the difference between the paths
     * <code>""</code> and <code>"/"</code>.
     */
    public boolean hasTrailingSlash() {
        return trailingSlash;
    }

    /**
     * Change whether there is a trailing slash or not.
     */
    public TextPath withTrailingSlash(boolean newValue) {
        return new TextPath(segments, newValue);
    }

    /**
     * Get the sequence of segments in this path. For a path
     * <code>/foo/bar/</code>, this would be <code>["foo", "bar"]</code>.
     * @return Non-null (possibly empty) normalized sequence of non-empty
     *     segments.
     */
    public List<String> getSegments() {
        return segments;
    }

    /**
     * Append the provided (unencoded) segments to the path. Any traversal
     * segments such as <code>".."</code> will be applied.
     * @param more Nullable collection of non-null segments.
     */
    public TextPath addSegments(List<String> more) {
        if (more.isEmpty()) {
            return this; // leaves trailingSlash alone, too
        } else {
            return applyEffect(effectOf(more))
                .withTrailingSlash(false);
        }
    }

    /**
     * Append or replace with the provided path.
     * @param rawRelative Absolute or relative path.
     */
    public TextPath addRawPath(String rawRelative) throws UrlDecodeException {
        return applyEffect(effectOf(rawRelative));
    }

    /**
     * Append more segments to a path.
     * @param more Further path segments (not null).
     */
    public TextPath addSegments(TextPath more) {
        if (more == null) {
            throw new NullPointerException("Additional TextPath may not be null");
        }
        return addSegments(more.getSegments())
            .withTrailingSlash(more.hasTrailingSlash());
    }

    /**
     * Add one text segment to a path.
     * @param text Text of the path segment (non-null)
     */
    public TextPath addOneSegment(String text) {
        return addSegments(Collections.singletonList(text));
    }

    /**
     * Format path into a normalized raw path string.
     * @return Raw path string, either empty or starting with "/".
     */
    public String format() {
        StringBuilder ret = new StringBuilder();
        for (String seg : segments) {
            ret.append('/').append(SEGMENT_ENCODER.encode(seg));
        }
        if (trailingSlash)
            ret.append('/');
        return ret.toString();
    }

    /*== Internals ==*/

    private TextPath applyEffect(PathEffect effect) {
        if (effect.absolute) {
            return new TextPath(effect.added, effect.hadTrailingSlash);
        } else {
            List<String> build = new ArrayList<String>(segments);

            if (effect.backwards > 0) {
                int newSize = Math.max(0, build.size() - effect.backwards);
                build.subList(0, newSize);
            }

            build.addAll(effect.added);

            boolean useTrailingSlash;
            if (effect.added.isEmpty() && effect.backwards == 0) {
                // If nothing was added or removed, don't inherit the effect's
                // trailing slash.
                useTrailingSlash = trailingSlash;
            } else {
                useTrailingSlash = effect.hadTrailingSlash;
            }
            return new TextPath(build, useTrailingSlash);
        }
    }

    /** Normalize (if necessary). */
    private static List<String> normComponent(List<String> input) {
        if (input == null) { throw new NullPointerException("segments may not be null"); }
        if (!isNormalized(input)) {
            return normalize(input);
        }
        return input;
    }

    /**
     * Given a path component, cancel out any empty segments or traversal
     * segments.
     * @param pathComp Path component as sequence of decoded segments.
     * @return Filtered version of component.
     */
    private static List<String> normalize(Iterable<String> pathComp) {
        return effectOf(pathComp).added;
    }

    /** Match decoded empty or traversal segment. */
    private static final Pattern nonNormalSegment = Pattern.compile("\\.{0,2}");

    /**
     * Determine if path component is already normalized.
     * @param pathComp Path component as sequence of decoded segments.
     * @return true iff has no empty segments or traversal segments.
     */
    private static boolean isNormalized(Iterable<String> pathComp) {
        for (String seg : pathComp) {
            if (nonNormalSegment.matcher(seg).matches()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Same as {@link #effectOf(Iterable)}, but accepts a path
     * reference as a string and returns the decoded effect.
     * @param pathRef Path reference, not null.
     * @return Effect on an existing path component, with decoded segments.
     */
    private static PathEffect effectOf(String pathRef) throws UrlDecodeException {
        if (pathRef == null) { throw new NullPointerException("path reference may not be null."); }
        boolean absolute = Paths.isAbsolute(pathRef);
        PathEffect effect = effectOf(decodeEach(Paths.explodeRaw(pathRef)));
        return new PathEffect(
            absolute,
            absolute ? 0 : effect.backwards,
            effect.added,
            pathRef.endsWith("/"));
    }

    /**
     * Compute the effect of applying this relative sequence of decoded path
     * segments to an existing path. This will remove
     * <code>.</code> and empty segments and use <code>..</code> to backtrack
     * over existing segments.
     * @param pathRefSegs Decoded segments of a path reference. Not null, and
     *     segments may not be null.
     * @return Effect on an existing path component, where
     *  {@link PathEffect#added} will be a filtered version of the param
     *  <code>more</code> (no segments will be altered, only removed.)
     */
    private static PathEffect effectOf(Iterable<String> pathRefSegs) {
        int removed = 0;
        List<String> added = new ArrayList<String>();
        for (String seg : pathRefSegs) {
            if (seg == null) {
                throw new NullPointerException("Path segments may not be null");
            }
            if (seg.isEmpty() || seg.equals(".")) {
                continue;
            } else if (seg.equals("..")) {
                if (added.isEmpty()) {
                    removed++;
                } else {
                    added.remove(added.size() - 1);
                }
            } else {
                added.add(seg);
            }
        }
        return new PathEffect(false, removed, added, false);
    }

    /** Percent-decode each segment. */
    private static Iterable<String> decodeEach(Iterable<String> rawSegs) throws UrlDecodeException {
        List<String> build = new ArrayList<String>();
        for (String raw : rawSegs) {
            build.add(Codecs.percentDecode(raw));
        }
        return Collections.unmodifiableList(build);
    }

    /*== Object overrides ==*/

    @Override
    public String toString() {
        return String.format("#<TextPath %s>", format());
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

/**
 * The results of applying a relative path reference to a URI. The effect
 * may either be absolute (replaces entire path, iff {@link #absolute} =
 * {@literal true}) or relative. If absolute, {@link #added} is the new
 * path. If relative, {@link #backwards} indicates how many existing path
 * segments are to be removed from the old path (if available) before
 * {@link #added} is appended.
 */
class PathEffect {
    /**
     * True iff entire old path should be replaced by contents of
     * {@link #added}.
     */
    final boolean absolute;
    /**
     * Iff {@link #absolute} is false, remove this many elements from
     * old path before appending {@link #added}.
     */
    final int backwards;
    /**
     * Elements to append to old path or replace it with. Whether these
     * are raw or decoded path segments is dependent on context. Non-null.
     * Should be immutable.
     */
    final List<String> added;
    /**
     * Whether or not the reference had a trailing slash. (The absolute
     * empty path "/" is considered to have a trailing slash.)
     */
    final boolean hadTrailingSlash;

    /**
     * Create a PathEffect. If param <code>absolute</code> is true, param
     * <code>backward</code> <em>should</em> be zero.
     * @param added Should be immutable
     */
    PathEffect(boolean absolute, int backwards, List<String> added,
                      boolean hadTrailingSlash) {
        this.absolute = absolute;
        this.backwards = absolute ? 0 : backwards;
        if (added == null) {
            throw new NullPointerException("added must not be null");
        }
        this.added = added;
        this.hadTrailingSlash = hadTrailingSlash;
    }

    @Override
    public String toString() {
        return String.format("abs=%s,  back=%s, added=%s, trailingSlash=%s",
            absolute, backwards, added, hadTrailingSlash);
    }
}
