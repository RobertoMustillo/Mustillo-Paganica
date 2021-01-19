package it.mustillopaganica.weather;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//import it.mustillopaganica.weather.utilities.Archivio;
/*
 * Main
 */
@SpringBootApplication
@EnableScheduling
public class WeatherApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(WeatherApplication.class, args);
//		Archivio.popola();
//	    Archivio.download();
	}

}
