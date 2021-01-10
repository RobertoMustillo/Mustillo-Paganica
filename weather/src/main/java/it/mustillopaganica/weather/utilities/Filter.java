/**
 * 
 */
package it.mustillopaganica.weather.utilities;

import org.json.simple.JSONObject;

import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.service.MeteoParser;

/**
 * @author rbtms
 *
 */
public class Filter {
	private String citta;
	private String units;
	private String from;
	private String to;
	protected JSONObject filter;
/*
 * @param filter filtro di ricerca ricevuto nelle API
 */
	public Filter(String citta, String units, String from, String to, JSONObject filter) {
	super();
	this.citta = citta;
	this.units = units;
	this.from = from;
	this.to = to;
	this.filter = filter;
}

	/*
	 * filtra il periodo richiesto in una possibile BodyRequest
	 */
	public boolean periodoPresente(MeteoParser m,String from,String to) throws MeteoException{

		from = (String) this.filter.get("from");
		to = (String) this.filter.get("to");
		
		boolean trovato = false ;
		for ( Data a : m.getArr() )
		if (a.getEpoch().equals(from )) { 
			trovato = true ;
			if(a.getEpoch().equals(to)) {
				trovato = true;
				break;
			}
		}
		if(!trovato) throw new MeteoException("date non trovate");
		return trovato ;	
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
