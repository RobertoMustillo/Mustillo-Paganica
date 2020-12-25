package it.mustillopaganica.weather.model;

public class DataStats {
	/**
	 * @author rbtms
	 *
	 */	
		private String Citta;
		private String Epoch;
		private String Descrizione;
		private long Nuvole;
		private double Vento;
		private long Visibilita;
		
		public DataStats() {
			
		}
		public DataStats(String citta, String epoch, String descrizione, long nuvole, double vento, long visibilita) {
			Citta = citta;
			Epoch=epoch;
			Descrizione = descrizione;
			Nuvole = nuvole;
			Vento = vento;
			Visibilita = visibilita;
		}
		public String getEpoch() {
			return Epoch;
		}
		public void setEpoch(String epoch) {
			Epoch = epoch;
		}
		public String getCitta() {
			return Citta;
		}
		public void setCitta(String citta) {
			Citta = citta;
		}
		public String getDescrizione() {
			return Descrizione;
		}
		public void setDescrizione(String descrizione) {
			Descrizione = descrizione;
		}
		public long getNuvole() {
			return Nuvole;
		}
		public void setNuvole(long nuvole) {
			Nuvole = nuvole;
		}
		public double getVento() {
			return Vento;
		}
		public void setVento(double vento) {
			Vento = vento;
		}
		public long getVisibilita() {
			return Visibilita;
		}
		public void setVisibilita(long visibilita) {
			Visibilita = visibilita;
		}
}
