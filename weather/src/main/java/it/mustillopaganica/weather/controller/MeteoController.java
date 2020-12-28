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

import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.utilities.MeteoService;

/**
 * @author rbtms
 */
@RestController
public class MeteoController {
	@Autowired
	MeteoService meteoService;

	//ritorna una citta di default e tutte le citta inserite dopo l'avvio
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	   public ResponseEntity<Object> getData() {
	      return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
	  }

	//ritorna la citta e l'unità di misura indicata nel path "/data/{--x--}/{--y--}"
		@RequestMapping(value = "/data/{citta}/{units}", method = RequestMethod.GET)
		   public ResponseEntity<Object> getDataCittaUnits(@PathVariable String citta,@PathVariable String units) {
			meteoService.getDataCittaUnits(citta,units);
		      return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
		  }

		//filtro della citta e dell'unità di misura indicato nei PARAMETRI della GET
		@GetMapping("/data")
		public ResponseEntity<Object> getDataCittaUnits2(@RequestParam(name = "q", defaultValue = "") String q,
									@RequestParam(name = "units", defaultValue = "kelvin") String units){
			meteoService.getDataCittaUnits(q,units);
			return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
			
		}
		
		//filtro per le statistiche
		@GetMapping("/stats")
		public ResponseEntity<Object> getStats(@RequestParam(name = "citta", defaultValue = "") String citta){
			meteoService.getStatsCitta(citta);
			return new ResponseEntity<>(meteoService.getDataStats(), HttpStatus.OK);
		}
		
	//ritorna una citta richiesta nel body
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Object> createMeteo(@RequestBody Data meteo) {
		meteoService.createMeteo(meteo);
		return new ResponseEntity<>(meteoService.getData(), HttpStatus.OK);
	}
}
