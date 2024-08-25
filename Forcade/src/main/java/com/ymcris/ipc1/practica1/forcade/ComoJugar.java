package com.ymcris.ipc1.practica1.forcade;

import java.util.Scanner;

/**
 *
 * @author YmCris
 */
public class ComoJugar {

    Scanner scanner = new Scanner(System.in);
    Forcade forcade = new Forcade();
    int regresar;

    /**
     * Método usado para mostrar las diferentes opciones de ayuda al usuario.
     */
    public void ayuda() {
        System.out.println("Bienvenido a la ayuda de forcade, aquí podrás obtener información de como se juegan los videojuegos.");
        System.out.println("Recomendamos ampliamente leer el manual de usuario donde se detallan a profundidad cada juego.");
        System.out.println("Selecciona el juego que desees saber como se juega:");
        System.out.println("1. Carrera de Caballos en el Hipodromo.");
        System.out.println("2. Anagramas.");
        System.out.println("3. Battleship.");
        System.out.println("4. Regresar al menú.");
        int opciónJuego = scanner.nextInt();
        switch (opciónJuego) {
            case 1:
                comoJugarCaballos();
                break;
            case 2:
                comoJugarAnagramas();
                break;
            case 3:
                comoJugarBattleship();
                break;
            case 4:
                System.out.println("\n".repeat(60));
                forcade.menuPrincipal();
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }
    }

    /**
     * Método usado para mostrar como jugar el juego de carrera de caballos en
     * el hipodromo.
     */
    public void comoJugarCaballos() {
        System.out.println("\n".repeat(60));
        System.out.println("Carrera de Caballos en el Hipódromo es un juego de estrategia y de ¿suerte?" + "\n" + "Un excelente juego donde el azar y la estrategia se juntan para dar una emocionante carrera de caballos. ");
        System.out.println("");
        System.out.println("Inicio:");
        System.out.println("Al momento de iniciar el juego, este pedirá el nombre del jugador" + "\n" + "Los caballos contra los que se deseen competir y el número de dados que habrá por partida" + "\n" + "Si no se selecciona ninguno (es decir que luego de 5 segundos , se tomará por defecto 5 caballos y 2 dados)");
        System.out.println("");
        System.out.println("Estrategias:");
        System.out.println("Las estrategias permiten obtener ventaja sobre los contrincantes o no avanzar nada y que los caballos contrincantes superen" + "\n" + "¿Qué decidirás?, ¿cuál será la mejor opción? Usa tu habilidad y tu suerte para descubrirlo!");
        System.out.println("");
        System.out.println("Juego:");
        System.out.println("en cada bloque de ceros, muestra la pista de un caballo, el caballo “1” es al cual controla, los demás caballos se mueven aleatoriamente en su pista.\n"
                + "El juego continúa en base a las estrategias, el primer caballo en llegar a los 200 ganará la carrera.");

        forcade.menuPrincipal();
    }

    /**
     * Método usado para mostrar como jugar el juego de anagramas.
     */
    public void comoJugarAnagramas() {

        forcade.menuPrincipal();
    }

    /**
     * Método usado para mostrar como se jugaría el juego de battleship.
     */
    public void comoJugarBattleship() {
        System.out.println(":c");
        forcade.menuPrincipal();
    }
}
