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
    public void checkEsculturaValoresCorrectos(String tipo) {
        obra1.check(tipo);
    }

    @Test
    public void toStringEscultura() {
        String expected = "ID: 2, Nombre: qwe, Autor: Pablo, Precio: 4.0, Altura: 1.0, Peso: 3.0E-5, Piezas: 7, Descripción: descripcion, Tipo: pictorica, Técnica: oleo";
        assertEquals(expected, obra1.toString());
    }

    
}
