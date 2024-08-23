package com.ymcris.ipc1.practica1.carrera;

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
     * Lanza los dados y calcula el resultado.
     */
    protected void lanzarDados(int numeroDeDados) {
        resultado = 0;
        for (int i = 0; i < numeroDeDados; i++) {
            int dado = random.nextInt(6) + 1;
            resultado += dado;
            System.out.println("Dado " + (i + 1) + ": " + dado);
        }
        verificarPrimo();
        System.out.println("El caballo avanza: "+resultado+" pasos.");
    }

     protected void verificarPrimo() {
        Jugador jugador = new Jugador();
        if (resultado <= 1) {
            esPrimo = false;
        } else {
            esPrimo = true;
            for (int i = 2; i <= Math.sqrt(resultado); i++) {
                if (resultado % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }
        if(jugador.getAvanceNormal()== false){
            System.out.println("EL resultado es: "+ resultado);
        }else if(jugador.getAvanceNormal()== true){
            System.out.println(esPrimo ? "El número es primo" : "El número no es primo");
            resultado = esPrimo? resultado +6: resultado+0;        
            System.out.println("EL resultado es: "+ resultado);
        }
        return;
    }

    public int getResultado() {
        return resultado;
    }

    public boolean isEsPrimo() {
        return esPrimo;
    }

}
