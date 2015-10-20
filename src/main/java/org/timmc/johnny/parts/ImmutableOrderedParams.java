package org.timmc.johnny.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.timmc.johnny.coll.MapEntry;

/**
 * An immutable params representation that maintains the original order
 * of key-value pairs, appends to the end, and can replace existing
 * pairs in-place. Accepts null values. Finding the last value for a key
 * takes linear time in the # of values for the key.
 */
public class ImmutableOrderedParams implements Params {

    /**
     * A blank instance.
     */
    public static final ImmutableOrderedParams EMPTY = new ImmutableOrderedParams();

    /**
     * Ordered list of key-value entries (Entry), with nulls indicating
     * deleted entries. NB: Null param values are not the same as null entries
     * in this collection.
     */
    private final List<Entry<String, String>> entries;
    /**
     * Number of nil entries in {@link #entries}.
     */
    private final int deleted;

    /**
     * Map of string keys to non-empty {@link PersistentTreeSet}
     * of {@link #entries} indices ({@link Integer}) where values lie.
     */
    private final Map<String, NavigableSet<Integer>> keylocs;

    /** Create a new, empty params (prefer to use {@link #EMPTY}.) */
    public ImmutableOrderedParams() {
        entries = Collections.emptyList();
        deleted = 0;
        keylocs = Collections.emptyMap();
    }

    /** Mutation constructor. */
    private ImmutableOrderedParams(List<Entry<String, String>> entries, int deleted, Map<String, NavigableSet<Integer>> keylocs) {
        this.entries = entries;
        this.deleted = deleted;
        this.keylocs = keylocs;
    }

    private NavigableSet<Integer> indicesFor(String key) {
        return keylocs.get(key);
    }

    /*== Functional ==*/

    private interface F2<I,O> {
        public O f(I in);
    }

    /**
     * Map f over a source.
     * @param source Nullable iterable
     * @return Non-null list of results.
     */
    private static <I, O> List<O> map(Iterable<I> source, F2<I, O> f) {
        LinkedList<O> out = new LinkedList<O>();
        if (source == null) {
            return out;
        }
        for (Iterator<I> iter = source.iterator(); iter.hasNext(); ) {
            out.addLast(f.f(iter.next()));
        }
        return out;
    }

    /*== Accessors ==*/

    /** Return highest index, or null if indices is empty or null. */
    private Integer maxIndex(NavigableSet<Integer> indices) {
        return indices == null ? null : indices.descendingSet().first();
    }

    /** Return val at index; null if null index, null value, or null entry. */
    private String valAtIndex(Integer i) {
        if (i == null) {
            return null;
        }
        Entry<String, String> e = entries.get(i);
        if (e == null) {
            return null;
        }
        return e.getValue();
    }

    private Integer findLast(String key, String val) {
        NavigableSet<Integer> indices = keylocs.get(key);
        if (indices == null) {
            return null;
        }
        for (Integer i : indices.descendingSet()) {
            String curv = valAtIndex(i);
            if (val == null ? curv == null : val.equals(curv)) {
                return i;
            }
        }
        return null;
    }

    /*== Interface implementation ==*/

    public boolean hasKey(String key) {
        NavigableSet<Integer> indices = keylocs.get(key);
        return indices != null;
    }

    public boolean hasPair(String key, String val) {
        return findLast(key, val) != null;
    }

    public String getLast(String key) {
        NavigableSet<Integer> indices = keylocs.get(key);
        if (indices == null) {
            return null;
        } else { // if present, not empty
            Integer index = maxIndex(indices);
            return valAtIndex(index);
        }
    }

    public Collection<String> getAll(String key) {
        return map(indicesFor(key), new F2<Integer, String>() {
            public String f(Integer in) {
                return valAtIndex(in);
            }
        });
    }

    public Collection<Entry<String, String>> getPairs() {
        LinkedList<Entry<String, String>> ret = new LinkedList<Entry<String,String>>();
        for (Entry<String, String> e : (Collection<Entry<String, String>>) entries) {
            if (e != null) {
                ret.addLast(e);
            }
        }
        return ret;
    }

    public int countKeys() {
        return keylocs.size();
    }

    public int countPairs() {
        return entries.size() - deleted;
    }

    public ImmutableOrderedParams empty() {
        return EMPTY;
    }

