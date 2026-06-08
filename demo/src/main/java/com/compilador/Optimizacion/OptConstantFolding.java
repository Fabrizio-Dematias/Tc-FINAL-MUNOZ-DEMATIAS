package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * OPT-1: Constant Folding (Simplificación de expresiones)
 *
 * Evalúa operaciones aritméticas en tiempo de compilación
 * cuando AMBOS operandos son literales numéricos.
 *
 * Ejemplo:  3 + 2  →  5   (se emite directamente el resultado)
 *
 * Esta optimización se aplica INLINE durante la generación de
 * código intermedio (en CodigoVisitor), por lo que el código
 * resultante nunca contiene la operación original.
 */
public class OptConstantFolding {

    private final List<String> log = new ArrayList<>();

    /**
     * Intenta plegar dos operandos con el operador dado.
     * Retorna el resultado como String si ambos son numéricos,
     * o null si no es posible plegar.
     */
    public String fold(String left, String op, String right) {
        try {
            double l = Double.parseDouble(left);
            double r = Double.parseDouble(right);
            double result;
            switch (op) {
                case "+": result = l + r; break;
                case "-": result = l - r; break;
                case "*": result = l * r; break;
                case "/": result = l / r; break;
                case "%": result = l % r; break;
                default: return null;
            }
            String folded = (result == Math.floor(result) && !Double.isInfinite(result))
                    ? String.valueOf((long) result)
                    : String.valueOf(result);
            log.add(left + " " + op + " " + right + "  →  " + folded);
            return folded;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Retorna el registro de expresiones que fueron simplificadas. */
    public List<String> getLog() {
        return log;
    }
}
