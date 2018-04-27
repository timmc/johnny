package org.timmc.johnny;

/**
 * Runtime exception denoting a failure to recognize or parse a URL or some part of a URL.
 */
public class UrlDecodeException extends RuntimeException {
    public UrlDecodeException(String msg) { super(msg); }
    public UrlDecodeException(String msg, Throwable cause) { super(msg, cause); }
    public UrlDecodeException(Throwable cause) { super(cause); }
}
