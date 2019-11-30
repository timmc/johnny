package org.timmc.johnny.internal.coll

/**
 * Immutable implementation of {@link java.util.Map.Entry} -- essentially,
 * a 2-tuple.
 */
data class MapEntry<K: Any?, V: Any?>(
    override val key: K,
    override val value: V
): Map.Entry<K, V>
