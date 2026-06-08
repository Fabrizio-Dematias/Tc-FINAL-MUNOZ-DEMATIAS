package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.List;

/**
 * OPT-1: Constant Folding — Simplificación de expresiones constantes.
 *
 * Cuando ambos operandos de una operación aritmética son literales numéricos,
 * el resultado se calcula en tiempo de compilación y se emite directamente,
 * evitando la instrucción en el código intermedio.
 *
 * Ejemplo:  4 * 5  →  se emite 20 directamente (no se genera instrucción)
 *
 * Esta optimización se aplica de forma inline dentro de GeneradorVisitor,
 * usando este objeto para delegar el cálculo y registrar el log.
 */
public class FoldingConstantes {

    private final List<String> registro = new ArrayList<>();

    /**
     * Intenta evaluar la operación con dos operandos literales.
     * Retorna el resultado como String, o null si no es posible plegar.
     *
     * @param izq operando izquierdo
     * @param op  operador aritmético (+, -, *, /, %)
     * @param der operando derecho
     */
    public String evaluar(String izq, String op, String der) {
        try {
            double a = Double.parseDouble(izq);
            double b = Double.parseDouble(der);
            double resultado;

            switch (op) {
                case "+": resultado = a + b; break;
                case "-": resultado = a - b; break;
                case "*": resultado = a * b; break;
                case "/": resultado = a / b; break;
                case "%": resultado = a % b; break;
                default: return null;
            }

            String valor = (resultado == Math.floor(resultado) && !Double.isInfinite(resultado))
                    ? String.valueOf((long) resultado)
                    : String.valueOf(resultado);

            registro.add(izq + " " + op + " " + der + "  =>  " + valor);
            return valor;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    public List<String> getRegistro() {
        return registro;
    }
}
