package com.ymcris.ipc1.practica1.anagramas;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase encargada de realizar el juego de "Anagramas en consola".
 *
 * @author YmCris
 */
public class Anagramas {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    private String[] palabrasOcultas = {"amor", "resigo", "caro", "cielo", "rango", "tenol"};
    private final String[][] palabrasValidas = {
        {"amor", "roma", "ramo", "mora"},
        {"resigo", "giro", "riesgo", "origen"},
        {"caro", "orca", "roca", "arco"},
        {"cielo", "liceo", "celio"},
        {"rango", "grano", "ganor"},
        {"tenol", "tonel", "lento", "notel"}};
    private final String MAGENTA = "\033[35m";
    private final String RESET = "\033[0m";
    private final String AZUL = "\033[34m";
    private boolean juegoTerminado = false;

    private String[] palabrasIngresadas;
    private String[] palabrasEncontradas;
    private String palabraDesordenada;
    private String palabraOculta;//***********************************
    private int palabraAOcultar;
    private int intentosRestantes;
    private int totalPalabrasPosibles;
    private int cantidadEncontrada;

    /**
     * Método constructor vacio, encargado de inicializar los intentos restantes
     * y el arreglo de las palabras ingresadas.
     */
    public Anagramas() {
        this.intentosRestantes = 4;
        this.palabrasIngresadas = new String[intentosRestantes];
        this.cantidadEncontrada = 0;
    }

    /**
     * Método encargado de iniciar el juego, tipo el main, pero para anagramas.
     */
    public void holaAnagramas() {
        System.out.println("Hola anagrama");
        ingresarPalabra();
    }

    /**
     * Método encargado de desordenar la palabra oculta y mostrarla.
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
        System.out.println(MAGENTA + "- La palabra es: " + palabraDesordenada + RESET);
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
            System.out.println(AZUL + "Ingrese la palabra: " + RESET);
            String palabraIntento = scanner.nextLine().toLowerCase();

            if (verificarPalabra(palabraIntento)) {
                System.out.println("La palabra es válida.");
                palabrasEncontradas[cantidadEncontrada++] = palabraIntento;
            } else {
                System.out.println("La palabra no es válida.");
                intentosRestantes--;
            }
            palabrasIngresadas[palabrasIngresadas.length - intentosRestantes] = palabraIntento;
            if (cantidadEncontrada == totalPalabrasPosibles) {
                System.out.println("Has hayado todas las palabras válidas, fecilitaciones.");
                break;
            }
            if (intentosRestantes == 0 && cantidadEncontrada < totalPalabrasPosibles) {
                System.out.println("Che bot");
            }
        }
    }

    /**
     * Método encargado de verificar si la palabra introducida por el usuario
     * corresponde una palabra que este en el arreglo correspondiente.
     *
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
        System.out.println("- Las palabras válidas encontradas son: " + MAGENTA);
        for (String palabra : palabrasEncontradas) {
            if (palabra != null) {
                System.out.print(palabra + " ");
            }
        }
        System.out.println(RESET);
        System.out.println("Intentos restantes: "+intentosRestantes);
        System.out.println("- La cantidad de palabras encontradas son: " + MAGENTA + "..." + RESET);
        System.out.println("- Palabras restantes: " + MAGENTA + "..." + RESET);
    }
}
