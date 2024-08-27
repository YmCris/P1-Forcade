package com.ymcris.ipc1.practica1.battleship;

import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Scanner;

/**
 * Clase encargada de realizar el juego de "Battleship en consola".
 *
 * @author YmCris
 */
public class Battleship {

    Scanner scanner = new Scanner(System.in);
    private int filas;
    private int columnas;

    public void holaBattleship() {
        inicio();
        partidaTerminada();
    }

    public Battleship(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public Battleship() {
    }

    public void iniciarBattleship() {
        System.out.println("Ingresa el número de filas del tablero:");
        filas = scanner.nextInt();
        if (filas < 20) {
            System.out.println("El tablero tiene que tener un máximo de 20 filas.");
            iniciarBattleship();
        }
        System.out.println("Ingresa el número de columnas del tablero:");
        columnas = scanner.nextInt();
        if (columnas > 10 || columnas < 9) {
            System.out.println("El tablero tiene que tener un tamaño de 10");
            iniciarBattleship();
        }
        if (filas <= 20 && columnas == 10) {
            Tablero tablero = new Tablero(filas, columnas);
            tablero.crearTablero1();
        }
    }

    private void inicio() {
        Forcade forcade = new Forcade();
        System.out.println("                            Bienvenido a Battleship.");
        System.out.println("1. Juego con 2 jugadores.");
        System.out.println("2. Juego con 1 jugador.");
        System.out.println("3. Resgresar al menú.");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                iniciarBattleship();
                break;
            case 2:
                forcade.menuPrincipal();
                break;
            case 3:
                forcade.menuPrincipal();
                break;
            default:
                System.out.println("Opción no válida, introduzca una opción del 1 al 3");
                inicio();
                break;
        }
    }

    private void partidaTerminada() {
        Forcade forcade = new Forcade();
        int juegoFinalizado;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Juego Finalizado, ¿qué desea realizar?");
        System.out.println("1. Ir al menú principal.");
        System.out.println("2. Terminar el programa.");
        juegoFinalizado = scanner.nextInt();
        switch (juegoFinalizado) {
            case 1:
                System.out.println("\n".repeat(100));
                forcade.menuPrincipal();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("\n".repeat(100));
                System.out.println("Por favor, ingresa una entrada válida.");
                partidaTerminada();
                break;
        }
    }
}
