/**
 * 
 */
package it.mustillopaganica.weather.model;

/**
 * Classe di output
 * @author rbtms
 * @author aldop
 */
public class Stats {
	private Integer id=0;

	private double TempMax=0.0;

	private double TempMin=0.0;

	private double TempPercMax=0.0;

	private double TempPercMin=0.0;
	
	private double media;
	
	private double mediaPercepita;

	private double varianza;

	private double varianzaPercepita;
	
	private String citta;
	
	private String message;

	/**
	 * 
	 * @return TempMax
	 */
	public double getTempMax() {
		return TempMax;
	}
    /**
     * 
     * @param tempMax
     */
	public void setTempMax(double tempMax) {
		TempMax = tempMax;
	}
    /**
     * 
     * @return TempMin
     */
	public double getTempMin() {
		return TempMin;
	}
    /**
     * 
     * @param tempMin
     */
	public void setTempMin(double tempMin) {
		TempMin = tempMin;
	}
    /**
     * 
     * @return TempPercMax
     */
	public double getTempPercMax() {
		return TempPercMax;
	}
    /**
     * 
     * @param tempPercMax
     */
	public void setTempPercMax(double tempPercMax) {
		TempPercMax = tempPercMax;
	}
    /**
     * 
     * @return TempPercMin
     */
	public double getTempPercMin() {
		return TempPercMin;
	}
    /**
     * 
     * @param tempPercMin
     */
	public void setTempPercMin(double tempPercMin) {
		TempPercMin = tempPercMin;
	}
    /**
     * 
     * @return media
     */
	public double getMedia() {
		return media;
	}
    /**
     * 
     * @param media
     */
	public void setMedia(double media) {
		this.media = media;
	}
    /**
     * 
     * @return mediaPercepita
     */
	public double getMediaPercepita() {
		return mediaPercepita;
	}
    /**
     * 
     * @param mediaPercepita
     */
	public void setMediaPercepita(double mediaPercepita) {
		this.mediaPercepita = mediaPercepita;
	}
    /**
     * 
     * @return varianza
     */
	public double getVarianza() {
		return varianza;
	}
    /**
     * 
     * @param varianza
     */
	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}
    /**
     * 
     * @return varianzaPercepita
     */
	public double getVarianzaPercepita() {
		return varianzaPercepita;
	}
    /**
     * 
     * @param varianzaPercepita
     */
	public void setVarianzaPercepita(double varianzaPercepita) {
		this.varianzaPercepita = varianzaPercepita;
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
	
}

