package daw.programacion.galeria;

import static org.junit.jupiter.api.Assertions.*;

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
        Obra[] obras = {obra1, obra2};
        int id = 1;
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Menu.idYaExiste(id, obras);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void positiveNumExcepcion(int id){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Menu.positiveNum(id);
                });
    }

    @Test
    void checkStringExcepcion(){
        String vacio = "";
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkString(vacio);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,7})
    void checkInputsExcepcion(int num){
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkInputs(num);
        });
    }

    @Test
    void checkTipoExcepcion(){
        String error = "abc";
        assertThrows(IllegalArgumentException.class,
        () -> {
            Menu.checkTipo(error);
        });
    }

    @Test
    void findIdFunciona(){
        Obra[] todo = {obra1, obra2};
        int expected = 1;
        assertEquals(expected, Menu.findId(obra2.getId(), todo));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void cambiarActividadEntraSinCambiarArray(int num){
        Obra[] todo = {obra1, obra2};
        Menu.cambiarActividad(num, todo);
    }

    @Test
    void cambiarActividadAcabaElBucle(){
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
