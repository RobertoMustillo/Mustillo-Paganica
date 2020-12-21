package it.mustillopaganica.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.utilities.MeteoService;

@RestController
public class MeteoController {
	@Autowired
	MeteoService meteoRepo;

	//ritorna una citta di default
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	   public ResponseEntity<Object> getData() {
	      return new ResponseEntity<>(meteoRepo.getData(), HttpStatus.OK);
	  }

	//ritorna una citta richiesta nel body
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<Object> createMeteo(@RequestBody Data meteo) {
		meteoRepo.createMeteo(meteo);
		return new ResponseEntity<>(meteoRepo.getData(), HttpStatus.OK);
	}
}
