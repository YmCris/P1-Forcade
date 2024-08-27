package com.ymcris.ipc1.practica1.anagramas;

import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Scanner;
import java.util.Random;

/**
 * Clase encargada de realizar el juego de "Anagramas en consola".
 *
 * @author YmCris
 */
public class Palabras {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    private final String[] palabrasOcultas = {"amor", "resigo", "caro", "cielo", "resta", "tenol"};
    private final String[][] palabrasValidas = {
        {"amor", "roma", "ramo", "mora"},
        {"resigo", "riesgo", "sergio"},
        {"caro", "orca", "roca", "arco"},
        {"cielo", "liceo", "celio"},
        {"resta", "estar", "artes"},
        {"tonel", "lento", "notel"}};
    private final String MAGENTA = "\033[35m";
    private final String RESET = "\033[0m";
    private final String AZUL = "\033[34m";

    private final String[] palabrasIngresadas;
    private String[] palabrasEncontradas;
    private String palabraDesordenada;
    private String palabraOculta;
    private int palabraAOcultar;
    private int intentosRestantes;
    private int totalPalabrasPosibles;
    private int cantidadEncontrada;

    /**
     * Método constructor vacio, encargado de inicializar los intentos restantes
     * y el arreglo de las palabras ingresadas.
     */
    public Palabras() {
        this.intentosRestantes = 4;
        this.palabrasIngresadas = new String[intentosRestantes];
        this.cantidadEncontrada = 0;
    }

    /**
     * Método encargado de iniciar el juego, tipo el main, pero para anagramas.
     */
    public void holaAnagramas() {
        ingresarPalabra();
    }

    /**
     * Método encargado de desordenar la palabra oculta con el algoritmo de y
     * mostrarla.
     */
    private void desordenarPalabraOculta() {
        palabraAOcultar = random.nextInt(palabrasOcultas.length);
        palabraOculta = palabrasOcultas[palabraAOcultar];
        char[] caracteresDeLaPalabra = palabraOculta.toCharArray();
        for (int i = caracteresDeLaPalabra.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char indice = caracteresDeLaPalabra[i];
            caracteresDeLaPalabra[i] = caracteresDeLaPalabra[j];
            caracteresDeLaPalabra[j] = indice;
        }
        palabraDesordenada = new String(caracteresDeLaPalabra);
        totalPalabrasPosibles = palabrasValidas[palabraAOcultar].length;
        palabrasEncontradas = new String[totalPalabrasPosibles];
    }

    /**
     * Método encargado de pedir la palabra al usuario, guardarla y estar los
     * intentos
     */
    private void ingresarPalabra() {
        desordenarPalabraOculta();
        while (intentosRestantes > 0) {
            mostrarEstadoActual();
            System.out.print("- Las palabras que se han introducido son:                  ");
            for (String palabrasIngresadasUsuario : palabrasIngresadas) {
                System.out.print(MAGENTA + palabrasIngresadasUsuario + "        " + RESET);
            }
            System.out.println("");
            System.out.println(AZUL + "No puedes usar 2 veces una letra. Ingrese la palabra: " + "              (Presione enter para volver al menú principal) " + RESET);
            String palabraIntento = scanner.nextLine().toLowerCase();
            if (palabraIntento.isEmpty()) {
                Forcade forcade = new Forcade();
                forcade.menuPrincipal();
            }
            if (verificarLetrasRepetidas(palabraIntento)) {
                System.out.println("\n".repeat(100));
                System.out.println("La palabra contiene letras repetidas, pierdes dos turns.");
                intentosRestantes--;
            } else {
                System.out.println("\n".repeat(100));
                System.out.println("La palabra no contiene letras repetidas.");
            }
            if (verificarPalabra(palabraIntento)) {
                System.out.println("La palabra es válida.");
                palabrasEncontradas[cantidadEncontrada++] = palabraIntento;
                intentosRestantes++;
            } else {
                System.out.println("La palabra no es válida.");
            }
            int indiceError = palabrasIngresadas.length - intentosRestantes;
            if (indiceError >= 0 && indiceError < palabrasIngresadas.length) {
                palabrasIngresadas[indiceError] = palabraIntento;
            } else {
                System.out.println("");
            }
            intentosRestantes--;
            if (cantidadEncontrada == totalPalabrasPosibles) {
                System.out.println("Has hayado todas las palabras válidas, fecilitaciones.");
                partidaFinalizada();
                break;
            }
            if (intentosRestantes == 0 && cantidadEncontrada < totalPalabrasPosibles) {
                System.out.println("No has hayado todas las palaabras válidas, mejor suerte en la próxima!");
                partidaFinalizada();
            }
        }
    }

    /**
     * Método encargado de verificar si la palabra del usuario contiene letras
     * repetidas.
     *
     * @param palabra - Palabra utilizada para verificar si se repiten
     * carácteres (Palabra intento)
     * @return true - si se repiten
     */
    private boolean verificarLetrasRepetidas(String palabra) {
        boolean[] letrasUsadas = new boolean[27];
        for (char letra : palabra.toCharArray()) {
            if (letra >= 'a' && letra <= 'z') {
                int indice = letra - 'a';
                if (letrasUsadas[indice]) {
                    return true;
                }
                letrasUsadas[indice] = true;
            }
        }
        return false;
    }

    /**
     * Método encargado de verificar si la palabra introducida por el usuario
     * corresponde una palabra que este en el arreglo correspondiente.
     *
     * @param palabraUsuario Es la palabra que se va a verificar si cumple con
     * estar en tre las palabras válidas.
     * @return juegoTerminado - Determina si el jugador acerto la palabra y así
     * termina el juego.
     */
    private boolean verificarPalabra(String palabraUsuario) {
        for (String palabras : palabrasValidas[palabraAOcultar]) {
            if (palabras.equals(palabraUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de proporcionar información al jugador durante toda la
     * partida.
     */
    private void mostrarEstadoActual() {
        System.out.println(MAGENTA + "- La palabra es: " + palabraDesordenada + RESET);
        System.out.println(MAGENTA + "- Intentos restantes: " + intentosRestantes + RESET);
        System.out.println("- Las palabras válidas encontradas son: " + MAGENTA);
        for (String palabra : palabrasEncontradas) {
            if (palabra != null) {
                System.out.print(palabra + " ");
            }
        }
        System.out.println(RESET);
        System.out.println("- La cantidad de palabras encontradas son: " + this.cantidadEncontrada);
        System.out.println("- Palabras restantes: " + MAGENTA + (this.totalPalabrasPosibles - this.cantidadEncontrada) + RESET);
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
                System.out.println("Por favor, ingresa una entrada válida.");
                partidaFinalizada();
                break;
        }
    }
}
