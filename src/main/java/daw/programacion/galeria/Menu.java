package daw.programacion.galeria;

import static daw.programacion.galeria.Mensajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import daw.programacion.obras.Obra;

public class Menu {
    public static void main(String[] args) {
        Galeria galeria = new Galeria();

        Obra[] exposicion = Obra.cargarObras();
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

    public static void menuModificarObra() {

        for (int i = 0; i < SELECCION.length; i++) {
            System.out.println(SELECCION[i] + ESPACIO + ATRIBUTOS[i]);
        }
    }

    public static Obra[] cambiarActividad(int num, Obra[] todo) throws IllegalArgumentException {
        try {
            Obra.checkInputs(num);
            if (num == 1) {
                Obra.visualizarObras(todo);
            } else if (num == 2) {
                Obra[] placeHolder = Obra.darDeAltaUnaObra(todo);
                return placeHolder;
            } else if (num == 3) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                Obra.findId(idSeleccion, todo);
                System.out.println(SELECCIONAR_MOD);
                menuModificarObra();
                int valor = scannerInt();
                System.out.println(SELECCION_VALOR);
                String cambio = scannerString();
                .modificarObra(idSeleccion, todo, valor);
            } else if (num == 4) {
                System.out.println(SELECCIONAR_ID);
                .visualizarDatosObra(Menu.scannerInt(), todo);
            } else if (num == 5) {
                System.out.println(SELECCIONAR_ID);
                .obtenerPrecio(Menu.scannerInt(), todo);
            } else if (num == 6) {
                System.out.println(SELECCIONAR_ID);
                .imprimirEtiqueta(Menu.scannerInt(), todo);
            } else if (num == 0) {
                .setActivo(false);
            }
            return todo;
        } catch (IllegalArgumentException wrongNum) {
            System.out.println(ESPACIO);
            System.out.println(ERROR_NUM_MAL);
            return todo;
        }
    }

    public static Obra[] elegirOpcion(Obra[] todo) {
        Obra[] placeHolder = todo;
        try {
            Menu menuOpcion = new Menu();
            menuOpcion.enseñarMenu();
            placeHolder = cambiarActividad(Menu.scannerInt(), todo);
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
