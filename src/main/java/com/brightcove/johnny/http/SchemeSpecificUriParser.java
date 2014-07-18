package com.brightcove.johnny.http;

import java.net.MalformedURLException;

import com.brightcove.johnny.Uri;
import com.brightcove.johnny.UriAuthority;

/**
 * A URL parser based on the generic {@link Uri} parser.
 */
public class SchemeSpecificUriParser implements UrlParser {

    public Object[] parse(String url) throws MalformedURLException {
        Uri uri;
        UriAuthority authority;
        try {
            uri = Uri.parseGeneric(url);
            if (uri.authority == null) {
                throw new MalformedURLException("Generic URI did not have an authority component.");
            } else {
                authority = uri.parseAuthority();
            }
        } catch (Uri.BadUriException bue) {
            throw (MalformedURLException) new MalformedURLException().initCause(bue);
        }
        Integer port = (authority.port == null || authority.port.isEmpty())
                       ? null : Integer.parseInt(authority.port);
        return new Object[]{uri.scheme, authority.userinfo, authority.host, port,
                            uri.path, uri.query, Codecs.percentDecode(uri.fragment)};
    }

}
