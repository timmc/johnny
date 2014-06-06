# Why can't Johnny read URLs?

**johnny: A URL parsing and manipulation library for the JVM**

For a language used extensively in web-facing application, it's
surprising that Java lacks a library that can (correctly!) parse and
manipulate URLs. The result is that everyone ends up writing their own
URL library, and the result of that is security flaws and subtly
broken apps. (java.net.URL accepts `८०` as a port number; java.net.URI
helpfully offers to decode paths wholesale instead of segmenting them
first; innumerable querystring APIs mishandle duplicate keys or
missing values.)

The goal is to be able to write this:

```java
Urls.parse("http://google.com/search?q=url#fragment").withDomain("brightcove.com").querySetKey("foo", "bar").unparse() // "http://brightcove.com/search?q=url&foo=bar#fragment"
```

...but the library is **nowhere near ready**. **DO NOT USE**.  It
needs further API development and grooming, a good long sit-down with
some RFCs, careful selection of supporting libraries, a huge number of
careful tests, and way more eyeballs.

If you're willing to help out, let me know! I'm also considering
opening up a Bitcoin bug bounty once the library is at the alpha
stage, and I would appreciate both deposits and withdrawals at that
point.

## Why use johnny

Correct handling of Unicode in domain names:

```java
// URI silently fails to decode port when it doesn't understand the host:
new java.net.URI("http://example.網絡.cn:8080/").getPort(); //= -1
// Johnny can handle unicode hostnames...
Urls.parse("http://example.網絡.cn:8080/").getPort(); //= 8080
// ...and will throw if the hostname is not valid:
(Urls/parse "http://valid_in_dns.but_not_as_host/") //! MalformedURLException Could not parse host from authority section of URI
```

Correct decoding of query components:

```java
// URI offers to decode query before destructuring it:
new java.net.URI("http://localhost?foo=b%26ar").getQuery().split("&"); //= ["foo=b", "ar"]
// Johnny knows not to percent-decode until the pairs are parsed:
Urls.parse("http://localhost?foo=b%26ar").getQuery().getLast("foo"); //= "b&ar"
```

Checks equality in a reasonable fashion:

```java
// j.u.URL actually does a *DNS lookup* when you call .equals:
new java.net.URL("http://example.net/").equals(new java.net.URL("http://example.org/")) //= true
// Johnny uses piece-wise equality (but may implement a deeper matching option in the future)
Urls.parse("http://example.net/").equals(Urls.parse("http://example.org/")) //= false
```

Correctly encodes for different URL components:

(TODO: Example with j.n.URLEncoder incorrectly encoding spaces as `+`.)

## Goals

* Minimal encoding of each URL component (e.g. querystring params can
  have unencoded "?")
* Support for extracting path parameters (aka matrix parameters)
* Support for duplicate keys in querystrings
* Support for querystring keys without values (`foo` vs. `foo=`)
* Use of immutable data structures so that manipulations are
  thread-safe
* Attempt to balance simple interface against configurability.

### More goals

* Pluggable parsing, validation, manipulation, and encoding

## Usage

FIXME

## Contributing

See [HACK.md](HACK.md).

## License

FIXME (will be Apache or MIT)
