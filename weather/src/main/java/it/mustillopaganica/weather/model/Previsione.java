/**
 * 
 */
package it.mustillopaganica.weather.model;

import java.util.Vector;

/**
 * Classe di output
 * @author rbtms
 * @author aldop
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
	/**
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return citta
	 */
	public String getCitta() {
		return citta;
	}
	/**
	 * 
	 * @param citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	/**
	 * 
	 * @return campione
	 */
	public Integer getCampione() {
		return campione;
	}
	/**
	 * 
	 * @param Campione
	 */
	public static void setCampione(Integer Campione) {
		campione = Campione;
	}
	/**
	 * 
	 * @return studiate
	 */
	public Integer getStudiate() {
		return studiate;
	}
	/**
	 * 
	 * @param Studiate
	 */
	public static void setStudiate(Integer Studiate) {
		studiate = Studiate;
	}
	/**
	 * 
	 * @return soglia
	 */
	public Double getSoglia() {
		return soglia;
	}
	/**
	 * 
	 * @param soglia
	 */
	public void setSoglia(Double soglia) {
		this.soglia = soglia;
	}
	/**
	 * 
	 * @return corrette
	 */
	public Integer getCorrette() {
		return corrette;
	}
	/**
	 * 
	 * @param corrette
	 */
	public void setCorrette(Integer corrette) {
		this.corrette = corrette;
	}

}
