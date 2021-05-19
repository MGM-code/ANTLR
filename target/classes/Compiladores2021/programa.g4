grammar programa;

//@header {
//package Compiladores2021;
//}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;


//Llaves y parentesis
LLAVEA : '{' ;
LLAVEC : '}' ;
PARA : '(' ;
PARC : ')' ;

//Operaciones
MAS : '+' ;
INCR : '++';
MENOS : '-' ;
DECR : '--';
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
RETURN : 'return';

// Cierre
PYC : ';' ;
COMA : ',' ;

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
CARACTER: '\''LETRA'\'';

// Variables
ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;

// Otros
WS : [ \n\t\r]+ -> skip;
OTRO : . ;

// Programa
programa : { System.out.println("\n\n -->INICIO<--"); } instruccion  { System.out.println("\n\n -->FIN<--"); } ;


// Instrucciones 
instrucciones : instruccion instrucciones
              //| bloque instrucciones
              |
              ;

bloque : LLAVEA instrucciones LLAVEC ;

instruccion : declaracion PYC
            | asignacion PYC
            | ciclowhile
            | ciclofor
            | condif
            | declaracion_funcion PYC
            | funcion
            | llamada_funcion PYC
            | bloque
           // | opal PYC
            ;

asignacion : ID ASIGN opal ;

declaracion : tipodato ID
            | tipodato ID asignacion
            ;

opal : exp ;

exp : term e ;

e : MAS term e
  | MENOS term e
  | MEN term e
  | INCR 
  | DECR
  | MENEQ term e
  | MAYEQ term e
  | EQL term e
  | DST term e
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

// Bucles
ciclofor : FOR PARA tipodato asignacion PYC opal PYC opal e PARC instrucciones
         ;

ciclowhile : WHILE PARA opal e PARC instrucciones
           ;

// Sentencia if else
condif : IF PARA opal e PARC instrucciones
       | IF PARA opal e PARC instruccion ELSE instruccion
       ;

// Funciones
funcion : tipodato ID PARA parametros PARC bloque
        ;

parametros :  declaracion parametros
           |  COMA parametros
           |
           ;

prototipo : tipodato prototipo
          | COMA prototipo
          |
          ;

llamada_funcion : ID PARA argumentos PARC
                ;

argumentos: ID argumentos
          | COMA argumentos
          |
          ;

declaracion_funcion : tipodato ID PARA prototipo PARC
                    ;
// declaracion -> int x; int suma(int , int);
//                double y;
//                int z = 0;
//                double w, q, t;
//                int a = 5, b, c = 10;

// asignacion -> x = 1;
//               z = y;

// iwhile -> while (x comp y) { instrucciones }
