package com.compilador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CodigoTresDirecciones {

    private List<String> instrucciones = new ArrayList<>();
    private int contadorTemp    = 1;
    private int contadorEtiq    = 1;

    public String nuevaTemp() {
        return "_t" + (contadorTemp++);
    }

    public String nuevaEtiqueta(String prefijo) {
        return prefijo + contadorEtiq++;
    }

    public void emitir(String instruccion) {
        instrucciones.add(instruccion);
    }

    public void marcar(String etiqueta) {
        instrucciones.add(etiqueta + ":");
    }

    public List<String> getInstrucciones() {
        return instrucciones;
    }

    public int totalInstrucciones() {
        return instrucciones.size();
    }

    public void imprimir() {
        for (int i = 0; i < instrucciones.size(); i++) {
            System.out.printf("  [%3d]  %s%n", i + 1, instrucciones.get(i));
        }
    }

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
