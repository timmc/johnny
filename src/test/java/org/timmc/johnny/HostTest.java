package org.timmc.johnny;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostTest {
    /** Parse and retrieve, check type and equality */
    @Test
    public void parsingAndRawPreservation() {
        List<List<Object>> samples = Arrays.asList(
            Arrays.asList("example.com", new RegNameHost("example.com")),
            Arrays.asList("1.2.3.4", new IPv4Host(1, 2, 3, 4)),
            Arrays.asList("1.2.3.4", new IPv4Host(1, 2, 3, 4, "1.2.3.4")),
            Arrays.asList("1.2.3.4", new IPv4Host(Arrays.asList(1, 2, 3, 4))),
            Arrays.asList("1.2.3.4", new IPv4Host(Arrays.asList(1, 2, 3, 4), "1.2.3.4")),
            Arrays.asList("[2620:0:861:ed1a::1]",
                new IPv6Host("2620:0:861:ed1a::1", null, "[2620:0:861:ed1a::1]")),
            Arrays.asList("[::1%25a%2Fb]", new IPv6Host("::1", "a/b")),
            Arrays.asList("[2620::10.2.3.40]",
                new IPv6Host("2620::10.2.3.40", null, "[2620::10.2.3.40]")),
            Arrays.asList("[v7.xyz]", new IPvFutureHost(7, "[v7.xyz]"))
        );

        for (List sample: samples) {
            String raw = (String) sample.get(0);
            Host expectedParsed = (Host) sample.get(1);

            Host actual = Urls.parse("https://" + raw).getHost();

            assertEquals("Parsed host",  expectedParsed, actual);
            assertEquals("Round-tripped raw host", raw, actual.getRaw());
        }
    }

    // TODO IPv6 with giant numeric sequence

    @Test
    public void ipv6() {
        IPv6Host h6 = (IPv6Host) Urls.parse("https://[::1%25a%2Fb]/").getHost();
        assertEquals("::1", h6.getAddress());
        assertEquals("[::1%25a%2Fb]", h6.getRaw());
        assertEquals("a/b", h6.getZone());
    }

    @Test
    public void nullChecks() {
        assertThrowsNPE(new Runnable() { public void run() {
            new RegNameHost(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(Arrays.asList(1, 2, 3, 4), null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv4Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv6Host(null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv6Host(null, "eth0"); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv6Host(null, "eth0", "[::1%25eth0]"); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPv6Host("::1", "eth0", null); } });
        assertThrowsNPE(new Runnable() { public void run() {
            new IPvFutureHost(5, null); } });
    }

    private void assertThrowsNPE(Runnable thunk) {
        try {
            thunk.run();
            fail("No exception was thrown (expected NPE)");
        } catch (NullPointerException npe) {
            // do nothing
        } catch (IllegalArgumentException iae) {
            // This is how Kotlin handles null checks
            String msg = iae.getMessage();
            if (msg == null || !msg.contains("Parameter specified as non-null is null")) {
                fail("Wrong exception thrown: " + iae);
            }
        } catch (Throwable t) {
            fail("Wrong exception was thrown: " + t);
        }
    }

    // TODO IPv4 with giant numeric sequence

    @Test
    public void ipv4Ambiguity() {
        // RFC 3986 §3.2.2
        // The syntax rule for host is ambiguous because it does not completely
        // distinguish between an IPv4address and a reg-name.  In order to
        // disambiguate the syntax, we apply the "first-match-wins" algorithm:
        // If host matches the rule for IPv4address, then it should be
        // considered an IPv4 address literal and not a reg-name.
        assertEquals(new IPv4Host(0, 0, 0, 0), Urls.parse("http://0.0.0.0").getHost());
        // TODO should all-numeric hosts be always treated as IPv4, but invalid?
        assertEquals("Leading zeroes",
            new RegNameHost("00.00.00.00"), Urls.parse("http://00.00.00.00").getHost());
        assertEquals("Out of range",
            new RegNameHost("1.1.1.256"), Urls.parse("http://1.1.1.256").getHost());
    }

    /** Check if IPv4Host copies array on input */
    @Test
    public void ipv4SafetyCopying() {
        List<Integer> quad = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        IPv4Host ipA = new IPv4Host(quad);
        // Mutate after passing
        quad.set(0, 100);

        assertEquals((Object) 100, quad.get(0));
        assertEquals(Arrays.asList(1, 2, 3, 4), ipA.getQuad());
    }

    @Test
    public void ipvFutureVersion() {
        assertEquals(1, ((IPvFutureHost) Urls.parse("http://[v1.foo]").getHost()).getFormatVersion());
        assertEquals(255, ((IPvFutureHost) Urls.parse("http://[vff.~$]").getHost()).getFormatVersion());
    }

    // TODO test:
    // - IPvFuture with non-hex before period
    // - IPv6 bad structure
    // - regname decoding
    // - Loose parsing: IPv4 with fewer than 4 segments, or leading zeroes
    //   for octal, or even hexadecimal (RFC 3986 §7.4)
}
