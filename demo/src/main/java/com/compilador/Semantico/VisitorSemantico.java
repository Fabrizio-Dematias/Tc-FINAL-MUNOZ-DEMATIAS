package com.compilador.Semantico;

import com.compilador.MiLenguajeBaseVisitor;
import com.compilador.MiLenguajeParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Analizador semántico del compilador.
 *
 * Recorre el AST y realiza las siguientes verificaciones:
 *   - Variables declaradas antes de usarse
 *   - Variables no redeclaradas en el mismo ámbito
 *   - Variables declaradas pero nunca usadas (warning)
 *   - Compatibilidad básica de tipos en asignaciones
 *   - break / continue solo dentro de bucles
 *   - Llamadas a funciones con número correcto de argumentos
 *
 * Retorna el tipo inferido de cada expresión (como String).
 */
public class VisitorSemantico extends MiLenguajeBaseVisitor<String> {

    private final TablaDeSimbolos tabla   = new TablaDeSimbolos();
    private final List<String>    errores = new ArrayList<>();
    private final List<String>    avisos  = new ArrayList<>();

    private String ambitoActual = "global";
    private int    profBucle    = 0;

    // -----------------------------------------------------------------------
    //  Tipos numéricos — son compatibles entre sí en operaciones aritméticas
    // -----------------------------------------------------------------------
    private boolean esNumerico(String tipo) {
        return tipo != null && (tipo.equals("int") || tipo.equals("float")
                || tipo.equals("double") || tipo.equals("char"));
    }

    private boolean sonCompatibles(String t1, String t2) {
        if (t1 == null || t2 == null)    return true;  // sin info = no reportar
        if (t1.equals(t2))               return true;
        if (esNumerico(t1) && esNumerico(t2)) return true;
        return false;
    }

    // -----------------------------------------------------------------------
    //  Funciones
    // -----------------------------------------------------------------------
    @Override
    public String visitDefFuncion(MiLenguajeParser.DefFuncionContext ctx) {
        String nombre  = ctx.ID().getText();
        String tipo    = ctx.tipoDato().getText();
        int    linea   = ctx.ID().getSymbol().getLine();
        int    columna = ctx.ID().getSymbol().getCharPositionInLine();

        EntradaSimbolo fn = new EntradaSimbolo(nombre, tipo, "funcion", linea, columna, "global", "");

        if (ctx.listaParams() != null) {
            for (MiLenguajeParser.ParamContext p : ctx.listaParams().param()) {
                fn.tiposParametros.add(p.tipoDato().getText());
            }
        }

        tabla.registrar(fn);

        String ambitoAnterior = ambitoActual;
        ambitoActual = nombre;

        if (ctx.listaParams() != null) visit(ctx.listaParams());
        visit(ctx.bloque());

        // Advertencia por variables locales no usadas
        for (EntradaSimbolo e : tabla.getEntradas()) {
            if (e.ambito.equals(nombre) && e.categoria.equals("variable") && !e.referenciado) {
                avisos.add("Variable '" + e.nombre + "' declarada pero no utilizada "
                        + "en '" + nombre + "' [línea " + e.linea + "]");
            }
        }

        ambitoActual = ambitoAnterior;
        return tipo;
    }

    @Override
    public String visitParam(MiLenguajeParser.ParamContext ctx) {
        String nombre  = ctx.ID().getText();
        String tipo    = ctx.tipoDato().getText();
        int    linea   = ctx.ID().getSymbol().getLine();
        int    columna = ctx.ID().getSymbol().getCharPositionInLine();
        tabla.registrar(new EntradaSimbolo(nombre, tipo, "parametro", linea, columna, ambitoActual, ""));
        return tipo;
    }

    // -----------------------------------------------------------------------
    //  Declaraciones
    // -----------------------------------------------------------------------
    @Override
    public String visitDeclSimple(MiLenguajeParser.DeclSimpleContext ctx) {
        String nombre  = ctx.ID().getText();
        String tipo    = ctx.tipoDato().getText();
        int    linea   = ctx.ID().getSymbol().getLine();
        int    columna = ctx.ID().getSymbol().getCharPositionInLine();

        if (tabla.existe(nombre, ambitoActual)) {
            errores.add("Variable '" + nombre + "' ya declarada en ámbito '"
                    + ambitoActual + "' [línea " + linea + "]");
            return tipo;
        }

        tabla.registrar(new EntradaSimbolo(nombre, tipo, "variable", linea, columna, ambitoActual, ""));

        if (ctx.expresion() != null) {
            String tipoExpr = visit(ctx.expresion());
            if (!sonCompatibles(tipo, tipoExpr)) {
                avisos.add("Posible incompatibilidad de tipos: se asigna '" + tipoExpr
                        + "' a variable de tipo '" + tipo + "' [línea " + linea + "]");
            }
        }
        return tipo;
    }

