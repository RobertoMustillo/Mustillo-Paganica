/**
 * 
 */
package it.mustillopaganica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.mustillopaganica.model.MeteoClass;
import it.mustillopaganica.service.MeteoService;
import it.mustillopaganica.service.MeteoServiceImpl;
import it.mustillopaganica.utility.MeteoParser;
/**
 * @author rbtms
 *
 */
@RestController
public class MeteoController {
	

	@Autowired
	MeteoService meteoService;
	
	@RequestMapping(value="/stats",method = RequestMethod.GET)
	public ResponseEntity<Object> getMeteoData(){
		return new ResponseEntity<>(meteoService.getMeteoData(), HttpStatus.OK);
	}
	
	
/*	@GetMapping(value="/metadata")
	public MeteoClass data() {
		return new MeteoClass("Termoli", "2020-12-18", 4.2, 3.3, 20.0, 11.0, 10.9, 7.0, 5.7);
	}
	@GetMapping("/prova")
	public ResponseEntity<Object>String prova(){
		return "CIAOO";
	}*/

/*	@PostMapping("/data")
	public MeteoClass data2(@RequestBody MeteoClass body){
		return body;
	}
	*/
	@GetMapping("/ciao")
	public String prova() {
		return "ciaooo";
	}
	
}
