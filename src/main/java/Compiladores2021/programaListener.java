// Generated from d:\Usuarios\Nicolas\Escritorio\REPO\ANTLR\src\main\java\Compiladores2021\programa.g4 by ANTLR 4.8

package Compiladores2021;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link programaParser}.
 */
public interface programaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link programaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(programaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(programaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(programaParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(programaParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(programaParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(programaParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(programaParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(programaParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(programaParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(programaParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(programaParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(programaParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(programaParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(programaParser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#tipodato}.
	 * @param ctx the parse tree
	 */
	void enterTipodato(programaParser.TipodatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#tipodato}.
	 * @param ctx the parse tree
	 */
	void exitTipodato(programaParser.TipodatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(programaParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(programaParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#ciclofor}.
	 * @param ctx the parse tree
	 */
	void enterCiclofor(programaParser.CicloforContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#ciclofor}.
	 * @param ctx the parse tree
	 */
	void exitCiclofor(programaParser.CicloforContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#ciclowhile}.
	 * @param ctx the parse tree
	 */
	void enterCiclowhile(programaParser.CiclowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#ciclowhile}.
	 * @param ctx the parse tree
	 */
	void exitCiclowhile(programaParser.CiclowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#condif}.
	 * @param ctx the parse tree
	 */
	void enterCondif(programaParser.CondifContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#condif}.
	 * @param ctx the parse tree
	 */
	void exitCondif(programaParser.CondifContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(programaParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(programaParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(programaParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(programaParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_funcion(programaParser.Llamada_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_funcion(programaParser.Llamada_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(programaParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(programaParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(programaParser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(programaParser.OperacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#opal}.
	 * @param ctx the parse tree
	 */
	void enterOpal(programaParser.OpalContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#opal}.
	 * @param ctx the parse tree
	 */
	void exitOpal(programaParser.OpalContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void enterDisyuncion(programaParser.DisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#disyuncion}.
	 * @param ctx the parse tree
	 */
	void exitDisyuncion(programaParser.DisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#disy}.
	 * @param ctx the parse tree
	 */
	void enterDisy(programaParser.DisyContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#disy}.
	 * @param ctx the parse tree
	 */
	void exitDisy(programaParser.DisyContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void enterConjuncion(programaParser.ConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#conjuncion}.
	 * @param ctx the parse tree
	 */
	void exitConjuncion(programaParser.ConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#conj}.
	 * @param ctx the parse tree
	 */
	void enterConj(programaParser.ConjContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#conj}.
	 * @param ctx the parse tree
	 */
	void exitConj(programaParser.ConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void enterComparaciones(programaParser.ComparacionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#comparaciones}.
	 * @param ctx the parse tree
	 */
	void exitComparaciones(programaParser.ComparacionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(programaParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(programaParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#opcomp}.
	 * @param ctx the parse tree
	 */
	void enterOpcomp(programaParser.OpcompContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#opcomp}.
	 * @param ctx the parse tree
	 */
	void exitOpcomp(programaParser.OpcompContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(programaParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(programaParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(programaParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(programaParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(programaParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(programaParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(programaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(programaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(programaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(programaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link programaParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(programaParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link programaParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(programaParser.FContext ctx);
}