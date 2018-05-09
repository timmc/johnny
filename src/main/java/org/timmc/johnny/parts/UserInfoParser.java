package org.timmc.johnny.parts;

import org.timmc.johnny.Codecs;
import org.timmc.johnny.UrlDecodeException;

/**
 * UserInfo parser with several variations.
 */
public class UserInfoParser { // TODO Find RFC describing this format
    /**
     * Parse a raw userinfo component, assuming it consists of a username
     * and possibly a password (delimited by a colon, if present).
     * @param userInfoRaw Undecoded userinfo component of a URI
     * @return Parsed and decoded UserInfo representation with username and password
     */
    public static UserInfo parseUserPass(String userInfoRaw) throws UrlDecodeException {
        String[] parts = userInfoRaw.split(":", 2);
        String user = Codecs.percentDecode(parts[0]);
        String password = parts.length > 1 ? Codecs.percentDecode(parts[1]) : null;
        return new UserInfo(user, password);
    }
}
