package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OPT-2: Propagación de Constantes.
 *
 * Recorre las instrucciones en orden. Cuando encuentra una asignación de la
 * forma  var = literal, registra esa constante. En instrucciones posteriores,
 * reemplaza las apariciones de esa variable por su valor literal.
 *
 * Si la variable es reasignada con un valor no-literal, se descarta del mapa.
 *
 * Ejemplo:
 *   x = 10
 *   _t1 = x + 3   →   _t1 = 10 + 3
 *
 * Se aplica como post-proceso sobre la lista de instrucciones.
 */
public class PropagacionConstantes {

    public List<String> aplicar(List<String> instrucciones) {
        Pattern patAsig = Pattern.compile("^([A-Za-z_][A-Za-z0-9_]*)\\s*=\\s*(.+)$");
        Map<String, String> constantes = new HashMap<>();
        List<String> reporte   = new ArrayList<>();
        List<String> resultado = new ArrayList<>();

        for (String linea : instrucciones) {
            String trim     = linea.trim();
            String procesada = linea;

            Matcher m = patAsig.matcher(trim);
            if (m.matches()) {
                String var = m.group(1);
                String rhs = m.group(2).trim();
                String rhsProp = sustituir(rhs, constantes, reporte);
                procesada = var + " = " + rhsProp;
                if (esLiteral(rhsProp)) constantes.put(var, rhsProp);
                else                    constantes.remove(var);
            } else if (!trim.isEmpty() && !trim.endsWith(":")) {
                procesada = sustituirLinea(linea, constantes, reporte);
            }

            resultado.add(procesada);
        }

        instrucciones.clear();
        instrucciones.addAll(resultado);
        return reporte;
    }

    private String sustituir(String rhs, Map<String, String> mapa, List<String> log) {
        String res = rhs;
        for (Map.Entry<String, String> e : mapa.entrySet()) {
            String reemplazado = res.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
            if (!reemplazado.equals(res)) {
                log.add(e.getKey() + " -> " + e.getValue());
                res = reemplazado;
            }
        }
        return res;
    }

    private String sustituirLinea(String linea, Map<String, String> mapa, List<String> log) {
        String res = linea;
        for (Map.Entry<String, String> e : mapa.entrySet()) {
            String reemplazado = res.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
            if (!reemplazado.equals(res)) {
                log.add(e.getKey() + " -> " + e.getValue());
                res = reemplazado;
            }
        }
        return res;
    }

    private boolean esLiteral(String s) {
        if (s == null || s.isEmpty()) return false;
        try { Double.parseDouble(s); return true; } catch (NumberFormatException ignored) {}
        if (s.equals("true") || s.equals("false")) return true;
        if (s.startsWith("'") && s.endsWith("'"))  return true;
        if (s.startsWith("\"") && s.endsWith("\"")) return true;
        return false;
    }
}
