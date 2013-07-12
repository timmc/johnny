package com.brightcove.johnny.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.brightcove.johnny.coll.MapEntry;

/**
 * An implementation of {@link Query} that only preserves value ordering
 * per-key, is mutable (and thus completely thread-unsafe), and accepts null
 * vals.
 */
public class MutableMultimapQuery implements Query {

    private static final List<String> NO_VALS = Collections.unmodifiableList(new ArrayList<String>());

    /** Map of keys to null-or-nonempty lists of values. */
    private Map<String, ArrayList<String>> byKey = new HashMap<String, ArrayList<String>>();
    private int pairCount = 0;

    /**
     * Build an instance from a list of key-value pairs.
     */
    public MutableMultimapQuery(List<Map.Entry<String, String>> pairs) {
        for (Map.Entry<String, String> pair : pairs) {
            getOrCreateList(pair.getKey()).add(pair.getValue());
            pairCount++;
        }
    }

    /**
     * Get the val list at a key, creating and adding it first, if necessary.
     */
    private ArrayList<String> getOrCreateList(String key) {
        ArrayList<String> list = byKey.get(key);
        if (list == null) {
            list = new ArrayList<String>();
            byKey.put(key, list);
        }
        return list;
    }

    public boolean hasKey(String key) {
        return byKey.containsKey(key);
    }

    public String getLast(String key) {
        List<String> all = byKey.get(key); // nullable, non-empty
        return all == null ? null : all.get(all.size() - 1);
    }

    public List<String> getAll(String key) {
        List<String> found = byKey.get(key);
        return found == null ? NO_VALS : Collections.unmodifiableList(found);
    }

    public List<Entry<String, String>> getPairs() {
        LinkedList<Entry<String, String>> ret = new LinkedList<Map.Entry<String,String>>();
        for (String key : byKey.keySet()) {
            for (String val : getAll(key)) {
                ret.add(new MapEntry<String, String>(key, val));
            }
        }
        return Collections.unmodifiableList(ret);
    }

    public int countKeys() {
        return byKey.size();
    }

    public int countPairs() {
        return pairCount;
    }

    public Query removeAll(String key) {
        List<String> removed = byKey.remove(key);
        if (removed != null) {
            pairCount -= removed.size();
        }
        return this;
    }

    public Query removeAll(String key, String val) {
        List<String> victim = byKey.get(key);
        if (victim == null) {
            return this;
        }
        for(Iterator<String> iter = victim.iterator(); iter.hasNext(); ) {
            String cur = iter.next();
            if (val == null ? cur == null : val.equals(cur)) {
                iter.remove();
                pairCount--;
            }
        }
        return this;
    }

    public Query appendAll(Iterable<Entry<String, String>> source) {
        for (Entry<String, String> e : source) {
            append(e.getKey(), e.getValue());
        }
        return this;
    }

    public Query append(String key, String val) {
        getOrCreateList(key).add(val);
        return this;
    }

    public Query replace(String key, String val) {
        return removeAll(key).append(key, val);
    }

    public Query replaceLast(String key, String val) {
        ArrayList<String> vals = getOrCreateList(key);
        int foundAt = -1;
        for (int i = vals.size() - 1; i >= 0; i--) {
            String cur = vals.get(i);
            if (val == null ? cur == null : val.equals(cur)) {
                foundAt = i;
                break;
            }
        }
        if (foundAt == -1) {
            vals.add(val);
        } else {
            vals.set(foundAt, val);
        }
        return this;
    }
}
