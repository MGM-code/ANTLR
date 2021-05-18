grammar programa;

@header {
package Compiladores2021;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;


//Llaves y parentesis
LLAVEA : '{' ;
LLAVEC : '}' ;
PARA : '(' ;
PARC : ')' ;

//Operaciones
MAS : '+' ;
MENOS : '-' ;
MULT: '*' ;
DIV : '/' ;
MOD  : '%' ;

//Asignación
ASIGN : '=' ;

// Comparaciones 
MAY  : '>' ;
MAYEQ: '>=';
MEN  : '<' ;
MENEQ: '<=';
EQL  : '==';
DST  : '!=';

// Operaciones logicas
OR   : '||' ;
AND  : '&&' ;
NOT  : '!'  ;

// Cierre
PYC : ';' ;

// Tipos de datos
INT     : 'int' ;
CHAR    : 'char' ;
DOUBLE  : 'double' ;
VOID    : 'void' ;

// Bucles
WHILE : 'while' ;
FOR  : 'for';

// Condición
IF   : 'if' ;
ELSE : 'else' ;

// Numeros
ENTERO : DIGITO+;
DECIMAL : ENTERO'.'ENTERO;

// Variables
ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;

// Otros
WS : [ \n\t\r]+ -> skip;
OTRO : . ;

// Programa
programa : { System.out.println("\n\n -->INICIO<--"); } instrucciones  { System.out.println("\n\n -->FIN<--"); } ;


// Instrucciones 
instrucciones : instruccion instrucciones
              | bloque instrucciones
              |
              ;

bloque : LLAVEA instrucciones LLAVEC ;

instruccion : declaracion PYC
            | asignacion PYC
           // | ciclofor
           // | ciclowhile
           // | condif
           // | funcion
           // | llamada_funcion PYC
            | bloque
            ;

asignacion : ID ASIGN opal ;

declaracion : tipodato ID
            | tipodato ID asignacion
            ;

opal : exp ;

exp : term e ;

e : MAS   term e
  | MENOS term e
  |
  ;

term : factor t;

t : MULT factor t
  | DIV  factor t
  |
  ;

factor : ID
       | ENTERO
       | PARA exp PARC
       ;

tipodato : INT
         | CHAR
         | DOUBLE
         | VOID
         ;


// declaracion -> int x;
//                double y;
//                int z = 0;
//                double w, q, t;
//                int a = 5, b, c = 10;

// asignacion -> x = 1;
//               z = y;

// iwhile -> while (x comp y) { instrucciones }
