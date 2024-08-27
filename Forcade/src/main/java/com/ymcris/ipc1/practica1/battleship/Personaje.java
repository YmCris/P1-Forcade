package com.ymcris.ipc1.practica1.battleship;

import java.util.Scanner;

/**
 *
 * @author YmCris
 */
public class Personaje {

    Scanner scanner = new Scanner(System.in);

    protected String nombre;
    protected boolean turno1;
    protected boolean turno2;

    public Personaje(String nombre, boolean turno1, boolean turno2) {
        this.nombre = nombre;
        this.turno1 = turno1;
        this.turno2 = turno2;
    }

    protected void definirElementos() {
        System.out.println("Ingrese el nombre del primer jugador");
        nombre = scanner.nextLine();
    }
    
    
}
