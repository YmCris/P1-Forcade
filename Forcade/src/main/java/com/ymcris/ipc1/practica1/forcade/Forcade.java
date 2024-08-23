package com.ymcris.ipc1.practica1.forcade;

import com.ymcris.ipc1.practica1.anagramas.Anagramas;
import com.ymcris.ipc1.practica1.battleship.Battleship;
import com.ymcris.ipc1.practica1.carrera.Hipodromo;
import com.ymcris.ipc1.practica1.reportes.Reportes;
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

    Scanner scanner = new Scanner(System.in);
    int opciónJuego;
    boolean parametroIntroducido= false;
    
    /**
     * Método principal encargado de iniciar el programa.
     *
     * @param args - Argumentos de la línea de comandos utilizados para iniciar
     * directamente un juego específico basado en el parámetro ingresado.
     */
    public static void main(String[] args) {
        Forcade inicio = new Forcade();
        inicio.inicio();
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
            if(comando.equals("hola")){
                System.out.println("HOlA MUNDO");
            } else if (comando.equals("hipodromo")) {
                Hipodromo hipodromo = new Hipodromo();
                hipodromo.holaHipodromo();
                parametroIntroducido = true;
            } else if (comando.equals("anagramas")) {
                Anagramas anagrama = new Anagramas();
                anagrama.holaAnagramas();
                parametroIntroducido = true;
            } else if (comando.equals("battleship")) {
                Battleship battle = new Battleship();
                battle.holaBattleship();
                parametroIntroducido = true;
            } else {
                System.out.println("Error: Comando no reconocido.");
                parametroIntroducido = false;
            }
        } else {
            System.out.println("\n".repeat(100));
            Interfaz interfaz = new Interfaz();
            interfaz.mostrarMenuPrincipal();
            opciónJuego = scanner.nextInt();
            switch(opciónJuego){
                case 1: 
                    ComoJugar jugar = new ComoJugar();
                    jugar.ayuda();
                    break;
                case 2: 
                    Hipodromo hipodromo = new Hipodromo();
                    hipodromo.holaHipodromo();
                    break;
                case 3: 
                    Anagramas anagrama = new Anagramas();
                    anagrama.holaAnagramas();
                    break;
                case 4: 
                    Battleship battleship = new Battleship();
                    battleship.holaBattleship();
                    break;
                case 5: 
                    Reportes reportes = new Reportes();
                    reportes.holaReportes();
                    break;
                case 6: 
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Opción no válida");
                    return;
            }return;
        }
    }
    
    /**
     * 
     */
    private void selecciónDeJuegos(){
        if (parametroIntroducido=false) {
            System.out.println("\n".repeat(100));
            System.out.println("Ingrese el juego que desea jugar:");
            System.out.println("1. Carrera de caballos en el hipódromo.");
            System.out.println("2. Anagramas.");
            System.out.println("3. Battleship.");
            opciónJuego = scanner.nextInt();
            switch(opciónJuego){
                case 1: 
                    Hipodromo hipodromo = new Hipodromo();
                    hipodromo.holaHipodromo();
                    break;
                case 2: 
                    Anagramas anagrama = new Anagramas();
                    anagrama.holaAnagramas();
                    break;
                case 3: 
                    Battleship battle = new Battleship();
                    battle.holaBattleship();
                    break;
                default: 
                    System.out.println("Opción no válida");
                    return;
            }return;
        }
    }
    
    private void inicio(){
        System.out.println("\n".repeat(100));
        System.out.println(""+
"            _____    ___    ____     ____      _      ____    _____ \n" +
"           |  ___|  / _ \\  |  _ \\   / ___|    / \\    |  _ \\  | ____|\n" +
"           | |_    | | | | | |_) | | |       / _ \\   | | | | |  _|  \n" +
"           |  _|   | |_| | |  _ <  | |___   / ___ \\  | |_| | | |___ \n" +
"           |_|      \\___/  |_| \\_\\  \\____| /_/   \\_\\ |____/  |_____|");
        System.out.println("\n".repeat(5));
        System.out.println("Presione enter para continuar");
        Scanner scanner = new Scanner(System.in);
        String hola = scanner.nextLine();
    }
    
}
