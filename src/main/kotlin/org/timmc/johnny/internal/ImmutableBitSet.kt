package org.timmc.johnny.internal

import java.util.BitSet
import java.util.NoSuchElementException

/**
 * An immutable version of [BitSet] that provides derivers equivalent to BitSet's mutators.
 */
data class ImmutableBitSet
/**
 * Create a set backed by a mutable bitset that the caller promises not to mutate.
 * The safe equivalent is `ImmutableBitSet.EMPTY.or(mutable)`.
 */
    (private val backing: BitSet) : Iterable<Int>, Cloneable {

    /** See [BitSet.isEmpty].  */
    fun isEmpty(): Boolean {
        return backing.isEmpty
    }

    /**
     * Create an empty set. Prefer [ImmutableBitSet.EMPTY].
     */
    private constructor() : this(EMPTY_BITSET) {}

    /** Clone the backing set for later mutation.  */
    private fun cloneOwnSet(): BitSet {
        return backing.clone() as BitSet
    }

    /*== Delegated accessors ==*/

    /** See [BitSet.get].  */
    fun get(bitIndex: Int): Boolean {
        return backing.get(bitIndex)
    }

    /** See [BitSet.get].  */
    fun get(fromIndex: Int, toIndex: Int): ImmutableBitSet {
        return ImmutableBitSet(backing.get(fromIndex, toIndex))
    }

    /** See [BitSet.nextSetBit].  */
    fun nextSetBit(fromIndex: Int): Int {
        return backing.nextSetBit(fromIndex)
    }

    /** See [BitSet.nextClearBit].  */
    fun nextClearBit(fromIndex: Int): Int {
        return backing.nextClearBit(fromIndex)
    }

    /** See [BitSet.length].  */
    fun length(): Int {
        return backing.length()
    }

    /** See [BitSet.intersects].  */
    fun intersects(set: ImmutableBitSet): Boolean {
        return backing.intersects(set.backing)
    }

    /** See [BitSet.cardinality].  */
    fun cardinality(): Int {
        return backing.cardinality()
    }

    /** See [BitSet.size].  */
    fun size(): Int {
        return backing.size()
    }

    /*== Additional accessors ==*/

    /*
     * Tested with timmc/collection-check@iterators (fork of ztellman lib):
     *
     * (import 'org.timmc.johnny.ImmutableBitSet)
     * (require '[collection-check :as cc]
     *          '[simple-check.generators :as gen]
     *          '[simple-check.core :refer (quick-check)])
     * (quick-check 1e3
     *   (cc/gen-iterator-like
     *    (gen/fmap (comp sort distinct)
     *              (gen/such-that #(< (count %) 10)
     *                             (gen/list gen/nat)))
     *    #(.iterator (reduce (fn [accum i] (.set accum (int i)))
     *                        ImmutableBitSet/EMPTY
     *                        %))
     *    false))
     */
    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            /** Location to search for next element from. May or may not itself be next value.  */
            private var searchFrom = 0

            override fun hasNext(): Boolean {
                return backing.nextSetBit(searchFrom) != -1
            }

            override fun next(): Int {
                val nextVal = backing.nextSetBit(searchFrom)
                if (nextVal == -1) {
                    throw NoSuchElementException("No more elements.")
                }
                searchFrom = nextVal + 1
                return nextVal
            }
        }
    }

    /*== Derivers ==*/

    /** Immutable version of [BitSet.flip].  */
    fun flip(bitIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.flip(bitIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.flip].  */
    fun flip(fromIndex: Int, toIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.flip(fromIndex, toIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.set].  */
    fun set(bitIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.set(bitIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.set].  */
    fun set(bitIndex: Int, value: Boolean): ImmutableBitSet {
        val b = cloneOwnSet()
        b.set(bitIndex, value)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.set].  */
    fun set(fromIndex: Int, toIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.set(fromIndex, toIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.set].  */
    fun set(fromIndex: Int, toIndex: Int, value: Boolean): ImmutableBitSet {
        val b = cloneOwnSet()
        b.set(fromIndex, toIndex, value)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.clear].  */
    fun clear(): ImmutableBitSet {
        val b = cloneOwnSet()
        b.clear()
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.clear].  */
    fun clear(bitIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.clear(bitIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.clear].  */
    fun clear(fromIndex: Int, toIndex: Int): ImmutableBitSet {
        val b = cloneOwnSet()
        b.clear(fromIndex, toIndex)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.and].  */
    fun and(set: ImmutableBitSet): ImmutableBitSet {
        val b = cloneOwnSet()
        b.and(set.backing)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.or].  */
    fun or(set: ImmutableBitSet): ImmutableBitSet {
        val b = cloneOwnSet()
        b.or(set.backing)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.xor].  */
    fun xor(set: ImmutableBitSet): ImmutableBitSet {
        val b = cloneOwnSet()
        b.xor(set.backing)
        return ImmutableBitSet(b)
    }

    /** Immutable version of [BitSet.andNot].  */
    fun andNot(set: ImmutableBitSet): ImmutableBitSet {
        val b = cloneOwnSet()
        b.andNot(set.backing)
        return ImmutableBitSet(b)
    }

    companion object {
        private val EMPTY_BITSET = BitSet(0)

        /** The empty set.  */
        @JvmField
        val EMPTY = ImmutableBitSet()
    }
}
