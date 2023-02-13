package daw.programacion.galeria;

import static daw.programacion.galeria.Mensajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import daw.programacion.obras.Obra;

public class Menu {

    public static void main(String[] args) {
        Obra[] exposicion = Obra.cargarObras();
        Obra[] placeHolder = elegirOpcion(exposicion);

        while (placeHolder.length > 0) {
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
                Obra obraNueva = new Obra();
                System.out.println(TIPO);
                String tipo = Menu.scannerString().toLowerCase();
                obraNueva = preguntarObra();
                Obra[] placeHolder = obraNueva.darDeAltaUnaObra(todo, tipo);
                return placeHolder;
            } else if (num == 3) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                System.out.println(SELECCIONAR_MOD);
                menuModificarObra();
                int modificacion = scannerInt();
                System.out.println(SELECCION_VALOR);
                todo[Obra.findId(idSeleccion, todo)].modificarObra(todo, modificacion);
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
                Obra[] end = new Obra[0];
                return end;
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

    public static Obra preguntarObra(){
        System.out.println(ID);
        int id = scannerInt();
        System.out.println(NOMBRE);
        String nombre = scannerString();
        System.out.println(AUTOR);
        String autor = scannerString();
        System.out.println(PESO);
        double peso = scannerDouble();
        System.out.println(ALTURA);
        double altura = scannerDouble();
        System.out.println(PRECIO);
        double precio = scannerDouble();
        System.out.println(PIEZAS);
        int piezas = scannerInt();
        System.out.println(DESC);
        String desc = scannerString();
        Obra obraNueva = new Obra(id, nombre, autor, precio, altura, peso, piezas, desc);
        return obraNueva;
    }
}
