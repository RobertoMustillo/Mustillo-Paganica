/**
 * 
 */
package it.mustillopaganica.weather.utilities;

import java.util.Vector;

import it.mustillopaganica.weather.exceptions.MeteoException;


/**
 * @author rbtms
 *
 */
public class Statistiche {

	private Double max;

	private Double min;

	private Integer sampleNum;

	private Double accumulator;
	/**
	 * Vettore contenente i campioni utilizzati
	 */
	private Vector<Double> samples;
	
	/**
	 * Costruttore di default
	 */
	public Statistiche() {
		this.max = -Double.MAX_VALUE;
		this.min = Double.MAX_VALUE;
		this.sampleNum = 0;
		this.accumulator = 0.0;
		this.samples = new Vector<Double>();
	}
	
	/**
	 * Metodo per aggiungere dati
	 * Esegue diverse operazioni on the fly per assegnare i corretti valori a
	 * max, min, sampleNum, e accumulator
	 * @param sample Campione contenente i dati
	 */
	public void addSample(Double sample) {
		this.sampleNum++;
		this.accumulator += sample;
		if (sample > this.max)
			this.max = sample;
		if (sample < this.min)
			this.min = sample;
		this.samples.add(sample);
	}

	/**
	 * @return the max
	 * @throws MmwStatsException 
	 */
	public Double getMax() throws MeteoException {
		if(max==-Double.MAX_VALUE)
			throw new MeteoException("Assenza di campioni");
		else
			return max;
	}

	/**
	 * @return the min
	 * @throws MmwStatsException 
	 */
	public Double getMin() throws MeteoException {
		if(min==Double.MAX_VALUE)
			throw new MeteoException("Assenza di campioni");
		else
			return min;
	}

	
	/**
	 * Metodo per effettuare arrotondamenti a due cifre decimali su tipi double
	 * @param val Valore da arrotondare
	 * @return the rounded value
	 */
	protected double round(double val) {
		int rounder = (int) (val*100.0);
		return (double)rounder/100;
	}
	
	/**
	 * @return the variance
	 * @throws MmwStatsException 
	 */
	public Double getVariance() throws MeteoException {
		if(max==-Double.MAX_VALUE)
			throw new MeteoException("Assenza di campioni");
		else {
			Double avg = this.getAverage();
			Double temp = 0.0;
			for (Double sample : samples) {
				temp += Math.pow((sample - avg), 2);
			}
			return round(temp/this.sampleNum);
		}
	}
	
	/**
	 * @return the average
	 * @throws MmwStatsException 
	 */
	public Double getAverage() throws MeteoException {
		if(max==-Double.MAX_VALUE)
			throw new MeteoException("Assenza di campioni");
		else
			return round(accumulator/sampleNum);
	}
}
