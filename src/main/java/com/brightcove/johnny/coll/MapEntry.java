package com.brightcove.johnny.coll;

import java.util.Map;

/**
 * Immutable implementation of {@link java.util.Map.Entry} -- essentially,
 * a 2-tuple.
 */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private final V val;

    /**
     * Construct a new MapEntry with specified key and value.
     */
    public MapEntry(K key, V val) {
        this.key = key;
        this.val = val;
    }

    /** Return key of this entry. */
    public K getKey() { return key; }
    /** Return value of this entry. */
    public V getValue() { return val; }

    /** Return a variation on this instance with the key changed. */
    public MapEntry<K, V> withKey(K key) {
        return new MapEntry<K, V>(key, val);
    }

    /** Return a variation on this instance with the value changed. */
    public MapEntry<K, V> withValue(V val) {
        return new MapEntry<K, V>(key, val);
    }

    public V setValue(V value) {
        throw new UnsupportedOperationException("Mutation is not supported on PersistentMultimap$Entry.");
    }
}