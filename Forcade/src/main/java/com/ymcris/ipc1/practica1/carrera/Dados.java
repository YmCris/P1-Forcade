package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author crist
 */
public class Dados {

    Random random = new Random();
    int resultado = 0;
    boolean esPrimo;
    Jugador jugador = new Jugador();

    protected void definirDado() {
        jugador.definirDados();
    }

    protected void lanzarDados() {
        int numeroDeDados = jugador.getNúmeroDeDados();
        resultado = 0;
        for (int i = 0; i < numeroDeDados; i++) {
            int dado = random.nextInt(6) + 1;
            resultado += dado;
            System.out.println("Dado " + (i + 1) + ": " + dado);
        }
        //System.out.println("Resultado total de los dados es: " + resultado);
        verificarPrimo(resultado);
    }

    /**
     *
     * @param resultado
     * @return verdadero = es primo, falso = no es primo
     */
    protected boolean verificarPrimo(int resultado) {
        if (resultado <= 1) {
            esPrimo = false;
            return false;
        } else if (true) {
            for (int i = 2; i < Math.sqrt(resultado); i++) {
                if (resultado % i == 0) {
                    System.out.println("El número no es primo");
                    esPrimo = false;
                    return false;
                }
            }
        }
        System.out.println("El número es primo");
        esPrimo = true;
        return true;
    }

    public int getResultado() {
        return resultado;
    }

    public boolean isEsPrimo() {
        return esPrimo;
    }

}
