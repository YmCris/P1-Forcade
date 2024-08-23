package com.ymcris.ipc1.practica1.reportes;

import com.ymcris.ipc1.practica1.carrera.Jugador;
import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Scanner;

/**
 * Clase encargada de realizar los reportes del programa.
 *
 * @author YmCris
 */
public class Reportes {

    Scanner scanner = new Scanner(System.in);
    Jugador jugador = new Jugador();
    Forcade forcade = new Forcade();

    private int opcion;

    /**
     * Método encargado de mostrar los diferentes reportes disponibles.
     */
    public void holaReportes() {
        System.out.println("\n".repeat(100));
        System.out.println("                                                Bienvenido a los reportes de Forcade");
        System.out.println("                    Aquí podrá hallar información de las acciones que se han relizado durante la ejecución del programa.");
        System.out.println("                          Tome en cuenta que al cerrar el programa esta información se perderá de forma definitiva.");
        System.out.println("\n".repeat(3));
        System.out.println("1. Cantidad de veces que cada juego se ha iniciado por separado.");
        System.out.println("2. Cantidad de veces que el jugador ha perdido en el hipódromo.");
        System.out.println("3. Cantidad de veces que el jugador ha ganado en el hipódromo.");
        System.out.println("4. Color de caballo que más ha ganado y su cantidad de veces ganadas.");
        System.out.println("5. Regresar al menú principal.");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                mostrarInicioDeCadaJuego();
                break;
            case 2:
                mostrarVecesPerdidasEnHipodromo();
                break;
            case 3:
                mostrarVecesGanadasEnHipodromo();
                break;
            case 4:
                mostrarColorDeCaballo();
                break;
            case 5:
                forcade.menuPrincipal();
                break;
            default:
                holaReportes();
                System.out.println("Entrada no válida, por favor ingrese un número del 1 al 5.");
                break;
        }
    }

    /**
     * Método encargado de mostrar las veces que se han iniciado cada juego.
     */
    private void mostrarInicioDeCadaJuego() {
        System.out.println("\n".repeat(100));
        System.out.println("La cantidad de veces que se ha iniciado el juego de Carrera de caballos en el hipódromo es:");
        System.out.println(forcade.getInicioHipodromo() + " veces.");
        System.out.println("La cantidad de veces que se ha iniciado el juego de Anagramas es:");
        System.out.println(forcade.getInicioAnagramas() + " veces.");
        regresarAlMenu();
    }

    /**
     * Método encargado de mostrar las veces que se han ganado en el juego de
     * hipódromo.
     */
    private void mostrarVecesGanadasEnHipodromo() {
        System.out.println("\n".repeat(100));
        System.out.println("La cantidad de veces que se ha ganado la carrera de caballos en el hipódromo es:");
        System.out.println(jugador.getPartidasGanadas() + " veces.");
        regresarAlMenu();
    }

    /**
     * Método encargado de mostrar las veces que se han perdido en el juego de
     * hipódromo.
     */
    private void mostrarVecesPerdidasEnHipodromo() {
        System.out.println("\n".repeat(100));
        System.out.println("La cantidad de veces que se ha perdido la carrera de caballos en el hipódromo es:");
        System.out.println(jugador.getPartidasPerdidas() + " veces.");
        regresarAlMenu();
    }

    /**
     * Método encargado de mostrar el color de caballo que más ha ganado.
     */
    private void mostrarColorDeCaballo() {

    }

    /**
     * Método que permite regresar al menu luego de ver cada reporte.
     */
    private void regresarAlMenu() {
        int opcion;
        System.out.println("\n".repeat(3));
        System.out.println("Ingrese 1 para volver a la sección de reportes.");
        System.out.println("Ingrese 2 para ir al menú principal.");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                holaReportes();
                break;
            case 2:
                forcade.menuPrincipal();
                break;
            default:
                System.out.println("Entrada no válida, por favor ingrese 1 o 2.");
                mostrarVecesGanadasEnHipodromo();
                break;
        }
    }

}
