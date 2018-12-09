package org.timmc.johnny

/**
 * Runtime exception denoting a failure to recognize or parse a URL or some part of a URL.
 */
class UrlDecodeException: RuntimeException {
    constructor(msg: String) : super(msg)
    constructor(msg: String, cause: Throwable) : super(msg, cause)
}
