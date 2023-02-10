package daw.programacion.galeria;

public final class Mensajes {
    // menu
    public final static String SALIR = "Salir";
    public final static String VISUALIZAR = "Visualizar las obras";
    public final static String DAR_ALTA = "Dar de alta una obra";
    public final static String MODIFICAR = "Modificar datos de una obra";
    public final static String VER_OBRA = "Visualizar datos de una obra";
    public final static String VER_PRECIO = "Obtener precio de venta de una obra";
    public final static String ETIQUETA = "Imprimir etiqueta de la obra";
    public final static String ESCOGER = "Escoge una función";
    public final static int[] SELECCION_MENU = { 0, 1, 2, 3, 4, 5, 6 };
    public final static String[] OPCIONES = { SALIR, VISUALIZAR, DAR_ALTA, MODIFICAR, VER_OBRA, VER_PRECIO, ETIQUETA };
    // interactividad
    public final static String SELECCIONAR_ID = "Selecciona el id de la obra";
    public final static String SELECCIONAR_MOD = "Selecciona qué quieres modificar de la obra";
    public final static String SELECCION_VALOR = "Selecciona su nuevo valor";
    // general
    public final static String ESCULTURA = "escultura";
    public final static String PICTORICA = "pictorica";
    public final static String TIPO = "Tipo (pictorica o escultura) ";
    public final static String TECNICA = "Técnica ";
    public final static String MATERIAL = "Material ";
    public final static String ID = "ID (1 o más)";
    public final static String NOMBRE = "Nombre ";
    public final static String AUTOR = "Autor ";
    public final static String PRECIO = "Precio en euros ";
    public final static String PIEZAS = "Número de piezas ";
    public final static String ALTURA = "Altura en metros ";
    public final static String PESO = "Peso en toneladas ";
    public final static String DESC = "Descripción ";
    public final static String TIPOS_TECNICA = "Tecnica de la obra (oleo, carboncillo, acuarela o acrilica) ";
    public final static String TIPOS_MATERIAL = "Material de la obra (bronce, cobre, hierro o acero) ";
    public final static String ESPECIALIDAD = "Técnica/Material ";
    public final static String ESPACIO = " ";
    public final static String INTRO = "Presiona intro para continuar";
    public final static String COBRE = "cobre";
    public final static String BRONCE = "bronce";
    public final static String HIERRO = "hierro";
    public final static String ACERO = "acero";
    public final static String ACUARELA = "acuarela";
    public final static String ACRILICA = "acrilica";
    public final static String CARBONCILLO = "carboncillo";
    public final static String OLEO = "oleo";
    public final static int[] SELECCION = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    public final static String[] ATRIBUTOS = { SALIR, ID, NOMBRE, AUTOR, PRECIO, ALTURA, PESO, ESPECIALIDAD, PIEZAS, DESC,
      TIPO };
    // precio strings
    public final static String COMISION = "Comisión de la galería: ";
    public final static String IMPORTE_PESO = "Importe por peso: ";
    public final static String IMPORTE_ALTURA = "Importe por altura: ";
    public final static String IMPORTE_AD_PIEZA = "Importe adicional - Pieza: ";
    public final static String VENTA = "Precio de venta: ";
    public final static String DESCUENTO_10 = "Descuento 10% pictórica: ";
    public final static String DESCUENTO_20 = "Descuento 20% escultura: ";
    public final static String GASTOS = "Gastos de manipulación ";
    public final static String PRECIO_FINAL = "Precio final de venta: ";
    // precio numeros
    public final static int PESO_LIMITE = 1;
    public final static int ALTURA_LIMITE = 2;
    public final static int PIEZAS_LIMITE = 2;
    public final static int IMPORTE_MAX = 100;
    public final static int IMPORTE_MIN = 20;
    public final static int IMPORTE_PIEZA = 10;
    public final static int PRECIO_PIEZA = 10;
    public final static int MANIPULACION = 50;
    public final static double COMISION_GALERIA = 1.25;
    public final static double DESCUENTO_PIC = 0.1;
    public final static double DESCUENTO_ESC = 0.2;
    // fallos
    public final static String ERROR_LETRA = "Has introducido algo que no es un número";
    public final static String ERROR_REINTENTAR = "Algo ha salido mal, vuelve a intentarlo";
    public final static String ERROR_NUM_MAL = "No has introducido un valor correcto, vuelve a intentarlo";
}
