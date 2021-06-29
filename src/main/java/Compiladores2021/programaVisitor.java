// Generated from d:\Usuarios\Nicolas\Escritorio\REPO\ANTLR\src\main\java\Compiladores2021\programa.g4 by ANTLR 4.8

package Compiladores2021;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link programaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface programaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link programaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(programaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(programaParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(programaParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(programaParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(programaParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(programaParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#asign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsign(programaParser.AsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#tipodato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipodato(programaParser.TipodatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(programaParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#ciclofor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclofor(programaParser.CicloforContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#ciclowhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiclowhile(programaParser.CiclowhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#condif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondif(programaParser.CondifContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(programaParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(programaParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#llamada_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_funcion(programaParser.Llamada_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(programaParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#operacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacion(programaParser.OperacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#opal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpal(programaParser.OpalContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#disyuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisyuncion(programaParser.DisyuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#disy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisy(programaParser.DisyContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#conjuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjuncion(programaParser.ConjuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#conj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConj(programaParser.ConjContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#comparaciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparaciones(programaParser.ComparacionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(programaParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#opcomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcomp(programaParser.OpcompContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(programaParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(programaParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(programaParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(programaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(programaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(programaParser.FContext ctx);
}