package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class Hipodromo {


    public void holaHipodromo() {
        Jugador jugador = new Jugador();
        jugador.definirNombreyCaballos();
        jugador.decidirEstrategia();
        Jugador pista = new Jugador(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.colocarCaballos();
        pista.mostrarPista();
    }

    //-----------------------------------------------------


}
