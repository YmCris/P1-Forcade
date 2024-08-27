package com.ymcris.ipc1.practica1.carrera;

import com.ymcris.ipc1.practica1.forcade.Forcade;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author YmCris
 */
public class Jugador {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public static int[] vecesGanadas = new int[1];
    public static int[] vecesPerdidas = new int[1];
    private final int CABALLOS_POR_DEFECTO = 5;
    private final int DADOS_POR_DEFECTO = 2;

    protected String nombre;
    protected int númeroDeCaballos;
    protected int númeroDeDados;
    protected int estrategia;
    protected boolean avanceNormal;

    /**
     * Método encargado de preguntarle al usuario que estrategia va a usar o si
     * desea retirarse de la partida al inicio del juego.
     */
    protected void decidirEstrategia() {
        System.out.println("\n".repeat(100));
        System.out.println(AZUL + "Seleccione su estrategia:" + RESET);
        System.out.println("1. Avanzar normal.");
        System.out.println("2. Avanzar con riesgo.");
        System.out.println("3. Regresar al menú.");
        estrategia = scanner.nextInt();
        switch (estrategia) {
            case 1:
                avanceNormal = true;
                break;
            case 2:
                avanceNormal = false;
                break;
            case 3:
                System.out.println("Has perdido la partida.");
                Forcade forcade = new Forcade();
                forcade.menuPrincipal();
                break;
            default:
                System.out.println("Entrada no válida >:(");
                break;
        }
    }

    /**
     * Método usado para mostrar información al jugador durante toda la partida.
     */
    protected void informacionJuego() {
        System.out.println(AZUL + "Turnos / Posiciones:" + RESET);
        System.out.println("Caballo 1 es el caballo de: " + nombre);
        for (int i = 0; i <= númeroDeCaballos; i++) {
            System.out.println("La posición del caballo " + (i + 1) + " es: " + getPosicionCaballo(i));
        }
    }

    /**
     * Método encargado de pedir y guardar el nombre del jugador.
     */
    protected void definirNombre() {
        System.out.println("\n".repeat(100));
        System.out.println("Ingrese el nombre del jugador:");
        nombre = scanner.nextLine();
    }

    /**
     * Método encargado de definir los caballos contrincantes predeterminados.
     */
    protected void definirCaballosPredeterminados() {
        System.out.println("\n".repeat(100));
        System.out.println("· Presione una tecla para definir los caballos con los que desea competir.");
        System.out.println("· Presione enter para la opción predeterminada.");
        String caballosPredeterminados = scanner.nextLine();
        if (caballosPredeterminados.isEmpty()) {
            númeroDeCaballos = CABALLOS_POR_DEFECTO;
            definirDadosPredeterminados();
        } else {
            definirCaballos();
        }
    }

    /**
     * Método encargado de definir los caballos contrincantes y verificar que la
     * entrada sea válida, tambien coloca la cantidad predeterminada de caballos
     * (5).
     */
    protected void definirCaballos() {
        System.out.println("Ingrese el número de caballos con los que desea competir: ");
        númeroDeCaballos = scanner.nextInt();
        scanner.nextLine();
        if (númeroDeCaballos < 3 || númeroDeCaballos > 7) {
            System.out.println("\n".repeat(3));
            System.out.println("El número de caballos debe ser entre 3 y 7");
            definirCaballos();
        } else {
            definirDadosPredeterminados();
        }
    }

    /**
     * Método encargado de asignar los dados predeterminados en dado caso el
     * usuario no los introduzca.
     */
    protected void definirDadosPredeterminados() {
        System.out.println("\n".repeat(100));
        System.out.println("· Presione una tecla para definir los dados con los que desea competir.");
        System.out.println("· Presione enter para la opción predeterminada.");
        String dadosPredeterminados = scanner.nextLine();
        if (dadosPredeterminados.isEmpty()) {
            númeroDeDados = DADOS_POR_DEFECTO;
        } else {
            definirDados();
        }
    }

    /**
     * Método encargado de pedir y guardar el número de dados al usuario,
     * también límita los dados en un rango de [1,4].
     */
    protected void definirDados() {
        System.out.println("Ingrese el número de dados con los que desea jugar:");
        númeroDeDados = scanner.nextInt();
        scanner.nextLine();
        if (númeroDeDados < 1 || númeroDeDados > 4) {
            System.out.println("\n".repeat(3));
            System.out.println("El número de dados debe ser entre 1 y 4");
            definirDados();
        }
    }

