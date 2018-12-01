package org.timmc.johnny;

import org.timmc.johnny.internal.Util;

/**
 * The host in a URI, either a registered name or an IP address.
 *
 * <p>This class only exposes the raw (or re-formatted) form of the host, and
 * indicates the type of host via subclasses:</p>
 *
 * <ol>
 *     <li>{@link RegNameHost}, a registered name</li>
 *     <li>{@link IPv4Host}, an IPv4 address</li>
 *     <li>{@link IPv6Host}, an IPv6 address</li>
 *     <li>{@link IPvFutureHost}, an IP address of a future version</li>
 * </ol>
 */
public abstract class Host {
    /**
     * Get string for this host address that is suitable for inclusion in a URI.
     * Non-null.
     */
    public abstract String format();

    /**
     * Get original raw string for this host. May be same as {@link #format()},
     * or might be misencoded if a loose parser was used. Non-null.
     */
    public abstract String getRaw();

    @Override
    public int hashCode() {
        return format().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Host)) {
            return false;
        }
        Host other = (Host) obj;
        return Util.equiv(format(), other.format());
    }

    @Override
    public String toString() {
        // TODO something less like Clojure's stringification format, to be less confusing
        return String.format("#<%s %s>", this.getClass().getSimpleName(), format());
    }
}
