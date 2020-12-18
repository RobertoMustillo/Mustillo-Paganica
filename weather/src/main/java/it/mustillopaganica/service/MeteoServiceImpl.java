/**
 * 
 */
package it.mustillopaganica.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.mustillopaganica.model.MeteoClass;

/**
 @author rbtms
 *
 */
@Service
public class MeteoServiceImpl implements MeteoService{
	
	//public Map<Integer, MeteoClass> meteo = new HashMap<>();
	private static Map<Integer, MeteoClass> meteoRepo = new HashMap<>();

/*	@Override
	public Map<Integer, MeteoClass> getMeteoData() {
		meteoRepo.put(1,new MeteoClass("termoli", "18122020", 12, 10, 8, 19, 89));

		return meteoRepo;
	}
*/
	@Override
	public Collection<MeteoClass> getMeteoData() {
		return meteoRepo.values();
	}
	
	@Override
	public void misurazione() {
		
	}
 
}
