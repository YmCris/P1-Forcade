package com.ymcris.ipc1.practica1.battleship;

import java.util.Scanner;

/**
 *
 * @author YmCris
 */
public class Tablero {

    Scanner scanner = new Scanner(System.in);

    protected char[] filasLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
    protected char[] columnasNumeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    protected String nombre;
    protected String color;
    protected int filas;
    protected int columnas;
    protected char[][] tablero;
    protected int[][] posicion;
    protected int numero;

    public Tablero() {
    }

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new char[filas][columnas];
    }

    public void crearTablero1() {
        for (int i = 0; i < filas; i++) {
            System.out.print(filasLetras[i] + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '▓';
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.print("  ");
        for (char columna : columnasNumeros) {
            System.out.print("  " + columna);
        }
        System.out.println();
    }

    public void colocarBarcos() {
        System.out.println("¿Qué barco desea colocar?");
        System.out.println("1. Poortaaviones C (5 Celdas)");
        System.out.println("2. Acorazado     B (4 Celdas)");
        System.out.println("3. Crucero       R (3 Celdas)");
        System.out.println("4. Submarino     S (2 Celdas)");
        System.out.println("5. Destructor    D (1 Celda)");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Opción no válida, ingrese una válida");
                colocarBarcos();
                break;
        }
    }

}
