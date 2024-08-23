package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class Hipodromo {

    private Scanner scanner = new Scanner(System.in);

    public void holaHipodromo() {
        Jugador jugador = new Jugador();

        jugador.definirNombreyCaballos();
        jugador.definirDados();
        jugador.decidirEstrategia();

        Dados dado = new Dados();
        Jugador pista = new Jugador(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.colocarCaballos();

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            dado.lanzarDados(jugador.getNúmeroDeDados());
            pista.moverCaballoJugador(dado.getResultado());
            pista.mostrarPista();

            // Verifica si el juego ha terminado
            if (verificarGanador(pista)) {
                System.out.println("¡El juego ha terminado!");
                juegoEnCurso = false;
            } else {
                System.out.println("Seleccione su estrategia:");
                System.out.println("1. Avanzar normal.");
                System.out.println("2. Avanzar con riesgo.");
                System.out.println("3. Terminar el juego.");
                int respuesta = scanner.nextInt();
                switch (respuesta) {
                    case 1:
                        juegoEnCurso=true;
                        System.out.println("Caballo avanza normal.");
                        break;
                    case 2:
                        System.out.println("Caballo avanza con riesgo.");
                        juegoEnCurso = true;
                        break;
                    case 3:
                        System.out.println("Juego terminado por el usuario.");
                        juegoEnCurso = false;
                        break;
                    default:
                        System.out.println("Entrada no válida >:(");
                        break;
                }
            }
        }
    }

    /**
     * Verifica si algún caballo ha ganado.
     *
     * @param pista La pista del juego.
     * @return true si algún caballo ha ganado, false en caso contrario.
     */
    private boolean verificarGanador(Jugador pista) {
        for (int i = 0; i < pista.getNúmeroDeCaballos(); i++) {
            // Verifica si el caballo ha llegado al final de la pista
            if (pista.getPosicionCaballo(i) >= pista.COLUMNAS - 2) {
                System.out.println("¡Caballo " + (i + 1) + " ha ganado!");
                return true;
            }
        }
        return false;
    }
}
