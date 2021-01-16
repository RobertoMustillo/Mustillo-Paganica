package it.mustillopaganica.weather.service;

import java.util.Vector;

import it.mustillopaganica.weather.model.Data;;


public class CostruisciArray {
	/**
	 * contiene tutti i dati del meteo
	 * @author aldop
	 * @author rbtms
	 */
	private Vector<Data> list = new Vector<Data>();
	
	/**
	 * Metodo statico che popola il vettore 
<<<<<<< HEAD
	 * @param citta
=======
	 * @param Citta      nome della Citta
	 * @param units      sistema di misura
	 * @param epoch      Data
	 * @param temp       temperatura della città
	 * @param tempPerc   temperatura percepita della città
	 * @param tempMin    temperatura minima della città
	 * @param tempMax    temperatura massima della città
	 * @param umidita    umidita della città
>>>>>>> branch 'master' of https://github.com/RobertoMustillo/Mustillo-Paganica
	 * @return list
	 */
	public Vector<Data> Costruisci(String Citta, String units,String epoch, double temp, double tempPerc,
			double tempMin, double tempMax, long umidita)
	{
		Data Meteo = new  Data(Citta, units,epoch, temp, tempPerc, tempMin, tempMax, umidita);
		list.add(Meteo);
		return list;
	}
}
