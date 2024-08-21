package com.ymcris.ipc1.practica1.carrera;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class MotorDelJuegoHipodromo {

    Pista pista;
    public void holaHipodromo(){
        System.out.println("Hola Hipodromo");
        Jugador jugador = new Jugador();
        jugador.definirNombreyCaballos();
        Pista pista = new Pista(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.mostrarPista();
    }
    
    
}
