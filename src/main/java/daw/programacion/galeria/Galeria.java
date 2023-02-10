package daw.programacion.galeria;

import static daw.programacion.galeria.Mensajes.*;

import daw.programacion.obras.Escultura;
import daw.programacion.obras.Obra;
import daw.programacion.obras.Pictorica;

public class Galeria {

    private boolean activo = true;

    public Galeria() {
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public int findId(int num, Obra[] todo) throws IllegalArgumentException {
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

    public void checkInputs(int num) throws IllegalArgumentException {
        if (!(num >= 0 && num < 7)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkTipo(String tipo) throws IllegalArgumentException {
        if (!(tipo.equals(PICTORICA) && tipo.equals(ESCULTURA))) {
            throw new IllegalArgumentException();
        }
    }

    public void checkString(String checked) throws IllegalArgumentException{
        if (checked.equals("")){
            throw new IllegalArgumentException();
        }
    }

    //acciones
    public void visualizarObras(Obra[] todo) {
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

    public void darDeAltaNombre(Obra obraNueva) {
        System.out.println(NOMBRE);
        String nombre = Menu.scannerString();
        checkString(nombre);
        obraNueva.setNombre(nombre);

    }

    public void darDeAltaAutor(Obra obraNueva) {
        System.out.println(AUTOR);
        String autor = Menu.scannerString();
        checkString(autor);
        obraNueva.setAutor(autor);

    }

    public void darDeAltaPrecio(Obra obraNueva) {
        System.out.println(PRECIO);
        double precio = Menu.scannerDouble();
        positiveNum(precio);
        obraNueva.setPrecio(precio);

    }

    public void darDeAltaAltura(Obra obraNueva) {
        System.out.println(ALTURA);
        double altura = Menu.scannerDouble();
        positiveNum(altura);
        obraNueva.setAltura(altura);

    }

    public void darDeAltaPeso(Obra obraNueva) {
        System.out.println(PESO);
        double peso = Menu.scannerDouble();
        positiveNum(peso);
        obraNueva.setPeso(peso);

    }

    public void darDeAltaPiezas(Obra obraNueva) {
        System.out.println(PIEZAS);
        int piezas = Menu.scannerInt();
        positiveNum(piezas);
        obraNueva.setPiezas(piezas);
    }

    public void darDeAltaDesc(Obra obraNueva) {
        System.out.println(DESC);
        String desc = Menu.scannerString();
        checkString(desc);
        obraNueva.setDesc(desc);
    }

    public void darDeAlta(Obra obraNueva, Obra[] todo) {
        darDeAltaId(obraNueva, todo);
        darDeAltaNombre(obraNueva);
        darDeAltaAutor(obraNueva);
        darDeAltaPrecio(obraNueva);
        darDeAltaAltura(obraNueva);
        darDeAltaPeso(obraNueva);
        darDeAltaPiezas(obraNueva);
        darDeAltaDesc(obraNueva);
    }

    public Pictorica darDeAltaPictorica(Obra[] todo) throws IllegalArgumentException {
        Pictorica picNueva = new Pictorica(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(picNueva, todo);
        System.out.println(TIPOS_TECNICA);
        String tipo = Menu.scannerString().toLowerCase();
        picNueva.check(tipo);
        picNueva.setTecnica(tipo);
        return picNueva;
    }

    public Escultura darDeAltaEscultura(Obra[] todo) {
        Escultura esculturaNueva = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
        darDeAlta(esculturaNueva, todo);
        System.out.println(TIPOS_MATERIAL);
        String tipo = Menu.scannerString().toLowerCase();
        esculturaNueva.check(tipo);
        esculturaNueva.setMaterial(tipo);
        return esculturaNueva;
    }

    public Obra[] aumentarColeccion(Obra[] coleccion) {
        Obra[] coleccionNueva = new Obra[coleccion.length + 1];
        System.arraycopy(coleccion, 0, coleccionNueva, 0, coleccion.length);
        return coleccionNueva;
    }

    public Obra[] darDeAltaUnaObra(Obra[] todo) throws IllegalArgumentException {
        try {
            Obra[] placeHolder = aumentarColeccion(todo);
            System.out.println(TIPO);
            String tipo = Menu.scannerString().toLowerCase();
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

    public void modificarObra(int num, Obra[] todo) {
        Menu menuModificar = new Menu();
        int modId = findId(num, todo);

        System.out.println(SELECCIONAR_MOD);
        menuModificar.menuModificarObra();
        int modificar = Menu.scannerInt();
        if (modificar == SELECCION[0]) {
            return;
        }
        System.out.println(SELECCION_VALOR);
        if (modificar == SELECCION[10]) {
            int save = todo[modId].getId();
            todo[modId] = todo[modId].cambiarTipo();
            todo[modId].setId(save);
        } else if (modificar == SELECCION[1]) {
            darDeAltaId(todo[modId], todo);
        } else if (modificar == SELECCION[2]) {
            darDeAltaNombre(todo[modId]);
        } else if (modificar == SELECCION[3]) {
            darDeAltaAutor(todo[modId]);
        } else if (modificar == SELECCION[4]) {
            darDeAltaPrecio(todo[modId]);
        } else if (modificar == SELECCION[5]) {
            darDeAltaAltura(todo[modId]);
        } else if (modificar == SELECCION[6]) {
            darDeAltaPeso(todo[modId]);
        } else if (modificar == SELECCION[7]) {
            todo[modId] = todo[modId].modificarEspecialidad(todo, modId);
        } else if (modificar == SELECCION[8]) {
            darDeAltaPiezas(todo[modId]);
        } else if (modificar == SELECCION[9]) {
            darDeAltaDesc(todo[modId]);
        }
    }

    public void visualizarDatosObra(int num, Obra[] todo) {
        int visualId = findId(num, todo);
        System.out.println(NOMBRE + todo[visualId].getNombre());
        System.out.println(AUTOR + todo[visualId].getAutor());
        System.out.println(PRECIO + todo[visualId].getPrecio());
        System.out.println(ALTURA + todo[visualId].getAltura());
        System.out.println(PESO + todo[visualId].getPeso());
        System.out.println(PIEZAS + todo[visualId].getPiezas());
        System.out.println(DESC + todo[visualId].getDesc());
    }

    public static double toDolar(double euro) {
        return euro / 0.99;
    }

    public double toKilo(double tonelada) {
        return tonelada * 1000;
    }

    public double precioPorPeso(Obra[] todo, int precioId) {
        double suma = 0;
        if (toKilo(todo[precioId].getPeso()) > PESO_LIMITE) {
            suma += IMPORTE_MAX;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MAX));
        } else {
            suma += IMPORTE_MAX;
            System.out.println(IMPORTE_PESO + toDolar(IMPORTE_MIN));
        }
        return suma;
    }

    public double precioPorAltura(Obra[] todo, int precioId) {
        double precioAltura = 0;
        double suma = 0;
        if (todo[precioId].getAltura() > ALTURA_LIMITE) {
            for (int i = 0; i < todo[precioId].getPiezas(); i++) {
                precioAltura += IMPORTE_MAX;
                suma = precioAltura;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        } else {
            for (int i = 0; i < todo[precioId].getPiezas(); i++) {
                precioAltura += IMPORTE_MIN;
                suma += precioAltura;
            }
            System.out.println(IMPORTE_ALTURA + toDolar(precioAltura));
        }
        return suma;
    }

    public double precioPorPiezas(Obra[] todo, int precioId) {
        double suma = 0;
        if (todo[precioId].getPiezas() > PIEZAS_LIMITE) {
            for (int i = 2; i < todo[precioId].getPiezas(); i++) {
                suma += IMPORTE_PIEZA;
                System.out.println(IMPORTE_AD_PIEZA + i + " " + toDolar(PRECIO_PIEZA));
            }
        }
        return suma;
    }

    public double precioFinalSinDescuento(Obra[] todo, int precioId) {
        double suma = 0;
        System.out.println(COMISION + toDolar(todo[precioId].getPrecio() * COMISION_GALERIA));
        suma += (todo[precioId].getPrecio() * COMISION_GALERIA);
        suma += precioPorPeso(todo, precioId);
        suma += precioPorAltura(todo, precioId);
        suma += precioPorPiezas(todo, precioId);
        System.out.println(VENTA + toDolar(suma));
        return suma;
    }

    public double precioFinal(Obra[] todo, int precioId) {
        double suma = 0;
        suma += precioFinalSinDescuento(todo, precioId);
        suma += todo[precioId].descuento(todo, precioId);
        System.out.println(PRECIO_FINAL + toDolar(suma));
        return suma;
    }

    public void obtenerPrecio(int num, Obra[] todo) {
        int precioId = findId(num, todo);

        System.out.println(NOMBRE + todo[precioId].getNombre());
        System.out.println(ALTURA + todo[precioId].getAltura());
        System.out.println(PESO + todo[precioId].getPeso());
        System.out.println(PIEZAS + todo[precioId].getPiezas());
        System.out.println(PRECIO + todo[precioId].getPrecio());
        precioFinal(todo, precioId);
    }

    public void imprimirEtiqueta(int num, Obra[] todo) {
        int etiquetaId = findId(num, todo);
        System.out.println(NOMBRE + todo[etiquetaId].getNombre());
        System.out.println(AUTOR + todo[etiquetaId].getAutor());
        System.out.println(DESC + todo[etiquetaId].getDesc());
    }
}
