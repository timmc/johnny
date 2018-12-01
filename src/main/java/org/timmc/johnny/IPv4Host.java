package org.timmc.johnny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Host component of a URI indicating an IPv4 address, represented as 4 integers.
 */
public class IPv4Host extends Host {
    /** See {@link #getRaw()} */
    public final String raw;
    /**
     * Get the 4 numeric segments of the IPv4 address
     */
    public final List<Integer> quad;

    /**
     * Create an IPv4Host from 4 integers. Raw form is derived.
     */
    public IPv4Host(int seg0, int seg1, int seg2, int seg3) {
        this(Arrays.asList(seg0, seg1, seg2, seg3));
    }

    /**
     * Create an IPv4Host from an array of 4 integers. Raw form is derived.
     */
    public IPv4Host(List<Integer> quad) {
        this(quad, IPv4Host.format(quad));
    }

    /**
     * Create an IPv4Host from an array of 4 integers and an accompanying
     * original raw form.
     * @param quad Array of 4 ints from 0 to 255 inclusive. Non-null.
     * @param raw Raw form of host before it was parsed. Non-null.
     */
    public IPv4Host(List<Integer> quad, String raw) {
        if (quad == null) {
            throw new NullPointerException("IPv4 quad must not be null");
        }
        // Copy, and then validate the copy
        this.quad = Collections.unmodifiableList(new ArrayList<>(quad));
        if (this.quad.size() != 4) {
            throw new IllegalArgumentException("IPv4 quad must contain 4 entries");
        }
        for (Integer seg: this.quad) {
            if (seg == null) {
                throw new NullPointerException("IPv4 segments must not be null");
            } else if (seg < 0) {
                throw new IllegalArgumentException("IPv4 segments must not be less than zero");
            } else if (seg > 255) {
                throw new IllegalArgumentException("IPv4 segments must not be greater than 255");
            }
        }
        if (raw == null) {
            throw new NullPointerException("IPv4 raw form must not be null");
        }
        this.raw = raw;
    }

    public String format() {
        return IPv4Host.format(quad);
    }

    /**
     * Format an IP v4 quad as a string, for URL representation.
     */
    public static String format(List<Integer> quad) {
        return quad.get(0) + "." + quad.get(1) + "." + quad.get(2) + "." + quad.get(3);
    }

    @Override
    public String getRaw() {
        return raw;
    }
}
