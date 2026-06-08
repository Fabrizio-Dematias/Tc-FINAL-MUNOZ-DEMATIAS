package com.compilador.Semantico;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una entrada en la tabla de símbolos.
 * Guarda toda la información de una variable, función o parámetro.
 */
public class EntradaSimbolo {

    public String nombre;
    public String tipo;
    public String categoria;    // "variable", "funcion", "parametro"
    public int    linea;
    public int    columna;
    public String ambito;
    public String info;         // detalles extra (tamaño de arreglo, params de función)
    public boolean referenciado = false;

    // Para funciones: lista de tipos de sus parámetros
    public List<String> tiposParametros = new ArrayList<>();

    public EntradaSimbolo(String nombre, String tipo, String categoria,
                          int linea, int columna, String ambito, String info) {
        this.nombre    = nombre;
        this.tipo      = tipo;
        this.categoria = categoria;
        this.linea     = linea;
        this.columna   = columna;
        this.ambito    = ambito;
        this.info      = info;
    }
}
