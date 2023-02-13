package daw.programacion.obras;

import static daw.programacion.galeria.Mensajes.*;
import daw.programacion.galeria.Menu;

public class Obra {

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

    public Obra cambiarTipo(){
        return null;
    }

    public void copy(Obra copy) {
        this.id = copy.id;
        this.nombre = copy.nombre;
        this.autor = copy.autor;
        this.precio = copy.precio;
        this.altura = copy.altura;
        this.peso = copy.peso;
        this.piezas = copy.piezas;
        this.desc = copy.desc;
    }

    //solo estan para hacer override
    public double descuento(Obra[] todo) {
        return 0;
    }

    public Obra modificarEspecialidad(Obra[] todo) {
        return null;
    }

    public void check(String tipo){
    }

    public static Obra[] cargarObras() {
        Pictorica guernica = new Pictorica(1, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
        Pictorica vie = new Pictorica(2, "La Vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
        Pictorica sueño = new Pictorica(3, "El Sueño", "P.Picasso", 300, 1.3, 1, 1, "óleo", "Óleo");
        Pictorica retrato = new Pictorica(4, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo", "Óleo");
        Escultura pielRoja = new Escultura(5, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "Bronce");
        Obra[] exposicion = { guernica, vie, sueño, retrato, pielRoja };
        return exposicion;
    }

    //excepciones
    public static void positiveNum(double num) throws IllegalArgumentException{
        if(!(num > 0)){
            throw new IllegalArgumentException();
        }
    }

    public static void idYaExiste(int num, Obra[] todo) throws IllegalArgumentException {
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                continue;
            } else if (num == todo[i].getId()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkInputs(int num) throws IllegalArgumentException {
        if (!(num >= 0 && num < 7)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void checkTipo(String tipo) throws IllegalArgumentException {
        if (!(tipo.equals(PICTORICA) && tipo.equals(ESCULTURA))) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkString(String checked) throws IllegalArgumentException{
        if (checked.equals("")){
            throw new IllegalArgumentException();
        }
    }

    public static int findId(int num, Obra[] todo) throws IllegalArgumentException {
        int index;
        for (index = 0; index < todo.length; index++) {
            if (num == todo[index].getId()) {
                break;
            } else if (index == todo.length - 1 && todo[todo.length - 1].getId() != index) {
                throw new IllegalArgumentException();
            }
        }
        return index;
    }

    //acciones
    public static void visualizarObras(Obra[] todo) {
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                continue;
            }
            System.out.println(todo[i].toString());
            System.out.println(" ");
        }
    }

    public static void darDeAltaId(Obra obraNueva, Obra[] todo) {
        System.out.println(ID);
        int newId = Menu.scannerInt();
        idYaExiste(newId, todo);
        positiveNum(newId);
        obraNueva.setId(newId);

    }

    public static void darDeAltaNombre(Obra obraNueva) {
        System.out.println(NOMBRE);
        String nombre = Menu.scannerString();
        checkString(nombre);
        obraNueva.setNombre(nombre);

    }

    public static void darDeAltaAutor(Obra obraNueva) {
        System.out.println(AUTOR);
        String autor = Menu.scannerString();
        checkString(autor);
        obraNueva.setAutor(autor);

    }

    public static void darDeAltaPrecio(Obra obraNueva) {
        System.out.println(PRECIO);
        double precio = Menu.scannerDouble();
        positiveNum(precio);
        obraNueva.setPrecio(precio);

    }

    public static void darDeAltaAltura(Obra obraNueva) {
        System.out.println(ALTURA);
        double altura = Menu.scannerDouble();
        positiveNum(altura);
        obraNueva.setAltura(altura);

    }

    public static void darDeAltaPeso(Obra obraNueva) {
        System.out.println(PESO);
        double peso = Menu.scannerDouble();
        positiveNum(peso);
        obraNueva.setPeso(peso);

    }

    public static void darDeAltaPiezas(Obra obraNueva) {
        System.out.println(PIEZAS);
        int piezas = Menu.scannerInt();
        positiveNum(piezas);
        obraNueva.setPiezas(piezas);
    }

    public static void darDeAltaDesc(Obra obraNueva) {
        System.out.println(DESC);
        String desc = Menu.scannerString();
        checkString(desc);
        obraNueva.setDesc(desc);
    }

    public static void darDeAlta(Obra obraNueva, Obra[] todo) {
        darDeAltaId(obraNueva, todo);
        darDeAltaNombre(obraNueva);
        darDeAltaAutor(obraNueva);
        darDeAltaPrecio(obraNueva);
        darDeAltaAltura(obraNueva);
        darDeAltaPeso(obraNueva);
        darDeAltaPiezas(obraNueva);
        darDeAltaDesc(obraNueva);
    }

    public static Pictorica darDeAltaPictorica(Obra[] todo) throws IllegalArgumentException {
        Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(picNueva, todo);
        System.out.println(TIPOS_TECNICA);
        String tipo = Menu.scannerString().toLowerCase();
        picNueva.check(tipo);
        picNueva.setTecnica(tipo);
        return picNueva;
    }

    public static Escultura darDeAltaEscultura(Obra[] todo) {
        Escultura esculturaNueva = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(esculturaNueva, todo);
        System.out.println(TIPOS_MATERIAL);
        String tipo = Menu.scannerString().toLowerCase();
        esculturaNueva.check(tipo);
        esculturaNueva.setMaterial(tipo);
        return esculturaNueva;
    }

    public static Obra[] aumentarColeccion(Obra[] coleccion) {
        Obra[] coleccionNueva = new Obra[coleccion.length + 1];
        System.arraycopy(coleccion, 0, coleccionNueva, 0, coleccion.length);
        return coleccionNueva;
    }

    public static Obra[] darDeAltaUnaObra(Obra[] todo, String tipo) throws IllegalArgumentException {
        try {
            Obra[] placeHolder = aumentarColeccion(todo);
            Obra obraNueva = null;
            if (tipo.equals(PICTORICA)) {
                obraNueva = darDeAltaPictorica(todo);
            } else if (tipo.equals(ESCULTURA)) {
                obraNueva = darDeAltaEscultura(todo);
            } else {
                throw new IllegalArgumentException();
            }
            placeHolder[placeHolder.length - 1] = obraNueva;
            return placeHolder;
        } catch (IllegalArgumentException wrong) {
            System.out.println(ESPACIO);
            System.out.println(ERROR_REINTENTAR);
            return todo;
        }
    }

    public void modificarObra(Obra[] todo, int valor) {
        if (valor == SELECCION[0]) {
            return;
        }
        if (valor == SELECCION[10]) {
            int save = this.getId();
            this.cambiarTipo();
            this.setId(save);
        } else if (valor == SELECCION[1]) {
            darDeAltaId(this, todo);
        } else if (valor == SELECCION[2]) {
            darDeAltaNombre(this);
        } else if (valor == SELECCION[3]) {
            darDeAltaAutor(this);
        } else if (valor == SELECCION[4]) {
            darDeAltaPrecio(this);
        } else if (valor == SELECCION[5]) {
            darDeAltaAltura(this);
        } else if (valor == SELECCION[6]) {
            darDeAltaPeso(this);
        } else if (valor == SELECCION[7]) {
            this.modificarEspecialidad(todo);
        } else if (valor == SELECCION[8]) {
            darDeAltaPiezas(this);
        } else if (valor == SELECCION[9]) {
            darDeAltaDesc(this);
        }
    }

    public void visualizarDatosObra(Obra[] todo) {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(AUTOR + this.getAutor());
        System.out.println(PRECIO + this.getPrecio());
        System.out.println(ALTURA + this.getAltura());
        System.out.println(PESO + this.getPeso());
        System.out.println(PIEZAS + this.getPiezas());
        System.out.println(DESC + this.getDesc());
    }

    public static double toDolar(double euro) {
        return euro / 0.99;
    }

    public double toKilo(double tonelada) {
        return tonelada * 1000;
    }

    public double precioPorPeso(Obra[] todo) {
        double suma = 0;
        if (toKilo(this.getPeso()) > PESO_LIMITE) {
            suma += IMPORTE_MAX;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MAX));
        } else {
            suma += IMPORTE_MAX;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MIN));
        }
        return suma;
    }

    public double precioPorAltura(Obra[] todo) {
        double precioAltura = 0;
        double suma = 0;
        if (this.getAltura() > ALTURA_LIMITE) {
            for (int i = 0; i < this.getPiezas(); i++) {
                precioAltura += IMPORTE_MAX;
                suma = precioAltura;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        } else {
            for (int i = 0; i < this.getPiezas(); i++) {
                precioAltura += IMPORTE_MIN;
                suma += precioAltura;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        }
        return suma;
    }

    public double precioPorPiezas(Obra[] todo) {
        double suma = 0;
        if (this.getPiezas() > PIEZAS_LIMITE) {
            for (int i = 2; i < this.getPiezas(); i++) {
                suma += IMPORTE_PIEZA;
                System.out.println(IMPORTE_AD_PIEZA + i + " " + toDolar(PRECIO_PIEZA));
            }
        }
        return suma;
    }

    public double precioFinalSinDescuento(Obra[] todo) {
        double suma = 0;
        System.out.println(COMISION + toDolar(this.getPrecio() * COMISION_GALERIA));
        suma += (this.getPrecio() * COMISION_GALERIA);
        suma += precioPorPeso(todo);
        suma += precioPorAltura(todo);
        suma += precioPorPiezas(todo);
        System.out.println(VENTA + toDolar(suma));
        return suma;
    }

    public double precioFinal(Obra[] todo) {
        double suma = 0;
        suma += precioFinalSinDescuento(todo);
        suma += this.descuento(todo);
        System.out.println(PRECIO_FINAL + toDolar(suma));
        return suma;
    }

    public void obtenerPrecio(Obra[] todo) {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(ALTURA + this.getAltura());
        System.out.println(PESO + this.getPeso());
        System.out.println(PIEZAS + this.getPiezas());
        System.out.println(PRECIO + this.getPrecio());
        precioFinal(todo);
    }

    public void imprimirEtiqueta(Obra[] todo) {
        System.out.println(NOMBRE + this.getNombre());
        System.out.println(AUTOR + this.getAutor());
        System.out.println(DESC + this.getDesc());
    }
}
