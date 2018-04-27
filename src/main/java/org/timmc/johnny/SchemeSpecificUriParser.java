package org.timmc.johnny;

/**
 * A URL parser based on the generic {@link Rfc3986Uri} parser.
 */
public class SchemeSpecificUriParser implements UrlParser {

    public Object[] parse(String url) throws UrlDecodeException {
        UriAuthority authority;
        Rfc3986Uri uri = Rfc3986Uri.parseGeneric(url);
        if (uri.authority == null) {
            throw new UrlDecodeException("Generic URI did not have an authority component.");
        } else {
            authority = uri.parseAuthority();
        }
        return new Object[]{uri.scheme, authority.userinfoRaw, authority.hostRaw, authority.portRaw,
                            uri.path, uri.query, uri.fragment};
    }

}
