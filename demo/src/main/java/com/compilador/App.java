package com.compilador;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;
import com.compilador.Semantico.VisitorSemantico;
import com.compilador.Optimizacion.FoldingConstantes;
import com.compilador.Optimizacion.PropagacionConstantes;
import com.compilador.Optimizacion.CodigoMuerto;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String ROJO  = "\u001B[31m";
    private static final String AMAR  = "\u001B[33m";
    private static final String CYAN  = "\u001B[36m";

    private static void ok(String msg)   { System.out.println(VERDE + "  [OK]  " + msg + RESET); }
    private static void err(String msg)  { System.out.println(ROJO  + "  [ERR] " + msg + RESET); }
    private static void warn(String msg) { System.out.println(AMAR  + "  [!!]  " + msg + RESET); }
    private static void sec(String msg)  { System.out.println(CYAN  + "\n>>> " + msg + RESET); }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar demo-1.0-jar-with-dependencies.jar <archivo>");
            System.exit(1);
        }

        String archivo = args[0];
        System.out.println("=".repeat(60));
        System.out.println("  Compilador C++ — Muñoz / Dematias");
        System.out.println("  Archivo: " + archivo);
        System.out.println("=".repeat(60));

        try {
            CharStream entrada = CharStreams.fromFileName(archivo);

            // =================================================================
            //  FASE 1: ANÁLISIS LÉXICO
            // =================================================================
            sec("FASE 1 — Análisis Léxico");

            MiLenguajeLexer lexer = new MiLenguajeLexer(entrada);
            final boolean[] hayErrorLex = {false};

            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> r, Object sym,
                                        int linea, int col, String msg, RecognitionException e) {
                    err("Línea " + linea + ":" + col + " — " + msg);
                    hayErrorLex[0] = true;
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            System.out.printf("  %-22s %-24s %-6s %-6s%n", "TOKEN", "LEXEMA", "LÍNEA", "COL");
            System.out.println("  " + "-".repeat(60));
            for (Token t : tokens.getTokens()) {
                if (t.getType() == Token.EOF) continue;
                String nombre = MiLenguajeLexer.VOCABULARY.getSymbolicName(t.getType());
                if (nombre == null) nombre = "DESCONOCIDO";
                System.out.printf("  %-22s %-24s %-6d %-6d%n",
                        nombre, t.getText(), t.getLine(), t.getCharPositionInLine());
            }

            if (hayErrorLex[0]) {
                err("Compilación detenida: errores léxicos.");
                return;
            }
            ok("Análisis léxico completado.");

            // =================================================================
            //  FASE 2: ANÁLISIS SINTÁCTICO
            // =================================================================
            sec("FASE 2 — Análisis Sintáctico");
            tokens.reset();

            MiLenguajeParser parser = new MiLenguajeParser(tokens);
            final boolean[] hayErrorSin = {false};

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> r, Object sym,
                                        int linea, int col, String msg, RecognitionException e) {
                    String tok = sym != null ? "'" + sym + "'" : "fin de archivo";
                    err("Línea " + linea + ":" + col + " cerca de " + tok + " — " + msg);
                    hayErrorSin[0] = true;
                }
            });

            MiLenguajeParser.CodigoContext arbol = parser.codigo();

            if (hayErrorSin[0]) {
                err("Compilación detenida: errores sintácticos.");
                return;
            }

            // Imprimir árbol textual
            System.out.println();
            new ArbolVisitor().visit(arbol);
            ok("Análisis sintáctico completado.");

            // =================================================================
            //  FASE 3: ANÁLISIS SEMÁNTICO
            // =================================================================
            sec("FASE 3 — Análisis Semántico");

            VisitorSemantico semantico = new VisitorSemantico();
            semantico.visit(arbol);
            semantico.getTabla().mostrar();

            for (String e : semantico.getErrores())  err(e);
            for (String a : semantico.getAvisos())   warn(a);

            if (semantico.hayErrores()) {
                err("Compilación detenida: errores semánticos.");
                return;
            }
            ok("Análisis semántico completado"
                    + (semantico.hayAvisos() ? " (con advertencias)." : "."));

            // =================================================================
            //  FASE 4: GENERACIÓN DE CÓDIGO INTERMEDIO
            // =================================================================
            sec("FASE 4 — Código Intermedio (sin optimizaciones)");

            CodigoTresDirecciones codigo = new CodigoTresDirecciones();
            GeneradorVisitor gen = new GeneradorVisitor(codigo);
            gen.visit(arbol);

            System.out.println();
            codigo.imprimir();

            String base = archivo.replaceAll("\\.[^.]+$", "");
            codigo.guardarEn(base + "_cod0.txt");
            ok("Código intermedio (raw) guardado en: " + base + "_cod0.txt");

            int instrOriginal = codigo.totalInstrucciones();

            // =================================================================
            //  OPT-1: CONSTANT FOLDING
            // =================================================================
            sec("OPT-1 — Constant Folding");

            FoldingConstantes opt1 = new FoldingConstantes();
            List<String> folds = opt1.aplicar(codigo.getInstrucciones());

            if (folds.isEmpty()) warn("Sin expresiones constantes para plegar.");
            else folds.forEach(f -> System.out.println(VERDE + "    " + f + RESET));

            System.out.println();
            codigo.imprimir();
            codigo.guardarEn(base + "_cod1.txt");
            ok("OPT-1 guardado en: " + base + "_cod1.txt");

            // =================================================================
            //  OPT-2: PROPAGACIÓN DE CONSTANTES
            // =================================================================
            sec("OPT-2 — Propagación de Constantes");

            PropagacionConstantes opt2 = new PropagacionConstantes();
            List<String> propag = opt2.aplicar(codigo.getInstrucciones());

            if (propag.isEmpty()) warn("Sin variables constantes para propagar.");
            else propag.forEach(p -> System.out.println(VERDE + "    " + p + RESET));

            System.out.println();
            codigo.imprimir();
            codigo.guardarEn(base + "_cod2.txt");
            ok("OPT-2 guardado en: " + base + "_cod2.txt");

            // =================================================================
            //  OPT-3: ELIMINACIÓN DE CÓDIGO MUERTO
            // =================================================================
            sec("OPT-3 — Eliminación de Código Muerto");

            CodigoMuerto opt3 = new CodigoMuerto();
            List<String> muertas = opt3.aplicar(codigo.getInstrucciones());

            if (muertas.isEmpty()) warn("Sin temporales muertas para eliminar.");
            else muertas.forEach(m -> System.out.println(VERDE + "    eliminada: " + m + RESET));

            System.out.println();
            codigo.imprimir();
            codigo.guardarEn(base + "_cod3.txt");
            ok("OPT-3 guardado en: " + base + "_cod3.txt");

            // =================================================================
            sec("FASE 5 — Resumen de Optimizaciones");

            int instrFinal   = codigo.totalInstrucciones();
            int elimFolding  = folds.size();
            int elimMuertas  = muertas.size();
            double reduccion = instrOriginal > 0
                    ? 100.0 - (instrFinal * 100.0 / instrOriginal) : 0;

            System.out.println();
            System.out.printf("  Instrucciones originales (sin opt.)  : %d%n", instrOriginal);
            System.out.printf("  Tras OPT-1 (Constant Folding)        : %d  (-%d)%n",
                    instrOriginal - elimFolding, elimFolding);
            System.out.printf("  Tras OPT-2 (Propagacion)             : %d%n",
                    instrOriginal - elimFolding);
            System.out.printf("  Tras OPT-3 (Codigo Muerto)           : %d  (-%d)%n",
                    instrFinal, elimMuertas);
            System.out.printf("  Reduccion total                      : %.1f%%%n", reduccion);

            System.out.println("\n" + "=".repeat(60));
            ok("Compilacion exitosa.");

            System.out.println("\n  Abriendo árbol sintáctico...");
            mostrarArbol(arbol, parser);

        } catch (IOException e) {
            err("No se pudo abrir el archivo: " + e.getMessage());
        } catch (Exception e) {
            err("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarArbol(ParseTree arbol, Parser parser) {
        JFrame ventana = new JFrame("Árbol Sintáctico — Muñoz / Dematias");
        JPanel panel   = new JPanel();
        TreeViewer visor = new TreeViewer(Arrays.asList(parser.getRuleNames()), arbol);
        visor.setScale(1.4);
        panel.add(visor);
        JScrollPane scroll = new JScrollPane(panel);
        ventana.add(scroll);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(900, 650);
        ventana.setVisible(true);
    }
}
