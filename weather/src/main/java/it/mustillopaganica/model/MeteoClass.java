
package it.mustillopaganica.model;

/* 
 * @author roberto mustillo
 */
public class MeteoClass {
	
	public String Citta = "";
	private double Temperatura;
	private double TemperaturaMinima;
	private double TemperaturaMassima;
	private int Umidita;
	private double TemperaturaReale;
	private double TemperaturaPercepita;
	private double Media;
	private double Varianza;

	public MeteoClass(String Citta, double temp, double tempMin, double tempMax, int umidita, double tempReale, double tempPerc, double media, double varianza) {
		this.Citta = Citta;
		temp = Temperatura;
		tempMin = TemperaturaMinima;
		tempMax = TemperaturaMassima;
		umidita = Umidita;
		tempReale = TemperaturaReale;
		tempPerc = TemperaturaPercepita;
		media = Media;
		varianza = Varianza;
	}

	public void getFromMeteoParser(String nomeCitta) {
		// Start of user code for method getFromMeteoParser
		// End of user code
	}

	// Start of user code (user defined methods for MeteoClass)

	// End of user code
	/**
	 * Returns Citta.
	 * @return Citta 
	 */
	public String getCitta() {
		return this.Citta;
	}

	/**
	 * Sets a value to attribute NomeCitta. 
	 * @param newNomeCitta 
	 */
	public void setCitta(String newCitta) {
		this.Citta = newCitta;
	}

	/**
	 * Returns Temperatura.
	 * @return Temperatura 
	 */
	public double getTemperatura() {
		return this.Temperatura;
	}

	/**
	 * Sets a value to attribute Temperatura. 
	 * @param newTemperatura 
	 */
	public void setTemperatura(double newTemperatura) {
		this.Temperatura = newTemperatura;
	}

	/**
	 * Returns TemperaturaMinima.
	 * @return TemperaturaMinima 
	 */
	public double getTemperaturaMinima() {
		return this.TemperaturaMinima;
	}

	/**
	 * Sets a value to attribute TemperaturaMinima. 
	 * @param newTemperaturaMinima 
	 */
	public void setTemperaturaMinima(double newTemperaturaMinima) {
		this.TemperaturaMinima = newTemperaturaMinima;
	}

	/**
	 * Returns TemperaturaMassima.
	 * @return TemperaturaMassima 
	 */
	public double getTemperaturaMassima() {
		return this.TemperaturaMassima;
	}

	/**
	 * Sets a value to attribute TemperaturaMassima. 
	 * @param newTemperaturaMassima 
	 */
	public void setTemperaturaMassima(double newTemperaturaMassima) {
		this.TemperaturaMassima = newTemperaturaMassima;
	}

	/**
	 * Returns Umidita.
	 * @return Umidita 
	 */
	public int getUmidita() {
		return this.Umidita;
	}

	/**
	 * Sets a value to attribute Umidita. 
	 * @param newUmidita 
	 */
	public void setUmidita(int newUmidita) {
		this.Umidita = newUmidita;
	}

	/**
	 * Returns TemperaturaReale.
	 * @return TemperaturaReale 
	 */
	public double getTemperaturaReale() {
		return this.TemperaturaReale;
	}

	/**
	 * Sets a value to attribute TemperaturaReale. 
	 * @param newTemperaturaReale 
	 */
	public void setTemperaturaReale(double newTemperaturaReale) {
		this.TemperaturaReale = newTemperaturaReale;
	}

	/**
	 * Returns TemperaturaPercepita.
	 * @return TemperaturaPercepita 
	 */
	public double getTemperaturaPercepita() {
		return this.TemperaturaPercepita;
	}

	/**
	 * Sets a value to attribute TemperaturaPercepita. 
	 * @param newTemperaturaPercepita 
	 */
	public void setTemperaturaPercepita(double newTemperaturaPercepita) {
		this.TemperaturaPercepita = newTemperaturaPercepita;
	}

	/**
	 * Returns Media.
	 * @return Media 
	 */
	public double getMedia() {
		return this.Media;
	}

	/**
	 * Sets a value to attribute Media. 
	 * @param newMedia 
	 */
	public void setMedia(double newMedia) {
		this.Media = newMedia;
	}

	/**
	 * Returns Varianza.
	 * @return Varianza 
	 */
	public double getVarianza() {
		return this.Varianza;
	}

	/**
	 * Sets a value to attribute Varianza. 
	 * @param newVarianza 
	 */
	public void setVarianza(double newVarianza) {
		this.Varianza = newVarianza;
	}
     //provaa22222
	
}
