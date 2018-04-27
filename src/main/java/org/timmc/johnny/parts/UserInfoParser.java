package org.timmc.johnny.parts;

import org.timmc.johnny.Url;
import org.timmc.johnny.UrlDecodeException;

/**
 * Parser for the userinfo component of a URL.
 */
public interface UserInfoParser {
    /**
     * Parse a raw userinfo component.
     * @param userInfoRaw Undecoded userinfo component as retrieved from
     *   {@link Url#getUserInfoRaw()}, not null.
     * @return Parsed and decoded UserInfo representation.
     */
    public UserInfo parse(String userInfoRaw) throws UrlDecodeException;
}