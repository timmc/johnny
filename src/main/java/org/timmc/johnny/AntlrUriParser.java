package org.timmc.johnny;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.timmc.johnny.gen.parse.RFC_3986_6874Lexer;
import org.timmc.johnny.gen.parse.RFC_3986_6874Parser;
import org.timmc.johnny.gen.parse.RFC_3986_6874Parser.*;

import java.net.MalformedURLException;
import java.util.BitSet;

/**
 * A strict URL parser directly derived from ABNF grammars in the relevant RFCs.
 */
public class AntlrUriParser implements UrlParser {

    public Object[] parse(String in) throws MalformedURLException {
        try {
            return parseInner(in);
        } catch(RecognitionException re) {
            throw (MalformedURLException) (new MalformedURLException("Could not recognize URL from input").initCause(re));
        } catch(ParseCancellationException pce) {
            throw (MalformedURLException) (new MalformedURLException("Could not recognize URL from input").initCause(pce));
        }
    }

    private Object[] parseInner(String in) throws MalformedURLException, RecognitionException {
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
        PortContext port = authority.port();
        Path_abemptyContext path = hier.path_abempty(); // the only one that involves an authority
        QueryContext query = uri.query();
        Fragment_1Context fragment = uri.fragment_1();

        // This may be a partial URL depending on whether there were parsing errors
        Object[] parts;
        try {
            parts = new Object[]{
                        scheme.getText(),
                        userinfo == null ? null : userinfo.getText(),
                        host.getText(),
                        port == null ? null : port.getText(),
                        path.getText(),
                        query == null ? null : query.getText(),
                        fragment == null ? null : fragment.getText()};
        } catch(NumberFormatException nfe) {
            throw new MalformedURLException("Could not parse URL: Invalid port number");
        }

        String errMsg = errorListener.getError();
        if (errMsg != null) {
            throw new MalformedURLException("Could not parse URL: " + errMsg);
        }

        // Check if entire string was consumed and matched
        String matched = uri.getText();
        if (!in.equals(matched)) {
            throw new MalformedURLException("Could not parse URL: " +
                    "error at position " + matched.length());
        }

        return parts;
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
