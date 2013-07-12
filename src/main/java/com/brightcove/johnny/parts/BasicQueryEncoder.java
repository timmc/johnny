package com.brightcove.johnny.parts;

import java.util.Map.Entry;

import com.brightcove.johnny.http.Codecs;

/**
 * Encodes queries in the standard fashion, defaulting to ampersand and equals
 * as delimiters and allowing null values.
 */
public class BasicQueryEncoder extends APairQueryEncoder {

    private String pairSep;
    private final char kSep = '=';

    /** Construct with default key-value pair separator (ampersand). */
    public BasicQueryEncoder() {
        this("&");
    }

    /** Construct with arbitrary key-value pair separator. */
    public BasicQueryEncoder(String pairSep) {
        this.pairSep = pairSep;
    }

    public String unparse(Query q) {
        return q == null ? null : unparse(q.getPairs());
    }

    @Override
    public String unparse(Iterable<Entry<String, String>> pairs) {
        StringBuilder ret = new StringBuilder();
        boolean writtenFirst = false;
        for (Entry<String, String> e : pairs) {
            if (writtenFirst) {
                ret.append(pairSep);
            } else {
                writtenFirst = true;
            }
            ret.append(Codecs.encodeQueryKey(e.getKey()));
            if (e.getValue() != null) {
                ret.append(kSep).append(Codecs.encodeQueryValue(e.getValue()));
            }
        }
        return ret.toString();
    }
}
