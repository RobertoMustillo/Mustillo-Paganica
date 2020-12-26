package it.mustillopaganica.weather.service;

import it.mustillopaganica.weather.model.DataStats;
import java.util.Vector;

/**
 * @author rbtms
 *
 */
public class CostruisciArrayStats {

		/**
		 * contiene tutti i dati per le statistiche del meteo
		 */
		private static Vector<DataStats> list = new Vector<DataStats>();
		
		/**
		 * Metodo statico che popola il vettore 
		 * @param citta
		 * 
		 * @return 
		 */
		public static Vector<DataStats> CostruisciStats(String citta,String epoch, String descrizione,long nuvole, 
				double vento, long visibilita)
		{
			DataStats infoMeteo = new  DataStats(citta, epoch,descrizione, nuvole, vento, visibilita);
			list.add(infoMeteo);
			return list;
		}
}
