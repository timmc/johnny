package org.timmc.johnny

import java.lang.IllegalArgumentException

/**
 * Host component of a URI indicating an IPv4 address, represented as 4 integers.
 */
data class IPv4Host @JvmOverloads constructor (
    /** First segment of the address. */
    val seg0: Int,
    /** Second segment of the address. */
    val seg1: Int,
    /** Third segment of the address. */
    val seg2: Int,
    /** Fourth segment of the address. */
    val seg3: Int,
    override val raw: String = IPv4Host.format(seg0, seg1, seg2, seg3)
): Host() {
    init {
        if (seg0 !in 0..255 || seg1 !in 0..255 || seg2 !in 0..255 || seg3 !in 0..255)
            throw IllegalArgumentException("IPv4 segments must be numbers from 0 to 255, inclusive")
    }

    /** Create an IPv4Host from a list of 4 integers. */
    @JvmOverloads
    constructor(segments: List<Int>, raw: String = IPv4Host.format(segments))
        : this(segments[0], segments[1], segments[2], segments[3], raw)
    {
        if (segments.size != 4)
            throw IllegalArgumentException("IPv4 address cannot be constructed from list with more or fewer than 4 integers")
    }

    /**
     * Get the 4 numeric segments of the IPv4 address
     */
    val quad: List<Int> = listOf(seg0, seg1, seg2, seg3)

    override fun format(): String {
        return format(seg0, seg1, seg2, seg3)
    }

    companion object {
        private fun format(segments: List<Int>): String {
            return format(segments[0], segments[1], segments[2], segments[3])
        }

        private fun format(seg0: Int, seg1: Int, seg2: Int, seg3: Int): String {
            return "$seg0.$seg1.$seg2.$seg3"
        }
    }
}
