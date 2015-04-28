package org.timmc.johnny.parts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

import org.timmc.johnny.coll.MapEntry;

/**
 * Variation on {@link NullableValueQueryParser} that treats null values as
 * empty strings.
 */
public class NullIsEmptyQueryParser implements QueryParser {

    private final NullableValueQueryParser delegate;

    /**
     * Default parser, using ampersand (<code>&amp;</code>) to delimit
     * key-value pairs from each other.
     */
    public NullIsEmptyQueryParser() {
        this(NullableValueQueryParser.AMPERSAND);
    }

    /**
     * Split key-value pairs from each other based on arbitrary pattern.
     */
    public NullIsEmptyQueryParser(Pattern pairSep) {
        this.delegate = new NullableValueQueryParser(pairSep);
    }

    public Iterable<Map.Entry<String, String>> parse(String queryRaw) {
        LinkedList<Map.Entry<String, String>> ret = new LinkedList<Map.Entry<String, String>>();
        for (Map.Entry<String, String> e : delegate.parse(queryRaw)) {
            ret.add(e.getValue() == null ? new MapEntry<String, String>(e.getKey(), "") : e);
        }
        return Collections.unmodifiableList(ret);
    }
}
