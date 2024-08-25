package com.ymcris.ipc1.practica1.carrera;

import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Scanner;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class Hipodromo {

    private Scanner scanner = new Scanner(System.in);

    private String MAGENTA = "\033[35m";
    private String RESET = "\033[0m";
    private String AZUL = "\033[34m";

    /**
     * Método encargado de juntar todo las instancias y métodos requeridos para
     * el funcionamiento de la carrera de caballos. También en que el juego siga
     * en curso (No debería, pero ya me tardé mucho con el juego).
     */
    public void holaHipodromo() {
        Jugador jugador = new Jugador();

        jugador.definirNombre();
        jugador.definirCaballos();
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
            if (verificarGanador(pista)) {
                System.out.println("La carrera ha acabado.");
                juegoEnCurso = false;
            } else {
                System.out.println("");
                System.out.println(AZUL + "Seleccione su estrategia:" + RESET);
                System.out.println("1. Avanzar normal.");
                System.out.println("2. Avanzar con riesgo.");
                System.out.println("3. Regresar al menú principal.");
                int respuesta = scanner.nextInt();
                switch (respuesta) {
                    case 1:
                        juegoEnCurso = true;
                        System.out.println("Caballo avanza normal.");
                        break;
                    case 2:
                        System.out.println("Caballo avanza con riesgo.");
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
     * Verifica si algún caballo ha ganado.
     *
     * @param pista La pista del juego.
     * @return true si algún caballo ha ganado, false en caso contrario.
     */
    private boolean verificarGanador(Jugador pista) {
        Jugador jugador = new Jugador();
        int posicionJugador = pista.getPosicionCaballo(0);
        if (pista.getPosicionCaballo(0) >= pista.COLUMNAS - 1) {
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
