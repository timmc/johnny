package org.timmc.johnny.parts;

import org.timmc.johnny.Ascii7Oracle;
import org.timmc.johnny.ByCharPercentEncoder;
import org.timmc.johnny.Constants;
import org.timmc.johnny.ImmutableBitSet;
import org.timmc.johnny.StringEncoder;
import org.timmc.johnny.Util;

/**
 * Represents a username/password pair from the userinfo component of a URI's
 * authority section.
 */
public class UserInfo {
    /** Set of unencoded characters for username subcomponent. */
    public static final ImmutableBitSet ALLOW_CHARS_USERNAME = Constants.RFC3986_UNENCODED_USERINFO.clear(':');
    /** Set of unencoded characters for password subcomponent. */
    public static final ImmutableBitSet ALLOW_CHARS_PASSWORD = Constants.RFC3986_UNENCODED_USERINFO;

    /** Encoder for username subcomponent. */
    public static final StringEncoder ENC_USERNAME = new ByCharPercentEncoder(new Ascii7Oracle(ALLOW_CHARS_USERNAME));
    /** Encoder for password subcomponent. */
    public static final StringEncoder ENC_PASSWORD = new ByCharPercentEncoder(new Ascii7Oracle(ALLOW_CHARS_PASSWORD));

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
     * Format a userinfo component to a raw userinfo string.
     * @return Formatted userinfo string.
     */
    public String format() {
        StringBuilder ret = new StringBuilder();
        ret.append(ENC_USERNAME.encode(user));
        if (password != null) {
            ret.append(':').append(ENC_PASSWORD.encode(password));
        }
        return ret.toString();
    }

    /**
     * Return a readable view of the username and password. May or may not be suitable for inclusion
     * in a URL.
     */
    @Override
    public String toString() {
        return format();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) o;
        return user.equals(other.user) && Util.equiv(password, other.password);
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
