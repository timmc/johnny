package org.timmc.johnny;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"SimplifiableJUnitAssertion", "ArraysAsListWithZeroOrOneArgument" })
class PathsTest {
    @Test void explodeRaw() {
        assertEquals(Arrays.asList(), Paths.explodeRaw(""));
        assertEquals(Arrays.asList(""), Paths.explodeRaw("/"));
        assertEquals(Arrays.asList("", "a"), Paths.explodeRaw("//a"));
        assertEquals(Arrays.asList("a", "b", "c"), Paths.explodeRaw("/a/b/c"));
        assertEquals(Arrays.asList("a", "b", "c", ""), Paths.explodeRaw("/a/b/c/"));
        assertEquals(Arrays.asList("..", ".", "a%2Fb", "..b", "c..", ".d", ""), Paths.explodeRaw(".././a%2Fb/..b/c../.d/"));
    }

    @Test void isAbsolute() {
        assertEquals(false, Paths.isAbsolute(""));
        assertEquals(false, Paths.isAbsolute("%2F"));
        assertEquals(true, Paths.isAbsolute("/"));
        assertEquals(true, Paths.isAbsolute("//"));
        assertEquals(false, Paths.isAbsolute("../../"));
        assertEquals(false, Paths.isAbsolute("a"));
    }

    @Test void fromVarargs() {
        // Does what you'd expect
        assertEquals(Arrays.asList(), Paths.from().getSegments());
        assertEquals(Arrays.asList("a"), Paths.from("a").getSegments());
        assertEquals(Arrays.asList("foo", "bar", "baz"), Paths.from("foo", "bar", "baz").getSegments());

        // Doesn't include a trailing slash
        assertEquals(false, Paths.from("a", "bc").hasTrailingSlash());

        // Checks for null or empty segments
        assertThrows(IllegalArgumentException.class, () -> Paths.from("a", "", "c"));
        // might be NPE
        assertThrows(RuntimeException.class, () -> Paths.from("a", null, "c"));

        // Treats input as data, not encoded
        assertEquals("/a%2Fb/cd", Paths.from("a/b", "cd").format());
        assertEquals("/_%2520_", Paths.from("_%20_").format());
    }

    @Test void parsingSimple() {
        TextPath empty = Urls.parsePath("");
        TextPath slash = Urls.parsePath("/");
        // parts
        assertEquals(false, empty.hasTrailingSlash());
        assertEquals(true, slash.hasTrailingSlash());
        assertEquals(Arrays.asList(), empty.getSegments());
        assertEquals(Arrays.asList(), slash.getSegments());
        // equality
        assertEquals(TextPath.EMPTY.withTrailingSlash(false), empty);
        assertEquals(TextPath.EMPTY.withTrailingSlash(true), slash);
        // round-trip
        assertEquals("", empty.format());
        assertEquals("/", slash.format());
    }

    @Test void parsingInteresting() {
        // Path traversal, double slashes, path params (ignored), ampersand, and encoded slash.
        TextPath interesting = Paths.parse("/.././/foo;page=1;sort=asc/;=&/_/../ba%2fr");
        TextPath alternative = Paths.parse("/foo;page=1;sort=asc/;=&/ba%2Fr/").withTrailingSlash(false);
        // parts
        assertEquals(Arrays.asList("foo;page=1;sort=asc", ";=&", "ba/r"), interesting.getSegments());
        assertEquals(false, interesting.hasTrailingSlash());
        // equality
        assertEquals(interesting, alternative);
        // round-trip
        assertEquals("/foo;page=1;sort=asc/;=&/ba%2Fr", interesting.format());
    }

    @Test void addingSegments() {
        // Path traversal, and allowing (though ignoring) empty segments
        TextPath traversal = Paths.from("a", "b", "..", "c")
            .addSegments(Arrays.asList(".", "", "d", "e", ".."));
        assertEquals(Arrays.asList("a", "c", "d"), traversal.getSegments());
        assertEquals("/a/c/d", traversal.format());

        // Concatenating an absolute does not wipe out original (not treated as path reference)
        assertEquals("/a/b/c/d/e", Paths.parse("/a/b/c").addSegments(Paths.parse("/d/e")).format());
        assertEquals("/a/b/c/d/e", Paths.parse("/a/b/c/").addSegments(Paths.parse("/d/e")).format());
        // Trailing slash preserved
        assertEquals("/a/b/c/d/e/", Paths.parse("/a/b/c").addSegments(Paths.parse("/d/e/")).format());


        // Adding segments loses trailing slash
        assertEquals("/a/b/c", Paths.parse("/a/").addSegments(Arrays.asList("b", "c")).format());
        // ...unless we aren't actually adding any
        assertEquals("/a/", Paths.parse("/a/").addSegments(Arrays.asList()).format());
    }

    @Test void resolveRelative() {
        // Absolute
        assertEquals("/d/e", Paths.parse("/a/b/c").resolveRelative("/d/e").format());

        // Path traversal
        assertEquals("/a/b/e/", Paths.parse("/a/b/c/").resolveRelative("d/../../e/./").format());

        // Replacing current is *different* with/without a trailing slash on the original
        assertEquals("/a/b/index.html", Paths.parse("/a/b/c").resolveRelative("index.html").format());
        assertEquals("/a/b/c/index.html", Paths.parse("/a/b/c/").resolveRelative("index.html").format());
        // Same when traversing upward
        assertEquals("/a/index.html", Paths.parse("/a/b/c").resolveRelative("../index.html").format());
        assertEquals("/a/b/index.html", Paths.parse("/a/b/c/").resolveRelative("../index.html").format());
        // And with current-dir
        assertEquals("/a/b/", Paths.parse("/a/b/c").resolveRelative(".").format());
        assertEquals("/a/b/c/", Paths.parse("/a/b/c/").resolveRelative(".").format());
        // ...with or without trailing slash on relative path
        assertEquals("/a/b/", Paths.parse("/a/b/c").resolveRelative("./").format());
        assertEquals("/a/b/c/", Paths.parse("/a/b/c/").resolveRelative("./").format());
        // But adding *empty* raw path doesn't add an empty segment (or remove
        // the current one when slashless)
        assertEquals("/a/b", Paths.parse("/a/b").resolveRelative("").format());
        assertEquals("/a/b/", Paths.parse("/a/b/").resolveRelative("").format());

        // Short base paths
        assertEquals("/index.html", Paths.parse("/a").resolveRelative("index.html").format());
        assertEquals("/a/index.html", Paths.parse("/a/").resolveRelative("index.html").format());
        // Empty base paths
        assertEquals("/index.html", Paths.parse("").resolveRelative("index.html").format());
        assertEquals("/index.html", Paths.parse("/").resolveRelative("index.html").format());
    }

    @Test void formatting() {
        // Spaces encoded as %20 (regression test)
        assertEquals("/foo/bar%20baz", TextPath.EMPTY.addSegments(Arrays.asList("foo", "bar baz")).format());
    }

    @Test void integration() {
        HostedUri u = Urls.parse("http://[::1]/foo/bar");
        u = u.withPath(u.getPath().resolveRelative("baz;a=b/quux").addOneSegment("/a?;"));
        assertEquals("http://[::1]/foo/baz;a=b/quux/%2Fa%3F;", u.format());
    }
}
