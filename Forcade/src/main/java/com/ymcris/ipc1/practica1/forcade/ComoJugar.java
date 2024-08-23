package com.ymcris.ipc1.practica1.forcade;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class ComoJugar {

    Scanner scanner = new Scanner(System.in);
    int regresar;

    public void ayuda() {
        System.out.println("Bienvenido a la ayuda de forcade, aquí podrás obtener información de como se juegan los videojuegos.");
        System.out.println("Recomendamos ampliamente leer el manual de usuario donde se detallan a profundidad cada juego.");
        System.out.println("Selecciona el juego que desees saber como se juega:");
        System.out.println("1. Carrera de Caballos en el Hipodromo.");
        System.out.println("2. Anagramas.");
        System.out.println("3. Battleship.");
        System.out.println("4. Regresar al menú.");
        int opciónJuego = scanner.nextInt();
        switch (opciónJuego) {
            case 1:
                comoJugarCaballos();
                break;
            case 2:
                comoJugarAnagramas();
                break;
            case 3:
                comoJugarBattleship();
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }
    }

    public void comoJugarCaballos() {
        int regresar;
        System.out.println("Carrera de caballos en el hipodromo es un juego ");
        
        
    }

    public void comoJugarAnagramas() {

    }

    public void comoJugarBattleship() {

    }
}
