/**
 * 
 */
package it.mustillopaganica.weather.exceptions;

/**
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
	
	public void validateParameters(Integer param ) {
		if (param == null) {
		throw new NullPointerException("Null parameters are not allowed");
		}
		}
}
