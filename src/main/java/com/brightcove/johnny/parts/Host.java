package com.brightcove.johnny.parts;

import java.net.InetAddress;

import com.google.common.net.InternetDomainName;

/**
 * The host component of a URL (e.g. "example.com" or an IP address.)
 *
 * Note that a hostname is not necessarily a domain name (e.g. IP addresses),
 * and a domain name is not necessarily a hostname (e.g. domain names with
 * underscores in them.)
 *
 * Delegates to {@link InternetDomainName} for domain names and
 * {@link InetAddress} for IP address literals.
 */
public class Host {

    private final InternetDomainName domain;
    private final InetAddress ip;

    /** Create a Host specified by a domain name. */
    public Host(InternetDomainName domain) {
        this.domain = domain;
        this.ip = null;
    }

    /** Create a Host specified by an IP address. */
    public Host(InetAddress ip) {
        this.domain = null;
        this.ip = ip;
    }

    /** Whether this host is specified by a domain name. */
    public boolean isDomain() { return domain != null; }

    /** Whether this host is specified by an IP address. */
    public boolean isIp() { return ip != null; }

    /** Return domain name if {@link #isDomain()} is true, else null */
    public InternetDomainName getDomain() {
        return domain;
    }

    /** Return IP address if {@link #isIp()} is true, else null */
    public InetAddress getIp() {
        return ip;
    }
}
