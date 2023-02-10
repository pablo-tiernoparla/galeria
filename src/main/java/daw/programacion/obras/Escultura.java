package daw.programacion.obras;

import static daw.programacion.obras.MensajesObras.*;

import daw.programacion.galeria.Galeria;
import daw.programacion.galeria.Menu;

public class Escultura extends Obra {

    private String material;

    public Escultura(int id, String nombre, String autor, double precio, double altura, double peso, int piezas,
            String desc, String material) {
        super(id, nombre, autor, precio, altura, peso, piezas, desc);
        this.tipo = "escultura";
        this.material = material;
    }

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
    public double descuento(Obra[] todo, int precioId) {
        double suma = 0;
        System.out.println(DESCUENTO_20 + Galeria.toDolar((todo[precioId].getPrecio() * DESCUENTO_ESC)));
        suma += (todo[precioId].getPrecio() * DESCUENTO_ESC);
        System.out.println(GASTOS + Galeria.toDolar(MANIPULACION));
        suma += MANIPULACION;
        return suma;
    }

    @Override
    public Obra modificarEspecialidad(Obra[] todo, int modId) {
        Escultura esculturaNueva = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
        esculturaNueva.copy(todo[modId]);
        System.out.println(TIPOS_MATERIAL);
        esculturaNueva.setMaterial(Menu.scannerString().toLowerCase());
        return esculturaNueva;
    }

    @Override
    public Obra cambiarTipo() {
        Pictorica pictoricaNueva = new Pictorica(0, this.nombre, this.autor, this.precio, this.altura, this.peso,
                this.piezas, this.desc, null);
        System.out.println(TIPOS_TECNICA);
        String tecnica = Menu.scannerString().toLowerCase();
        pictoricaNueva.check(tecnica);
        pictoricaNueva.setTecnica(tecnica);
        return pictoricaNueva;
    }
}
