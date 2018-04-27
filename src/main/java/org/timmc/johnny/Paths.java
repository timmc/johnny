package org.timmc.johnny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Utilities for working with standard RFC 3986 paths.
 * <p>
 * Terminology:
 * <ul>
 * <li>"." and ".." are referred to as traversal segments,
 * in reference to their use in filesystem traversal.</li>
 * <li>A <dfn>path component</dfn> is the path from a valid URI. It
 * <em>must</em> either be empty or begin with a slash.</li>
 * <li>A <dfn>path reference</dfn> is a URI relative reference with only
 * a path element. If it starts with a slash it is an absolute path reference;
 * otherwise it is a relative path reference (including if empty.)</li>
 * <li>Paths are composed of raw segments separate by slashes. Segments
 * can only be decoded once the path has been exploded into segments, lest
 * <code>/foo/bar%2Fbaz</code> be interpreted as <code>/foo/bar/baz</code>
 * (the former has two segments which decode to
 * <code>["foo", "bar/baz"]</code>.</li>
 * </ul>
 */
public class Paths {

    private static final List<String> EMPTY_STRS = Collections.unmodifiableList(Arrays.<String>asList());

    /**
     * Explode a raw path (component or reference) without decoding it. This
     * will lose information about whether a path reference started with a
     * slash; see {@link #isAbsolute(String)}.
     * @param path Raw path, possibly relative. Not null.
     * @return Raw segments of path, including empty and traversal segments.
     */
    public static Iterable<String> explode(String path) {
        if (path.isEmpty()) {
            return EMPTY_STRS;
        }
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        return Collections.unmodifiableList(Arrays.asList(path.split("/", -1)));
    }

    /**
     * Return true iff this is an absolute path reference, that is, it starts
     * with a slash.
     * @param pathRef Non-null string.
     * @return true iff path is absolute
     */
    public static boolean isAbsolute(String pathRef) {
        return pathRef.startsWith("/");
    }

    /**
     * Compute the effect of applying this relative sequence of decoded path
     * segments to an existing path. This will remove
     * <code>.</code> and empty segments and use <code>..</code> to backtrack
     * over existing segments.
     * @param pathRefSegs Decoded segments of a path reference. Not null.
     * @return Effect on an existing path component, where
     *  {@link PathEffect#added} will be a filtered version of the param
     *  <code>more</code> (no segments will be altered, only removed.)
     */
    public static PathEffect effectOf(Iterable<String> pathRefSegs) {
        int removed = 0;
        List<String> added = new ArrayList<String>();
        for (String seg : pathRefSegs) {
            if (seg == null || seg.isEmpty() || seg.equals(".")) {
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
        return new PathEffect(false, removed, added);
    }

    /** Percent-decode each segment. */
    private static Iterable<String> decodeEach(Iterable<String> rawSegs) throws UrlDecodeException {
        List<String> build = new ArrayList<String>();
        for (String raw : rawSegs) {
            build.add(Codecs.percentDecode(raw));
        }
        return Collections.unmodifiableList(build);
    }

    /**
     * Same as {@link #effectOf(Iterable)}, but accepts a path
     * reference as a string and returns the decoded effect.
     * @param pathRef Path reference, not null.
     * @return Effect on an existing path component, with decoded segments.
     * @see #decode(String) for working with path components
     */
    public static PathEffect effectOf(String pathRef) throws UrlDecodeException {
        if (pathRef == null) { throw new NullPointerException("path reference may not be null."); }
        boolean absolute = isAbsolute(pathRef);
        PathEffect effect = effectOf(decodeEach(explode(pathRef)));
        return new PathEffect(absolute, absolute ? 0 : effect.backwards, effect.added);
    }

    /**
     * Decode a path by splitting it and decoding the segments.
     * @param pathComp Path component. Not null.
     * @return Decoded segments of a path, with empty and traversal segments normalized away.
     * @see #effectOf(String) for working with path references
     */
    public static List<String> decode(String pathComp) throws UrlDecodeException {
        if (!pathComp.isEmpty() && !pathComp.startsWith("/")) {
            throw new IllegalArgumentException("Non-empty path component did not start with a slash"); // TODO use a BadUriException?
        }
        return effectOf(pathComp).added;
    }

    /**
     * Given a path component, cancel out any empty segments or traversal
     * segments.
     * @param pathComp Path component as sequence of decoded segments.
     * @return Filtered version of component.
     */
    public static List<String> normalize(Iterable<String> pathComp) {
        return effectOf(pathComp).added;
    }

    /** Match decoded empty or traversal segment. */
    private static final Pattern nonNormalSegment = Pattern.compile("\\.{0,2}");

    /**
     * Determine if path component is already normalized.
     * @param pathComp Path component as sequence of decoded segments.
     * @return true iff has no empty segments or traversal segments.
     */
    public static boolean isNormalized(Iterable<String> pathComp) {
        for (String seg : pathComp) {
            if (nonNormalSegment.matcher(seg).matches()) {
                return false;
            }
        }
        return true;
    }

    /**
     * The results of applying a relative path reference to a URI. The effect
     * may either be absolute (replaces entire path, iff {@link #absolute} =
     * {@literal true}) or relative. If absolute, {@link #added} is the new
     * path. If relative, {@link #backwards} indicates how many existing path
     * segments are to be removed from the old path (if available) before
     * {@link #added} is appended.
     */
    public static class PathEffect {
        /**
         * True iff entire old path should be replaced by contents of
         * {@link #added}.
         */
        public final boolean absolute;
        /**
         * Iff {@link #absolute} is false, remove this many elements from
         * old path before appending {@link #added}.
         */
        public final int backwards;
        /**
         * Elements to append to old path or replace it with. Whether these
         * are raw or decoded path segments is dependent on context. Non-null.
         * Should be immutable.
         */
        public final List<String> added;

        /**
         * Create a PathEffect. If param <code>absolute</code> is true, param
         * <code>backward</code> <em>should</em> be zero.
         * @param added Should be immutable
         */
        public PathEffect(boolean absolute, int backwards, List<String> added) {
            this.absolute = absolute;
            this.backwards = absolute ? 0 : backwards;
            if (added == null) {
                throw new NullPointerException("added must not be null");
            }
            this.added = added;
        }

        @Override
        public String toString() {
            return String.format("abs=%s,  back=%s, added=%s", absolute, backwards, added);
        }
    }
}
