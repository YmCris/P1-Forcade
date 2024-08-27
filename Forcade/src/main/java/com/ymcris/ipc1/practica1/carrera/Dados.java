package com.ymcris.ipc1.practica1.carrera;

import java.util.Random;

/**
 *
 * @author YmCris
 */
public class Dados {

    Random random = new Random();

    private String RESET = "\033[0m";
    private String AZUL = "\033[34m";

    int resultado;
    boolean esPrimo;

    /**
     * Método encargado de lanzar los dados y calcula el resultado.
     *
     * @param numeroDeDados - Número que el usuario introduce.
     */
    protected void lanzarDados(int numeroDeDados) {
        System.out.println("\n".repeat(100));
        resultado = 0;
        System.out.println(AZUL + "Resultado De los dados:" + RESET);
        for (int i = 0; i < numeroDeDados; i++) {
            int dado = random.nextInt(6) + 1;
            resultado += dado;
            System.out.println("Dado " + (i + 1) + ": " + dado);
        }
        System.out.println("El caballo avanza: " + resultado + " pasos.");
    }

    //GETTERS & SETTERS que creo no se utilizaron, porque se reinicia siempre :(
    public int getResultado() {
        return resultado;
    }

    public boolean isEsPrimo() {
        return esPrimo;
    }
}
