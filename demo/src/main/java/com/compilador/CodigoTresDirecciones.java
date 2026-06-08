package com.compilador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Administra la lista de instrucciones de código de tres direcciones.
 * Provee métodos para emitir instrucciones, crear temporales y etiquetas,
 * imprimir el resultado y guardarlo en archivo.
 *
 * Las optimizaciones se aplican en clases separadas del paquete Optimizacion/.
 */
public class CodigoTresDirecciones {

    private List<String> instrucciones = new ArrayList<>();
    private int contadorTemp    = 1;
    private int contadorEtiq    = 1;

    /** Crea un nuevo nombre de variable temporal único: _t1, _t2, ... */
    public String nuevaTemp() {
        return "_t" + (contadorTemp++);
    }

    /** Crea una nueva etiqueta única con el prefijo dado. */
    public String nuevaEtiqueta(String prefijo) {
        return prefijo + contadorEtiq++;
    }

    /** Emite una instrucción de código intermedio. */
    public void emitir(String instruccion) {
        instrucciones.add(instruccion);
    }

    /** Emite una etiqueta (aparece con ':' al final). */
    public void marcar(String etiqueta) {
        instrucciones.add(etiqueta + ":");
    }

    public List<String> getInstrucciones() {
        return instrucciones;
    }

    public int totalInstrucciones() {
        return instrucciones.size();
    }

    /** Imprime el código intermedio numerado. */
    public void imprimir() {
        for (int i = 0; i < instrucciones.size(); i++) {
            System.out.printf("  [%3d]  %s%n", i + 1, instrucciones.get(i));
        }
    }

    /** Guarda el código intermedio en un archivo de texto. */
    public void guardarEn(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (int i = 0; i < instrucciones.size(); i++) {
                pw.printf("[%3d]  %s%n", i + 1, instrucciones.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + ruta);
        }
    }
}
