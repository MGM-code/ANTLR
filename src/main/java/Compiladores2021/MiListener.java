package Compiladores2021;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.Trees;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.ParseTree;

import Compiladores2021.programaParser.*;
import Compiladores2021.Errores.CustomErrores;

import Compiladores2021.TablaSimbolos.MiToken;
import Compiladores2021.TablaSimbolos.Funcion;
import Compiladores2021.TablaSimbolos.Id;
import Compiladores2021.TablaSimbolos.Variable;
import Compiladores2021.TablaSimbolos.TablaDeSimbolos;

public class MiListener extends programaBaseListener {

    private TablaDeSimbolos simbolos = new TablaDeSimbolos();
    private CustomErrores errors = new CustomErrores();

    /*****************************************************************
     *************************Private Methods*************************
     *****************************************************************/

    private String positionToken(Token token){
        return "[" + token.getLine() + ":" + token.getCharPositionInLine() + "]";
    }

    private boolean isSameDataType(String dataType, String dataTypeFactor) {
        if (dataType.equals(dataTypeFactor))
            return true;
        else
            return false;
    }

    private String getStringType(int type) {
        switch (type) {
            case programaLexer.ENTERO:
                return "int";
            case programaLexer.DECIMAL:
                return "double";
            case programaLexer.CARACTER:
                return "char";
            default:
                return null;
        }
    }

    private Id getID(String id) { return simbolos.lookup(id); }

    private Id getIDLocal(String id){ return simbolos.lookupLocal(id); }

    private boolean isFunction(Id id){ return id instanceof Funcion; }

    /* Buscar factores, ecxepto argumentos de la funcion */
    private Collection<ParseTree> findFactorsWithoutArguments(ParseTree ctx){
        Collection<ParseTree> factors = Trees.findAllRuleNodes(ctx, programaParser.RULE_factor);
        Collection<ParseTree> callsFunction = Trees.findAllRuleNodes(ctx, programaParser.RULE_llamada_funcion);
        Collection<ParseTree> factorsCallFunction;
        for (ParseTree parseTree : callsFunction) {
            factorsCallFunction = Trees.findAllRuleNodes(parseTree, programaParser.RULE_factor);
            factors.removeAll(factorsCallFunction);
        }
        return factors;
    }
    
    /* Verificar que no existan parametros iguales en la definicion o declaracion de una funcion */
    private boolean containsParameter(List<Variable> parameters, String nameVar){
        return parameters.stream()
                         .filter(param -> param.getTokenNombre().equals(nameVar))
                         .findFirst()
                         .isPresent();
    }

    /* Obtener parametros de una funcion */
    private List<Variable> getParameters(ParametrosContext ctx){
        List<Variable> params = new ArrayList<Variable>();
        Collection<ParseTree> parameters = Trees.findAllRuleNodes(ctx, programaParser.RULE_declaracion);
        for (ParseTree parseTree : parameters) {
            DeclaracionContext decl = (DeclaracionContext)parseTree;
            if(containsParameter(params, decl.ID().getText())){
                errors.idRedefined(positionToken(ctx.getStart()), decl.ID().getText());
                return null;
            }
            Variable var = new Variable(true, false, decl.tipodato().getText(), decl.ID().getText());
            params.add(var);
        }
        return params;
    }

    /* Analizar cada factor de una operacion */
    private boolean processFactors(Id caller, String dataType, Collection<ParseTree> factors) {
        FactorContext fc;
        boolean error = true;
        for (ParseTree parseTree : factors) {
            fc = (FactorContext) parseTree;
            
            if (fc.ID() != null){
                String idFactor = fc.ID().getText();
                Id id = getID(idFactor);
                if (id == null){
                    errors.idNotDeclared(positionToken(fc.getStart()), idFactor);
                    error = false;
                }else if(!id.isInicializado()){
                    errors.idNotInitialized(positionToken(fc.getStart()), idFactor);
                    error = false;
                }else{
                    id.setUtilizado(true);
                    if (dataType != null  && !isSameDataType(dataType, id.getTipoDato())){
                        if(isFunction(caller))
                            errors.idDifferentsTypesParamArgs(positionToken(fc.getStart()), id.getTipoDato(), dataType, id.getTokenNombre());
                        else
                            errors.idDifferentsTypes(positionToken(fc.getStart()), id.getTipoDato(), dataType);
                    }
                }
            } else if(fc.llamada_funcion() != null){
                processCallfunction(dataType, fc.llamada_funcion());
            } else if (fc.ENTERO() != null || fc.DECIMAL() != null || fc.CARACTER() != null) {
                if (dataType != null  && !isSameDataType(dataType, getStringType(fc.getStop().getType()))){
                    if(isFunction(caller))
                        errors.idDifferentsTypesParamArgs(positionToken(fc.getStart()), getStringType(fc.getStop().getType()), dataType, fc.getText());
                    else
                        errors.idDifferentsTypes(positionToken(fc.getStart()), getStringType(fc.getStop().getType()), dataType);
                }
            }
        }
        return error;
    }

