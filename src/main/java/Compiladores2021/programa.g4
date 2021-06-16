grammar programa;

@header {
package Compiladores2021;
}


@members {
    String tipovariable="";
    Funciones funciones= new Funciones();
    String nombreVariable=null;
    Object valor=null;
    String variableAsignada=null;
}


fragment LETRA : [A-Za-z]; //palabras
fragment DIGITO : [0-9]; //numeros
fragment MAYUSCULA : [A-Z];

PA : '(';
PC : ')';
LA : '{';
LC : '}';
CA : '[';
CC : ']';

PYC : ';';
EQ : '=';
COMA : ',';
COMILLA: '"';

INT : 'int ';
CHAR :'char ';
DOUBLE : 'double ';
FLOAT : 'float ';
VOID: 'void ';
RETURN: 'return ';

FOR: 'for';
IF : 'if';
ELSE: 'else';
WHILE: 'while';

SUM: '+';
RESTA: '-';
MULT: '*';
DIV: '/';
RESTO: '%';

//---------Operadores relacionales-------
COMP: ('<'|'>'|'<='|'>='|'!='|'==');            

//---------Operadores logicos------------
LOGIC : ('&'|'&&'|'|');              

INC_DEC: ( '++' | '--'); 


ID : (LETRA | '_')(LETRA | DIGITO | '_')*;
NUMERO : DIGITO+;
FLOTANTE: DIGITO+'.'DIGITO+;
LETRAMAYUSCULA : MAYUSCULA;


HORA: (('0'[0-2] | '1'[0-9] | '2'[0-3])':'([0-5][0-9]));
FECHA: (('0'[1-9] | '1'[0-9] | '2'[0-9]| '30')'/'(('0'[1-9]) | ('1'[1-2]))'/'([0-9][0-9][0-9][0-9])) ;
EMAIL : (ID | [A-z]) '@' ID '.com';
COMENTARIO : ('/*'(LETRA*DIGITO*)'*/');


WS : [ \n\t\r] -> skip; 

OTRO : . ; 

prog : instrucciones+
     ;

instrucciones: (operacion | estructuras)
             ;

operacion : declaracion PYC
          | ID asignacion PYC { funciones.asignacion($ID.getText(),null,tipovariable); } 
          | RETURN ID PYC
          ;

declaracion : tipodato ID asignacion { funciones.agregarVarialble($ID.getText(),tipovariable); funciones.asignacion($ID.getText(),valor,null); }
            | tipodato ID { funciones.agregarVarialble($ID.getText(),tipovariable); }
            ;

tipodato : INT {tipovariable="int";}
         | DOUBLE {tipovariable="double";}
         | FLOAT {tipovariable="float";}
         | CHAR {tipovariable="char";}
         ;

tipoaritmetica : SUM
               | RESTA
               | MULT
               | DIV
               | RESTO
               ;

tipologica : COMP 
           | LOGIC
           ;

asignacion : EQ valor 
           | EQ ID { tipovariable=funciones.getTipo($ID.getText()); }
           | EQ op_aritmetica
           | INC_DEC
           ;


valor: NUMERO  { valor = Integer.parseInt($NUMERO.getText());}
     | FLOTANTE { valor = Float.parseFloat($FLOTANTE.getText());}
     | COMILLA ID COMILLA { valor = $ID.getText(); } //Se toma "ID" como una palabra
     | ID { valor = Integer.parseInt($ID.getText());}
     | llamada_funcion
     ;

op_aritmetica : (valor tipoaritmetica)+ valor
              ;
              
op_logica : (valor tipologica)+ valor
          ;

tipo_funcion : tipodato
             | VOID {tipovariable="void";}
             ;

dec_funcion : tipo_funcion ID PA PC bloque_instruccion 
            | tipo_funcion ID PA (dec_parametros) PC bloque_instruccion 
            ;

llamada_funcion :  ID PA PC { tipovariable=funciones.getTipo($ID.getText()); }
                |  ID PA (dec_parametros) PC { tipovariable=funciones.getTipo($ID.getText()); }
                ;

dec_parametros : (tipodato ID COMA)* tipodato ID
               ;

estructuras : ciclo_for
            | ciclo_while
            | condicion_if
            | dec_funcion
            ;

ciclo_for : FOR PA declaracion PYC op_logica PYC ID asignacion PC bloque_instruccion
          ;

bloque_instruccion: LA (instrucciones)+ LC
                  ;


ciclo_while : WHILE PA op_logica PC bloque_instruccion
            ;

condicion_if : IF PA op_logica PC bloque_instruccion
             | IF PA op_logica PC bloque_instruccion ELSE bloque_instruccion
             ;