package com.ymcris.ipc1.practica1.battleship;

/**
 *
 * @author YmCris
 */
public class Barco {

    protected String nombre;
    protected String color;
    protected int tamaño;
    protected int numero;

    public Barco(String nombre, String color, int tamaño, int numero) {
        this.nombre = nombre;
        this.color = color;
        this.tamaño = tamaño;
        this.numero = numero;
    }

    public Barco() {
        nombre = "";
        color = "";
        tamaño = 0;
        numero = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
