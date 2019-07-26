package org.timmc.johnny

import org.timmc.johnny.internal.Ascii7Oracle
import org.timmc.johnny.internal.ByCharPercentEncoder
import org.timmc.johnny.internal.Constants

/**
 * Represents a username/password pair from the userinfo component of a URI's
 * authority section.
 */
data class UserPass @JvmOverloads constructor (
    /** Required username portion of userinfo component. May be empty but not null.  */
    @JvmField
    val user: String,
    /** Optional (nullable) password portion of userinfo component.  */
    @JvmField
    val password: String? = null
) {

    /** True iff password component is present (may be empty).  */
    fun hasPassword(): Boolean {
        return password != null
    }

    /**
     * Format a userinfo component to a raw userinfo string.
     * @return Formatted userinfo string.
     */
    fun format(): String {
        val ret = StringBuilder()
        ret.append(ENC_USERNAME.encode(user))
        if (password != null) {
            ret.append(':').append(ENC_PASSWORD.encode(password))
        }
        return ret.toString()
    }

    private companion object {
        /** Set of unencoded characters for username subcomponent.  */
        private val ALLOW_CHARS_USERNAME = Constants.RFC3986_UNENCODED_USERINFO.clear(':'.toInt())
        /** Set of unencoded characters for password subcomponent.  */
        private val ALLOW_CHARS_PASSWORD = Constants.RFC3986_UNENCODED_USERINFO

        /** Encoder for username subcomponent.  */
        private val ENC_USERNAME = ByCharPercentEncoder(Ascii7Oracle(ALLOW_CHARS_USERNAME))
        /** Encoder for password subcomponent.  */
        private val ENC_PASSWORD = ByCharPercentEncoder(Ascii7Oracle(ALLOW_CHARS_PASSWORD))
    }
}
