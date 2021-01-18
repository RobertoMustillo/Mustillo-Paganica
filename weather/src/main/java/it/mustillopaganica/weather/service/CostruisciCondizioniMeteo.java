package it.mustillopaganica.weather.service;

import it.mustillopaganica.weather.model.CondizioniMeteo;
import java.util.Vector;

/**
 * @author rbtms
 * @author aldop
 */
public class CostruisciCondizioniMeteo {

		/**
		 * contiene tutti i dati per le statistiche del meteo
		 */
		private Vector<CondizioniMeteo> list = new Vector<CondizioniMeteo>();
		
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
		public Vector<CondizioniMeteo> CostruisciStats(String citta,String epoch, String descrizione,long nuvole, 
				double vento, long visibilita)
		{
			CondizioniMeteo infoMeteo = new  CondizioniMeteo(citta, epoch,descrizione, nuvole, vento, visibilita);
			list.add(infoMeteo);
			return list;
		}
}
