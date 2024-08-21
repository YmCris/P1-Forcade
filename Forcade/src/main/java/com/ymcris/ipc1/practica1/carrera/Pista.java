package com.ymcris.ipc1.practica1.carrera;

/**
 *
 * @author YmCris
 */
public class Pista {

    protected int filas;
    protected int COLUMNAS = 200;
    protected boolean avanceJugador;
    protected boolean avanceBot;
    private String VERDE = "\033[0;32m";
    private String RESET = "\033[0m";
    protected int[][] pista = new int[filas][COLUMNAS];
    protected int[] númerodeCaballos;
    protected int[][] inicio;
    protected int[][] meta;

    public Pista(int númeroDeCaballos) {
        this.filas= númeroDeCaballos+1;
        this.pista= new int[filas][COLUMNAS];
    }

    protected void crearPista() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                pista[i][j] = 0;
            }
        }
    }

    protected void mostrarPista() {
        if (pista.length == 0 || pista[0].length == 0) {
            System.out.println("La pista no tiene dimensiones válidas.");
            return;
        }
        System.out.println("Pista:");
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j] + VERDE + "\t");
            }
            System.out.println();
            System.out.println(RESET);
        }
    }
    
}
