# Johnny: Read and write URLs on the JVM

Johnny is a Kotlin library that helps you read, modify, and write URLs
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
  <version>0.2.1</version>
</dependency>
```

Leiningen:

```clojure
[org.timmc/johnny "0.2.1"]
```

## Usage

The public interface is defined by the classes in the
`org.timmc.johnny` package, starting with the `Urls` class. This
interface follows semantic versioning.

TODO: Post the generated Javadocs somewhere browseable.

Packages with "internal" in the name are not part of the public
interface and *may* change at any time, or not be as easily accessible
from Java (as they are written in and tested from Kotlin).

## Features

- Fluent builder interface for URLs and URL components
- Minimal encoding of each URL component (e.g. querystring params can
  have unencoded "?")
- Support for duplicate keys in querystrings
- Support for querystring keys without values (`foo` vs. `foo=`)
- Use of immutable data structures so that manipulations are
  thread-safe

## Opinions

I had to make some decisions on semantics where the RFCs leave things
unspecified or the API would otherwise be overly pedantic.

- There is no meaningful difference between querystrings that are
  missing (`https://example.net/foo`) or empty
  (`https://example.net/foo?`). Raw strings available if you care
  about the difference.
- Similarly, there is no meaningful difference between paths that are
  missing (`https://example.net`) or just have the root slash
  (`https://example.net/`).
- Ports can only take values from 0 to 65535, inclusive, since that's
  pretty well baked into everything now.

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

If you're willing to help out, let me know!

See [HACK.md](HACK.md) for loosely arranged thoughts on the roadmap,
extant bugs, and decisions that need to be made.

## License

Copyright 2013–2019 Tim McCormack (where commits authored using personal
email address) and Brightcove, Inc. (where using brightcove.com address)
as well as other contributors as commit metadata indicates.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
