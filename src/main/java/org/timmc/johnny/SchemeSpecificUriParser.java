package org.timmc.johnny;

import java.net.MalformedURLException;


/**
 * A URL parser based on the generic {@link Rfc3986Uri} parser.
 */
public class SchemeSpecificUriParser implements UrlParser {

    public Object[] parse(String url) throws MalformedURLException {
        Rfc3986Uri uri;
        UriAuthority authority;
        try {
            uri = Rfc3986Uri.parseGeneric(url);
            if (uri.authority == null) {
                throw new MalformedURLException("Generic URI did not have an authority component.");
            } else {
                authority = uri.parseAuthority();
            }
        } catch (Rfc3986Uri.BadUriException bue) {
            throw (MalformedURLException) new MalformedURLException().initCause(bue);
        }
        Integer port = (authority.portRaw == null || authority.portRaw.isEmpty())
                       ? null : Integer.parseInt(authority.portRaw);
        return new Object[]{uri.scheme, authority.userinfoRaw, authority.hostRaw, port,
                            uri.path, uri.query, Codecs.percentDecode(uri.fragment)};
    }

}
