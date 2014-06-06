package com.brightcove.johnny.parts;

import java.util.Arrays;
import java.util.List;

import com.brightcove.johnny.http.Urls;

/**
 * The path component of a URL, consisting of a possibly-empty series of
 * segments with optional parameters. For example, the path <code>/foo/bar/ba%2fz/</code>
 * contains the segment strings <code>["foo", "bar", "ba/z", ""]</code>.
 */
public abstract class Path {

    /**
     * Get the sequence of segments in this path.
     * @return Non-null, possibly empty collection of non-null values.
     */
    public abstract List<PathSegment> getSegments();

    /**
     * Get the sequence of segment texts in this path. For path /foo;a=b/bar
     * this would be ["foo", "bar"].
     * @return Non-null, possibly empty collection of non-null values.
     */
    public abstract List<String> getSegmentsText();

    /**
     * Append the provided segments to the path.
     * @param more Nullable collection of non-null segments.
     */
    public abstract Path addSegments(Iterable<PathSegment> more);

    /**
     * Append more segments to a path.
     * @param more Further path segments, or null.
     */
    public Path addPath(Path more) {
        return more == null ? this : addSegments(more.getSegments());
    }

    /**
     * Append another path, using default path parser.
     * @param rawPath Raw path component, to be parsed and appended.
     */
    public Path addRawPath(String rawPath) {
        return addSegments(Urls.DEFAULT_CODECS.pathParser.parse(rawPath));
    }

    /**
     * Add one text segment to a path.
     * @param text Text of the path segment (non-null)
     */
    public Path addOneSegment(String text) {
        return addSegments(Arrays.asList(new PathSegment(text)));
    }

    /**
     * Add one text segment with params to a path.
     * @param text Text of the path segment (non-null)
     * @param params Parameters for path segment (non-null, possibly empty)
     */
    public Path addOneSegment(String text, Params params) {
        return addSegments(Arrays.asList(new PathSegment(text, params)));
    }

    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.pathEncoder.unparse(this);
    }

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
