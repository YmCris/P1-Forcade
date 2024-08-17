package com.ymcris.ipc1.practica1.forcade;

import com.ymcris.ipc1.practica1.anagramas.Anagramas;
import com.ymcris.ipc1.practica1.battleship.Battleship;
import com.ymcris.ipc1.practica1.carrera.CarreraDeCaballos;

/**
 *
 * @author YmCris
 * @version 21.0.2
 * @see Anagramas
 * @see Battleship
 * @see CarreraDeCaballos
 * @see Reportes
 */
public class Forcade {

    String[] args = {"Hipodromo", "Anagramas", "Battleship"};

    /**
     * Método principal encargado de iniciar el programa.
     *
     * @param args - Argumento de la línea de comandos utilizados para iniciar
     * directamente un juego específico basado en el parámetro ingresado.
     *
     */
    public static void main(String[] args) {
        Forcade inicio = new Forcade();
        inicio.parámetroInicial();
    }

    /**
     * Método encargado de procesar el parámetro ingresado en la consola y
     * ejecutar el juego correspondiente de manera inmediata.
     */
    private void parámetroInicial() {
        if (args.length > 0) {
            if (args[0].equals("Hipodromo")) {
                CarreraDeCaballos carrera = new CarreraDeCaballos();
                carrera.holaHipodromo();
            } else if (args[0].equals("Anagramas")) {
                Anagramas anagrama = new Anagramas();
                anagrama.holaAnagramas();
            } else if (args[0].equals("Battleship")) {
                Battleship battle = new Battleship();
                battle.holaBattleship();
            } else {
                System.out.println("Syntax error");
            }
        } else {
            System.out.println("Oh me bugeo");
        }
    }
}
