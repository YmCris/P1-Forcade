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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNúmeroDeCaballos() {
        return númeroDeCaballos;
    }

    public void setNúmeroDeCaballos(int númeroDeCaballos) {
        this.númeroDeCaballos = númeroDeCaballos;
    }    
}
