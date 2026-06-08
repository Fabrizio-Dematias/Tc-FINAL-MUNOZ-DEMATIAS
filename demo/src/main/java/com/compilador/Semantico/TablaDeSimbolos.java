package com.compilador.Semantico;

import java.util.ArrayList;
import java.util.List;

/**
 * Tabla de símbolos del compilador.
 * Almacena todas las entradas y permite buscarlas por nombre y ámbito.
 */
public class TablaDeSimbolos {

    private final List<EntradaSimbolo> entradas = new ArrayList<>();

    /** Agrega un nuevo símbolo a la tabla. */
    public void registrar(EntradaSimbolo entrada) {
        entradas.add(entrada);
    }

    /** Verifica si un nombre ya fue declarado en el ámbito dado. */
    public boolean existe(String nombre, String ambito) {
        for (EntradaSimbolo e : entradas) {
            if (e.nombre.equals(nombre) && e.ambito.equals(ambito)) return true;
        }
        return false;
    }

    /**
     * Busca un símbolo por nombre.
     * Recorre de atrás hacia adelante para respetar el ámbito más cercano.
     */
    public EntradaSimbolo obtener(String nombre) {
        for (int i = entradas.size() - 1; i >= 0; i--) {
            if (entradas.get(i).nombre.equals(nombre)) return entradas.get(i);
        }
        return null;
    }

    public List<EntradaSimbolo> getEntradas() {
        return entradas;
    }

    /** Imprime la tabla con formato de columnas. */
    public void mostrar() {
        System.out.println("\n+------------------+-----------+--------------+--------+---------+------------------+");
        System.out.printf( "| %-16s | %-9s | %-12s | %-6s | %-7s | %-16s |%n",
                "NOMBRE", "TIPO", "CATEGORÍA", "LÍNEA", "COLUMNA", "ÁMBITO");
        System.out.println("+------------------+-----------+--------------+--------+---------+------------------+");
        for (EntradaSimbolo e : entradas) {
            System.out.printf("| %-16s | %-9s | %-12s | %-6d | %-7d | %-16s |%n",
                    e.nombre, e.tipo, e.categoria, e.linea, e.columna, e.ambito);
        }
        System.out.println("+------------------+-----------+--------------+--------+---------+------------------+");
    }
}
