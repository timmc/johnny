# Sources for grammars

The `RFC_3986_6874.g4` grammar was derived by the following process:

- Save RFC 3986 Appendix A to `src/main/grammer/RFC_3986.abnf`
- Save RFC 5234 Appendix B.1 to `src/main/grammer/RFC_5234.abnf`
    - This defines the base ABNF for RFC 3986
- Save the replacement ABNF in RFC 6874 to `src/main/grammer/RFC_6874.abnf`
    - This is an update to RFC 3986
- Create a combined ABNF from the above
    - Modify RFC 3986 ABNF as indicated in RFC 6874
    - Append RFC 5234
    - Save to `src/main/grammer/RFC_3986_6874.abnf`
- Run this through Abnf-To-Antlr
    - http://www.bobpinchbeck.com/abnf_to_antlr/Default.aspx
        - Source https://github.com/rpinchbeck/Abnf-To-Antlr
        - Use at least version 1.5.1 to avoid fixed bug around
          case-insensitivity of ABNF
    - Save to `src/main/grammar/RFC_3986_6874.g4`
    - Add `grammar RFC_3986_6874;` to the top of the file
- Strip out all rules that do not get used by other rules, except for
  the top-level `uri_reference` rule:
    - Discover unused rules: `for sym in $(grep -o '^[^\s/]+' -P src/main/grammar/RFC_3986_6874.g4 | tail -n+2); do grep src/main/grammar/RFC_3986_6874.g4 -e ".\b$sym\b" >/dev/null || echo $sym; done | grep -v '^uri_reference$'`
    - Delete all rules mentioned in that output
    - Repeat above until no output
    - Besides cutting the size of the lexer and parser in half, this
      also happens to work around a bug in ANTLR's Java targeting,
      wherein the Unicode character escapes `\u000A` and `\u000D` are
      emitted directly into Java sources, which will cause compilation
      errors. (See https://github.com/antlr/antlr4/issues/2281)

To compile the g4 grammar into Java files, run `generate.sh` from the root
directory.
