// Generated from src/main/grammar/RFC_3986_6874.g4 by ANTLR 4.7.1
package org.timmc.johnny.gen.parse;
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
		RULE_uri = 0, RULE_hier_part = 1, RULE_scheme = 2, RULE_authority = 3, 
		RULE_userinfo = 4, RULE_host = 5, RULE_port = 6, RULE_ipvfuture = 7, RULE_ipv6address = 8, 
		RULE_h16 = 9, RULE_ls32 = 10, RULE_ipv4address = 11, RULE_dec_octet = 12, 
		RULE_reg_name = 13, RULE_path_abempty = 14, RULE_path_absolute = 15, RULE_path_rootless = 16, 
		RULE_path_empty = 17, RULE_segment = 18, RULE_segment_nz = 19, RULE_pchar = 20, 
		RULE_query = 21, RULE_fragment_1 = 22, RULE_pct_encoded = 23, RULE_unreserved = 24, 
		RULE_sub_delims = 25, RULE_ip_literal = 26, RULE_zoneid = 27, RULE_ipv6addrz = 28, 
		RULE_alpha = 29, RULE_digit = 30, RULE_hexdig = 31;
	public static final String[] ruleNames = {
		"uri", "hier_part", "scheme", "authority", "userinfo", "host", "port", 
		"ipvfuture", "ipv6address", "h16", "ls32", "ipv4address", "dec_octet", 
		"reg_name", "path_abempty", "path_absolute", "path_rootless", "path_empty", 
		"segment", "segment_nz", "pchar", "query", "fragment_1", "pct_encoded", 
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
			setState(64);
			scheme();
			setState(65);
			match(COLON);
			setState(66);
			hier_part();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(67);
				match(QUESTION);
				setState(68);
				query();
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POUND) {
				{
				setState(71);
				match(POUND);
				setState(72);
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
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(75);
				match(SLASH);
				setState(76);
				match(SLASH);
				}
				setState(78);
				authority();
				setState(79);
				path_abempty();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				path_absolute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				path_rootless();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
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
		enterRule(_localctx, 4, RULE_scheme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			alpha();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)))) != 0)) {
				{
				setState(92);
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
					setState(87);
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
					setState(88);
					digit();
					}
					break;
				case PLUS:
					{
					setState(89);
					match(PLUS);
					}
					break;
				case DASH:
					{
					setState(90);
					match(DASH);
					}
					break;
				case PERIOD:
					{
					setState(91);
					match(PERIOD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(96);
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
		enterRule(_localctx, 6, RULE_authority);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(97);
				userinfo();
				setState(98);
				match(AT);
				}
				break;
			}
			setState(102);
			host();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(103);
				match(COLON);
				setState(104);
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
		enterRule(_localctx, 8, RULE_userinfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(111);
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
					setState(107);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(108);
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
					setState(109);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(110);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(115);
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
		enterRule(_localctx, 10, RULE_host);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				ip_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				ipv4address();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
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
		enterRule(_localctx, 12, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) {
				{
				{
				setState(121);
				digit();
				}
				}
				setState(126);
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
		enterRule(_localctx, 14, RULE_ipvfuture);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==CAP_V || _la==V) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				hexdig();
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0) );
			setState(133);
			match(PERIOD);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(137);
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
					setState(134);
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
					setState(135);
					sub_delims();
					}
					break;
				case COLON:
					{
					setState(136);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(139); 
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
		enterRule(_localctx, 16, RULE_ipv6address);
		int _la;
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(141);
				h16();
				setState(142);
				match(COLON);
				}
				{
				setState(144);
				h16();
				setState(145);
				match(COLON);
				}
				{
				setState(147);
				h16();
				setState(148);
				match(COLON);
				}
				{
				setState(150);
				h16();
				setState(151);
				match(COLON);
				}
				{
				setState(153);
				h16();
				setState(154);
				match(COLON);
				}
				{
				setState(156);
				h16();
				setState(157);
				match(COLON);
				}
				setState(159);
				ls32();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				{
				setState(161);
				match(COLON);
				setState(162);
				match(COLON);
				}
				{
				setState(164);
				h16();
				setState(165);
				match(COLON);
				}
				{
				setState(167);
				h16();
				setState(168);
				match(COLON);
				}
				{
				setState(170);
				h16();
				setState(171);
				match(COLON);
				}
				{
				setState(173);
				h16();
				setState(174);
				match(COLON);
				}
				{
				setState(176);
				h16();
				setState(177);
				match(COLON);
				}
				setState(179);
				ls32();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(181);
					h16();
					}
				}

				{
				setState(184);
				match(COLON);
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
				{
				setState(193);
				h16();
				setState(194);
				match(COLON);
				}
				{
				setState(196);
				h16();
				setState(197);
				match(COLON);
				}
				setState(199);
				ls32();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					{
					setState(204);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(201);
						h16();
						setState(202);
						match(COLON);
						}
						break;
					}
					}
					setState(206);
					h16();
					}
				}

				{
				setState(209);
				match(COLON);
				setState(210);
				match(COLON);
				}
				{
				setState(212);
				h16();
				setState(213);
				match(COLON);
				}
				{
				setState(215);
				h16();
				setState(216);
				match(COLON);
				}
				{
				setState(218);
				h16();
				setState(219);
				match(COLON);
				}
				setState(221);
				ls32();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(234);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(226);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
						case 1:
							{
							setState(223);
							h16();
							setState(224);
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
						}
						}
						break;
					}
					setState(236);
					h16();
					}
				}

				{
				setState(239);
				match(COLON);
				setState(240);
				match(COLON);
				}
				{
				setState(242);
				h16();
				setState(243);
				match(COLON);
				}
				{
				setState(245);
				h16();
				setState(246);
				match(COLON);
				}
				setState(248);
				ls32();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						setState(253);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(250);
							h16();
							setState(251);
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
						setState(255);
						h16();
						setState(256);
						match(COLON);
						}
						{
						setState(258);
						h16();
						setState(259);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(261);
						h16();
						setState(262);
						match(COLON);
						}
						{
						setState(264);
						h16();
						setState(265);
						match(COLON);
						}
						{
						setState(267);
						h16();
						setState(268);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(272);
					h16();
					}
				}

				{
				setState(275);
				match(COLON);
				setState(276);
				match(COLON);
				}
				setState(278);
				h16();
				setState(279);
				match(COLON);
				setState(280);
				ls32();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(314);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(285);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
						case 1:
							{
							setState(282);
							h16();
							setState(283);
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
						setState(287);
						h16();
						setState(288);
						match(COLON);
						}
						{
						setState(290);
						h16();
						setState(291);
						match(COLON);
						}
						}
						}
						break;
					case 3:
						{
						{
						{
						setState(293);
						h16();
						setState(294);
						match(COLON);
						}
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
					case 4:
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
						{
						setState(311);
						h16();
						setState(312);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(316);
					h16();
					}
				}

				{
				setState(319);
				match(COLON);
				setState(320);
				match(COLON);
				}
				setState(322);
				ls32();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(370);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(326);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
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
					case 5:
						{
						{
						{
						setState(355);
						h16();
						setState(356);
						match(COLON);
						}
						{
						setState(358);
						h16();
						setState(359);
						match(COLON);
						}
						{
						setState(361);
						h16();
						setState(362);
						match(COLON);
						}
						{
						setState(364);
						h16();
						setState(365);
						match(COLON);
						}
						{
						setState(367);
						h16();
						setState(368);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(372);
					h16();
					}
				}

				{
				setState(375);
				match(COLON);
				setState(376);
				match(COLON);
				}
				setState(378);
				h16();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(444);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(382);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
						case 1:
							{
							setState(379);
							h16();
							setState(380);
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
						}
						}
						break;
					case 3:
						{
						{
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
						{
						setState(396);
						h16();
						setState(397);
						match(COLON);
						}
						}
						}
						break;
					case 4:
						{
						{
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
					case 5:
						{
						{
						{
						setState(411);
						h16();
						setState(412);
						match(COLON);
						}
						{
						setState(414);
						h16();
						setState(415);
						match(COLON);
						}
						{
						setState(417);
						h16();
						setState(418);
						match(COLON);
						}
						{
						setState(420);
						h16();
						setState(421);
						match(COLON);
						}
						{
						setState(423);
						h16();
						setState(424);
						match(COLON);
						}
						}
						}
						break;
					case 6:
						{
						{
						{
						setState(426);
						h16();
						setState(427);
						match(COLON);
						}
						{
						setState(429);
						h16();
						setState(430);
						match(COLON);
						}
						{
						setState(432);
						h16();
						setState(433);
						match(COLON);
						}
						{
						setState(435);
						h16();
						setState(436);
						match(COLON);
						}
						{
						setState(438);
						h16();
						setState(439);
						match(COLON);
						}
						{
						setState(441);
						h16();
						setState(442);
						match(COLON);
						}
						}
						}
						break;
					}
					setState(446);
					h16();
					}
				}

				{
				setState(449);
				match(COLON);
				setState(450);
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
		enterRule(_localctx, 18, RULE_h16);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			hexdig();
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (ZERO - 15)) | (1L << (ONE - 15)) | (1L << (TWO - 15)) | (1L << (THREE - 15)) | (1L << (FOUR - 15)) | (1L << (FIVE - 15)) | (1L << (SIX - 15)) | (1L << (SEVEN - 15)) | (1L << (EIGHT - 15)) | (1L << (NINE - 15)) | (1L << (CAP_A - 15)) | (1L << (CAP_B - 15)) | (1L << (CAP_C - 15)) | (1L << (CAP_D - 15)) | (1L << (CAP_E - 15)) | (1L << (CAP_F - 15)) | (1L << (A - 15)) | (1L << (B - 15)) | (1L << (C - 15)) | (1L << (D - 15)) | (1L << (E - 15)) | (1L << (F - 15)))) != 0)) {
					{
					setState(454);
					hexdig();
					}
				}

				}
				break;
			case 2:
				{
				{
				setState(457);
				hexdig();
				setState(458);
				hexdig();
				}
				}
				break;
			case 3:
				{
				{
				setState(460);
				hexdig();
				setState(461);
				hexdig();
				setState(462);
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
		enterRule(_localctx, 20, RULE_ls32);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(466);
				h16();
				setState(467);
				match(COLON);
				setState(468);
				h16();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
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
		enterRule(_localctx, 22, RULE_ipv4address);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			dec_octet();
			setState(474);
			match(PERIOD);
			setState(475);
			dec_octet();
			setState(476);
			match(PERIOD);
			setState(477);
			dec_octet();
			setState(478);
			match(PERIOD);
			setState(479);
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
		enterRule(_localctx, 24, RULE_dec_octet);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				digit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(482);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(483);
				digit();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(484);
				match(ONE);
				setState(485);
				digit();
				setState(486);
				digit();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(488);
				match(TWO);
				setState(489);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(490);
				digit();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				{
				setState(491);
				match(TWO);
				setState(492);
				match(FIVE);
				}
				setState(494);
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
		enterRule(_localctx, 26, RULE_reg_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(500);
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
					setState(497);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(498);
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
					setState(499);
					sub_delims();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(504);
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
		enterRule(_localctx, 28, RULE_path_abempty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(505);
				match(SLASH);
				setState(506);
				segment();
				}
				}
				setState(511);
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
		enterRule(_localctx, 30, RULE_path_absolute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			match(SLASH);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(513);
				segment_nz();
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SLASH) {
					{
					{
					setState(514);
					match(SLASH);
					setState(515);
					segment();
					}
					}
					setState(520);
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
		enterRule(_localctx, 32, RULE_path_rootless);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			segment_nz();
			setState(528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(524);
				match(SLASH);
				setState(525);
				segment();
				}
				}
				setState(530);
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
		enterRule(_localctx, 34, RULE_path_empty);
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
		enterRule(_localctx, 36, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				{
				setState(533);
				pchar();
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
		enterRule(_localctx, 38, RULE_segment_nz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(539);
				pchar();
				}
				}
				setState(542); 
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
		enterRule(_localctx, 40, RULE_pchar);
		try {
			setState(549);
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
				setState(544);
				unreserved();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
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
				setState(546);
				sub_delims();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(547);
				match(COLON);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(548);
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
		enterRule(_localctx, 42, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(554);
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
					setState(551);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(552);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(553);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(558);
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
		enterRule(_localctx, 44, RULE_fragment_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXCLAMATION) | (1L << DOLLAR) | (1L << PERCENT) | (1L << AMPERSAND) | (1L << APOSTROPHE) | (1L << LEFT_PAREN) | (1L << RIGHT_PAREN) | (1L << ASTERISK) | (1L << PLUS) | (1L << COMMA) | (1L << DASH) | (1L << PERIOD) | (1L << SLASH) | (1L << ZERO) | (1L << ONE) | (1L << TWO) | (1L << THREE) | (1L << FOUR) | (1L << FIVE) | (1L << SIX) | (1L << SEVEN) | (1L << EIGHT) | (1L << NINE) | (1L << COLON) | (1L << SEMICOLON) | (1L << EQUALS) | (1L << QUESTION) | (1L << AT) | (1L << CAP_A) | (1L << CAP_B) | (1L << CAP_C) | (1L << CAP_D) | (1L << CAP_E) | (1L << CAP_F) | (1L << CAP_G) | (1L << CAP_H) | (1L << CAP_I) | (1L << CAP_J) | (1L << CAP_K) | (1L << CAP_L) | (1L << CAP_M) | (1L << CAP_N) | (1L << CAP_O) | (1L << CAP_P) | (1L << CAP_Q) | (1L << CAP_R) | (1L << CAP_S) | (1L << CAP_T) | (1L << CAP_U) | (1L << CAP_V) | (1L << CAP_W) | (1L << CAP_X) | (1L << CAP_Y) | (1L << CAP_Z) | (1L << UNDERSCORE) | (1L << A) | (1L << B) | (1L << C) | (1L << D) | (1L << E))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F - 64)) | (1L << (G - 64)) | (1L << (H - 64)) | (1L << (I - 64)) | (1L << (J - 64)) | (1L << (K - 64)) | (1L << (L - 64)) | (1L << (M - 64)) | (1L << (N - 64)) | (1L << (O - 64)) | (1L << (P - 64)) | (1L << (Q - 64)) | (1L << (R - 64)) | (1L << (S - 64)) | (1L << (T - 64)) | (1L << (U - 64)) | (1L << (V - 64)) | (1L << (W - 64)) | (1L << (X - 64)) | (1L << (Y - 64)) | (1L << (Z - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(562);
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
					setState(559);
					pchar();
					}
					break;
				case SLASH:
					{
					setState(560);
					match(SLASH);
					}
					break;
				case QUESTION:
					{
					setState(561);
					match(QUESTION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(566);
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
		enterRule(_localctx, 46, RULE_pct_encoded);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			match(PERCENT);
			setState(568);
			hexdig();
			setState(569);
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
		enterRule(_localctx, 48, RULE_unreserved);
		try {
			setState(577);
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
				setState(571);
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
				setState(572);
				digit();
				}
				break;
			case DASH:
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				match(DASH);
				}
				break;
			case PERIOD:
				enterOuterAlt(_localctx, 4);
				{
				setState(574);
				match(PERIOD);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
				match(UNDERSCORE);
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 6);
				{
				setState(576);
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
		enterRule(_localctx, 50, RULE_sub_delims);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
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
		enterRule(_localctx, 52, RULE_ip_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			match(LEFT_BRACE);
			setState(585);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(582);
				ipv6address();
				}
				break;
			case 2:
				{
				setState(583);
				ipv6addrz();
				}
				break;
			case 3:
				{
				setState(584);
				ipvfuture();
				}
				break;
			}
			setState(587);
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
		enterRule(_localctx, 54, RULE_zoneid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(591);
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
					setState(589);
					unreserved();
					}
					break;
				case PERCENT:
					{
					setState(590);
					pct_encoded();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(593); 
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
		enterRule(_localctx, 56, RULE_ipv6addrz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			ipv6address();
			{
			setState(596);
			match(PERCENT);
			setState(597);
			match(TWO);
			setState(598);
			match(FIVE);
			}
			setState(600);
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
		enterRule(_localctx, 58, RULE_alpha);
		int _la;
		try {
			setState(604);
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
				setState(602);
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
				setState(603);
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
		enterRule(_localctx, 60, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
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
		enterRule(_localctx, 62, RULE_hexdig);
		int _la;
		try {
			setState(615);
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
				setState(608);
				digit();
				}
				break;
			case CAP_A:
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
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
				setState(610);
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
				setState(611);
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
				setState(612);
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
				setState(613);
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
				setState(614);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u026c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\5\2H\n\2\3\2\3\2\5\2L\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4_\n\4\f\4\16\4b\13"+
		"\4\3\5\3\5\3\5\5\5g\n\5\3\5\3\5\3\5\5\5l\n\5\3\6\3\6\3\6\3\6\7\6r\n\6"+
		"\f\6\16\6u\13\6\3\7\3\7\3\7\5\7z\n\7\3\b\7\b}\n\b\f\b\16\b\u0080\13\b"+
		"\3\t\3\t\6\t\u0084\n\t\r\t\16\t\u0085\3\t\3\t\3\t\3\t\6\t\u008c\n\t\r"+
		"\t\16\t\u008d\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b9\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00cf"+
		"\n\n\3\n\5\n\u00d2\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00e5\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ed\n"+
		"\n\3\n\5\n\u00f0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0100\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u0111\n\n\3\n\5\n\u0114\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0120\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u013d"+
		"\n\n\3\n\5\n\u0140\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0149\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u0175\n\n\3\n\5\n\u0178\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0181\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01bf\n\n"+
		"\3\n\5\n\u01c2\n\n\3\n\3\n\5\n\u01c6\n\n\3\13\3\13\5\13\u01ca\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u01d3\n\13\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u01da\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u01f2\n\16\3\17\3\17"+
		"\3\17\7\17\u01f7\n\17\f\17\16\17\u01fa\13\17\3\20\3\20\7\20\u01fe\n\20"+
		"\f\20\16\20\u0201\13\20\3\21\3\21\3\21\3\21\7\21\u0207\n\21\f\21\16\21"+
		"\u020a\13\21\5\21\u020c\n\21\3\22\3\22\3\22\7\22\u0211\n\22\f\22\16\22"+
		"\u0214\13\22\3\23\3\23\3\24\7\24\u0219\n\24\f\24\16\24\u021c\13\24\3\25"+
		"\6\25\u021f\n\25\r\25\16\25\u0220\3\26\3\26\3\26\3\26\3\26\5\26\u0228"+
		"\n\26\3\27\3\27\3\27\7\27\u022d\n\27\f\27\16\27\u0230\13\27\3\30\3\30"+
		"\3\30\7\30\u0235\n\30\f\30\16\30\u0238\13\30\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u0244\n\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\5\34\u024c\n\34\3\34\3\34\3\35\3\35\6\35\u0252\n\35\r\35\16\35\u0253"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\5\37\u025f\n\37\3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u026a\n!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\20\4\2\65\65RR\3\2\22\32\3\2\21"+
		"\25\3\2\21\26\6\2\3\3\5\5\7\r\34\35\3\2 9\3\2=V\3\2\21\32\4\2  ==\4\2"+
		"!!>>\4\2\"\"??\4\2##@@\4\2$$AA\4\2%%BB\2\u02b1\2B\3\2\2\2\4V\3\2\2\2\6"+
		"X\3\2\2\2\bf\3\2\2\2\ns\3\2\2\2\fy\3\2\2\2\16~\3\2\2\2\20\u0081\3\2\2"+
		"\2\22\u01c5\3\2\2\2\24\u01c7\3\2\2\2\26\u01d9\3\2\2\2\30\u01db\3\2\2\2"+
		"\32\u01f1\3\2\2\2\34\u01f8\3\2\2\2\36\u01ff\3\2\2\2 \u0202\3\2\2\2\"\u020d"+
		"\3\2\2\2$\u0215\3\2\2\2&\u021a\3\2\2\2(\u021e\3\2\2\2*\u0227\3\2\2\2,"+
		"\u022e\3\2\2\2.\u0236\3\2\2\2\60\u0239\3\2\2\2\62\u0243\3\2\2\2\64\u0245"+
		"\3\2\2\2\66\u0247\3\2\2\28\u0251\3\2\2\2:\u0255\3\2\2\2<\u025e\3\2\2\2"+
		">\u0260\3\2\2\2@\u0269\3\2\2\2BC\5\6\4\2CD\7\33\2\2DG\5\4\3\2EF\7\36\2"+
		"\2FH\5,\27\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IJ\7\4\2\2JL\5.\30\2KI\3\2\2"+
		"\2KL\3\2\2\2L\3\3\2\2\2MN\7\20\2\2NO\7\20\2\2OP\3\2\2\2PQ\5\b\5\2QR\5"+
		"\36\20\2RW\3\2\2\2SW\5 \21\2TW\5\"\22\2UW\5$\23\2VM\3\2\2\2VS\3\2\2\2"+
		"VT\3\2\2\2VU\3\2\2\2W\5\3\2\2\2X`\5<\37\2Y_\5<\37\2Z_\5> \2[_\7\f\2\2"+
		"\\_\7\16\2\2]_\7\17\2\2^Y\3\2\2\2^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2"+
		"\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\7\3\2\2\2b`\3\2\2\2cd\5\n\6\2de\7"+
		"\37\2\2eg\3\2\2\2fc\3\2\2\2fg\3\2\2\2gh\3\2\2\2hk\5\f\7\2ij\7\33\2\2j"+
		"l\5\16\b\2ki\3\2\2\2kl\3\2\2\2l\t\3\2\2\2mr\5\62\32\2nr\5\60\31\2or\5"+
		"\64\33\2pr\7\33\2\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2ru\3\2\2\2"+
		"sq\3\2\2\2st\3\2\2\2t\13\3\2\2\2us\3\2\2\2vz\5\66\34\2wz\5\30\r\2xz\5"+
		"\34\17\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\r\3\2\2\2{}\5> \2|{\3\2\2\2}\u0080"+
		"\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\17\3\2\2\2\u0080~\3\2\2\2\u0081\u0083"+
		"\t\2\2\2\u0082\u0084\5@!\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008b\7\17"+
		"\2\2\u0088\u008c\5\62\32\2\u0089\u008c\5\64\33\2\u008a\u008c\7\33\2\2"+
		"\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\21\3\2\2\2\u008f"+
		"\u0090\5\24\13\2\u0090\u0091\7\33\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\5\24\13\2\u0093\u0094\7\33\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\24\13"+
		"\2\u0096\u0097\7\33\2\2\u0097\u0098\3\2\2\2\u0098\u0099\5\24\13\2\u0099"+
		"\u009a\7\33\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5\24\13\2\u009c\u009d"+
		"\7\33\2\2\u009d\u009e\3\2\2\2\u009e\u009f\5\24\13\2\u009f\u00a0\7\33\2"+
		"\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\5\26\f\2\u00a2\u01c6\3\2\2\2\u00a3"+
		"\u00a4\7\33\2\2\u00a4\u00a5\7\33\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\5"+
		"\24\13\2\u00a7\u00a8\7\33\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\5\24\13"+
		"\2\u00aa\u00ab\7\33\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\5\24\13\2\u00ad"+
		"\u00ae\7\33\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\5\24\13\2\u00b0\u00b1"+
		"\7\33\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\5\24\13\2\u00b3\u00b4\7\33\2"+
		"\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\5\26\f\2\u00b6\u01c6\3\2\2\2\u00b7"+
		"\u00b9\5\24\13\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3"+
		"\2\2\2\u00ba\u00bb\7\33\2\2\u00bb\u00bc\7\33\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\5\24\13\2\u00be\u00bf\7\33\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1"+
		"\5\24\13\2\u00c1\u00c2\7\33\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\5\24\13"+
		"\2\u00c4\u00c5\7\33\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\5\24\13\2\u00c7"+
		"\u00c8\7\33\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\5\26\f\2\u00ca\u01c6\3"+
		"\2\2\2\u00cb\u00cc\5\24\13\2\u00cc\u00cd\7\33\2\2\u00cd\u00cf\3\2\2\2"+
		"\u00ce\u00cb\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2"+
		"\5\24\13\2\u00d1\u00ce\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00d4\7\33\2\2\u00d4\u00d5\7\33\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7"+
		"\5\24\13\2\u00d7\u00d8\7\33\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\5\24\13"+
		"\2\u00da\u00db\7\33\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\5\24\13\2\u00dd"+
		"\u00de\7\33\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5\26\f\2\u00e0\u01c6\3"+
		"\2\2\2\u00e1\u00e2\5\24\13\2\u00e2\u00e3\7\33\2\2\u00e3\u00e5\3\2\2\2"+
		"\u00e4\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00ed\3\2\2\2\u00e6\u00e7"+
		"\5\24\13\2\u00e7\u00e8\7\33\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\5\24\13"+
		"\2\u00ea\u00eb\7\33\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec"+
		"\u00e6\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\5\24\13\2\u00ef\u00ec\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7\33\2\2\u00f2"+
		"\u00f3\7\33\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\5\24\13\2\u00f5\u00f6"+
		"\7\33\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\5\24\13\2\u00f8\u00f9\7\33\2"+
		"\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\5\26\f\2\u00fb\u01c6\3\2\2\2\u00fc"+
		"\u00fd\5\24\13\2\u00fd\u00fe\7\33\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fc"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0111\3\2\2\2\u0101\u0102\5\24\13\2"+
		"\u0102\u0103\7\33\2\2\u0103\u0104\3\2\2\2\u0104\u0105\5\24\13\2\u0105"+
		"\u0106\7\33\2\2\u0106\u0111\3\2\2\2\u0107\u0108\5\24\13\2\u0108\u0109"+
		"\7\33\2\2\u0109\u010a\3\2\2\2\u010a\u010b\5\24\13\2\u010b\u010c\7\33\2"+
		"\2\u010c\u010d\3\2\2\2\u010d\u010e\5\24\13\2\u010e\u010f\7\33\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u00ff\3\2\2\2\u0110\u0101\3\2\2\2\u0110\u0107\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0114\5\24\13\2\u0113\u0110\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7\33\2\2\u0116\u0117\7"+
		"\33\2\2\u0117\u0118\3\2\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\33\2\2"+
		"\u011a\u011b\5\26\f\2\u011b\u01c6\3\2\2\2\u011c\u011d\5\24\13\2\u011d"+
		"\u011e\7\33\2\2\u011e\u0120\3\2\2\2\u011f\u011c\3\2\2\2\u011f\u0120\3"+
		"\2\2\2\u0120\u013d\3\2\2\2\u0121\u0122\5\24\13\2\u0122\u0123\7\33\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0125\5\24\13\2\u0125\u0126\7\33\2\2\u0126"+
		"\u013d\3\2\2\2\u0127\u0128\5\24\13\2\u0128\u0129\7\33\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012b\5\24\13\2\u012b\u012c\7\33\2\2\u012c\u012d\3\2\2"+
		"\2\u012d\u012e\5\24\13\2\u012e\u012f\7\33\2\2\u012f\u013d\3\2\2\2\u0130"+
		"\u0131\5\24\13\2\u0131\u0132\7\33\2\2\u0132\u0133\3\2\2\2\u0133\u0134"+
		"\5\24\13\2\u0134\u0135\7\33\2\2\u0135\u0136\3\2\2\2\u0136\u0137\5\24\13"+
		"\2\u0137\u0138\7\33\2\2\u0138\u0139\3\2\2\2\u0139\u013a\5\24\13\2\u013a"+
		"\u013b\7\33\2\2\u013b\u013d\3\2\2\2\u013c\u011f\3\2\2\2\u013c\u0121\3"+
		"\2\2\2\u013c\u0127\3\2\2\2\u013c\u0130\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\5\24\13\2\u013f\u013c\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3"+
		"\2\2\2\u0141\u0142\7\33\2\2\u0142\u0143\7\33\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u01c6\5\26\f\2\u0145\u0146\5\24\13\2\u0146\u0147\7\33\2\2\u0147\u0149"+
		"\3\2\2\2\u0148\u0145\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0175\3\2\2\2\u014a"+
		"\u014b\5\24\13\2\u014b\u014c\7\33\2\2\u014c\u014d\3\2\2\2\u014d\u014e"+
		"\5\24\13\2\u014e\u014f\7\33\2\2\u014f\u0175\3\2\2\2\u0150\u0151\5\24\13"+
		"\2\u0151\u0152\7\33\2\2\u0152\u0153\3\2\2\2\u0153\u0154\5\24\13\2\u0154"+
		"\u0155\7\33\2\2\u0155\u0156\3\2\2\2\u0156\u0157\5\24\13\2\u0157\u0158"+
		"\7\33\2\2\u0158\u0175\3\2\2\2\u0159\u015a\5\24\13\2\u015a\u015b\7\33\2"+
		"\2\u015b\u015c\3\2\2\2\u015c\u015d\5\24\13\2\u015d\u015e\7\33\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0160\5\24\13\2\u0160\u0161\7\33\2\2\u0161\u0162"+
		"\3\2\2\2\u0162\u0163\5\24\13\2\u0163\u0164\7\33\2\2\u0164\u0175\3\2\2"+
		"\2\u0165\u0166\5\24\13\2\u0166\u0167\7\33\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u0169\5\24\13\2\u0169\u016a\7\33\2\2\u016a\u016b\3\2\2\2\u016b\u016c"+
		"\5\24\13\2\u016c\u016d\7\33\2\2\u016d\u016e\3\2\2\2\u016e\u016f\5\24\13"+
		"\2\u016f\u0170\7\33\2\2\u0170\u0171\3\2\2\2\u0171\u0172\5\24\13\2\u0172"+
		"\u0173\7\33\2\2\u0173\u0175\3\2\2\2\u0174\u0148\3\2\2\2\u0174\u014a\3"+
		"\2\2\2\u0174\u0150\3\2\2\2\u0174\u0159\3\2\2\2\u0174\u0165\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u0178\5\24\13\2\u0177\u0174\3\2\2\2\u0177\u0178\3"+
		"\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\7\33\2\2\u017a\u017b\7\33\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u01c6\5\24\13\2\u017d\u017e\5\24\13\2\u017e\u017f"+
		"\7\33\2\2\u017f\u0181\3\2\2\2\u0180\u017d\3\2\2\2\u0180\u0181\3\2\2\2"+
		"\u0181\u01bf\3\2\2\2\u0182\u0183\5\24\13\2\u0183\u0184\7\33\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\5\24\13\2\u0186\u0187\7\33\2\2\u0187\u01bf"+
		"\3\2\2\2\u0188\u0189\5\24\13\2\u0189\u018a\7\33\2\2\u018a\u018b\3\2\2"+
		"\2\u018b\u018c\5\24\13\2\u018c\u018d\7\33\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u018f\5\24\13\2\u018f\u0190\7\33\2\2\u0190\u01bf\3\2\2\2\u0191\u0192"+
		"\5\24\13\2\u0192\u0193\7\33\2\2\u0193\u0194\3\2\2\2\u0194\u0195\5\24\13"+
		"\2\u0195\u0196\7\33\2\2\u0196\u0197\3\2\2\2\u0197\u0198\5\24\13\2\u0198"+
		"\u0199\7\33\2\2\u0199\u019a\3\2\2\2\u019a\u019b\5\24\13\2\u019b\u019c"+
		"\7\33\2\2\u019c\u01bf\3\2\2\2\u019d\u019e\5\24\13\2\u019e\u019f\7\33\2"+
		"\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\5\24\13\2\u01a1\u01a2\7\33\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a4\5\24\13\2\u01a4\u01a5\7\33\2\2\u01a5\u01a6"+
		"\3\2\2\2\u01a6\u01a7\5\24\13\2\u01a7\u01a8\7\33\2\2\u01a8\u01a9\3\2\2"+
		"\2\u01a9\u01aa\5\24\13\2\u01aa\u01ab\7\33\2\2\u01ab\u01bf\3\2\2\2\u01ac"+
		"\u01ad\5\24\13\2\u01ad\u01ae\7\33\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0"+
		"\5\24\13\2\u01b0\u01b1\7\33\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\5\24\13"+
		"\2\u01b3\u01b4\7\33\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\5\24\13\2\u01b6"+
		"\u01b7\7\33\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\5\24\13\2\u01b9\u01ba"+
		"\7\33\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\5\24\13\2\u01bc\u01bd\7\33\2"+
		"\2\u01bd\u01bf\3\2\2\2\u01be\u0180\3\2\2\2\u01be\u0182\3\2\2\2\u01be\u0188"+
		"\3\2\2\2\u01be\u0191\3\2\2\2\u01be\u019d\3\2\2\2\u01be\u01ac\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c2\5\24\13\2\u01c1\u01be\3\2\2\2\u01c1\u01c2\3"+
		"\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\7\33\2\2\u01c4\u01c6\7\33\2\2\u01c5"+
		"\u008f\3\2\2\2\u01c5\u00a3\3\2\2\2\u01c5\u00b8\3\2\2\2\u01c5\u00d1\3\2"+
		"\2\2\u01c5\u00ef\3\2\2\2\u01c5\u0113\3\2\2\2\u01c5\u013f\3\2\2\2\u01c5"+
		"\u0177\3\2\2\2\u01c5\u01c1\3\2\2\2\u01c6\23\3\2\2\2\u01c7\u01d2\5@!\2"+
		"\u01c8\u01ca\5@!\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01d3"+
		"\3\2\2\2\u01cb\u01cc\5@!\2\u01cc\u01cd\5@!\2\u01cd\u01d3\3\2\2\2\u01ce"+
		"\u01cf\5@!\2\u01cf\u01d0\5@!\2\u01d0\u01d1\5@!\2\u01d1\u01d3\3\2\2\2\u01d2"+
		"\u01c9\3\2\2\2\u01d2\u01cb\3\2\2\2\u01d2\u01ce\3\2\2\2\u01d3\25\3\2\2"+
		"\2\u01d4\u01d5\5\24\13\2\u01d5\u01d6\7\33\2\2\u01d6\u01d7\5\24\13\2\u01d7"+
		"\u01da\3\2\2\2\u01d8\u01da\5\30\r\2\u01d9\u01d4\3\2\2\2\u01d9\u01d8\3"+
		"\2\2\2\u01da\27\3\2\2\2\u01db\u01dc\5\32\16\2\u01dc\u01dd\7\17\2\2\u01dd"+
		"\u01de\5\32\16\2\u01de\u01df\7\17\2\2\u01df\u01e0\5\32\16\2\u01e0\u01e1"+
		"\7\17\2\2\u01e1\u01e2\5\32\16\2\u01e2\31\3\2\2\2\u01e3\u01f2\5> \2\u01e4"+
		"\u01e5\t\3\2\2\u01e5\u01f2\5> \2\u01e6\u01e7\7\22\2\2\u01e7\u01e8\5> "+
		"\2\u01e8\u01e9\5> \2\u01e9\u01f2\3\2\2\2\u01ea\u01eb\7\23\2\2\u01eb\u01ec"+
		"\t\4\2\2\u01ec\u01f2\5> \2\u01ed\u01ee\7\23\2\2\u01ee\u01ef\7\26\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01f2\t\5\2\2\u01f1\u01e3\3\2\2\2\u01f1\u01e4\3\2"+
		"\2\2\u01f1\u01e6\3\2\2\2\u01f1\u01ea\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f2"+
		"\33\3\2\2\2\u01f3\u01f7\5\62\32\2\u01f4\u01f7\5\60\31\2\u01f5\u01f7\5"+
		"\64\33\2\u01f6\u01f3\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f5\3\2\2\2\u01f7"+
		"\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\35\3\2\2"+
		"\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\7\20\2\2\u01fc\u01fe\5&\24\2\u01fd"+
		"\u01fb\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\37\3\2\2\2\u0201\u01ff\3\2\2\2\u0202\u020b\7\20\2\2\u0203\u0208"+
		"\5(\25\2\u0204\u0205\7\20\2\2\u0205\u0207\5&\24\2\u0206\u0204\3\2\2\2"+
		"\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020c"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u0203\3\2\2\2\u020b\u020c\3\2\2\2\u020c"+
		"!\3\2\2\2\u020d\u0212\5(\25\2\u020e\u020f\7\20\2\2\u020f\u0211\5&\24\2"+
		"\u0210\u020e\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213"+
		"\3\2\2\2\u0213#\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"%\3\2\2\2\u0217\u0219\5*\26\2\u0218\u0217\3\2\2\2\u0219\u021c\3\2\2\2"+
		"\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\'\3\2\2\2\u021c\u021a\3"+
		"\2\2\2\u021d\u021f\5*\26\2\u021e\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221)\3\2\2\2\u0222\u0228\5\62\32"+
		"\2\u0223\u0228\5\60\31\2\u0224\u0228\5\64\33\2\u0225\u0228\7\33\2\2\u0226"+
		"\u0228\7\37\2\2\u0227\u0222\3\2\2\2\u0227\u0223\3\2\2\2\u0227\u0224\3"+
		"\2\2\2\u0227\u0225\3\2\2\2\u0227\u0226\3\2\2\2\u0228+\3\2\2\2\u0229\u022d"+
		"\5*\26\2\u022a\u022d\7\20\2\2\u022b\u022d\7\36\2\2\u022c\u0229\3\2\2\2"+
		"\u022c\u022a\3\2\2\2\u022c\u022b\3\2\2\2\u022d\u0230\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022e\u022f\3\2\2\2\u022f-\3\2\2\2\u0230\u022e\3\2\2\2\u0231"+
		"\u0235\5*\26\2\u0232\u0235\7\20\2\2\u0233\u0235\7\36\2\2\u0234\u0231\3"+
		"\2\2\2\u0234\u0232\3\2\2\2\u0234\u0233\3\2\2\2\u0235\u0238\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237/\3\2\2\2\u0238\u0236\3\2\2\2"+
		"\u0239\u023a\7\6\2\2\u023a\u023b\5@!\2\u023b\u023c\5@!\2\u023c\61\3\2"+
		"\2\2\u023d\u0244\5<\37\2\u023e\u0244\5> \2\u023f\u0244\7\16\2\2\u0240"+
		"\u0244\7\17\2\2\u0241\u0244\7<\2\2\u0242\u0244\7W\2\2\u0243\u023d\3\2"+
		"\2\2\u0243\u023e\3\2\2\2\u0243\u023f\3\2\2\2\u0243\u0240\3\2\2\2\u0243"+
		"\u0241\3\2\2\2\u0243\u0242\3\2\2\2\u0244\63\3\2\2\2\u0245\u0246\t\6\2"+
		"\2\u0246\65\3\2\2\2\u0247\u024b\7:\2\2\u0248\u024c\5\22\n\2\u0249\u024c"+
		"\5:\36\2\u024a\u024c\5\20\t\2\u024b\u0248\3\2\2\2\u024b\u0249\3\2\2\2"+
		"\u024b\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\7;\2\2\u024e\67\3"+
		"\2\2\2\u024f\u0252\5\62\32\2\u0250\u0252\5\60\31\2\u0251\u024f\3\2\2\2"+
		"\u0251\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0251\3\2\2\2\u0253\u0254"+
		"\3\2\2\2\u02549\3\2\2\2\u0255\u0256\5\22\n\2\u0256\u0257\7\6\2\2\u0257"+
		"\u0258\7\23\2\2\u0258\u0259\7\26\2\2\u0259\u025a\3\2\2\2\u025a\u025b\5"+
		"8\35\2\u025b;\3\2\2\2\u025c\u025f\t\7\2\2\u025d\u025f\t\b\2\2\u025e\u025c"+
		"\3\2\2\2\u025e\u025d\3\2\2\2\u025f=\3\2\2\2\u0260\u0261\t\t\2\2\u0261"+
		"?\3\2\2\2\u0262\u026a\5> \2\u0263\u026a\t\n\2\2\u0264\u026a\t\13\2\2\u0265"+
		"\u026a\t\f\2\2\u0266\u026a\t\r\2\2\u0267\u026a\t\16\2\2\u0268\u026a\t"+
		"\17\2\2\u0269\u0262\3\2\2\2\u0269\u0263\3\2\2\2\u0269\u0264\3\2\2\2\u0269"+
		"\u0265\3\2\2\2\u0269\u0266\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u0268\3\2"+
		"\2\2\u026aA\3\2\2\2:GKV^`fkqsy~\u0085\u008b\u008d\u00b8\u00ce\u00d1\u00e4"+
		"\u00ec\u00ef\u00ff\u0110\u0113\u011f\u013c\u013f\u0148\u0174\u0177\u0180"+
		"\u01be\u01c1\u01c5\u01c9\u01d2\u01d9\u01f1\u01f6\u01f8\u01ff\u0208\u020b"+
		"\u0212\u021a\u0220\u0227\u022c\u022e\u0234\u0236\u0243\u024b\u0251\u0253"+
		"\u025e\u0269";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}