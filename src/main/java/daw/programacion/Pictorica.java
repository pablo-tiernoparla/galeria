package daw.programacion;

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
    public String toString() {
        return super.toString() + ", Tipo: " + this.tipo + ", Técnica: " + this.tecnica;
    }
}
