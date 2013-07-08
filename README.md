# Why can't Johnny read URLs?

**johnny: A URL parsing and manipulation library for the JVM**

For a language used extensively in web-facing application, it's
surprising that Java lacks a library that can (correctly!) parse and
manipulate URLs. The result is that everyone ends up writing their own
URL library, and the result is security flaws and subtly broken
apps. (java.net.URL accepts `८०` as a port number; java.net.URI
helpfully offers to decode paths wholesale instead of segmenting them
first; innumerable querystring APIs mishandle duplicate keys or
missing values.)

The goal is to be able to write this:

```java
WebUrl.from("http://google.com/search?q=url#fragment").withDomain("brightcove.com").addQueryParam("foo", "bar").toString() // "http://brightcove.com/search?q=url&foo=bar#fragment"
```

## Goals

* Minimal encoding of each URL component (e.g. querystring params can
  have unencoded "?")
* Support for extracting path parameters (aka matrix parameters)
* Support for duplicate keys in querystrings
* Support for querystring keys without values (`foo` vs. `foo=`)
* Use of immutable data structures so that manipulations are
  thread-safe

## Usage

FIXME

## Contributing

See HACK.md.

## License

FIXME
