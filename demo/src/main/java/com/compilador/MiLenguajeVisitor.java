// Generated from com/compilador/MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiLenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodigo(MiLenguajeParser.CodigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(MiLenguajeParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declSimple}
	 * labeled alternative in {@link MiLenguajeParser#declVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclSimple(MiLenguajeParser.DeclSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link MiLenguajeParser#declVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArreglo(MiLenguajeParser.DeclArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#defFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFuncion(MiLenguajeParser.DefFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#listaParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParams(MiLenguajeParser.ListaParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MiLenguajeParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(MiLenguajeParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(MiLenguajeParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asigSimple}
	 * labeled alternative in {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigSimple(MiLenguajeParser.AsigSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asigArreglo}
	 * labeled alternative in {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigArreglo(MiLenguajeParser.AsigArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#imprimir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprimir(MiLenguajeParser.ImprimirContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(MiLenguajeParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#bucleWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucleWhile(MiLenguajeParser.BucleWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#bucleFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucleFor(MiLenguajeParser.BucleForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicForDecl}
	 * labeled alternative in {@link MiLenguajeParser#inicFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicForDecl(MiLenguajeParser.InicForDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicForAsig}
	 * labeled alternative in {@link MiLenguajeParser#inicFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicForAsig(MiLenguajeParser.InicForAsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#actualizFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualizFor(MiLenguajeParser.ActualizForContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#salirBucle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalirBucle(MiLenguajeParser.SalirBucleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#continuarBucle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuarBucle(MiLenguajeParser.ContinuarBucleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litEntero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitEntero(MiLenguajeParser.LitEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litDecimal}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitDecimal(MiLenguajeParser.LitDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litVerdadero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitVerdadero(MiLenguajeParser.LitVerdaderoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litCadena}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitCadena(MiLenguajeParser.LitCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accesoArreglo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccesoArreglo(MiLenguajeParser.AccesoArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litFalso}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitFalso(MiLenguajeParser.LitFalsoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(MiLenguajeParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNegativo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code llamadaFuncion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(MiLenguajeParser.LlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litCaracter}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitCaracter(MiLenguajeParser.LitCaracterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNegacion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegacion(MiLenguajeParser.ExprNegacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MiLenguajeParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(MiLenguajeParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGrupo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGrupo(MiLenguajeParser.ExprGrupoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx);
}