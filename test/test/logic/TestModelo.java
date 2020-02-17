package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendo;
import model.data_structures.ICola;
import model.data_structures.IPila;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";

	@Before
	public void setUp1() {

		modelo = new Modelo();

	}

	public void setUp2() {

		Comparendo comp = new Comparendo();
		comp.INFRACCION = "Prueba Infraccion";
		for(int i = 0; i<20; i++){
			modelo.darArreglo().agregar(comp);
		}


	}

	public void setUp3() {

		Comparendo comp = new Comparendo();
		comp.CLASE_VEHI = "Carro prueba";
		modelo.darArreglo().agregar(comp);
		Comparendo comp2 = new Comparendo();
		comp2.CLASE_VEHI = "Carro prueba 2";
		modelo.darArreglo().agregar(comp2);
	}



	@Test
	public void testAgregar(){

		setUp1();
		setUp2();
		assertEquals(20, modelo.darArreglo().darTamano());
		assertEquals("Prueba Infraccion", modelo.darArreglo().darElemento(15).INFRACCION);

	}

	@Test
	public void testDatosDatosGuardadosCorrectamente() {

		setUp1();
		setUp3();
		assertEquals("Carro prueba", modelo.darArreglo().darElemento(0).CLASE_VEHI);
		assertEquals("Carro prueba 2", modelo.darArreglo().darElemento(1).CLASE_VEHI);


	}
	@Test
	public void testCargar(){

		setUp1();
		modelo.cargar(PATH);
		assertEquals(20, modelo.darArreglo().darTamano());
		assertEquals(29042, modelo.darArreglo().darElemento(0).OBJECTID);
	}

}
