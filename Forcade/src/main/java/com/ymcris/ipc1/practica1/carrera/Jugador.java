package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Jugador {

    Scanner scanner = new Scanner(System.in);
    Caballos caballoSeleccionado= new Caballos();
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
        switch(estrategia){
            case 1:
                System.out.println("\n".repeat(100));
                dado.lanzarDados();
                dado.verificarPrimo(númeroDeDados);
                avanceNormal = true;
                System.out.println("El jugador avanza normal "+dado.getResultado()+" casillas");
                break;
            case 2:
                dado.lanzarDados();
                dado.verificarPrimo(númeroDeDados);
                avanceNormal = true;
                System.out.println("El jugador avanza con riesgo "+dado.getResultado()+" casillas");
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
    protected void definirNombreyCaballos(){
        System.out.println("Ingrese el nombre del jugador:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el número de caballos con los que desea competir:");
        númeroDeCaballos = scanner.nextInt();
    }
    
    protected void definirDados(){
        System.out.println("Ingrese el número de dados con los que desea jugar:");
        númeroDeDados = scanner.nextInt();
    }

    public Caballos getCaballoSeleccionado() {
        return caballoSeleccionado;
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
    
    

}
