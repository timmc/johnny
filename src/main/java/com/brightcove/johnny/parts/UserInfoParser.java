package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Url;
import com.brightcove.johnny.http.Urls;

/**
 * Parser for the userinfo component of a URL.
 *
 * @see Urls#DEFAULT_USERINFO_PARSER
 */
public interface UserInfoParser {
    /**
     * Parse a raw userinfo component.
     * @param userInfoRaw Undecoded userinfo component as retrieved from
     *   {@link Url#getUserInfoRaw()}, not null.
     * @return Parsed and decoded UserInfo representation.
     */
    public UserInfo parse(String userInfoRaw);
}