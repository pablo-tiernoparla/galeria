package daw.programacion.galeria;

import static daw.programacion.galeria.Mensajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import daw.programacion.obras.Escultura;
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
            checkInputs(num);
            if (num == 1) {
                Obra.visualizarObras(todo);
            } else if (num == 2) {
                Escultura obraNueva = new Escultura();
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
                todo[findId(idSeleccion, todo)].modificarObra(todo, modificacion);
            } else if (num == 4) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[findId(idSeleccion, todo)].visualizarDatosObra(todo);
            } else if (num == 5) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[findId(idSeleccion, todo)].obtenerPrecio(todo);
            } else if (num == 6) {
                System.out.println(SELECCIONAR_ID);
                int idSeleccion = scannerInt();
                todo[findId(idSeleccion, todo)].imprimirEtiqueta(todo);
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

    public static Escultura preguntarObra(){
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
        Escultura obraNueva = new Escultura(id, nombre, autor, precio, altura, peso, piezas, desc, null);
        return obraNueva;
    }

    //escepciones
    public static void positiveNum(double num) throws IllegalArgumentException{
        if(!(num > 0)){
            throw new IllegalArgumentException();
        }
    }

    public static void idYaExiste(int num, Obra[] todo) throws IllegalArgumentException {
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                continue;
            } else if (num == todo[i].getId()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkInputs(int num) throws IllegalArgumentException {
        if (!(num >= 0 && num < 7)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void checkTipo(String tipo) throws IllegalArgumentException {
        if (!(tipo.equals(PICTORICA) && tipo.equals(ESCULTURA))) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkString(String checked) throws IllegalArgumentException{
        if (checked.equals("")){
            throw new IllegalArgumentException();
        }
    }

    public static int findId(int num, Obra[] todo) throws IllegalArgumentException {
        int index;
        for (index = 0; index < todo.length; index++) {
            if (num == todo[index].getId()) {
                break;
            } else if (index == todo.length - 1 && todo[todo.length - 1].getId() != index) {
                throw new IllegalArgumentException();
            }
        }
        return index;
    }
}
