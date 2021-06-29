package Compiladores2021.TablaSimbolos;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class TablaDeSimbolos {
    private LinkedList<HashMap<String, Id>> tablaDeSimbolos;


    public TablaDeSimbolos() {
        tablaDeSimbolos = new LinkedList<HashMap<String, Id>>();
    }

   
    public void enterContext() {
        HashMap<String, Id> contexto = new HashMap<String, Id>();
        this.tablaDeSimbolos.add(contexto);
    }

    
    public void exitContext() {
        this.tablaDeSimbolos.removeLast();
    }

    public ArrayList<String> unusedIDs() {
        ArrayList<String> variablesSinUso = new ArrayList<String>();
        for (Entry<String, Id> entry : tablaDeSimbolos.getLast().entrySet()) {
            if(!entry.getValue().isUtilizado() && !entry.getValue().getTokenNombre().equals("main")){
                if (entry.getValue() instanceof Funcion && !entry.getValue().isInicializado()) {
                    continue;
                }else{
                    variablesSinUso.add(entry.getKey()); 
                }
            }
        }
        return variablesSinUso;
    }


    public void insert(String name, Id symbol){
        this.tablaDeSimbolos.getLast().put(name, symbol);
    }

    public Id lookup(String id){
        Id symbol = lookupLocal(id);
        if(symbol != null){
            return symbol;
        }else{
            ListIterator<HashMap<String, Id>> symbolsIterator = this.tablaDeSimbolos.listIterator(tablaDeSimbolos.size() - 1);
            while(symbolsIterator.hasPrevious()){
                symbol = symbolsIterator.previous().get(id);
                if( symbol != null ){
                    return symbol;
                }
            }
        }

        return symbol;
    }

    public Id lookupLocal(String id){
        Id symbol = tablaDeSimbolos.getLast().get(id);
        if(symbol != null){
            return symbol;
        }
        return null;
    }
    
    
    public LinkedList<HashMap<String, Id>> getTablaDeSimbolos() {
        return tablaDeSimbolos;
    }

    @Override
    public String toString() {
        return tablaDeSimbolos.toString();
    }
    
}