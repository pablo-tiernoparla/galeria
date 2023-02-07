package daw.programacion;

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
            Galeria.scannerString();
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
}
