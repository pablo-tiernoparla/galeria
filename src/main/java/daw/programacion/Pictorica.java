package daw.programacion;

import static daw.programacion.Mensajes.*;

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
    public void check(String tipo) throws IllegalArgumentException{
        if (!(tipo == OLEO || tipo == CARBONCILLO || tipo == ACRILICA || tipo == ACUARELA)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipo: " + this.tipo + ", Técnica: " + this.tecnica;
    }

    @Override
    public double descuento(Obra[] todo, int precioId) {
        double suma = 0;
        System.out.println(DESCUENTO_10 + Galeria.toDolar((todo[precioId].getPrecio() * DESCUENTO_PIC)));
        suma += (todo[precioId].getPrecio() * DESCUENTO_PIC);
        return suma;
    }

    @Override
    public Obra modificarEspecialidad(Obra[] todo, int modId){
        Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
        picNueva.copy(todo[modId]);
        System.out.println(TIPOS_TECNICA);
        picNueva.setTecnica(Menu.scannerString().toLowerCase());
        return picNueva;
    }
}
