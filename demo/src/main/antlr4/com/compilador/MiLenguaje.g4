grammar MiLenguaje;

// ============================================================
//  Gramática del compilador — subconjunto de C++
//  Técnicas de Compilación — Muñoz / Dematias
// ============================================================

// Regla inicial: un programa es una secuencia de instrucciones
codigo
    : instruccion* EOF
    ;

// Una instrucción puede ser cualquiera de los siguientes tipos
instruccion
    : defFuncion
    | declVar
    | asignacion
    | imprimir
    | condicional
    | bucleWhile
    | bucleFor
    | salirBucle
    | continuarBucle
    | retorno
    | bloque
    ;

// Declaración de variable: tipo nombre [= expr] ;
// o declaración de arreglo: tipo nombre[tamaño] ;
declVar
    : tipoDato ID (OP_ASIG expresion)? PYCOM    # declSimple
    | tipoDato ID CORCH_A expresion CORCH_C PYCOM  # declArreglo
    ;

// Definición de función: tipo nombre(params) { ... }
defFuncion
    : tipoDato ID PAREN_A listaParams? PAREN_C bloque
    ;

listaParams
    : param (COMA param)*
    ;

param
    : tipoDato ID
    ;

// Sentencia return: return [expr] ;
retorno
    : RETURN expresion? PYCOM
    ;

// Tipos de datos soportados
tipoDato
    : INT
    | FLOAT
    | DOUBLE
    | CHAR
    | STRING_TIPO
    | BOOL
    | VOID
    ;

// Asignación: id = expr ; o id[idx] = expr ;
asignacion
    : ID OP_ASIG expresion PYCOM                               # asigSimple
    | ID CORCH_A expresion CORCH_C OP_ASIG expresion PYCOM    # asigArreglo
    ;

// Salida por consola: cout << expr ;
imprimir
    : COUT OP_FLUJO expresion PYCOM
    ;

// Condicional: if (expr) { ... } [else { ... }]
condicional
    : IF PAREN_A expresion PAREN_C bloque (ELSE bloque)?
    ;

// Bucle while: while (expr) { ... }
bucleWhile
    : WHILE PAREN_A expresion PAREN_C bloque
    ;

// Bucle for: for (init; cond; update) { ... }
bucleFor
    : FOR PAREN_A inicFor? PYCOM expresion? PYCOM actualizFor? PAREN_C bloque
    ;

// Inicialización del for (sin punto y coma propio)
inicFor
    : tipoDato ID OP_ASIG expresion    # inicForDecl
    | ID OP_ASIG expresion              # inicForAsig
    ;

// Actualización del for (sin punto y coma propio)
actualizFor
    : ID OP_ASIG expresion
    ;

// Control de bucles
salirBucle
    : BREAK PYCOM
    ;

continuarBucle
    : CONTINUE PYCOM
    ;

// Bloque de instrucciones entre llaves
bloque
    : LLAVE_A instruccion* LLAVE_C
    ;

// ============================================================
//  EXPRESIONES — con jerarquía de precedencia
//  (menor precedencia arriba, mayor abajo)
// ============================================================
expresion
    : expresion OP_OR expresion                                           # exprOr
    | expresion OP_AND expresion                                          # exprAnd
    | expresion (OP_EQ | OP_NEQ) expresion                               # exprIgualdad
    | expresion (OP_GT | OP_LT | OP_GTE | OP_LTE) expresion             # exprRelacional
    | expresion (OP_SUM | OP_RES) expresion                              # exprAditiva
    | expresion (OP_MUL | OP_DIV | OP_MOD) expresion                    # exprMultiplicativa
    | OP_NOT expresion                                                    # exprNegacion
    | OP_RES expresion                                                    # exprNegativo
    | PAREN_A expresion PAREN_C                                          # exprGrupo
    | ENTERO                                                              # litEntero
    | DECIMAL                                                             # litDecimal
    | CARACTER                                                            # litCaracter
    | CADENA                                                              # litCadena
    | TRUE                                                                # litVerdadero
    | FALSE                                                               # litFalso
    | ID PAREN_A (expresion (COMA expresion)*)? PAREN_C                  # llamadaFuncion
    | ID CORCH_A expresion CORCH_C                                        # accesoArreglo
    | ID                                                                  # variable
    ;

// ============================================================
//  LEXER — definición de tokens
// ============================================================
fragment LETRA  : [A-Za-z];
fragment DIGITO : [0-9];

// Delimitadores
PAREN_A  : '(' ;
PAREN_C  : ')' ;
CORCH_A  : '[' ;
CORCH_C  : ']' ;
LLAVE_A  : '{' ;
LLAVE_C  : '}' ;
PYCOM    : ';' ;
COMA     : ',' ;

// Operadores (los de 2 caracteres van primero)
OP_EQ    : '==' ;
OP_NEQ   : '!=' ;
OP_GTE   : '>=' ;
OP_LTE   : '<=' ;
OP_FLUJO : '<<' ;
OP_OR    : '||' ;
OP_AND   : '&&' ;
OP_GT    : '>'  ;
OP_LT    : '<'  ;
OP_ASIG  : '='  ;
OP_SUM   : '+'  ;
OP_RES   : '-'  ;
OP_MUL   : '*'  ;
OP_DIV   : '/'  ;
OP_MOD   : '%'  ;
OP_NOT   : '!'  ;

// Palabras clave de control (antes que ID)
FOR      : 'for'      ;
WHILE    : 'while'    ;
IF       : 'if'       ;
ELSE     : 'else'     ;
BREAK    : 'break'    ;
CONTINUE : 'continue' ;
RETURN   : 'return'   ;

// Palabras clave de tipos
INT         : 'int'    ;
FLOAT       : 'float'  ;
DOUBLE      : 'double' ;
CHAR        : 'char'   ;
STRING_TIPO : 'string' ;
BOOL        : 'bool'   ;
VOID        : 'void'   ;

// Literales booleanos
TRUE  : 'true'  ;
FALSE : 'false' ;

// Salida
COUT : 'cout' ;

// Identificadores (después de todas las palabras clave)
ID : (LETRA | '_') (LETRA | DIGITO | '_')* ;

// Literales
ENTERO   : DIGITO+ ;
DECIMAL  : DIGITO+ '.' DIGITO+ ;
CARACTER : '\'' (~['\r\n] | '\\' .) '\'' ;
CADENA   : '"' (~["\r\n] | '\\' .)* '"' ;

// Comentarios — se descartan
COM_LINEA  : '//' ~[\r\n]*  -> skip ;
COM_BLOQUE : '/*' .*? '*/'  -> skip ;

// Espacios — se descartan
ESPACIOS : [ \r\n\t]+ -> skip ;

// Token de error para caracteres no reconocidos
INVALIDO : . ;
