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
	
/**
 * @param filter filtro di ricerca ricevuto nelle API
 * @param citta  nome della città
 * @param units  sistema di misura
 * @param from	 data da cui iniziare il filtro
 * @param to	 data da cui terminare il filtro
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
    /**
     * 
     * @return from
     */
	public String getFrom() {
		return from;
	}
	/**
	 * 
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * 
	 * @return to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * 
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
    /**
     * 
     * @return units
     */
	public String getUnits() {
		return units;
	}
    /**
     * 
     * @param units
     */
	public void setUnits(String units) {
		this.units = units;
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
	
}
