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
        Dados dado = new Dados();
        Jugador jugador = new Jugador();
        
        jugador.definirNombreyCaballos();
        jugador.definirDados();
        jugador.decidirEstrategia();
        dado.lanzarDados(jugador.getNúmeroDeDados());
        Jugador pista = new Jugador(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.colocarCaballos();
        pista.moverCaballoJugador(dado.getResultado());
        pista.mostrarPista();
    }

    //-----------------------------------------------------


}
