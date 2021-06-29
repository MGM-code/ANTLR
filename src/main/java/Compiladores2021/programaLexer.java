// Generated from d:\Usuarios\Nicolas\Escritorio\REPO\ANTLR\src\main\java\Compiladores2021\programa.g4 by ANTLR 4.8

package Compiladores2021;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class programaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, LA=3, LC=4, CA=5, CC=6, PYC=7, EQ=8, COMA=9, COMILLA=10, INT=11, 
		CHAR=12, DOUBLE=13, FLOAT=14, VOID=15, RETURN=16, FOR=17, IF=18, ELSE=19, 
		WHILE=20, SUM=21, RESTA=22, MULT=23, DIV=24, RESTO=25, MEN=26, MENEQ=27, 
		EQL=28, MAY=29, MAYEQ=30, DST=31, OR=32, AND=33, NOT=34, INC_DEC=35, ID=36, 
		ENTERO=37, DECIMAL=38, CARACTER=39, LETRAMAYUSCULA=40, WS=41, OTRO=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETRA", "DIGITO", "MAYUSCULA", "PA", "PC", "LA", "LC", "CA", "CC", "PYC", 
			"EQ", "COMA", "COMILLA", "INT", "CHAR", "DOUBLE", "FLOAT", "VOID", "RETURN", 
			"FOR", "IF", "ELSE", "WHILE", "SUM", "RESTA", "MULT", "DIV", "RESTO", 
			"MEN", "MENEQ", "EQL", "MAY", "MAYEQ", "DST", "OR", "AND", "NOT", "INC_DEC", 
			"ID", "ENTERO", "DECIMAL", "CARACTER", "LETRAMAYUSCULA", "WS", "OTRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'='", "','", 
			"'\"'", "'int '", "'char '", "'double '", "'float '", "'void '", "'return '", 
			"'for'", "'if'", "'else'", "'while'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'<'", "'<='", "'=='", "'>'", "'>='", "'!='", "'||'", "'&&'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "LA", "LC", "CA", "CC", "PYC", "EQ", "COMA", "COMILLA", 
			"INT", "CHAR", "DOUBLE", "FLOAT", "VOID", "RETURN", "FOR", "IF", "ELSE", 
			"WHILE", "SUM", "RESTA", "MULT", "DIV", "RESTO", "MEN", "MENEQ", "EQL", 
			"MAY", "MAYEQ", "DST", "OR", "AND", "NOT", "INC_DEC", "ID", "ENTERO", 
			"DECIMAL", "CARACTER", "LETRAMAYUSCULA", "WS", "OTRO"
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


	    String tipovariable="";
	    Funciones funciones= new Funciones();
	    String nombreVariable=null;
	    Object valor=null;
	    String variableAsignada=null;


	public programaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "programa.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00fa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3"+
		"\'\3\'\5\'\u00d8\n\'\3(\3(\5(\u00dc\n(\3(\3(\3(\7(\u00e1\n(\f(\16(\u00e4"+
		"\13(\3)\6)\u00e7\n)\r)\16)\u00e8\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3-\3-\3"+
		"-\3-\3.\3.\2\2/\3\2\5\2\7\2\t\3\13\4\r\5\17\6\21\7\23\b\25\t\27\n\31\13"+
		"\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67"+
		"\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,\3\2\6\4\2C\\c|\3\2"+
		"\62;\3\2C\\\5\2\13\f\17\17\"\"\2\u00fc\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7"+
		"a\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21k\3\2\2\2\23"+
		"m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2"+
		"\37|\3\2\2\2!\u0082\3\2\2\2#\u008a\3\2\2\2%\u0091\3\2\2\2\'\u0097\3\2"+
		"\2\2)\u009f\3\2\2\2+\u00a3\3\2\2\2-\u00a6\3\2\2\2/\u00ab\3\2\2\2\61\u00b1"+
		"\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2\2\2\67\u00b7\3\2\2\29\u00b9\3\2"+
		"\2\2;\u00bb\3\2\2\2=\u00bd\3\2\2\2?\u00c0\3\2\2\2A\u00c3\3\2\2\2C\u00c5"+
		"\3\2\2\2E\u00c8\3\2\2\2G\u00cb\3\2\2\2I\u00ce\3\2\2\2K\u00d1\3\2\2\2M"+
		"\u00d7\3\2\2\2O\u00db\3\2\2\2Q\u00e6\3\2\2\2S\u00ea\3\2\2\2U\u00ee\3\2"+
		"\2\2W\u00f2\3\2\2\2Y\u00f4\3\2\2\2[\u00f8\3\2\2\2]^\t\2\2\2^\4\3\2\2\2"+
		"_`\t\3\2\2`\6\3\2\2\2ab\t\4\2\2b\b\3\2\2\2cd\7*\2\2d\n\3\2\2\2ef\7+\2"+
		"\2f\f\3\2\2\2gh\7}\2\2h\16\3\2\2\2ij\7\177\2\2j\20\3\2\2\2kl\7]\2\2l\22"+
		"\3\2\2\2mn\7_\2\2n\24\3\2\2\2op\7=\2\2p\26\3\2\2\2qr\7?\2\2r\30\3\2\2"+
		"\2st\7.\2\2t\32\3\2\2\2uv\7$\2\2v\34\3\2\2\2wx\7k\2\2xy\7p\2\2yz\7v\2"+
		"\2z{\7\"\2\2{\36\3\2\2\2|}\7e\2\2}~\7j\2\2~\177\7c\2\2\177\u0080\7t\2"+
		"\2\u0080\u0081\7\"\2\2\u0081 \3\2\2\2\u0082\u0083\7f\2\2\u0083\u0084\7"+
		"q\2\2\u0084\u0085\7w\2\2\u0085\u0086\7d\2\2\u0086\u0087\7n\2\2\u0087\u0088"+
		"\7g\2\2\u0088\u0089\7\"\2\2\u0089\"\3\2\2\2\u008a\u008b\7h\2\2\u008b\u008c"+
		"\7n\2\2\u008c\u008d\7q\2\2\u008d\u008e\7c\2\2\u008e\u008f\7v\2\2\u008f"+
		"\u0090\7\"\2\2\u0090$\3\2\2\2\u0091\u0092\7x\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7f\2\2\u0095\u0096\7\"\2\2\u0096&\3\2\2\2\u0097"+
		"\u0098\7t\2\2\u0098\u0099\7g\2\2\u0099\u009a\7v\2\2\u009a\u009b\7w\2\2"+
		"\u009b\u009c\7t\2\2\u009c\u009d\7p\2\2\u009d\u009e\7\"\2\2\u009e(\3\2"+
		"\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7t\2\2\u00a2*\3"+
		"\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5,\3\2\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		".\3\2\2\2\u00ab\u00ac\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae"+
		"\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7-\2\2\u00b2"+
		"\62\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7,\2\2\u00b6"+
		"\66\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b88\3\2\2\2\u00b9\u00ba\7\'\2\2\u00ba"+
		":\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc<\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf"+
		"\7?\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7?\2\2\u00c2@\3"+
		"\2\2\2\u00c3\u00c4\7@\2\2\u00c4B\3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7D\3\2\2\2\u00c8\u00c9\7#\2\2\u00c9\u00ca\7?\2\2\u00caF\3"+
		"\2\2\2\u00cb\u00cc\7~\2\2\u00cc\u00cd\7~\2\2\u00cdH\3\2\2\2\u00ce\u00cf"+
		"\7(\2\2\u00cf\u00d0\7(\2\2\u00d0J\3\2\2\2\u00d1\u00d2\7#\2\2\u00d2L\3"+
		"\2\2\2\u00d3\u00d4\7-\2\2\u00d4\u00d8\7-\2\2\u00d5\u00d6\7/\2\2\u00d6"+
		"\u00d8\7/\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8N\3\2\2\2\u00d9"+
		"\u00dc\5\3\2\2\u00da\u00dc\7a\2\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2"+
		"\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00e1\5\3\2\2\u00de\u00e1\5\5\3\2\u00df"+
		"\u00e1\7a\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"P\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\5\5\3\2\u00e6\u00e5\3\2\2\2"+
		"\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9R\3"+
		"\2\2\2\u00ea\u00eb\5Q)\2\u00eb\u00ec\7\60\2\2\u00ec\u00ed\5Q)\2\u00ed"+
		"T\3\2\2\2\u00ee\u00ef\7)\2\2\u00ef\u00f0\5\3\2\2\u00f0\u00f1\7)\2\2\u00f1"+
		"V\3\2\2\2\u00f2\u00f3\5\7\4\2\u00f3X\3\2\2\2\u00f4\u00f5\t\5\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\b-\2\2\u00f7Z\3\2\2\2\u00f8\u00f9\13\2\2\2"+
		"\u00f9\\\3\2\2\2\b\2\u00d7\u00db\u00e0\u00e2\u00e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}