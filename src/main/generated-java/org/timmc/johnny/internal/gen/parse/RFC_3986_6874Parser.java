// Generated from src/main/grammar/RFC_3986_6874.g4 by ANTLR 4.7.1
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
		RULE_host = 8, RULE_port = 9, RULE_ipvfuture = 10, RULE_ipv6address = 11, 
		RULE_h16 = 12, RULE_ls32 = 13, RULE_ipv4address = 14, RULE_dec_octet = 15, 
		RULE_reg_name = 16, RULE_path_abempty = 17, RULE_path_absolute = 18, RULE_path_noscheme = 19, 
		RULE_path_rootless = 20, RULE_path_empty = 21, RULE_segment = 22, RULE_segment_nz = 23, 
		RULE_segment_nz_nc = 24, RULE_pchar = 25, RULE_query = 26, RULE_fragment_1 = 27, 
		RULE_pct_encoded = 28, RULE_unreserved = 29, RULE_sub_delims = 30, RULE_ip_literal = 31, 
		RULE_zoneid = 32, RULE_ipv6addrz = 33, RULE_alpha = 34, RULE_digit = 35, 
		RULE_hexdig = 36;
	public static final String[] ruleNames = {
		"uri", "hier_part", "uri_reference", "relative_ref", "relative_part", 
		"scheme", "authority", "userinfo", "host", "port", "ipvfuture", "ipv6address", 
		"h16", "ls32", "ipv4address", "dec_octet", "reg_name", "path_abempty", 
		"path_absolute", "path_noscheme", "path_rootless", "path_empty", "segment", 
		"segment_nz", "segment_nz_nc", "pchar", "query", "fragment_1", "pct_encoded", 
		"unreserved", "sub_delims", "ip_literal", "zoneid", "ipv6addrz", "alpha", 
		"digit", "hexdig"
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
			setState(74);
			scheme();
			setState(75);
			match(COLON);
			setState(76);
			hier_part();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(77);
				match(QUESTION);
				setState(78);
				query();
				}
			}

			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POUND) {
				{
				setState(81);
				match(POUND);
				setState(82);
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
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(85);
				match(SLASH);
				setState(86);
				match(SLASH);
				}
				setState(88);
				authority();
				setState(89);
				path_abempty();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				path_absolute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				path_rootless();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
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
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				uri();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
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
			setState(100);
			relative_part();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(101);
				match(QUESTION);
				setState(102);
				query();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POUND) {
				{
				setState(105);
				match(POUND);
				setState(106);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(109);
				match(SLASH);
				setState(110);
				match(SLASH);
				}
				setState(112);
				authority();
				setState(113);
				path_abempty();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				path_absolute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				path_noscheme();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
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
			setState(120);
			alpha();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)))) != 0)) {
				{
				setState(126);
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
					setState(121);
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
					setState(122);
					digit();
					}
					break;
				case PLUS:
					{
					setState(123);
					match(PLUS);
					}
					break;
				case DASH:
					{
					setState(124);
					match(DASH);
					}
					break;
				case PERIOD:
					{
					setState(125);
					match(PERIOD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(130);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(131);
				userinfo();
				setState(132);
				match(AT);
				}
				break;
			}
			setState(136);
			host();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(137);
				match(COLON);
				setState(138);
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
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(145);
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
					setState(141);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(142);
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
					setState(143);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(144);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(149);
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
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				ip_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				ipv4address();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
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
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) {
				{
				{
				setState(155);
				digit();
				}
				}
				setState(160);
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
		public TerminalNode PERIOD() { return getToken(RFC_3986_6874Parser.PERIOD, 0); }
		public TerminalNode CAP_V() { return getToken(RFC_3986_6874Parser.CAP_V, 0); }
		public TerminalNode V() { return getToken(RFC_3986_6874Parser.V, 0); }
		public List<HexdigContext> hexdig() {
			return getRuleContexts(HexdigContext.class);
		}
		public HexdigContext hexdig(int i) {
			return getRuleContext(HexdigContext.class,i);
		}
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
			setState(161);
			_la = _input.LA(1);
			if ( !(_la==CAP_V || _la==V) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				hexdig();
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0) );
			setState(167);
			match(PERIOD);
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(171);
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
					setState(168);
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
					setState(169);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(170);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(173); 
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
		enterRule(_localctx, 22, RULE_ipv6address);
		int _la;
		try {
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(175);
				h16();
				setState(176);
				match(COLON);
				}
				{
				setState(178);
				h16();
				setState(179);
				match(COLON);
				}
				{
				setState(181);
				h16();
				setState(182);
				match(COLON);
				}
				{
				setState(184);
				h16();
				setState(185);
				match(COLON);
				}
				{
				setState(187);
				h16();
				setState(188);
				match(COLON);
				}
				{
				setState(190);
				h16();
				setState(191);
				match(COLON);
				}
				setState(193);
				ls32();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				{
				setState(195);
				match(COLON);
				setState(196);
				match(COLON);
				}
				{
				setState(198);
				h16();
				setState(199);
				match(COLON);
				}
				{
				setState(201);
				h16();
				setState(202);
				match(COLON);
				}
				{
				setState(204);
				h16();
				setState(205);
				match(COLON);
				}
				{
				setState(207);
				h16();
				setState(208);
				match(COLON);
				}
				{
				setState(210);
				h16();
				setState(211);
				match(COLON);
				}
				setState(213);
				ls32();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(215);
					h16();
					}
				}

				{
				setState(218);
				match(COLON);
				setState(219);
				match(COLON);
				}
				{
				setState(221);
				h16();
				setState(222);
				match(COLON);
				}
				{
				setState(224);
				h16();
				setState(225);
				match(COLON);
				}
				{
				setState(227);
				h16();
				setState(228);
				match(COLON);
				}
				{
				setState(230);
				h16();
				setState(231);
				match(COLON);
				}
				setState(233);
				ls32();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					{
					setState(238);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(235);
						h16();
						setState(236);
						match(COLON);
						}
						break;
					}
					}
					setState(240);
					h16();
					}
				}

				{
				setState(243);
				match(COLON);
				setState(244);
				match(COLON);
				}
				{
				setState(246);
				h16();
				setState(247);
				match(COLON);
				}
				{
				setState(249);
				h16();
				setState(250);
				match(COLON);
				}
				{
				setState(252);
				h16();
				setState(253);
				match(COLON);
				}
				setState(255);
				ls32();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(268);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						setState(260);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(257);
							h16();
							setState(258);
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
						setState(262);
						h16();
						setState(263);
						match(COLON);
						}
						{
						setState(265);
						h16();
						setState(266);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(270);
					h16();
					}
				}

				{
				setState(273);
				match(COLON);
				setState(274);
				match(COLON);
				}
				{
				setState(276);
				h16();
				setState(277);
				match(COLON);
				}
				{
				setState(279);
				h16();
				setState(280);
				match(COLON);
				}
				setState(282);
				ls32();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(304);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(287);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
						case 1:
							{
							setState(284);
							h16();
							setState(285);
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
						setState(289);
						h16();
						setState(290);
						match(COLON);
						}
						{
						setState(292);
						h16();
						setState(293);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(295);
						h16();
						setState(296);
						match(COLON);
						}
						{
						setState(298);
						h16();
						setState(299);
						match(COLON);
						}
						{
						setState(301);
						h16();
						setState(302);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(306);
					h16();
					}
				}

				{
				setState(309);
				match(COLON);
				setState(310);
				match(COLON);
				}
				setState(312);
				h16();
				setState(313);
				match(COLON);
				setState(314);
				ls32();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(319);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(316);
							h16();
							setState(317);
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
						setState(321);
						h16();
						setState(322);
						match(COLON);
						}
						{
						setState(324);
						h16();
						setState(325);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(327);
						h16();
						setState(328);
						match(COLON);
						}
						{
						setState(330);
						h16();
						setState(331);
						match(COLON);
						}
						{
						setState(333);
						h16();
						setState(334);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(336);
						h16();
						setState(337);
						match(COLON);
						}
						{
						setState(339);
						h16();
						setState(340);
						match(COLON);
						}
						{
						setState(342);
						h16();
						setState(343);
						match(COLON);
						}
						{
						setState(345);
						h16();
						setState(346);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(350);
					h16();
					}
				}

				{
				setState(353);
				match(COLON);
				setState(354);
				match(COLON);
				}
				setState(356);
				ls32();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(404);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(360);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
						case 1:
							{
							setState(357);
							h16();
							setState(358);
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
						setState(362);
						h16();
						setState(363);
						match(COLON);
						}
						{
						setState(365);
						h16();
						setState(366);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(368);
						h16();
						setState(369);
						match(COLON);
						}
						{
						setState(371);
						h16();
						setState(372);
						match(COLON);
						}
						{
						setState(374);
						h16();
						setState(375);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(377);
						h16();
						setState(378);
						match(COLON);
						}
						{
						setState(380);
						h16();
						setState(381);
						match(COLON);
						}
						{
						setState(383);
						h16();
						setState(384);
						match(COLON);
						}
						{
						setState(386);
						h16();
						setState(387);
						match(COLON);
						}
						}
						}
						break;
					case 5:
						{
						{
						{
						setState(389);
						h16();
						setState(390);
						match(COLON);
						}
						{
						setState(392);
						h16();
						setState(393);
						match(COLON);
						}
						{
						setState(395);
						h16();
						setState(396);
						match(COLON);
						}
						{
						setState(398);
						h16();
						setState(399);
						match(COLON);
						}
						{
						setState(401);
						h16();
						setState(402);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(406);
					h16();
					}
				}

				{
				setState(409);
				match(COLON);
				setState(410);
				match(COLON);
				}
				setState(412);
				h16();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(478);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(416);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(413);
							h16();
							setState(414);
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
						setState(418);
						h16();
						setState(419);
						match(COLON);
						}
						{
						setState(421);
						h16();
						setState(422);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(424);
						h16();
						setState(425);
						match(COLON);
						}
						{
						setState(427);
						h16();
						setState(428);
						match(COLON);
						}
						{
						setState(430);
						h16();
						setState(431);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
						{
						setState(433);
						h16();
						setState(434);
						match(COLON);
						}
						{
						setState(436);
						h16();
						setState(437);
						match(COLON);
						}
						{
						setState(439);
						h16();
						setState(440);
						match(COLON);
						}
						{
						setState(442);
						h16();
						setState(443);
						match(COLON);
						}
						}
						}
						break;
					case 5:
						{
						{
						{
						setState(445);
						h16();
						setState(446);
						match(COLON);
						}
						{
						setState(448);
						h16();
						setState(449);
						match(COLON);
						}
						{
						setState(451);
						h16();
						setState(452);
						match(COLON);
						}
						{
						setState(454);
						h16();
						setState(455);
						match(COLON);
						}
						{
						setState(457);
						h16();
						setState(458);
						match(COLON);
						}
						}
						}
						break;
					case 6:
						{
						{
						{
						setState(460);
						h16();
						setState(461);
						match(COLON);
						}
						{
						setState(463);
						h16();
						setState(464);
						match(COLON);
						}
						{
						setState(466);
						h16();
						setState(467);
						match(COLON);
						}
						{
						setState(469);
						h16();
						setState(470);
						match(COLON);
						}
						{
						setState(472);
						h16();
						setState(473);
						match(COLON);
						}
						{
						setState(475);
						h16();
						setState(476);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(480);
					h16();
					}
				}

				{
				setState(483);
				match(COLON);
				setState(484);
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
		enterRule(_localctx, 24, RULE_h16);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			hexdig();
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(488);
					hexdig();
					}
				}

				}
				break;
			case 2:
				{
				{
				setState(491);
				hexdig();
				setState(492);
				hexdig();
				}
				}
				break;
			case 3:
				{
				{
				setState(494);
				hexdig();
				setState(495);
				hexdig();
				setState(496);
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
		enterRule(_localctx, 26, RULE_ls32);
		try {
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(500);
				h16();
				setState(501);
				match(COLON);
				setState(502);
				h16();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
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
		enterRule(_localctx, 28, RULE_ipv4address);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			dec_octet();
			setState(508);
			match(PERIOD);
			setState(509);
			dec_octet();
			setState(510);
			match(PERIOD);
			setState(511);
			dec_octet();
			setState(512);
			match(PERIOD);
			setState(513);
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
		enterRule(_localctx, 30, RULE_dec_octet);
		int _la;
		try {
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				digit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(516);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(517);
				digit();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(518);
				match(ONE);
				setState(519);
				digit();
				setState(520);
				digit();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(522);
				match(TWO);
				setState(523);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR))) != 0)) ) {
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
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				{
				setState(525);
				match(TWO);
				setState(526);
				match(FIVE);
				}
				setState(528);
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
		enterRule(_localctx, 32, RULE_reg_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(534);
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
					setState(531);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(532);
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
					setState(533);
					sub_delims();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(538);
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
		enterRule(_localctx, 34, RULE_path_abempty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(539);
				match(SLASH);
				setState(540);
				segment();
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
		enterRule(_localctx, 36, RULE_path_absolute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(SLASH);
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(547);
				segment_nz();
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SLASH) {
					{
					{
					setState(548);
					match(SLASH);
					setState(549);
					segment();
					}
					}
					setState(554);
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
		enterRule(_localctx, 38, RULE_path_noscheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			segment_nz_nc();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(558);
				match(SLASH);
				setState(559);
				segment();
				}
				}
				setState(564);
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
		enterRule(_localctx, 40, RULE_path_rootless);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			segment_nz();
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(566);
				match(SLASH);
				setState(567);
				segment();
				}
				}
				setState(572);
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
		enterRule(_localctx, 42, RULE_path_empty);
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
		enterRule(_localctx, 44, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				{
				setState(575);
				pchar();
				}
				}
				setState(580);
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
		enterRule(_localctx, 46, RULE_segment_nz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(581);
				pchar();
				}
				}
				setState(584); 
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
		enterRule(_localctx, 48, RULE_segment_nz_nc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(590);
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
					setState(586);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(587);
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
					setState(588);
					sub_delims();
					}
					break;
				case AT:
					{
					setState(589);
					match(AT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(592); 
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
		enterRule(_localctx, 50, RULE_pchar);
		try {
			setState(599);
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
				setState(594);
				unreserved();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(595);
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
				setState(596);
				sub_delims();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(597);
				match(COLON);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(598);
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
		enterRule(_localctx, 52, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(604);
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
					setState(601);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(602);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(603);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(608);
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
		enterRule(_localctx, 54, RULE_fragment_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(612);
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
					setState(609);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(610);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(611);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(616);
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
		enterRule(_localctx, 56, RULE_pct_encoded);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(PERCENT);
			setState(618);
			hexdig();
			setState(619);
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
		enterRule(_localctx, 58, RULE_unreserved);
		try {
			setState(627);
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
				setState(621);
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
				setState(622);
				digit();
				}
				break;
			case DASH:
				enterOuterAlt(_localctx, 3);
				{
				setState(623);
				match(DASH);
				}
				break;
			case PERIOD:
				enterOuterAlt(_localctx, 4);
				{
				setState(624);
				match(PERIOD);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 5);
				{
				setState(625);
				match(UNDERSCORE);
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 6);
				{
				setState(626);
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
		enterRule(_localctx, 60, RULE_sub_delims);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
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
		enterRule(_localctx, 62, RULE_ip_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(LEFT_BRACE);
			setState(635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(632);
				ipv6address();
				}
				break;
			case 2:
				{
				setState(633);
				ipv6addrz();
				}
				break;
			case 3:
				{
				setState(634);
				ipvfuture();
				}
				break;
			}
			setState(637);
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
		enterRule(_localctx, 64, RULE_zoneid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(641);
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
					setState(639);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(640);
					pct_encoded();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(643); 
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
		enterRule(_localctx, 66, RULE_ipv6addrz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			ipv6address();
			{
			setState(646);
			match(PERCENT);
			setState(647);
			match(TWO);
			setState(648);
			match(FIVE);
			}
			setState(650);
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
		enterRule(_localctx, 68, RULE_alpha);
		int _la;
		try {
			setState(654);
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
				setState(652);
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
				setState(653);
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
		enterRule(_localctx, 70, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
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
		enterRule(_localctx, 72, RULE_hexdig);
		int _la;
		try {
			setState(665);
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
				setState(658);
				digit();
				}
				break;
			case CAP_A:
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(659);
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
				setState(660);
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
				setState(661);
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
				setState(662);
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
				setState(663);
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
				setState(664);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u029e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\5\2R\n\2\3\2\3"+
		"\2\5\2V\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3a\n\3\3\4\3\4\5\4e"+
		"\n\4\3\5\3\5\3\5\5\5j\n\5\3\5\3\5\5\5n\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6y\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0081\n\7\f\7\16\7\u0084"+
		"\13\7\3\b\3\b\3\b\5\b\u0089\n\b\3\b\3\b\3\b\5\b\u008e\n\b\3\t\3\t\3\t"+
		"\3\t\7\t\u0094\n\t\f\t\16\t\u0097\13\t\3\n\3\n\3\n\5\n\u009c\n\n\3\13"+
		"\7\13\u009f\n\13\f\13\16\13\u00a2\13\13\3\f\3\f\6\f\u00a6\n\f\r\f\16\f"+
		"\u00a7\3\f\3\f\3\f\3\f\6\f\u00ae\n\f\r\f\16\f\u00af\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00db\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f1\n\r\3\r\5\r\u00f4\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0107"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u010f\n\r\3\r\5\r\u0112\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0122\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0133\n\r\3\r\5"+
		"\r\u0136\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0142\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u015f\n\r\3\r\5\r\u0162\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u016b\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u0197\n\r\3\r\5\r\u019a\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01a3\n\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01e1\n\r\3\r\5\r\u01e4\n\r\3\r\3\r"+
		"\5\r\u01e8\n\r\3\16\3\16\5\16\u01ec\n\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u01f5\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u01fc\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0214\n\21\3\22\3\22\3\22\7\22"+
		"\u0219\n\22\f\22\16\22\u021c\13\22\3\23\3\23\7\23\u0220\n\23\f\23\16\23"+
		"\u0223\13\23\3\24\3\24\3\24\3\24\7\24\u0229\n\24\f\24\16\24\u022c\13\24"+
		"\5\24\u022e\n\24\3\25\3\25\3\25\7\25\u0233\n\25\f\25\16\25\u0236\13\25"+
		"\3\26\3\26\3\26\7\26\u023b\n\26\f\26\16\26\u023e\13\26\3\27\3\27\3\30"+
		"\7\30\u0243\n\30\f\30\16\30\u0246\13\30\3\31\6\31\u0249\n\31\r\31\16\31"+
		"\u024a\3\32\3\32\3\32\3\32\6\32\u0251\n\32\r\32\16\32\u0252\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u025a\n\33\3\34\3\34\3\34\7\34\u025f\n\34\f\34\16"+
		"\34\u0262\13\34\3\35\3\35\3\35\7\35\u0267\n\35\f\35\16\35\u026a\13\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0276\n\37\3 "+
		"\3 \3!\3!\3!\3!\5!\u027e\n!\3!\3!\3\"\3\"\6\"\u0284\n\"\r\"\16\"\u0285"+
		"\3#\3#\3#\3#\3#\3#\3#\3$\3$\5$\u0291\n$\3%\3%\3&\3&\3&\3&\3&\3&\3&\5&"+
		"\u029c\n&\3&\2\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJ\2\20\4\2\65\65RR\3\2\22\32\3\2\21\25\3\2\21\26\6\2"+
		"\3\3\5\5\7\r\34\35\3\2 9\3\2=V\3\2\21\32\4\2  ==\4\2!!>>\4\2\"\"??\4\2"+
		"##@@\4\2$$AA\4\2%%BB\2\u02e9\2L\3\2\2\2\4`\3\2\2\2\6d\3\2\2\2\bf\3\2\2"+
		"\2\nx\3\2\2\2\fz\3\2\2\2\16\u0088\3\2\2\2\20\u0095\3\2\2\2\22\u009b\3"+
		"\2\2\2\24\u00a0\3\2\2\2\26\u00a3\3\2\2\2\30\u01e7\3\2\2\2\32\u01e9\3\2"+
		"\2\2\34\u01fb\3\2\2\2\36\u01fd\3\2\2\2 \u0213\3\2\2\2\"\u021a\3\2\2\2"+
		"$\u0221\3\2\2\2&\u0224\3\2\2\2(\u022f\3\2\2\2*\u0237\3\2\2\2,\u023f\3"+
		"\2\2\2.\u0244\3\2\2\2\60\u0248\3\2\2\2\62\u0250\3\2\2\2\64\u0259\3\2\2"+
		"\2\66\u0260\3\2\2\28\u0268\3\2\2\2:\u026b\3\2\2\2<\u0275\3\2\2\2>\u0277"+
		"\3\2\2\2@\u0279\3\2\2\2B\u0283\3\2\2\2D\u0287\3\2\2\2F\u0290\3\2\2\2H"+
		"\u0292\3\2\2\2J\u029b\3\2\2\2LM\5\f\7\2MN\7\33\2\2NQ\5\4\3\2OP\7\36\2"+
		"\2PR\5\66\34\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2ST\7\4\2\2TV\58\35\2US\3\2"+
		"\2\2UV\3\2\2\2V\3\3\2\2\2WX\7\20\2\2XY\7\20\2\2YZ\3\2\2\2Z[\5\16\b\2["+
		"\\\5$\23\2\\a\3\2\2\2]a\5&\24\2^a\5*\26\2_a\5,\27\2`W\3\2\2\2`]\3\2\2"+
		"\2`^\3\2\2\2`_\3\2\2\2a\5\3\2\2\2be\5\2\2\2ce\5\b\5\2db\3\2\2\2dc\3\2"+
		"\2\2e\7\3\2\2\2fi\5\n\6\2gh\7\36\2\2hj\5\66\34\2ig\3\2\2\2ij\3\2\2\2j"+
		"m\3\2\2\2kl\7\4\2\2ln\58\35\2mk\3\2\2\2mn\3\2\2\2n\t\3\2\2\2op\7\20\2"+
		"\2pq\7\20\2\2qr\3\2\2\2rs\5\16\b\2st\5$\23\2ty\3\2\2\2uy\5&\24\2vy\5("+
		"\25\2wy\5,\27\2xo\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\13\3\2\2\2z\u0082"+
		"\5F$\2{\u0081\5F$\2|\u0081\5H%\2}\u0081\7\f\2\2~\u0081\7\16\2\2\177\u0081"+
		"\7\17\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2"+
		"\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\r\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\5\20\t\2\u0086"+
		"\u0087\7\37\2\2\u0087\u0089\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\5\22\n\2\u008b\u008c\7\33\2\2\u008c"+
		"\u008e\5\24\13\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\17\3\2"+
		"\2\2\u008f\u0094\5<\37\2\u0090\u0094\5:\36\2\u0091\u0094\5> \2\u0092\u0094"+
		"\7\33\2\2\u0093\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\21\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009c\5@!\2\u0099"+
		"\u009c\5\36\20\2\u009a\u009c\5\"\22\2\u009b\u0098\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009a\3\2\2\2\u009c\23\3\2\2\2\u009d\u009f\5H%\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\25\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\t\2\2\2\u00a4\u00a6"+
		"\5J&\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ad\7\17\2\2\u00aa\u00ae\5"+
		"<\37\2\u00ab\u00ae\5> \2\u00ac\u00ae\7\33\2\2\u00ad\u00aa\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\27\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2"+
		"\u00b3\7\33\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6"+
		"\7\33\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\5\32\16\2\u00b8\u00b9\7\33\2"+
		"\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\5\32\16\2\u00bb\u00bc\7\33\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf\7\33\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\u00c1\5\32\16\2\u00c1\u00c2\7\33\2\2\u00c2\u00c3\3\2\2"+
		"\2\u00c3\u00c4\5\34\17\2\u00c4\u01e8\3\2\2\2\u00c5\u00c6\7\33\2\2\u00c6"+
		"\u00c7\7\33\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\5\32\16\2\u00c9\u00ca"+
		"\7\33\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00cd\7\33\2"+
		"\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\5\32\16\2\u00cf\u00d0\7\33\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\5\32\16\2\u00d2\u00d3\7\33\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d5\5\32\16\2\u00d5\u00d6\7\33\2\2\u00d6\u00d7\3\2\2"+
		"\2\u00d7\u00d8\5\34\17\2\u00d8\u01e8\3\2\2\2\u00d9\u00db\5\32\16\2\u00da"+
		"\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\33"+
		"\2\2\u00dd\u00de\7\33\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5\32\16\2\u00e0"+
		"\u00e1\7\33\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5\32\16\2\u00e3\u00e4"+
		"\7\33\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e7\7\33\2"+
		"\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\5\32\16\2\u00e9\u00ea\7\33\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\5\34\17\2\u00ec\u01e8\3\2\2\2\u00ed\u00ee\5"+
		"\32\16\2\u00ee\u00ef\7\33\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ed\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\5\32\16\2\u00f3\u00f0"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7\33\2\2"+
		"\u00f6\u00f7\7\33\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\5\32\16\2\u00f9"+
		"\u00fa\7\33\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\5\32\16\2\u00fc\u00fd"+
		"\7\33\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\5\32\16\2\u00ff\u0100\7\33\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\u0102\5\34\17\2\u0102\u01e8\3\2\2\2\u0103"+
		"\u0104\5\32\16\2\u0104\u0105\7\33\2\2\u0105\u0107\3\2\2\2\u0106\u0103"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010f\3\2\2\2\u0108\u0109\5\32\16\2"+
		"\u0109\u010a\7\33\2\2\u010a\u010b\3\2\2\2\u010b\u010c\5\32\16\2\u010c"+
		"\u010d\7\33\2\2\u010d\u010f\3\2\2\2\u010e\u0106\3\2\2\2\u010e\u0108\3"+
		"\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\5\32\16\2\u0111\u010e\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7\33\2\2\u0114\u0115\7"+
		"\33\2\2\u0115\u0116\3\2\2\2\u0116\u0117\5\32\16\2\u0117\u0118\7\33\2\2"+
		"\u0118\u0119\3\2\2\2\u0119\u011a\5\32\16\2\u011a\u011b\7\33\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011d\5\34\17\2\u011d\u01e8\3\2\2\2\u011e\u011f\5"+
		"\32\16\2\u011f\u0120\7\33\2\2\u0120\u0122\3\2\2\2\u0121\u011e\3\2\2\2"+
		"\u0121\u0122\3\2\2\2\u0122\u0133\3\2\2\2\u0123\u0124\5\32\16\2\u0124\u0125"+
		"\7\33\2\2\u0125\u0126\3\2\2\2\u0126\u0127\5\32\16\2\u0127\u0128\7\33\2"+
		"\2\u0128\u0133\3\2\2\2\u0129\u012a\5\32\16\2\u012a\u012b\7\33\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\5\32\16\2\u012d\u012e\7\33\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0130\5\32\16\2\u0130\u0131\7\33\2\2\u0131\u0133\3\2\2"+
		"\2\u0132\u0121\3\2\2\2\u0132\u0123\3\2\2\2\u0132\u0129\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\5\32\16\2\u0135\u0132\3\2\2\2\u0135\u0136\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\u0138\7\33\2\2\u0138\u0139\7\33\2\2\u0139\u013a"+
		"\3\2\2\2\u013a\u013b\5\32\16\2\u013b\u013c\7\33\2\2\u013c\u013d\5\34\17"+
		"\2\u013d\u01e8\3\2\2\2\u013e\u013f\5\32\16\2\u013f\u0140\7\33\2\2\u0140"+
		"\u0142\3\2\2\2\u0141\u013e\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u015f\3\2"+
		"\2\2\u0143\u0144\5\32\16\2\u0144\u0145\7\33\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\5\32\16\2\u0147\u0148\7\33\2\2\u0148\u015f\3\2\2\2\u0149\u014a"+
		"\5\32\16\2\u014a\u014b\7\33\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5\32\16"+
		"\2\u014d\u014e\7\33\2\2\u014e\u014f\3\2\2\2\u014f\u0150\5\32\16\2\u0150"+
		"\u0151\7\33\2\2\u0151\u015f\3\2\2\2\u0152\u0153\5\32\16\2\u0153\u0154"+
		"\7\33\2\2\u0154\u0155\3\2\2\2\u0155\u0156\5\32\16\2\u0156\u0157\7\33\2"+
		"\2\u0157\u0158\3\2\2\2\u0158\u0159\5\32\16\2\u0159\u015a\7\33\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\5\32\16\2\u015c\u015d\7\33\2\2\u015d\u015f"+
		"\3\2\2\2\u015e\u0141\3\2\2\2\u015e\u0143\3\2\2\2\u015e\u0149\3\2\2\2\u015e"+
		"\u0152\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\5\32\16\2\u0161\u015e\3"+
		"\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7\33\2\2\u0164"+
		"\u0165\7\33\2\2\u0165\u0166\3\2\2\2\u0166\u01e8\5\34\17\2\u0167\u0168"+
		"\5\32\16\2\u0168\u0169\7\33\2\2\u0169\u016b\3\2\2\2\u016a\u0167\3\2\2"+
		"\2\u016a\u016b\3\2\2\2\u016b\u0197\3\2\2\2\u016c\u016d\5\32\16\2\u016d"+
		"\u016e\7\33\2\2\u016e\u016f\3\2\2\2\u016f\u0170\5\32\16\2\u0170\u0171"+
		"\7\33\2\2\u0171\u0197\3\2\2\2\u0172\u0173\5\32\16\2\u0173\u0174\7\33\2"+
		"\2\u0174\u0175\3\2\2\2\u0175\u0176\5\32\16\2\u0176\u0177\7\33\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0179\5\32\16\2\u0179\u017a\7\33\2\2\u017a\u0197"+
		"\3\2\2\2\u017b\u017c\5\32\16\2\u017c\u017d\7\33\2\2\u017d\u017e\3\2\2"+
		"\2\u017e\u017f\5\32\16\2\u017f\u0180\7\33\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0182\5\32\16\2\u0182\u0183\7\33\2\2\u0183\u0184\3\2\2\2\u0184\u0185"+
		"\5\32\16\2\u0185\u0186\7\33\2\2\u0186\u0197\3\2\2\2\u0187\u0188\5\32\16"+
		"\2\u0188\u0189\7\33\2\2\u0189\u018a\3\2\2\2\u018a\u018b\5\32\16\2\u018b"+
		"\u018c\7\33\2\2\u018c\u018d\3\2\2\2\u018d\u018e\5\32\16\2\u018e\u018f"+
		"\7\33\2\2\u018f\u0190\3\2\2\2\u0190\u0191\5\32\16\2\u0191\u0192\7\33\2"+
		"\2\u0192\u0193\3\2\2\2\u0193\u0194\5\32\16\2\u0194\u0195\7\33\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u016a\3\2\2\2\u0196\u016c\3\2\2\2\u0196\u0172\3\2"+
		"\2\2\u0196\u017b\3\2\2\2\u0196\u0187\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u019a\5\32\16\2\u0199\u0196\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3"+
		"\2\2\2\u019b\u019c\7\33\2\2\u019c\u019d\7\33\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u01e8\5\32\16\2\u019f\u01a0\5\32\16\2\u01a0\u01a1\7\33\2\2\u01a1\u01a3"+
		"\3\2\2\2\u01a2\u019f\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01e1\3\2\2\2\u01a4"+
		"\u01a5\5\32\16\2\u01a5\u01a6\7\33\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8"+
		"\5\32\16\2\u01a8\u01a9\7\33\2\2\u01a9\u01e1\3\2\2\2\u01aa\u01ab\5\32\16"+
		"\2\u01ab\u01ac\7\33\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\5\32\16\2\u01ae"+
		"\u01af\7\33\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\5\32\16\2\u01b1\u01b2"+
		"\7\33\2\2\u01b2\u01e1\3\2\2\2\u01b3\u01b4\5\32\16\2\u01b4\u01b5\7\33\2"+
		"\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\5\32\16\2\u01b7\u01b8\7\33\2\2\u01b8"+
		"\u01b9\3\2\2\2\u01b9\u01ba\5\32\16\2\u01ba\u01bb\7\33\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bc\u01bd\5\32\16\2\u01bd\u01be\7\33\2\2\u01be\u01e1\3\2\2"+
		"\2\u01bf\u01c0\5\32\16\2\u01c0\u01c1\7\33\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\5\32\16\2\u01c3\u01c4\7\33\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6"+
		"\5\32\16\2\u01c6\u01c7\7\33\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\5\32\16"+
		"\2\u01c9\u01ca\7\33\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\5\32\16\2\u01cc"+
		"\u01cd\7\33\2\2\u01cd\u01e1\3\2\2\2\u01ce\u01cf\5\32\16\2\u01cf\u01d0"+
		"\7\33\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\5\32\16\2\u01d2\u01d3\7\33\2"+
		"\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\5\32\16\2\u01d5\u01d6\7\33\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d8\5\32\16\2\u01d8\u01d9\7\33\2\2\u01d9\u01da"+
		"\3\2\2\2\u01da\u01db\5\32\16\2\u01db\u01dc\7\33\2\2\u01dc\u01dd\3\2\2"+
		"\2\u01dd\u01de\5\32\16\2\u01de\u01df\7\33\2\2\u01df\u01e1\3\2\2\2\u01e0"+
		"\u01a2\3\2\2\2\u01e0\u01a4\3\2\2\2\u01e0\u01aa\3\2\2\2\u01e0\u01b3\3\2"+
		"\2\2\u01e0\u01bf\3\2\2\2\u01e0\u01ce\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e4\5\32\16\2\u01e3\u01e0\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3"+
		"\2\2\2\u01e5\u01e6\7\33\2\2\u01e6\u01e8\7\33\2\2\u01e7\u00b1\3\2\2\2\u01e7"+
		"\u00c5\3\2\2\2\u01e7\u00da\3\2\2\2\u01e7\u00f3\3\2\2\2\u01e7\u0111\3\2"+
		"\2\2\u01e7\u0135\3\2\2\2\u01e7\u0161\3\2\2\2\u01e7\u0199\3\2\2\2\u01e7"+
		"\u01e3\3\2\2\2\u01e8\31\3\2\2\2\u01e9\u01f4\5J&\2\u01ea\u01ec\5J&\2\u01eb"+
		"\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f5\3\2\2\2\u01ed\u01ee\5J"+
		"&\2\u01ee\u01ef\5J&\2\u01ef\u01f5\3\2\2\2\u01f0\u01f1\5J&\2\u01f1\u01f2"+
		"\5J&\2\u01f2\u01f3\5J&\2\u01f3\u01f5\3\2\2\2\u01f4\u01eb\3\2\2\2\u01f4"+
		"\u01ed\3\2\2\2\u01f4\u01f0\3\2\2\2\u01f5\33\3\2\2\2\u01f6\u01f7\5\32\16"+
		"\2\u01f7\u01f8\7\33\2\2\u01f8\u01f9\5\32\16\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01fc\5\36\20\2\u01fb\u01f6\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\35\3\2"+
		"\2\2\u01fd\u01fe\5 \21\2\u01fe\u01ff\7\17\2\2\u01ff\u0200\5 \21\2\u0200"+
		"\u0201\7\17\2\2\u0201\u0202\5 \21\2\u0202\u0203\7\17\2\2\u0203\u0204\5"+
		" \21\2\u0204\37\3\2\2\2\u0205\u0214\5H%\2\u0206\u0207\t\3\2\2\u0207\u0214"+
		"\5H%\2\u0208\u0209\7\22\2\2\u0209\u020a\5H%\2\u020a\u020b\5H%\2\u020b"+
		"\u0214\3\2\2\2\u020c\u020d\7\23\2\2\u020d\u020e\t\4\2\2\u020e\u0214\5"+
		"H%\2\u020f\u0210\7\23\2\2\u0210\u0211\7\26\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0214\t\5\2\2\u0213\u0205\3\2\2\2\u0213\u0206\3\2\2\2\u0213\u0208\3\2"+
		"\2\2\u0213\u020c\3\2\2\2\u0213\u020f\3\2\2\2\u0214!\3\2\2\2\u0215\u0219"+
		"\5<\37\2\u0216\u0219\5:\36\2\u0217\u0219\5> \2\u0218\u0215\3\2\2\2\u0218"+
		"\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u0218\3\2"+
		"\2\2\u021a\u021b\3\2\2\2\u021b#\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u021e"+
		"\7\20\2\2\u021e\u0220\5.\30\2\u021f\u021d\3\2\2\2\u0220\u0223\3\2\2\2"+
		"\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222%\3\2\2\2\u0223\u0221\3"+
		"\2\2\2\u0224\u022d\7\20\2\2\u0225\u022a\5\60\31\2\u0226\u0227\7\20\2\2"+
		"\u0227\u0229\5.\30\2\u0228\u0226\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228"+
		"\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022d"+
		"\u0225\3\2\2\2\u022d\u022e\3\2\2\2\u022e\'\3\2\2\2\u022f\u0234\5\62\32"+
		"\2\u0230\u0231\7\20\2\2\u0231\u0233\5.\30\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235)\3\2\2\2"+
		"\u0236\u0234\3\2\2\2\u0237\u023c\5\60\31\2\u0238\u0239\7\20\2\2\u0239"+
		"\u023b\5.\30\2\u023a\u0238\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d+\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0240"+
		"\3\2\2\2\u0240-\3\2\2\2\u0241\u0243\5\64\33\2\u0242\u0241\3\2\2\2\u0243"+
		"\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245/\3\2\2\2"+
		"\u0246\u0244\3\2\2\2\u0247\u0249\5\64\33\2\u0248\u0247\3\2\2\2\u0249\u024a"+
		"\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\61\3\2\2\2\u024c"+
		"\u0251\5<\37\2\u024d\u0251\5:\36\2\u024e\u0251\5> \2\u024f\u0251\7\37"+
		"\2\2\u0250\u024c\3\2\2\2\u0250\u024d\3\2\2\2\u0250\u024e\3\2\2\2\u0250"+
		"\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2"+
		"\2\2\u0253\63\3\2\2\2\u0254\u025a\5<\37\2\u0255\u025a\5:\36\2\u0256\u025a"+
		"\5> \2\u0257\u025a\7\33\2\2\u0258\u025a\7\37\2\2\u0259\u0254\3\2\2\2\u0259"+
		"\u0255\3\2\2\2\u0259\u0256\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u0258\3\2"+
		"\2\2\u025a\65\3\2\2\2\u025b\u025f\5\64\33\2\u025c\u025f\7\20\2\2\u025d"+
		"\u025f\7\36\2\2\u025e\u025b\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025d\3"+
		"\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"\67\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0267\5\64\33\2\u0264\u0267\7\20"+
		"\2\2\u0265\u0267\7\36\2\2\u0266\u0263\3\2\2\2\u0266\u0264\3\2\2\2\u0266"+
		"\u0265\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2"+
		"\2\2\u02699\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u026c\7\6\2\2\u026c\u026d"+
		"\5J&\2\u026d\u026e\5J&\2\u026e;\3\2\2\2\u026f\u0276\5F$\2\u0270\u0276"+
		"\5H%\2\u0271\u0276\7\16\2\2\u0272\u0276\7\17\2\2\u0273\u0276\7<\2\2\u0274"+
		"\u0276\7W\2\2\u0275\u026f\3\2\2\2\u0275\u0270\3\2\2\2\u0275\u0271\3\2"+
		"\2\2\u0275\u0272\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0274\3\2\2\2\u0276"+
		"=\3\2\2\2\u0277\u0278\t\6\2\2\u0278?\3\2\2\2\u0279\u027d\7:\2\2\u027a"+
		"\u027e\5\30\r\2\u027b\u027e\5D#\2\u027c\u027e\5\26\f\2\u027d\u027a\3\2"+
		"\2\2\u027d\u027b\3\2\2\2\u027d\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0280\7;\2\2\u0280A\3\2\2\2\u0281\u0284\5<\37\2\u0282\u0284\5:\36\2\u0283"+
		"\u0281\3\2\2\2\u0283\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0283\3\2"+
		"\2\2\u0285\u0286\3\2\2\2\u0286C\3\2\2\2\u0287\u0288\5\30\r\2\u0288\u0289"+
		"\7\6\2\2\u0289\u028a\7\23\2\2\u028a\u028b\7\26\2\2\u028b\u028c\3\2\2\2"+
		"\u028c\u028d\5B\"\2\u028dE\3\2\2\2\u028e\u0291\t\7\2\2\u028f\u0291\t\b"+
		"\2\2\u0290\u028e\3\2\2\2\u0290\u028f\3\2\2\2\u0291G\3\2\2\2\u0292\u0293"+
		"\t\t\2\2\u0293I\3\2\2\2\u0294\u029c\5H%\2\u0295\u029c\t\n\2\2\u0296\u029c"+
		"\t\13\2\2\u0297\u029c\t\f\2\2\u0298\u029c\t\r\2\2\u0299\u029c\t\16\2\2"+
		"\u029a\u029c\t\17\2\2\u029b\u0294\3\2\2\2\u029b\u0295\3\2\2\2\u029b\u0296"+
		"\3\2\2\2\u029b\u0297\3\2\2\2\u029b\u0298\3\2\2\2\u029b\u0299\3\2\2\2\u029b"+
		"\u029a\3\2\2\2\u029cK\3\2\2\2AQU`dimx\u0080\u0082\u0088\u008d\u0093\u0095"+
		"\u009b\u00a0\u00a7\u00ad\u00af\u00da\u00f0\u00f3\u0106\u010e\u0111\u0121"+
		"\u0132\u0135\u0141\u015e\u0161\u016a\u0196\u0199\u01a2\u01e0\u01e3\u01e7"+
		"\u01eb\u01f4\u01fb\u0213\u0218\u021a\u0221\u022a\u022d\u0234\u023c\u0244"+
		"\u024a\u0250\u0252\u0259\u025e\u0260\u0266\u0268\u0275\u027d\u0283\u0285"+
		"\u0290\u029b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}