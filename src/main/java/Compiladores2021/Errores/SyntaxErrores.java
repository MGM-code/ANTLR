package Compiladores2021.Errores;

public class SyntaxErrores {

    private int line;
    private int charPosition;
    private String token;

    public SyntaxErrores(int line, int charPosition, String token){
        this.line = line;
        this.charPosition = charPosition;
        this.token = token;
    }

    @Override
    public String toString() {
        return "[" + line + ":" + charPosition + "] - " + token;
    }
}
