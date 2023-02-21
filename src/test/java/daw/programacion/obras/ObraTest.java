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
        obra1 = new Escultura(1, "Abc", "Raul", 2.1, 2.2, 2.3, 1, "esto es la descripcion", "hierro");
        obra2 = new Pictorica(2, "qwe", "Pablo", 4, 1, 0.00003, 7, "descripcion", "oleo");
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
        int dos = 2;
        int expected = dos;
        obra1.setId(dos);
        assertEquals(expected, obra1.getId());
    }

    @Test
    void getAutorFunciona() {
        String expected = "Raul";
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void setAutorFunciona() {
        String autorNuevo = "Pablo";
        String expected = autorNuevo;
        obra1.setAutor(autorNuevo);
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void getNombreFunciona() {
        String expected = "Abc";
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void setNombreFunciona() {
        String nombreNuevo = "Qwe";
        String expected = nombreNuevo;
        obra1.setNombre(nombreNuevo);
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void getPrecioFunciona() {
        double expected = 2.1;
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void setPrecioFunciona() {
        double precioNuevo = 4.3;
        double expected = precioNuevo;
        obra1.setPrecio(precioNuevo);
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void getAlturaFunciona() {
        double expected = 2.2;
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void setAlturaFunciona() {
        double alturaNueva = 6.5;
        double expected = alturaNueva;
        obra1.setAltura(alturaNueva);
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void getPesoFunciona() {
        double expected = 2.3;
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void setPesoFunciona() {
        double pesoNuevo = 7.4;
        double expected = pesoNuevo;
        obra1.setPeso(pesoNuevo);
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void getPiezasFunciona() {
        int expected = 1;
        assertEquals(expected, obra1.getPiezas());
    }

    @Test
    void setPiezasFunciona() {
        int piezasNuevo = 8;
        int expected = piezasNuevo;
        obra1.setPiezas(piezasNuevo);
        assertEquals(expected, obra1.getPiezas());
    }

    @Test
    void getDescFunciona() {
        String expected = "esto es la descripcion";
        assertEquals(expected, obra1.getDesc());
    }

    @Test
    void setDescFunciona() {
        String descNueva = "nueva descripcion";
        String expected = descNueva;
        obra1.setDesc(descNueva);
        assertEquals(expected, obra1.getDesc());
    }

    @Test
    void getTipoFunciona(){
        String expected = "pictorica";
        assertEquals(expected, obra2.getTipo());
    }

    @Test
    void cargarObrasFunciona(){
        Pictorica guernica = new Pictorica(1, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
        Pictorica vie = new Pictorica(2, "La Vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
        Pictorica sueño = new Pictorica(3, "El Sueño", "P.Picasso", 300, 1.3, 1, 1, "óleo", "Óleo");
        Pictorica retrato = new Pictorica(4, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo", "Óleo");
        Escultura pielRoja = new Escultura(5, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "Bronce");
        Obra[] exposicion = { guernica, vie, sueño, retrato, pielRoja };
        int expected = exposicion.length;
        assertEquals(expected, Obra.cargarObras().length);
    }

    @Test
    void aumentarColeccionFunciona(){
        Obra[] base = new Obra[6];
        assertEquals(base.length+1, obra1.aumentarColeccion(base).length);
    }

    @Test
    void toDolarFunciona(){
        double num = 1;
        double expected = 0.99;
        assertEquals(expected, obra1.toDolar(num));
    }

    @Test
    void toKiloFunciona(){
        int expected = 1000;
        assertEquals(expected, obra1.toKilo(1));
    }

    @Test
    public void darDeAltaEntraEnPictorica(){
        Obra[] todo = {obra1,obra2};
        String valor = "oleo";
        obra1.darDeAltaUnaObra(todo, valor);
    }

    @Test
    public void darDeAltaEntraEnEscultura(){
        Obra[] todo = {obra1,obra2};
        String valor = "cobre";
        obra1.darDeAltaUnaObra(todo, valor);
    }

    @Test
    public void arrayNoAumentaSiFallaDarDeAlta(){
        Obra[] todo = {obra1, obra2};
        int expected = todo.length;
        assertEquals(expected, obra1.darDeAltaUnaObra(todo, "osd").length);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10})
    void modificarObraEntraEnTodo(int num){
        Obra[] todo = {obra1,obra2, null};
        Escultura obra3 = new Escultura(3, "cobre", "ab", 4, 4, 4, 4, "ad", "cobre");
        int pos = 2;
        obra1.modificarObra(todo, num, obra3, pos);
    }

    @Test
    public void precioPorPesoPorEncimaDelLimite(){
        double expected = 100;
        assertEquals(expected, obra1.precioPorPeso());
    }

    @Test
    public void precioPorPesoPorDebajoDelLimite(){
        double expected = 20;
        assertEquals(expected, obra2.precioPorPeso());
    }

    @Test
    public void precioPorAlturaPorEncimaDelLimite(){
        double expected = 100;
        assertEquals(expected, obra1.precioPorAltura());
    }

    @Test
    public void precioPorAlturaPorDebajoDelLimite(){
        double expected = 140;
        assertEquals(expected, obra2.precioPorAltura());
    }

    @Test
    public void precioPorPiezasPorEncimaDelLimite(){
        double expected = 50;
        assertEquals(expected, obra2.precioPorPiezas());
    }

    @Test
    public void precioPorPiezasPorDebajoDelLimite(){
        double expected = 0;
        assertEquals(expected, obra1.precioPorPiezas());
    }

    @Test
    public void precioFinalSinDescuento(){
        double expected = 215;
        assertEquals(expected, obra2.precioFinalSinDescuento());
    }

    @Test
    public void precioFinalFunciona(){
        double expected = 215.4;
        assertEquals(expected, obra2.precioFinal());
    }

    @Test
    public void visualizarObrasConNull(){
        Obra[] obras = {obra1, null, obra2};
        Obra.visualizarObras(obras);
    }
}
