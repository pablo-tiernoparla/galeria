package daw.programacion.obras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ObraTest {

    Obra obra1;
    Pictorica obra2;

    @BeforeEach
    void crearObjetoObra() {
        obra1 = new Escultura(1, "Abc", "Raul", 2.1, 2.2, 2.3, 4, "esto es la descripcion", "hierro");
        obra2 = new Pictorica(2, "qwe", "Pablo", 4, 5, 6, 7, "descripcion", "oleo");
    }

    @AfterEach
    void borrarObjetoObra() {
        obra1 = null;
        obra2 = null;
    }

    @Test
    void getIdFunciona() {
        int expected = 1;
        assertEquals(expected, obra1.getId());
    }

    @Test
    void setIdFunciona() {
        final int DOS = 2;
        int expected = DOS;
        obra1.setId(DOS);
        assertEquals(expected, obra1.getId());
    }

    @Test
    void setIdCheckFunciona(){
        final int DOS = 2;
        int expected = DOS;
        obra1.setId(DOS);
        assertEquals(expected, obra1.getId());
    }

    @Test
    void getAutorFunciona() {
        String expected = "Raul";
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void setAutorFunciona() {
        final String AUTOR_NUEVO = "Pablo";
        String expected = AUTOR_NUEVO;
        obra1.setAutor(AUTOR_NUEVO);
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void getNombreFunciona() {
        String expected = "Abc";
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void setNombreFunciona() {
        final String NOMBRE_NUEVO = "Qwe";
        String expected = NOMBRE_NUEVO;
        obra1.setNombre(NOMBRE_NUEVO);
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void getPrecioFunciona() {
        double expected = 2.1;
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void setPrecioFunciona() {
        final double PRECIO_NUEVO = 4.3;
        double expected = PRECIO_NUEVO;
        obra1.setPrecio(PRECIO_NUEVO);
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void getAlturaFunciona() {
        double expected = 2.2;
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void setAlturaFunciona() {
        final double ALTURA_NUEVA = 6.5;
        double expected = ALTURA_NUEVA;
        obra1.setAltura(ALTURA_NUEVA);
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void getPesoFunciona() {
        double expected = 2.3;
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void setPesoFunciona() {
        final double PESO_NUEVO = 7.4;
        double expected = PESO_NUEVO;
        obra1.setPeso(PESO_NUEVO);
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void getPiezasFunciona() {
        int expected = 4;
        assertEquals(expected, obra1.getPiezas());
    }

    @Test
    void setPiezasFunciona() {
        final int PIEZAS_NUEVO = 8;
        int expected = PIEZAS_NUEVO;
        obra1.setPiezas(PIEZAS_NUEVO);
        assertEquals(expected, obra1.getPiezas());
    }

    @Test
    void getDescFunciona() {
        String expected = "esto es la descripcion";
        assertEquals(expected, obra1.getDesc());
    }

    @Test
    void setDescFunciona() {
        final String DESC_NUEVA = "nueva descripcion";
        String expected = DESC_NUEVA;
        obra1.setDesc(DESC_NUEVA);
        assertEquals(expected, obra1.getDesc());
    }

    @Test
    void getTipoFunciona(){
        String expected = "pictorica";
        assertEquals(expected, obra2.getTipo());
    }

    @Test
    void cambiarTipoFunciona(){
        String expected = null;
        assertEquals(expected, obra1.cambiarTipo());
    }

    @Test
    void copyFunciona(){
        Obra obraCopy = new Escultura(0, null, null, 0, 0, 0, 0, null, null);
        obraCopy.copy(obra1);
        assertTrue(obra1.getId() == (obraCopy.getId()));
    }

    @Test
    void modificarEspecialidadFunciona(){
        String expected = null;
        assertEquals(expected, obra1.modificarEspecialidad(null));
    }
}
