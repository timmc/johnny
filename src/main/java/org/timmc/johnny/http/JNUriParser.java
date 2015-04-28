package org.timmc.johnny.http;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * A parser based on {@link java.net.URI}, which doesn't understand unicode domains.
 * Also, will ignore errors in the port component:
 * <p>
 * <code>new URI("http://localhost:८४४३").getPort() //= -1</code>
 */
public class JNUriParser implements UrlParser {
    public Object[] parse(String url) throws MalformedURLException {
        Object[] args = new Object[7];
        URI parsed;
        try {
            parsed = new URI(url);
        } catch (URISyntaxException urise) {
            throw new MalformedURLException("Bad URI: " + urise);
        }
        args[0] = parsed.getScheme();
        args[1] = parsed.getRawUserInfo();
        if (parsed.getAuthority() != null && parsed.getHost() == null) {
            // For example, when given "http://localhost:८४४३"
            throw new MalformedURLException("Could not parse host from authority section of URI");
        }
        args[2] = parsed.getHost();
        args[3] = parsed.getPort() == -1 ? null : Integer.valueOf(parsed.getPort());
        args[4] = parsed.getRawPath();
        args[5] = parsed.getRawQuery();
        args[6] = parsed.getFragment();
        return args;
    }
}