    /* Procesar instruccion asignacion */
    private void processAssignment(AsignacionContext ctx) {
        Id id = getID(ctx.ID().getText());
        if (id != null) {
            Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
            if(processFactors(null, id.getTipoDato(), factors))
                id.setInicializado(true);
        } else
            errors.idNotDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
    }

    /* Procesar instruccion declaracion */
    private void processDeclaration(DeclaracionContext ctx) {
        Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
        if (getIDLocal(ctx.ID().getText()) == null) {
            Id id = new Variable(false, false, ctx.tipodato().getText(), ctx.ID().getText());
            simbolos.insert(ctx.ID().getText(), id);
            if (ctx.asign() != null) {
                if(processFactors(null, ctx.tipodato().getText(), factors))
                    id.setInicializado(true);
            }
        } else{
            processFactors(null, ctx.tipodato().getText(), factors);
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }
    }

    /* Procesar declaracion de funcion */
    private Id processFunction(FuncionContext ctx){
        Id id = getIDLocal(ctx.ID().getText());
        if(id == null){
            List<Variable> parameteros = getParameters(ctx.parametros());
            if(parameteros != null){
                Id idFunction = new Funcion(true, false, ctx.tipodato().getText(), ctx.ID().getText(), parameteros);
                simbolos.insert(ctx.ID().getText(), idFunction);
                return idFunction;
            }
        }else if(!isFunction(id)){
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }else if(isFunction(id) && id.isInicializado()){
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }else if(isFunction(id) && !id.isInicializado()){
            if(!((Funcion)id).areParametersEquals(getParameters(ctx.parametros())))
                errors.orderPrototype(positionToken(ctx.getStart()));
            else
                id.setInicializado(true);
                return id;
        }
        return null;
    }

    /* Procesar llamada a funcion */
    private void processCallfunction(String dataType, Object object){
        Id id = getID(((DeclaracionContext) object).ID().getText());
        Collection<ParseTree> operations = Trees.findAllRuleNodes((ParseTree) object, programaParser.RULE_operacion);
        Object[] oper = operations.toArray();
        Collection<ParseTree> factorCountFirstOperation = Trees.findAllRuleNodes((ParseTree)oper[0], programaParser.RULE_factor);

        if(id == null)
            errors.idNotDeclared(positionToken(((ParserRuleContext) object).getStart()), ((DeclaracionContext) object).ID().getText());
        else if(isFunction(id) && id.isInicializado()){
            List<Variable> parameters = ((Funcion)id).getParametros();
            Collection<ParseTree> factors;

            if(dataType != null && id.getTipoDato().equals("void"))
                errors.functionVoid(positionToken(((ParserRuleContext) object).getStart()), id.getTokenNombre());
            else if(factorCountFirstOperation.size() > 0 && ((Funcion)id).getParametros().size() != operations.size()){
                errors.numberParamsArgs(positionToken(((ParserRuleContext) object).getStart()));
            }
            else if(dataType != null && !isSameDataType(dataType, id.getTipoDato()))
                errors.idDifferentsTypes(positionToken(((ParserRuleContext) object).getStart()), id.getTipoDato(), dataType);
            
            id.setUtilizado(true);
            for(int i=0; i < parameters.size();  i++){
                if(i > (operations.size() - 1)) { break; }
                factors = Trees.findAllRuleNodes((ParseTree)oper[i], programaParser.RULE_factor);
                processFactors(id, parameters.get(i).getTipoDato(), factors);
            }
        }else if(isFunction(id) && !id.isInicializado()){
            errors.functionNotDeclared(positionToken(((ParserRuleContext) object).getStart()), id.getTokenNombre());
        }else if(!isFunction(id))
            errors.declaredAsVariable(positionToken(((ParserRuleContext) object).getStart()), id.getTokenNombre());
    }

