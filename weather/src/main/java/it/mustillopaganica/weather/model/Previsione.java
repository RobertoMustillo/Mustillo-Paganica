/**
 * 
 */
package it.mustillopaganica.weather.model;

import java.util.Vector;

/**
 * @author rbtms
 *
 */
public class Previsione {
	
	private Integer id=0;

	private Vector<Double> eps;

	private String message;
	
	private String citta;
	
	/**
     * 
     * @return eps
     */
	public Vector<Double> getEps() {
		return eps;
	}
	/**
     * 
     * @param eps
     */
	public void setEps(Vector<Double> eps) {
		this.eps = eps;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}

}
