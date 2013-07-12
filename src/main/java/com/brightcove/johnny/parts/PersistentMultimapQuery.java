package com.brightcove.johnny.parts;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.brightcove.johnny.coll.PersistentMultimap;

/**
 * An implementation of {@link Query} that only preserves value ordering
 * per-key, is immutable (and thus thread-safe), and accepts null
 * vals.
 * <p>
 * This is a persistent data structure, viz., mutation operations return a
 * new immutable instance that shares structure with the old instance. As
 * such, there is only one empty instance, {@link #EMPTY}.
 */
public class PersistentMultimapQuery implements Query {

    private static final PersistentMultimap<String, String> EMPTY_STORE = new PersistentMultimap<String, String>();

    /** Empty value. */
    public static final PersistentMultimapQuery EMPTY = new PersistentMultimapQuery();

    /** Map of keys to null-or-nonempty lists of values. */
    private PersistentMultimap<String, String> store = new PersistentMultimap<String, String>();

    private PersistentMultimapQuery(PersistentMultimap<String, String> store) {
        this.store = store;
    }

    /**
     * Build an instance from a sequence of key-value pairs.
     */
    public PersistentMultimapQuery(Iterable<Map.Entry<String, String>> pairs) {
        this(EMPTY_STORE.consAll(pairs));
    }

    /** Private singleton constructor. Prefer {@link #EMPTY}. */
    private PersistentMultimapQuery() {
        this(EMPTY_STORE);
    }

    public boolean hasKey(String key) {
        return store.containsKey(key);
    }

    public String getLast(String key) {
        List<String> all = store.get(key); // non-null, may be empty
        return all.isEmpty() ? null : all.get(all.size() - 1);
    }

    public List<String> getAll(String key) {
        return store.get(key);
    }

    public Collection<Entry<String, String>> getPairs() {
        return store.entries();
    }

    public int countKeys() {
        return store.length();
    }

    public int countPairs() {
        return store.size();
    }

    public Query removeAll(String key) {
        return new PersistentMultimapQuery(store.dissoc(key));
    }

    public Query removeAll(String key, String val) {
        return new PersistentMultimapQuery(store.dropAll(key, val));
    }

    public Query append(String key, String val) {
        return new PersistentMultimapQuery(store.cons(key, val));
    }

    public Query replace(String key, String val) {
        return removeAll(key).append(key, val);
    }

    public Query replaceLast(String key, String val) {
        List<String> original = store.get(key);
        LinkedList<String> replacement = new LinkedList<String>();
        boolean found = false;
        for (int i = original.size() - 1; i >= 0; i--) {
            String cur = original.get(i);
            if (!found && (val == null ? cur == null : val.equals(cur))) {
                found = true;
                continue;
            }
            replacement.addFirst(cur);
        }
        return new PersistentMultimapQuery(store.assoc(key, replacement));
    }
}
