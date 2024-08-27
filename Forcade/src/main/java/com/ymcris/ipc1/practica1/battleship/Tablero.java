package com.ymcris.ipc1.practica1.battleship;

/**
 *
 * @author YmCris
 */
public class Tablero {

    Barco tabler = new Barco();

    protected String nombre;
    protected String color;
    protected int[][] tablero;
    protected int[][] posicion;
    protected int numero;

    private final int FILAS = 10;
    private final int COLUMNAS = 10;

    public Tablero() {
        this.tablero = new int[FILAS][COLUMNAS];
    }

    public Tablero(String nombre, int[][] posicion, int numero) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numero = numero;
    }

    public void crearTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                Barco barco = new Barco();
                tablero[i][j] = 0;
                System.out.print(tablero[i][j]+"    ");
            }
            System.out.println("");
        }
    }

}
