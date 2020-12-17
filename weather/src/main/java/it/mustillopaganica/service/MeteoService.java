/**
 * 
 */
package it.mustillopaganica.service;

import java.util.Collection;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public interface MeteoService {
	public abstract void createMeteo(MeteoClass meteo);
	public abstract Collection<MeteoClass> getMeteo();
}
