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
        Integer port = (authority.port == null || authority.port.isEmpty())
                       ? null : Integer.parseInt(authority.port);
        return new Object[]{uri.scheme, authority.userinfo, authority.host, port,
                            uri.path, uri.query, Codecs.percentDecode(uri.fragment)};
    }

}