    //GETTERS & SETTERS DE LA CLASE JUGADOR
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

    public void setPartidasGanadas(int partidaGanada) {
        vecesGanadas[0] += partidaGanada;
    }

    public int getPartidasGanadas() {
        return vecesGanadas[0];
    }

    public int getPartidasPerdidas() {
        return vecesPerdidas[0];
    }

    public void setPartidasPerdidas(int partidaPerdida) {
        vecesPerdidas[0] += partidaPerdida;
    }

    // "CLASE PISTA" Se mezcla porque al momento de querer usar el número de caballos nomas daba 0
    //--------------------------------------------------------------------------   
    private final String VERDE = "\033[0;32m";
    private final String RESET = "\033[0m";
    private final String AZUL = "\033[34m";
    protected final int COLUMNAS = 200;

    protected int filas;
    protected int posicionJugador;
    private int[] posicionesCaballos;
    protected int[][] pista;

    /**
     * Constructor de la que debería ser la clase pista.
     *
     * @param númeroDeCaballos - Parámetro usado para definir los números de
     * caballos que seleccionó el usuario.
     */
    public Jugador(int númeroDeCaballos) {
        this.númeroDeCaballos = númeroDeCaballos;
        this.filas = númeroDeCaballos + 1;
        this.pista = new int[filas][COLUMNAS];
        this.posicionesCaballos = new int[filas];
    }

    /**
     * Constructor vacio porque ciertos métodos lo requieren.
     */
    public Jugador() {

    }

    /**
     * Método encargado de crear la pista con puro cero
     */
    protected void crearPista() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                pista[i][j] = 0;
            }
        }
    }

    /**
     * Método encargado de mostrar la pisata en consola.
     */
    protected void mostrarPista() {
        informacionJuego();
        System.out.println(AZUL + "Pista:" + RESET);
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j] + VERDE);
            }
            System.out.println(RESET);
        }
    }

    /**
     * Método encargado de colocar los caballos en la primera columna de la
     * pista ([0][0])
     */
    public void colocarCaballos() {
        for (int i = 0; i < númeroDeCaballos; i++) {
            pista[i][0] = i + 1;
            posicionesCaballos[i] = 0;
        }
        pista[0][0] = 1;
        posicionJugador = 0;
    }

    /**
     * Método encargado de mover el caballo del usuario en la pista.
     *
     * @param resultadoDados - Es el resultado que se obtiene luego de que el
     * usuario elija que estrategia usará.
     */
    public void moverCaballoJugador(int resultadoDados) {
        pista[0][posicionJugador] = 0;
        posicionJugador += resultadoDados;
        if (posicionJugador >= COLUMNAS) {
            posicionJugador = COLUMNAS - 1;
            System.out.println("EL jugador " + nombre + " es el ganador.");
        }
        pista[0][posicionJugador] = 1;
    }

    /**
     * Método encargado de mover los caballos contrincantes de forma aleatoria
     * siempre en su misma fila, así como definir que pasa cuando llegan al
     * final.
     *
     * @param resultadoDados - Es el resultado que se obtiene de los dados que
     * haya seleccionado el usuario.
     */
    protected void moverCaballosAleatorios(int resultadoDados) {
        for (int i = 1; i <= númeroDeCaballos; i++) {
            pista[i][posicionesCaballos[i]] = 0;
            int movimientoAleatorio = random.nextInt(resultadoDados) * 2;
            posicionesCaballos[i] += movimientoAleatorio;
            if (posicionesCaballos[i] >= COLUMNAS) {
                posicionesCaballos[i] = COLUMNAS - 1;
                System.out.println("El caballo " + (i + 1) + " llegó a la meta " + getNombre() + " perdió");
            }
            pista[i][posicionesCaballos[i]] = i + 1;
        }
    }

    /**
     * Método encargado de obtener la posición de un caballo específico en la
     * pista.
     *
     * @param indiceCaballo Selecciona el caballo que se quiera elegir.
     * @return La posición del caballo en la pista.
     */
    public int getPosicionCaballo(int indiceCaballo) {
        if (indiceCaballo == 0) {
            return posicionJugador;
        } else {
            return posicionesCaballos[indiceCaballo];
        }
    }

    public int getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(int posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public int[] getPosicionesCaballos() {
        return posicionesCaballos;
    }

    public void setPosicionesCaballos(int[] posicionesCaballos) {
        this.posicionesCaballos = posicionesCaballos;
    }

}
