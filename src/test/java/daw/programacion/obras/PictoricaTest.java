package daw.programacion.obras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PictoricaTest {

    Pictorica obra1;

    @BeforeEach
    void crearObjetoObra() {
        obra1 = new Pictorica(2, "qwe", "Pablo", 4, 1, 0.00003, 7, "descripcion", "oleo");
    }

    @AfterEach
    void borrarObjetoObra() {
        obra1 = null;
    }

    @Test
    public void getTecnicaFunciona(){
        String expected = "oleo";
        assertEquals(expected, obra1.getTecnica());
    }

    @Test
    public void setTecnicaFunciona(){
        String expected = "acuarela";
        obra1.setTecnica("acuarela");
        assertEquals(expected, obra1.getTecnica());
    }
    
    @Test
    public void checkPictoricaExcepcion(){
        String error = "abc";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    obra1.check(error);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = { "oleo", "carboncillo", "acuarela", "acrilica" })
    public void checkPictoricaValoresCorrectos(String tipo) {
        obra1.check(tipo);
    }

    @Test
    public void toStringPictorica() {
        String expected = "ID: 2, Nombre: qwe, Autor: Pablo, Precio: 4.0, Altura: 1.0, Peso: 3.0E-5, Piezas: 7, Descripción: descripcion, Tipo: pictorica, Técnica: oleo";
        assertEquals(expected, obra1.toString());
    }

    @Test
    public void descuentoFunciona(){
        double expected = 0.4;
        assertEquals(expected, obra1.descuento());
    }
 
    @Test
    public void modificarEspecialidadFuncionaPictorica(){
        String expected = "acuarela";
        obra1 = obra1.modificarEspecialidad("acuarela");
        assertEquals(expected, obra1.getTecnica());
    }

    @Test
    public void cambiarTipoFunciona(){
        String expected = "escultura";
        Obra obra3;
        obra3 = obra1.cambiarTipo("cobre");
        assertEquals(expected, obra3.getTipo());
    }
}
