package daw.programacion.obras;

import static daw.programacion.galeria.Mensajes.*;

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
    public Pictorica modificarEspecialidad(String spec) {
        Pictorica picNueva = new Pictorica(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso, this.piezas, this.desc, spec);
        check(spec);
        return picNueva;
    }

    @Override
    public Escultura cambiarTipo(String spec) {
        Escultura esculturaNueva = new Escultura(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso,
                this.piezas, this.desc, spec);
        esculturaNueva.check(spec);
        return esculturaNueva;
    }
}
