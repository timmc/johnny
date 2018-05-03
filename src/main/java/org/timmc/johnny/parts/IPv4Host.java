package org.timmc.johnny.parts;

import java.util.Arrays;

/**
 * Host component of a URI indicating an IPv4 address, represented as 4 integers.
 */
public class IPv4Host extends Host {
    private final String raw;
    private final int[] quad;

    /**
     * Create an IPv4Host from 4 integers. Raw form is derived.
     */
    public IPv4Host(int seg0, int seg1, int seg2, int seg3) {
        this(new int[]{seg0, seg1, seg2, seg3});
    }

    /**
     * Create an IPv4Host from an array of 4 integers. Raw form is derived.
     */
    public IPv4Host(int[] quad) {
        this(quad, IPv4Host.format(quad));
    }

    /**
     * Create an IPv4Host from an array of 4 integers and an accompanying
     * original raw form.
     * @param quad Array of 4 ints from 0 to 255 inclusive. Non-null.
     * @param raw Raw form of host before it was parsed. Non-null.
     */
    public IPv4Host(int[] quad, String raw) {
        if (quad == null) {
            throw new NullPointerException("IPv4 quad must not be null");
        }
        if (quad.length != 4) {
            throw new IllegalArgumentException("IPv4 quad must contain 4 entries");
        }
        if (quad[0] < 0 || quad[0] > 255 ||
            quad[1] < 0 || quad[1] > 255 ||
            quad[2] < 0 || quad[2] > 255 ||
            quad[3] < 0 || quad[3] > 255) {
            throw new IllegalArgumentException("IPv4 segments must be between 0 and 255, inclusive");
        }
        this.quad = Arrays.copyOf(quad, 4);
        if (raw == null) {
            throw new NullPointerException("IPv4 raw form must not be null");
        }
        this.raw = raw;
    }

    /**
     * Get copy of IPv4 in numeric segment form.
     */
    public int[] getQuad() {
        return Arrays.copyOf(quad, 4);
    }

    public String format() {
        return IPv4Host.format(quad);
    }

    /**
     * Format an IP v4 quad as a string, for URL representation.
     */
    public static String format(int[] quad) {
        StringBuilder sb = new StringBuilder();
        sb.append(quad[0]).append('.').append(quad[1]).append('.')
          .append(quad[2]).append('.').append(quad[3]);
        return sb.toString();
    }

    @Override
    public String getRaw() {
        return raw;
    }
}
