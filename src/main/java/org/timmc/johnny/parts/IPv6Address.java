package org.timmc.johnny.parts;

import java.net.Inet6Address;

public class IPv6Address {
    public final Inet6Address address;
    public final String zoneRaw;
    
    public IPv6Address(Inet6Address address, String zoneRaw) {
        this.address = address;
        this.zoneRaw = zoneRaw;
    }
    
    public IPv6Address(Inet6Address address) {
        this(address, null);
    }
    
}
