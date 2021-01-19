package it.mustillopaganica.weather.model;

import it.mustillopaganica.weather.service.MeteoParser;

/**
 * Model
 * @author aldop
 * @author rbtms
 * 
 */
public class Data {
		private String Citta;
		private String epoch;
		private double Temperatura;
		private double TemperaturaPercepita;
		private double TemperaturaMinima;
		private double TemperaturaMassima;
		private long Umidita;
		private String units = "metric";


		public String getUnits() {
			return units;
		}
		public void setUnits(String units) {
			this.units = units;
		}

		public Data() {
			
		}
		/**Costruttore completo
		 * @param Citta     Nome della città
		 * @param units     sistema di misura
		 * @param epoch     Data 
		 * @param temp      Temperatura della città
		 * @param tempPerc  Temperatura percepita della città
		 * @param tempMin   Temperatura minima della città
		 * @param tempMax   Temperatura massima della città
		 * @param umidita   Umidità della città
		*/
		public Data(String Citta, String units,String epoch, double temp, double tempPerc,double tempMin, double tempMax, long umidita) {
			this.Citta = Citta;
			this.units = units;
			this.epoch = epoch;
			Temperatura=temp;
			TemperaturaPercepita = tempPerc;
			TemperaturaMinima = tempMin;
			TemperaturaMassima = tempMax;
			Umidita = umidita;
		}
        /**
         * 
         * @param Citta
         */
		public void getFromMeteoParser(String Citta) {
			MeteoParser openWeatherParser = new MeteoParser(Citta);
			openWeatherParser.setUnits(this.units);
			openWeatherParser.parser();
			this.Citta = openWeatherParser.getCitta();
			this.epoch = openWeatherParser.getEpoch();
			this.Temperatura = openWeatherParser.getTemperatura();
			this.TemperaturaPercepita = openWeatherParser.getTemperaturaPercepita();
			this.TemperaturaMassima = openWeatherParser.getTemperaturaMassima();
			this.TemperaturaMinima = openWeatherParser.getTemperaturaMinima();
			this.Umidita = openWeatherParser.getUmidita();
		}
        
		/**
		 * Ritorna il nome della Città.
		 * @return Citta 
		 */
		
		public String getCitta() {
			return this.Citta;
		}

		/**
		 * Metodo che setta il nome della Città. 
		 * @param newCitta 
		 */
		public void setCitta(String newCitta) {
			this.Citta = newCitta;
		}

		/**
		 * Ritorna la temperatura della Città.
		 * @return Temperatura 
		 */
		public double getTemperatura() {
			return this.Temperatura;
		}

		/**
		 * Metodo che setta la temperatura della Città. 
		 * @param newTemperatura 
		 */
		public void setTemperatura(double newTemperatura) {
			this.Temperatura = newTemperatura;
		}

		/**
		 * Ritorna la temperatura minima della Città.
		 * @return TemperaturaMinima 
		 */
		public double getTemperaturaMinima() {
			return this.TemperaturaMinima;
		}

		/**
		 * Metodo che setta la temperatura minima della Città. 
		 * @param newTemperaturaMinima 
		 */
		public void setTemperaturaMinima(double newTemperaturaMinima) {
			this.TemperaturaMinima = newTemperaturaMinima;
		}

		/**
		 * Ritorna la temperatura massima.
		 * @return TemperaturaMassima 
		 */
		public double getTemperaturaMassima() {
			return this.TemperaturaMassima;
		}

		/**
		 * Metodo che setta la temperatura massima. 
		 * @param newTemperaturaMassima 
		 */
		public void setTemperaturaMassima(double newTemperaturaMassima) {
			this.TemperaturaMassima = newTemperaturaMassima;
		}

		/**
		 * Ritorna l'umidita della città.
		 * @return Umidita 
		 */
		public long getUmidita() {
			return this.Umidita;
		}

		/**
		 * Metodo che setta l'umidita della città. 
		 * @param newUmidita 
		 */
		public void setUmidita(long newUmidita) {
			this.Umidita = newUmidita;
		}

		/**
		 * Ritorna la temperatura percepita della città.
		 * @return TemperaturaPercepita 
		 */
		public double getTemperaturaPercepita() {
			return this.TemperaturaPercepita;
		}

		/**
		 * Metodo che setta la temperatura percepita della città. 
		 * @param newTemperaturaPercepita 
		 */
		public void setTemperaturaPercepita(double newTemperaturaPercepita) {
			this.TemperaturaPercepita = newTemperaturaPercepita;
		}
		/**
		 * Ritorna la data.
		 * @return epoch
		 */
			public String getEpoch() {
			return epoch;
		}
		/**
	     * Metodo che setta la data. 
		 *@param epoch
	    */
		public void setEpoch(String epoch) {
			this.epoch = epoch;
		}
		
		public String toString() {
			return "Citta: "+Citta+","+"data: "+epoch+","+"units: "+units+","+"temp: "+Temperatura+","+
					"temp_max: "+TemperaturaMassima+","+"temp_min: "+TemperaturaMinima+","+
					"temp_perc: "+TemperaturaPercepita+","+"umidita : "+Umidita;
		}
		
		public boolean equals(Object o) {
			if (o instanceof Data ) {
				Data a = ( Data ) o;
				return (epoch.equals(a.epoch) && Citta.equals(a.Citta));
				}
				else return false ;			
		}
	}
