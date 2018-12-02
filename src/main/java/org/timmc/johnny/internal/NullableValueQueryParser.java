package org.timmc.johnny.internal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

import org.timmc.johnny.UrlDecodeException;
import org.timmc.johnny.internal.coll.MapEntry;

/**
 * A parser for query components that are composed of keys and optional
 * values. In <code>?a=5&amp;a&amp;b=7</code>, the second <code>a</code> is
 * an example of a missing value. This call uses a null value to represent them.
 * <p>
 * <strong>Warning:</strong>: Do not use this for parsing POST bodies of
 * HTTP requests! <code>application/x-www-form-urlencoded</code> uses a
 * slightly different encoding, specifically around the "+" character.
 */
public class NullableValueQueryParser {

    /** Pattern that finds ampersands. */
    private static final Pattern AMPERSAND = Pattern.compile("&");

    /**
     * Pattern that finds ampersands or semicolons. The W3C recommends
     * allowing both, although this is very rare in the wild.
     */
    public static final Pattern AMPERSAND_OR_SEMICOLON = Pattern.compile("[&;]");

    private final Pattern pairSep;
    private final Pattern kSep = Pattern.compile("=");

    /**
     * Default parser, using ampersand (<code>&amp;</code>) to delimit
     * key-value pairs from each other.
     */
    public NullableValueQueryParser() {
        this(AMPERSAND);
    }

    /**
     * Split key-value pairs from each other based on arbitrary pattern.
     */
    public NullableValueQueryParser(Pattern pairSep) {
        if (pairSep == null) {
            throw new NullPointerException("pair separator pattern must not be null");
        }
        this.pairSep = pairSep;
    }

    public Iterable<Map.Entry<String, String>> parse(String queryRaw) throws UrlDecodeException {
        LinkedList<Map.Entry<String, String>> ret = new LinkedList<>();
        String[] pairs = pairSep.split(queryRaw);
        for (String pair : pairs) {
            if (pair.isEmpty()) {
                continue;
            }
            String[] kv = kSep.split(pair, 2);
            String k = Codecs.percentDecode(kv[0]);
            String v = kv.length == 1 ? null : Codecs.percentDecode(kv[1]);
            ret.addLast(new MapEntry<>(k, v));
        }
        return Collections.unmodifiableList(ret);
    }
}
