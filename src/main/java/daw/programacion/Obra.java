package daw.programacion;

public class Obra {

    private int id;
    private String nombre;
    private String autor;
    private double precio;
    private double altura;
    private double peso;
    private int piezas;
    private String desc;
    protected String tipo;

    public Obra(int id, String nombre, String autor, double precio, double altura, double peso, int piezas,
            String desc) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.altura = altura;
        this.peso = peso;
        this.piezas = piezas;
        this.desc = desc;
    }

    public Obra() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPiezas() {
        return this.piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nombre: " + this.nombre + ", Autor: " + this.autor + ", Precio: " + this.precio
                + ", Altura: "
                + this.altura + ", Peso: " + this.peso + ", Piezas: " + this.piezas + ", Descripción: " + this.desc;
    }

    public String getTipo() {
        return this.tipo;
    }

}
