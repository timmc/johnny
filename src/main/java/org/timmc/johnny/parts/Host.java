package org.timmc.johnny.parts;

import java.net.Inet4Address;
import java.net.Inet6Address;

import org.timmc.johnny.Urls;
import org.timmc.johnny.Util;

/**
 * The host component of a URL (e.g. "example.com" or an IP address.)
 *
 * Note that a hostname is not necessarily a domain name (e.g. IP addresses),
 * and a domain name is not necessarily a hostname (e.g. domain names with
 * underscores in them.)
 */
public class Host {

    /**
     * Type of URI host -- either an address or a name.
     */
    public enum HostType {
        /** A registered name, i.e. a domain name. */
        REG_NAME,
        /** An IP address of an unknown (future) version. */
        IP_UNKNOWN,
        /** A version 4 IP address. */
        IP_V4,
        /** A version 6 IP address. */
        IP_V6
    }

    /**
     * Type of host. Non-null.
     */
    public final HostType type;

    /**
     * The registered name the host identifies, if this is a {@link HostType#REG_NAME} host. Null if
     * other type. This value has *not* been percent-decoded, which should not matter for HTTP and
     * similar URLs.
     */
    public final String regNameRaw;
    /**
     * The IP address of unknown (probably future) version the host identifies, if this is a
     * {@link HostType#IP_UNKNOWN} host. Null if other type. This value has *not* been
     * percent-decoded in case since it is unknown what delimiters might be used.
     */
    public final String ipUnknownRaw;
    /**
     * The version 64IP address the host identifies, if this is a {@link HostType#IP_V6} host. Null
     * if other type.
     */
    public final Inet4Address ipv4address;
    /**
     * The version 6 IP address the host identifies, if this is a {@link HostType#IP_V6} host. Null
     * if other type. May contain a zone identifier.
     */
    public final Inet6Address ipv6address;

    /**
     * Construct a REG_NAME or IP_UNKNOWN host using a raw string.
     * @param type One of {@link HostType#REG_NAME} or {@link HostType#IP_UNKNOWN}
     * @param regNameOrIPUnknownRaw Undecoded value for host
     */
    public Host(HostType type, String regNameOrIPUnknownRaw) {
        this.type = type;
        if (type == HostType.REG_NAME) {
            regNameRaw = regNameOrIPUnknownRaw;
            ipUnknownRaw = null;
        } else if (type == HostType.IP_UNKNOWN) {
            regNameRaw = null;
            ipUnknownRaw = regNameOrIPUnknownRaw;
        } else {
            throw new IllegalArgumentException("Raw string constructor only allowed for REG_NAME or IP_UNKNOWN types, given: " + type);
        }
        this.ipv4address = null;
        this.ipv6address = null;
    }

    /**
     * Construct a {@link HostType#IP_V4} host given an IP version 4 address.
     * @param ipv4 Address this host represents.
     */
    public Host(Inet4Address ipv4) {
        this.type = HostType.IP_V4;
        this.regNameRaw = null;
        this.ipUnknownRaw = null;
        this.ipv4address = ipv4;
        this.ipv6address = null;
    }

    /**
     * Construct a {@link HostType#IP_V6} host given an IP version 6 address.
     * @param ipv6 Address this host represents.
     */
    public Host(Inet6Address ipv6) {
        this.type = HostType.IP_V6;
        this.regNameRaw = null;
        this.ipUnknownRaw = null;
        this.ipv4address = null;
        this.ipv6address = ipv6;
    }

    /** Whether this host is specified by a domain name or other registered address. */
    public boolean isDomain() { return type == HostType.REG_NAME; }

    /** Whether this host is specified by an IP address. */
    public boolean isIp() { return type == HostType.IP_V4 || type == HostType.IP_V6 || type == HostType.IP_UNKNOWN; }

    @Override
    public String toString() {
        return Urls.DEFAULT_CODECS.hostFormatter.format(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Host)) {
            return false;
        }
        Host other = (Host) o;
        return Util.equiv(regNameRaw, other.regNameRaw)
                && Util.equiv(ipv4address, other.ipv4address)
                && Util.equiv(ipv6address, other.ipv6address)
                && Util.equiv(ipUnknownRaw, other.ipUnknownRaw);
    }

    @Override
    public int hashCode() {
        return Util.hash(regNameRaw) ^ Util.hash(ipv4address) ^ Util.hash(ipv6address) ^ Util.hash(ipUnknownRaw);
    }
}