    @Override
    public String visitDeclArreglo(MiLenguajeParser.DeclArregloContext ctx) {
        String nombre  = ctx.ID().getText();
        String tipo    = ctx.tipoDato().getText();
        int    linea   = ctx.ID().getSymbol().getLine();
        int    columna = ctx.ID().getSymbol().getCharPositionInLine();
        String tam     = ctx.expresion().getText();

        if (tabla.existe(nombre, ambitoActual)) {
            errores.add("Variable '" + nombre + "' ya declarada en ámbito '"
                    + ambitoActual + "' [línea " + linea + "]");
            return tipo;
        }

        tabla.registrar(new EntradaSimbolo(nombre, tipo, "variable", linea, columna, ambitoActual,
                "arreglo[" + tam + "]"));
        return tipo;
    }

    // -----------------------------------------------------------------------
    //  Asignaciones
    // -----------------------------------------------------------------------
    @Override
    public String visitAsigSimple(MiLenguajeParser.AsigSimpleContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();

        EntradaSimbolo entrada = tabla.obtener(nombre);
        if (entrada == null) {
            errores.add("Variable '" + nombre + "' no declarada [línea " + linea + "]");
        } else if (entrada.categoria.equals("funcion")) {
            errores.add("'" + nombre + "' es una función, no se puede asignar [línea " + linea + "]");
        } else {
            entrada.referenciado = true;
            String tipoExpr = visit(ctx.expresion());
            if (!sonCompatibles(entrada.tipo, tipoExpr)) {
                avisos.add("Posible incompatibilidad: tipo '" + tipoExpr + "' asignado a '"
                        + nombre + "' de tipo '" + entrada.tipo + "' [línea " + linea + "]");
            }
        }
        if (entrada == null) visit(ctx.expresion());
        return null;
    }

    @Override
    public String visitAsigArreglo(MiLenguajeParser.AsigArregloContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();

        EntradaSimbolo entrada = tabla.obtener(nombre);
        if (entrada == null) {
            errores.add("Variable '" + nombre + "' no declarada [línea " + linea + "]");
        } else {
            entrada.referenciado = true;
        }
        visitChildren(ctx);
        return null;
    }

    // -----------------------------------------------------------------------
    //  Bucles — controlan la profundidad para validar break/continue
    // -----------------------------------------------------------------------
    @Override
    public String visitBucleWhile(MiLenguajeParser.BucleWhileContext ctx) {
        visit(ctx.expresion());
        profBucle++;
        visit(ctx.bloque());
        profBucle--;
        return null;
    }

    @Override
    public String visitBucleFor(MiLenguajeParser.BucleForContext ctx) {
        if (ctx.inicFor()    != null) visit(ctx.inicFor());
        if (ctx.expresion()  != null) visit(ctx.expresion());
        profBucle++;
        visit(ctx.bloque());
        profBucle--;
        return null;
    }

    @Override
    public String visitInicForDecl(MiLenguajeParser.InicForDeclContext ctx) {
        String nombre  = ctx.ID().getText();
        String tipo    = ctx.tipoDato().getText();
        int    linea   = ctx.ID().getSymbol().getLine();
        int    columna = ctx.ID().getSymbol().getCharPositionInLine();
        if (!tabla.existe(nombre, ambitoActual)) {
            tabla.registrar(new EntradaSimbolo(nombre, tipo, "variable", linea, columna, ambitoActual, "for-init"));
        }
        visit(ctx.expresion());
        return tipo;
    }

    @Override
    public String visitInicForAsig(MiLenguajeParser.InicForAsigContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();
        EntradaSimbolo e = tabla.obtener(nombre);
        if (e == null) errores.add("Variable '" + nombre + "' no declarada [línea " + linea + "]");
        else           e.referenciado = true;
        visit(ctx.expresion());
        return null;
    }

    @Override
    public String visitSalirBucle(MiLenguajeParser.SalirBucleContext ctx) {
        if (profBucle == 0) {
            errores.add("'break' fuera de un bucle [línea "
                    + ctx.BREAK().getSymbol().getLine() + "]");
        }
        return null;
    }

    @Override
    public String visitContinuarBucle(MiLenguajeParser.ContinuarBucleContext ctx) {
        if (profBucle == 0) {
            errores.add("'continue' fuera de un bucle [línea "
                    + ctx.CONTINUE().getSymbol().getLine() + "]");
        }
        return null;
    }

