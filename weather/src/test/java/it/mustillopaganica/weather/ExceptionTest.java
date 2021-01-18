/**
 * 
 */
package it.mustillopaganica.weather;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.utilities.Filter;
import it.mustillopaganica.weather.utilities.MeteoServiceImpl;
import it.mustillopaganica.weather.utilities.Statistiche;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author rbtms
 *
 */
public class ExceptionTest {
	
	MeteoServiceImpl meteoService = new MeteoServiceImpl();
	Filter filter = new Filter();
	Statistiche statistiche = new Statistiche();

	@BeforeEach
	void setUp() throws Exception{
		filter.setCitta("Milano");
		filter.setFrom("2021-01-11 18:00:00");
		filter.setTo("2021-01-11 18:00:00");
		filter.setUnits("metric");
	}

	@AfterEach
	void tearDown() throws Exception {}
	
	@Test
	@DisplayName("Test eccezioni")
	void exceptionTest() {
		MeteoException e;
		e=assertThrows(
				MeteoException.class,
				()->{statistiche.getTempMax();}
				);
		assertTrue(e.getMessage().contains("Assenza di campioni"));

		e=assertThrows(
				MeteoException.class,
				()->{statistiche.getMedia();}
				);
		assertTrue(e.getMessage().contains("Assenza di campioni"));
		
		e=assertThrows(
				MeteoException.class,
				()->{statistiche.getVarianza();}
				);
		assertTrue(e.getMessage().contains("Assenza di campioni"));
		
		e=assertThrows(
				MeteoException.class,
				()->{meteoService.getFilter(filter);}
				);
		assertTrue(e.getMessage().contains("data non presente"));
	}
}
