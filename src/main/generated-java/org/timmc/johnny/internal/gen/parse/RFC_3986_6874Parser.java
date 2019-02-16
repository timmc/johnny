// Generated from src/main/antlr4/RFC_3986_6874.g4 by ANTLR 4.7.1
package org.timmc.johnny.internal.gen.parse;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RFC_3986_6874Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXCLAMATION=1, POUND=2, DOLLAR=3, PERCENT=4, AMPERSAND=5, APOSTROPHE=6, 
		LEFT_PAREN=7, RIGHT_PAREN=8, ASTERISK=9, PLUS=10, COMMA=11, DASH=12, PERIOD=13, 
		SLASH=14, ZERO=15, ONE=16, TWO=17, THREE=18, FOUR=19, FIVE=20, SIX=21, 
		SEVEN=22, EIGHT=23, NINE=24, COLON=25, SEMICOLON=26, EQUALS=27, QUESTION=28, 
		AT=29, CAP_A=30, CAP_B=31, CAP_C=32, CAP_D=33, CAP_E=34, CAP_F=35, CAP_G=36, 
		CAP_H=37, CAP_I=38, CAP_J=39, CAP_K=40, CAP_L=41, CAP_M=42, CAP_N=43, 
		CAP_O=44, CAP_P=45, CAP_Q=46, CAP_R=47, CAP_S=48, CAP_T=49, CAP_U=50, 
		CAP_V=51, CAP_W=52, CAP_X=53, CAP_Y=54, CAP_Z=55, LEFT_BRACE=56, RIGHT_BRACE=57, 
		UNDERSCORE=58, A=59, B=60, C=61, D=62, E=63, F=64, G=65, H=66, I=67, J=68, 
		K=69, L=70, M=71, N=72, O=73, P=74, Q=75, R=76, S=77, T=78, U=79, V=80, 
		W=81, X=82, Y=83, Z=84, TILDE=85;
	public static final int
		RULE_uri = 0, RULE_hier_part = 1, RULE_uri_reference = 2, RULE_relative_ref = 3, 
		RULE_relative_part = 4, RULE_scheme = 5, RULE_authority = 6, RULE_userinfo = 7, 
		RULE_host = 8, RULE_port = 9, RULE_ipvfuture = 10, RULE_ipvfuture_version = 11, 
		RULE_ipvfuture_data = 12, RULE_ipv6address = 13, RULE_h16 = 14, RULE_ls32 = 15, 
		RULE_ipv4address = 16, RULE_dec_octet = 17, RULE_reg_name = 18, RULE_path_abempty = 19, 
		RULE_path_absolute = 20, RULE_path_noscheme = 21, RULE_path_rootless = 22, 
		RULE_path_empty = 23, RULE_segment = 24, RULE_segment_nz = 25, RULE_segment_nz_nc = 26, 
		RULE_pchar = 27, RULE_query = 28, RULE_fragment_1 = 29, RULE_pct_encoded = 30, 
		RULE_unreserved = 31, RULE_sub_delims = 32, RULE_ip_literal = 33, RULE_zoneid = 34, 
		RULE_ipv6addrz = 35, RULE_alpha = 36, RULE_digit = 37, RULE_hexdig = 38;
	public static final String[] ruleNames = {
		"uri", "hier_part", "uri_reference", "relative_ref", "relative_part", 
		"scheme", "authority", "userinfo", "host", "port", "ipvfuture", "ipvfuture_version", 
		"ipvfuture_data", "ipv6address", "h16", "ls32", "ipv4address", "dec_octet", 
		"reg_name", "path_abempty", "path_absolute", "path_noscheme", "path_rootless", 
		"path_empty", "segment", "segment_nz", "segment_nz_nc", "pchar", "query", 
		"fragment_1", "pct_encoded", "unreserved", "sub_delims", "ip_literal", 
		"zoneid", "ipv6addrz", "alpha", "digit", "hexdig"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'!'", "'#'", "'$'", "'%'", "'&'", "'''", "'('", "')'", "'*'", "'+'", 
		"','", "'-'", "'.'", "'/'", "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", 
		"'6'", "'7'", "'8'", "'9'", "':'", "';'", "'='", "'?'", "'@'", "'A'", 
		"'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", 
		"'L'", "'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", "'U'", 
		"'V'", "'W'", "'X'", "'Y'", "'Z'", "'['", "']'", "'_'", "'a'", "'b'", 
		"'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", 
		"'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", 
		"'w'", "'x'", "'y'", "'z'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EXCLAMATION", "POUND", "DOLLAR", "PERCENT", "AMPERSAND", "APOSTROPHE", 
		"LEFT_PAREN", "RIGHT_PAREN", "ASTERISK", "PLUS", "COMMA", "DASH", "PERIOD", 
		"SLASH", "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", 
		"EIGHT", "NINE", "COLON", "SEMICOLON", "EQUALS", "QUESTION", "AT", "CAP_A", 
		"CAP_B", "CAP_C", "CAP_D", "CAP_E", "CAP_F", "CAP_G", "CAP_H", "CAP_I", 
		"CAP_J", "CAP_K", "CAP_L", "CAP_M", "CAP_N", "CAP_O", "CAP_P", "CAP_Q", 
		"CAP_R", "CAP_S", "CAP_T", "CAP_U", "CAP_V", "CAP_W", "CAP_X", "CAP_Y", 
		"CAP_Z", "LEFT_BRACE", "RIGHT_BRACE", "UNDERSCORE", "A", "B", "C", "D", 
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
		"S", "T", "U", "V", "W", "X", "Y", "Z", "TILDE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RFC_3986_6874.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RFC_3986_6874Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UriContext extends ParserRuleContext {
		public SchemeContext scheme() {
			return getRuleContext(SchemeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(RFC_3986_6874Parser.COLON, 0); }
		public Hier_partContext hier_part() {
			return getRuleContext(Hier_partContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(RFC_3986_6874Parser.QUESTION, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode POUND() { return getToken(RFC_3986_6874Parser.POUND, 0); }
		public Fragment_1Context fragment_1() {
			return getRuleContext(Fragment_1Context.class,0);
		}
		public UriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uri; }
	}

	public final UriContext uri() throws RecognitionException {
		UriContext _localctx = new UriContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_uri);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			scheme();
			setState(79);
			match(COLON);
			setState(80);
			hier_part();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(81);
				match(QUESTION);
				setState(82);
				query();
				}
			}

			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POUND) {
				{
				setState(85);
				match(POUND);
				setState(86);
				fragment_1();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hier_partContext extends ParserRuleContext {
		public AuthorityContext authority() {
			return getRuleContext(AuthorityContext.class,0);
		}
		public Path_abemptyContext path_abempty() {
			return getRuleContext(Path_abemptyContext.class,0);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public Path_absoluteContext path_absolute() {
			return getRuleContext(Path_absoluteContext.class,0);
		}
		public Path_rootlessContext path_rootless() {
			return getRuleContext(Path_rootlessContext.class,0);
		}
		public Path_emptyContext path_empty() {
			return getRuleContext(Path_emptyContext.class,0);
		}
		public Hier_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hier_part; }
	}

	public final Hier_partContext hier_part() throws RecognitionException {
		Hier_partContext _localctx = new Hier_partContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_hier_part);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(89);
				match(SLASH);
				setState(90);
				match(SLASH);
				}
				setState(92);
				authority();
				setState(93);
				path_abempty();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				path_absolute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				path_rootless();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				path_empty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Uri_referenceContext extends ParserRuleContext {
		public UriContext uri() {
			return getRuleContext(UriContext.class,0);
		}
		public Relative_refContext relative_ref() {
			return getRuleContext(Relative_refContext.class,0);
		}
		public Uri_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uri_reference; }
	}

	public final Uri_referenceContext uri_reference() throws RecognitionException {
		Uri_referenceContext _localctx = new Uri_referenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_uri_reference);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				uri();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				relative_ref();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relative_refContext extends ParserRuleContext {
		public Relative_partContext relative_part() {
			return getRuleContext(Relative_partContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(RFC_3986_6874Parser.QUESTION, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode POUND() { return getToken(RFC_3986_6874Parser.POUND, 0); }
		public Fragment_1Context fragment_1() {
			return getRuleContext(Fragment_1Context.class,0);
		}
		public Relative_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relative_ref; }
	}

	public final Relative_refContext relative_ref() throws RecognitionException {
		Relative_refContext _localctx = new Relative_refContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relative_ref);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			relative_part();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(105);
				match(QUESTION);
				setState(106);
				query();
				}
			}

			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POUND) {
				{
				setState(109);
				match(POUND);
				setState(110);
				fragment_1();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relative_partContext extends ParserRuleContext {
		public AuthorityContext authority() {
			return getRuleContext(AuthorityContext.class,0);
		}
		public Path_abemptyContext path_abempty() {
			return getRuleContext(Path_abemptyContext.class,0);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public Path_absoluteContext path_absolute() {
			return getRuleContext(Path_absoluteContext.class,0);
		}
		public Path_noschemeContext path_noscheme() {
			return getRuleContext(Path_noschemeContext.class,0);
		}
		public Path_emptyContext path_empty() {
			return getRuleContext(Path_emptyContext.class,0);
		}
		public Relative_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relative_part; }
	}

	public final Relative_partContext relative_part() throws RecognitionException {
		Relative_partContext _localctx = new Relative_partContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relative_part);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(113);
				match(SLASH);
				setState(114);
				match(SLASH);
				}
				setState(116);
				authority();
				setState(117);
				path_abempty();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				path_absolute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				path_noscheme();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				path_empty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SchemeContext extends ParserRuleContext {
		public List<AlphaContext> alpha() {
			return getRuleContexts(AlphaContext.class);
		}
		public AlphaContext alpha(int i) {
			return getRuleContext(AlphaContext.class,i);
		}
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(RFC_3986_6874Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(RFC_3986_6874Parser.PLUS, i);
		}
		public List<TerminalNode> DASH() { return getTokens(RFC_3986_6874Parser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(RFC_3986_6874Parser.DASH, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(RFC_3986_6874Parser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(RFC_3986_6874Parser.PERIOD, i);
		}
		public SchemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scheme; }
	}

	public final SchemeContext scheme() throws RecognitionException {
		SchemeContext _localctx = new SchemeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			alpha();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)))) != 0)) {
				{
				setState(130);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
					{
					setState(125);
					alpha();
					}
					break;
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
					{
					setState(126);
					digit();
					}
					break;
				case PLUS:
					{
					setState(127);
					match(PLUS);
					}
					break;
				case DASH:
					{
					setState(128);
					match(DASH);
					}
					break;
				case PERIOD:
					{
					setState(129);
					match(PERIOD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuthorityContext extends ParserRuleContext {
		public HostContext host() {
			return getRuleContext(HostContext.class,0);
		}
		public UserinfoContext userinfo() {
			return getRuleContext(UserinfoContext.class,0);
		}
		public TerminalNode AT() { return getToken(RFC_3986_6874Parser.AT, 0); }
		public TerminalNode COLON() { return getToken(RFC_3986_6874Parser.COLON, 0); }
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public AuthorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_authority; }
	}

	public final AuthorityContext authority() throws RecognitionException {
		AuthorityContext _localctx = new AuthorityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_authority);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(135);
				userinfo();
				setState(136);
				match(AT);
				}
				break;
			}
			setState(140);
			host();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(141);
				match(COLON);
				setState(142);
				port();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserinfoContext extends ParserRuleContext {
		public List<UnreservedContext> unreserved() {
			return getRuleContexts(UnreservedContext.class);
		}
		public UnreservedContext unreserved(int i) {
			return getRuleContext(UnreservedContext.class,i);
		}
		public List<Pct_encodedContext> pct_encoded() {
			return getRuleContexts(Pct_encodedContext.class);
		}
		public Pct_encodedContext pct_encoded(int i) {
			return getRuleContext(Pct_encodedContext.class,i);
		}
		public List<Sub_delimsContext> sub_delims() {
			return getRuleContexts(Sub_delimsContext.class);
		}
		public Sub_delimsContext sub_delims(int i) {
			return getRuleContext(Sub_delimsContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(RFC_3986_6874Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(RFC_3986_6874Parser.COLON, i);
		}
		public UserinfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userinfo; }
	}

	public final UserinfoContext userinfo() throws RecognitionException {
		UserinfoContext _localctx = new UserinfoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_userinfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(145);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(146);
					pct_encoded();
					}
					break;
				case EXCLAMATION:
				case DOLLAR:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case SEMICOLON:
				case EQUALS:
					{
					setState(147);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(148);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HostContext extends ParserRuleContext {
		public Ip_literalContext ip_literal() {
			return getRuleContext(Ip_literalContext.class,0);
		}
		public Ipv4addressContext ipv4address() {
			return getRuleContext(Ipv4addressContext.class,0);
		}
		public Reg_nameContext reg_name() {
			return getRuleContext(Reg_nameContext.class,0);
		}
		public HostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_host; }
	}

	public final HostContext host() throws RecognitionException {
		HostContext _localctx = new HostContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_host);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				ip_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				ipv4address();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				reg_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) {
				{
				{
				setState(159);
				digit();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IpvfutureContext extends ParserRuleContext {
		public Ipvfuture_versionContext ipvfuture_version() {
			return getRuleContext(Ipvfuture_versionContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(RFC_3986_6874Parser.PERIOD, 0); }
		public Ipvfuture_dataContext ipvfuture_data() {
			return getRuleContext(Ipvfuture_dataContext.class,0);
		}
		public TerminalNode CAP_V() { return getToken(RFC_3986_6874Parser.CAP_V, 0); }
		public TerminalNode V() { return getToken(RFC_3986_6874Parser.V, 0); }
		public IpvfutureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipvfuture; }
	}

	public final IpvfutureContext ipvfuture() throws RecognitionException {
		IpvfutureContext _localctx = new IpvfutureContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ipvfuture);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==CAP_V || _la==V) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(166);
			ipvfuture_version();
			setState(167);
			match(PERIOD);
			setState(168);
			ipvfuture_data();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ipvfuture_versionContext extends ParserRuleContext {
		public List<HexdigContext> hexdig() {
			return getRuleContexts(HexdigContext.class);
		}
		public HexdigContext hexdig(int i) {
			return getRuleContext(HexdigContext.class,i);
		}
		public Ipvfuture_versionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipvfuture_version; }
	}

	public final Ipvfuture_versionContext ipvfuture_version() throws RecognitionException {
		Ipvfuture_versionContext _localctx = new Ipvfuture_versionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ipvfuture_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				hexdig();
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ipvfuture_dataContext extends ParserRuleContext {
		public List<UnreservedContext> unreserved() {
			return getRuleContexts(UnreservedContext.class);
		}
		public UnreservedContext unreserved(int i) {
			return getRuleContext(UnreservedContext.class,i);
		}
		public List<Sub_delimsContext> sub_delims() {
			return getRuleContexts(Sub_delimsContext.class);
		}
		public Sub_delimsContext sub_delims(int i) {
			return getRuleContext(Sub_delimsContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(RFC_3986_6874Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(RFC_3986_6874Parser.COLON, i);
		}
		public Ipvfuture_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipvfuture_data; }
	}

	public final Ipvfuture_dataContext ipvfuture_data() throws RecognitionException {
		Ipvfuture_dataContext _localctx = new Ipvfuture_dataContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ipvfuture_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(178);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(175);
					unreserved();
					}
					break;
				case EXCLAMATION:
				case DOLLAR:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case SEMICOLON:
				case EQUALS:
					{
					setState(176);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(177);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ipv6addressContext extends ParserRuleContext {
		public Ls32Context ls32() {
			return getRuleContext(Ls32Context.class,0);
		}
		public List<H16Context> h16() {
			return getRuleContexts(H16Context.class);
		}
		public H16Context h16(int i) {
			return getRuleContext(H16Context.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(RFC_3986_6874Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(RFC_3986_6874Parser.COLON, i);
		}
		public Ipv6addressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipv6address; }
	}

	public final Ipv6addressContext ipv6address() throws RecognitionException {
		Ipv6addressContext _localctx = new Ipv6addressContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ipv6address);
		int _la;
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(182);
				h16();
				setState(183);
				match(COLON);
				}
				{
				setState(185);
				h16();
				setState(186);
				match(COLON);
				}
				{
				setState(188);
				h16();
				setState(189);
				match(COLON);
				}
				{
				setState(191);
				h16();
				setState(192);
				match(COLON);
				}
				{
				setState(194);
				h16();
				setState(195);
				match(COLON);
				}
				{
				setState(197);
				h16();
				setState(198);
				match(COLON);
				}
				setState(200);
				ls32();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				{
				setState(202);
				match(COLON);
				setState(203);
				match(COLON);
				}
				{
				setState(205);
				h16();
				setState(206);
				match(COLON);
				}
				{
				setState(208);
				h16();
				setState(209);
				match(COLON);
				}
				{
				setState(211);
				h16();
				setState(212);
				match(COLON);
				}
				{
				setState(214);
				h16();
				setState(215);
				match(COLON);
				}
				{
				setState(217);
				h16();
				setState(218);
				match(COLON);
				}
				setState(220);
				ls32();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(222);
					h16();
					}
				}

				{
				setState(225);
				match(COLON);
				setState(226);
				match(COLON);
				}
				{
				setState(228);
				h16();
				setState(229);
				match(COLON);
				}
				{
				setState(231);
				h16();
				setState(232);
				match(COLON);
				}
				{
				setState(234);
				h16();
				setState(235);
				match(COLON);
				}
				{
				setState(237);
				h16();
				setState(238);
				match(COLON);
				}
				setState(240);
				ls32();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					{
					setState(245);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(242);
						h16();
						setState(243);
						match(COLON);
						}
						break;
					}
					}
					setState(247);
					h16();
					}
				}

				{
				setState(250);
				match(COLON);
				setState(251);
				match(COLON);
				}
				{
				setState(253);
				h16();
				setState(254);
				match(COLON);
				}
				{
				setState(256);
				h16();
				setState(257);
				match(COLON);
				}
				{
				setState(259);
				h16();
				setState(260);
				match(COLON);
				}
				setState(262);
				ls32();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(275);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						setState(267);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(264);
							h16();
							setState(265);
							match(COLON);
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						{
						setState(269);
						h16();
						setState(270);
						match(COLON);
						}
						{
						setState(272);
						h16();
						setState(273);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(277);
					h16();
					}
				}

				{
				setState(280);
				match(COLON);
				setState(281);
				match(COLON);
				}
				{
				setState(283);
				h16();
				setState(284);
				match(COLON);
				}
				{
				setState(286);
				h16();
				setState(287);
				match(COLON);
				}
				setState(289);
				ls32();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(311);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(294);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
						case 1:
							{
							setState(291);
							h16();
							setState(292);
							match(COLON);
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						{
						setState(296);
						h16();
						setState(297);
						match(COLON);
						}
						{
						setState(299);
						h16();
						setState(300);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(302);
						h16();
						setState(303);
						match(COLON);
						}
						{
						setState(305);
						h16();
						setState(306);
						match(COLON);
						}
						{
						setState(308);
						h16();
						setState(309);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(313);
					h16();
					}
				}

				{
				setState(316);
				match(COLON);
				setState(317);
				match(COLON);
				}
				setState(319);
				h16();
				setState(320);
				match(COLON);
				setState(321);
				ls32();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(355);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(326);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(323);
							h16();
							setState(324);
							match(COLON);
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						{
						setState(328);
						h16();
						setState(329);
						match(COLON);
						}
						{
						setState(331);
						h16();
						setState(332);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(334);
						h16();
						setState(335);
						match(COLON);
						}
						{
						setState(337);
						h16();
						setState(338);
						match(COLON);
						}
						{
						setState(340);
						h16();
						setState(341);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(343);
						h16();
						setState(344);
						match(COLON);
						}
						{
						setState(346);
						h16();
						setState(347);
						match(COLON);
						}
						{
						setState(349);
						h16();
						setState(350);
						match(COLON);
						}
						{
						setState(352);
						h16();
						setState(353);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(357);
					h16();
					}
				}

				{
				setState(360);
				match(COLON);
				setState(361);
				match(COLON);
				}
				setState(363);
				ls32();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(411);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(367);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
						case 1:
							{
							setState(364);
							h16();
							setState(365);
							match(COLON);
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						{
						setState(369);
						h16();
						setState(370);
						match(COLON);
						}
						{
						setState(372);
						h16();
						setState(373);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(375);
						h16();
						setState(376);
						match(COLON);
						}
						{
						setState(378);
						h16();
						setState(379);
						match(COLON);
						}
						{
						setState(381);
						h16();
						setState(382);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(384);
						h16();
						setState(385);
						match(COLON);
						}
						{
						setState(387);
						h16();
						setState(388);
						match(COLON);
						}
						{
						setState(390);
						h16();
						setState(391);
						match(COLON);
						}
						{
						setState(393);
						h16();
						setState(394);
						match(COLON);
						}
						}
						}
						break;
					case 5:
						{
						{
						{
						setState(396);
						h16();
						setState(397);
						match(COLON);
						}
						{
						setState(399);
						h16();
						setState(400);
						match(COLON);
						}
						{
						setState(402);
						h16();
						setState(403);
						match(COLON);
						}
						{
						setState(405);
						h16();
						setState(406);
						match(COLON);
						}
						{
						setState(408);
						h16();
						setState(409);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(413);
					h16();
					}
				}

				{
				setState(416);
				match(COLON);
				setState(417);
				match(COLON);
				}
				setState(419);
				h16();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(485);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(423);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(420);
							h16();
							setState(421);
							match(COLON);
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						{
						setState(425);
						h16();
						setState(426);
						match(COLON);
						}
						{
						setState(428);
						h16();
						setState(429);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(431);
						h16();
						setState(432);
						match(COLON);
						}
						{
						setState(434);
						h16();
						setState(435);
						match(COLON);
						}
						{
						setState(437);
						h16();
						setState(438);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(440);
						h16();
						setState(441);
						match(COLON);
						}
						{
						setState(443);
						h16();
						setState(444);
						match(COLON);
						}
						{
						setState(446);
						h16();
						setState(447);
						match(COLON);
						}
						{
						setState(449);
						h16();
						setState(450);
						match(COLON);
						}
						}
						}
						break;
					case 5:
						{
						{
						{
						setState(452);
						h16();
						setState(453);
						match(COLON);
						}
						{
						setState(455);
						h16();
						setState(456);
						match(COLON);
						}
						{
						setState(458);
						h16();
						setState(459);
						match(COLON);
						}
						{
						setState(461);
						h16();
						setState(462);
						match(COLON);
						}
						{
						setState(464);
						h16();
						setState(465);
						match(COLON);
						}
						}
						}
						break;
					case 6:
						{
						{
						{
						setState(467);
						h16();
						setState(468);
						match(COLON);
						}
						{
						setState(470);
						h16();
						setState(471);
						match(COLON);
						}
						{
						setState(473);
						h16();
						setState(474);
						match(COLON);
						}
						{
						setState(476);
						h16();
						setState(477);
						match(COLON);
						}
						{
						setState(479);
						h16();
						setState(480);
						match(COLON);
						}
						{
						setState(482);
						h16();
						setState(483);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(487);
					h16();
					}
				}

				{
				setState(490);
				match(COLON);
				setState(491);
				match(COLON);
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class H16Context extends ParserRuleContext {
		public List<HexdigContext> hexdig() {
			return getRuleContexts(HexdigContext.class);
		}
		public HexdigContext hexdig(int i) {
			return getRuleContext(HexdigContext.class,i);
		}
		public H16Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_h16; }
	}

	public final H16Context h16() throws RecognitionException {
		H16Context _localctx = new H16Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_h16);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			hexdig();
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(495);
					hexdig();
					}
				}

				}
				break;
			case 2:
				{
				{
				setState(498);
				hexdig();
				setState(499);
				hexdig();
				}
				}
				break;
			case 3:
				{
				{
				setState(501);
				hexdig();
				setState(502);
				hexdig();
				setState(503);
				hexdig();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ls32Context extends ParserRuleContext {
		public List<H16Context> h16() {
			return getRuleContexts(H16Context.class);
		}
		public H16Context h16(int i) {
			return getRuleContext(H16Context.class,i);
		}
		public TerminalNode COLON() { return getToken(RFC_3986_6874Parser.COLON, 0); }
		public Ipv4addressContext ipv4address() {
			return getRuleContext(Ipv4addressContext.class,0);
		}
		public Ls32Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ls32; }
	}

	public final Ls32Context ls32() throws RecognitionException {
		Ls32Context _localctx = new Ls32Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_ls32);
		try {
			setState(512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(507);
				h16();
				setState(508);
				match(COLON);
				setState(509);
				h16();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				ipv4address();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ipv4addressContext extends ParserRuleContext {
		public List<Dec_octetContext> dec_octet() {
			return getRuleContexts(Dec_octetContext.class);
		}
		public Dec_octetContext dec_octet(int i) {
			return getRuleContext(Dec_octetContext.class,i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(RFC_3986_6874Parser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(RFC_3986_6874Parser.PERIOD, i);
		}
		public Ipv4addressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipv4address; }
	}

	public final Ipv4addressContext ipv4address() throws RecognitionException {
		Ipv4addressContext _localctx = new Ipv4addressContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ipv4address);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			dec_octet();
			setState(515);
			match(PERIOD);
			setState(516);
			dec_octet();
			setState(517);
			match(PERIOD);
			setState(518);
			dec_octet();
			setState(519);
			match(PERIOD);
			setState(520);
			dec_octet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dec_octetContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public TerminalNode ONE() { return getToken(RFC_3986_6874Parser.ONE, 0); }
		public List<TerminalNode> TWO() { return getTokens(RFC_3986_6874Parser.TWO); }
		public TerminalNode TWO(int i) {
			return getToken(RFC_3986_6874Parser.TWO, i);
		}
		public TerminalNode THREE() { return getToken(RFC_3986_6874Parser.THREE, 0); }
		public TerminalNode FOUR() { return getToken(RFC_3986_6874Parser.FOUR, 0); }
		public List<TerminalNode> FIVE() { return getTokens(RFC_3986_6874Parser.FIVE); }
		public TerminalNode FIVE(int i) {
			return getToken(RFC_3986_6874Parser.FIVE, i);
		}
		public TerminalNode SIX() { return getToken(RFC_3986_6874Parser.SIX, 0); }
		public TerminalNode SEVEN() { return getToken(RFC_3986_6874Parser.SEVEN, 0); }
		public TerminalNode EIGHT() { return getToken(RFC_3986_6874Parser.EIGHT, 0); }
		public TerminalNode NINE() { return getToken(RFC_3986_6874Parser.NINE, 0); }
		public TerminalNode ZERO() { return getToken(RFC_3986_6874Parser.ZERO, 0); }
		public Dec_octetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_octet; }
	}

	public final Dec_octetContext dec_octet() throws RecognitionException {
		Dec_octetContext _localctx = new Dec_octetContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_dec_octet);
		int _la;
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				digit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(523);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(524);
				digit();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(525);
				match(ONE);
				setState(526);
				digit();
				setState(527);
				digit();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(529);
				match(TWO);
				setState(530);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(531);
				digit();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				{
				setState(532);
				match(TWO);
				setState(533);
				match(FIVE);
				}
				setState(535);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reg_nameContext extends ParserRuleContext {
		public List<UnreservedContext> unreserved() {
			return getRuleContexts(UnreservedContext.class);
		}
		public UnreservedContext unreserved(int i) {
			return getRuleContext(UnreservedContext.class,i);
		}
		public List<Pct_encodedContext> pct_encoded() {
			return getRuleContexts(Pct_encodedContext.class);
		}
		public Pct_encodedContext pct_encoded(int i) {
			return getRuleContext(Pct_encodedContext.class,i);
		}
		public List<Sub_delimsContext> sub_delims() {
			return getRuleContexts(Sub_delimsContext.class);
		}
		public Sub_delimsContext sub_delims(int i) {
			return getRuleContext(Sub_delimsContext.class,i);
		}
		public Reg_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reg_name; }
	}

	public final Reg_nameContext reg_name() throws RecognitionException {
		Reg_nameContext _localctx = new Reg_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_reg_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(541);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(538);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(539);
					pct_encoded();
					}
					break;
				case EXCLAMATION:
				case DOLLAR:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case SEMICOLON:
				case EQUALS:
					{
					setState(540);
					sub_delims();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Path_abemptyContext extends ParserRuleContext {
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public Path_abemptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_abempty; }
	}

	public final Path_abemptyContext path_abempty() throws RecognitionException {
		Path_abemptyContext _localctx = new Path_abemptyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_path_abempty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(546);
				match(SLASH);
				setState(547);
				segment();
				}
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Path_absoluteContext extends ParserRuleContext {
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public Segment_nzContext segment_nz() {
			return getRuleContext(Segment_nzContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public Path_absoluteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_absolute; }
	}

	public final Path_absoluteContext path_absolute() throws RecognitionException {
		Path_absoluteContext _localctx = new Path_absoluteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_path_absolute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(SLASH);
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(554);
				segment_nz();
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SLASH) {
					{
					{
					setState(555);
					match(SLASH);
					setState(556);
					segment();
					}
					}
					setState(561);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Path_noschemeContext extends ParserRuleContext {
		public Segment_nz_ncContext segment_nz_nc() {
			return getRuleContext(Segment_nz_ncContext.class,0);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public Path_noschemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_noscheme; }
	}

	public final Path_noschemeContext path_noscheme() throws RecognitionException {
		Path_noschemeContext _localctx = new Path_noschemeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_path_noscheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			segment_nz_nc();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(565);
				match(SLASH);
				setState(566);
				segment();
				}
				}
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Path_rootlessContext extends ParserRuleContext {
		public Segment_nzContext segment_nz() {
			return getRuleContext(Segment_nzContext.class,0);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public Path_rootlessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_rootless; }
	}

	public final Path_rootlessContext path_rootless() throws RecognitionException {
		Path_rootlessContext _localctx = new Path_rootlessContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_path_rootless);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			segment_nz();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(573);
				match(SLASH);
				setState(574);
				segment();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Path_emptyContext extends ParserRuleContext {
		public Path_emptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path_empty; }
	}

	public final Path_emptyContext path_empty() throws RecognitionException {
		Path_emptyContext _localctx = new Path_emptyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_path_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SegmentContext extends ParserRuleContext {
		public List<PcharContext> pchar() {
			return getRuleContexts(PcharContext.class);
		}
		public PcharContext pchar(int i) {
			return getRuleContext(PcharContext.class,i);
		}
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				{
				setState(582);
				pchar();
				}
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Segment_nzContext extends ParserRuleContext {
		public List<PcharContext> pchar() {
			return getRuleContexts(PcharContext.class);
		}
		public PcharContext pchar(int i) {
			return getRuleContext(PcharContext.class,i);
		}
		public Segment_nzContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment_nz; }
	}

	public final Segment_nzContext segment_nz() throws RecognitionException {
		Segment_nzContext _localctx = new Segment_nzContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_segment_nz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(588);
				pchar();
				}
				}
				setState(591); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Segment_nz_ncContext extends ParserRuleContext {
		public List<UnreservedContext> unreserved() {
			return getRuleContexts(UnreservedContext.class);
		}
		public UnreservedContext unreserved(int i) {
			return getRuleContext(UnreservedContext.class,i);
		}
		public List<Pct_encodedContext> pct_encoded() {
			return getRuleContexts(Pct_encodedContext.class);
		}
		public Pct_encodedContext pct_encoded(int i) {
			return getRuleContext(Pct_encodedContext.class,i);
		}
		public List<Sub_delimsContext> sub_delims() {
			return getRuleContexts(Sub_delimsContext.class);
		}
		public Sub_delimsContext sub_delims(int i) {
			return getRuleContext(Sub_delimsContext.class,i);
		}
		public List<TerminalNode> AT() { return getTokens(RFC_3986_6874Parser.AT); }
		public TerminalNode AT(int i) {
			return getToken(RFC_3986_6874Parser.AT, i);
		}
		public Segment_nz_ncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment_nz_nc; }
	}

	public final Segment_nz_ncContext segment_nz_nc() throws RecognitionException {
		Segment_nz_ncContext _localctx = new Segment_nz_ncContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_segment_nz_nc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(597);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(593);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(594);
					pct_encoded();
					}
					break;
				case EXCLAMATION:
				case DOLLAR:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case SEMICOLON:
				case EQUALS:
					{
					setState(595);
					sub_delims();
					}
					break;
				case AT:
					{
					setState(596);
					match(AT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(599); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PcharContext extends ParserRuleContext {
		public UnreservedContext unreserved() {
			return getRuleContext(UnreservedContext.class,0);
		}
		public Pct_encodedContext pct_encoded() {
			return getRuleContext(Pct_encodedContext.class,0);
		}
		public Sub_delimsContext sub_delims() {
			return getRuleContext(Sub_delimsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(RFC_3986_6874Parser.COLON, 0); }
		public TerminalNode AT() { return getToken(RFC_3986_6874Parser.AT, 0); }
		public PcharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pchar; }
	}

	public final PcharContext pchar() throws RecognitionException {
		PcharContext _localctx = new PcharContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pchar);
		try {
			setState(606);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DASH:
			case PERIOD:
			case ZERO:
			case ONE:
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
			case SIX:
			case SEVEN:
			case EIGHT:
			case NINE:
			case CAP_A:
			case CAP_B:
			case CAP_C:
			case CAP_D:
			case CAP_E:
			case CAP_F:
			case CAP_G:
			case CAP_H:
			case CAP_I:
			case CAP_J:
			case CAP_K:
			case CAP_L:
			case CAP_M:
			case CAP_N:
			case CAP_O:
			case CAP_P:
			case CAP_Q:
			case CAP_R:
			case CAP_S:
			case CAP_T:
			case CAP_U:
			case CAP_V:
			case CAP_W:
			case CAP_X:
			case CAP_Y:
			case CAP_Z:
			case UNDERSCORE:
			case A:
			case B:
			case C:
			case D:
			case E:
			case F:
			case G:
			case H:
			case I:
			case J:
			case K:
			case L:
			case M:
			case N:
			case O:
			case P:
			case Q:
			case R:
			case S:
			case T:
			case U:
			case V:
			case W:
			case X:
			case Y:
			case Z:
			case TILDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(601);
				unreserved();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(602);
				pct_encoded();
				}
				break;
			case EXCLAMATION:
			case DOLLAR:
			case AMPERSAND:
			case APOSTROPHE:
			case LEFT_PAREN:
			case RIGHT_PAREN:
			case ASTERISK:
			case PLUS:
			case COMMA:
			case SEMICOLON:
			case EQUALS:
				enterOuterAlt(_localctx, 3);
				{
				setState(603);
				sub_delims();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(604);
				match(COLON);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(605);
				match(AT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public List<PcharContext> pchar() {
			return getRuleContexts(PcharContext.class);
		}
		public PcharContext pchar(int i) {
			return getRuleContext(PcharContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public List<TerminalNode> QUESTION() { return getTokens(RFC_3986_6874Parser.QUESTION); }
		public TerminalNode QUESTION(int i) {
			return getToken(RFC_3986_6874Parser.QUESTION, i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(611);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXCLAMATION:
				case DOLLAR:
				case PERCENT:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case COLON:
				case SEMICOLON:
				case EQUALS:
				case AT:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(608);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(609);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(610);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fragment_1Context extends ParserRuleContext {
		public List<PcharContext> pchar() {
			return getRuleContexts(PcharContext.class);
		}
		public PcharContext pchar(int i) {
			return getRuleContext(PcharContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(RFC_3986_6874Parser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(RFC_3986_6874Parser.SLASH, i);
		}
		public List<TerminalNode> QUESTION() { return getTokens(RFC_3986_6874Parser.QUESTION); }
		public TerminalNode QUESTION(int i) {
			return getToken(RFC_3986_6874Parser.QUESTION, i);
		}
		public Fragment_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragment_1; }
	}

	public final Fragment_1Context fragment_1() throws RecognitionException {
		Fragment_1Context _localctx = new Fragment_1Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_fragment_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(619);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXCLAMATION:
				case DOLLAR:
				case PERCENT:
				case AMPERSAND:
				case APOSTROPHE:
				case LEFT_PAREN:
				case RIGHT_PAREN:
				case ASTERISK:
				case PLUS:
				case COMMA:
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case COLON:
				case SEMICOLON:
				case EQUALS:
				case AT:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(616);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(617);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(618);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pct_encodedContext extends ParserRuleContext {
		public TerminalNode PERCENT() { return getToken(RFC_3986_6874Parser.PERCENT, 0); }
		public List<HexdigContext> hexdig() {
			return getRuleContexts(HexdigContext.class);
		}
		public HexdigContext hexdig(int i) {
			return getRuleContext(HexdigContext.class,i);
		}
		public Pct_encodedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pct_encoded; }
	}

	public final Pct_encodedContext pct_encoded() throws RecognitionException {
		Pct_encodedContext _localctx = new Pct_encodedContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pct_encoded);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(PERCENT);
			setState(625);
			hexdig();
			setState(626);
			hexdig();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnreservedContext extends ParserRuleContext {
		public AlphaContext alpha() {
			return getRuleContext(AlphaContext.class,0);
		}
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public TerminalNode DASH() { return getToken(RFC_3986_6874Parser.DASH, 0); }
		public TerminalNode PERIOD() { return getToken(RFC_3986_6874Parser.PERIOD, 0); }
		public TerminalNode UNDERSCORE() { return getToken(RFC_3986_6874Parser.UNDERSCORE, 0); }
		public TerminalNode TILDE() { return getToken(RFC_3986_6874Parser.TILDE, 0); }
		public UnreservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unreserved; }
	}

	public final UnreservedContext unreserved() throws RecognitionException {
		UnreservedContext _localctx = new UnreservedContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_unreserved);
		try {
			setState(634);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP_A:
			case CAP_B:
			case CAP_C:
			case CAP_D:
			case CAP_E:
			case CAP_F:
			case CAP_G:
			case CAP_H:
			case CAP_I:
			case CAP_J:
			case CAP_K:
			case CAP_L:
			case CAP_M:
			case CAP_N:
			case CAP_O:
			case CAP_P:
			case CAP_Q:
			case CAP_R:
			case CAP_S:
			case CAP_T:
			case CAP_U:
			case CAP_V:
			case CAP_W:
			case CAP_X:
			case CAP_Y:
			case CAP_Z:
			case A:
			case B:
			case C:
			case D:
			case E:
			case F:
			case G:
			case H:
			case I:
			case J:
			case K:
			case L:
			case M:
			case N:
			case O:
			case P:
			case Q:
			case R:
			case S:
			case T:
			case U:
			case V:
			case W:
			case X:
			case Y:
			case Z:
				enterOuterAlt(_localctx, 1);
				{
				setState(628);
				alpha();
				}
				break;
			case ZERO:
			case ONE:
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
			case SIX:
			case SEVEN:
			case EIGHT:
			case NINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(629);
				digit();
				}
				break;
			case DASH:
				enterOuterAlt(_localctx, 3);
				{
				setState(630);
				match(DASH);
				}
				break;
			case PERIOD:
				enterOuterAlt(_localctx, 4);
				{
				setState(631);
				match(PERIOD);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 5);
				{
				setState(632);
				match(UNDERSCORE);
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 6);
				{
				setState(633);
				match(TILDE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sub_delimsContext extends ParserRuleContext {
		public TerminalNode EXCLAMATION() { return getToken(RFC_3986_6874Parser.EXCLAMATION, 0); }
		public TerminalNode DOLLAR() { return getToken(RFC_3986_6874Parser.DOLLAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(RFC_3986_6874Parser.AMPERSAND, 0); }
		public TerminalNode APOSTROPHE() { return getToken(RFC_3986_6874Parser.APOSTROPHE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(RFC_3986_6874Parser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(RFC_3986_6874Parser.RIGHT_PAREN, 0); }
		public TerminalNode ASTERISK() { return getToken(RFC_3986_6874Parser.ASTERISK, 0); }
		public TerminalNode PLUS() { return getToken(RFC_3986_6874Parser.PLUS, 0); }
		public TerminalNode COMMA() { return getToken(RFC_3986_6874Parser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(RFC_3986_6874Parser.SEMICOLON, 0); }
		public TerminalNode EQUALS() { return getToken(RFC_3986_6874Parser.EQUALS, 0); }
		public Sub_delimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_delims; }
	}

	public final Sub_delimsContext sub_delims() throws RecognitionException {
		Sub_delimsContext _localctx = new Sub_delimsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sub_delims);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << SEMICOLON) | (1L << EQUALS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ip_literalContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(RFC_3986_6874Parser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(RFC_3986_6874Parser.RIGHT_BRACE, 0); }
		public Ipv6addressContext ipv6address() {
			return getRuleContext(Ipv6addressContext.class,0);
		}
		public Ipv6addrzContext ipv6addrz() {
			return getRuleContext(Ipv6addrzContext.class,0);
		}
		public IpvfutureContext ipvfuture() {
			return getRuleContext(IpvfutureContext.class,0);
		}
		public Ip_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ip_literal; }
	}

	public final Ip_literalContext ip_literal() throws RecognitionException {
		Ip_literalContext _localctx = new Ip_literalContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ip_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			match(LEFT_BRACE);
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(639);
				ipv6address();
				}
				break;
			case 2:
				{
				setState(640);
				ipv6addrz();
				}
				break;
			case 3:
				{
				setState(641);
				ipvfuture();
				}
				break;
			}
			setState(644);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ZoneidContext extends ParserRuleContext {
		public List<UnreservedContext> unreserved() {
			return getRuleContexts(UnreservedContext.class);
		}
		public UnreservedContext unreserved(int i) {
			return getRuleContext(UnreservedContext.class,i);
		}
		public List<Pct_encodedContext> pct_encoded() {
			return getRuleContexts(Pct_encodedContext.class);
		}
		public Pct_encodedContext pct_encoded(int i) {
			return getRuleContext(Pct_encodedContext.class,i);
		}
		public ZoneidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zoneid; }
	}

	public final ZoneidContext zoneid() throws RecognitionException {
		ZoneidContext _localctx = new ZoneidContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_zoneid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(648);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
				case PERIOD:
				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case CAP_A:
				case CAP_B:
				case CAP_C:
				case CAP_D:
				case CAP_E:
				case CAP_F:
				case CAP_G:
				case CAP_H:
				case CAP_I:
				case CAP_J:
				case CAP_K:
				case CAP_L:
				case CAP_M:
				case CAP_N:
				case CAP_O:
				case CAP_P:
				case CAP_Q:
				case CAP_R:
				case CAP_S:
				case CAP_T:
				case CAP_U:
				case CAP_V:
				case CAP_W:
				case CAP_X:
				case CAP_Y:
				case CAP_Z:
				case UNDERSCORE:
				case A:
				case B:
				case C:
				case D:
				case E:
				case F:
				case G:
				case H:
				case I:
				case J:
				case K:
				case L:
				case M:
				case N:
				case O:
				case P:
				case Q:
				case R:
				case S:
				case T:
				case U:
				case V:
				case W:
				case X:
				case Y:
				case Z:
				case TILDE:
					{
					setState(646);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(647);
					pct_encoded();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(650); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PERCENT) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ipv6addrzContext extends ParserRuleContext {
		public Ipv6addressContext ipv6address() {
			return getRuleContext(Ipv6addressContext.class,0);
		}
		public ZoneidContext zoneid() {
			return getRuleContext(ZoneidContext.class,0);
		}
		public TerminalNode PERCENT() { return getToken(RFC_3986_6874Parser.PERCENT, 0); }
		public TerminalNode TWO() { return getToken(RFC_3986_6874Parser.TWO, 0); }
		public TerminalNode FIVE() { return getToken(RFC_3986_6874Parser.FIVE, 0); }
		public Ipv6addrzContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ipv6addrz; }
	}

	public final Ipv6addrzContext ipv6addrz() throws RecognitionException {
		Ipv6addrzContext _localctx = new Ipv6addrzContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ipv6addrz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			ipv6address();
			{
			setState(653);
			match(PERCENT);
			setState(654);
			match(TWO);
			setState(655);
			match(FIVE);
			}
			setState(657);
			zoneid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlphaContext extends ParserRuleContext {
		public TerminalNode CAP_A() { return getToken(RFC_3986_6874Parser.CAP_A, 0); }
		public TerminalNode CAP_B() { return getToken(RFC_3986_6874Parser.CAP_B, 0); }
		public TerminalNode CAP_C() { return getToken(RFC_3986_6874Parser.CAP_C, 0); }
		public TerminalNode CAP_D() { return getToken(RFC_3986_6874Parser.CAP_D, 0); }
		public TerminalNode CAP_E() { return getToken(RFC_3986_6874Parser.CAP_E, 0); }
		public TerminalNode CAP_F() { return getToken(RFC_3986_6874Parser.CAP_F, 0); }
		public TerminalNode CAP_G() { return getToken(RFC_3986_6874Parser.CAP_G, 0); }
		public TerminalNode CAP_H() { return getToken(RFC_3986_6874Parser.CAP_H, 0); }
		public TerminalNode CAP_I() { return getToken(RFC_3986_6874Parser.CAP_I, 0); }
		public TerminalNode CAP_J() { return getToken(RFC_3986_6874Parser.CAP_J, 0); }
		public TerminalNode CAP_K() { return getToken(RFC_3986_6874Parser.CAP_K, 0); }
		public TerminalNode CAP_L() { return getToken(RFC_3986_6874Parser.CAP_L, 0); }
		public TerminalNode CAP_M() { return getToken(RFC_3986_6874Parser.CAP_M, 0); }
		public TerminalNode CAP_N() { return getToken(RFC_3986_6874Parser.CAP_N, 0); }
		public TerminalNode CAP_O() { return getToken(RFC_3986_6874Parser.CAP_O, 0); }
		public TerminalNode CAP_P() { return getToken(RFC_3986_6874Parser.CAP_P, 0); }
		public TerminalNode CAP_Q() { return getToken(RFC_3986_6874Parser.CAP_Q, 0); }
		public TerminalNode CAP_R() { return getToken(RFC_3986_6874Parser.CAP_R, 0); }
		public TerminalNode CAP_S() { return getToken(RFC_3986_6874Parser.CAP_S, 0); }
		public TerminalNode CAP_T() { return getToken(RFC_3986_6874Parser.CAP_T, 0); }
		public TerminalNode CAP_U() { return getToken(RFC_3986_6874Parser.CAP_U, 0); }
		public TerminalNode CAP_V() { return getToken(RFC_3986_6874Parser.CAP_V, 0); }
		public TerminalNode CAP_W() { return getToken(RFC_3986_6874Parser.CAP_W, 0); }
		public TerminalNode CAP_X() { return getToken(RFC_3986_6874Parser.CAP_X, 0); }
		public TerminalNode CAP_Y() { return getToken(RFC_3986_6874Parser.CAP_Y, 0); }
		public TerminalNode CAP_Z() { return getToken(RFC_3986_6874Parser.CAP_Z, 0); }
		public TerminalNode A() { return getToken(RFC_3986_6874Parser.A, 0); }
		public TerminalNode B() { return getToken(RFC_3986_6874Parser.B, 0); }
		public TerminalNode C() { return getToken(RFC_3986_6874Parser.C, 0); }
		public TerminalNode D() { return getToken(RFC_3986_6874Parser.D, 0); }
		public TerminalNode E() { return getToken(RFC_3986_6874Parser.E, 0); }
		public TerminalNode F() { return getToken(RFC_3986_6874Parser.F, 0); }
		public TerminalNode G() { return getToken(RFC_3986_6874Parser.G, 0); }
		public TerminalNode H() { return getToken(RFC_3986_6874Parser.H, 0); }
		public TerminalNode I() { return getToken(RFC_3986_6874Parser.I, 0); }
		public TerminalNode J() { return getToken(RFC_3986_6874Parser.J, 0); }
		public TerminalNode K() { return getToken(RFC_3986_6874Parser.K, 0); }
		public TerminalNode L() { return getToken(RFC_3986_6874Parser.L, 0); }
		public TerminalNode M() { return getToken(RFC_3986_6874Parser.M, 0); }
		public TerminalNode N() { return getToken(RFC_3986_6874Parser.N, 0); }
		public TerminalNode O() { return getToken(RFC_3986_6874Parser.O, 0); }
		public TerminalNode P() { return getToken(RFC_3986_6874Parser.P, 0); }
		public TerminalNode Q() { return getToken(RFC_3986_6874Parser.Q, 0); }
		public TerminalNode R() { return getToken(RFC_3986_6874Parser.R, 0); }
		public TerminalNode S() { return getToken(RFC_3986_6874Parser.S, 0); }
		public TerminalNode T() { return getToken(RFC_3986_6874Parser.T, 0); }
		public TerminalNode U() { return getToken(RFC_3986_6874Parser.U, 0); }
		public TerminalNode V() { return getToken(RFC_3986_6874Parser.V, 0); }
		public TerminalNode W() { return getToken(RFC_3986_6874Parser.W, 0); }
		public TerminalNode X() { return getToken(RFC_3986_6874Parser.X, 0); }
		public TerminalNode Y() { return getToken(RFC_3986_6874Parser.Y, 0); }
		public TerminalNode Z() { return getToken(RFC_3986_6874Parser.Z, 0); }
		public AlphaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alpha; }
	}

	public final AlphaContext alpha() throws RecognitionException {
		AlphaContext _localctx = new AlphaContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_alpha);
		int _la;
		try {
			setState(661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP_A:
			case CAP_B:
			case CAP_C:
			case CAP_D:
			case CAP_E:
			case CAP_F:
			case CAP_G:
			case CAP_H:
			case CAP_I:
			case CAP_J:
			case CAP_K:
			case CAP_L:
			case CAP_M:
			case CAP_N:
			case CAP_O:
			case CAP_P:
			case CAP_Q:
			case CAP_R:
			case CAP_S:
			case CAP_T:
			case CAP_U:
			case CAP_V:
			case CAP_W:
			case CAP_X:
			case CAP_Y:
			case CAP_Z:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case A:
			case B:
			case C:
			case D:
			case E:
			case F:
			case G:
			case H:
			case I:
			case J:
			case K:
			case L:
			case M:
			case N:
			case O:
			case P:
			case Q:
			case R:
			case S:
			case T:
			case U:
			case V:
			case W:
			case X:
			case Y:
			case Z:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				_la = _input.LA(1);
				if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (A - 59)) | (1L << (B - 59)) | (1L << (C - 59)) | (1L << (D - 59)) | (1L << (E - 59)) | (1L << (F - 59)) | (1L << (G - 59)) | (1L << (H - 59)) | (1L << (I - 59)) | (1L << (J - 59)) | (1L << (K - 59)) | (1L << (L - 59)) | (1L << (M - 59)) | (1L << (N - 59)) | (1L << (O - 59)) | (1L << (P - 59)) | (1L << (Q - 59)) | (1L << (R - 59)) | (1L << (S - 59)) | (1L << (T - 59)) | (1L << (U - 59)) | (1L << (V - 59)) | (1L << (W - 59)) | (1L << (X - 59)) | (1L << (Y - 59)) | (1L << (Z - 59)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode ZERO() { return getToken(RFC_3986_6874Parser.ZERO, 0); }
		public TerminalNode ONE() { return getToken(RFC_3986_6874Parser.ONE, 0); }
		public TerminalNode TWO() { return getToken(RFC_3986_6874Parser.TWO, 0); }
		public TerminalNode THREE() { return getToken(RFC_3986_6874Parser.THREE, 0); }
		public TerminalNode FOUR() { return getToken(RFC_3986_6874Parser.FOUR, 0); }
		public TerminalNode FIVE() { return getToken(RFC_3986_6874Parser.FIVE, 0); }
		public TerminalNode SIX() { return getToken(RFC_3986_6874Parser.SIX, 0); }
		public TerminalNode SEVEN() { return getToken(RFC_3986_6874Parser.SEVEN, 0); }
		public TerminalNode EIGHT() { return getToken(RFC_3986_6874Parser.EIGHT, 0); }
		public TerminalNode NINE() { return getToken(RFC_3986_6874Parser.NINE, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HexdigContext extends ParserRuleContext {
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public TerminalNode CAP_A() { return getToken(RFC_3986_6874Parser.CAP_A, 0); }
		public TerminalNode A() { return getToken(RFC_3986_6874Parser.A, 0); }
		public TerminalNode CAP_B() { return getToken(RFC_3986_6874Parser.CAP_B, 0); }
		public TerminalNode B() { return getToken(RFC_3986_6874Parser.B, 0); }
		public TerminalNode CAP_C() { return getToken(RFC_3986_6874Parser.CAP_C, 0); }
		public TerminalNode C() { return getToken(RFC_3986_6874Parser.C, 0); }
		public TerminalNode CAP_D() { return getToken(RFC_3986_6874Parser.CAP_D, 0); }
		public TerminalNode D() { return getToken(RFC_3986_6874Parser.D, 0); }
		public TerminalNode CAP_E() { return getToken(RFC_3986_6874Parser.CAP_E, 0); }
		public TerminalNode E() { return getToken(RFC_3986_6874Parser.E, 0); }
		public TerminalNode CAP_F() { return getToken(RFC_3986_6874Parser.CAP_F, 0); }
		public TerminalNode F() { return getToken(RFC_3986_6874Parser.F, 0); }
		public HexdigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexdig; }
	}

	public final HexdigContext hexdig() throws RecognitionException {
		HexdigContext _localctx = new HexdigContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_hexdig);
		int _la;
		try {
			setState(672);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ZERO:
			case ONE:
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
			case SIX:
			case SEVEN:
			case EIGHT:
			case NINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				digit();
				}
				break;
			case CAP_A:
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(666);
				_la = _input.LA(1);
				if ( !(_la==CAP_A || _la==A) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CAP_B:
			case B:
				enterOuterAlt(_localctx, 3);
				{
				setState(667);
				_la = _input.LA(1);
				if ( !(_la==CAP_B || _la==B) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CAP_C:
			case C:
				enterOuterAlt(_localctx, 4);
				{
				setState(668);
				_la = _input.LA(1);
				if ( !(_la==CAP_C || _la==C) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CAP_D:
			case D:
				enterOuterAlt(_localctx, 5);
				{
				setState(669);
				_la = _input.LA(1);
				if ( !(_la==CAP_D || _la==D) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CAP_E:
			case E:
				enterOuterAlt(_localctx, 6);
				{
				setState(670);
				_la = _input.LA(1);
				if ( !(_la==CAP_E || _la==E) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CAP_F:
			case F:
				enterOuterAlt(_localctx, 7);
				{
				setState(671);
				_la = _input.LA(1);
				if ( !(_la==CAP_F || _la==F) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u02a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\5\2V\n\2\3\2\3\2\5\2Z\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3e\n"+
		"\3\3\4\3\4\5\4i\n\4\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\5\5r\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6}\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0085\n"+
		"\7\f\7\16\7\u0088\13\7\3\b\3\b\3\b\5\b\u008d\n\b\3\b\3\b\3\b\5\b\u0092"+
		"\n\b\3\t\3\t\3\t\3\t\7\t\u0098\n\t\f\t\16\t\u009b\13\t\3\n\3\n\3\n\5\n"+
		"\u00a0\n\n\3\13\7\13\u00a3\n\13\f\13\16\13\u00a6\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\6\r\u00ae\n\r\r\r\16\r\u00af\3\16\3\16\3\16\6\16\u00b5\n\16\r"+
		"\16\16\16\u00b6\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00e2\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f8\n\17"+
		"\3\17\5\17\u00fb\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010e\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0116\n\17\3\17\5\17\u0119\n\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0129\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u013a\n\17\3\17\5\17\u013d\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u0149\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0166\n\17\3\17\5\17\u0169\n\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0172\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u019e\n\17\3\17"+
		"\5\17\u01a1\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01aa\n\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u01e8\n\17\3\17\5\17\u01eb\n\17\3\17\3\17\5\17"+
		"\u01ef\n\17\3\20\3\20\5\20\u01f3\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u01fc\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u0203\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u021b\n\23\3\24\3\24\3\24\7\24\u0220"+
		"\n\24\f\24\16\24\u0223\13\24\3\25\3\25\7\25\u0227\n\25\f\25\16\25\u022a"+
		"\13\25\3\26\3\26\3\26\3\26\7\26\u0230\n\26\f\26\16\26\u0233\13\26\5\26"+
		"\u0235\n\26\3\27\3\27\3\27\7\27\u023a\n\27\f\27\16\27\u023d\13\27\3\30"+
		"\3\30\3\30\7\30\u0242\n\30\f\30\16\30\u0245\13\30\3\31\3\31\3\32\7\32"+
		"\u024a\n\32\f\32\16\32\u024d\13\32\3\33\6\33\u0250\n\33\r\33\16\33\u0251"+
		"\3\34\3\34\3\34\3\34\6\34\u0258\n\34\r\34\16\34\u0259\3\35\3\35\3\35\3"+
		"\35\3\35\5\35\u0261\n\35\3\36\3\36\3\36\7\36\u0266\n\36\f\36\16\36\u0269"+
		"\13\36\3\37\3\37\3\37\7\37\u026e\n\37\f\37\16\37\u0271\13\37\3 \3 \3 "+
		"\3 \3!\3!\3!\3!\3!\3!\5!\u027d\n!\3\"\3\"\3#\3#\3#\3#\5#\u0285\n#\3#\3"+
		"#\3$\3$\6$\u028b\n$\r$\16$\u028c\3%\3%\3%\3%\3%\3%\3%\3&\3&\5&\u0298\n"+
		"&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\5(\u02a3\n(\3(\2\2)\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\20\4\2\65\65RR\3"+
		"\2\22\32\3\2\21\25\3\2\21\26\6\2\3\3\5\5\7\r\34\35\3\2 9\3\2=V\3\2\21"+
		"\32\4\2  ==\4\2!!>>\4\2\"\"??\4\2##@@\4\2$$AA\4\2%%BB\2\u02ee\2P\3\2\2"+
		"\2\4d\3\2\2\2\6h\3\2\2\2\bj\3\2\2\2\n|\3\2\2\2\f~\3\2\2\2\16\u008c\3\2"+
		"\2\2\20\u0099\3\2\2\2\22\u009f\3\2\2\2\24\u00a4\3\2\2\2\26\u00a7\3\2\2"+
		"\2\30\u00ad\3\2\2\2\32\u00b4\3\2\2\2\34\u01ee\3\2\2\2\36\u01f0\3\2\2\2"+
		" \u0202\3\2\2\2\"\u0204\3\2\2\2$\u021a\3\2\2\2&\u0221\3\2\2\2(\u0228\3"+
		"\2\2\2*\u022b\3\2\2\2,\u0236\3\2\2\2.\u023e\3\2\2\2\60\u0246\3\2\2\2\62"+
		"\u024b\3\2\2\2\64\u024f\3\2\2\2\66\u0257\3\2\2\28\u0260\3\2\2\2:\u0267"+
		"\3\2\2\2<\u026f\3\2\2\2>\u0272\3\2\2\2@\u027c\3\2\2\2B\u027e\3\2\2\2D"+
		"\u0280\3\2\2\2F\u028a\3\2\2\2H\u028e\3\2\2\2J\u0297\3\2\2\2L\u0299\3\2"+
		"\2\2N\u02a2\3\2\2\2PQ\5\f\7\2QR\7\33\2\2RU\5\4\3\2ST\7\36\2\2TV\5:\36"+
		"\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WX\7\4\2\2XZ\5<\37\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z\3\3\2\2\2[\\\7\20\2\2\\]\7\20\2\2]^\3\2\2\2^_\5\16\b\2_`\5(\25\2`"+
		"e\3\2\2\2ae\5*\26\2be\5.\30\2ce\5\60\31\2d[\3\2\2\2da\3\2\2\2db\3\2\2"+
		"\2dc\3\2\2\2e\5\3\2\2\2fi\5\2\2\2gi\5\b\5\2hf\3\2\2\2hg\3\2\2\2i\7\3\2"+
		"\2\2jm\5\n\6\2kl\7\36\2\2ln\5:\36\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2op\7"+
		"\4\2\2pr\5<\37\2qo\3\2\2\2qr\3\2\2\2r\t\3\2\2\2st\7\20\2\2tu\7\20\2\2"+
		"uv\3\2\2\2vw\5\16\b\2wx\5(\25\2x}\3\2\2\2y}\5*\26\2z}\5,\27\2{}\5\60\31"+
		"\2|s\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\13\3\2\2\2~\u0086\5J&\2\177"+
		"\u0085\5J&\2\u0080\u0085\5L\'\2\u0081\u0085\7\f\2\2\u0082\u0085\7\16\2"+
		"\2\u0083\u0085\7\17\2\2\u0084\177\3\2\2\2\u0084\u0080\3\2\2\2\u0084\u0081"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\r\3\2\2\2\u0088\u0086\3\2\2\2"+
		"\u0089\u008a\5\20\t\2\u008a\u008b\7\37\2\2\u008b\u008d\3\2\2\2\u008c\u0089"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\5\22\n\2"+
		"\u008f\u0090\7\33\2\2\u0090\u0092\5\24\13\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093\u0098\5@!\2\u0094\u0098\5> \2\u0095"+
		"\u0098\5B\"\2\u0096\u0098\7\33\2\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\21\3\2\2\2\u009b\u0099\3\2\2"+
		"\2\u009c\u00a0\5D#\2\u009d\u00a0\5\"\22\2\u009e\u00a0\5&\24\2\u009f\u009c"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\23\3\2\2\2\u00a1"+
		"\u00a3\5L\'\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8"+
		"\t\2\2\2\u00a8\u00a9\5\30\r\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab\5\32\16"+
		"\2\u00ab\27\3\2\2\2\u00ac\u00ae\5N(\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\31\3\2\2\2\u00b1"+
		"\u00b5\5@!\2\u00b2\u00b5\5B\"\2\u00b3\u00b5\7\33\2\2\u00b4\u00b1\3\2\2"+
		"\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\33\3\2\2\2\u00b8\u00b9\5\36\20\2\u00b9"+
		"\u00ba\7\33\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\5\36\20\2\u00bc\u00bd"+
		"\7\33\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\36\20\2\u00bf\u00c0\7\33\2"+
		"\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\5\36\20\2\u00c2\u00c3\7\33\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\5\36\20\2\u00c5\u00c6\7\33\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9\7\33\2\2\u00c9\u00ca\3\2\2"+
		"\2\u00ca\u00cb\5 \21\2\u00cb\u01ef\3\2\2\2\u00cc\u00cd\7\33\2\2\u00cd"+
		"\u00ce\7\33\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\5\36\20\2\u00d0\u00d1"+
		"\7\33\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\5\36\20\2\u00d3\u00d4\7\33\2"+
		"\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5\36\20\2\u00d6\u00d7\7\33\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\5\36\20\2\u00d9\u00da\7\33\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\u00dc\5\36\20\2\u00dc\u00dd\7\33\2\2\u00dd\u00de\3\2\2"+
		"\2\u00de\u00df\5 \21\2\u00df\u01ef\3\2\2\2\u00e0\u00e2\5\36\20\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\33"+
		"\2\2\u00e4\u00e5\7\33\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\5\36\20\2\u00e7"+
		"\u00e8\7\33\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\5\36\20\2\u00ea\u00eb"+
		"\7\33\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\5\36\20\2\u00ed\u00ee\7\33\2"+
		"\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1\7\33\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\5 \21\2\u00f3\u01ef\3\2\2\2\u00f4\u00f5\5\36"+
		"\20\2\u00f5\u00f6\7\33\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f4\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\5\36\20\2\u00fa\u00f7\3"+
		"\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\33\2\2\u00fd"+
		"\u00fe\7\33\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\5\36\20\2\u0100\u0101"+
		"\7\33\2\2\u0101\u0102\3\2\2\2\u0102\u0103\5\36\20\2\u0103\u0104\7\33\2"+
		"\2\u0104\u0105\3\2\2\2\u0105\u0106\5\36\20\2\u0106\u0107\7\33\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\5 \21\2\u0109\u01ef\3\2\2\2\u010a\u010b\5\36"+
		"\20\2\u010b\u010c\7\33\2\2\u010c\u010e\3\2\2\2\u010d\u010a\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0116\3\2\2\2\u010f\u0110\5\36\20\2\u0110\u0111\7"+
		"\33\2\2\u0111\u0112\3\2\2\2\u0112\u0113\5\36\20\2\u0113\u0114\7\33\2\2"+
		"\u0114\u0116\3\2\2\2\u0115\u010d\3\2\2\2\u0115\u010f\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117\u0119\5\36\20\2\u0118\u0115\3\2\2\2\u0118\u0119\3\2\2\2"+
		"\u0119\u011a\3\2\2\2\u011a\u011b\7\33\2\2\u011b\u011c\7\33\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\5\36\20\2\u011e\u011f\7\33\2\2\u011f\u0120\3\2\2"+
		"\2\u0120\u0121\5\36\20\2\u0121\u0122\7\33\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0124\5 \21\2\u0124\u01ef\3\2\2\2\u0125\u0126\5\36\20\2\u0126\u0127\7"+
		"\33\2\2\u0127\u0129\3\2\2\2\u0128\u0125\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u013a\3\2\2\2\u012a\u012b\5\36\20\2\u012b\u012c\7\33\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012e\5\36\20\2\u012e\u012f\7\33\2\2\u012f\u013a\3\2\2"+
		"\2\u0130\u0131\5\36\20\2\u0131\u0132\7\33\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\5\36\20\2\u0134\u0135\7\33\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\5\36\20\2\u0137\u0138\7\33\2\2\u0138\u013a\3\2\2\2\u0139\u0128\3\2\2"+
		"\2\u0139\u012a\3\2\2\2\u0139\u0130\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d"+
		"\5\36\20\2\u013c\u0139\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2"+
		"\u013e\u013f\7\33\2\2\u013f\u0140\7\33\2\2\u0140\u0141\3\2\2\2\u0141\u0142"+
		"\5\36\20\2\u0142\u0143\7\33\2\2\u0143\u0144\5 \21\2\u0144\u01ef\3\2\2"+
		"\2\u0145\u0146\5\36\20\2\u0146\u0147\7\33\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0145\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0166\3\2\2\2\u014a\u014b\5\36"+
		"\20\2\u014b\u014c\7\33\2\2\u014c\u014d\3\2\2\2\u014d\u014e\5\36\20\2\u014e"+
		"\u014f\7\33\2\2\u014f\u0166\3\2\2\2\u0150\u0151\5\36\20\2\u0151\u0152"+
		"\7\33\2\2\u0152\u0153\3\2\2\2\u0153\u0154\5\36\20\2\u0154\u0155\7\33\2"+
		"\2\u0155\u0156\3\2\2\2\u0156\u0157\5\36\20\2\u0157\u0158\7\33\2\2\u0158"+
		"\u0166\3\2\2\2\u0159\u015a\5\36\20\2\u015a\u015b\7\33\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\5\36\20\2\u015d\u015e\7\33\2\2\u015e\u015f\3\2\2"+
		"\2\u015f\u0160\5\36\20\2\u0160\u0161\7\33\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0163\5\36\20\2\u0163\u0164\7\33\2\2\u0164\u0166\3\2\2\2\u0165\u0148"+
		"\3\2\2\2\u0165\u014a\3\2\2\2\u0165\u0150\3\2\2\2\u0165\u0159\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0169\5\36\20\2\u0168\u0165\3\2\2\2\u0168\u0169\3"+
		"\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\7\33\2\2\u016b\u016c\7\33\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u01ef\5 \21\2\u016e\u016f\5\36\20\2\u016f\u0170\7"+
		"\33\2\2\u0170\u0172\3\2\2\2\u0171\u016e\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u019e\3\2\2\2\u0173\u0174\5\36\20\2\u0174\u0175\7\33\2\2\u0175\u0176"+
		"\3\2\2\2\u0176\u0177\5\36\20\2\u0177\u0178\7\33\2\2\u0178\u019e\3\2\2"+
		"\2\u0179\u017a\5\36\20\2\u017a\u017b\7\33\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017d\5\36\20\2\u017d\u017e\7\33\2\2\u017e\u017f\3\2\2\2\u017f\u0180"+
		"\5\36\20\2\u0180\u0181\7\33\2\2\u0181\u019e\3\2\2\2\u0182\u0183\5\36\20"+
		"\2\u0183\u0184\7\33\2\2\u0184\u0185\3\2\2\2\u0185\u0186\5\36\20\2\u0186"+
		"\u0187\7\33\2\2\u0187\u0188\3\2\2\2\u0188\u0189\5\36\20\2\u0189\u018a"+
		"\7\33\2\2\u018a\u018b\3\2\2\2\u018b\u018c\5\36\20\2\u018c\u018d\7\33\2"+
		"\2\u018d\u019e\3\2\2\2\u018e\u018f\5\36\20\2\u018f\u0190\7\33\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0192\5\36\20\2\u0192\u0193\7\33\2\2\u0193\u0194"+
		"\3\2\2\2\u0194\u0195\5\36\20\2\u0195\u0196\7\33\2\2\u0196\u0197\3\2\2"+
		"\2\u0197\u0198\5\36\20\2\u0198\u0199\7\33\2\2\u0199\u019a\3\2\2\2\u019a"+
		"\u019b\5\36\20\2\u019b\u019c\7\33\2\2\u019c\u019e\3\2\2\2\u019d\u0171"+
		"\3\2\2\2\u019d\u0173\3\2\2\2\u019d\u0179\3\2\2\2\u019d\u0182\3\2\2\2\u019d"+
		"\u018e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\5\36\20\2\u01a0\u019d\3"+
		"\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\33\2\2\u01a3"+
		"\u01a4\7\33\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01ef\5\36\20\2\u01a6\u01a7"+
		"\5\36\20\2\u01a7\u01a8\7\33\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a6\3\2\2"+
		"\2\u01a9\u01aa\3\2\2\2\u01aa\u01e8\3\2\2\2\u01ab\u01ac\5\36\20\2\u01ac"+
		"\u01ad\7\33\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\5\36\20\2\u01af\u01b0"+
		"\7\33\2\2\u01b0\u01e8\3\2\2\2\u01b1\u01b2\5\36\20\2\u01b2\u01b3\7\33\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\5\36\20\2\u01b5\u01b6\7\33\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b8\5\36\20\2\u01b8\u01b9\7\33\2\2\u01b9\u01e8"+
		"\3\2\2\2\u01ba\u01bb\5\36\20\2\u01bb\u01bc\7\33\2\2\u01bc\u01bd\3\2\2"+
		"\2\u01bd\u01be\5\36\20\2\u01be\u01bf\7\33\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c1\5\36\20\2\u01c1\u01c2\7\33\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4"+
		"\5\36\20\2\u01c4\u01c5\7\33\2\2\u01c5\u01e8\3\2\2\2\u01c6\u01c7\5\36\20"+
		"\2\u01c7\u01c8\7\33\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\5\36\20\2\u01ca"+
		"\u01cb\7\33\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\5\36\20\2\u01cd\u01ce"+
		"\7\33\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\5\36\20\2\u01d0\u01d1\7\33\2"+
		"\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\5\36\20\2\u01d3\u01d4\7\33\2\2\u01d4"+
		"\u01e8\3\2\2\2\u01d5\u01d6\5\36\20\2\u01d6\u01d7\7\33\2\2\u01d7\u01d8"+
		"\3\2\2\2\u01d8\u01d9\5\36\20\2\u01d9\u01da\7\33\2\2\u01da\u01db\3\2\2"+
		"\2\u01db\u01dc\5\36\20\2\u01dc\u01dd\7\33\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\u01df\5\36\20\2\u01df\u01e0\7\33\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2"+
		"\5\36\20\2\u01e2\u01e3\7\33\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\5\36\20"+
		"\2\u01e5\u01e6\7\33\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01a9\3\2\2\2\u01e7"+
		"\u01ab\3\2\2\2\u01e7\u01b1\3\2\2\2\u01e7\u01ba\3\2\2\2\u01e7\u01c6\3\2"+
		"\2\2\u01e7\u01d5\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\5\36\20\2\u01ea"+
		"\u01e7\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\7\33"+
		"\2\2\u01ed\u01ef\7\33\2\2\u01ee\u00b8\3\2\2\2\u01ee\u00cc\3\2\2\2\u01ee"+
		"\u00e1\3\2\2\2\u01ee\u00fa\3\2\2\2\u01ee\u0118\3\2\2\2\u01ee\u013c\3\2"+
		"\2\2\u01ee\u0168\3\2\2\2\u01ee\u01a0\3\2\2\2\u01ee\u01ea\3\2\2\2\u01ef"+
		"\35\3\2\2\2\u01f0\u01fb\5N(\2\u01f1\u01f3\5N(\2\u01f2\u01f1\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01fc\3\2\2\2\u01f4\u01f5\5N(\2\u01f5\u01f6\5N(\2"+
		"\u01f6\u01fc\3\2\2\2\u01f7\u01f8\5N(\2\u01f8\u01f9\5N(\2\u01f9\u01fa\5"+
		"N(\2\u01fa\u01fc\3\2\2\2\u01fb\u01f2\3\2\2\2\u01fb\u01f4\3\2\2\2\u01fb"+
		"\u01f7\3\2\2\2\u01fc\37\3\2\2\2\u01fd\u01fe\5\36\20\2\u01fe\u01ff\7\33"+
		"\2\2\u01ff\u0200\5\36\20\2\u0200\u0203\3\2\2\2\u0201\u0203\5\"\22\2\u0202"+
		"\u01fd\3\2\2\2\u0202\u0201\3\2\2\2\u0203!\3\2\2\2\u0204\u0205\5$\23\2"+
		"\u0205\u0206\7\17\2\2\u0206\u0207\5$\23\2\u0207\u0208\7\17\2\2\u0208\u0209"+
		"\5$\23\2\u0209\u020a\7\17\2\2\u020a\u020b\5$\23\2\u020b#\3\2\2\2\u020c"+
		"\u021b\5L\'\2\u020d\u020e\t\3\2\2\u020e\u021b\5L\'\2\u020f\u0210\7\22"+
		"\2\2\u0210\u0211\5L\'\2\u0211\u0212\5L\'\2\u0212\u021b\3\2\2\2\u0213\u0214"+
		"\7\23\2\2\u0214\u0215\t\4\2\2\u0215\u021b\5L\'\2\u0216\u0217\7\23\2\2"+
		"\u0217\u0218\7\26\2\2\u0218\u0219\3\2\2\2\u0219\u021b\t\5\2\2\u021a\u020c"+
		"\3\2\2\2\u021a\u020d\3\2\2\2\u021a\u020f\3\2\2\2\u021a\u0213\3\2\2\2\u021a"+
		"\u0216\3\2\2\2\u021b%\3\2\2\2\u021c\u0220\5@!\2\u021d\u0220\5> \2\u021e"+
		"\u0220\5B\"\2\u021f\u021c\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2"+
		"\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\'\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0225\7\20\2\2\u0225\u0227\5\62\32"+
		"\2\u0226\u0224\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229"+
		"\3\2\2\2\u0229)\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u0234\7\20\2\2\u022c"+
		"\u0231\5\64\33\2\u022d\u022e\7\20\2\2\u022e\u0230\5\62\32\2\u022f\u022d"+
		"\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232"+
		"\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u022c\3\2\2\2\u0234\u0235\3\2"+
		"\2\2\u0235+\3\2\2\2\u0236\u023b\5\66\34\2\u0237\u0238\7\20\2\2\u0238\u023a"+
		"\5\62\32\2\u0239\u0237\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2"+
		"\u023b\u023c\3\2\2\2\u023c-\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u0243\5"+
		"\64\33\2\u023f\u0240\7\20\2\2\u0240\u0242\5\62\32\2\u0241\u023f\3\2\2"+
		"\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244/"+
		"\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0247\3\2\2\2\u0247\61\3\2\2\2\u0248"+
		"\u024a\58\35\2\u0249\u0248\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2"+
		"\2\2\u024b\u024c\3\2\2\2\u024c\63\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0250"+
		"\58\35\2\u024f\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\65\3\2\2\2\u0253\u0258\5@!\2\u0254\u0258\5> \2\u0255"+
		"\u0258\5B\"\2\u0256\u0258\7\37\2\2\u0257\u0253\3\2\2\2\u0257\u0254\3\2"+
		"\2\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\67\3\2\2\2\u025b\u0261\5@!\2"+
		"\u025c\u0261\5> \2\u025d\u0261\5B\"\2\u025e\u0261\7\33\2\2\u025f\u0261"+
		"\7\37\2\2\u0260\u025b\3\2\2\2\u0260\u025c\3\2\2\2\u0260\u025d\3\2\2\2"+
		"\u0260\u025e\3\2\2\2\u0260\u025f\3\2\2\2\u02619\3\2\2\2\u0262\u0266\5"+
		"8\35\2\u0263\u0266\7\20\2\2\u0264\u0266\7\36\2\2\u0265\u0262\3\2\2\2\u0265"+
		"\u0263\3\2\2\2\u0265\u0264\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2"+
		"\2\2\u0267\u0268\3\2\2\2\u0268;\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026e"+
		"\58\35\2\u026b\u026e\7\20\2\2\u026c\u026e\7\36\2\2\u026d\u026a\3\2\2\2"+
		"\u026d\u026b\3\2\2\2\u026d\u026c\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d"+
		"\3\2\2\2\u026f\u0270\3\2\2\2\u0270=\3\2\2\2\u0271\u026f\3\2\2\2\u0272"+
		"\u0273\7\6\2\2\u0273\u0274\5N(\2\u0274\u0275\5N(\2\u0275?\3\2\2\2\u0276"+
		"\u027d\5J&\2\u0277\u027d\5L\'\2\u0278\u027d\7\16\2\2\u0279\u027d\7\17"+
		"\2\2\u027a\u027d\7<\2\2\u027b\u027d\7W\2\2\u027c\u0276\3\2\2\2\u027c\u0277"+
		"\3\2\2\2\u027c\u0278\3\2\2\2\u027c\u0279\3\2\2\2\u027c\u027a\3\2\2\2\u027c"+
		"\u027b\3\2\2\2\u027dA\3\2\2\2\u027e\u027f\t\6\2\2\u027fC\3\2\2\2\u0280"+
		"\u0284\7:\2\2\u0281\u0285\5\34\17\2\u0282\u0285\5H%\2\u0283\u0285\5\26"+
		"\f\2\u0284\u0281\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286\u0287\7;\2\2\u0287E\3\2\2\2\u0288\u028b\5@!\2\u0289"+
		"\u028b\5> \2\u028a\u0288\3\2\2\2\u028a\u0289\3\2\2\2\u028b\u028c\3\2\2"+
		"\2\u028c\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028dG\3\2\2\2\u028e\u028f"+
		"\5\34\17\2\u028f\u0290\7\6\2\2\u0290\u0291\7\23\2\2\u0291\u0292\7\26\2"+
		"\2\u0292\u0293\3\2\2\2\u0293\u0294\5F$\2\u0294I\3\2\2\2\u0295\u0298\t"+
		"\7\2\2\u0296\u0298\t\b\2\2\u0297\u0295\3\2\2\2\u0297\u0296\3\2\2\2\u0298"+
		"K\3\2\2\2\u0299\u029a\t\t\2\2\u029aM\3\2\2\2\u029b\u02a3\5L\'\2\u029c"+
		"\u02a3\t\n\2\2\u029d\u02a3\t\13\2\2\u029e\u02a3\t\f\2\2\u029f\u02a3\t"+
		"\r\2\2\u02a0\u02a3\t\16\2\2\u02a1\u02a3\t\17\2\2\u02a2\u029b\3\2\2\2\u02a2"+
		"\u029c\3\2\2\2\u02a2\u029d\3\2\2\2\u02a2\u029e\3\2\2\2\u02a2\u029f\3\2"+
		"\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a1\3\2\2\2\u02a3O\3\2\2\2AUYdhmq|\u0084"+
		"\u0086\u008c\u0091\u0097\u0099\u009f\u00a4\u00af\u00b4\u00b6\u00e1\u00f7"+
		"\u00fa\u010d\u0115\u0118\u0128\u0139\u013c\u0148\u0165\u0168\u0171\u019d"+
		"\u01a0\u01a9\u01e7\u01ea\u01ee\u01f2\u01fb\u0202\u021a\u021f\u0221\u0228"+
		"\u0231\u0234\u023b\u0243\u024b\u0251\u0257\u0259\u0260\u0265\u0267\u026d"+
		"\u026f\u027c\u0284\u028a\u028c\u0297\u02a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}