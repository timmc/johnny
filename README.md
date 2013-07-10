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
Urls.parse("http://google.com/search?q=url#fragment").withDomain("brightcove.com").querySetKey("foo", "bar").toString() // "http://brightcove.com/search?q=url&foo=bar#fragment"
```

...but the library is **nowhere near ready**. **DO NOT USE**.  It
needs further API development and grooming, a good long sit-down with
some RFCs, careful selection of supporting libraries, a huge number of
careful tests, and way more eyeballs.

If you're willing to help out, let me know! I'm also considering
opening up a Bitcoin bug bounty once the library is at the alpha
stage, and I would appreciate both deposits and withdrawals at that
point.

## Goals

* Minimal encoding of each URL component (e.g. querystring params can
  have unencoded "?")
* Support for extracting path parameters (aka matrix parameters)
* Support for duplicate keys in querystrings
* Support for querystring keys without values (`foo` vs. `foo=`)
* Use of immutable data structures so that manipulations are
  thread-safe

### More goals

* Pluggable parsing, validation, manipulation, and encoding

## Usage

FIXME

## Contributing

See HACK.md.

## License

FIXME (will be Apache or MIT)
