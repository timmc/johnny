# Johnny: Read and write URLs on the JVM

Johnny is a Java library that helps you read, modify, and write URLs
with in a safe, efficient, and standards-compliant fashion. Here's
Johnny replacing a host name and adding a query parameter:

```java
Urls.parse("https://"www.example.com/search?q=url#fragment")
    .withHost(new RegNameHost("ietf.org"))
    .querySetKey("foo", "bar")
    .format();
// "https://ietf.org/search?q=url&foo=bar#fragment"
```

## Why to use Johnny

- Attempts to conform to RFC 3986 ("Uniform Resource Identifier (URI):
  Generic Syntax") and RFC 6874 ("Representing IPv6 Zone Identifiers
  in Address Literals and Uniform Resource Identifiers"
    - See "[Gallery of Bugs](doc/gallery-of-bugs.md)" for how various
      URL libraries fail at this
    - Uses a parser programmatically generated from the
      specification—no custom parsers by default.
- Provides escape hatches for non-compliant use-cases
- Uses immutable data structures by default
- The fluent API is super nice to use

## Why to not use Johnny

- Despite an extensive test suite, has not been reality-tested. (Or
  perhaps you could try it out and help remove this bullet point!)
- Makes it slightly inconvenient to be bug-compatible with broken URL
  implementations. Bug or feature, you decide.
- Host parsing (domain vs. IP) is not yet provided
- Path parsing is still clunky

## Get it

**Johnny is currently in alpha** and the API may change dramatically
between sub-1.0 versions.

Maven:

```xml
<dependency>
  <groupId>org.timmc</groupId>
  <artifactId>johnny</artifactId>
  <version>0.1.1</version>
</dependency>
```

Leiningen:

```clojure
[org.timmc/johnny "0.1.1"]
```

## Usage

TODO: Post the generated Javadocs somewhere browseable. In the
meantime, start with the package docs:

https://github.com/timmc/johnny/blob/johnny-0.1.1/src/main/java/org/timmc/johnny/http/package-info.java

## Features

- Fluent builder interface for URLs and URL components
- Optional validation
- Minimal encoding of each URL component (e.g. querystring params can
  have unencoded "?")
- Support for duplicate keys in querystrings
- Support for querystring keys without values (`foo` vs. `foo=`)
- Use of immutable data structures so that manipulations are
  thread-safe

## Rationale

Why another URL library?

For a language used extensively in web-facing application, it's
surprising that Java lacks a library that can (correctly!) parse and
manipulate URLs. The result is that everyone ends up writing their own
URL library (it's deceptively hard), and the result of that is
security flaws and subtly (or not so subtly) broken apps.

The aspiration of Johnny is to both be correct and usable: If it's not
correct, there's no reason to write it; if it's not usable, no one
will use it.

## Contributing

If you're willing to help out, let me know! I'm also considering
opening up a Bitcoin bug bounty once the library is at the alpha
stage, and I would appreciate both deposits and withdrawals at that
point.

See [HACK.md](HACK.md) for loosely arranged thoughts on the roadmap,
extant bugs, and decisions that need to be made.

## License

Copyright 2013–2015 Brightcove, Inc. (where commits authored using
brightcove.com email address) and Tim McCormack (where using personal
address) as well as other contributers as commit metadata indicates.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
