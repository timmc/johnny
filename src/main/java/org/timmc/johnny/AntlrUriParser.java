package org.timmc.johnny;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.timmc.johnny.gen.parse.RFC_3986_6874Lexer;
import org.timmc.johnny.gen.parse.RFC_3986_6874Parser;
import org.timmc.johnny.gen.parse.RFC_3986_6874Parser.*;
import org.timmc.johnny.parts.Host;
import org.timmc.johnny.parts.IPv4Host;
import org.timmc.johnny.parts.IPv6Host;
import org.timmc.johnny.parts.IPvFutureHost;
import org.timmc.johnny.parts.RegNameHost;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * A strict URL parser directly derived from ABNF grammars in the relevant RFCs.
 */
public class AntlrUriParser implements UrlParser {

    public Url parse(String in) throws UrlDecodeException {
        try {
            return parseInner(in);
        } catch(RecognitionException re) {
            throw new UrlDecodeException("Could not recognize URL from input", re);
        } catch(ParseCancellationException pce) {
            throw new UrlDecodeException("Could not recognize URL from input", pce);
        }
    }

    private Url parseInner(String in) throws UrlDecodeException, RecognitionException, ParseCancellationException {
        if (in == null) { throw new NullPointerException("uri may not be null."); }

        RFC_3986_6874Lexer lexer = new RFC_3986_6874Lexer(CharStreams.fromString(in));
        RFC_3986_6874Parser parser = new RFC_3986_6874Parser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());

        // Record whether any errors have been reported during parsing,
        // don't print to stdout...
        FlaggingErrorListener errorListener = new FlaggingErrorListener();
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        lexer.addErrorListener(errorListener);

        UriContext uri = parser.uri();
        SchemeContext scheme = uri.scheme();
        Hier_partContext hier = uri.hier_part();
        AuthorityContext authority = hier.authority();
        UserinfoContext userinfo = authority.userinfo();
        HostContext host = authority.host();
        Reg_nameContext regname = host.reg_name();
        Ipv4addressContext ipv4 = host.ipv4address();
        Ip_literalContext ipNewer = host.ip_literal();
        Ipv6addressContext ipv6 = ipNewer == null? null : ipNewer.ipv6address();
        Ipv6addrzContext ipv6zoned = ipNewer == null? null : ipNewer.ipv6addrz();
        IpvfutureContext ipFuture = ipNewer == null ? null : ipNewer.ipvfuture();
        PortContext port = authority.port();
        Path_abemptyContext path = hier.path_abempty(); // the only one that involves an authority
        QueryContext query = uri.query();
        Fragment_1Context fragment = uri.fragment_1();

        Host parsedHost;
        if (regname != null) {
            parsedHost = new RegNameHost(host.getText());
        } else if (ipv4 != null) {
            List<Integer> octets = new ArrayList<Integer>(4);
            int index = 0;
            for (Dec_octetContext octet : ipv4.dec_octet()) {
                octets.add(Integer.parseInt(octet.getText()));
            }
            parsedHost = new IPv4Host(octets, host.getText());
        } else if (ipv6 != null) {
            parsedHost = new IPv6Host(ipv6.getText(), null, host.getText());
        } else if (ipv6zoned != null) {
            String ipv6addr = ipv6zoned.ipv6address().getText();
            String zone = ipv6zoned.zoneid().getText();
            parsedHost = new IPv6Host(ipv6addr, zone, host.getText());
        } else if (ipFuture != null ){
            StringBuilder hexver = new StringBuilder();
            for (HexdigContext digit: ipFuture.hexdig()) {
                hexver.append(digit.getText());
            }
            int formatVersion = Integer.parseInt(hexver.toString(), 16);
            parsedHost = new IPvFutureHost(formatVersion, host.getText());
        } else {
            throw new UrlDecodeException("Was not able to determine format of URI host");
        }

        Url ret;
        try {
            ret = new ImmutableUrl(
                        maybeText(scheme),
                        maybeText(userinfo),
                        parsedHost,
                        maybeText(port),
                        maybeText(path),
                        maybeText(query),
                        maybeText(fragment));
        } catch(NumberFormatException nfe) {
            throw new UrlDecodeException("Could not parse URL: Invalid port number");
        }

        String errMsg = errorListener.getError();
        if (errMsg != null) {
            throw new UrlDecodeException("Could not parse URL: " + errMsg);
        }

        // Check if entire string was consumed and matched
        String matched = uri.getText();
        if (!in.equals(matched)) {
            throw new UrlDecodeException("Could not parse URL: " +
                    "error at position " + matched.length());
        }

        return ret;
    }

    private String maybeText(ParserRuleContext x) {
        return x == null ? null : x.getText();
    }
}

/** Error listener that just records whether errors have occurred. */
class FlaggingErrorListener implements ANTLRErrorListener {
    private String errorMsg = null;

    FlaggingErrorListener() {}

    /** Returns an error message if an error has been encountered, else null. */
    String getError() {
        return errorMsg;
    }

    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        errorMsg = String.format("Error on line %d at position %d: %s",
                                 line, charPositionInLine, msg);
    }

    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                                boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // do nothing
    }

    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                                            BitSet conflictingAlts, ATNConfigSet configs) {
        // do nothing
    }

    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                                         int prediction, ATNConfigSet configs) {
        // do nothing
    }
}
