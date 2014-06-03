package com.brightcove.johnny.coll;

import java.util.Iterator;

import clojure.lang.APersistentVector;
import clojure.lang.IEditableCollection;
import clojure.lang.ITransientCollection;
import clojure.lang.RT;

/**
 * Helper methods for Clojure data structures.
 */
public class ClojureHelper {

    private ClojureHelper() { }

    /**
     * Initialize Clojure. We shouldn't have to have this! But otherwise we get a weird error in
     * PersistentTreeSet's class init about contains? not being defined for PersistentList. This
     * might only happen during JUnit tests, though.
     */
    public static void init() { // XXX
        RT.keyword("force", "load"); // some trivial operation to force loading
    }

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
