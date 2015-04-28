package org.timmc.johnny.parts;

import org.timmc.johnny.http.Codecs;

/**
 * Standard {@link UserInfoParser}.
 * 
 * @see <a href="https://tools.ietf.org/html/rfc3986#section-3.2.1">RFC 3986 §3.2.1</a>
 */
public class StdUserInfoParser implements UserInfoParser {
    public UserInfo parse(String userInfoRaw) {
        String[] parts = userInfoRaw.split(":", 2);
        String user = Codecs.percentDecode(parts[0]);
        String password = parts.length > 1 ? Codecs.percentDecode(parts[1]) : null;
        return new UserInfo(user, password);
    }
}
