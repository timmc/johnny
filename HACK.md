# Hacking on johnny

Contribution guidelines and future work.

## Development ideals:

- Fail fast
- Allow parsing/construction without validation
- Use immutable data structures, ideally persistent (that means
  structure-sharing, not persisted-to-disk!)
- UTF-8 always

## Pending design decisions

- Case-fold protocol?
- Checked or unchecked exceptions?
- Validate by default?

## TODO

- Add features
- Automatically run tests against all impls of HttpUrl
- Steal tests from other URL libs

## Features to add

- Expansion to other kinds of URIs.
- Relative URLs

### Component processing

Parse and manipulate components:

- path (/-delimited)
- querystring
  - &-delimited or ;-delimited
  - keep or collapse duplicate keys
- User portion
- Hostname portion
- Lambda support for any of the above: `withQueryChange(...lambda...)`

### Variations

- Encoding options: Minimal (default), conservative, always encode
  provided chars, only encode provided char sets for each URL
  component
- Charset options: Decode from non-UTF-8, encode to non-UTF-8 (do we
  even want to allow this?)
- WebUrl#reEncode: Decode and then encode with various options

## Features not to add

### Templating

Belongs in another (dependent) lib.
