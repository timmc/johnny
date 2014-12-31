# Why can't Johnny read URLs?

**johnny: A URL parsing and manipulation library for the JVM**

For a language used extensively in web-facing application, it's
surprising that Java lacks a library that can (correctly!) parse and
manipulate URLs. The result is that everyone ends up writing their own
URL library, and the result of that is security flaws and subtly
broken apps. (java.net.URL accepts `८०` as a port number; java.net.URI
helpfully offers to decode paths wholesale instead of segmenting them
first and has an outright broken multipart constructor; innumerable
querystring APIs mishandle duplicate keys or missing values.)

The goal is to be able to write this:

```java
Urls.parse("http://google.com/search?q=url#fragment").withDomain("brightcove.com").querySetKey("foo", "bar").unparse() // "http://brightcove.com/search?q=url&foo=bar#fragment"
```

...but the library is **not ready**. **DO NOT USE**.  It
needs further API development and grooming, a good long sit-down with
some RFCs, careful selection of supporting libraries, a huge number of
careful tests, and way more eyeballs.

If you're willing to help out, let me know! I'm also considering
opening up a Bitcoin bug bounty once the library is at the alpha
stage, and I would appreciate both deposits and withdrawals at that
point.

## Why use johnny

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

Correctly assembles URLs from components:

```java
// There is no value for x that will make this true:
// java.net.URI("http", "example.com", "/", x, null).equals(new java.net.URI("http://example.com/?ampersand=%26");
// Johnny correctly assembles URIs without any second-guessing:
new ImmutableUrl("http", null, "example.com", null, "/", "ampersand=%26", null);
```

(TODO: Example with j.n.URLEncoder incorrectly encoding spaces as `+` in paths.)

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

Copyright 2013–2014 Brightcove, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
