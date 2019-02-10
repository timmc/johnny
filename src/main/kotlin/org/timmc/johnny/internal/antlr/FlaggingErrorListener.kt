package org.timmc.johnny.internal.antlr

import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA

import java.util.BitSet

/** Error listener that just records whether errors have occurred.  */
class FlaggingErrorListener : ANTLRErrorListener {
    /** Contains an error message if an error has been encountered, else null. */
    var error: String? = null
        private set

    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?,
        line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        error = "Error on line $line at position $charPositionInLine: $msg"
    }

    override fun reportAttemptingFullContext(
        recognizer: Parser?, dfa: DFA?, startIndex: Int, stopIndex: Int,
        conflictingAlts: BitSet?, configs: ATNConfigSet?
    ) {
        // Do nothing: It's OK if the parser falls back to full-context parsing
    }

    override fun reportAmbiguity(
        recognizer: Parser?, dfa: DFA, startIndex: Int, stopIndex: Int,
        exact: Boolean, ambigAlts: BitSet?, configs: ATNConfigSet?
    ) {
        error = "Ambiguous parse between $startIndex and $stopIndex"
    }

    override fun reportContextSensitivity(
        recognizer: Parser?, dfa: DFA?, startIndex: Int, stopIndex: Int,
        prediction: Int, configs: ATNConfigSet?
    ) {
        // Do nothing: Context-sensitivity isn't great, but this does not
        // indicate an ambiguity; there was a unique result.
    }
}
