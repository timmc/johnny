/**
 * A library for parsing and manipulating web URLs (http/https) correctly
 * and usefully.
 * <p>
 * The main class is {@link org.timmc.johnny.Urls}.
 * <p>
 * <b>Overview</b>
 * <p>
 * This library is organized around the successive parsing of nested structural elements.
 * Given a URL string, {@link org.timmc.johnny.Urls#parse(String)} converts it
 * into a {@link org.timmc.johnny.Url} data structure that may be inspected,
 * manipulated, and re-encoded as a string using a builder API.
 * {@link org.timmc.johnny.Url} contains 7 components, some of which have internal
 * structure. These may be further parsed and manipulated:
 * <p>
 * <pre><code>Url orig = Urls.parse("http://brightcove.com/login?a=b=c&amp;a=?d");
 * Url result = orig.withQuery(orig.getQuery()
 *                                 .append("foo", "bar")
 *                                 .replace("a", null));
 * result.format(); // "http://brightcove.com/login?a&amp;foo=bar"</code></pre>
 * <p>
 * These manipulations use persistent data structures (structure-sharing immutable objects)
 * so they are thread-safe by default. (You may opt into mutable data structures, but should
 * still use the builder API to make debugging via implementation swap easier.)
 * <p>
 * <b>Flexibility</b>
 * <p>
 * By default, the library uses strict parsers, allows repeated query parameter keys,
 * conflates null and empty values, and performs minimal encoding. If your application needs
 * alternative behavior, it can eschew the mainline API and use intermediate representations
 * to customize URL handling. For instance, to use a mutable query representation:
 * <p>
 * <pre><code>Url orig = Urls.parse("http://brightcove.com/login?a=b=c&amp;a=?d");
 * Params mutable = new MutableMultimapParams().appendAll(Urls.DEFAULT_QUERY_PARSER.parse(orig.getQueryRaw()));
 * mutable = mutable.append("foo", "bar").replace("a", null);
 * orig.withQuery(mutable).format(); // "http://brightcove.com/login?a&amp;foo=bar"
 * </code></pre>
 */
package org.timmc.johnny;

