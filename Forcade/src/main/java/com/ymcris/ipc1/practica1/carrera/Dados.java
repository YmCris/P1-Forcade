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

    /**
     * 
     */
protected void lanzarDados() {
    Jugador jugador = new Jugador();
    jugador.definirDados();
    int numeroDeDados = jugador.getNúmeroDeDados();
    resultado = 0; // Restablecer resultado
    System.out.println("El resultado es: ");
    
    for (int i = 0; i < numeroDeDados; i++) {
        int dado = random.nextInt(6) + 1; // Número entre 1 y 6
        resultado += dado;
        System.out.println("Dado " + (i + 1) + ": " + dado);
    }
    
    System.out.println("Resultado total de los dados es: " + resultado);
}

    
    /**
     * 
     * @param resultado
     * @return 
     */
    protected boolean verificarPrimo(int resultado){
        if (resultado <=1) {
            return false;
        }
        System.out.println("El número no es primo");
        
        for (int i = 2; i < Math.sqrt(resultado); i++) {
            if (resultado % i ==0) {
                return false;
            }
            System.out.println("El número no es primo");
        }
        System.out.println("El número es primo");
        return true;
    }
    

}
