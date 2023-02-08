package daw.programacion;

import java.util.Scanner;
import static daw.programacion.Mensajes.*;

public class Menu {
    public static void main(String[] args) {
        Galeria galeria = new Galeria();

        Obra[] exposicion = Galeria.cargarObras();
        Obra[] placeHolder = galeria.elegirOpcion(exposicion);

        while (galeria.isActivo()) {
            exposicion = placeHolder;
            System.out.println(ESPACIO);
            System.out.println(INTRO);
            scannerString();
            placeHolder = galeria.elegirOpcion(exposicion);
            
        }
    }

    public void enseñarMenu() {

        for (int i = 0; i < SELECCION_MENU.length; i++) {
            System.out.println(SELECCION_MENU[i] + ESPACIO + OPCIONES[i]);
        }
        System.out.println(ESCOGER);
    }

    public void menuModificarObra() {

        for (int i = 0; i < SELECCION.length; i++) {
            System.out.println(SELECCION[i] + ESPACIO + ATRIBUTOS[i]);
        }
    }

    public static String scannerString() {
        Scanner scString = new Scanner(System.in);
        return scString.nextLine();
    }

    public static int scannerInt() {
        Scanner scString = new Scanner(System.in);
        return scString.nextInt();
    }

    public static double scannerDouble() {
        Scanner scString = new Scanner(System.in);
        return scString.nextDouble();
    }
}
