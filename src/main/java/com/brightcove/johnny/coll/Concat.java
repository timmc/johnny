package com.brightcove.johnny.coll;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An immutable iterable that represents the concatenation of two iterables.
 * @param <E> Element type
 */
public class Concat<E> implements Iterable<E> {

    private final Iterable<E> first;
    private final Iterable<E> second;

    /**
     * Create concatenation of two iterables, expected to be immutable (or at
     * least not change over lifetime of this object.)
     */
    public Concat(Iterable<E> first, Iterable<E> second) {
        this.first = first;
        this.second = second;
    }

    public Iterator<E> iterator() {
        return new ConcatIterator<E>(first, second);
    }
}

class ConcatIterator<E> implements Iterator<E> {

    /**
     * Nullable, so do not try to access if {@link #firstHasMore} is false.
     */
    private final Iterator<E> first;
    private final Iterator<E> second;

    // Rules: Check if an iterator is exhausted first, and check the first before the second.
    /**
     * True iff {@link #first} is non-null and has next element.
     */
    private boolean firstHasMore;
    private boolean secondHasMore;

    /**
     * Element to return when {@link #next()} is called (if {@link #nextValValid} is true).
     */
    private E nextVal;
    /**
     * True iff nextVal is available. (Sources have not been consumed.)
     */
    private boolean nextValValid;

    public ConcatIterator(Iterable<E> firstSource, Iterable<E> secondSource) {
        this.first = firstSource == null ? null : firstSource.iterator();
        this.second = secondSource == null ? null : secondSource.iterator();
        firstHasMore = first != null && first.hasNext();
        secondHasMore = second != null && second.hasNext();
        nextValValid = true; // assume true, will flip to false once in lifetime
        produceNext();
    }

    private void produceNext() {
        if (firstHasMore) {
            nextVal = first.next();
            firstHasMore = first.hasNext();
        } else if (secondHasMore) {
            nextVal = second.next();
            secondHasMore = second.hasNext();
        } else {
            nextValValid = false;
        }
    }

    public synchronized boolean hasNext() {
        return nextValValid;
    }

    public synchronized E next() {
        if (!nextValValid) {
            throw new NoSuchElementException("No next element.");
        }
        E ret = nextVal;
        produceNext();
        return ret;
    }

    public synchronized void remove() {
        throw new UnsupportedOperationException("Concat assumes immutable iterables, cannot remove");
    }
}
