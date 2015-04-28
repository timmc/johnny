package org.timmc.johnny.http;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * An oddly permissive parser that uses {@link java.net.URL}, which accepts
 * non-Latin numeric characters in the port number:
 * <p>
 * <code>new URL("http://localhost:८४४३").getPort() //= 8443</code>
 */
public class JNUrlParser implements UrlParser {
    public Object[] parse(String url) throws MalformedURLException {
        Object[] args = new Object[7];
        URL parsed = new URL(url);
        args[0] = parsed.getProtocol();
        args[1] = parsed.getUserInfo();
        args[2] = parsed.getHost();
        args[3] = parsed.getPort() == -1 ? null : Integer.valueOf(parsed.getPort());
        args[4] = parsed.getPath();
        args[5] = parsed.getQuery();
        String fragment = parsed.getRef();
        args[6] = fragment == null ? null : Codecs.percentDecode(fragment);
        return args;
    }
}
