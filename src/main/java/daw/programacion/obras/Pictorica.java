package daw.programacion.obras;

import static daw.programacion.galeria.Mensajes.*;

import daw.programacion.galeria.Menu;

public class Pictorica extends Obra {

    private String tecnica;

    public Pictorica(int id, String nombre, String autor, double precio, double altura, double peso, int piezas,
            String desc, String tecnica) {
        super(id, nombre, autor, precio, altura, peso, piezas, desc);
        this.tipo = "pictorica";
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return this.tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public void check(String tipo) throws IllegalArgumentException {
        if (!(tipo.equals(OLEO) || tipo.equals(CARBONCILLO) || tipo.equals(ACRILICA) || tipo.equals(ACUARELA))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + this.tipo + ", Técnica: " + this.tecnica;
    }

    @Override
    public double descuento(Obra[] todo) {
        double suma = 0;
        System.out.println(DESCUENTO_10 + toDolar((this.getPrecio() * DESCUENTO_PIC)));
        suma += (this.getPrecio() * DESCUENTO_PIC);
        return suma;
    }

    @Override
    public Obra modificarEspecialidad(Obra[] todo) {
        Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
        picNueva.copy(this);
        System.out.println(TIPOS_TECNICA);
        picNueva.setTecnica(Menu.scannerString().toLowerCase());
        return picNueva;
    }

    @Override
    public Obra cambiarTipo() {
        Escultura esculturaNueva = new Escultura(0, this.nombre, this.autor, this.precio, this.altura, this.peso,
                this.piezas, this.desc, null);
        System.out.println(TIPOS_MATERIAL);
        String material = Menu.scannerString().toLowerCase();
        esculturaNueva.check(material);
        esculturaNueva.setMaterial(material);
        return esculturaNueva;
    }

    @Override
    public Pictorica darDeAltaTipo(){
        System.out.println(TIPOS_TECNICA);
        String tipo = Menu.scannerString().toLowerCase();
        this.check(tipo);
        this.setTecnica(tipo);
        return this;
    }
}
