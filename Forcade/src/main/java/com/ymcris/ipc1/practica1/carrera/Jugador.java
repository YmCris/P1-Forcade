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
    protected int decidirEstrategia() {
        System.out.println("Estrategia:"+"\n");
        System.out.println("1. Avanzar con precaución.");
        System.out.println("2. Avanzar normal.");
        return caballoSeleccionado.getEstrategia();
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

}