    /* Procesar instruccion return o validar su omision */
    private void processReturn(FuncionContext ctx){
        Collection<ParseTree> returns = Trees.findAllRuleNodes(ctx, programaParser.RULE_retorno);
        if(ctx.tipodato().getText().equals("void") && returns.size() != 0)
            errors.returnVoidFunction(positionToken(((RetornoContext)(returns.toArray()[0])).getStart()));
        else if(!ctx.tipodato().getText().equals("void") && !ctx.ID().getText().equals("main") && returns.size() == 0)
            errors.notReturn(positionToken(ctx.getStart()));
        else if(!ctx.tipodato().getText().equals("void") && returns.size() > 0){
            ParseTree ret = (ParseTree)(returns.toArray()[0]);
            Collection<ParseTree> factors = findFactorsWithoutArguments(ret);
            processFactors(null, ctx.tipodato().getText(), factors);
        }
    }

    /*****************************************************************
     ************************Override Methods*************************
     *****************************************************************/

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        simbolos.enterContext();
    }

    @Override
    public void exitPrograma(programaParser.ProgramaContext ctx) {
        errors.idNotUsed(simbolos.unusedIDs());
        simbolos.exitContext();
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        processAssignment(ctx);
    }

    @Override 
    public void exitOperacion(OperacionContext ctx) { 
        if( !(ctx.getParent() instanceof AsignContext) &&
                !(ctx.getParent() instanceof ArgumentosContext) &&
                !(ctx.getParent() instanceof AsignContext)){
            Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
            processFactors(null, null, factors);
        }
    }

    @Override 
    public void exitPrototype(PrototypeContext ctx) { 
        if(simbolos.getTablaDeSimbolos().size() == 1){
            Id id = getID(ctx.ID().getText()); 
            if(id == null){
                List<Variable> parameters = getParameters(ctx.parameters());
                if(parameters != null){
                    Id prototype = new Funcion(false, false, ctx.datatype().getText(), ctx.ID().getText(), parameters);
                    simbolos.insert(ctx.ID().getText(), prototype);
                }
            }else{
                errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
            }
        }else{
            errors.prototypeCtxGlobal(positionToken(ctx.getStart()));
        }
    }

    @Override 
    public void enterBloque(BloqueContext ctx) { 
        if(ctx.getParent() instanceof FuncionContext){
            FuncionContext funcionContext = (FuncionContext)ctx.getParent();
            Id id = processFunction(funcionContext);
            simbolos.enterContext();
            if(id != null)
                ((Funcion)id).getParametros().stream().forEach(param -> simbolos.insert(param.getTokenNombre(), param));
            else
                getParameters(funcionContext.parametros()).stream().forEach(param -> simbolos.insert(param.getTokenNombre(), param));
        }else
            simbolos.enterContext();
    }

    @Override 
    public void exitBloque(BloqueContext ctx) {
        if(ctx.getParent() instanceof FuncionContext)
            processReturn((FuncionContext)ctx.getParent());
        errors.idNotUsed(simbolos.unusedIDs());
        simbolos.exitContext();
    }

    @Override 
    public void exitLlamada_funcion(Llamada_funcionContext ctx) {
        if(ctx.getParent() instanceof InstruccionContext){
            Id id = getID(ctx.ID().getText());
            if(id != null){
                getID(ctx.ID().getText()).setUtilizado(true);
                processCallfunction(null, ctx);
            }
        }
    }

    @Override 
    public void exitInstruccion(InstruccionContext ctx) { 
        if(ctx.declaracion() != null)
            processDeclaration(ctx.declaracion());
        //System.out.println(simbolos);
    } 

    // @Override
    // public void exitDeclaration(DeclarationContext ctx) {
    //     if(!ctx.getStop().getText().equals(";")){
    //         MyToken token = new MyToken(reglasLexer.PYC, ";");

    //         ctx.addErrorNode(new ErrorNodeImpl((Token) token));


    //     }
    // }

    // @Override
    // public void visitErrorNode(ErrorNode node) {
    //     System.out.println("ERROR -> " + node.getText());
    //     super.visitErrorNode(node);
    // }
}