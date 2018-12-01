package org.timmc.johnny.internal.antlr;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

/** Error listener that just records whether errors have occurred. */
public class FlaggingErrorListener implements ANTLRErrorListener {
    private String errorMsg = null;

    public FlaggingErrorListener() {}

    /** Returns an error message if an error has been encountered, else null. */
    public String getError() {
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
