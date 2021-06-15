
package app;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link programaPaser}.
 */
public interface programaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link programaPaser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(programaPaser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(programaPaser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(programaPaser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(programaPaser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(programaPaser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(programaPaser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#balance}.
	 * @param ctx the parse tree
	 */
	void enterBalance(programaPaser.BalanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#balance}.
	 * @param ctx the parse tree
	 */
	void exitBalance(programaPaser.BalanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(programaPaser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(programaPaser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_funcion(programaPaser.Declaracion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#declaracion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_funcion(programaPaser.Declaracion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#retornar}.
	 * @param ctx the parse tree
	 */
	void enterRetornar(programaPaser.RetornarContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#retornar}.
	 * @param ctx the parse tree
	 */
	void exitRetornar(programaPaser.RetornarContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#param_declaracion}.
	 * @param ctx the parse tree
	 */
	void enterParam_declaracion(programaPaser.Param_declaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#param_declaracion}.
	 * @param ctx the parse tree
	 */
	void exitParam_declaracion(programaPaser.Param_declaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_funcion(programaPaser.Definicion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_funcion(programaPaser.Definicion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#param_definicion}.
	 * @param ctx the parse tree
	 */
	void enterParam_definicion(programaPaser.Param_definicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#param_definicion}.
	 * @param ctx the parse tree
	 */
	void exitParam_definicion(programaPaser.Param_definicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(programaPaser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(programaPaser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(programaPaser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(programaPaser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#tipodato}.
	 * @param ctx the parse tree
	 */
	void enterTipodato(programaPaser.TipodatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#tipodato}.
	 * @param ctx the parse tree
	 */
	void exitTipodato(programaPaser.TipodatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(programaPaser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(programaPaser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(programaPaser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(programaPaser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(programaPaser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(programaPaser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(programaPaser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(programaPaser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#iteracion}.
	 * @param ctx the parse tree
	 */
	void enterIteracion(programaPaser.IteracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#iteracion}.
	 * @param ctx the parse tree
	 */
	void exitIteracion(programaPaser.IteracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(programaPaser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(programaPaser.OperacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(programaPaser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(programaPaser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(programaPaser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(programaPaser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(programaPaser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(programaPaser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(programaPaser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(programaPaser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(programaPaser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(programaPaser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(programaPaser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(programaPaser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#igualdad}.
	 * @param ctx the parse tree
	 */
	void enterIgualdad(programaPaser.IgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#igualdad}.
	 * @param ctx the parse tree
	 */
	void exitIgualdad(programaPaser.IgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void enterComparaciones(programaPaser.ComparacionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void exitComparaciones(programaPaser.ComparacionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void enterConjuncion(programaPaser.ConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void exitConjuncion(programaPaser.ConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void enterDisyuncion(programaPaser.DisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void exitDisyuncion(programaPaser.DisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaPaser#opal}.
	 * @param ctx the parse tree
	 */
	void enterOpal(programaPaser.OpalContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaPaser#opal}.
	 * @param ctx the parse tree
	 */
	void exitOpal(programaPaser.OpalContext ctx);
}