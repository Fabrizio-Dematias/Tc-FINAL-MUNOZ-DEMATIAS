package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OPT-1: Constant Folding — Simplificación de expresiones constantes.
 *
 * Se aplica como post-proceso sobre la lista de instrucciones generada.
 * Detecta instrucciones de la forma:
 *   _tN = literal OP literal
 * calcula el resultado en tiempo de compilación, elimina esa instrucción
 * y reemplaza los usos posteriores de _tN con el valor calculado.
 *
 * El proceso se realiza en un único recorrido de izquierda a derecha,
 * propagando los resultados plegados para habilitar plegados en cadena.
 *
 * Ejemplo:
 *   _t1 = 4 * 5       →  eliminada (_t1 = 20 propagado)
 *   _t2 = _t1 + 3     →  _t2 = 20 + 3  →  eliminada (_t2 = 23)
 *   x = _t2           →  x = 23
 */
public class FoldingConstantes {

    // Patrón: _tN = <token> <op_aritmético> <token>
    private static final Pattern PAT_BIN = Pattern.compile(
        "^(_t\\d+)\\s*=\\s*(\\S+)\\s*([+\\-*/%])\\s*(\\S+)$"
    );

    public List<String> aplicar(List<String> instrucciones) {
        Map<String, String> constantes = new LinkedHashMap<>();
        List<String> reporte  = new ArrayList<>();
        List<String> resultado = new ArrayList<>();

        for (String linea : instrucciones) {
            // 1. Sustituir constantes plegadas conocidas en esta línea
            String procesada = sustituir(linea, constantes);

            // 2. Intentar plegar si es _tN = lit OP lit
            Matcher m = PAT_BIN.matcher(procesada.trim());
            if (m.matches()) {
                String temp = m.group(1);
                String izq  = m.group(2);
                String op   = m.group(3);
                String der  = m.group(4);

                String val = evaluar(izq, op, der);
                if (val != null) {
                    constantes.put(temp, val);
                    reporte.add(izq + " " + op + " " + der + "  =>  " + val);
                    continue; // instrucción eliminada
                }
            }

            resultado.add(procesada);
        }

        instrucciones.clear();
        instrucciones.addAll(resultado);
        return reporte;
    }

    private String sustituir(String linea, Map<String, String> mapa) {
        String res = linea;
        for (Map.Entry<String, String> e : mapa.entrySet()) {
            res = res.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
        }
        return res;
    }

    private String evaluar(String izq, String op, String der) {
        try {
            double a = Double.parseDouble(izq);
            double b = Double.parseDouble(der);
            double resultado;

            switch (op) {
                case "+": resultado = a + b; break;
                case "-": resultado = a - b; break;
                case "*": resultado = a * b; break;
                case "/": if (b == 0) return null; resultado = a / b; break;
                case "%": if (b == 0) return null; resultado = a % b; break;
                default: return null;
            }

            return (resultado == Math.floor(resultado) && !Double.isInfinite(resultado))
                    ? String.valueOf((long) resultado)
                    : String.valueOf(resultado);

        } catch (NumberFormatException e) {
            return null;
        }
    }
}
