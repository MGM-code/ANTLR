package Compiladores2021.TablaSimbolos;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;

import Compiladores2021.Errores.CustomErrores;

/**
 * Personalizamos los errores de ANTLR para poder hacer un 
 * "pretty printer" de los mismo e indicar que son Sintacticos y en 
 * que posicion se encuentra
 */

public class ErroresListener extends BaseErrorListener {
    
    private Compiladores2021.Errores.CustomErrores CustomErrores;

    public ErroresListener() {
        this.CustomErrores = new CustomErrores();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        String position = "[" + line + ":" + charPositionInLine + "]";
        CustomErrores.syntacticError(position, msg);
    }

}
