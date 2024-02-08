package es.iesSoteroHernandez.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import es.iesSoteroHernandez.daw.endes.Persona.ejerciciosUnitarias.Persona;

/**
 * Unit test for simple App.
 */
public class PersonaTest {
	/**
	 * Rigorous Test :-)
	 */
	private static Persona persona;

	@BeforeAll
	public static void init() {
		persona = new Persona();
	}

	@AfterAll
	public static void finish() {
		persona = null;
	}

	@Test
	public void testCalcularIMCPesoIdeal() {
		Persona persona = new Persona("Ale", 22, 'H', 90, 1.90);
		assertEquals(0, persona.calcularIMC());
	}

	@Test
	public void testCalcularIMCBajoPeso() {
		Persona persona = new Persona("Juan", 35, 'M', 45, 1.60);
		assertEquals(Persona.INFRAPESO, persona.calcularIMC());
	}

	@Test
	public void testCalcularIMCSobrePeso() {
		Persona persona = new Persona("Manu", 50, 'H', 90, 1.75);
		assertEquals(Persona.SOBREPESO, persona.calcularIMC());
	}

	@Test
	public void testEsMayorDeEdadMenorDeEdad() {
		Persona persona = new Persona("Javi", 15, 'M', 50, 1.65);
		assertFalse(persona.esMayorDeEdad());
	}

	@Test
	public void testEsMayorDeEdadMayorDeEdad() {
		Persona persona = new Persona("Luis", 25, 'H', 70, 1.70);
		assertTrue(persona.esMayorDeEdad());
	}
}
