package it.mustillopaganica.weather.service;

import java.util.Vector;

import it.mustillopaganica.weather.model.Data;;

public class CostruisciArray {
	/**
	 * contiene tutti i dati del meteo
	 */
	private Vector<Data> list = new Vector<Data>();
	
	/**
	 * Metodo statico che popola il vettore 
	 * @param citta
	 * @return 
	 */
	public Vector<Data> Costruisci(String Citta, String units,String epoch, double temp, double tempPerc,
			double tempMin, double tempMax, long umidita)
	{
		Data infoMeteo = new  Data(Citta, units,epoch, temp, tempPerc, tempMin, tempMax, umidita);
		list.add(infoMeteo);
		return list;
	}
}
