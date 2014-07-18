package com.brightcove.johnny.parts;

import java.util.List;

import com.brightcove.johnny.Ascii7Oracle;
import com.brightcove.johnny.BitSetUtils;
import com.brightcove.johnny.ByCharPercentEncoder;
import com.brightcove.johnny.Constants;
import com.brightcove.johnny.Encoder;
import com.brightcove.johnny.ImmutableBitSet;
import com.brightcove.johnny.coll.ClojureHelper;

import clojure.lang.APersistentVector;
import clojure.lang.PersistentVector;

/**
 * A path representation that provides an uninterpreted view of a path string,
 * including per-segment parameters and empty segments.
 */
public class TextPath extends Path<String> {
    /** Default set of unencoded characters for segments. */
    public static final ImmutableBitSet DEFAULT_PASS_SEGMENT =
            Constants.RFC3986_UNRESERVED.or(Constants.RFC3986_SUB_DELIMS).or(BitSetUtils.fromChars(":@"));

    /** Default encoder for segments. */
    public static final Encoder<String> DEFAULT_ENC_SEGMENT = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_SEGMENT));

    /** A reusable empty instance. */
    public static final Path<String> EMPTY = new TextPath();

    /** Encoder for segments. */
    public final Encoder<String> segmentEncoder;

    /** Possibly-empty collection of {@link String}. */
    private final APersistentVector segments;

    /** Creates an empty path. It is preferable to reuse {@link #EMPTY}. */
    public TextPath() {
        this(PersistentVector.EMPTY);
    }

    private TextPath(APersistentVector segments) {
        this(segments, DEFAULT_ENC_SEGMENT);
    }

    private TextPath(APersistentVector segments, Encoder<String> segmentEncoder) {
        this.segments = segments;
        this.segmentEncoder = segmentEncoder;
    }

    @SuppressWarnings("unchecked")
    public List<String> getSegments() {
        return segments;
    }

    public TextPath addSegments(Iterable<String> more) {
        return new TextPath(ClojureHelper.into(segments, more.iterator()));
    }

    @Override
    public Encoder<String> getSegmentEncoder() {
        return segmentEncoder;
    }
}
