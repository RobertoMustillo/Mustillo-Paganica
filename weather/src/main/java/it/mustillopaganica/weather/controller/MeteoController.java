package it.mustillopaganica.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.Previsione;
import it.mustillopaganica.weather.model.Stats;
import it.mustillopaganica.weather.utilities.MeteoServiceImpl;
import it.mustillopaganica.weather.utilities.Filter;

/**
 * Controller
 * @author rbtms
 */
@RestController
public class MeteoController {
	@Autowired
	MeteoServiceImpl meteoService;

	/*
	 * Ritorna il meteo di tutte le citta presenti nell'archivio
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	   public ResponseEntity<Object> getMetadata() {
		meteoService.getArchivio();
	      return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
	  }
      /**
       * 
       * @param citta
       * @param units
       */
	//ritorna la citta e l'unità di misura indicata nel path "/data/{--x--}/{--y--}"
		@RequestMapping(value = "/data/{citta}/{units}", method = RequestMethod.GET)
		   public ResponseEntity<Object> getDataCittaUnits(@PathVariable String citta,@PathVariable String units) {
			meteoService.getDataCittaUnits(citta,units);
		      return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
		  }
        /**
         * 
         * @param citta
         * @param units
         */
		//filtro della citta e dell'unità di misura indicato nei PARAMETRI della GET
		@GetMapping("/data")
		public ResponseEntity<Object> getDataCittaUnits2(@RequestParam(name = "citta", defaultValue = "") String citta,
									@RequestParam(name = "units", defaultValue = "kelvin") String units){
			meteoService.getDataCittaUnits(citta,units);
			return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
			
		}
		/**
		 * 
		 * @param citta
		 */
		//filtro per le statistiche
		@GetMapping("/tempo")
		public ResponseEntity<Object> getCondizioniMeteo(@RequestParam(name = "citta", defaultValue = "") String citta){
			meteoService.getStatsCitta(citta);
			return new ResponseEntity<>(meteoService.getDataStats(), HttpStatus.OK);
		}
    /**
     * 
     * @param meteo
     */
	//ritorna una citta richiesta nel body
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Object> createMeteo(@RequestBody Data meteo) {
		meteoService.createMeteo(meteo);
		return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);

	}
	/**
	 * 
	 * @param filter
	 * @throws MeteoException
	 */
	//Filtro di una data richiesta dall utente
		@RequestMapping(value = "/filter", method = RequestMethod.POST)
		public ResponseEntity<Object> Filter(@RequestBody Filter filter) throws MeteoException {
			meteoService.getFilter(filter);
			return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);

		}
		
		/*
		 * STATS max, min, media e varianza
		 * di temperature reali e percepite 
		 */
		/**
		 * 
		 * @param body
		 * @throws MeteoException
		 */
		@RequestMapping(value = "/stats", method = RequestMethod.POST)
		public Stats STATS(@RequestBody Stats body) throws MeteoException {

			switch (body.getCitta()) {
			case "Termoli":
				body.setId(0);
				break;
			case "Ancona":
				body.setId(1);
				break;
			case "Milano":
				body.setId(2);
				break;
			case "Bergamo":
				body.setId(3);
				break;
			case "Napoli":
				body.setId(4);
				break;
			case "Benevento":
				body.setId(5);
				break;
			case "Torino":
				body.setId(6);
				break;		
			}
		
			

			return meteoService.getStats(body);
		}
		
		//STATS azzeccate
		/**
		 * 
		 * @param body
		 * @throws MeteoException
		 */
		@RequestMapping(value = "/previsioni", method = RequestMethod.POST)
		public Previsione PREVISIONI(@RequestBody Previsione body) throws MeteoException {

			switch (body.getCitta()) {
					case "Termoli":
						body.setId(0);
						break;
					case "Ancona":
						body.setId(1);
						break;
					case "Milano":
						body.setId(2);
						break;
					case "Bergamo":
						body.setId(3);
						break;
					case "Napoli":
						body.setId(4);
						break;
					case "Benevento":
						body.setId(5);
						break;
					case "Torino":
						body.setId(6);
						break;		
					}
				

					return meteoService.statsPrevisione(body);
				}
}
