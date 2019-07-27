package org.timmc.johnny;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.timmc.johnny.internal.coll.MapEntry;

import java.util.*;

class QueriesTest {
    @Test
    void missing() {
        // Url-level q-parse defaults
        assertEquals(Queries.empty(), Urls.parse("http://localhost").getQuery());
        // Urls-level q-parse defaults
        assertEquals(Queries.empty(), Urls.parseQuery(""));
    }

    @Test
    void emptyEquality() {
        Params missing = Urls.parse("http://localhost").getQuery();
        Params empty = Urls.parse("http://localhost?").getQuery();
        Params degenerate = Urls.parse("http://localhost?&&&").getQuery();

        assertEquals(missing, empty);
        assertEquals(empty, degenerate);
        assertEquals(degenerate, missing);
    }

    /**
     * Behavioral testing of various routes to an empty Params.
     */
    @Test
    void empty() {
        for (Params empty: Arrays.asList(
            Queries.parse(""),
            Queries.parse("&&&&&"),
            Queries.empty(),
            Queries.empty().appendAll(new ArrayList<MapEntry<String, String>>()),
            Queries.from("foo", new ArrayList<>()),
            Queries.from(new HashMap<>()),
            Queries.from("foo", "bar").removeAll("foo")
        )) {
            assertEquals(0, empty.getPairs().size());
            assertEquals(0, empty.countKeys());
            assertEquals(0, empty.countPairs());
            for (String key: Arrays.asList("", "foo")) {
                assertFalse(empty.hasKey(key));
                assertNull(empty.getLast(key));
                assertFalse(empty.hasPair(key, null));
                assertEquals(0, empty.getAll(key).size());
            }
        }
    }

    /**
     * Behavioral testing of a Params made from parsing
     */
    @Test
    void parsed() {
        Params q = Queries.parse("a&b=&a=65");

        assertNotNull(q);
        assertEquals(2, q.countKeys());
        assertTrue(q.hasKey("a"));
        assertTrue(q.hasKey("b"));
        assertEquals(3, q.countPairs());
        assertEquals(
            Arrays.asList(
                new MapEntry<>("a", null),
                new MapEntry<>("b", ""),
                new MapEntry<>("a", "65")
            ),
            q.getPairs());

        assertEquals("65", q.getLast("a"));
        assertNull(q.getAll("a").iterator().next());
        assertEquals("", q.getLast("b"));
    }

    @Test
    void appending() {
        Params base = Queries.parse("m=5&m=6");
        assertNotNull(base);
        Params appended = base.append("m", "6") // again
            .append("a", "before")
            .append("m", "7")
            .append("z", "after");

        assertEquals(Arrays.asList("5", "6", "6", "7"), appended.getAll("m"));
        assertEquals("7", appended.getLast("m"));

        List<Map.Entry<String, String>> pairs = appended.getPairs();
        Map.Entry last = pairs.get(pairs.size() - 1);
        assertEquals("z", last.getKey());
        assertEquals("after", last.getValue());
    }
}
