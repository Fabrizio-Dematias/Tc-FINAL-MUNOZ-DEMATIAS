package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OPT-2: Propagación de Constantes
 *
 * Busca asignaciones de la forma  var = literal  y reemplaza
 * todas las apariciones futuras de esa variable por su valor constante.
 *
 * Ejemplo:
 *   x = 5
 *   t1 = x + 3   →   t1 = 5 + 3
 *
 * Se aplica como post-proceso sobre la lista de instrucciones
 * generada por CodigoVisitor.
 */
public class OptPropagacionConstantes {

    /**
     * Aplica la optimización sobre la lista de instrucciones (modifica en el lugar).
     *
     * @param instrucciones lista de instrucciones de código de tres direcciones
     * @return log con las sustituciones realizadas (var → valor)
     */
    public List<String> optimizar(List<String> instrucciones) {
        Pattern asignacion = Pattern.compile("^([a-zA-Z_][a-zA-Z0-9_]*)\\s*=\\s*(.+)$");
        Map<String, String> constMap = new HashMap<>();
        List<String> propagaciones = new ArrayList<>();
        List<String> resultado = new ArrayList<>();

        for (String instr : instrucciones) {
            String trimmed = instr.trim();
            String procesada = instr;

            Matcher mAsign = asignacion.matcher(trimmed);
            if (mAsign.matches()) {
                String var = mAsign.group(1);
                String rhs = mAsign.group(2).trim();
                String rhsProp = aplicarSustitucion(rhs, constMap, propagaciones);
                procesada = var + " = " + rhsProp;
                if (esLiteral(rhsProp)) {
                    constMap.put(var, rhsProp);
                } else {
                    constMap.remove(var);
                }
            } else if (!trimmed.isEmpty() && !trimmed.endsWith(":")) {
                procesada = aplicarSustitucionLinea(instr, constMap, propagaciones);
            }

            resultado.add(procesada);
        }

        instrucciones.clear();
        instrucciones.addAll(resultado);
        return propagaciones;
    }

    private String aplicarSustitucion(String rhs, Map<String, String> constMap, List<String> log) {
        String resultado = rhs;
        for (Map.Entry<String, String> entry : constMap.entrySet()) {
            String var = entry.getKey();
            String val = entry.getValue();
            String reemplazado = resultado.replaceAll("\\b" + Pattern.quote(var) + "\\b", val);
            if (!reemplazado.equals(resultado)) {
                log.add(var + "  →  " + val);
                resultado = reemplazado;
            }
        }
        return resultado;
    }

    private String aplicarSustitucionLinea(String instr, Map<String, String> constMap, List<String> log) {
        String resultado = instr;
        for (Map.Entry<String, String> entry : constMap.entrySet()) {
            String var = entry.getKey();
            String val = entry.getValue();
            String reemplazado = resultado.replaceAll("\\b" + Pattern.quote(var) + "\\b", val);
            if (!reemplazado.equals(resultado)) {
                log.add(var + "  →  " + val);
                resultado = reemplazado;
            }
        }
        return resultado;
    }

    private boolean esLiteral(String s) {
        if (s == null || s.isEmpty()) return false;
        try { Double.parseDouble(s); return true; } catch (NumberFormatException ignored) {}
        if (s.equals("true") || s.equals("false")) return true;
        if (s.startsWith("'") && s.endsWith("'")) return true;
        if (s.startsWith("\"") && s.endsWith("\"")) return true;
        return false;
    }
}
