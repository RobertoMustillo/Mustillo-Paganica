/**
 * 
 */
package it.mustillopaganica.service;

import java.util.Collection;	
import java.util.Map;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public interface MeteoService {
	//public abstract void createMeteo(MeteoClass meteo);
	//public abstract Map<Integer,MeteoClass> getMeteoData();
	public abstract Collection<MeteoClass> getMeteoData();

	//metodo che crea il post in base al tipo di unità scelta
	public abstract void misurazione();
}
