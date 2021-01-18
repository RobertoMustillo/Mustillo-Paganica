/**
 * 
 */
package it.mustillopaganica.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.mustillopaganica.weather.utilities.Statistiche;

/**
 * @author rbtms
 *
 */
class StatsTest {
	
	private Statistiche statistiche = new Statistiche();
		
	@BeforeEach
	void setUp() {
		statistiche.setPath("JSONConfig.txt");
		statistiche.setPath2("correnti.txt");

	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	@DisplayName("Verifica che i path siano corretti")
	void archivi() {
	
		assertEquals("JSONConfig.txt", statistiche.getPath());
		assertEquals("correnti.txt", statistiche.getPath2());
	}
	
	@Test
	void fileNotFound() {
	NullPointerException exception = assertThrows(NullPointerException.class, () -> {
        statistiche.validate("meteo.txt");
    });
	assertEquals("path non presente", exception.getMessage());

	}
	
	@Test
	@DisplayName("Test sullo studio della differenza tra una temperatura ed un'altra")
	void contTest() {
		Vector<Double> eps;

		eps = statistiche.correnti();
		assertNotNull(eps);
				
	}
	
}
