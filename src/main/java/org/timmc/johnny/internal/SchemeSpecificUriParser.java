package org.timmc.johnny.internal;

import org.timmc.johnny.Url;
import org.timmc.johnny.UrlDecodeException;

/**
 * A URL parser based on the generic {@link Rfc3986Uri} parser.
 */
public class SchemeSpecificUriParser implements UrlParser {

    public Url parse(String url) throws UrlDecodeException {
        UriAuthority authority;
        Rfc3986Uri uri = Rfc3986Uri.parseGeneric(url);
        if (uri.authority == null) {
            throw new UrlDecodeException("Generic URI did not have an authority component.");
        } else {
            authority = uri.parseAuthority();
        }
        return new ImmutableUrl(uri.scheme, authority.userinfoRaw, authority.host, authority.portRaw,
                                uri.path, uri.query, uri.fragment);
    }

}
