package org.timmc.johnny.internal

import org.timmc.johnny.UriDecodeException
import org.timmc.johnny.UserPass

/**
 * User-info parser expecting a username and optional password, colon-delimited.
 */
object UserPassParser { // TODO Find RFC describing this format
    /**
     * Parse a raw userinfo component, assuming it consists of a username
     * and possibly a password (delimited by a colon, if present).
     * @param userInfoRaw Undecoded userinfo component of a URI
     * @return Parsed and decoded UserInfo representation with username and password
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parse(userInfoRaw: String): UserPass {
        val parts = userInfoRaw.split(":".toRegex(), 2)
        val user = Codecs.percentDecode(parts[0])
        val password = if (parts.size > 1) Codecs.percentDecode(parts[1]) else null
        return UserPass(user, password)
    }

    /**
     * Parse a raw userinfo component, assuming it consists solely of a username.
     * @param userInfoRaw Undecoded userinfo component of a URI (non-null)
     * @return Decoded username (non-null)
     */
    @JvmStatic
    @Throws(UriDecodeException::class)
    fun parseJustUser(userInfoRaw: String): String {
        return Codecs.percentDecode(userInfoRaw)
    }
}
