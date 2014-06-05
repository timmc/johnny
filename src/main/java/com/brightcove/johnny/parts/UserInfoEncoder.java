package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Urls;

/**
 * Userinfo encoder. Implementations are free to choose character sets and
 * reserved characters.
 *
 * @see Urls#DEFAULT_USERINFO_ENCODER
 */
public interface UserInfoEncoder {
    /**
     * Encode a userinfo component to a raw userinfo string.
     * @param userInfo UserInfo object, not null.
     * @return Encoded userinfo string.
     */
    public String unparse(UserInfo userInfo);
}
