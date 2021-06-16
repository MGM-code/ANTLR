package Compiladores2021;

import java.util.HashMap;

public class Funciones
{
    HashMap<String, String> variables;
    
    public Funciones() {
        this.variables = new HashMap<String, String>();
    }
    
    public void agregarVarialble(final String nombre, final String tipovariable) {
        if (this.variables.get(nombre) == null) {
            this.variables.put(nombre, tipovariable);
        }
        else {
            System.out.println(" Variable " + nombre + " duplicada.");
            System.exit(1);
        }
    }
    
    public void asignacion(final String nombre, Object valor, final String tipoVariable) {
        boolean correcto = false;
        if (tipoVariable == null) {
            if (this.variables.get(nombre) == null) {
                System.out.println(" Variable " + nombre + " inexistente.");
                System.exit(1);
            }
            else {
                final String tipo = this.variables.get(nombre);
                if (valor.getClass() == Integer.class && tipo == "int") {
                    correcto = true;
                }
                else if (valor.getClass() == String.class && tipo == "char") {
                    correcto = true;
                }
                else if ((valor.getClass() == Float.class | valor.getClass() == Double.class) && (tipo == "double" | tipo == "float")) {
                    correcto = true;
                }
            }
        }
        else if (this.variables.get(nombre) == tipoVariable) {
            correcto = true;
        }
        else {
            valor = this.variables.get(nombre);
        }
        if (!correcto) {
            System.out.println(" Asignacion incorrecta de " + nombre + " a tipo " + valor.getClass().toString().substring(16));
            System.exit(1);
        }
    }
    
    public String getTipo(final String nombreVariable) {
        String tipo = null;
        if (this.variables.get(nombreVariable) == null) {
            System.out.println(" Variable " + nombreVariable + " inexistente.");
            System.exit(1);
        }
        else {
            tipo = this.variables.get(nombreVariable);
        }
        return tipo;
    }
}