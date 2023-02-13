package daw.programacion.galeria;

import static daw.programacion.galeria.Mensajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import daw.programacion.obras.Obra;

public class Menu {

    private static boolean activo = true;

    public static boolean isActivo() {
        return activo;
    }

    public static void setActivo(boolean activo) {
        activo = activo;
    }

    public static void main(String[] args) {
        Obra[] exposicion = Obra.cargarObras();
        Obra[] placeHolder = elegirOpcion(exposicion);

        while (isActivo()) {
            exposicion = placeHolder;
            System.out.println(ESPACIO);
            System.out.println(INTRO);
            scannerString();
            placeHolder = elegirOpcion(exposicion);
            
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
                System.out.println(TIPO);
                String tipo = Menu.scannerString().toLowerCase();
                Obra[] placeHolder = Obra.darDeAltaUnaObra(todo, tipo);
                return placeHolder;
            } else if (num == 3) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                Obra.findId(idSeleccion, todo);
                System.out.println(SELECCIONAR_MOD);
                menuModificarObra();
                int valor = scannerInt();
                System.out.println(SELECCION_VALOR);
                todo[Obra.findId(idSeleccion, todo)].modificarObra(todo, valor);
            } else if (num == 4) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[Obra.findId(idSeleccion, todo)].visualizarDatosObra(todo);
            } else if (num == 5) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[Obra.findId(idSeleccion, todo)].obtenerPrecio(todo);
            } else if (num == 6) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[Obra.findId(idSeleccion, todo)].imprimirEtiqueta(todo);
            } else if (num == 0) {
                setActivo(false);
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
