package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Urls;

/** One segment of a parameterized path. */
public class PathSegment {
    /**
     * The text of the path segment; for the first segment of <code>/comments;sort=new/flagged</code>
     * this would be <code>comments</code>. Not null, may be empty.
     */
    public final String text;

    /**
     * The parameters of the path segment; for the first segment of <code>/comments;sort=new/flagged</code>
     * this would be <code>{sort -> new}</code>. Not null, may be empty.
     */
    public final Params params;

    /**
     * Construct a segment with empty parameter list.
     * @param text Non-null, may be empty.
     */
    public PathSegment(String text) {
        this(text, Urls.DEFAULT_CODECS.emptyParams);
    }

    /**
     * Construct a segment, possibly with parameters.
     * @param text Non-null, may be empty.
     * @param params Non-null, may be empty.
     */
    public PathSegment(String text, Params params) {
        if (text == null) {
            throw new NullPointerException("Path segment text must not be null (may be empty.)");
        }
        if (params == null) {
            throw new NullPointerException("Path params must not be null (may be empty.)");
        }
        this.text = text;
        this.params = params;
    }

    /** Return instance with {@link #text} field replaced. */
    public PathSegment withText(String text) {
        return new PathSegment(text, params);
    }

    /** Return instance with {@link #params} field replaced. */
    public PathSegment withParams(Params params) {
        return new PathSegment(text, params);
    }

    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.pathEncoder.unparseSegment(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PathSegment)) {
            return false;
        }
        PathSegment other = (PathSegment) o;
        return text.equals(other.text) && params.equals(other.params);
    }

    @Override
    public int hashCode() {
        return text.hashCode() + params.hashCode();
    }
}
