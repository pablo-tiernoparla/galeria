package daw.programacion;

import static daw.programacion.Mensajes.*;

public class Menu {
    public static void main(String[] args) {
        

    }

    public void enseñarMenu() {

        for (int i = 0; i < SELECCION_MENU.length; i++) {
            System.out.println(SELECCION_MENU[i] + ESPACIO + OPCIONES[i]);
        }
        System.out.println(ESCOGER);
    }
}
