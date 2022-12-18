package com.example.evaluacion4charlottegabriel.Dao;

import java.io.Serializable;

public class Carta implements Serializable {
    private String titulo;
    private String descripcion;
    private String descripcionInvertida;
    private String descripcionAmorosa;

    public Carta() {

    }

    public Carta(String titulo, String descripcion) {
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionInvertida() {
        return descripcionInvertida;
    }

    public void setDescripcionInvertida(String descripcionInvertida) {
        this.descripcionInvertida = descripcionInvertida;
    }

    public String getDescripcionAmorosa() {
        return descripcionAmorosa;
    }

    public void setDescripcionAmorosa(String descripcionAmorosa) {
        this.descripcionAmorosa = descripcionAmorosa;
    }
}
