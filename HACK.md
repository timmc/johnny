# Hacking on johnny

Contribution guidelines and future work.

## Development ideals:

- Fail fast
- Allow parsing/construction without validation
- Use immutable data structures, ideally persistent (that means
  structure-sharing, not persisted-to-disk!)
- UTF-8 always

## Pending design decisions

- Case-fold protocol and host? -- RFC 3986 prefers lowercase
- Checked or unchecked exceptions?
- Validate by default?

## TODO

- Steal tests from other URL libs
- getHost vs. getHostRaw? (IPv6 with zone can require encoding)
- Make Suites of parser, manipulators, and encoders
  - Order-preserving query suite
  - Conservative encoding suite
- Split out encoding methods from Urls.java into Encoders
- Equality & comparators (see RFC 3986 section 6)
- Cloning
- Roundtripping of encoding decisions. May want to preserve:
  - Case of percent-encodes (`%2f` vs. `%2F`) -- RFC 3986 prefers
    uppercase
  - Encoding of optionally-encoded chars (e.g. `?` in query)
  - Empty query components (e.g. `&&`)
- Ensure GC hygiene re: substrings (an Url impl might hand back
  substrings that hold reference to their (larger) parent strings)
- Harden query impls against HashDoS attack
- Test that `;` is escaped in at least one query encoder

## Features to add

- Use of File as path (encode segments to avoid production of matrix
  params)
- Expansion to other kinds of URIs.
- Relative URLs
- StringBuilder-backed impls (store offsets for fast getters)

### Component processing

Parse and manipulate components:

- path (/-delimited)
  - collapsing of /./ segments (RFC 3986)
  - relative URI resolution (RFC 3986)
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
