/**
 * @author rbtms
 *
 */
package it.mustillopaganica.model;

/**
 * Description of MeteoClass.
 * 
 * @author rbtms
 */
public class MeteoClass {
	/**
	 * Description of the property NomeCitta.
	 */
	public String NomeCitta = "";

	/**
	 * Description of the property Temperatura.
	 */
	private double Temperatura = 0D;

	/**
	 * Description of the property TemperaturaMinima.
	 */
	private double TemperaturaMinima = 0D;

	/**
	 * Description of the property TemperaturaMassima.
	 */
	private double TemperaturaMassima = 0D;

	/**
	 * Description of the property Umidita.
	 */
	private Integer Umidita = Integer.valueOf(0);

	/**
	 * Description of the property TemperaturaReale.
	 */
	private double TemperaturaReale = 0D;

	/**
	 * Description of the property TemperaturaPercepita.
	 */
	private double TemperaturaPercepita = 0D;

	/**
	 * Description of the property Media.
	 */
	private double Media = 0D;

	/**
	 * Description of the property Varianza.
	 */
	private double Varianza = 0D;

	// Start of user code (user defined attributes for MeteoClass)

	// End of user code

	/**
	 * The constructor.
	 */
	public MeteoClass() {
		// Start of user code constructor for MeteoClass)
		super();
		// End of user code
	}

	public void getFromMeteoParser(String nomeCitta) {
		// Start of user code for method getFromMeteoParser
		// End of user code
	}

	// Start of user code (user defined methods for MeteoClass)

	// End of user code
	/**
	 * Returns NomeCitta.
	 * @return NomeCitta 
	 */
	public String getNomeCitta() {
		return this.NomeCitta;
	}

	/**
	 * Sets a value to attribute NomeCitta. 
	 * @param newNomeCitta 
	 */
	public void setNomeCitta(String newNomeCitta) {
		this.NomeCitta = newNomeCitta;
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
	public Integer getUmidita() {
		return this.Umidita;
	}

	/**
	 * Sets a value to attribute Umidita. 
	 * @param newUmidita 
	 */
	public void setUmidita(Integer newUmidita) {
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

}
