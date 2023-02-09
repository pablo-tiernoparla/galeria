package daw.programacion;

import java.util.InputMismatchException;
import java.util.Scanner;
import static daw.programacion.Mensajes.*;

public class Menu {
    public static void main(String[] args) {
        Galeria galeria = new Galeria();

        Obra[] exposicion = Galeria.cargarObras();
        Obra[] placeHolder = elegirOpcion(exposicion, galeria);

        while (galeria.isActivo()) {
            exposicion = placeHolder;
            System.out.println(ESPACIO);
            System.out.println(INTRO);
            scannerString();
            placeHolder = elegirOpcion(exposicion, galeria);
            
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

    public static Obra[] cambiarActividad(int num, Obra[] todo, Galeria gal) throws IllegalArgumentException {
        try {
            gal.checkInputs(num);
            if (num == 1) {
                gal.visualizarObras(todo);
            } else if (num == 2) {
                Obra[] placeHolder = gal.darDeAltaUnaObra(todo);
                return placeHolder;
            } else if (num == 3) {
                System.out.println(SELECCIONAR_ID);
                gal.modificarObra(Menu.scannerInt(), todo);
            } else if (num == 4) {
                System.out.println(SELECCIONAR_ID);
                gal.visualizarDatosObra(Menu.scannerInt(), todo);
            } else if (num == 5) {
                System.out.println(SELECCIONAR_ID);
                gal.obtenerPrecio(Menu.scannerInt(), todo);
            } else if (num == 6) {
                System.out.println(SELECCIONAR_ID);
                gal.imprimirEtiqueta(Menu.scannerInt(), todo);
            } else if (num == 0) {
                gal.setActivo(false);
            }
            return todo;
        } catch (IllegalArgumentException wrongNum) {
            System.out.println(ESPACIO);
            System.out.println(ERROR_NUM_MAL);
            return todo;
        }
    }

    public static Obra[] elegirOpcion(Obra[] todo, Galeria gal) {
        Obra[] placeHolder = todo;
        try {
            Menu menuOpcion = new Menu();
            menuOpcion.enseñarMenu();
            placeHolder = cambiarActividad(Menu.scannerInt(), todo, gal);
            return placeHolder;
        } catch (InputMismatchException wasString) {
            System.out.println(ERROR_LETRA);
            return placeHolder;
        }
    }

    //cerrar el scanner hace que funcione mal
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
