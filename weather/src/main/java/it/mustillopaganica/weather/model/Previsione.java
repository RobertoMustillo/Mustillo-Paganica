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

	private Integer corrette;

	private Double soglia;

	private static Integer studiate=0;

	private static Integer campione=1;

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
     * @param eps (Epsilon) Indica l'errore nel calcolo della temperatura previsionale.
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
	public Integer getCampione() {
		return campione;
	}
	public static void setCampione(Integer Campione) {
		campione = Campione;
	}
	public Integer getStudiate() {
		return studiate;
	}
	public static void setStudiate(Integer Studiate) {
		studiate = Studiate;
	}
	public Double getSoglia() {
		return soglia;
	}
	public void setSoglia(Double soglia) {
		this.soglia = soglia;
	}
	public Integer getCorrette() {
		return corrette;
	}
	public void setCorrette(Integer corrette) {
		this.corrette = corrette;
	}

}
