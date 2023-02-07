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

    public static String scannerString() {
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

    public Obra[] aumentarColeccion(Obra[] coleccion) {
        Obra[] coleccionNueva = new Obra[coleccion.length + 1];
        System.arraycopy(coleccion, 0, coleccionNueva, 0, coleccion.length);
        return coleccionNueva;
    }

    // excepcion letras y numeros
    // excepcion id ya existe
    public Obra[] darDeAltaUnaObra(Obra[] todo) throws IllegalArgumentException {
        Obra[] placeHolder = todo;
        placeHolder = aumentarColeccion(todo);
        System.out.println(TIPO);
        String tipo = scannerString().toLowerCase();
        Obra obraNueva = null;
        if (tipo.equals(PICTORICA)) {
            obraNueva = darDeAltaPictorica(todo);
        } else if (tipo.equals(ESCULTURA)) {
            obraNueva = darDeAltaEscultura(todo);
        } else {
            throw new IllegalArgumentException();
        }
        placeHolder[placeHolder.length - 1] = obraNueva;
        return placeHolder;
    }

    public Pictorica darDeAltaPictorica(Obra[] todo) {
        Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(picNueva, todo);
        System.out.println(TIPOS_TECNICA);
        picNueva.setTecnica(scannerString().toLowerCase());
        return picNueva;
    }

    public Escultura darDeAltaEscultura(Obra[] todo) {
        Escultura esculturaNueva = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(esculturaNueva, todo);
        System.out.println(TIPOS_MATERIAL);
        esculturaNueva.setMaterial(scannerString().toLowerCase());
        return esculturaNueva;
    }

    public void modificarObra(int modId, Obra[] todo) {
        Menu menuModificar = new Menu();

        System.out.println(SELECCIONAR_MOD);
        menuModificar.menuModificarObra();
        int modificar = scannerInt();
        if (modificar == SELECCION[0]) {
            return;
        }
        System.out.println(SELECCION_VALOR);
        if (modificar == SELECCION[10]) {
            todo[modId] = todo[modId].crearTipo(scannerString().toLowerCase());
        } else if (modificar == SELECCION[1]) {
            darDeAltaId(null, todo);
        } else if (modificar == SELECCION[2]) {
            todo[modId].setNombre(scannerString());
        } else if (modificar == SELECCION[3]) {
            todo[modId].setAutor(scannerString());
        } else if (modificar == SELECCION[4]) {
            todo[modId].setPrecio(scannerDouble());
        } else if (modificar == SELECCION[5]) {
            todo[modId].setAltura(scannerDouble());
        } else if (modificar == SELECCION[6]) {
            todo[modId].setPeso(scannerDouble());
        } else if (modificar == SELECCION[7]) {
            todo[modId] = modificarEspecialidad(todo, modId);
        } else if (modificar == SELECCION[8]) {
            todo[modId].setPiezas(scannerInt());
        } else if (modificar == SELECCION[9]) {
            todo[modId].setDesc(scannerString());
        }
    }

    public Obra modificarEspecialidad(Obra[] todo, int modId) {
        if (todo[modId].getTipo().equals(ESCULTURA)) {
            Escultura esculturaNueva = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
            esculturaNueva.copy(todo[modId]);
            System.out.println(TIPOS_MATERIAL);
            esculturaNueva.setMaterial(scannerString().toLowerCase());
            return esculturaNueva;
        } else if (todo[modId].getTipo().equals(PICTORICA)) {
            Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
            picNueva.copy(todo[modId]);
            System.out.println(TIPOS_TECNICA);
            picNueva.setTecnica(scannerString().toLowerCase());
            return picNueva;
        }
        return null;
    }

    public void visualizarDatosObra(int visualId, Obra[] todo) {
        System.out.println(NOMBRE + todo[visualId].getNombre());
        System.out.println(AUTOR + todo[visualId].getAutor());
        System.out.println(PRECIO + todo[visualId].getPrecio());
        System.out.println(ALTURA + todo[visualId].getAltura());
        System.out.println(PESO + todo[visualId].getPeso());
        System.out.println(PIEZAS + todo[visualId].getPiezas());
        System.out.println(DESC + todo[visualId].getDesc());
    }
}
