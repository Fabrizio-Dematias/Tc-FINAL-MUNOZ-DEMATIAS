# Compilador C++ — Técnicas de Compilación

*Integrantes:* Muñoz / Dematias  
*Materia:* Técnicas de Compilación  
*Herramienta:* Java + ANTLR4  

Compilador de un subconjunto del lenguaje C++ implementado en Java con ANTLR4. Cubre todas las fases del proceso de compilación: análisis léxico, sintáctico, semántico, generación de código intermedio y optimización.

---

## Funcionalidades implementadas

### Fases del compilador
| Fase | Descripción |
|---|---|
| Análisis Léxico | Tabla de tokens con tipo, lexema, línea y columna. Reporte de errores léxicos. |
| Análisis Sintáctico | Verificación gramatical. Reporte de errores sintácticos con recuperación. Árbol sintáctico en consola y ventana gráfica (Swing). |
| Análisis Semántico | Tabla de símbolos, inferencia de tipos, verificación de ámbitos, errores críticos y warnings. |
| Código Intermedio | Código de tres direcciones con etiquetas, temporales, ⁠ DECL ⁠, ⁠ PARAM ⁠, ⁠ CALL ⁠, ⁠ RET ⁠, ⁠ PRINT ⁠. |
| Optimización | OPT-1 Constant Folding · OPT-2 Propagación de Constantes · OPT-3 Eliminación de Código Muerto |

### Subconjunto de C++ soportado

*Tipos:* ⁠ int ⁠, ⁠ char ⁠, ⁠ double ⁠, ⁠ float ⁠, ⁠ bool ⁠, ⁠ string ⁠, ⁠ void ⁠

*Estructuras de control:* ⁠ if-else ⁠, ⁠ while ⁠, ⁠ for ⁠, ⁠ break ⁠, ⁠ continue ⁠

*Elementos:* declaración de variables y arreglos, funciones con parámetros y retorno, expresiones aritméticas y lógicas, llamadas a funciones, ⁠ cout ⁠

### Verificaciones semánticas
•⁠  ⁠Variable no declarada → error
•⁠  ⁠Variable redeclarada en el mismo ámbito → error
•⁠  ⁠Asignación a nombre de función → error
•⁠  ⁠⁠ break ⁠ / ⁠ continue ⁠ fuera de un bucle → error
•⁠  ⁠Llamada con número incorrecto de argumentos → error
•⁠  ⁠Variable declarada pero no utilizada → warning
•⁠  ⁠Incompatibilidad de tipos en asignación → warning

### Sistema de colores en consola
•⁠  ⁠Verde ⁠ [OK] ⁠ — éxito
•⁠  ⁠Amarillo ⁠ [!!] ⁠ — warnings
•⁠  ⁠Rojo ⁠ [ERR] ⁠ — errores

---

## Requisitos

•⁠  ⁠Java 11 o superior
•⁠  ⁠Maven 3.6 o superior

---

## Compilar el proyecto

⁠ bash
cd demo
mvn clean package -q
 ⁠

Esto genera ⁠ target/demo-1.0-jar-with-dependencies.jar ⁠.

---

## Ejecutar el compilador

⁠ bash
java -jar demo/target/demo-1.0-jar-with-dependencies.jar <archivo.txt>
 ⁠

### Ejemplos incluidos

| Archivo | Descripción |
|---|---|
| ⁠ demo/prueba_correcto.txt ⁠ | Programa completo sin errores (todas las funcionalidades) |
| ⁠ demo/prueba_sintactico.txt ⁠ | Programa con 3 errores sintácticos intencionales |
| ⁠ demo/prueba_semantico.txt ⁠ | Programa con 6 errores y 2 warnings semánticos intencionales |
| ⁠ demo/ejemplo.txt ⁠ | Programa con variables, funciones y arreglos |
| ⁠ demo/ejemplo_for.txt ⁠ | Demostración de ⁠ for ⁠, ⁠ break ⁠ y ⁠ continue ⁠ |
| ⁠ demo/ejemplo_con_errores.txt ⁠ | Errores semánticos adicionales |

⁠ bash
# Ejemplo de uso
java -jar demo/target/demo-1.0-jar-with-dependencies.jar demo/prueba_correcto.txt
 ⁠

---

## Archivos de salida generados

Para un archivo de entrada ⁠ programa.txt ⁠, el compilador genera:

| Archivo | Contenido |
|---|---|
| ⁠ programa_cod1.txt ⁠ | Código intermedio (con OPT-1 Constant Folding inline) |
| ⁠ programa_cod2.txt ⁠ | Código tras OPT-2 Propagación de Constantes |
| ⁠ programa_cod3.txt ⁠ | Código tras OPT-3 Eliminación de Código Muerto |

---

## Estructura del proyecto


demo/
├── src/
│   └── main/
│       ├── antlr4/com/compilador/
│       │   └── MiLenguaje.g4              # Gramática ANTLR4
│       └── java/com/compilador/
│           ├── App.java                   # Punto de entrada
│           ├── ArbolVisitor.java          # Impresión textual del AST
│           ├── GeneradorVisitor.java      # Generación de código intermedio
│           ├── CodigoTresDirecciones.java # Estructura del código intermedio
│           ├── Semantico/
│           │   ├── VisitorSemantico.java  # Analizador semántico
│           │   ├── TablaDeSimbolos.java   # Tabla de símbolos
│           │   └── EntradaSimbolo.java    # Entrada individual de la tabla
│           └── Optimizacion/
│               ├── FoldingConstantes.java      # OPT-1
│               ├── PropagacionConstantes.java  # OPT-2
│               └── CodigoMuerto.java           # OPT-3
└── pom.xml


---

## Creación del proyecto Maven

⁠ bash
mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate \
  -DarchetypeArtifactId="maven-archetype-quickstart" \
  -DarchetypeGroupId="org.apache.maven.archetypes" \
  -DarchetypeVersion="1.4" \
  -DgroupId="com.compilador" \
  -DartifactId="demo"
 ⁠