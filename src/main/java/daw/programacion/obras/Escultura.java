package daw.programacion.obras;

import static daw.programacion.galeria.Mensajes.*;

import daw.programacion.galeria.Menu;

public class Escultura extends Obra {

    private String material;

    public Escultura(int id, String nombre, String autor, double precio, double altura, double peso, int piezas,
            String desc, String material) {
        super(id, nombre, autor, precio, altura, peso, piezas, desc);
        this.tipo = "escultura";
        this.material = material;
    }

    public Escultura(){}

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void check(String tipo) throws IllegalArgumentException {
        if (!(tipo.equals(BRONCE) || tipo.equals(ACERO) || tipo.equals(COBRE) || tipo.equals(HIERRO))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + this.tipo + ", Material: " + this.material;
    }

    @Override
    public double descuento() {
        double suma = 0;
        System.out.println(DESCUENTO_20 + toDolar((this.getPrecio() * DESCUENTO_ESC)));
        suma += (this.getPrecio() * DESCUENTO_ESC);
        System.out.println(GASTOS + toDolar(MANIPULACION));
        suma += MANIPULACION;
        return suma;
    }

    @Override
    public Obra modificarEspecialidad(String spec) {
        Escultura esculturaNueva = new Escultura(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso, this.piezas, this.desc, spec);
        esculturaNueva.check(spec);
        return esculturaNueva;
    }

    @Override
    public Pictorica cambiarTipo(String spec) {
        Pictorica pictoricaNueva = new Pictorica(0, this.nombre, this.autor, this.precio, this.altura, this.peso,
                this.piezas, this.desc, null);
        System.out.println(TIPOS_TECNICA);
        pictoricaNueva.check(spec);
        pictoricaNueva.setTecnica(spec);
        System.out.println(this.getMaterial());
        return pictoricaNueva;
    }
}
