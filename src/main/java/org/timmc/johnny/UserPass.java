package org.timmc.johnny;

import org.timmc.johnny.internal.Ascii7Oracle;
import org.timmc.johnny.internal.ByCharPercentEncoder;
import org.timmc.johnny.internal.Constants;
import org.timmc.johnny.internal.ImmutableBitSet;
import org.timmc.johnny.internal.StringEncoder;
import org.timmc.johnny.internal.Util;

/**
 * Represents a username/password pair from the userinfo component of a URI's
 * authority section.
 */
public class UserPass {
    /** Set of unencoded characters for username subcomponent. */
    private static final ImmutableBitSet ALLOW_CHARS_USERNAME = Constants.RFC3986_UNENCODED_USERINFO.clear(':');
    /** Set of unencoded characters for password subcomponent. */
    private static final ImmutableBitSet ALLOW_CHARS_PASSWORD = Constants.RFC3986_UNENCODED_USERINFO;

    /** Encoder for username subcomponent. */
    private static final StringEncoder ENC_USERNAME = new ByCharPercentEncoder(new Ascii7Oracle(ALLOW_CHARS_USERNAME));
    /** Encoder for password subcomponent. */
    private static final StringEncoder ENC_PASSWORD = new ByCharPercentEncoder(new Ascii7Oracle(ALLOW_CHARS_PASSWORD));

    /** Required username portion of userinfo component. May be empty but not null. */
    public final String user;
    /** Optional (nullable) password portion of userinfo component. */
    public final String password;

    /** Construct with specified username (not null) and no password. */
    public UserPass(String user) {
        this(user, null);
    }

    /** Construct with specified username (not null) and password (nullable). */
    public UserPass(String user, String password) {
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

    @Override
    public String toString() {
        return String.format("#<UserInfo %s>", format());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserPass)) {
            return false;
        }
        UserPass other = (UserPass) o;
        return Util.equiv(user, other.user) && Util.equiv(password, other.password);
    }

    @Override
    public int hashCode() {
        int result = (23 + Util.hash(user)) * 37;
        if (password != null) {
            result = (result + Util.hash(password)) * 37;
        }
        return result;
    }
}
