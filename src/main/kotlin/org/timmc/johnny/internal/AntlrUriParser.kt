package org.timmc.johnny.internal

import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.timmc.johnny.*
import org.timmc.johnny.internal.antlr.FlaggingErrorListener
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Lexer
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Parser
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Parser.*

import java.util.ArrayList

/**
 * A strict URI parser directly derived from ABNF grammars in the relevant RFCs.
 */
class AntlrUriParser : UriParser {

    @Throws(UriDecodeException::class)
    override fun parseGenericUri(input: String): GenericUri {
        try {
            return parseInner(input)
        } catch (e: RecognitionException) {
            throw UriDecodeException("Could not recognize URI from input", e)
        } catch (e: ParseCancellationException) {
            throw UriDecodeException("Could not recognize URI from input", e)
        } catch (e: NullPointerException) {
            throw UriDecodeException("Unexpected null reference when reading URI parse tree", e)
        } catch (e: Exception) {
            throw UriDecodeException("Unexpected exception when parsing URI", e)
        } catch (e: AssertionError) {
            throw UriDecodeException("Unexpected assertion error when parsing URI", e)
        }
    }

    private fun setUpParser(input: String): Pair<RFC_3986_6874Parser, FlaggingErrorListener> {
        val lexer = RFC_3986_6874Lexer(CharStreams.fromString(input))
        val parser = RFC_3986_6874Parser(CommonTokenStream(lexer))
        parser.errorHandler = BailErrorStrategy()
        // We can use SLL prediction mode since there should never be ambiguity
        // in what state transition the next character introduces in a full
        // URI parse. Parsing URI references may be different.
        parser.interpreter.predictionMode = PredictionMode.SLL

        // Record whether any errors have been reported during parsing,
        // don't print to stdout...
        val errorListener = FlaggingErrorListener()
        lexer.removeErrorListeners()
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        lexer.addErrorListener(errorListener)

        return parser to errorListener
    }

    /**
     * Attempt parsing some part of the grammar.
     *
     * Accepts an input and a function that will try to parse it according
     * to some rule of the grammar. The function takes a parser and returns
     * the context element + its parsed output, or throws if it could not parse.
     *
     * The parser context element is used to determine whether the parse took
     * the complete input; if not, throw.
     *
     * [partDesc] is a noun phrase describing the part of the URI we're
     * attempting to parse, such as "URI" or "scheme".
     */
    @Throws(UriDecodeException::class, RecognitionException::class, ParseCancellationException::class)
    private fun <R> tryParse(input: String, partDesc: String, partParser: (RFC_3986_6874Parser) -> Pair<ParserRuleContext, R>): R {
        val (parser, errorListener) = setUpParser(input)

        val (context, ret) = partParser(parser)

        val errMsg = errorListener.error
        if (errMsg != null) {
            throw UriDecodeException("Could not parse $partDesc: $errMsg")
        }

        // Check if entire string was consumed and matched
        //
        // We use an EOF token in the grammar, but we would still need this
        // code for validating subrules.
        val matched = context.text
        if (input != matched) {
            throw UriDecodeException(
                "Could not parse $partDesc: " +
                    "error at position " + matched.length
            )
        }

        return ret
    }

    @Throws(UriDecodeException::class, RecognitionException::class, ParseCancellationException::class)
    private fun parseInner(input: String): GenericUri {
        return tryParse(input, "URI") { parser ->
            val context = parser.uri()
            context to parseUri(context)
        }
    }

    private fun parseUri(uriAbs: UriContext): GenericUri {
        val schemeRaw = uriAbs.scheme().text

        val hier = uriAbs.hier_part()
        val parsedAuthority = hier.authority()?.let { parseAuthority(it) }
        val pathRaw = firstPath(
            hier.path_abempty(),
            hier.path_absolute(),
            hier.path_rootless(),
            hier.path_empty()
        )

        val queryRaw = uriAbs.query()?.text
        val fragmentRaw = uriAbs.fragment_1()?.text

        return GenericUri(schemeRaw, parsedAuthority, pathRaw, queryRaw, fragmentRaw)
    }

    private fun parseAuthority(authority: AuthorityContext): UriAuthority {
        return UriAuthority(
            userinfoRaw = authority.userinfo()?.text,
            host = parseHost(authority.host()),
            portRaw = authority.port()?.text
        )
    }

    private fun parseHost(host: HostContext): Host {
        val regname = host.reg_name()
        val ipv4 = host.ipv4address()
        val ipNewer = host.ip_literal()
        val ipv6 = ipNewer?.ipv6address()
        val ipv6zoned = ipNewer?.ipv6addrz()
        val ipFuture = ipNewer?.ipvfuture()

        if (regname != null) {
            return RegNameHost(host.text)
        } else if (ipv4 != null) {
            val octets = ArrayList<Int>(4)
            for (octet in ipv4.dec_octet()) {
                octets.add(Integer.parseInt(octet.text))
            }
            return IPv4Host(octets, host.text)
        } else if (ipv6 != null) {
            return IPv6Host(ipv6.text, null, host.text)
        } else if (ipv6zoned != null) {
            val ipv6addr = ipv6zoned.ipv6address().text
            val zoneRaw = ipv6zoned.zoneid().text
            val zone = if (zoneRaw == null) null else Codecs.percentDecode(zoneRaw)
            return IPv6Host(ipv6addr, zone, host.text)
        } else if (ipFuture != null) {
            val hexver = ipFuture.ipvfuture_version().text
            val futureData = ipFuture.ipvfuture_data().text
            val formatVersion = Integer.parseInt(hexver, 16)
            return IPvFutureHost(formatVersion, futureData, host.text)
        } else {
            throw UriDecodeException("Grammar mismatch: authority did not contain any known host variant")
        }
    }

    private fun firstPath(vararg paths: ParserRuleContext?): String {
        for (path in paths) {
            if (path != null) {
                return path.text
            }
        }
        throw UriDecodeException("Grammar mismatch: hier_part/rel_part did not contain any known path variant")
    }

    override fun validateScheme(input: String) {
        tryParse(input, "scheme") { parser ->
            val context = parser.scheme()
            val read = context.text
            context to read
        }
    }
}
