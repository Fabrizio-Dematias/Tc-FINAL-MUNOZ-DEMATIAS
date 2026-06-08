package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OPT-3: Eliminación de Código Muerto.
 *
 * Identifica variables temporales (prefijo _t) que son asignadas pero
 * nunca utilizadas como operandos en ninguna instrucción posterior.
 * Esas instrucciones de asignación se eliminan del código intermedio.
 *
 * Ejemplo:
 *   _t3 = x + 1    <- si _t3 no aparece en ningún otro lugar → se elimina
 *   cout x
 *
 * Se aplica como post-proceso sobre el resultado de OPT-2.
 */
public class CodigoMuerto {

    /**
     * Aplica la optimización sobre la lista de instrucciones (modifica en el lugar).
     *
     * @param instrucciones lista de instrucciones de código intermedio
     * @return lista de instrucciones que fueron eliminadas
     */
    public List<String> aplicar(List<String> instrucciones) {
        Pattern patTemp = Pattern.compile("^(_t\\d+)\\s*=");

        // Paso 1: recopilar todas las temporales que se asignan
        Set<String> asignadas = new HashSet<>();
        for (String linea : instrucciones) {
            Matcher m = patTemp.matcher(linea.trim());
            if (m.find()) asignadas.add(m.group(1));
        }

        // Paso 2: determinar cuáles son usadas como operandos
        Set<String> usadas = new HashSet<>();
        for (String temp : asignadas) {
            for (String linea : instrucciones) {
                String trim = linea.trim();
                if (trim.matches("^" + Pattern.quote(temp) + "\\s*=.*")) continue;
                if (trim.contains(temp)) { usadas.add(temp); break; }
            }
        }

        // Paso 3: eliminar las asignaciones de temporales muertas
        Set<String> muertas = new HashSet<>(asignadas);
        muertas.removeAll(usadas);

        List<String> eliminadas = new ArrayList<>();
        Iterator<String> it = instrucciones.iterator();
        while (it.hasNext()) {
            String linea = it.next();
            Matcher m = patTemp.matcher(linea.trim());
            if (m.find() && muertas.contains(m.group(1))) {
                eliminadas.add(linea);
                it.remove();
            }
        }

        return eliminadas;
    }
}
