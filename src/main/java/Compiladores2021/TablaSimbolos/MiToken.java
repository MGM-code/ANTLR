package Compiladores2021.TablaSimbolos;

import org.antlr.runtime.CommonToken;

import org.antlr.runtime.CommonToken;

public class MiToken extends CommonToken{

    private static final long serialVersionUID = 1L;
    public String srcName;

    public MiToken(int type, String text) {
        //TODO Auto-generated constructor stub
        super(type, text);
    }
    
    @Override
    public String toString() {
        String t = super.toString();
        return srcName + ":" + t;
    }

}
