package org.timmc.johnny;

import java.util.Arrays;
import java.util.Collections;

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

    /**
     * Parse an raw (undecoded) path from a URL. Empty segments will be removed
     * and relative segments ("." and "..") will be cancelled out. The
     * presence of any trailing slash will be noted.
     * @param pathRaw Raw path component of a URL (not null, may either be
     *     empty or start with "/")
     */
    public static TextPath parse(String pathRaw) throws UrlDecodeException {
        if (pathRaw == null) {
            throw new NullPointerException("Raw path must not be null.");
        }
        if (!pathRaw.isEmpty() && !pathRaw.startsWith("/")) {
            throw new UrlDecodeException("Non-empty path component did not start with a slash");
        }
        return TextPath.EMPTY.addRawPath(pathRaw);
    }

    /**
     * Create a path from a series of path segments, not encoded. Validates
     * that segments are not null or empty.
     */
    public static TextPath from(String... pathSegs) {
        for (String segment: pathSegs) {
            if (segment == null) {
                throw new NullPointerException("Path segments may not be null");
            }
            if (segment.isEmpty()) {
                throw new IllegalArgumentException("Path segments may not be empty");
            }
        }
        return TextPath.EMPTY.addSegments(Arrays.asList(pathSegs));
    }

    /**
     * Explode a raw path (component or reference) without decoding it. This
     * will lose information about whether a path reference started with a
     * slash; see {@link #isAbsolute(String)}.
     * @param path Raw path, possibly relative. Not null.
     * @return Raw segments of path, including empty and traversal segments.
     */
    public static Iterable<String> explodeRaw(String path) {
        if (path.isEmpty()) {
            return Collections.emptyList();
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
}
