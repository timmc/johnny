// Generated from src/main/antlr4/RFC_3986_6874.g4 by ANTLR 4.9.3
package org.timmc.johnny.internal.gen.parse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RFC_3986_6874Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"EXCLAMATION", "POUND", "DOLLAR", "PERCENT", "AMPERSAND", "APOSTROPHE", 
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
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'#'", "'$'", "'%'", "'&'", "'''", "'('", "')'", "'*'", 
			"'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", "'2'", "'3'", "'4'", 
			"'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", "'='", "'?'", "'@'", 
			"'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", 
			"'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", 
			"'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'", "'['", "']'", "'_'", "'a'", 
			"'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", 
			"'l'", "'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", 
			"'v'", "'w'", "'x'", "'y'", "'z'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public RFC_3986_6874Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RFC_3986_6874.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2W\u0157\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3"+
		";\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3"+
		"F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3"+
		"R\3R\3S\3S\3T\3T\3U\3U\3V\3V\2\2W\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099"+
		"N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\3\2\2"+
		"\2\u0156\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2"+
		"\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad\3\2\2\2\5\u00af\3\2\2"+
		"\2\7\u00b1\3\2\2\2\t\u00b3\3\2\2\2\13\u00b5\3\2\2\2\r\u00b7\3\2\2\2\17"+
		"\u00b9\3\2\2\2\21\u00bb\3\2\2\2\23\u00bd\3\2\2\2\25\u00bf\3\2\2\2\27\u00c1"+
		"\3\2\2\2\31\u00c3\3\2\2\2\33\u00c5\3\2\2\2\35\u00c7\3\2\2\2\37\u00c9\3"+
		"\2\2\2!\u00cb\3\2\2\2#\u00cd\3\2\2\2%\u00cf\3\2\2\2\'\u00d1\3\2\2\2)\u00d3"+
		"\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2"+
		"\63\u00dd\3\2\2\2\65\u00df\3\2\2\2\67\u00e1\3\2\2\29\u00e3\3\2\2\2;\u00e5"+
		"\3\2\2\2=\u00e7\3\2\2\2?\u00e9\3\2\2\2A\u00eb\3\2\2\2C\u00ed\3\2\2\2E"+
		"\u00ef\3\2\2\2G\u00f1\3\2\2\2I\u00f3\3\2\2\2K\u00f5\3\2\2\2M\u00f7\3\2"+
		"\2\2O\u00f9\3\2\2\2Q\u00fb\3\2\2\2S\u00fd\3\2\2\2U\u00ff\3\2\2\2W\u0101"+
		"\3\2\2\2Y\u0103\3\2\2\2[\u0105\3\2\2\2]\u0107\3\2\2\2_\u0109\3\2\2\2a"+
		"\u010b\3\2\2\2c\u010d\3\2\2\2e\u010f\3\2\2\2g\u0111\3\2\2\2i\u0113\3\2"+
		"\2\2k\u0115\3\2\2\2m\u0117\3\2\2\2o\u0119\3\2\2\2q\u011b\3\2\2\2s\u011d"+
		"\3\2\2\2u\u011f\3\2\2\2w\u0121\3\2\2\2y\u0123\3\2\2\2{\u0125\3\2\2\2}"+
		"\u0127\3\2\2\2\177\u0129\3\2\2\2\u0081\u012b\3\2\2\2\u0083\u012d\3\2\2"+
		"\2\u0085\u012f\3\2\2\2\u0087\u0131\3\2\2\2\u0089\u0133\3\2\2\2\u008b\u0135"+
		"\3\2\2\2\u008d\u0137\3\2\2\2\u008f\u0139\3\2\2\2\u0091\u013b\3\2\2\2\u0093"+
		"\u013d\3\2\2\2\u0095\u013f\3\2\2\2\u0097\u0141\3\2\2\2\u0099\u0143\3\2"+
		"\2\2\u009b\u0145\3\2\2\2\u009d\u0147\3\2\2\2\u009f\u0149\3\2\2\2\u00a1"+
		"\u014b\3\2\2\2\u00a3\u014d\3\2\2\2\u00a5\u014f\3\2\2\2\u00a7\u0151\3\2"+
		"\2\2\u00a9\u0153\3\2\2\2\u00ab\u0155\3\2\2\2\u00ad\u00ae\7#\2\2\u00ae"+
		"\4\3\2\2\2\u00af\u00b0\7%\2\2\u00b0\6\3\2\2\2\u00b1\u00b2\7&\2\2\u00b2"+
		"\b\3\2\2\2\u00b3\u00b4\7\'\2\2\u00b4\n\3\2\2\2\u00b5\u00b6\7(\2\2\u00b6"+
		"\f\3\2\2\2\u00b7\u00b8\7)\2\2\u00b8\16\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba"+
		"\20\3\2\2\2\u00bb\u00bc\7+\2\2\u00bc\22\3\2\2\2\u00bd\u00be\7,\2\2\u00be"+
		"\24\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0\26\3\2\2\2\u00c1\u00c2\7.\2\2\u00c2"+
		"\30\3\2\2\2\u00c3\u00c4\7/\2\2\u00c4\32\3\2\2\2\u00c5\u00c6\7\60\2\2\u00c6"+
		"\34\3\2\2\2\u00c7\u00c8\7\61\2\2\u00c8\36\3\2\2\2\u00c9\u00ca\7\62\2\2"+
		"\u00ca \3\2\2\2\u00cb\u00cc\7\63\2\2\u00cc\"\3\2\2\2\u00cd\u00ce\7\64"+
		"\2\2\u00ce$\3\2\2\2\u00cf\u00d0\7\65\2\2\u00d0&\3\2\2\2\u00d1\u00d2\7"+
		"\66\2\2\u00d2(\3\2\2\2\u00d3\u00d4\7\67\2\2\u00d4*\3\2\2\2\u00d5\u00d6"+
		"\78\2\2\u00d6,\3\2\2\2\u00d7\u00d8\79\2\2\u00d8.\3\2\2\2\u00d9\u00da\7"+
		":\2\2\u00da\60\3\2\2\2\u00db\u00dc\7;\2\2\u00dc\62\3\2\2\2\u00dd\u00de"+
		"\7<\2\2\u00de\64\3\2\2\2\u00df\u00e0\7=\2\2\u00e0\66\3\2\2\2\u00e1\u00e2"+
		"\7?\2\2\u00e28\3\2\2\2\u00e3\u00e4\7A\2\2\u00e4:\3\2\2\2\u00e5\u00e6\7"+
		"B\2\2\u00e6<\3\2\2\2\u00e7\u00e8\7C\2\2\u00e8>\3\2\2\2\u00e9\u00ea\7D"+
		"\2\2\u00ea@\3\2\2\2\u00eb\u00ec\7E\2\2\u00ecB\3\2\2\2\u00ed\u00ee\7F\2"+
		"\2\u00eeD\3\2\2\2\u00ef\u00f0\7G\2\2\u00f0F\3\2\2\2\u00f1\u00f2\7H\2\2"+
		"\u00f2H\3\2\2\2\u00f3\u00f4\7I\2\2\u00f4J\3\2\2\2\u00f5\u00f6\7J\2\2\u00f6"+
		"L\3\2\2\2\u00f7\u00f8\7K\2\2\u00f8N\3\2\2\2\u00f9\u00fa\7L\2\2\u00faP"+
		"\3\2\2\2\u00fb\u00fc\7M\2\2\u00fcR\3\2\2\2\u00fd\u00fe\7N\2\2\u00feT\3"+
		"\2\2\2\u00ff\u0100\7O\2\2\u0100V\3\2\2\2\u0101\u0102\7P\2\2\u0102X\3\2"+
		"\2\2\u0103\u0104\7Q\2\2\u0104Z\3\2\2\2\u0105\u0106\7R\2\2\u0106\\\3\2"+
		"\2\2\u0107\u0108\7S\2\2\u0108^\3\2\2\2\u0109\u010a\7T\2\2\u010a`\3\2\2"+
		"\2\u010b\u010c\7U\2\2\u010cb\3\2\2\2\u010d\u010e\7V\2\2\u010ed\3\2\2\2"+
		"\u010f\u0110\7W\2\2\u0110f\3\2\2\2\u0111\u0112\7X\2\2\u0112h\3\2\2\2\u0113"+
		"\u0114\7Y\2\2\u0114j\3\2\2\2\u0115\u0116\7Z\2\2\u0116l\3\2\2\2\u0117\u0118"+
		"\7[\2\2\u0118n\3\2\2\2\u0119\u011a\7\\\2\2\u011ap\3\2\2\2\u011b\u011c"+
		"\7]\2\2\u011cr\3\2\2\2\u011d\u011e\7_\2\2\u011et\3\2\2\2\u011f\u0120\7"+
		"a\2\2\u0120v\3\2\2\2\u0121\u0122\7c\2\2\u0122x\3\2\2\2\u0123\u0124\7d"+
		"\2\2\u0124z\3\2\2\2\u0125\u0126\7e\2\2\u0126|\3\2\2\2\u0127\u0128\7f\2"+
		"\2\u0128~\3\2\2\2\u0129\u012a\7g\2\2\u012a\u0080\3\2\2\2\u012b\u012c\7"+
		"h\2\2\u012c\u0082\3\2\2\2\u012d\u012e\7i\2\2\u012e\u0084\3\2\2\2\u012f"+
		"\u0130\7j\2\2\u0130\u0086\3\2\2\2\u0131\u0132\7k\2\2\u0132\u0088\3\2\2"+
		"\2\u0133\u0134\7l\2\2\u0134\u008a\3\2\2\2\u0135\u0136\7m\2\2\u0136\u008c"+
		"\3\2\2\2\u0137\u0138\7n\2\2\u0138\u008e\3\2\2\2\u0139\u013a\7o\2\2\u013a"+
		"\u0090\3\2\2\2\u013b\u013c\7p\2\2\u013c\u0092\3\2\2\2\u013d\u013e\7q\2"+
		"\2\u013e\u0094\3\2\2\2\u013f\u0140\7r\2\2\u0140\u0096\3\2\2\2\u0141\u0142"+
		"\7s\2\2\u0142\u0098\3\2\2\2\u0143\u0144\7t\2\2\u0144\u009a\3\2\2\2\u0145"+
		"\u0146\7u\2\2\u0146\u009c\3\2\2\2\u0147\u0148\7v\2\2\u0148\u009e\3\2\2"+
		"\2\u0149\u014a\7w\2\2\u014a\u00a0\3\2\2\2\u014b\u014c\7x\2\2\u014c\u00a2"+
		"\3\2\2\2\u014d\u014e\7y\2\2\u014e\u00a4\3\2\2\2\u014f\u0150\7z\2\2\u0150"+
		"\u00a6\3\2\2\2\u0151\u0152\7{\2\2\u0152\u00a8\3\2\2\2\u0153\u0154\7|\2"+
		"\2\u0154\u00aa\3\2\2\2\u0155\u0156\7\u0080\2\2\u0156\u00ac\3\2\2\2\3\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}