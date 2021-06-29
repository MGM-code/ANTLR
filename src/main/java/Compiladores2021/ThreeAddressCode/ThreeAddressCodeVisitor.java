package Compiladores2021.ThreeAddressCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.Trees;

import Compiladores2021.programaBaseVisitor;
import Compiladores2021.programaParser;
import Compiladores2021.programaParser.*;


public class ThreeAddressCodeVisitor extends programaBaseVisitor<String>{
    // Contador labels
    private int countLbl;
    // Contador temporales
    private int countTmp;
    // Concatenaresultado final
    private String result;
    // Almacena temporal anterior
    private String previousTemp;
    // Almacena temporal actual
    private String currentTemp;

    public ThreeAddressCodeVisitor() {
        this.countLbl = 0;
        this.countTmp = 0;
        this.result = "";
        this.previousTemp = "";
        this.currentTemp = "";
    }

    @Override
    public String visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public String visitPrograma(ProgramaContext ctx) {
        if (ctx.asign() != null) {
            List<ParseTree> ruleFactors = findRuleNodes(ctx, programaParser.RULE_factor);
            List<ParseTree> funcs = findRuleNodes(ctx, programaParser.RULE_llamada_funcion);
            if (ruleFactors.size() < 3 && funcs.size() == 0) {
                result += ctx.ID().getText() + " = ";
                lessThanTWo(ruleFactors);
            } else {
                processConjunctions(((programaParser) ctx.asign()).operacion().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }

        }
        return "";
    }

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        if (ctx.asign() != null) {
            List<ParseTree> ruleFactors = findRuleNodes(ctx, programaParser.RULE_factor);
            if (ruleFactors.size() < 3) {
                result += ctx.ID().getText() + " = ";
                lessThanTWo(ruleFactors);
            } else {
                processConjunctions(ctx.asign().operacion().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }
        }
        return "";
    }

    @Override
    public String visitCondif(CondifContext ctx) {
        countLbl++;
        processConjunctions(ctx.operacion().opal());
        result += "ifnot " + currentTemp + ", jmp L" + countLbl + "\n";
        if (ctx.ELSE() == null) {
            visitChildren(ctx);
        } else {
           
            visitBloque((BloqueContext) ctx.getChild(4));

            int aux = countLbl;
            countLbl++;
            result += String.format("jmp L%s\n", countLbl);
            result += String.format("label L%s\n", aux);

           
            visitBloque((BloqueContext) ctx.getChild(6));
        }
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitCiclowhile(CiclowhileContext ctx) {
        countLbl++;
        int aux = countLbl;
        processConjunctions(ctx.operacion().opal());

        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", currentTemp, countLbl);

        visitChildren(ctx);

        result += String.format("jmp L%s\n", aux);
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitBloque(BloqueContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCiclofor(CicloforContext ctx) {
        countLbl++;

        visitAsignacion(ctx.asignacion());

        int aux = countLbl;

        processConjunctions(ctx.operacion().opal());
        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", currentTemp, countLbl);
        visitBloque(ctx.instruccion().bloque());

        result += String.format("%s %s\n", ctx.ID().getText(), ctx.asign().getText());
        result += String.format("jmp L%s\n", aux);
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitFuncion(FuncionContext ctx) {
        result += String.format("func begin %s\n", ctx.ID().getText());
        visitBloque(ctx.bloque());
        result += String.format("%s end\n", ctx.ID().getText());
        return "";
    }

    @Override
    public String visitRetorno(RetornoContext ctx) {
        processConjunctions(ctx.opal());
        result += String.format("return %s\n", currentTemp);
        return "";
    }

    @Override
    public String visitLlamada_funcion(Llamada_funcionContext ctx) {
        if (ctx.argumentos().operacion().opal().getChildCount() > 0) {
            List<ParseTree> args = findRuleNodes(ctx, programaParser.RULE_operacion);
            for (ParseTree a : args) {
                processConjunctions(((OperacionContext) a).opal());
                result += String.format("param %s\n", currentTemp);
            }
            result += String.format("t%d = call %s, %d\n", countTmp, ctx.ID().getText(), args.size());
        } else {
            result += String.format("t%d = call %s\n", countTmp, ctx.ID().getText());
        }
        countTmp++;
        return "";
    }

    private List<ParseTree> findRuleNodes(ParseTree ctx, int ruleIndex) {
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }
    public void getResult() {
        System.out.println(result);
    }

    private void concatTemps(String operation) {
        result += String.format("t%d = %s %s %s \n", countTmp, previousTemp, operation, currentTemp);
        currentTemp = "t" + countTmp;
        countTmp++;
    }

    public void findRuleNodesWithoutOpal(ParseTree t, int index, List<ParseTree> nodes) {
        if (t instanceof ParserRuleContext) {
            ParserRuleContext ctx = (ParserRuleContext) t;
            if (ctx.getRuleIndex() == index) {
                nodes.add(t);
            }
        }
        for (int i = 0; i < t.getChildCount(); i++) {
            if (!(t.getChild(i) instanceof OpalContext)) {
                findRuleNodesWithoutOpal(t.getChild(i), index, nodes);
            }
        }
    }


    public void generateCode() {
        try {
            PrintWriter out;
            out = new PrintWriter("intermediate-code.txt");
            out.println(this.result);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void lessThanTWo(List<ParseTree> ruleFactors){
        for (ParseTree parseTree : ruleFactors) {
            FactorContext fc = ((FactorContext)parseTree);
            if(fc.getParent().getParent() instanceof ExpContext){
                result += fc.getParent().getParent().getChild(0).getText() + " " + fc.getParent().getChild(0).getText() + "\n";
            } else if(fc.getParent() instanceof TerminoContext){
                result += fc.getParent().getChild(0).getText() + " " + fc.getText() + "\n";   
            } else {
                result += fc.getParent().getChild(0).getText() + (ruleFactors.size() == 1 ? "\n" : " ");
            }
        }
    }

    private void processConjunctions(OpalContext ctx) {
        List<ParseTree> conjunctions = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, programaParser.RULE_conjuncion, conjunctions);
        String temp;
        for (int i = 0; i < conjunctions.size(); i++) {
            temp = currentTemp;
            processComparisons((ConjuncionContext) conjunctions.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(conjunctions.get(i).getParent().getChild(0).getText());
            }
        }
    }


    private void processComparisons(ConjuncionContext ctx) {
        List<ParseTree> comparisons = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, programaParser.RULE_comparaciones, comparisons);
        String temp;
        for (int i = 0; i < comparisons.size(); i++) {
            temp = currentTemp;
            processExpressions((ComparacionesContext) comparisons.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(comparisons.get(i).getParent().getChild(0).getText());
            }
        }
    }


    private void processExpressions(ComparacionesContext ctx) {
        List<ParseTree> exps = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, programaParser.RULE_exp, exps);
        String temp;
        for (int i = 0; i < exps.size(); i++) {
            temp = currentTemp;
            processTerms((ExpContext) exps.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(exps.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void generateTempsInTerm(Collection<ParseTree> factors) {
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;
        for(int i=0; i < factorsLocal.size(); i++){
            if(((FactorContext)factorsLocal.get(i)).opal() != null){
                temp = currentTemp;
                processConjunctions(((FactorContext) factorsLocal.get(i)).opal());
                previousTemp = temp;
            } else if(((FactorContext)factorsLocal.get(i)).llamada_funcion() != null){
                temp = currentTemp;
                visitLlamada_funcion((Llamada_funcionContext) ((FactorContext)factorsLocal.get(i)).llamada_funcion());
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1);
            } else {
                previousTemp = currentTemp;
                currentTemp = factorsLocal.get(i).getText();
            }
            if (i > 0) {
                concatTemps(factorsLocal.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void processTerms(ExpContext ctx) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, programaParser.RULE_term, ruleTerms);
        String temp;

        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        for (int i = 0; i < terms.size(); i++) {
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodesWithoutOpal(terms.get(i), programaParser.RULE_factor, factors);

            if (factors.size() > 1) {
                temp = currentTemp;
                generateTempsInTerm(factors);
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1);
            } else {
                previousTemp = currentTemp; 
                if (((TermContext) terms.get(i)).factor().opal() != null) {
                    temp = currentTemp;
                    processConjunctions(((TermContext) terms.get(i)).factor().opal());
                    previousTemp = temp;
                }else if(((TermContext)terms.get(i)).factor().llamada_funcion() != null){
                    temp = currentTemp;
                    visitLlamada_funcion((Llamada_funcionContext) ((TermContext) terms.get(i)).factor().llamada_funcion());
                    previousTemp = temp;
                    currentTemp = "t" + (countTmp - 1);
                }
                else {
                    currentTemp = factors.get(0).getText();
                }
            }
            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }
}