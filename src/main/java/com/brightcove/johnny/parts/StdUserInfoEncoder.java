package com.brightcove.johnny.parts;

import com.brightcove.johnny.http.Codecs;

/**
 * Standard encoder for {@link UserInfo}.
 */
public class StdUserInfoEncoder implements UserInfoEncoder {
    //TODO accept bitsets for encoding?

    public String unparse(UserInfo userInfo) {
        StringBuilder ret = new StringBuilder();
        ret.append(Codecs.encodeUsername(userInfo.user));
        if (userInfo.password != null) {
            ret.append(':').append(Codecs.encodePassword(userInfo.password));
        }
        return ret.toString();
    }

}
