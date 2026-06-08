package com.compilador.Optimizacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OPT-3: Eliminación de Código Muerto
 *
 * Identifica variables temporales (t1, t2, ...) que son asignadas
 * pero nunca utilizadas como operandos en ninguna instrucción posterior,
 * y elimina esas instrucciones de asignación.
 *
 * Ejemplo:
 *   t1 = x + 3     <- si t1 nunca aparece como operando → se elimina
 *   cout << x
 *
 * Se aplica como post-proceso sobre el resultado de OPT-2.
 */
public class OptEliminacionMuerto {

    /**
     * Aplica la optimización sobre la lista de instrucciones (modifica en el lugar).
     *
     * @param instrucciones lista de instrucciones de código de tres direcciones
     * @return lista de instrucciones eliminadas
     */
    public List<String> optimizar(List<String> instrucciones) {
        Pattern asignTemp = Pattern.compile("^(t\\d+)\\s*=");

        // Recopilar todas las temporales que son asignadas
        Set<String> asignadas = new HashSet<>();
        for (String instr : instrucciones) {
            Matcher m = asignTemp.matcher(instr.trim());
            if (m.find()) {
                asignadas.add(m.group(1));
            }
        }

        // Determinar cuáles son usadas como operandos en alguna instrucción
        Set<String> usadas = new HashSet<>();
        for (String temp : asignadas) {
            for (String instr : instrucciones) {
                String trimmed = instr.trim();
                // No cuenta la propia instrucción de asignación como "uso"
                if (trimmed.matches("^" + Pattern.quote(temp) + "\\s*=.*")) continue;
                if (trimmed.contains(temp)) {
                    usadas.add(temp);
                    break;
                }
            }
        }

        // Las muertas son las asignadas pero nunca usadas
        Set<String> muertas = new HashSet<>(asignadas);
        muertas.removeAll(usadas);

        // Eliminar instrucciones de temporales muertas
        List<String> eliminadas = new ArrayList<>();
        Iterator<String> it = instrucciones.iterator();
        while (it.hasNext()) {
            String instr = it.next();
            Matcher m = asignTemp.matcher(instr.trim());
            if (m.find() && muertas.contains(m.group(1))) {
                eliminadas.add(instr);
                it.remove();
            }
        }

        return eliminadas;
    }
}
