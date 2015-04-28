package org.timmc.johnny.parts;

import org.timmc.johnny.Ascii7Oracle;
import org.timmc.johnny.ByCharPercentEncoder;
import org.timmc.johnny.Constants;
import org.timmc.johnny.ImmutableBitSet;
import org.timmc.johnny.StringEncoder;

/**
 * Pluggable encoder for {@link UserInfo}s that uses minimal encoding by default.
 */
public class PluggableUserInfoEncoder implements UserInfoEncoder {

    /** Default set of unencoded characters for username subcomponent. */
    public static final ImmutableBitSet DEFAULT_PASS_USERNAME = Constants.RFC3986_UNENCODED_USERINFO.clear(':');
    /** Default set of unencoded characters for password subcomponent. */
    public static final ImmutableBitSet DEFAULT_PASS_PASSWORD = Constants.RFC3986_UNENCODED_USERINFO;

    /** Default encoder for username subcomponent. */
    public static final StringEncoder DEFAULT_ENC_USERNAME = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_USERNAME));
    /** Default encoder for password subcomponent. */
    public static final StringEncoder DEFAULT_ENC_PASSWORD = new ByCharPercentEncoder(new Ascii7Oracle(DEFAULT_PASS_PASSWORD));

    /** Encoder for username subcomponent. */
    public final StringEncoder usernameEnc;
    /** Encoder for password subcomponent. */
    public final StringEncoder passwordEnc;

    /** Instance using all defaults. */
    public static final PluggableUserInfoEncoder INSTANCE = new PluggableUserInfoEncoder();

    /**
     * Specify custom encoders for {@link #usernameEnc} and {@link #passwordEnc}.
     */
    public PluggableUserInfoEncoder(StringEncoder usernameEnc, StringEncoder passwordEnc) {
        this.usernameEnc = usernameEnc;
        this.passwordEnc = passwordEnc;
    }

    /** Prefer {@link #INSTANCE}. */
    public PluggableUserInfoEncoder() {
        this(DEFAULT_ENC_USERNAME, DEFAULT_ENC_PASSWORD);
    }

    public String unparse(UserInfo userInfo) {
        StringBuilder ret = new StringBuilder();
        ret.append(usernameEnc.encode(userInfo.user));
        if (userInfo.password != null) {
            ret.append(':').append(passwordEnc.encode(userInfo.password));
        }
        return ret.toString();
    }
}
