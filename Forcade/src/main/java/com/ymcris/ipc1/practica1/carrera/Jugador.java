package com.ymcris.ipc1.practica1.carrera;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Jugador {

    Scanner scanner = new Scanner(System.in);
    Dados dado = new Dados();
    String nombre;
    int númeroDeCaballos;
    int númeroDeDados;
    int estrategia;
    boolean avanceNormal;

    /**
     *
     * @return
     */
    protected void decidirEstrategia() {
        System.out.println("\n".repeat(100));
        System.out.println("Seleccione su estrategia:");
        System.out.println("1. Avanzar normal.");
        System.out.println("2. Avanzar con riesgo.");
        estrategia = scanner.nextInt();
        switch (estrategia) {
            case 1:
                avanceNormal = true;
                break;
            case 2:
                avanceNormal = false;
                break;
            default:
                System.out.println("Entrada no válida >:(");
                break;
        }
    }

    protected void avanceNormal() {
        dado.lanzarDados(númeroDeDados);
        dado.verificarPrimo();
        System.out.println("\n".repeat(100));
        System.out.println("El jugador avanza normal " + dado.getResultado() + " casillas");
        avanceNormal = true;
    }

    protected void avenceConRiesgo() {
        dado.lanzarDados(númeroDeDados);
        dado.verificarPrimo();
        System.out.println("\n".repeat(100));
        System.out.println("El jugador avanza con riesgo " + dado.getResultado() + " casillas");
        avanceNormal = false;
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

    public boolean getAvanceNormal() {
        return avanceNormal;
    }

    //--------------------------------------------------------------------------   
    protected int filas;
    protected int COLUMNAS = 200;
    protected int posicionJugador;
    private String VERDE = "\033[0;32m";
    private String RESET = "\033[0m";
    protected int[][] pista;
    private int [] posicionesCaballos;

    public Jugador(int númeroDeCaballos) {
        this.númeroDeCaballos = númeroDeCaballos;
        this.filas = númeroDeCaballos + 1;
        this.pista = new int[filas][COLUMNAS];
        this.posicionesCaballos = new int[filas];
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
        System.out.println("Pista:");
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j] + VERDE + "\t");
            }
            System.out.println(RESET);
        }
    }

    /**
     * Coloca los caballos en la primera columna de la pista ([0][0])
     */
    public void colocarCaballos() {
        for (int i = 0; i < númeroDeCaballos; i++) {
            pista[i][0] = i + 1;  // Cada caballo tiene un número distinto
            posicionesCaballos[i] = 0;  // Posición inicial de cada caballo
        }
        pista[0][0] = 1;  // El caballo del jugador siempre está en la primera fila
        posicionJugador = 0;
    }

    public void moverCaballoJugador(int resultadoDados) {
        pista[0][posicionJugador] = 0; //limpia la posición actual del jugador
        posicionJugador += resultadoDados; // actualiza la posición del jugador
        if (posicionJugador >= COLUMNAS) {
            posicionJugador = COLUMNAS - 1;
        }

        pista[0][posicionJugador] = 1;//coloca el caballo del jugador en su nueva posición
        moverCaballosAleatorios();
    }

    private void moverCaballosAleatorios() {
        for (int i = 1; i < númeroDeCaballos; i++) {  // Empieza desde 1 porque el índice 0 es del jugador
            pista[i][posicionesCaballos[i]] = 0;  // Limpiar posición actual
            int movimientoAleatorio = (int) (Math.random() * 3);  // Movimiento entre 0 y 2 casillas
            posicionesCaballos[i] += movimientoAleatorio;

            if (posicionesCaballos[i] >= COLUMNAS) {
                posicionesCaballos[i] = COLUMNAS - 1;
            }

            pista[i][posicionesCaballos[i]] = i + 1;  // Actualizar nueva posición
        }
    }

    /**
     * Obtiene la posición de un caballo específico en la pista.
     *
     * @param index El índice del caballo.
     * @return La posición del caballo en la pista.
     */
    public int getPosicionCaballo(int indiceCaballo) {
        return posicionesCaballos[indiceCaballo];
    }
}
