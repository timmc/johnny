package org.timmc.johnny.internal;

import java.util.Map.Entry;

import org.timmc.johnny.*;

/**
 * Encodes queries in the standard fashion, defaulting to ampersand and equals
 * as delimiters and allowing null values.
 */
public class PairQueryFormatter implements QueryFormatter {

    private String pairSep;
    private final char kSep = '=';

    private final StringEncoder keyEnc;
    private final StringEncoder valEnc;

    /** Construct with default key-value pair separator (ampersand). */
    public PairQueryFormatter() {
        this("&");
    }

    /** Construct with arbitrary key-value pair separator. */
    public PairQueryFormatter(String pairSep) {
        this.pairSep = pairSep;
        keyEnc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_QUERY.or(BitSetUtils.fromChars(pairSep + kSep))));
        valEnc = new ByCharPercentEncoder(new Ascii7Oracle(Constants.RFC3986_UNENCODED_QUERY.or(BitSetUtils.fromChars(pairSep))));
    }

    public String format(Params q) {
        return q == null ? null : format(q.getPairs());
    }

    /**
     * Format query pairs to a raw query string.
     * @param pairs Key-value pairs (possibly with null values)
     * @return String suitable for {@link Url#withQueryRaw(String)}
     */
    public String format(Iterable<Entry<String, String>> pairs) {
        StringBuilder ret = new StringBuilder();
        boolean writtenFirst = false;
        for (Entry<String, String> e : pairs) {
            if (writtenFirst) {
                ret.append(pairSep);
            } else {
                writtenFirst = true;
            }
            ret.append(keyEnc.encode(e.getKey()));
            if (e.getValue() != null) {
                ret.append(kSep).append(valEnc.encode(e.getValue()));
            }
        }
        return ret.toString();
    }
}
