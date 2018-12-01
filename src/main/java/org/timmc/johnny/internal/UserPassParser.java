package org.timmc.johnny.internal;

import org.timmc.johnny.UrlDecodeException;
import org.timmc.johnny.UserPass;

/**
 * User-info parser expecting a username and optional password, colon-delimited.
 */
public class UserPassParser { // TODO Find RFC describing this format
    /**
     * Parse a raw userinfo component, assuming it consists of a username
     * and possibly a password (delimited by a colon, if present).
     * @param userInfoRaw Undecoded userinfo component of a URI (non-null)
     * @return Parsed and decoded UserInfo representation with username and password (non-null)
     */
    public static UserPass parse(String userInfoRaw) throws UrlDecodeException {
        String[] parts = userInfoRaw.split(":", 2);
        String user = Codecs.percentDecode(parts[0]);
        String password = parts.length > 1 ? Codecs.percentDecode(parts[1]) : null;
        return new UserPass(user, password);
    }

    /**
     * Parse a raw userinfo component, assuming it consists solely of a username.
     * @param userInfoRaw Undecoded userinfo component of a URI (non-null)
     * @return Decoded username (non-null)
     */
    public static String parseJustUser(String userInfoRaw) throws UrlDecodeException {
        return Codecs.percentDecode(userInfoRaw);
    }
}
