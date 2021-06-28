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
fragment DIGITO : [0-9]; //ENTEROs
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

MEN  : '<' ;  
MENEQ: '<=';  
EQL  : '==';  
MAY  : '>' ;  
MAYEQ: '>=';  
DST  : '!=';  

OR   : '||' ;  
AND  : '&&' ;  
NOT  : '!'  ;  

INC_DEC: ( '++' | '--'); 


ID : (LETRA | '_')(LETRA | DIGITO | '_')*;
ENTERO : DIGITO+;
DECIMAL: ENTERO'.'ENTERO;
CARACTER: '\''LETRA'\'';
LETRAMAYUSCULA : MAYUSCULA;


WS : [ \n\t\r] -> skip; 

OTRO : . ; 

programa: instrucciones ; 

instrucciones : instruccion instrucciones 
              |
              ;

bloque : LA instrucciones LC 
       ;

instruccion : declaracion PYC
            | asignacion PYC
            | ciclofor
            | ciclowhile
            | condif
            | funcion
            | llamada_funcion PYC
            | bloque
            ;

retorno : RETURN opal;

declaracion : tipodato ID
            | tipodato ID asign
            ;

asign : EQ llamada_funcion
      | EQ operacion
      ;

tipodato : INT
         | CHAR
         | DOUBLE
         | VOID
         ;

asignacion  : ID asign
            ;

ciclofor : FOR PA asignacion PYC operacion PYC ID asign PC instruccion
         ;

ciclowhile : WHILE PA operacion PC instruccion
           ;

condif : IF PA operacion PC instruccion
       | IF PA operacion PC instruccion ELSE instruccion
       ;

funcion : tipodato ID PA parametros PC bloque
        ;

parametros :  declaracion parametros
           |  COMA parametros
           |
           ;

llamada_funcion : ID PA argumentos PC
                ;

argumentos: ID argumentos
          | COMA argumentos
          |
          ;

operacion : opal ;

opal : disyuncion 
     |
     ;

disyuncion : conjuncion disy
           ;

disy : OR conjuncion disy
     |
     ;

conjuncion : comparaciones conj
           ;

conj : AND comparaciones conj
     |
     ;

comparaciones : expresion comp
              ;

comp : opcomp expresion comp
     |
     ;

opcomp : EQL
       | DST
       | MAY
       | MAYEQ
       | MEN
       | MENEQ
       ;

expresion : termino exp;

exp : SUM termino exp
    | RESTA termino exp
    |
    ;

termino : factor term ;

term : MULT factor term
     | DIV factor term
     | RESTO factor term
     |
     ;

factor : f PA opal PC
       | f ENTERO
       | f DECIMAL
       | f CARACTER
       | f ID
       ;

f : SUM
  | RESTA
  | NOT
  |
  ;
