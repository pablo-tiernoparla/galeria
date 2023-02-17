package daw.programacion.galeria;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import daw.programacion.obras.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {

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
    void idYaExisteExcepcion(){
        final Obra[] OBRAS = {obra1, obra2};
        final int ID = 1;
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Menu.idYaExiste(ID, OBRAS);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void positiveNumExcepcion(final int ID){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Menu.positiveNum(ID);
                });
    }

    @Test
    void checkStringExcepcion(){
        final String VACIO = "";
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkString(VACIO);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,7})
    void checkInputsExcepcion(final int NUM){
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkInputs(NUM);
        });
    }

    @Test
    void checkTipoExcepcion(){
        final String ERROR = "abc";
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkTipo(ERROR);
        });
    }

    @Test
    void findIdFunciona(){
        Obra[] todo = {obra1, obra2};
        int expected = 1;
        assertEquals(expected, Menu.findId(obra2.getId(), todo));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void cambiarActividadEntraSinCambiarArray(final int NUM){
        Obra[] todo = {obra1, obra2};
        Menu.cambiarActividad(NUM, todo);
    }

    @Test
    void cambiarActividadAñadeLongitud(){
        Obra[] todo = {obra1, obra2};
        int expected = todo.length+1;
        assertEquals(expected, Menu.cambiarActividad(2, todo).length);
    }

    @Test
    void cambiaRActividadAcabaElBucle(){
        Obra[] todo = {obra1,obra2};
        int expected = 0;
        assertEquals(expected, Menu.cambiarActividad(0, todo).length);
    }

    @Test
    public void positiveNumFunciona(){
        double num = 2;
        Menu.positiveNum(num);
    }

    @Test
    public void checkInputsFunciona(){
        int num = 2;
        Menu.checkInputs(num);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pictorica","escultura"})
    public void checkTipoFunciona(String tipo){
        Menu.checkTipo(tipo);
    }

    @Test
    public void checkStringFunciona(){
        String abc = "abc";
        Menu.checkString(abc);
    }
}
