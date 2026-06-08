package com.compilador;

/**
 * ArbolVisitor — imprime el árbol sintáctico en la consola con indentación.
 *
 * Cada nodo del AST se representa con su tipo y, cuando corresponde,
 * el valor del token. La indentación refleja la jerarquía del árbol.
 */
public class ArbolVisitor extends MiLenguajeBaseVisitor<Void> {

    private int nivel = 0;

    private String prefijo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) sb.append("  |  ");
        return sb.toString();
    }

    private void nodo(String texto) {
        System.out.println(prefijo() + texto);
    }

    @Override
    public Void visitCodigo(MiLenguajeParser.CodigoContext ctx) {
        nodo("[PROGRAMA]");
        nivel++;
        visitChildren(ctx);
        nivel--;
        return null;
    }

    @Override
    public Void visitDefFuncion(MiLenguajeParser.DefFuncionContext ctx) {
        nodo("[FUNCION] " + ctx.tipoDato().getText() + " " + ctx.ID().getText() + "(...)");
        nivel++;
        visitChildren(ctx);
        nivel--;
        return null;
    }

    @Override
    public Void visitDeclSimple(MiLenguajeParser.DeclSimpleContext ctx) {
        boolean tieneValor = ctx.expresion() != null;
        nodo("[DECL] " + ctx.tipoDato().getText() + " " + ctx.ID().getText()
                + (tieneValor ? " = ..." : ""));
        if (tieneValor) { nivel++; visit(ctx.expresion()); nivel--; }
        return null;
    }

    @Override
    public Void visitDeclArreglo(MiLenguajeParser.DeclArregloContext ctx) {
        nodo("[DECL_ARR] " + ctx.tipoDato().getText() + " " + ctx.ID().getText() + "[...]");
        return null;
    }

    @Override
    public Void visitAsigSimple(MiLenguajeParser.AsigSimpleContext ctx) {
        nodo("[ASIG] " + ctx.ID().getText() + " = ...");
        nivel++; visit(ctx.expresion()); nivel--;
        return null;
    }

    @Override
    public Void visitAsigArreglo(MiLenguajeParser.AsigArregloContext ctx) {
        nodo("[ASIG_ARR] " + ctx.ID().getText() + "[...] = ...");
        return null;
    }

    @Override
    public Void visitImprimir(MiLenguajeParser.ImprimirContext ctx) {
        nodo("[COUT]");
        nivel++; visit(ctx.expresion()); nivel--;
        return null;
    }

    @Override
    public Void visitCondicional(MiLenguajeParser.CondicionalContext ctx) {
        nodo("[IF" + (ctx.ELSE() != null ? "/ELSE" : "") + "]");
        nodo("  cond:"); nivel++; visit(ctx.expresion()); nivel--;
        nodo("  then:"); nivel++; visit(ctx.bloque(0));   nivel--;
        if (ctx.ELSE() != null) {
            nodo("  else:"); nivel++; visit(ctx.bloque(1)); nivel--;
        }
        return null;
    }

    @Override
    public Void visitBucleWhile(MiLenguajeParser.BucleWhileContext ctx) {
        nodo("[WHILE]");
        nodo("  cond:"); nivel++; visit(ctx.expresion()); nivel--;
        nodo("  cuerpo:"); nivel++; visit(ctx.bloque()); nivel--;
        return null;
    }

    @Override
    public Void visitBucleFor(MiLenguajeParser.BucleForContext ctx) {
        nodo("[FOR]");
        if (ctx.inicFor()    != null) { nodo("  init:");  nivel++; visit(ctx.inicFor());   nivel--; }
        if (ctx.expresion()  != null) { nodo("  cond:");  nivel++; visit(ctx.expresion()); nivel--; }
        if (ctx.actualizFor()!= null) { nodo("  update: " + ctx.actualizFor().ID().getText() + " = ..."); }
        nodo("  cuerpo:"); nivel++; visit(ctx.bloque()); nivel--;
        return null;
    }

    @Override
    public Void visitSalirBucle(MiLenguajeParser.SalirBucleContext ctx) {
        nodo("[BREAK]"); return null;
    }

    @Override
    public Void visitContinuarBucle(MiLenguajeParser.ContinuarBucleContext ctx) {
        nodo("[CONTINUE]"); return null;
    }

    @Override
    public Void visitRetorno(MiLenguajeParser.RetornoContext ctx) {
        nodo("[RETURN]");
        if (ctx.expresion() != null) { nivel++; visit(ctx.expresion()); nivel--; }
        return null;
    }

    @Override
    public Void visitBloque(MiLenguajeParser.BloqueContext ctx) {
        nodo("[BLOQUE (" + ctx.instruccion().size() + " instrucciones)]");
        nivel++; visitChildren(ctx); nivel--;
        return null;
    }

    // Expresiones
    @Override public Void visitExprOr(MiLenguajeParser.ExprOrContext ctx)
        { nodo("[OR]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprAnd(MiLenguajeParser.ExprAndContext ctx)
        { nodo("[AND]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx)
        { nodo("[" + ctx.getChild(1).getText() + "]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx)
        { nodo("[" + ctx.getChild(1).getText() + "]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx)
        { nodo("[" + ctx.getChild(1).getText() + "]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx)
        { nodo("[" + ctx.getChild(1).getText() + "]"); nivel++; visitChildren(ctx); nivel--; return null; }
    @Override public Void visitExprNegacion(MiLenguajeParser.ExprNegacionContext ctx)
        { nodo("[NOT]"); nivel++; visit(ctx.expresion()); nivel--; return null; }
    @Override public Void visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx)
        { nodo("[NEG]"); nivel++; visit(ctx.expresion()); nivel--; return null; }
    @Override public Void visitExprGrupo(MiLenguajeParser.ExprGrupoContext ctx)
        { nodo("[()]"); nivel++; visit(ctx.expresion()); nivel--; return null; }
    @Override public Void visitLitEntero(MiLenguajeParser.LitEnteroContext ctx)
        { nodo("[INT] " + ctx.ENTERO().getText()); return null; }
    @Override public Void visitLitDecimal(MiLenguajeParser.LitDecimalContext ctx)
        { nodo("[DEC] " + ctx.DECIMAL().getText()); return null; }
    @Override public Void visitLitCaracter(MiLenguajeParser.LitCaracterContext ctx)
        { nodo("[CHAR] " + ctx.CARACTER().getText()); return null; }
    @Override public Void visitLitCadena(MiLenguajeParser.LitCadenaContext ctx)
        { nodo("[STR] " + ctx.CADENA().getText()); return null; }
    @Override public Void visitLitVerdadero(MiLenguajeParser.LitVerdaderoContext ctx)
        { nodo("[BOOL] true"); return null; }
    @Override public Void visitLitFalso(MiLenguajeParser.LitFalsoContext ctx)
        { nodo("[BOOL] false"); return null; }
    @Override public Void visitVariable(MiLenguajeParser.VariableContext ctx)
        { nodo("[VAR] " + ctx.ID().getText()); return null; }
    @Override public Void visitLlamadaFuncion(MiLenguajeParser.LlamadaFuncionContext ctx)
        { nodo("[CALL] " + ctx.ID().getText() + "(...)"); return null; }
    @Override public Void visitAccesoArreglo(MiLenguajeParser.AccesoArregloContext ctx)
        { nodo("[IDX] " + ctx.ID().getText() + "[...]"); return null; }
}
