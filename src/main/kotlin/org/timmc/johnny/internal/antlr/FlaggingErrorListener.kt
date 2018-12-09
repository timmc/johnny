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

    override fun reportAmbiguity(
        recognizer: Parser?, dfa: DFA, startIndex: Int, stopIndex: Int,
        exact: Boolean, ambigAlts: BitSet?, configs: ATNConfigSet?
    ) {
        // do nothing
    }

    override fun reportAttemptingFullContext(
        recognizer: Parser?, dfa: DFA?, startIndex: Int, stopIndex: Int,
        conflictingAlts: BitSet?, configs: ATNConfigSet?
    ) {
        // do nothing
    }

    override fun reportContextSensitivity(
        recognizer: Parser?, dfa: DFA?, startIndex: Int, stopIndex: Int,
        prediction: Int, configs: ATNConfigSet?
    ) {
        // do nothing
    }
}
