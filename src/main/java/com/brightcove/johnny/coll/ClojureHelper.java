package com.brightcove.johnny.coll;

import java.util.Iterator;

import clojure.lang.APersistentVector;
import clojure.lang.IEditableCollection;
import clojure.lang.ITransientCollection;

/**
 * Helper methods for Clojure data structures.
 */
public class ClojureHelper {

    private ClojureHelper() { }

    /**
     * Dump elements into a persistent vector using transients.
     */
    public static APersistentVector into(APersistentVector base, Iterator<?> more) {
        ITransientCollection list = ((IEditableCollection) base).asTransient();
        for (; more.hasNext();) {
            list = list.conj(more.next());
        }
        return (APersistentVector) list.persistent();
    }
}
