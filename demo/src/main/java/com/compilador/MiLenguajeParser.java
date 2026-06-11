// Generated from com/compilador/MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PAREN_A=1, PAREN_C=2, CORCH_A=3, CORCH_C=4, LLAVE_A=5, LLAVE_C=6, PYCOM=7, 
		COMA=8, OP_EQ=9, OP_NEQ=10, OP_GTE=11, OP_LTE=12, OP_FLUJO=13, OP_OR=14, 
		OP_AND=15, OP_GT=16, OP_LT=17, OP_ASIG=18, OP_SUM=19, OP_RES=20, OP_MUL=21, 
		OP_DIV=22, OP_MOD=23, OP_NOT=24, FOR=25, WHILE=26, IF=27, ELSE=28, BREAK=29, 
		CONTINUE=30, RETURN=31, INT=32, FLOAT=33, DOUBLE=34, CHAR=35, STRING_TIPO=36, 
		BOOL=37, VOID=38, TRUE=39, FALSE=40, COUT=41, ID=42, ENTERO=43, DECIMAL=44, 
		CARACTER=45, CADENA=46, COM_LINEA=47, COM_BLOQUE=48, ESPACIOS=49, INVALIDO=50;
	public static final int
		RULE_codigo = 0, RULE_instruccion = 1, RULE_declVar = 2, RULE_defFuncion = 3, 
		RULE_listaParams = 4, RULE_param = 5, RULE_retorno = 6, RULE_tipoDato = 7, 
		RULE_asignacion = 8, RULE_imprimir = 9, RULE_condicional = 10, RULE_bucleWhile = 11, 
		RULE_bucleFor = 12, RULE_inicFor = 13, RULE_actualizFor = 14, RULE_salirBucle = 15, 
		RULE_continuarBucle = 16, RULE_bloque = 17, RULE_expresion = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"codigo", "instruccion", "declVar", "defFuncion", "listaParams", "param", 
			"retorno", "tipoDato", "asignacion", "imprimir", "condicional", "bucleWhile", 
			"bucleFor", "inicFor", "actualizFor", "salirBucle", "continuarBucle", 
			"bloque", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'=='", 
			"'!='", "'>='", "'<='", "'<<'", "'||'", "'&&'", "'>'", "'<'", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'for'", "'while'", "'if'", 
			"'else'", "'break'", "'continue'", "'return'", "'int'", "'float'", "'double'", 
			"'char'", "'string'", "'bool'", "'void'", "'true'", "'false'", "'cout'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PAREN_A", "PAREN_C", "CORCH_A", "CORCH_C", "LLAVE_A", "LLAVE_C", 
			"PYCOM", "COMA", "OP_EQ", "OP_NEQ", "OP_GTE", "OP_LTE", "OP_FLUJO", "OP_OR", 
			"OP_AND", "OP_GT", "OP_LT", "OP_ASIG", "OP_SUM", "OP_RES", "OP_MUL", 
			"OP_DIV", "OP_MOD", "OP_NOT", "FOR", "WHILE", "IF", "ELSE", "BREAK", 
			"CONTINUE", "RETURN", "INT", "FLOAT", "DOUBLE", "CHAR", "STRING_TIPO", 
			"BOOL", "VOID", "TRUE", "FALSE", "COUT", "ID", "ENTERO", "DECIMAL", "CARACTER", 
			"CADENA", "COM_LINEA", "COM_BLOQUE", "ESPACIOS", "INVALIDO"
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

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CodigoContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiLenguajeParser.EOF, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public CodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codigo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitCodigo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodigoContext codigo() throws RecognitionException {
		CodigoContext _localctx = new CodigoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_codigo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LLAVE_A) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TIPO) | (1L << BOOL) | (1L << VOID) | (1L << COUT) | (1L << ID))) != 0)) {
				{
				{
				setState(38);
				instruccion();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EOF);
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

	public static class InstruccionContext extends ParserRuleContext {
		public DefFuncionContext defFuncion() {
			return getRuleContext(DefFuncionContext.class,0);
		}
		public DeclVarContext declVar() {
			return getRuleContext(DeclVarContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ImprimirContext imprimir() {
			return getRuleContext(ImprimirContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public BucleWhileContext bucleWhile() {
			return getRuleContext(BucleWhileContext.class,0);
		}
		public BucleForContext bucleFor() {
			return getRuleContext(BucleForContext.class,0);
		}
		public SalirBucleContext salirBucle() {
			return getRuleContext(SalirBucleContext.class,0);
		}
		public ContinuarBucleContext continuarBucle() {
			return getRuleContext(ContinuarBucleContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruccion);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				defFuncion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				declVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				imprimir();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				condicional();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				bucleWhile();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				bucleFor();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				salirBucle();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				continuarBucle();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(55);
				retorno();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(56);
				bloque();
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

	public static class DeclVarContext extends ParserRuleContext {
		public DeclVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVar; }
	 
		public DeclVarContext() { }
		public void copyFrom(DeclVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclArregloContext extends DeclVarContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CORCH_A() { return getToken(MiLenguajeParser.CORCH_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CORCH_C() { return getToken(MiLenguajeParser.CORCH_C, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public DeclArregloContext(DeclVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclSimpleContext extends DeclVarContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclSimpleContext(DeclVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVarContext declVar() throws RecognitionException {
		DeclVarContext _localctx = new DeclVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declVar);
		int _la;
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				tipoDato();
				setState(60);
				match(ID);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_ASIG) {
					{
					setState(61);
					match(OP_ASIG);
					setState(62);
					expresion(0);
					}
				}

				setState(65);
				match(PYCOM);
				}
				break;
			case 2:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				tipoDato();
				setState(68);
				match(ID);
				setState(69);
				match(CORCH_A);
				setState(70);
				expresion(0);
				setState(71);
				match(CORCH_C);
				setState(72);
				match(PYCOM);
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

	public static class DefFuncionContext extends ParserRuleContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ListaParamsContext listaParams() {
			return getRuleContext(ListaParamsContext.class,0);
		}
		public DefFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFuncion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDefFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefFuncionContext defFuncion() throws RecognitionException {
		DefFuncionContext _localctx = new DefFuncionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			tipoDato();
			setState(77);
			match(ID);
			setState(78);
			match(PAREN_A);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TIPO) | (1L << BOOL) | (1L << VOID))) != 0)) {
				{
				setState(79);
				listaParams();
				}
			}

			setState(82);
			match(PAREN_C);
			setState(83);
			bloque();
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

	public static class ListaParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ListaParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitListaParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaParamsContext listaParams() throws RecognitionException {
		ListaParamsContext _localctx = new ListaParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listaParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			param();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(86);
				match(COMA);
				setState(87);
				param();
				}
				}
				setState(92);
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

	public static class ParamContext extends ParserRuleContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			tipoDato();
			setState(94);
			match(ID);
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

	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_retorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(RETURN);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAREN_A) | (1L << OP_RES) | (1L << OP_NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << ENTERO) | (1L << DECIMAL) | (1L << CARACTER) | (1L << CADENA))) != 0)) {
				{
				setState(97);
				expresion(0);
				}
			}

			setState(100);
			match(PYCOM);
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

	public static class TipoDatoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MiLenguajeParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode STRING_TIPO() { return getToken(MiLenguajeParser.STRING_TIPO, 0); }
		public TerminalNode BOOL() { return getToken(MiLenguajeParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TipoDatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDato; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitTipoDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDatoContext tipoDato() throws RecognitionException {
		TipoDatoContext _localctx = new TipoDatoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipoDato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TIPO) | (1L << BOOL) | (1L << VOID))) != 0)) ) {
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

	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsigArregloContext extends AsignacionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CORCH_A() { return getToken(MiLenguajeParser.CORCH_A, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode CORCH_C() { return getToken(MiLenguajeParser.CORCH_C, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public AsigArregloContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsigArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsigSimpleContext extends AsignacionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public AsigSimpleContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsigSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_asignacion);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AsigSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(ID);
				setState(105);
				match(OP_ASIG);
				setState(106);
				expresion(0);
				setState(107);
				match(PYCOM);
				}
				break;
			case 2:
				_localctx = new AsigArregloContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(ID);
				setState(110);
				match(CORCH_A);
				setState(111);
				expresion(0);
				setState(112);
				match(CORCH_C);
				setState(113);
				match(OP_ASIG);
				setState(114);
				expresion(0);
				setState(115);
				match(PYCOM);
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

	public static class ImprimirContext extends ParserRuleContext {
		public TerminalNode COUT() { return getToken(MiLenguajeParser.COUT, 0); }
		public TerminalNode OP_FLUJO() { return getToken(MiLenguajeParser.OP_FLUJO, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public ImprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imprimir; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitImprimir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImprimirContext imprimir() throws RecognitionException {
		ImprimirContext _localctx = new ImprimirContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_imprimir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(COUT);
			setState(120);
			match(OP_FLUJO);
			setState(121);
			expresion(0);
			setState(122);
			match(PYCOM);
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

	public static class CondicionalContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(IF);
			setState(125);
			match(PAREN_A);
			setState(126);
			expresion(0);
			setState(127);
			match(PAREN_C);
			setState(128);
			bloque();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(129);
				match(ELSE);
				setState(130);
				bloque();
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

	public static class BucleWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public BucleWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucleWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBucleWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BucleWhileContext bucleWhile() throws RecognitionException {
		BucleWhileContext _localctx = new BucleWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bucleWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(WHILE);
			setState(134);
			match(PAREN_A);
			setState(135);
			expresion(0);
			setState(136);
			match(PAREN_C);
			setState(137);
			bloque();
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

	public static class BucleForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public List<TerminalNode> PYCOM() { return getTokens(MiLenguajeParser.PYCOM); }
		public TerminalNode PYCOM(int i) {
			return getToken(MiLenguajeParser.PYCOM, i);
		}
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public InicForContext inicFor() {
			return getRuleContext(InicForContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ActualizForContext actualizFor() {
			return getRuleContext(ActualizForContext.class,0);
		}
		public BucleForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucleFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBucleFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BucleForContext bucleFor() throws RecognitionException {
		BucleForContext _localctx = new BucleForContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bucleFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(FOR);
			setState(140);
			match(PAREN_A);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TIPO) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(141);
				inicFor();
				}
			}

			setState(144);
			match(PYCOM);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAREN_A) | (1L << OP_RES) | (1L << OP_NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << ENTERO) | (1L << DECIMAL) | (1L << CARACTER) | (1L << CADENA))) != 0)) {
				{
				setState(145);
				expresion(0);
				}
			}

			setState(148);
			match(PYCOM);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(149);
				actualizFor();
				}
			}

			setState(152);
			match(PAREN_C);
			setState(153);
			bloque();
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

	public static class InicForContext extends ParserRuleContext {
		public InicForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicFor; }
	 
		public InicForContext() { }
		public void copyFrom(InicForContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InicForDeclContext extends InicForContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public InicForDeclContext(InicForContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInicForDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InicForAsigContext extends InicForContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public InicForAsigContext(InicForContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInicForAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicForContext inicFor() throws RecognitionException {
		InicForContext _localctx = new InicForContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inicFor);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case STRING_TIPO:
			case BOOL:
			case VOID:
				_localctx = new InicForDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				tipoDato();
				setState(156);
				match(ID);
				setState(157);
				match(OP_ASIG);
				setState(158);
				expresion(0);
				}
				break;
			case ID:
				_localctx = new InicForAsigContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(ID);
				setState(161);
				match(OP_ASIG);
				setState(162);
				expresion(0);
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

	public static class ActualizForContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(MiLenguajeParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ActualizForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualizFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitActualizFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualizForContext actualizFor() throws RecognitionException {
		ActualizForContext _localctx = new ActualizForContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_actualizFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(166);
			match(OP_ASIG);
			setState(167);
			expresion(0);
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

	public static class SalirBucleContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiLenguajeParser.BREAK, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public SalirBucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_salirBucle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSalirBucle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SalirBucleContext salirBucle() throws RecognitionException {
		SalirBucleContext _localctx = new SalirBucleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_salirBucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(BREAK);
			setState(170);
			match(PYCOM);
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

	public static class ContinuarBucleContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYCOM() { return getToken(MiLenguajeParser.PYCOM, 0); }
		public ContinuarBucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continuarBucle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitContinuarBucle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinuarBucleContext continuarBucle() throws RecognitionException {
		ContinuarBucleContext _localctx = new ContinuarBucleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continuarBucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(CONTINUE);
			setState(173);
			match(PYCOM);
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

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LLAVE_A() { return getToken(MiLenguajeParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(MiLenguajeParser.LLAVE_C, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(LLAVE_A);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LLAVE_A) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TIPO) | (1L << BOOL) | (1L << VOID) | (1L << COUT) | (1L << ID))) != 0)) {
				{
				{
				setState(176);
				instruccion();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			match(LLAVE_C);
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

	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LitEnteroContext extends ExpresionContext {
		public TerminalNode ENTERO() { return getToken(MiLenguajeParser.ENTERO, 0); }
		public LitEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public LitDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAditivaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_SUM() { return getToken(MiLenguajeParser.OP_SUM, 0); }
		public TerminalNode OP_RES() { return getToken(MiLenguajeParser.OP_RES, 0); }
		public ExprAditivaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRelacionalContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_GT() { return getToken(MiLenguajeParser.OP_GT, 0); }
		public TerminalNode OP_LT() { return getToken(MiLenguajeParser.OP_LT, 0); }
		public TerminalNode OP_GTE() { return getToken(MiLenguajeParser.OP_GTE, 0); }
		public TerminalNode OP_LTE() { return getToken(MiLenguajeParser.OP_LTE, 0); }
		public ExprRelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitVerdaderoContext extends ExpresionContext {
		public TerminalNode TRUE() { return getToken(MiLenguajeParser.TRUE, 0); }
		public LitVerdaderoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitVerdadero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitCadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(MiLenguajeParser.CADENA, 0); }
		public LitCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccesoArregloContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CORCH_A() { return getToken(MiLenguajeParser.CORCH_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CORCH_C() { return getToken(MiLenguajeParser.CORCH_C, 0); }
		public AccesoArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAccesoArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitFalsoContext extends ExpresionContext {
		public TerminalNode FALSE() { return getToken(MiLenguajeParser.FALSE, 0); }
		public LitFalsoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitFalso(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_OR() { return getToken(MiLenguajeParser.OP_OR, 0); }
		public ExprOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNegativoContext extends ExpresionContext {
		public TerminalNode OP_RES() { return getToken(MiLenguajeParser.OP_RES, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNegativoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNegativo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LlamadaFuncionContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public LlamadaFuncionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLlamadaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitCaracterContext extends ExpresionContext {
		public TerminalNode CARACTER() { return getToken(MiLenguajeParser.CARACTER, 0); }
		public LitCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitLitCaracter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNegacionContext extends ExpresionContext {
		public TerminalNode OP_NOT() { return getToken(MiLenguajeParser.OP_NOT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNegacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNegacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIgualdadContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_EQ() { return getToken(MiLenguajeParser.OP_EQ, 0); }
		public TerminalNode OP_NEQ() { return getToken(MiLenguajeParser.OP_NEQ, 0); }
		public ExprIgualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public VariableContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_AND() { return getToken(MiLenguajeParser.OP_AND, 0); }
		public ExprAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprGrupoContext extends ExpresionContext {
		public TerminalNode PAREN_A() { return getToken(MiLenguajeParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(MiLenguajeParser.PAREN_C, 0); }
		public ExprGrupoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprGrupo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultiplicativaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OP_MUL() { return getToken(MiLenguajeParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(MiLenguajeParser.OP_DIV, 0); }
		public TerminalNode OP_MOD() { return getToken(MiLenguajeParser.OP_MOD, 0); }
		public ExprMultiplicativaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExprNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(185);
				match(OP_NOT);
				setState(186);
				expresion(18);
				}
				break;
			case 2:
				{
				_localctx = new ExprNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(OP_RES);
				setState(188);
				expresion(17);
				}
				break;
			case 3:
				{
				_localctx = new ExprGrupoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(PAREN_A);
				setState(190);
				expresion(0);
				setState(191);
				match(PAREN_C);
				}
				break;
			case 4:
				{
				_localctx = new LitEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(ENTERO);
				}
				break;
			case 5:
				{
				_localctx = new LitDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(DECIMAL);
				}
				break;
			case 6:
				{
				_localctx = new LitCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(CARACTER);
				}
				break;
			case 7:
				{
				_localctx = new LitCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(CADENA);
				}
				break;
			case 8:
				{
				_localctx = new LitVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new LitFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(FALSE);
				}
				break;
			case 10:
				{
				_localctx = new LlamadaFuncionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(ID);
				setState(200);
				match(PAREN_A);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAREN_A) | (1L << OP_RES) | (1L << OP_NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << ENTERO) | (1L << DECIMAL) | (1L << CARACTER) | (1L << CADENA))) != 0)) {
					{
					setState(201);
					expresion(0);
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(202);
						match(COMA);
						setState(203);
						expresion(0);
						}
						}
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(211);
				match(PAREN_C);
				}
				break;
			case 11:
				{
				_localctx = new AccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(ID);
				setState(213);
				match(CORCH_A);
				setState(214);
				expresion(0);
				setState(215);
				match(CORCH_C);
				}
				break;
			case 12:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(238);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicativaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(220);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(221);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MUL) | (1L << OP_DIV) | (1L << OP_MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprAditivaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(223);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(224);
						_la = _input.LA(1);
						if ( !(_la==OP_SUM || _la==OP_RES) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(226);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(227);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GTE) | (1L << OP_LTE) | (1L << OP_GT) | (1L << OP_LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(229);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(230);
						_la = _input.LA(1);
						if ( !(_la==OP_EQ || _la==OP_NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(231);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(232);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(233);
						match(OP_AND);
						setState(234);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(235);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(236);
						match(OP_OR);
						setState(237);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00f6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\5\4B\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5\3\5\5\5S\n\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\7\3\7\3\7\3\b\3\b\5\be\n"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nx\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0086"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u0091\n\16\3\16\3\16"+
		"\5\16\u0095\n\16\3\16\3\16\5\16\u0099\n\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a6\n\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\7\23\u00b4\n\23\f\23\16\23\u00b7\13"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00cf\n\24\f\24\16\24"+
		"\u00d2\13\24\5\24\u00d4\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00dd"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u00f1\n\24\f\24\16\24\u00f4\13\24\3\24"+
		"\2\3&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\7\3\2\"(\3\2\27"+
		"\31\3\2\25\26\4\2\r\16\22\23\3\2\13\f\2\u010c\2+\3\2\2\2\4;\3\2\2\2\6"+
		"L\3\2\2\2\bN\3\2\2\2\nW\3\2\2\2\f_\3\2\2\2\16b\3\2\2\2\20h\3\2\2\2\22"+
		"w\3\2\2\2\24y\3\2\2\2\26~\3\2\2\2\30\u0087\3\2\2\2\32\u008d\3\2\2\2\34"+
		"\u00a5\3\2\2\2\36\u00a7\3\2\2\2 \u00ab\3\2\2\2\"\u00ae\3\2\2\2$\u00b1"+
		"\3\2\2\2&\u00dc\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,.\3\2\2\2-+\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60<\5\b\5\2\61<\5\6\4\2"+
		"\62<\5\22\n\2\63<\5\24\13\2\64<\5\26\f\2\65<\5\30\r\2\66<\5\32\16\2\67"+
		"<\5 \21\28<\5\"\22\29<\5\16\b\2:<\5$\23\2;\60\3\2\2\2;\61\3\2\2\2;\62"+
		"\3\2\2\2;\63\3\2\2\2;\64\3\2\2\2;\65\3\2\2\2;\66\3\2\2\2;\67\3\2\2\2;"+
		"8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\5\3\2\2\2=>\5\20\t\2>A\7,\2\2?@\7\24\2"+
		"\2@B\5&\24\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\t\2\2DM\3\2\2\2EF\5\20"+
		"\t\2FG\7,\2\2GH\7\5\2\2HI\5&\24\2IJ\7\6\2\2JK\7\t\2\2KM\3\2\2\2L=\3\2"+
		"\2\2LE\3\2\2\2M\7\3\2\2\2NO\5\20\t\2OP\7,\2\2PR\7\3\2\2QS\5\n\6\2RQ\3"+
		"\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\4\2\2UV\5$\23\2V\t\3\2\2\2W\\\5\f\7\2X"+
		"Y\7\n\2\2Y[\5\f\7\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\13\3\2"+
		"\2\2^\\\3\2\2\2_`\5\20\t\2`a\7,\2\2a\r\3\2\2\2bd\7!\2\2ce\5&\24\2dc\3"+
		"\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\t\2\2g\17\3\2\2\2hi\t\2\2\2i\21\3\2\2\2"+
		"jk\7,\2\2kl\7\24\2\2lm\5&\24\2mn\7\t\2\2nx\3\2\2\2op\7,\2\2pq\7\5\2\2"+
		"qr\5&\24\2rs\7\6\2\2st\7\24\2\2tu\5&\24\2uv\7\t\2\2vx\3\2\2\2wj\3\2\2"+
		"\2wo\3\2\2\2x\23\3\2\2\2yz\7+\2\2z{\7\17\2\2{|\5&\24\2|}\7\t\2\2}\25\3"+
		"\2\2\2~\177\7\35\2\2\177\u0080\7\3\2\2\u0080\u0081\5&\24\2\u0081\u0082"+
		"\7\4\2\2\u0082\u0085\5$\23\2\u0083\u0084\7\36\2\2\u0084\u0086\5$\23\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\27\3\2\2\2\u0087\u0088"+
		"\7\34\2\2\u0088\u0089\7\3\2\2\u0089\u008a\5&\24\2\u008a\u008b\7\4\2\2"+
		"\u008b\u008c\5$\23\2\u008c\31\3\2\2\2\u008d\u008e\7\33\2\2\u008e\u0090"+
		"\7\3\2\2\u008f\u0091\5\34\17\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0094\7\t\2\2\u0093\u0095\5&\24\2\u0094\u0093"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\7\t\2\2\u0097"+
		"\u0099\5\36\20\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u009b\7\4\2\2\u009b\u009c\5$\23\2\u009c\33\3\2\2\2\u009d"+
		"\u009e\5\20\t\2\u009e\u009f\7,\2\2\u009f\u00a0\7\24\2\2\u00a0\u00a1\5"+
		"&\24\2\u00a1\u00a6\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\7\24\2\2\u00a4"+
		"\u00a6\5&\24\2\u00a5\u009d\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6\35\3\2\2"+
		"\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7\24\2\2\u00a9\u00aa\5&\24\2\u00aa\37"+
		"\3\2\2\2\u00ab\u00ac\7\37\2\2\u00ac\u00ad\7\t\2\2\u00ad!\3\2\2\2\u00ae"+
		"\u00af\7 \2\2\u00af\u00b0\7\t\2\2\u00b0#\3\2\2\2\u00b1\u00b5\7\7\2\2\u00b2"+
		"\u00b4\5\4\3\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\u00b9\7\b\2\2\u00b9%\3\2\2\2\u00ba\u00bb\b\24\1\2\u00bb\u00bc\7\32\2"+
		"\2\u00bc\u00dd\5&\24\24\u00bd\u00be\7\26\2\2\u00be\u00dd\5&\24\23\u00bf"+
		"\u00c0\7\3\2\2\u00c0\u00c1\5&\24\2\u00c1\u00c2\7\4\2\2\u00c2\u00dd\3\2"+
		"\2\2\u00c3\u00dd\7-\2\2\u00c4\u00dd\7.\2\2\u00c5\u00dd\7/\2\2\u00c6\u00dd"+
		"\7\60\2\2\u00c7\u00dd\7)\2\2\u00c8\u00dd\7*\2\2\u00c9\u00ca\7,\2\2\u00ca"+
		"\u00d3\7\3\2\2\u00cb\u00d0\5&\24\2\u00cc\u00cd\7\n\2\2\u00cd\u00cf\5&"+
		"\24\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00dd\7\4\2\2\u00d6"+
		"\u00d7\7,\2\2\u00d7\u00d8\7\5\2\2\u00d8\u00d9\5&\24\2\u00d9\u00da\7\6"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00dd\7,\2\2\u00dc\u00ba\3\2\2\2\u00dc"+
		"\u00bd\3\2\2\2\u00dc\u00bf\3\2\2\2\u00dc\u00c3\3\2\2\2\u00dc\u00c4\3\2"+
		"\2\2\u00dc\u00c5\3\2\2\2\u00dc\u00c6\3\2\2\2\u00dc\u00c7\3\2\2\2\u00dc"+
		"\u00c8\3\2\2\2\u00dc\u00c9\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00db\3\2"+
		"\2\2\u00dd\u00f2\3\2\2\2\u00de\u00df\f\22\2\2\u00df\u00e0\t\3\2\2\u00e0"+
		"\u00f1\5&\24\23\u00e1\u00e2\f\21\2\2\u00e2\u00e3\t\4\2\2\u00e3\u00f1\5"+
		"&\24\22\u00e4\u00e5\f\20\2\2\u00e5\u00e6\t\5\2\2\u00e6\u00f1\5&\24\21"+
		"\u00e7\u00e8\f\17\2\2\u00e8\u00e9\t\6\2\2\u00e9\u00f1\5&\24\20\u00ea\u00eb"+
		"\f\16\2\2\u00eb\u00ec\7\21\2\2\u00ec\u00f1\5&\24\17\u00ed\u00ee\f\r\2"+
		"\2\u00ee\u00ef\7\20\2\2\u00ef\u00f1\5&\24\16\u00f0\u00de\3\2\2\2\u00f0"+
		"\u00e1\3\2\2\2\u00f0\u00e4\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0\u00ea\3\2"+
		"\2\2\u00f0\u00ed\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\'\3\2\2\2\u00f4\u00f2\3\2\2\2\25+;ALR\\dw\u0085\u0090"+
		"\u0094\u0098\u00a5\u00b5\u00d0\u00d3\u00dc\u00f0\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}