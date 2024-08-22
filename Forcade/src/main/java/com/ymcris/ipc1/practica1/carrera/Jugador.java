package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Jugador {

    Scanner scanner = new Scanner(System.in);
    Caballos caballo = new Caballos();
    String nombre;
    int númeroDeCaballos;
    int númeroDeDados;
    int estrategia;
    boolean avanceNormal = true;

    /**
     *
     * @param caballo
     * @return
     */
    protected Caballos seleccionarCaballo(Caballos caballo) {

        return caballo;
    }

    /**
     *
     * @return
     */
    protected void decidirEstrategia() {
        Dados dado = new Dados();
        dado.definirDado();
        System.out.println("\n".repeat(100));
        System.out.println("Seleccione su estrategia:");
        System.out.println("1. Avanzar normal.");
        System.out.println("2. Avanzar con riesgo.");
        estrategia = scanner.nextInt();
        switch (estrategia) {
            case 1:
                System.out.println("\n".repeat(100));
                dado.lanzarDados();
                dado.verificarPrimo(númeroDeDados);
                avanceNormal = true;
                System.out.println("El jugador avanza normal " + dado.getResultado() + " casillas");
                break;
            case 2:
                dado.lanzarDados();
                dado.verificarPrimo(númeroDeDados);
                avanceNormal = true;
                System.out.println("El jugador avanza con riesgo " + dado.getResultado() + " casillas");
                avanceNormal = false;
                break;
            default:
                System.out.println("Entrada no válida >:(");
                break;
        }
    }

    /**
     *
     */
    protected void definirNombreyCaballos() {
        System.out.println("Ingrese el nombre del jugador:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el número de caballos con los que desea competir:");
        númeroDeCaballos = scanner.nextInt();
    }

    protected void definirDados() {
        System.out.println("Ingrese el número de dados con los que desea jugar:");
        númeroDeDados = scanner.nextInt();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNúmeroDeCaballos() {
        return númeroDeCaballos;
    }

    public int getNúmeroDeDados() {
        return númeroDeDados;
    }

    public boolean isAvanceNormal() {
        return avanceNormal;
    }

    //--------------------------------------------------------------------------   
    protected int filas;
    protected int COLUMNAS = 200;
    protected int posicionJugador;
    private String VERDE = "\033[0;32m";
    private String RESET = "\033[0m";
    protected int[][] pista;

    public Jugador(int númeroDeCaballos) {
        this.númeroDeCaballos = númeroDeCaballos;
        this.filas = númeroDeCaballos + 1;
        this.pista = new int[filas][COLUMNAS];
    }

    public Jugador() {
    }

    /**
     * Crear la pista inicializando todos los valores a 0
     */
    protected void crearPista() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                pista[i][j] = 0;
            }
        }
    }

    /**
     * Muestra la pisata en consola.
     */
    protected void mostrarPista() {
        if (pista.length == 0 || pista[0].length == 0) {
            System.out.println("La pista no tiene dimensiones válidas.");
            return;
        }
        System.out.println("Pista:");
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j] + VERDE + "\t");
            }
            System.out.println();
            System.out.println(RESET);
        }
    }

    /**
     * Coloca los caballos en la primera columna de la pista ([0][0])
     */
    public void colocarCaballos() {
        for (int i = 0; i < númeroDeCaballos; i++) {
            pista[0][0]=1;
            pista[i+1][0]=1;
        }
    }

}
