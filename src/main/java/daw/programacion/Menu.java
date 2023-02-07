package daw.programacion;

public class Menu {
    public static void main(String[] args) {
        

    }

    public void enseñarMenu() {
        final int[] SELECCION_MENU = {0,1,2,3,4,5,6};
        final String[] OPCIONES = {"Salir", "Visualizar obras", "Dar de alta una obra", "Modificar una obra", "Visualizar una obra", "Obtener el precio de una obra", "Imprimir etiqueta"};

        for (int i = 0; i < SELECCION_MENU.length; i++) {
            System.out.println(SELECCION_MENU[i] + "" + OPCIONES[i]);
        }
        System.out.println("Escoge una opcion");
    }
}
