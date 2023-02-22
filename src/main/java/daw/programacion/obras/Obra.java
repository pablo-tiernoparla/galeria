package daw.programacion.obras;

import static daw.programacion.galeria.Mensajes.*;
import daw.programacion.galeria.Menu;

public abstract class Obra {

    protected int id;
    protected String nombre;
    protected String autor;
    protected double precio;
    protected double altura;
    protected double peso;
    protected int piezas;
    protected String desc;
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

    public int getId() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setIdCheck(int id, Obra[] todo) {
        Menu.idYaExiste(id, todo);
        Menu.positiveNum(id);
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

    public abstract double descuento();
    
    public abstract Obra modificarEspecialidad(String spec);

    public abstract void check(String tipo);

    public abstract Obra cambiarTipo(String spec);

    public static Obra[] cargarObras() {
        Pictorica guernica = new Pictorica(1, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
        Pictorica vie = new Pictorica(2, "La Vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
        Pictorica sueño = new Pictorica(3, "El Sueño", "P.Picasso", 300, 1.3, 1, 1, "óleo", "Óleo");
        Pictorica retrato = new Pictorica(4, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo", "Óleo");
        Escultura pielRoja = new Escultura(5, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "Bronce");
        Obra[] exposicion = { guernica, vie, sueño, retrato, pielRoja };
        return exposicion;
    }

    public static void visualizarObras(Obra[] todo) {
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                continue;
            }
            System.out.println(todo[i].toString());
            System.out.println(" ");
        }
    }

    public Obra[] aumentarColeccion(Obra[] coleccion) {
        Obra[] coleccionNueva = new Obra[coleccion.length + 1];
        System.arraycopy(coleccion, 0, coleccionNueva, 0, coleccion.length);
        return coleccionNueva;
    }

    public Obra[] darDeAltaUnaObra(Obra[] todo, String valor) throws IllegalArgumentException {
        try {
            Obra[] placeHolder = aumentarColeccion(todo);
            Obra obraNueva = null;
            obraNueva = this.modificarEspecialidad(valor);
            placeHolder[placeHolder.length - 1] = obraNueva;
            return placeHolder;
        } catch (IllegalArgumentException wrong) {
            System.out.println(ESPACIO);
            System.out.println(ERROR_REINTENTAR);
            return todo;
        }
    }

    public void modificarObra(Obra[] todo, int valor, Obra variableHolder, int pos) {
        if (valor == SELECCION[10]) {
            if (this.tipo.equals(PICTORICA)) {
                Escultura escNueva = new Escultura(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso, this.piezas, this.desc, variableHolder.nombre);
                todo[pos] = escNueva;
            } else if (this.tipo.equals(ESCULTURA)) {
                Pictorica picNueva = new Pictorica(this.id, this.nombre, this.autor, this.precio, this.altura, this.peso, this.piezas, this.desc, variableHolder.nombre);;
                todo[pos] = picNueva;
            }
        } else if (valor == SELECCION[1]) {
            this.setIdCheck(variableHolder.id, todo);
        } else if (valor == SELECCION[2]) {
            this.setNombre(variableHolder.nombre);
        } else if (valor == SELECCION[3]) {
            this.setAutor(variableHolder.autor);
        } else if (valor == SELECCION[4]) {
            this.setPrecio(variableHolder.precio);
        } else if (valor == SELECCION[5]) {
            this.setAltura(variableHolder.altura);
        } else if (valor == SELECCION[6]) {
            this.setPeso(variableHolder.peso);
        } else if (valor == SELECCION[7]) {
            todo[pos] = this.modificarEspecialidad(variableHolder.nombre);
        } else if (valor == SELECCION[8]) {
            this.setPiezas(variableHolder.piezas);
        } else if (valor == SELECCION[9]) {
            this.setDesc(variableHolder.desc);
        }
    }

    public void visualizarDatosObra() {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(AUTOR + this.getAutor());
        System.out.println(PRECIO + this.getPrecio());
        System.out.println(ALTURA + this.getAltura());
        System.out.println(PESO + this.getPeso());
        System.out.println(PIEZAS + this.getPiezas());
        System.out.println(DESC + this.getDesc());
    }

    public double toDolar(double euro) {
        return euro * 0.99;
    }

    public double toKilo(double tonelada) {
        return tonelada * 1000;
    }

    public double precioPorPeso() {
        double suma = 0;
        if (toKilo(this.getPeso()) > PESO_LIMITE) {
            suma += IMPORTE_MAX;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MAX));
        } else {
            suma += IMPORTE_MIN;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MIN));
        }
        return suma;
    }

    public double precioPorAltura() {
        double precioAltura = 0;
        double suma = 0;
        if (this.getAltura() > ALTURA_LIMITE) {
            for (int i = 0; i < this.getPiezas(); i++) {
                precioAltura += IMPORTE_MAX;
                suma = IMPORTE_MAX;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        } else {
            for (int i = 0; i < this.getPiezas(); i++) {
                precioAltura += IMPORTE_MIN;
                suma += IMPORTE_MIN;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        }
        return suma;
    }

    public double precioPorPiezas() {
        double suma = 0;
        if (this.getPiezas() > PIEZAS_LIMITE) {
            for (int i = 2; i < this.getPiezas(); i++) {
                suma += IMPORTE_PIEZA;
                System.out.println(IMPORTE_AD_PIEZA + i + " " + toDolar(PRECIO_PIEZA));
            }
        }
        return suma;
    }

    public double precioFinalSinDescuento() {
        double suma = 0;
        System.out.println(COMISION + toDolar(this.getPrecio() * COMISION_GALERIA));
        suma += (this.getPrecio() * COMISION_GALERIA);
        suma += precioPorPeso();
        suma += precioPorAltura();
        suma += precioPorPiezas();
        System.out.println(VENTA + toDolar(suma));
        return suma;
    }

    public double precioFinal() {
        double suma = 0;
        suma += precioFinalSinDescuento();
        suma += this.descuento();
        System.out.println(PRECIO_FINAL + toDolar(suma));
        return suma;
    }

    public void obtenerPrecio() {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(ALTURA + this.getAltura());
        System.out.println(PESO + this.getPeso());
        System.out.println(PIEZAS + this.getPiezas());
        System.out.println(PRECIO + this.getPrecio());
        precioFinal();
    }

    public void imprimirEtiqueta() {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(AUTOR + this.getAutor());
        System.out.println(DESC + this.getDesc());
    }
}
