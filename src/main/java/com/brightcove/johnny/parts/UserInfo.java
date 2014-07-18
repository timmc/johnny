package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Urls;

/**
 * Represents a username/password pair from the userinfo component of a URI's
 * authority section.
 */
public class UserInfo {
    /** Required username portion of userinfo component. May be empty but not null. */
    public final String user;
    /** Optional (nullable) password portion of userinfo component. */
    public final String password;

    /** Construct with specified username (not null) and no password. */
    public UserInfo(String user) {
        this(user, null);
    }

    /** Construct with specified username (not null) and password (nullable). */
    public UserInfo(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /** True iff password component is present (may be empty). */
    public boolean hasPassword() {
        return password != null;
    }

    /**
     * Return a readable view of the username and password. May or may not be suitable for inclusion
     * in a URL.
     *
     * @see UserInfoEncoder
     */
    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.userInfoEncoder.unparse(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) o;
        return user.equals(other.user) &&
               (password == null ? other.password == null : password.equals(other.password));
    }

    @Override
    public int hashCode() {
        int result = (23 + user.hashCode()) * 37;
        if (password != null) {
            result = (result + password.hashCode()) * 37;
        }
        return result;
    }
}
