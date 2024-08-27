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

    public void holaBattleship() {
        Tablero tablero = new Tablero();
        tablero.crearTablero();
        System.out.println("Hola Battleship");
        regresarMenu();
    }
    
    private void regresarMenu(){
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
                regresarMenu();
                break;
        }
    }
}
