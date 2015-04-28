package org.timmc.johnny.parts;

/**
 * Userinfo encoder. Implementations are free to choose character sets and
 * reserved characters.
 */
public interface UserInfoEncoder {
    /**
     * Encode a userinfo component to a raw userinfo string.
     * @param userInfo UserInfo object, not null.
     * @return Encoded userinfo string.
     */
    public String unparse(UserInfo userInfo);
}
