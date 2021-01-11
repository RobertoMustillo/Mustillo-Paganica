/**
 * 
 */
package it.mustillopaganica.weather.utilities;

/**
 * Classe che implementa un tipo di Filtro possibile
 *@author rbtms
 *
 */
public class Filter {
	private String citta;
	private String units;
	private String from;
	private String to;
	
/*
 * @param filter filtro di ricerca ricevuto nelle API
 */
	public Filter(String citta, String units, String from, String to) {
	super();
	this.citta = citta;
	this.units = units;
	this.from = from;
	this.to = to;
	}

	public Filter() {
		
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
}
