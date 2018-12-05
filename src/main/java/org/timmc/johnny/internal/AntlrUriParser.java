package org.timmc.johnny.internal;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.timmc.johnny.*;
import org.timmc.johnny.internal.antlr.FlaggingErrorListener;
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Lexer;
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Parser;
import org.timmc.johnny.internal.gen.parse.RFC_3986_6874Parser.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A strict URI parser directly derived from ABNF grammars in the relevant RFCs.
 */
public class AntlrUriParser implements UrlParser {

    public Url parse(String in) throws UrlDecodeException {
        try {
            return parseInner(in);
        } catch (RecognitionException e) {
            throw new UrlDecodeException("Could not recognize URI from input", e);
        } catch (ParseCancellationException e) {
            throw new UrlDecodeException("Could not recognize URI from input", e);
        } catch (NullPointerException npe) {
            throw new UrlDecodeException("Unexpected null reference when reading URI parse tree", npe);
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

        Uri_referenceContext root = parser.uri_reference();
        Url ret = parseUri(root);

        String errMsg = errorListener.getError();
        if (errMsg != null) {
            throw new UrlDecodeException("Could not parse URI: " + errMsg);
        }

        // Check if entire string was consumed and matched
        String matched = root.getText();
        if (!in.equals(matched)) {
            throw new UrlDecodeException("Could not parse URI: " +
                    "error at position " + matched.length());
        }

        return ret;
    }

    private Url parseUri(Uri_referenceContext root) {
        String schemeRaw;
        String userInfoRaw;
        Host host;
        String portRaw;
        String pathRaw;
        String queryRaw;
        String fragmentRaw;

        UriContext uriAbs = root.uri();
        Relative_refContext uriRef = root.relative_ref();

        if (uriAbs != null) {
            schemeRaw = uriAbs.scheme().getText();
        } else {
            schemeRaw = null;
        }

        AuthorityContext authority;
        if (uriAbs != null) {
            Hier_partContext hier = uriAbs.hier_part();
            authority = hier.authority();
            pathRaw = firstPath(
                    hier.path_abempty(),
                    hier.path_absolute(),
                    hier.path_rootless(),
                    hier.path_empty()
            );
        } else {
            Relative_partContext relpart = uriRef.relative_part();
            authority = relpart.authority();
            pathRaw = firstPath(
                    relpart.path_abempty(),
                    relpart.path_absolute(),
                    relpart.path_noscheme(),
                    relpart.path_empty()
            );
        }

        if (authority != null) {
            UserinfoContext userinfo = authority.userinfo();
            userInfoRaw = userinfo == null ? null : userinfo.getText();
            HostContext hostRaw = authority.host();
            host = hostRaw == null ? null : parseHost(hostRaw);
            PortContext port = authority.port();
            portRaw = port == null ? null : port.getText();
        } else {
            userInfoRaw = null;
            host = null;
            portRaw = null;
        }

        QueryContext query = uriAbs != null ? uriAbs.query() : uriRef.query();
        queryRaw = maybeText(query);
        Fragment_1Context fragment = uriAbs != null ? uriAbs.fragment_1() : uriRef.fragment_1();
        fragmentRaw = maybeText(fragment);

        return new ImmutableUrl(schemeRaw, userInfoRaw, host, portRaw, pathRaw, queryRaw, fragmentRaw);
    }

    public Host parseHost(HostContext host) {
        Reg_nameContext regname = host.reg_name();
        Ipv4addressContext ipv4 = host.ipv4address();
        Ip_literalContext ipNewer = host.ip_literal();
        Ipv6addressContext ipv6 = ipNewer == null? null : ipNewer.ipv6address();
        Ipv6addrzContext ipv6zoned = ipNewer == null? null : ipNewer.ipv6addrz();
        IpvfutureContext ipFuture = ipNewer == null ? null : ipNewer.ipvfuture();

        if (regname != null) {
            return new RegNameHost(host.getText());
        } else if (ipv4 != null) {
            List<Integer> octets = new ArrayList<Integer>(4);
            for (Dec_octetContext octet : ipv4.dec_octet()) {
                octets.add(Integer.parseInt(octet.getText()));
            }
            return new IPv4Host(octets, host.getText());
        } else if (ipv6 != null) {
            return new IPv6Host(ipv6.getText(), null, host.getText());
        } else if (ipv6zoned != null) {
            String ipv6addr = ipv6zoned.ipv6address().getText();
            String zone = ipv6zoned.zoneid().getText();
            return new IPv6Host(ipv6addr, zone, host.getText());
        } else if (ipFuture != null ){
            StringBuilder hexver = new StringBuilder();
            for (HexdigContext digit: ipFuture.hexdig()) {
                hexver.append(digit.getText());
            }
            int formatVersion = Integer.parseInt(hexver.toString(), 16);
            return new IPvFutureHost(formatVersion, host.getText());
        } else {
            throw new UrlDecodeException("Grammar mismatch: authority did not contain any known host variant");
        }
    }

    private String firstPath(ParserRuleContext... paths) {
        for (ParserRuleContext path: paths) {
            if (path != null) {
                return path.getText();
            }
        }
        throw new UrlDecodeException("Grammar mismatch: hier_part/rel_part did not contain any known path variant");
    }

    private String maybeText(ParserRuleContext x) {
        return x == null ? null : x.getText();
    }
}
