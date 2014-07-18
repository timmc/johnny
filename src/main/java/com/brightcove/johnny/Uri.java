package com.brightcove.johnny;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brightcove.johnny.Uri.BadUriException.UriError;

/**
 * RFC 3986 URI representation and parsing.
 */
public class Uri {
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
    public Uri(String scheme, String authority, String path, String query, String fragment) {
        if (scheme == null) { throw new NullPointerException("Scheme may not be null."); }
        if (path == null) { throw new NullPointerException("Path may not be null."); }

        validate(scheme.length() > 0, UriError.SCHEME_EMPTY);
        validate(Constants.ASCII_ALPHA.get(scheme.charAt(0)), UriError.SCHEME_NO_ALPHA_START);
        validate(BitSetUtils.fromChars(scheme).andNot(Constants.RFC3986_SCHEME_ALLOWED).isEmpty(),
                 UriError.SCHEME_ILLEGAL_CHAR);

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
    public static Uri parseGeneric(String uri) {
        if (uri == null) { throw new NullPointerException("uri may not be null."); }

        Matcher m = absSyntax.matcher(uri);
        validate(m.find(), UriError.PARSE_FAILED);
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

        return new Uri(scheme, authority, path, query, fragment);
    }

    private static void validate(boolean valid, UriError checking) {
        if (!valid) {
            throw new BadUriException(checking);
        }
    }

    /**
     * Parse the authority component. Throws if authority is null.
     */
    public UriAuthority parseAuthority() {
        return UriAuthority.parseGeneric(authority);
    }

    public static class BadUriException extends RuntimeException {
        public enum UriError {
            PARSE_FAILED("Could not determine basic structure of URI"),
            SCHEME_EMPTY("Scheme component was empty"),
            SCHEME_NO_ALPHA_START("Scheme component must start with an alphabetic character"),
            SCHEME_ILLEGAL_CHAR("Scheme component contained an illegal char"),
            ;

            public final String message;

            UriError(String message) {
                this.message = message;
            }
        };

        public final UriError why;

        public BadUriException(UriError why) {
            super(why.message);
            this.why = why;
        }
    }
}
