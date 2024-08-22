package com.ymcris.ipc1.practica1.carrera;

/**
 * Clase encargada de realizar el juego de "Carrera de Caballos en el
 * Hipódromo."
 *
 * @author YmCris
 */
public class Hipodromo {

    Jugador jugador = new Jugador();
    int númeroDeCaballos = jugador.getNúmeroDeCaballos();
    int númeroDeDados = jugador.getNúmeroDeDados();

    public void holaHipodromo() {
        Jugador jugador = new Jugador();
        jugador.definirNombreyCaballos();
        Dados dado = new Dados();
        dado.lanzarDados();
        dado.verificarPrimo(númeroDeDados);
        Pista pista = new Pista(jugador.getNúmeroDeCaballos());
        pista.crearPista();
        pista.mostrarPista();
    }

}
