package daw.programacion;

public final class Mensajes {
    //menu
    final static String SALIR = "Salir";
    final static String VISUALIZAR = "Visualizar las obras";
    final static String DAR_ALTA = "Dar de alta una obra";
    final static String MODIFICAR = "Modificar datos de una obra";
    final static String VER_OBRA = "Visualizar datos de una obra";
    final static String VER_PRECIO = "Obtener precio de venta de una obra";
    final static String ETIQUETA = "Imprimir etiqueta de la obra";
    final static String ESCOGER = "Escoge una función";
    final static int[] SELECCION_MENU = { 0, 1, 2, 3, 4, 5, 6 };
    final static String[] OPCIONES = { SALIR, VISUALIZAR, DAR_ALTA, MODIFICAR, VER_OBRA, VER_PRECIO, ETIQUETA };
 
    //interactividad
    final static String SELECCIONAR_ID = "Selecciona el id de la obra";
    final static String SELECCIONAR_MOD = "Selecciona qué quieres modificar de la obra";
    final static String SELECCION_VALOR = "Selecciona su nuevo valor";
    //general
    final static String ESCULTURA = "escultura";
    final static String PICTORICA = "pictorica";
    final static String TIPO = "Tipo (pictorica o escultura) ";
    final static String TECNICA = "Técnica ";
    final static String MATERIAL = "Material ";
    final static String ID = "ID (1 o más)";
    final static String NOMBRE = "Nombre ";
    final static String AUTOR = "Autor ";
    final static String PRECIO = "Precio en euros ";
    final static String PIEZAS = "Número de piezas ";
    final static String ALTURA = "Altura en metros ";
    final static String PESO = "Peso en toneladas ";
    final static String DESC = "Descripción ";
    final static String TIPOS_TECNICA = "Tecnica de la obra (oleo, carboncillo, acuarela o acrilica) ";
    final static String TIPOS_MATERIAL = "Material de la obra (bronce, cobre, hierro o acero) ";
    final static String ESPECIALIDAD = "Técnica/Material ";
    final static String ESPACIO = " ";
    final static String INTRO = "Presiona intro para continuar";
    final static String COBRE = "cobre";
    final static String BRONCE = "bronce";
    final static String HIERRO = "hierro";
    final static String ACERO = "acero";
    final static String ACUARELA = "acuarela";
    final static String ACRILICA = "acrilica";
    final static String CARBONCILLO = "carboncillo";
    final static String OLEO = "oleo";
    final static int[] SELECCION = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    final static String[] ATRIBUTOS = { SALIR, ID, NOMBRE, AUTOR, PRECIO, ALTURA, PESO, ESPECIALIDAD, PIEZAS, DESC, TIPO };

    //precio strings
    final static String COMISION = "Comisión de la galería: ";
    final static String IMPORTE_PESO = "Importe por peso: ";
    final static String IMPORTE_ALTURA = "Importe por altura: ";
    final static String IMPORTE_AD_PIEZA = "Importe adicional - Pieza: ";
    final static String VENTA = "Precio de venta: ";
    final static String DESCUENTO_10 = "Descuento 10% pictórica: ";
    final static String DESCUENTO_20 = "Descuento 20% escultura: ";
    final static String GASTOS = "Gastos de manipulación ";
    final static String PRECIO_FINAL = "Precio final de venta: ";
    //precio numeros
    final static int PESO_LIMITE = 1;
    final static int ALTURA_LIMITE = 2;
    final static int PIEZAS_LIMITE = 2;
    final static int IMPORTE_MAX = 100;
    final static int IMPORTE_MIN = 20;
    final static int IMPORTE_PIEZA = 10;
    final static int PRECIO_PIEZA = 10;
    final static int MANIPULACION = 50;
    final static double COMISION_GALERIA = 1.25;
    final static double DESCUENTO_PIC = 0.1;
    final static double DESCUENTO_ESC = 0.2;
    //fallos
    final static String ERROR_LETRA = "Has introducido algo que no es un número";
    final static String ERROR_REINTENTAR = "Algo ha salido mal, vuelve a intentarlo";
    final static String ERROR_NUM_MAL = "No has introducido un valor correcto, vuelve a intentarlo";
    final static String ERROR_TIPO = "Has seleccionado una técnica o material erróneos";
}
