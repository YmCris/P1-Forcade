package com.ymcris.ipc1.practica1.forcade;

import com.ymcris.ipc1.practica1.anagramas.Anagramas;
import com.ymcris.ipc1.practica1.battleship.Battleship;
import com.ymcris.ipc1.practica1.carrera.MotorDelJuegoHipodromo;
import java.util.Scanner;

/**
 *
 * @author YmCris
 * @version 21.0.2
 * @see Anagramas
 * @see Battleship
 * @see CarreraDeCaballos
 */
public class Forcade {

    MotorDelJuegoHipodromo motorH;
    Scanner scanner = new Scanner(System.in);
    int opciónJuego;
    
    /**
     * Método principal encargado de iniciar el programa.
     *
     * @param args - Argumentos de la línea de comandos utilizados para iniciar
     * directamente un juego específico basado en el parámetro ingresado.
     */
    public static void main(String[] args) {
        Forcade inicio = new Forcade();
        inicio.parámetroInicial(args);
        inicio.selecciónDeJuegos();
    }

    /**
     * Método encargado de procesar el parámetro ingresado en la consola y
     * ejecutar el juego correspondiente de manera inmediata.
     *
     * @param args - Argumentos de la línea de comandos que especifican el juego
     * a ejecutar.
     */
    private void parámetroInicial(String[] args) {
        if (args.length > 0) {
            String comando = args[0].trim().toLowerCase();
            if (comando.equals("hipodromo")) {
                MotorDelJuegoHipodromo carrera = new MotorDelJuegoHipodromo();
                carrera.holaHipodromo();
            } else if (comando.equals("anagramas")) {
                Anagramas anagrama = new Anagramas();
                anagrama.holaAnagramas();
            } else if (comando.equals("battleship")) {
                Battleship battle = new Battleship();
                battle.holaBattleship();
            } else {
                System.out.println("Error: Comando no reconocido.");
            }
        } else {
            return;
        }
    }
    
    /**
     * 
     */
    private void selecciónDeJuegos(){
        System.out.println("Ingrese el juego que desea jugar:");
        System.out.println("1. Carrera de caballos en el hipódromo.");
        System.out.println("2. Anagramas.");
        System.out.println("3. Battleship.");
        opciónJuego = scanner.nextInt();
        switch(opciónJuego){
            case 1: 
                MotorDelJuegoHipodromo motorh = new MotorDelJuegoHipodromo();
                motorh.holaHipodromo();
                break;
            case 2: 
                
                break;
            case 3: 
                
                break;
            default: 
                System.out.println("Opción no válida");
                selecciónDeJuegos();
                break;
        }
    
    }
}
