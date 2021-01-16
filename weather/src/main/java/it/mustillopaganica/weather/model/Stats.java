/**
 * 
 */
package it.mustillopaganica.weather.model;

/**
 * @author rbtms
 *
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
	
	public double getTempMax() {
		return TempMax;
	}

	public void setTempMax(double tempMax) {
		TempMax = tempMax;
	}

	public double getTempMin() {
		return TempMin;
	}

	public void setTempMin(double tempMin) {
		TempMin = tempMin;
	}

	public double getTempPercMax() {
		return TempPercMax;
	}

	public void setTempPercMax(double tempPercMax) {
		TempPercMax = tempPercMax;
	}

	public double getTempPercMin() {
		return TempPercMin;
	}

	public void setTempPercMin(double tempPercMin) {
		TempPercMin = tempPercMin;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getMediaPercepita() {
		return mediaPercepita;
	}

	public void setMediaPercepita(double mediaPercepita) {
		this.mediaPercepita = mediaPercepita;
	}

	public double getVarianza() {
		return varianza;
	}

	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}

	public double getVarianzaPercepita() {
		return varianzaPercepita;
	}

	public void setVarianzaPercepita(double varianzaPercepita) {
		this.varianzaPercepita = varianzaPercepita;
	}

	public Integer getId() {
		return id;
	}

	public void setCitta(Integer id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
}
