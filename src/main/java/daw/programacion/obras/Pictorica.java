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
    public double descuento() {
        double suma = 0;
        System.out.println(DESCUENTO_10 + toDolar((this.getPrecio() * DESCUENTO_PIC)));
        suma += (this.getPrecio() * DESCUENTO_PIC);
        return suma;
    }

    @Override
    public Obra modificarEspecialidad(String spec) {
        Pictorica picNueva = new Pictorica(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso, this.piezas, this.desc, spec);
        picNueva.check(spec);
        return picNueva;
    }

    @Override
    public Escultura cambiarTipo(String spec) {
        Escultura esculturaNueva = new Escultura(0, this.nombre, this.autor, this.precio, this.altura, this.peso,
                this.piezas, this.desc, null);
        esculturaNueva.check(spec);
        esculturaNueva.setMaterial(spec);
        this.getTecnica();
        return esculturaNueva;
    }
}
