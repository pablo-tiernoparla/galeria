package daw.programacion.obras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EsculturaTest {

    Escultura obra1;

    @BeforeEach
    void crearObjetoObra() {
        obra1 = new Escultura(1, "Abc", "Raul", 2.1, 2.2, 2.3, 4, "esto es la descripcion", "hierro");
    }

    @AfterEach
    void borrarObjetoObra() {
        obra1 = null;
    }

    @Test
    public void getMaterialFunciona() {
        String expected = "hierro";
        assertEquals(expected, obra1.getMaterial());
    }

    @Test
    public void setMaterialFunciona() {
        String expected = "cobre";
        obra1.setMaterial("cobre");
        assertEquals(expected, obra1.getMaterial());
    }

    @Test
    public void checkExcepcionEscultura() {
        String error = "abc";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    obra1.check(error);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = { "hierro", "cobre", "bronce", "acero" })
    public void checkEsculturaValoresCorrectos(String tipo) {
        obra1.check(tipo);
    }

    @Test
    public void toStringEscultura() {
        String expected = "ID: 1, Nombre: Abc, Autor: Raul, Precio: 2.1, Altura: 2.2, Peso: 2.3, Piezas: 4, Descripción: esto es la descripcion, Tipo: escultura, Material: hierro";
        assertEquals(expected, obra1.toString());
    }

    @Test
    public void descuentoFunciona(){
        double expected = 50.42;
        assertEquals(expected, obra1.descuento());
    }
 
    @Test
    public void modificarEspecialidadFuncionaEscultura(){
        String expected = "bronce";
        obra1 = obra1.modificarEspecialidad("bronce");
        assertEquals(expected, obra1.getMaterial());
    }

    @Test
    public void cambiarTipoFunciona(){
        String expected = "pictorica";
        Obra obra3;
        obra3 = obra1.cambiarTipo("oleo");
        assertEquals(expected, obra3.getTipo());
    }
}
