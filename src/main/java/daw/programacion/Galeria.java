package daw.programacion;

import java.util.Scanner;

public class Galeria {

    private boolean activo = true;

    public Galeria() {
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String scannerString() {
        Scanner scString = new Scanner(System.in);
        return scString.nextLine();
    }

    public int scannerInt() {
        Scanner scString = new Scanner(System.in);
        return scString.nextInt();
    }

    public double scannerDouble() {
        Scanner scString = new Scanner(System.in);
        return scString.nextDouble();
    }

    public void visualizarObras(Obra[] todo) {
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                continue;
            }
            System.out.println(todo[i].toString());
            System.out.println(" ");
        }
    }
}
