package com.ymcris.ipc1.practica1.carrera;

import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class Hipodromo {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private final String MAGENTA = "\033[35m";
    private final String RESET = "\033[0m";
    private final String AZUL = "\033[34m";

    /**
     * Método encargado de juntar todo las instancias y métodos requeridos para
     * el funcionamiento de la carrera de caballos. También en que el juego siga
     * en curso (No debería, pero ya me tardé mucho con el juego).
     */
    public void holaHipodromo() {
        Jugador jugador = new Jugador();
        jugador.definirNombre();
        jugador.definirCaballosPredeterminados();
        jugador.decidirEstrategia();

        Dados dado = new Dados();
        Jugador pista = new Jugador(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.colocarCaballos();

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            pista.mostrarPista();
            if (verificarGanador(pista)) {
                System.out.println("Carrera terminada.");
                juegoEnCurso = false;
            } else {
                System.out.println("");
                System.out.println(AZUL + "Seleccione su estrategia:" + RESET);
                System.out.println("1. Avanzar normal: El caballo avanza lo que salga en los dados.");
                System.out.println("2. Avanzar con riesgo: El caballo puede avanzar el doble o no avanzar nada.");
                System.out.println("3. Regresar al menú principal.");
                int respuesta = scanner.nextInt();
                dado.lanzarDados(jugador.getNúmeroDeDados());
                int resultado = dado.getResultado();
                boolean esPrimo = esPrimo(resultado);
                switch (respuesta) {
                    case 1:
                        juegoEnCurso = true;
                        System.out.println("Caballo avanza normal.");
                        pista.moverCaballoJugador(resultado);
                        pista.moverCaballosAleatorios(resultado);
                        break;
                    case 2:
                        System.out.println("Caballo avanza con riesgo.");
                        if (esPrimo) {
                            System.out.println("El número " + resultado + " es primo.");
                            System.out.println("El caballo avanza el doble.");
                            pista.moverCaballoJugador(resultado * 2);
                            pista.moverCaballosAleatorios(resultado);
                        } else {
                            System.out.println("El número " + resultado + " no es primo.");
                            System.out.println("El caballo no avanza nada.");
                            pista.moverCaballosAleatorios(resultado);
                        }
                        juegoEnCurso = true;
                        break;
                    case 3:
                        juegoEnCurso = false;
                        Forcade forcade = new Forcade();
                        forcade.menuPrincipal();
                        break;
                    default:
                        System.out.println("Entrada no válida >:(");
                        break;
                }
            }
        }
    }

    /**
     * Método encargado si un número es primo
     *
     * @param numero número a evaluar
     * @return true si es primo
     */
    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si algún caballo ha ganado.
     *
     * @param pista La pista del juego.
     * @return true si algún caballo ha ganado, false en caso contrario.
     */
    private boolean verificarGanador(Jugador pista) {
        Jugador jugador = new Jugador();
        int posicionJugador = pista.getPosicionCaballo(0);
        for (int i = 0; i <= pista.getNúmeroDeCaballos(); i++) {
            if (pista.getPosicionCaballo(i) >= pista.COLUMNAS - 1 && posicionJugador >= pista.COLUMNAS - 1) {
                System.out.println("Hubo un empate entre el jugador " + jugador.getNombre() + " y el caballo " + (i + 1));
            }
        }
        if (posicionJugador >= pista.COLUMNAS - 1) {
            System.out.println(MAGENTA + "El caballo de " + jugador.getNombre() + jugador.nombre + " es el ganador." + RESET);
            jugador.setPartidasGanadas(+1);
            System.out.println(MAGENTA + "EL jugador ha ganado: " + jugador.getPartidasGanadas() + " veces." + RESET);
            partidaFinalizada();
            return true;
        }
        for (int i = 0; i <= pista.getNúmeroDeCaballos(); i++) {
            if (pista.getPosicionCaballo(i) >= pista.COLUMNAS - 1) {
                System.out.println(MAGENTA + "El Caballo " + (i + 1) + " ha ganado la partida." + RESET);
                jugador.setPartidasPerdidas(+1);
                System.out.println(MAGENTA + "EL jugador ha perdido: " + jugador.getPartidasPerdidas() + " veces." + RESET);
                partidaFinalizada();
                return true;
            } else if (pista.getPosicionCaballo(i) >= pista.COLUMNAS - 1 && pista.getPosicionCaballo(0) >= pista.COLUMNAS - 1) {
                System.out.println("El caballo " + (i + 1) + " y el jugador " + jugador.getNombre() + " empataron la partida");
            }
        }
        return false;
    }

    /**
     * Método encargado de dar las opciones después de finalizada la partida.
     */
    private void partidaFinalizada() {
        Forcade forcade = new Forcade();
        int juegoFinalizado;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Juego Finalizado, ¿qué desea realizar?");
        System.out.println("1. Volver a jugar.");
        System.out.println("2. Ir al menú principal.");
        System.out.println("3. Terminar el programa.");
        juegoFinalizado = scanner.nextInt();
        switch (juegoFinalizado) {
            case 1:
                forcade.setInicioHipodromo(+1);
                holaHipodromo();
                break;
            case 2:
                forcade.menuPrincipal();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Por favor, ingresa una entrada válida.");
                partidaFinalizada();
                break;
        }
    }
}
