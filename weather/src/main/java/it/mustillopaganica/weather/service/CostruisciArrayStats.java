package it.mustillopaganica.weather.service;

import it.mustillopaganica.weather.model.DataStats;
import java.util.Vector;

/**
 * @author rbtms
 * @author aldop
 */
public class CostruisciArrayStats {

		/**
		 * contiene tutti i dati per le statistiche del meteo
		 */
		private Vector<DataStats> list = new Vector<DataStats>();
		
		/**
		 * Metodo che popola il vettore 
		 * @param citta
		 * @param epoch
		 * @param descrizione
		 * @param nuvole
		 * @param vento
		 * @param visibilita
		 * @return list
		 */
		public Vector<DataStats> CostruisciStats(String citta,String epoch, String descrizione,long nuvole, 
				double vento, long visibilita)
		{
			DataStats infoMeteo = new  DataStats(citta, epoch,descrizione, nuvole, vento, visibilita);
			list.add(infoMeteo);
			return list;
		}
}
