package es.iesSoteroHernandez.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import es.iesSoteroHernandez.daw.endes.Persona.ejerciciosUnitarias.Persona;

/**
 * Unit test for simple App.
 */
public class PersonaTest {

	private Persona persona;

	@AfterEach
	public void finish() {
		persona = null;
	}

	@Test
	public void testCalcularIMCPesoIdeal() {
		persona = new Persona("Ale", 22, 'H', 90, 1.90);
		assertEquals(0, persona.calcularIMC());
	}

	@Test
	public void testCalcularIMCBajoPeso() {
		persona = new Persona("Juan", 35, 'M', 45, 1.60);
		assertEquals(Persona.INFRAPESO, persona.calcularIMC());
	}

	@Test
	public void testCalcularIMCSobrePeso() {
		persona = new Persona("Manu", 50, 'H', 90, 1.75);
		assertEquals(Persona.SOBREPESO, persona.calcularIMC());
	}

	@Test
	public void testEsMayorDeEdadMenorDeEdad() {
		persona = new Persona("Javi", 15, 'M', 50, 1.65);
		assertFalse(persona.esMayorDeEdad());
	}

	@Test
	public void testEsMayorDeEdadMayorDeEdad() {
		persona = new Persona("Luis", 25, 'H', 70, 1.70);
		assertTrue(persona.esMayorDeEdad());
	}

	@Test
	public void testToString() {
		persona = new Persona("Juan", 30, 'H', 80, 1.75);
		
		String patron = "\\d{8}[A-Z]"; 
		String dni = persona.toString()                      // Convertimos persona a una cadena de caracteres
										.split("DNI: ")[1]   // Usamos el separador "DNI: " para dividir en dos en funcion de este y sacamos la segunda parte de la separacion 
										.split("\n")[0];     // Volvemos a dividir por el separador "/n" y sacamos el primer elemento de la separacion
		assertTrue(dni.matches(patron));
		String expected = "Informacion de la persona:\n" + 
									"Nombre: Juan\n" + 
									"Sexo: hombre\n" + 
									"Edad: 30 años\n"+ 
									"DNI: " + dni + "\n" + // Usar el DNI extraido en lugar de un valor fijo
									"Peso: 80.0 kg\n" + 
									"Altura: 1.75 metros\n";
		assertEquals(expected, persona.toString());
	}

}
