package org.timmc.johnny.internal;

/**
 * General utilities.
 */
public class Util {
    /**
     * Yield hash of object, or 0 for null.
     */
    public static int hash(Object o) {
        return o == null ? 0 : o.hashCode();
    }

    /**
     * Check if two objects are equal, permitting nulls.
     */
    public static boolean equiv(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 != null) {
            return o1.equals(o2);
        } else {
            return false;
        }
    }
}
