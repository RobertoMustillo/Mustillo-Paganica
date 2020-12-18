/**
 * 
 */
package it.mustillopaganica.model;

/**
 * @author rbtms
 *
 */
public class MeteoClassStats extends MeteoClass{
	private double Media;
	private double Varianza;
	
	public MeteoClassStats(String Citta, String epoch, double temp, double tempPerc, double tempMin, double tempMax, long umidita, double media,double varianza) {
		super(Citta, epoch, temp, tempPerc,tempMin, tempMax, umidita);
		Media= media;
		Varianza=varianza;
	}

	public MeteoClassStats() {
		
	}
	
	public double getMedia() {
		return Media;
	}

	public void setMedia(double media) {
		Media = media;
	}

	public double getVarianza() {
		return Varianza;
	}

	public void setVarianza(double varianza) {
		Varianza = varianza;
	}
}
