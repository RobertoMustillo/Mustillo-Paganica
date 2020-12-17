/**
 * 
 */
package it.mustillopaganica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
@RestController
public class MeteoRestController {

/*	@Autowired
	MeteoClass productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productService.get(), HttpStatus.OK);
	}
	*/
	@GetMapping(value="/data")
	public MeteoClass data() {
		return new MeteoClass("Termoli", 246982, 4.2, 3.3, 20.0, 5, 11.0, 10.9, 7.0, 5.7);
	}
	@GetMapping("/prova")
	public String prova(){
		return "CIAOO";
	}

	@PostMapping("/data")
	public MeteoClass data2(@RequestBody MeteoClass body){
		return body;
	}
	
	
}
