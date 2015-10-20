# Hacking on johnny

Contribution guidelines and future work.

## Structure

While the johnny library is written entirely in Java, the test suite
is mostly Clojure to allow for rapid development of comprehensive
tests.

## Building

johnny is managed with the [Leiningen][lein] build tool.

- Build: `lein do clean, deps, javac` (not usually necessary, but if
  you encounter surprising behavior during tests, you may want to do
  this clean rebuild)
- Test: `lein test` (should incrementally recompile)
- Package: `lein do pom, jar`
- Enter an interactive Clojure session, `lein repl`

[lein]: http://leiningen.org/

## Development ideals:

- Fail fast
- Allow parsing/construction without validation
- Use immutable data structures, ideally persistent (that means
  structure-sharing, not persisted-to-disk!)
- UTF-8 always (but provide facilities to allow users to introduce
  other encodings)

## Pending design decisions

- Case-fold scheme and host? -- RFC 3986 prefers lowercase
- Checked or unchecked exceptions?
- Validate by default?
- Which parsers and encoders accept null inputs?

## TODO

- Get rid of Clojure dependency -- replace use of PersistentHashMap
  and similar with array-copying. We're not going to have tons of
  querystrings larger than 32 elements, so we don't get any perf
  benefits from PHM anyhow!
- No checked exceptions -- switch to unchecked.
- 
- Test that we don't fall victim to java.net.URI's constructor bug:
  There is no `x` such that
  `java.net.URI("http", "example.com", "/", x, null).equals(new java.net.URI("http://example.com/?ampersand=%26")`.
- Accept suites or suite elements in parser and encoder methods.
    - Or even allow embedding of CodecSuite instances into Url and
      other objects?
- Correctly round-trip absolute domain names
- getHost vs. getHostRaw? (IPv6 with zone can require encoding)
- Make Suites of parser, manipulators, and encoders
  - Order-preserving query suite
  - Conservative encoding suite
- Efficient persistent ordered Query
    - Two fields:
        - PersistentVector of Map.Entry holding key-value pairs or nulls
            - When a pair is deleted, null it out (preserve indexes)
            - When a pair is modified, overwrite it
        - PersistentHashMap of keys -> PersistentTreeSet of pair indexes
            - Fast lookup of values, in order
    - Could also have index on values
- Equality & comparators (see RFC 3986 section 6)
- Normalizers (e.g. decode all unreserved chars)
- File path parser (drop empty segments including final; treat
  semicolons as non-delimiters)
- Cloning
- Roundtripping of encoding decisions. May want to preserve:
    - Case of percent-encodes (`%2f` vs. `%2F`) -- RFC 3986 prefers
      uppercase
    - Encoding of optionally-encoded chars (e.g. `?` in query)
    - Empty query components (e.g. `&&`)
- Ensure GC hygiene re: substrings (an Url impl might hand back
  substrings that hold reference to their (larger) parent strings)
- Harden query impls against HashDoS attack

### Tests

- Steal tests from other URL libs
- Add fuzz tests/generative tests
- Test that `;` is escaped in at least one query encoder
- Test that NPE is thrown whereever null is not accepted

### Documentation

- Strong warnings around not using Query encoders/decoders for parsing
  `application/x-www-form-urlencoded` POST bodies. (Supply an
  alternative.)

### Features

- Compatibility: Support treating + as a space (opt-in)
- Use of File as path (encode segments to avoid production of matrix
  params)
- Expansion to other kinds of URIs.
    - or just support generic URI syntax
- StringBuilder-backed impls (store offsets for fast getters)
- Parsing/matching of paths and queries based on templates,
  e.g. `"/video/{id}/sources;limit={?limit}"`
  (remember to match across encoding, e.g. `%61` matches `a`)

### Component processing

Parse and manipulate components:

- path (/-delimited)
    - collapsing of /./ segments (RFC 3986)
    - relative reference resolution (RFC 3986)
- querystring
    - &-delimited or ;-delimited
    - keep or collapse duplicate keys
    - FormEncoded utility
- User portion
- Hostname portion
- Lambda support for any of the above: `withQueryChange(...lambda...)`

### Variations

- Encoding options:
    - Minimal (default)
    - conservative
    - always/only encode provided chars (BitSet is mutable, but
      BigInteger isn't...)
    - only encode provided char sets for each URL component
    - application/x-www-form-encoded variation (use + instead
      of %20)
    - '#' unencoded in fragment (may cause problems with some bad parsers)
- Charset options: Decode from non-UTF-8, encode to non-UTF-8 (do we
  even want to allow this?)
- WebUrl#reEncode: Decode and then encode with various options

## Features not to add

### Templating

RFC 6570

Belongs in another (dependent) lib.

## Specs

- RFC 3986: Generic URI Syntax -- use the http portion
- RFC 2616: Defines HTTP URLs, makes reference to 2396 (now 3986)
- RFC 2732: IPv6 in URL
- RFC 6874: IPv6 scope/zone identifier (and problems with % in
  authority)

Unused:

- RFC 1738 was an older URL spec, and was obsoleted. Its successors
  are a gopher URI spec and a telnet URI spec, neither appropriate
  here.

## Sources

### Useful

These have at least one useful thing:

- java.net.URL - mostly good parsing, but allows alternative numeric
  chars in port and doesn't decode fragment for you
- commons-httpclient/commons-httpclient 3.1 for URIUtils escapeWithinX
  methods (although it does parse fragments incorrectly by looking for
  last `#`) and URI bitset building

### Unuseful

I have evaluated these and found them unuseful for this project:

- http://ostermiller.org/utils/src/CGIParser.java.html does not allow
  null query values

### Unevaluated

- com.google.gdata.util.common.base.CharEscapers
- Apache HttpCore & HttpClient
- Urly (mostly the API choices)
- https://github.com/mikaelhg/urlbuilder

## Compliance

### Unresolved questions

What does this mean in RFC 3986?

> All URI references are parsed by generic syntax parsers when used.
> However, because hierarchical processing has no effect on an
> absolute URI used in a reference unless it contains one or more
> dot-segments (complete path segments of "." or "..", as described in
> Section 3.3), URI scheme specifications can define opaque
> identifiers by disallowing use of slash characters, question mark
> characters, and the URIs "scheme:." and "scheme:..".

Is it allowed to have unencoded "?" in the query component? §2.2
implies no. Compliant impls should be able to parse it just fine, but
maybe are not allowed to produce it.
