package org.timmc.johnny;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An immutable version of {@link BitSet} that provides derivers equivalent to BitSet's mutators.
 */
public class ImmutableBitSet implements Iterable<Integer>, Cloneable {

    private static final BitSet EMPTY_BITSET = new BitSet(0);
    /** The empty set. */
    public static final ImmutableBitSet EMPTY = new ImmutableBitSet();

    private final BitSet backing;

    /**
     * Create a set backed by a mutable bitset that the caller promises not to mutate.
     * The safe equivalent is <code>ImmutableBitSet.EMPTY.or(mutable)</code>.
     */
    protected ImmutableBitSet(BitSet willNotMutate) {
        this.backing = willNotMutate;
    }

    /**
     * Create an empty set. Prefer {@link ImmutableBitSet#EMPTY}.
     */
    public ImmutableBitSet() {
        this(EMPTY_BITSET);
    }

    /** Clone the backing set for later mutation. */
    private BitSet cloneOwnSet() {
        return (BitSet) backing.clone();
    }

    /*== Delegated accessors ==*/

    /** See {@link BitSet#toByteArray()}. */
    public byte[] toByteArray() {
        return backing.toByteArray();
    }

    /** See {@link BitSet#toLongArray()}. */
    public long[] toLongArray() {
        return backing.toLongArray();
    }

    /** See {@link BitSet#get(int)}. */
    public boolean get(int bitIndex) {
        return backing.get(bitIndex);
    }

    /** See {@link BitSet#get(int, int)}. */
    public ImmutableBitSet get(int fromIndex, int toIndex) {
        return new ImmutableBitSet(backing.get(fromIndex, toIndex));
    }

    /** See {@link BitSet#nextSetBit(int)}. */
    public int nextSetBit(int fromIndex) {
        return backing.nextSetBit(fromIndex);
    }

    /** See {@link BitSet#nextClearBit(int)}. */
    public int nextClearBit(int fromIndex) {
        return backing.nextClearBit(fromIndex);
    }

    /** See {@link BitSet#previousSetBit(int)}. */
    public int previousSetBit(int fromIndex) {
        return backing.previousSetBit(fromIndex);
    }

    /** See {@link BitSet#previousClearBit(int)}. */
    public int previousClearBit(int fromIndex) {
        return backing.previousClearBit(fromIndex);
    }

    /** See {@link BitSet#length()}. */
    public int length() {
        return backing.length();
    }

    /** See {@link BitSet#isEmpty()}. */
    public boolean isEmpty() {
        return backing.isEmpty();
    }

    /** See {@link BitSet#intersects(BitSet)}. */
    public boolean intersects(ImmutableBitSet set) {
        return backing.intersects(set.backing);
    }

    /** See {@link BitSet#cardinality()}. */
    public int cardinality() {
        return backing.cardinality();
    }

    /** See {@link BitSet#size()}. */
    public int size() {
        return backing.size();
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
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            /** Location to search for next element from. May or may not itself be next value. */
            private int searchFrom = 0;

            public boolean hasNext() {
                return backing.nextSetBit(searchFrom) != -1;
            }

            public Integer next() {
                int nextVal = backing.nextSetBit(searchFrom);
                if (nextVal == -1) {
                    throw new NoSuchElementException("No more elements.");
                }
                searchFrom = nextVal + 1;
                return nextVal;
            }

            public void remove() {
                throw new UnsupportedOperationException("Iterator over immutable bitset does not support removal.");
            }
        };
    }

    /*== Derivers ==*/

    /** Immutable version of {@link BitSet#flip(int)}. */
    public ImmutableBitSet flip(int bitIndex) {
        BitSet b = cloneOwnSet();
        b.flip(bitIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#flip(int, int)}. */
    public ImmutableBitSet flip(int fromIndex, int toIndex) {
        BitSet b = cloneOwnSet();
        b.flip(fromIndex, toIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#set(int)}. */
    public ImmutableBitSet set(int bitIndex) {
        BitSet b = cloneOwnSet();
        b.set(bitIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#set(int, boolean)}. */
    public ImmutableBitSet set(int bitIndex, boolean value) {
        BitSet b = cloneOwnSet();
        b.set(bitIndex, value);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#set(int, int)}. */
    public ImmutableBitSet set(int fromIndex, int toIndex) {
        BitSet b = cloneOwnSet();
        b.set(fromIndex, toIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#set(int, int, boolean)}. */
    public ImmutableBitSet set(int fromIndex, int toIndex, boolean value) {
        BitSet b = cloneOwnSet();
        b.set(fromIndex, toIndex, value);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#clear()}. */
    public ImmutableBitSet clear() {
        BitSet b = cloneOwnSet();
        b.clear();
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#clear(int)}. */
    public ImmutableBitSet clear(int bitIndex) {
        BitSet b = cloneOwnSet();
        b.clear(bitIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#clear(int, int)}. */
    public ImmutableBitSet clear(int fromIndex, int toIndex) {
        BitSet b = cloneOwnSet();
        b.clear(fromIndex, toIndex);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#and(BitSet)}. */
    public ImmutableBitSet and(ImmutableBitSet set) {
        BitSet b = cloneOwnSet();
        b.and(set.backing);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#or(BitSet)}. */
    public ImmutableBitSet or(ImmutableBitSet set) {
        BitSet b = cloneOwnSet();
        b.or(set.backing);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#xor(BitSet)}. */
    public ImmutableBitSet xor(ImmutableBitSet set) {
        BitSet b = cloneOwnSet();
        b.xor(set.backing);
        return new ImmutableBitSet(b);
    }

    /** Immutable version of {@link BitSet#andNot(BitSet)}. */
    public ImmutableBitSet andNot(ImmutableBitSet set) {
        BitSet b = cloneOwnSet();
        b.andNot(set.backing);
        return new ImmutableBitSet(b);
    }

    /*== Object overrides ==*/

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ImmutableBitSet) {
            ImmutableBitSet other = (ImmutableBitSet) obj;
            return backing.equals(other.backing);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return backing.hashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return backing.toString();
    }
}
