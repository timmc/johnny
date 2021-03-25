# Hacking on johnny

So you'd like to improve johnny? Great! This file will help orient you
to the library and give you guidance on what needs work.

## Orientation

### Structure

While the johnny library is written in Kotlin, the test suite
includes Java to ensure that the API is Java-friendly.

Some tests are still in Clojure from an earlier iteration.

### Development ideals:

- Stick to the standards
- ...but provide safety valves for non-compliant usage
- Allow parsing/construction without validation
- Use immutable data structures, ideally persistent (that means
  structure-sharing, not persisted-to-disk)
- UTF-8 always (but provide facilities to allow users to introduce
  other encodings)
- Advertise possible throwing of runtime exceptions, except for
  trivial ones like NPE

## Contributing

### Building

johnny is managed with the Maven build tool with some tests still
run via Leiningen.

- Build: `mvn clean compile` (not usually necessary, but if
  you encounter surprising behavior during tests, you may want to do
  this clean rebuild)
- Test: `mvn test && lein test`

You'll likely need to run the build using JDK 1.8 rather than newer,
module-system JDKs, e.g.

`JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/ mvn package`

### Release

Deploy snapshots to [Sonatype's open source repo hosting][ossrh] via
`mvn clean deploy`.

[ossrh]: https://central.sonatype.org/pages/ossrh-guide.html

Releases are a little more complicated. `mvn release:clean
release:prepare` and then `mvn release:perform`. The release should
appear in https://oss.sonatype.org/#stagingRepositories after a few
minutes (when logged in as `timmc`). Then
[manually release][manual-release] the staging repository by "closing"
it. It will take some time for this to complete, and even longer for
the deployment to sync to the Central repo.

[manual-release]: https://central.sonatype.org/pages/releasing-the-deployment.html

Dokka, the Kotlin documentation generator, has some verbose complaints
that are mostly irrelevant. To strip out most of the noise and see if
there are any real issues, run:

```
mvn clean dokka:javadocJar \
  | grep -v INFO \
  | grep -v 'cannot be used in inline' \
  | grep -v "Can't find node by signature not implemented for"
```

### Process

All skill levels welcome. Please consider opening an issue before
sending a pull request with a non-trivial amount of work.

## What to do

Work on any of the following is helpful!

- Bugs
- Standards compliance issues
- Documentation
- Features
- Build tooling

Reports of bugs and discussions of feature ideas are welcome even
without a patch in hand (but resolving them may take longer, of
course.)

### Bugs


### Features

- `getHost`/`withHost` (see Host Parsing section)
- No checked exceptions -- switch to unchecked.
- Support for extracting path parameters (aka matrix parameters)
- Compatibility: Support treating + as a space (opt-in)
- Use of File as path (encode segments to avoid production of matrix
  params)
- Expansion to other kinds of URIs.
    - or just support generic URI syntax
- StringBuilder-backed impls (store offsets for fast getters)
- Parsing/matching of paths and queries based on templates,
  e.g. `"/video/{id}/sources;limit={?limit}"`
  (remember to match across encoding, e.g. `%61` matches `a`)
- Harden query impls against HashDoS attack
- Equality & comparators (see RFC 3986 section 6)
- Normalizers (e.g. decode all unreserved chars)
- Validation of ports as being 1–65535?

#### Component processing

Parse and manipulate components:

- path (/-delimited)
    - collapsing of /./ segments (RFC 3986)
    - relative reference resolution (RFC 3986)
    - appending a list of segments
- querystring
    - FormEncoded utility
- User and password components
- Host component
    - Get public suffix (foo.brightcove.com -> com)
    - Get private suffix
    - "Is this host equal to or a subdomain of this other host/one of
      these other hosts?"
- Lambda support for any of the above: `withQueryChange(...lambda...)`
- "Does the URL match this origin/one of these origins?"

### Tests

- Tests around equality comparison of case-folding, e.g. Turkish dotless i:
  https://eng.getwisdom.io/hacking-github-with-unicode-dotless-i/
  (that one is about the local portion of an email address, but we should check
  on handling in regnames)
- Steal tests from other URL libs
- Add fuzz tests/generative tests
    - Perhaps grab data from https://commoncrawl.org and extract all hrefs
- Test that `;` is escaped in at least one query encoder
- Test that NPE is thrown wherever null is not accepted
- Example of raw non-ASCII in host: `☁→❄→☃→☀→☺→☂→☹→✝.ws`
- Test that we don't fall victim to java.net.URI's constructor bug:
  There is no `x` such that
  `java.net.URI("http", "example.com", "/", x, null).equals(new java.net.URI("http://example.com/?ampersand=%26")`.
- Correctly round-trip absolute domain names

### Design decisions

- Case-fold scheme and host? -- RFC 3986 prefers lowercase
- How to handle empty final path component? (e.g. `/foo/bar/`)
- Validate by default?
- Which parsers and encoders accept null inputs?
- Roundtrip encoding decisions? May want to preserve:
    - Case of percent-encodes (`%2f` vs. `%2F`) -- RFC 3986 prefers
      uppercase
    - Encoding of optionally-encoded chars (e.g. `?` in query)
    - Empty query components (e.g. `&&`)
- Configurable/composable parsers and encoders:
    - Accept suites or suite elements in parsing, manipulation, and
      encoding methods.
    - Or even allow embedding of CodecSuite instances into Url and
      other objects?
    - Example suites and suite features:
        - Order-preserving query manip
        - Conservative vs. minimal encoding
        - always/only encode provided chars (BitSet is mutable, but
          BigInteger isn't...)
        - only encode provided char sets for each URL component
        - application/x-www-form-encoded variation (use + instead
          of %20)
        - '#' unencoded in fragment (may cause problems with some bad parsers)
        - Charset options: Decode from non-UTF-8, encode to non-UTF-8 (do we
          even want to allow this?)
        - WebUrl#reEncode: Decode and then encode with various options
- Size limits
    - Overall URL (check common browser, server, and proxy limits)
    - Limits on any components? (Either number of parts, or length of
      each part.)

#### Host parsing

Host parsing turns out to be tricky for the following reasons:

- The host component is a reg-name or an ip. Registered names are
  *usually* domain names (or at least the subset of domain names that
  *can* be hostnames, e.g. those without underscores), but RFC 3986
  allows for `*( unreserved / pct-encoded / sub-delims )` which has
  delimiters that might be permissible as data in some scheme. Therefore
  we cannot blindly percent-decode it.
- IPv6 addresses can have a zone identifier.  RFC 6874 describes how
  to include these in RFC 3986 URIs, and it involves having an encoded
  `%` char, which means IPv6 definitely has an encoded vs. decoded
  form.
- Java's Inet6Address cannot be constructed with a zone identifier
  that is not available on the current system (!) and in any event
  doesn't have a nice way to build/format objects. The latter problem
  also applies to IPv4, although those are easier to work with so it's
  not as much of a concern. Google's Guava lib could help here a bit,
  although it does not support zone identifiers (at least in v14).
- All host types can have encoded characters, although some should
  not. For instance, non-ASCII in a domain name can and should be
  encoded. (Or perhaps should be represented in punycode...) An IPv4
  address could even have a number encoded, although a compliant
  formatter must not produce such a thing.
- Need to decide how to capture absolute vs. non-absolute nature of
  domain names (ending in `.` or not).

See commit `13523afcc3789b` ("Delete Host{,Parser,Formatter} support
for now.") for abandoned code and tests that were working towards this
feature.

### Documentation

- Strong warnings around not using Query encoders/decoders for parsing
  `application/x-www-form-urlencoded` POST bodies. (Supply an
  alternative.)

### Research

### Audits to perform

- Ensure GC hygiene re: substrings (an Url impl might hand back
  substrings that hold reference to their (larger) parent strings)

## Features not to add

- Efficient query manipulation (for now)

### Templating

RFC 6570

Belongs in another (dependent) lib.

## Specs

Specifications to draw from.

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
- http://wiki.call-cc.org/eggref/5/uri-generic seems to have the same
  aim as this project, and a good collection of tests

### Unuseful

I have evaluated these and found them unuseful for this project:

- http://ostermiller.org/utils/src/CGIParser.java.html does not allow
  null query values

### Unevaluated

- com.google.gdata.util.common.base.CharEscapers
- Apache HttpCore & HttpClient

#### Possibly interesting APIs

- Urly
- https://github.com/mikaelhg/urlbuilder
- https://docs.racket-lang.org/net/url.html
- https://github.com/sporkmonger/addressable
- https://stackoverflow.com/questions/5913613/standard-java-class-for-common-url-uri-manipulation
- https://gist.github.com/agentgt/3011049

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
