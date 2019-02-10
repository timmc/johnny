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
class AntlrUriParser : UrlParser {

    @Throws(UrlDecodeException::class)
    override fun parse(url: String): Url {
        try {
            return parseInner(url)
        } catch (e: RecognitionException) {
            throw UrlDecodeException("Could not recognize URI from input", e)
        } catch (e: ParseCancellationException) {
            throw UrlDecodeException("Could not recognize URI from input", e)
        } catch (npe: NullPointerException) {
            throw UrlDecodeException("Unexpected null reference when reading URI parse tree", npe)
        }

    }

    @Throws(UrlDecodeException::class, RecognitionException::class, ParseCancellationException::class)
    private fun parseInner(`in`: String?): Url {
        if (`in` == null) {
            throw NullPointerException("uri may not be null.")
        }

        val lexer = RFC_3986_6874Lexer(CharStreams.fromString(`in`))
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

        val root = parser.uri_reference()
        val ret = parseUri(root)

        val errMsg = errorListener.error
        if (errMsg != null) {
            throw UrlDecodeException("Could not parse URI: $errMsg")
        }

        // Check if entire string was consumed and matched
        //
        // Alternatively, should we use an EOF token in the grammar?
        val matched = root.text
        if (`in` != matched) {
            throw UrlDecodeException(
                "Could not parse URI: " +
                    "error at position " + matched.length
            )
        }

        return ret
    }

    private fun parseUri(root: Uri_referenceContext): Url {
        val schemeRaw: String?
        val userInfoRaw: String?
        val host: Host?
        val portRaw: String?
        val pathRaw: String
        val queryRaw: String?
        val fragmentRaw: String?

        val uriAbs = root.uri()
        val uriRef = root.relative_ref()

        schemeRaw = uriAbs?.scheme()?.text

        val authority: AuthorityContext?
        if (uriAbs != null) {
            val hier = uriAbs.hier_part()
            authority = hier.authority()
            pathRaw = firstPath(
                hier.path_abempty(),
                hier.path_absolute(),
                hier.path_rootless(),
                hier.path_empty()
            )
        } else {
            val relpart = uriRef.relative_part()
            authority = relpart.authority()
            pathRaw = firstPath(
                relpart.path_abempty(),
                relpart.path_absolute(),
                relpart.path_noscheme(),
                relpart.path_empty()
            )
        }

        if (authority != null) {
            val userinfo = authority.userinfo()
            userInfoRaw = userinfo?.text
            val hostRaw = authority.host()
            host = hostRaw?.let{ parseHost(it) }
            val port = authority.port()
            portRaw = port?.text
        } else {
            userInfoRaw = null
            host = null
            portRaw = null
        }

        val query = if (uriAbs != null) uriAbs.query() else uriRef.query()
        queryRaw = maybeText(query)
        val fragment = if (uriAbs != null) uriAbs.fragment_1() else uriRef.fragment_1()
        fragmentRaw = maybeText(fragment)

        return Url(schemeRaw!!, userInfoRaw, host!!, portRaw, pathRaw, queryRaw, fragmentRaw)
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
            val hexver = StringBuilder()
            for (digit in ipFuture.hexdig()) {
                hexver.append(digit.text)
            }
            val formatVersion = Integer.parseInt(hexver.toString(), 16)
            return IPvFutureHost(formatVersion, host.text)
        } else {
            throw UrlDecodeException("Grammar mismatch: authority did not contain any known host variant")
        }
    }

    private fun firstPath(vararg paths: ParserRuleContext?): String {
        for (path in paths) {
            if (path != null) {
                return path.text
            }
        }
        throw UrlDecodeException("Grammar mismatch: hier_part/rel_part did not contain any known path variant")
    }

    private fun maybeText(x: ParserRuleContext?): String? {
        return x?.text
    }
}
