package com.brightcove.johnny.parts;

import java.util.Map;

import com.brightcove.johnny.Ascii7Oracle;
import com.brightcove.johnny.ByCharPercentEncoder;
import com.brightcove.johnny.Constants;
import com.brightcove.johnny.ImmutableBitSet;
import com.brightcove.johnny.StringEncoder;

/**
 * Pluggable encoder for {@link Path}s that uses minimal encoding by default.
 */
public class PluggablePathEncoder implements PathEncoder {

    // TODO minimal encoding
    /** Default set of unencoded characters for text segments. */
    public static final ImmutableBitSet DEFAULT_PASS_TEXT = Constants.RFC3986_UNRESERVED;
    /** Default set of unencoded characters for param keys. */
    public static final ImmutableBitSet DEFAULT_PASS_KEY = Constants.RFC3986_UNRESERVED;
    /** Default set of unencoded characters for param values. */
    public static final ImmutableBitSet DEFAULT_PASS_VAL = Constants.RFC3986_UNRESERVED;

    /** Default encoder for text segments. */
    public static final StringEncoder DEFAULT_ENC_TEXT = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_TEXT));
    /** Default encoder for param keys. */
    public static final StringEncoder DEFAULT_ENC_KEY = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_KEY));
    /** Default encoder for param values. */
    public static final StringEncoder DEFAULT_ENC_VAL = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_VAL));

    /** Instance using all defaults. */
    public static final PathEncoder INSTANCE = new PluggablePathEncoder();

    /** Encoder for text segments. */
    public final StringEncoder textEnc;
    /** Encoder for param keys. */
    public final StringEncoder keyEnc;
    /** Encoder for param values. */
    public final StringEncoder valEnc;

    /**
     * Specify custom encoders for {@link #textEnc}, {@link #keyEnc}, and {@link #valEnc}.
     */
    public PluggablePathEncoder(StringEncoder textEnc, StringEncoder keyEnc, StringEncoder valEnc) {
        this.textEnc = textEnc;
        this.keyEnc = keyEnc;
        this.valEnc = valEnc;
    }

    /** Prefer {@link #INSTANCE}. */
    public PluggablePathEncoder() {
        this(DEFAULT_ENC_TEXT, DEFAULT_ENC_KEY, DEFAULT_ENC_VAL);
    }

    /** Append to a string builder instead of returning a string. */
    protected void unparseSegment(PathSegment segment, StringBuilder ret) {
        for (Map.Entry<String, String> pair : segment.params.getPairs()) {
            ret.append(';').append(keyEnc.encode(pair.getKey()));
            if (pair.getValue() != null) {
                ret.append('=').append(valEnc.encode(pair.getValue()));
            }
        }
    }

    public String unparseSegment(PathSegment segment) {
        StringBuilder ret = new StringBuilder();
        unparseSegment(segment, ret);
        return ret.toString();
    }

    public String unparse(Path path) {
        if (path == null || path.getSegments() == null || path.getSegments().isEmpty()) {
            return "/";
        }
        StringBuilder ret = new StringBuilder();
        for (PathSegment seg : path.getSegments()) {
            ret.append('/').append(textEnc.encode(seg.text));
            unparseSegment(seg, ret);
        }
        return ret.toString();
    }
}
