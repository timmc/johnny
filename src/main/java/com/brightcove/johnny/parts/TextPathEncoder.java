package com.brightcove.johnny.parts;

import com.brightcove.johnny.Ascii7Oracle;
import com.brightcove.johnny.ByCharPercentEncoder;
import com.brightcove.johnny.Constants;
import com.brightcove.johnny.Encoder;
import com.brightcove.johnny.ImmutableBitSet;

/**
 * Pluggable encoder for {@link Path}s that uses minimal encoding by default.
 */
public class TextPathEncoder implements PathEncoder<String> {

    // TODO minimal encoding
    /** Default set of unencoded characters for text segments. */
    public static final ImmutableBitSet DEFAULT_PASS_TEXT = Constants.RFC3986_UNRESERVED;

    /** Default encoder for text segments. */
    public static final Encoder<String> DEFAULT_ENC_TEXT = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_TEXT));

    /** Instance using all defaults. */
    public static final TextPathEncoder INSTANCE = new TextPathEncoder();

    /** Encoder for text segments. */
    public final Encoder<String> textEnc;

    /**
     * Specify custom encoder for {@link #textEnc}.
     */
    public TextPathEncoder(Encoder<String> textEnc) {
        this.textEnc = textEnc;
    }

    /** Prefer {@link #INSTANCE}. */
    public TextPathEncoder() {
        this(DEFAULT_ENC_TEXT);
    }

    public String unparse(Path<String> path) {
        if (path == null || path.getSegments() == null || path.getSegments().isEmpty()) {
            return "/";
        }
        StringBuilder ret = new StringBuilder();
        for (String seg : path.getSegments()) {
            ret.append('/').append(textEnc.encode(seg));
        }
        return ret.toString();
    }
}
