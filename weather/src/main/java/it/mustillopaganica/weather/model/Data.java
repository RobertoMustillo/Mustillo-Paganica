package it.mustillopaganica.weather.model;

import it.mustillopaganica.weather.service.MeteoParser;

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
		 * Returns Citta.
		 * @return Citta 
		 */
		public String getCitta() {
			return this.Citta;
		}

		/**
		 * Sets a value to attribute NomeCitta. 
		 * @param newNomeCitta 
		 */
		public void setCitta(String newCitta) {
			this.Citta = newCitta;
		}

		/**
		 * Returns Temperatura.
		 * @return Temperatura 
		 */
		public double getTemperatura() {
			return this.Temperatura;
		}

		/**
		 * Sets a value to attribute Temperatura. 
		 * @param newTemperatura 
		 */
		public void setTemperatura(double newTemperatura) {
			this.Temperatura = newTemperatura;
		}

		/**
		 * Returns TemperaturaMinima.
		 * @return TemperaturaMinima 
		 */
		public double getTemperaturaMinima() {
			return this.TemperaturaMinima;
		}

		/**
		 * Sets a value to attribute TemperaturaMinima. 
		 * @param newTemperaturaMinima 
		 */
		public void setTemperaturaMinima(double newTemperaturaMinima) {
			this.TemperaturaMinima = newTemperaturaMinima;
		}

		/**
		 * Returns TemperaturaMassima.
		 * @return TemperaturaMassima 
		 */
		public double getTemperaturaMassima() {
			return this.TemperaturaMassima;
		}

		/**
		 * Sets a value to attribute TemperaturaMassima. 
		 * @param newTemperaturaMassima 
		 */
		public void setTemperaturaMassima(double newTemperaturaMassima) {
			this.TemperaturaMassima = newTemperaturaMassima;
		}

		/**
		 * Returns Umidita.
		 * @return Umidita 
		 */
		public long getUmidita() {
			return this.Umidita;
		}

		/**
		 * Sets a value to attribute Umidita. 
		 * @param newUmidita 
		 */
		public void setUmidita(long newUmidita) {
			this.Umidita = newUmidita;
		}

		/**
		 * Returns TemperaturaPercepita.
		 * @return TemperaturaPercepita 
		 */
		public double getTemperaturaPercepita() {
			return this.TemperaturaPercepita;
		}

		/**
		 * Sets a value to attribute TemperaturaPercepita. 
		 * @param newTemperaturaPercepita 
		 */
		public void setTemperaturaPercepita(double newTemperaturaPercepita) {
			this.TemperaturaPercepita = newTemperaturaPercepita;
		}

			public String getEpoch() {
			return epoch;
		}

		public void setEpoch(String epoch) {
			this.epoch = epoch;
		}
		
		public String toString() {
			return "Citta: "+Citta+","+"data: "+epoch+","+"units: "+units+","+"temp: "+Temperatura+","+"temp_max: "+TemperaturaMassima+","+"temp_min: "+TemperaturaMinima+","+"temp_perc: "+TemperaturaPercepita+","+"umidita : "+Umidita;
		}
		
		public boolean equals(Object o) {
			if (o instanceof Data ) {
				Data a = ( Data ) o;
				return (epoch.equals(a.epoch) && Citta.equals(a.Citta));
				}
				else return false ;			
		}
	}
