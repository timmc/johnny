package org.timmc.johnny.parts;

/**
 * Userinfo formatter. Implementations are free to choose character sets and
 * reserved characters.
 */
public interface UserInfoFormatter {
    /**
     * Format a userinfo component to a raw userinfo string.
     * @param userInfo UserInfo object, not null.
     * @return Formatted userinfo string.
     */
    public String format(UserInfo userInfo);
}
