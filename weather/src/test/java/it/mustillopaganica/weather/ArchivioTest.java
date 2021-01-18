/**
 * 
 */
package it.mustillopaganica.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.mustillopaganica.weather.utilities.Archivio;

/**
 * @author rbtms
 *
 */
public class ArchivioTest {
	
	
	@BeforeEach
	void setUp() {

		Archivio.setPath("citta.txt");
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	@DisplayName("Verifica che il path sia corretto")
	void test() {
		assertEquals("citta.txt", Archivio.getPath());

	}
}
