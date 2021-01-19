package it.mustillopaganica.weather.model;


public class CondizioniMeteo {
	/**
	 * @author rbtms
	 * @author aldop
	 */	
		private String Citta;
		private String Epoch;
		private String Descrizione;
		private long Nuvole;
		private double Vento;
		private long Visibilita;
		
		public CondizioniMeteo() {
		}
		/**
		 * 
		 * @param citta       
		 * @param epoch       
		 * @param descrizione  
		 * @param nuvole      
		 * @param vento
		 * @param visibilita
		 */
		public CondizioniMeteo(String citta, String epoch, String descrizione, long nuvole, double vento, long visibilita) {
			Citta = citta;
			Epoch=epoch;
			Descrizione = descrizione;
			Nuvole = nuvole;
			Vento = vento;
			Visibilita = visibilita;
		}
		public boolean equals(Object o) {
			if (o instanceof CondizioniMeteo ) {
				CondizioniMeteo a = ( CondizioniMeteo ) o;
				return (Epoch.equals(a.Epoch) && Citta.equals(a.Citta));
				}
				else return false ;			
		}
		/**
		 * Ritorna la data
		 * @return Epoch
		 */
		public String getEpoch() {
			return Epoch;
		}
		/**
		 * metodo che setta la data
		 * @param epoch
		 */
		public void setEpoch(String epoch) {
			Epoch = epoch;
		}
		/**
		 * Ritorna il nome della città
		 * @return Citta
		 */
		public String getCitta() {
			return Citta;
		}
		/**
		 * metodo che setta il nome della città
		 * @param citta
		 */
		public void setCitta(String citta) {
			Citta = citta;
		}
		/**
		 * ritorna la descrizione
		 * @return Descrizione
		 */
		public String getDescrizione() {
			return Descrizione;
		}
		/**
		 * metodo che setta la descrizione
		 * @param descrizione
		 */
		public void setDescrizione(String descrizione) {
			Descrizione = descrizione;
		}
		/**
		 * 
		 * @return Nuvole
		 */
		public long getNuvole() {
			return Nuvole;
		}
		/**
		 * 
		 * @param nuvole
		 */
		public void setNuvole(long nuvole) {
			Nuvole = nuvole;
		}
		/**
		 * 
		 * @return Vento
		 */
		public double getVento() {
			return Vento;
		}
		/**
		 * 
		 * @param vento
		 */
		public void setVento(double vento) {
			Vento = vento;
		}
		/**
		 * 
		 * @return Visibilita
		 */
		public long getVisibilita() {
			return Visibilita;
		}
		/**
		 * 
		 * @param visibilita
		 */
		public void setVisibilita(long visibilita) {
			Visibilita = visibilita;
		}
}
