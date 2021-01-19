/**
 * 
 */
package it.mustillopaganica.weather.exceptions;

/**
 * Classe per le eccezioni
 * @author rbtms
 *
 */
public class MeteoException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public MeteoException() {
		super();
	}

	/**
	 * @param message Description of the Exception
	 */
	public MeteoException(String message) {
		super(message);
	}
}
