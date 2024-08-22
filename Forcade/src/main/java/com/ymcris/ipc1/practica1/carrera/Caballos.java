package com.ymcris.ipc1.practica1.carrera;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Caballos {

    Scanner scanner = new Scanner(System.in);
    private String nombre;
    //Negro    //Blanco    //Verde    //Azul    //Magenta
    private String[] colores = {"\033[37m", "\033[30m", "\033[32m", "\033[34m", "\033[35m"};
    protected int lugar;
    protected int posiciónActual;
    protected int númeroCaballo;
    protected int estrategia = scanner.nextInt();
    protected boolean ganador;
    private boolean esJugador;

    public String getNombre() {
        return nombre;
    }

    public String[] getColores() {
        return colores;
    }

    public int getLugar() {
        return lugar;
    }

    public int getPosiciónActual() {
        return posiciónActual;
    }

    public int getNúmeroCaballo() {
        return númeroCaballo;
    }

    public int getEstrategia() {
        return estrategia;
    }

    public boolean isGanador() {
        return ganador;
    }

    public boolean isEsJugador() {
        return esJugador;
    }
    
    public void avanzar(){
    
    }
    
    public void seleccionarEstrategia() {
    
    }
}