    public ImmutableOrderedParams removeAll(String key) {
        NavigableSet<Integer> indices = indicesFor(key);
        if (indices == null) {
            return this;
        }
        List<Entry<String, String>> newEntries = new ArrayList<Entry<String, String>>(entries);
        for (Integer i : indices) {
            newEntries.set(i, null);
        }
        Map<String, NavigableSet<Integer>> newKeylocs = new HashMap<String, NavigableSet<Integer>>(keylocs);
        newKeylocs.remove(key);
        return new ImmutableOrderedParams(newEntries, deleted + indices.size(), newKeylocs);
    }

    public ImmutableOrderedParams removeAll(String key, String val) {
        NavigableSet<Integer> indices = indicesFor(key);
        if (indices == null) {
            return this;
        }
        NavigableSet<Integer> newIndices = new TreeSet<Integer>(indices);
        int removed = 0;
        List<Entry<String, String>> newEntries = new ArrayList<Entry<String, String>>(entries);
        for (Integer i : indices) {
            Entry<String, String> e = entries.get(i);
            // trust that entry is not null, since it was referred to by index
            String curv = e.getValue();
            if (val == null ? curv == null : val.equals(curv)) {
                newEntries.set(i, null);
                removed++;
                newIndices.remove(i);
            }
        }
        Map<String, NavigableSet<Integer>> newKeylocs = new HashMap<String, NavigableSet<Integer>>(keylocs);
        if (newIndices.isEmpty()) {
            newKeylocs.remove(key);
        } else {
            newKeylocs.put(key, newIndices);
        }
        return new ImmutableOrderedParams(newEntries, deleted + removed, newKeylocs);
    }

    public ImmutableOrderedParams append(String key, String val) {
        List<Entry<String, String>> newEntries = new ArrayList<Entry<String, String>>(entries);
        newEntries.add(new MapEntry<String, String>(key, val));
        Map<String, NavigableSet<Integer>> newKeylocs = new HashMap<String, NavigableSet<Integer>>(keylocs);
        NavigableSet<Integer> indices = keylocs.get(key);
        if (indices == null) {
            indices = new TreeSet<Integer>();
            newKeylocs.put(key, indices);
        }
        indices.add(entries.size());
        return new ImmutableOrderedParams(newEntries, deleted, newKeylocs);
    }

    public ImmutableOrderedParams appendAll(Iterable<Entry<String, String>> source) {
        Map<String, NavigableSet<Integer>> newKeylocs = new HashMap<String, NavigableSet<Integer>>(keylocs);
        List<Entry<String, String>> newEntries = new ArrayList<Map.Entry<String,String>>(entries);
        int nextIndex = entries.size();
        for (Iterator<Entry<String, String>> iter = source.iterator(); iter.hasNext(); ) {
            Entry<String, String> e = iter.next();
            NavigableSet<Integer> indices = newKeylocs.get(e.getKey());
            if (indices == null) {
                indices = new TreeSet<Integer>();
                newKeylocs.put(e.getKey(), indices);
            }
            indices.add(nextIndex);
            // Ensure Entry objects themselves are immutable.
            newEntries.add(new MapEntry<String, String>(e.getKey(), e.getValue()));
            nextIndex++;
        }
        return new ImmutableOrderedParams(
                newEntries,
                deleted,
                newKeylocs);
    }

    public ImmutableOrderedParams replace(String key, String val) {
        return removeAll(key).append(key, val);
    }

    public ImmutableOrderedParams replaceLast(String key, String val) {
        NavigableSet<Integer> indices = keylocs.get(key);
        if (indices == null) {
            return append(key, val);
        } else {
            Integer lastMatchingIndex = maxIndex(indices);
            List<Entry<String, String>> newEntries = new ArrayList<Entry<String,String>>(entries);
            newEntries.set(lastMatchingIndex, new MapEntry<String, String>(key, val));
            return new ImmutableOrderedParams(newEntries, deleted, keylocs);
        }
    }

    public boolean implPreservesRepeatedKeys() {
        return true;
    }

    public boolean implPreservesValueOrderPerKey() {
        return true;
    }

    public boolean implPreservesPairOrder() {
        return true;
    }

    public boolean implImmutable() {
        return true;
    }
}
