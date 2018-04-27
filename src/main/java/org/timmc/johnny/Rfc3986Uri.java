package org.timmc.johnny;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RFC 3986 URI representation and parsing.
 */
public class Rfc3986Uri {
    /** Scheme component, not null. */
    public final String scheme;
    /** Raw authority component, nullable. */
    public final String authority;
    /** Raw path component, not null. */
    public final String path;
    /** Raw query component, nullable. */
    public final String query;
    /** Raw fragment component, nullable. */
    public final String fragment;

    /**
     * Create a URI from raw components.
     */
    public Rfc3986Uri(String scheme, String authority, String path, String query, String fragment)
    throws UrlDecodeException {
        if (scheme == null) { throw new NullPointerException("Scheme may not be null."); }
        if (path == null) { throw new NullPointerException("Path may not be null."); }

        if (scheme.length() == 0) {
            throw new UrlDecodeException("Scheme component was empty");
        }
        if (!Constants.ASCII_ALPHA.get(scheme.charAt(0))) {
            throw new UrlDecodeException("Scheme component must start with an alphabetic character");
        }
        if (!BitSetUtils.fromChars(scheme).andNot(Constants.RFC3986_SCHEME_ALLOWED).isEmpty()) {
            throw new UrlDecodeException("Scheme component contained an illegal char");
        }

        //TODO validate and characterize path

        this.scheme = scheme;
        this.authority = authority;
        this.path = path;
        this.query = query;
        this.fragment = fragment;
    }

    private static Pattern absSyntax = Pattern.compile("^([^:]*?):([^?#]*?)(\\?([^#]*))?(#(.*))?$");

    /**
     * Parse a URI based on generic syntax (not scheme-specific.)
     */
    public static Rfc3986Uri parseGeneric(String uri) throws UrlDecodeException {
        if (uri == null) { throw new NullPointerException("uri may not be null."); }

        Matcher m = absSyntax.matcher(uri);
        if (!m.find()) {
            throw new UrlDecodeException("Could not determine basic structure of URI");
        }
        String scheme = m.group(1);
        String hierarchy = m.group(2);
        String query = m.group(4);
        String fragment = m.group(6);

        String authority;
        String path;
        if (hierarchy.startsWith("//")) {
            // We have an authority
            int firstSlash = hierarchy.indexOf('/', 2);
            if (firstSlash == -1) {
                authority = hierarchy.substring(2);
                path = "";
            } else {
                authority = hierarchy.substring(2, firstSlash);
                path = hierarchy.substring(firstSlash);
            }
        } else {
            authority = null;
            path = hierarchy;
        }

        return new Rfc3986Uri(scheme, authority, path, query, fragment);
    }

    /**
     * Parse the authority component. Throws if authority is null.
     */
    public UriAuthority parseAuthority()throws UrlDecodeException {
        return UriAuthority.parseGeneric(authority);
    }
}