    // -----------------------------------------------------------------------
    //  Expresiones — retornan el tipo inferido
    // -----------------------------------------------------------------------
    @Override
    public String visitVariable(MiLenguajeParser.VariableContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();
        EntradaSimbolo e = tabla.obtener(nombre);
        if (e == null) {
            errores.add("Variable '" + nombre + "' no declarada [línea " + linea + "]");
            return "desconocido";
        }
        e.referenciado = true;
        return e.tipo;
    }

    @Override
    public String visitLlamadaFuncion(MiLenguajeParser.LlamadaFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();
        EntradaSimbolo fn = tabla.obtener(nombre);
        if (fn == null) {
            errores.add("Función '" + nombre + "' no declarada [línea " + linea + "]");
            return "desconocido";
        }
        int numArgs   = ctx.expresion() != null ? ctx.expresion().size() : 0;
        int numParams = fn.tiposParametros.size();
        if (numArgs != numParams) {
            errores.add("Función '" + nombre + "' espera " + numParams
                    + " argumento(s), se pasaron " + numArgs + " [línea " + linea + "]");
        }
        if (ctx.expresion() != null) {
            for (MiLenguajeParser.ExpresionContext e : ctx.expresion()) visit(e);
        }
        return fn.tipo;
    }

    @Override
    public String visitAccesoArreglo(MiLenguajeParser.AccesoArregloContext ctx) {
        String nombre = ctx.ID().getText();
        int    linea  = ctx.ID().getSymbol().getLine();
        EntradaSimbolo e = tabla.obtener(nombre);
        if (e == null) errores.add("Variable '" + nombre + "' no declarada [línea " + linea + "]");
        else           e.referenciado = true;
        visit(ctx.expresion());
        return e != null ? e.tipo : "desconocido";
    }

    @Override public String visitLitEntero(MiLenguajeParser.LitEnteroContext ctx)     { return "int"; }
    @Override public String visitLitDecimal(MiLenguajeParser.LitDecimalContext ctx)   { return "double"; }
    @Override public String visitLitCaracter(MiLenguajeParser.LitCaracterContext ctx) { return "char"; }
    @Override public String visitLitCadena(MiLenguajeParser.LitCadenaContext ctx)     { return "string"; }
    @Override public String visitLitVerdadero(MiLenguajeParser.LitVerdaderoContext ctx) { return "bool"; }
    @Override public String visitLitFalso(MiLenguajeParser.LitFalsoContext ctx)       { return "bool"; }
    @Override public String visitExprGrupo(MiLenguajeParser.ExprGrupoContext ctx)     { return visit(ctx.expresion()); }

    @Override
    public String visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx) {
        String t1 = visit(ctx.expresion(0));
        String t2 = visit(ctx.expresion(1));
        if (!esNumerico(t1) || !esNumerico(t2)) {
            avisos.add("Operación aritmética sobre tipos no numéricos: '"
                    + t1 + "' y '" + t2 + "'");
        }
        return esNumerico(t1) ? t1 : "int";
    }

    @Override
    public String visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx) {
        String t1 = visit(ctx.expresion(0));
        String t2 = visit(ctx.expresion(1));
        if (!esNumerico(t1) || !esNumerico(t2)) {
            avisos.add("Operación aritmética sobre tipos no numéricos: '"
                    + t1 + "' y '" + t2 + "'");
        }
        return esNumerico(t1) ? t1 : "int";
    }

    @Override
    public String visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx) {
        visit(ctx.expresion(0));
        visit(ctx.expresion(1));
        return "bool";
    }

    @Override
    public String visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx) {
        visit(ctx.expresion(0));
        visit(ctx.expresion(1));
        return "bool";
    }

    @Override
    public String visitExprAnd(MiLenguajeParser.ExprAndContext ctx) {
        visit(ctx.expresion(0)); visit(ctx.expresion(1)); return "bool";
    }

    @Override
    public String visitExprOr(MiLenguajeParser.ExprOrContext ctx) {
        visit(ctx.expresion(0)); visit(ctx.expresion(1)); return "bool";
    }

    @Override
    public String visitExprNegacion(MiLenguajeParser.ExprNegacionContext ctx) {
        visit(ctx.expresion()); return "bool";
    }

    @Override
    public String visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx) {
        return visit(ctx.expresion());
    }

    // -----------------------------------------------------------------------
    //  Getters
    // -----------------------------------------------------------------------
    public TablaDeSimbolos getTabla()        { return tabla; }
    public List<String>    getErrores()      { return errores; }
    public List<String>    getAvisos()       { return avisos; }
    public boolean         hayErrores()      { return !errores.isEmpty(); }
    public boolean         hayAvisos()       { return !avisos.isEmpty(); }
}
