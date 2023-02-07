package daw.programacion;

import java.util.Scanner;
import static daw.programacion.Mensajes.*;

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

    public void darDeAlta(Obra obraNueva, Obra[] todo) {
        darDeAltaId(obraNueva, todo);
        darDeAltaNombre(obraNueva);
        darDeAltaAutor(obraNueva);
        darDeAltaPrecio(obraNueva);
        darDeAltaAltura(obraNueva);
        darDeAltaPeso(obraNueva);
        darDeAltaPiezas(obraNueva);
        darDeAltaDesc(obraNueva);
    }

    public void darDeAltaId(Obra obraNueva, Obra[] todo) {
        System.out.println(ID);
        int newId = scannerInt();
        obraNueva.setId(newId);

    }

    public void darDeAltaNombre(Obra obraNueva) {

        System.out.println(NOMBRE);
        obraNueva.setNombre(scannerString());

    }

    public void darDeAltaAutor(Obra obraNueva) {
        System.out.println(AUTOR);
        obraNueva.setAutor(scannerString());

    }

    public void darDeAltaPrecio(Obra obraNueva) {
        System.out.println(PRECIO);
        obraNueva.setPrecio(scannerDouble());

    }

    public void darDeAltaAltura(Obra obraNueva) {
        System.out.println(ALTURA);
        obraNueva.setAltura(scannerDouble());

    }

    public void darDeAltaPeso(Obra obraNueva) {
        System.out.println(PESO);
        obraNueva.setPeso(scannerDouble());

    }

    public void darDeAltaPiezas(Obra obraNueva) {
        System.out.println(PIEZAS);
        obraNueva.setPiezas(scannerInt());
    }

    public void darDeAltaDesc(Obra obraNueva) {
        System.out.println(DESC);
        obraNueva.setDesc(scannerString());
    }

    public Obra[] darDeAltaUnaObra(Obra[] todo) throws IllegalArgumentException {
        Obra[] placeHolder = todo;
        System.out.println(TIPO);
        String tipo = scannerString().toLowerCase();
        Obra obraNueva = null;
        if (tipo.equals(PICTORICA)) {

        } else if (tipo.equals(ESCULTURA)) {

        } else {
            throw new IllegalArgumentException();
        }
        placeHolder[placeHolder.length - 1] = obraNueva;
        return placeHolder;
    }
}
