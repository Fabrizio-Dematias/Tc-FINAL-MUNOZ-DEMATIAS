package com.compilador;

import com.compilador.Optimizacion.FoldingConstantes;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GeneradorVisitor extends MiLenguajeBaseVisitor<String> {

    private final CodigoTresDirecciones codigo;
    private final FoldingConstantes     folder;
    private final Deque<String[]>       pilaBucles = new ArrayDeque<>();

    public GeneradorVisitor(CodigoTresDirecciones codigo) {
        this.codigo  = codigo;
        this.folder  = new FoldingConstantes();
    }

    public List<String> getFoldLog() {
        return folder.getRegistro();
    }

    @Override
    public String visitCodigo(MiLenguajeParser.CodigoContext ctx) {
        codigo.marcar("INICIO");
        for (MiLenguajeParser.InstruccionContext i : ctx.instruccion()) {
            visit(i);
        }
        codigo.marcar("FIN");
        return null;
    }

    @Override
    public String visitDefFuncion(MiLenguajeParser.DefFuncionContext ctx) {
        codigo.marcar("fn_" + ctx.ID().getText());
        if (ctx.listaParams() != null) visit(ctx.listaParams());
        visit(ctx.bloque());
        return null;
    }

    @Override
    public String visitListaParams(MiLenguajeParser.ListaParamsContext ctx) {
        for (MiLenguajeParser.ParamContext p : ctx.param()) visit(p);
        return null;
    }

    @Override
    public String visitParam(MiLenguajeParser.ParamContext ctx) {
        codigo.emitir("PARAM " + ctx.ID().getText() + ":" + ctx.tipoDato().getText());
        return null;
    }

    @Override
    public String visitRetorno(MiLenguajeParser.RetornoContext ctx) {
        if (ctx.expresion() != null) {
            String val = visit(ctx.expresion());
            codigo.emitir("RET " + val);
        } else {
            codigo.emitir("RET");
        }
        return null;
    }

    @Override
    public String visitDeclSimple(MiLenguajeParser.DeclSimpleContext ctx) {
        String tipo = ctx.tipoDato().getText();
        String id   = ctx.ID().getText();
        codigo.emitir("DECL " + id + " : " + tipo);
        if (ctx.expresion() != null) {
            String val = visit(ctx.expresion());
            codigo.emitir(id + " = " + val);
        }
        return null;
    }

    @Override
    public String visitDeclArreglo(MiLenguajeParser.DeclArregloContext ctx) {
        String tipo = ctx.tipoDato().getText();
        String id   = ctx.ID().getText();
        String tam  = visit(ctx.expresion());
        codigo.emitir("DECL " + id + "[" + tam + "] : " + tipo);
        return null;
    }

    @Override
    public String visitAsigSimple(MiLenguajeParser.AsigSimpleContext ctx) {
        String val = visit(ctx.expresion());
        codigo.emitir(ctx.ID().getText() + " = " + val);
        return null;
    }

    @Override
    public String visitAsigArreglo(MiLenguajeParser.AsigArregloContext ctx) {
        String idx = visit(ctx.expresion(0));
        String val = visit(ctx.expresion(1));
        codigo.emitir(ctx.ID().getText() + "[" + idx + "] = " + val);
        return null;
    }

    @Override
    public String visitImprimir(MiLenguajeParser.ImprimirContext ctx) {
        String val = visit(ctx.expresion());
        codigo.emitir("PRINT " + val);
        return null;
    }

    @Override
    public String visitCondicional(MiLenguajeParser.CondicionalContext ctx) {
        String cond    = visit(ctx.expresion());
        String lblThen = codigo.nuevaEtiqueta("THEN_");
        String lblFin  = codigo.nuevaEtiqueta("FIN_IF_");
        String lblElse = (ctx.ELSE() != null) ? codigo.nuevaEtiqueta("ELSE_") : null;

        codigo.emitir("IF " + cond + " GOTO " + lblThen);
        codigo.emitir("GOTO " + (lblElse != null ? lblElse : lblFin));

        codigo.marcar(lblThen);
        visit(ctx.bloque(0));

        if (lblElse != null) {
            codigo.emitir("GOTO " + lblFin);
            codigo.marcar(lblElse);
            visit(ctx.bloque(1));
        }

        codigo.marcar(lblFin);
        return null;
    }

    @Override
    public String visitBucleWhile(MiLenguajeParser.BucleWhileContext ctx) {
        String lblInicio = codigo.nuevaEtiqueta("WHILE_");
        String lblCuerpo = codigo.nuevaEtiqueta("WHILE_CUERPO_");
        String lblFin    = codigo.nuevaEtiqueta("WHILE_FIN_");

        pilaBucles.push(new String[]{lblFin, lblInicio});

        codigo.marcar(lblInicio);
        String cond = visit(ctx.expresion());
        codigo.emitir("IF " + cond + " GOTO " + lblCuerpo);
        codigo.emitir("GOTO " + lblFin);
        codigo.marcar(lblCuerpo);
        visit(ctx.bloque());
        codigo.emitir("GOTO " + lblInicio);
        codigo.marcar(lblFin);

        pilaBucles.pop();
        return null;
    }

    @Override
    public String visitBucleFor(MiLenguajeParser.BucleForContext ctx) {
        String lblInicio  = codigo.nuevaEtiqueta("FOR_");
        String lblCuerpo  = codigo.nuevaEtiqueta("FOR_CUERPO_");
        String lblUpdate  = codigo.nuevaEtiqueta("FOR_UPDATE_");
        String lblFin     = codigo.nuevaEtiqueta("FOR_FIN_");

        pilaBucles.push(new String[]{lblFin, lblUpdate});

        if (ctx.inicFor() != null) visit(ctx.inicFor());

        codigo.marcar(lblInicio);
        if (ctx.expresion() != null) {
            String cond = visit(ctx.expresion());
            codigo.emitir("IF " + cond + " GOTO " + lblCuerpo);
            codigo.emitir("GOTO " + lblFin);
        } else {
            codigo.emitir("GOTO " + lblCuerpo);
        }

        codigo.marcar(lblCuerpo);
        visit(ctx.bloque());

        codigo.marcar(lblUpdate);
        if (ctx.actualizFor() != null) {
            String val = visit(ctx.actualizFor().expresion());
            codigo.emitir(ctx.actualizFor().ID().getText() + " = " + val);
        }
        codigo.emitir("GOTO " + lblInicio);
        codigo.marcar(lblFin);

        pilaBucles.pop();
        return null;
    }

    @Override
    public String visitInicForDecl(MiLenguajeParser.InicForDeclContext ctx) {
        String tipo = ctx.tipoDato().getText();
        String id   = ctx.ID().getText();
        codigo.emitir("DECL " + id + " : " + tipo);
        String val = visit(ctx.expresion());
        codigo.emitir(id + " = " + val);
        return null;
    }

    @Override
    public String visitInicForAsig(MiLenguajeParser.InicForAsigContext ctx) {
        String val = visit(ctx.expresion());
        codigo.emitir(ctx.ID().getText() + " = " + val);
        return null;
    }

    @Override
    public String visitSalirBucle(MiLenguajeParser.SalirBucleContext ctx) {
        if (!pilaBucles.isEmpty()) codigo.emitir("GOTO " + pilaBucles.peek()[0]);
        return null;
    }

    @Override
    public String visitContinuarBucle(MiLenguajeParser.ContinuarBucleContext ctx) {
        if (!pilaBucles.isEmpty()) codigo.emitir("GOTO " + pilaBucles.peek()[1]);
        return null;
    }

    @Override
    public String visitBloque(MiLenguajeParser.BloqueContext ctx) {
        for (MiLenguajeParser.InstruccionContext i : ctx.instruccion()) visit(i);
        return null;
    }

    @Override public String visitVariable(MiLenguajeParser.VariableContext ctx)         { return ctx.ID().getText(); }
    @Override public String visitLitEntero(MiLenguajeParser.LitEnteroContext ctx)        { return ctx.ENTERO().getText(); }
    @Override public String visitLitDecimal(MiLenguajeParser.LitDecimalContext ctx)      { return ctx.DECIMAL().getText(); }
    @Override public String visitLitCaracter(MiLenguajeParser.LitCaracterContext ctx)    { return ctx.CARACTER().getText(); }
    @Override public String visitLitCadena(MiLenguajeParser.LitCadenaContext ctx)        { return ctx.CADENA().getText(); }
    @Override public String visitLitVerdadero(MiLenguajeParser.LitVerdaderoContext ctx)  { return "true"; }
    @Override public String visitLitFalso(MiLenguajeParser.LitFalsoContext ctx)          { return "false"; }
    @Override public String visitExprGrupo(MiLenguajeParser.ExprGrupoContext ctx)        { return visit(ctx.expresion()); }

    @Override
    public String visitAccesoArreglo(MiLenguajeParser.AccesoArregloContext ctx) {
        String idx  = visit(ctx.expresion());
        String temp = codigo.nuevaTemp();
        codigo.emitir(temp + " = " + ctx.ID().getText() + "[" + idx + "]");
        return temp;
    }

    @Override
    public String visitLlamadaFuncion(MiLenguajeParser.LlamadaFuncionContext ctx) {
        List<String> args = new ArrayList<>();
        if (ctx.expresion() != null) {
            for (MiLenguajeParser.ExpresionContext e : ctx.expresion()) args.add(visit(e));
        }
        String llamada = "fn_" + ctx.ID().getText();
        if (!args.isEmpty()) codigo.emitir("CALL " + llamada + ", " + String.join(", ", args));
        else                 codigo.emitir("CALL " + llamada);
        return "RET_VAL";
    }

    @Override
    public String visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx) {
        String val  = visit(ctx.expresion());
        String temp = codigo.nuevaTemp();
        codigo.emitir(temp + " = -" + val);
        return temp;
    }

    @Override
    public String visitExprNegacion(MiLenguajeParser.ExprNegacionContext ctx) {
        String val  = visit(ctx.expresion());
        String temp = codigo.nuevaTemp();
        codigo.emitir(temp + " = !" + val);
        return temp;
    }

    private String opBinaria(String izq, String op, String der) {
        String plegado = folder.evaluar(izq, op, der);
        if (plegado != null) return plegado;
        String temp = codigo.nuevaTemp();
        codigo.emitir(temp + " = " + izq + " " + op + " " + der);
        return temp;
    }

    @Override
    public String visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.OP_SUM() != null ? "+" : "-";
        return opBinaria(izq, op, der);
    }

    @Override
    public String visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op;
        if      (ctx.OP_MUL() != null) op = "*";
        else if (ctx.OP_MOD() != null) op = "%";
        else {
            op = "/";
            if ("0".equals(der) || "0.0".equals(der))
                System.err.println("Advertencia: division por cero detectada.");
        }
        return opBinaria(izq, op, der);
    }

    @Override
    public String visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op;
        if      (ctx.OP_GT()  != null) op = ">";
        else if (ctx.OP_LT()  != null) op = "<";
        else if (ctx.OP_GTE() != null) op = ">=";
        else                           op = "<=";
        return opBinaria(izq, op, der);
    }

    @Override
    public String visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.OP_EQ() != null ? "==" : "!=";
        return opBinaria(izq, op, der);
    }

    @Override
    public String visitExprAnd(MiLenguajeParser.ExprAndContext ctx) {
        return opBinaria(visit(ctx.expresion(0)), "&&", visit(ctx.expresion(1)));
    }

    @Override
    public String visitExprOr(MiLenguajeParser.ExprOrContext ctx) {
        return opBinaria(visit(ctx.expresion(0)), "||", visit(ctx.expresion(1)));
    }
}
