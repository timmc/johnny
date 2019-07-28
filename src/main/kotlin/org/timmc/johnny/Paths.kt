package org.timmc.johnny

import java.util.Arrays

/**
 * Utilities for working with standard RFC 3986 paths.
 *
 *
 * Terminology:
 *
 *  * "." and ".." are referred to as traversal segments,
 * in reference to their use in filesystem traversal.
 *  * A <dfn>path component</dfn> is the path from a valid URI. It
 * *must* either be empty or begin with a slash.
 *  * A <dfn>path reference</dfn> is a URI relative reference with only
 * a path element. If it starts with a slash it is an absolute path reference;
 * otherwise it is a relative path reference (including if empty.)
 *  * Paths are composed of raw segments separate by slashes. Segments
 * can only be decoded once the path has been exploded into segments, lest
 * `/foo/bar%2Fbaz` be interpreted as `/foo/bar/baz`
 * (the former has two segments which decode to
 * `["foo", "bar/baz"]`.
 *
 */
object Paths {

    /**
     * Parse a raw (undecoded) path from a URL. Empty segments will be removed
     * and relative segments ("." and "..") will be cancelled out. The
     * presence of any trailing slash will be noted.
     * @param pathRaw Raw path component of a URL (not null, may either be
     * empty or start with "/")
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parse(pathRaw: String): TextPath {
        if (!pathRaw.isEmpty() && !pathRaw.startsWith("/")) {
            throw UriDecodeException("Non-empty path component did not start with a slash")
        }
        return TextPath.EMPTY.addRawPath(pathRaw)
    }

    /**
     * Create a path from a series of path segments, not encoded. Validates
     * that segments are not null or empty.
     */
    @JvmStatic
    fun from(vararg pathSegs: String): TextPath {
        for (segment in pathSegs) {
            if (segment.isEmpty()) {
                throw IllegalArgumentException("Path segments may not be empty")
            }
        }
        return TextPath.EMPTY.addSegments(Arrays.asList(*pathSegs))
    }

    /**
     * Explode a raw path (component or reference) without decoding it. This
     * will lose information about whether a path reference started with a
     * slash; see [isAbsolute].
     * @param path Raw path, possibly relative. Not null.
     * @return Raw segments of path, including empty and traversal segments.
     */
    @JvmStatic
    fun explodeRaw(path: String): Iterable<String> {
        if (path.isEmpty()) {
            return emptyList()
        }
        val pathNoLead = if (path.startsWith("/")) {
            path.substring(1)
        } else {
            path
        }
        return pathNoLead.split("/".toRegex()).toList()
    }

    /**
     * Return true iff this is an absolute path reference, that is, it starts
     * with a slash.
     * @param pathRef Non-null string.
     * @return true iff path is absolute
     */
    @JvmStatic
    fun isAbsolute(pathRef: String): Boolean {
        return pathRef.startsWith("/")
    }
}
