# Gallery of Bugs

A listing of how various URL libraries fail at correctly handling
URLs, provided as motivation for using the Johnny URL library.

## Premature decoding of query

`java.net.URI` provides both `getQuery` and `getRawQuery`. The
former leads to bugs by exposing encoded `&` chars inside query
values:

```java
new java.net.URI("http://localhost?candy=M%26M").getQuery().split("&"); // ["candy=M", "M"]
```

No one is going to know to look under "R" for `getRawQuery`, so there
is an endless parade of bugs due to premature decoding. (The same
happens for the path.)

Johnny attempts to solve this by 1) yielding a structured result for
`getQuery` (does not decode until after parsing), and 2) using the
name `getQueryRaw` to aid in API discovery.

```java
Urls.parse("http://localhost?candy=M%26M").getQuery().getLast("candy"); // "M&M"
```

## Non-deterministic DNS-based equals

`java.net.URL` actually does a *DNS lookup* when you call `.equals`:

```java
new java.net.URL("http://example.net/").equals(new java.net.URL("http://example.org/")) // true
```

What should be a couple of string comparisons instead returns
different values depending on a network call.

Johnny uses piece-wise equality but does not perform host lookups.

```java
Urls.parse("http://example.net/").equals(Urls.parse("http://example.org/")) // false
```

RFC 3986 defines a ladder of progressively more complex
comparison. Johnny does not yet fall into any of those categories, but
will at some point provide a mechanism for checkign equality at those
different levels.

## Over-encoding of query

`java.net.URI` has several piece-wise contructors that accept a
scheme, hostname, path, query, etc. However, it assumes that pieces
like the query have *not yet been* encoded, and encodes them for the
caller.

This means that there is no way to use j.n.URI to construct
`http://example.com/?ampersand=%26` or other URLs with reserved
characters in their data:

```java
// There is no value for x that will make this true:
String x = ?;
URI piecewise = new URI("http", "example.com", "/", x, null);
URI wholesale = new URI("http://example.com/?ampersand=%26");
piecewise.equals(wholesale);
```

Johnny correctly assembles URIs without any second-guessing:

```java
// Use pre-encoded query or use a builder:
new ImmutableUrl("http", null, "example.com", null, "/", "ampersand=%26", null);
new ImmutableUrl("http", "example.com").withPathRaw("/").withQuery(Queries.from("ampersand", "&"));
// "http://example.com/?ampersand=%26"
```

## Ignoring bogus port numbers

`java.net.URL` parses Devanagari numerals in port numbers instead of
requiring Latin numerals:

```java
new java.net.URL("http://example.com:८०८०/").getPort() // 8080
```

`java.net.URI` on the other hand silently drops the host and port:

```java
java.net.URI uri = new java.net.URI("http://example.com:८०८०/");
uri.getHost(); // null
uri.getPort(); // -1
uri.getAuthority(); // "example.com:८०८०"
```

Johnny rejects the URL:

```java
Urls.parse("http://example.com:८०८०/");
// java.lang.IllegalArgumentException: URI authority section ends in invalid port (or is unbracketed IPv6 address)
// 	at org.timmc.johnny.UriAuthority.parseGeneric(UriAuthority.java:68)
// 	at org.timmc.johnny.Rfc3986Uri.parseAuthority(Rfc3986Uri.java:89)
// 	at org.timmc.johnny.SchemeSpecificUriParser.parse(SchemeSpecificUriParser.java:19)
// 	at org.timmc.johnny.ImmutableUrl.from(ImmutableUrl.java:54)
// 	at org.timmc.johnny.Urls.parse(Urls.java:43)
```

## Conflating query with POST data

`java.net.URLEncoder` is commonly used to encode strings for use in
raw URL components. However, from URLEncoder's own docs:

> Utility class for HTML form encoding. This class contains static
> methods for converting a String to the
> `application/x-www-form-urlencoded` MIME format.

That format encodes spaces as `+` instead of as `%20`, which is fine
for the pseudo querystring format used in POST bodies, but not in URL
queries (where a raw `+` might represent itself.)

Johnny makes sure to always encode spaces as `%20` in queries and will
decode `+` to itself unless an alternative parser is specified.

## Disregard for repeated keys or missing values

TODO: Doc examples of APIs that only permit at most one value per key in queries or don't allow missing values.

## Greedy pair-splitting

TODO: Doc examples of libraries that mis-parse `?foo=bar=baz`

