package org.timmc.johnny

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
abstract class Host { // TODO Showing up as non-abstract in dokka javadocs

    // Why is the raw string stored here, instead of in the containing Url
    // instance? Because it's pre-parsed by AntlrUriParser, and it seems
    // a shame to waste that work, so the raw form is stored here after
    // the fact.

    /**
     * Original raw string for this host. May be same as {@link #format()},
     * or might be misencoded if a loose parser was used. Non-null.
     */
    abstract val raw: String

    /**
     * Get string for this host address that is suitable for inclusion in a URI.
     * Non-null.
     */
    abstract fun format(): String
}
