package daw.programacion;

import static daw.programacion.Mensajes.*;

public class Escultura extends Obra {
    
    private String material;

    public Escultura(int id, String nombre, String autor, double precio, double altura, double peso, int piezas,
            String desc, String material) {
        super(id, nombre, autor, precio, altura, peso, piezas, desc);
        this.tipo = ESCULTURA;
        this.material = material;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipo: " + this.tipo + ", Material: " + this.material;
    }

    @Override
    public double descuento(Obra[] todo, int precioId){
        double suma = 0;
        System.out.println(DESCUENTO_20 + Galeria.toDolar((todo[precioId].getPrecio() * DESCUENTO_ESC)));
        suma += (todo[precioId].getPrecio() * DESCUENTO_ESC);
        System.out.println(GASTOS + Galeria.toDolar(MANIPULACION));
        suma += MANIPULACION;
        return suma;
    }
}
