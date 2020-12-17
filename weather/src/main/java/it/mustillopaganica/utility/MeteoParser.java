/**
 * 
 */
package it.mustillopaganica.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public class MeteoParser {

		private String Citta;
		private long epoch;
		private double Temperatura;
		private double TemperaturaMinima;
		private double TemperaturaMassima;
		private int Umidita;
	
		public MeteoParser(String Citta) {
			this.Citta = Citta;
		}

		public String getCitta() {
			return Citta;
		}

		public void setCitta(String citta) {
			Citta = citta;
		}

		public double getTemperatura() {
			return Temperatura;
		}

		public double getTemperaturaMinima() {
			return TemperaturaMinima;
		}

		public double getTemperaturaMassima() {
			return TemperaturaMassima;
		}

		public int getUmidita() {
			return Umidita;
		}
		
		public void parser() {
			JSONParser parser = new JSONParser();
			JSONObject obj = null;
			RestTemplate restTemplate = new RestTemplate(); //oggetto che serve per consumare una API REST
			String result = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/forecast?q="+this.Citta+
					"&appid=1e16191367ab76e8faec0be2fb320e01&units=metric&lang=it", String.class);
			System.out.println(result); //giusto per vedere da console che faccia qualcosa
			try {
				obj = (JSONObject) parser.parse(result);
				this.Citta = (String) obj.get("name");
				this.epoch = (Long) obj.get("dt");
				JSONObject clouds = (JSONObject) obj.get("clouds");
				JSONObject main = (JSONObject) obj.get("main");
				this.Temperatura = (Long) obj.get("temp");
				this.TemperaturaMinima = Double.parseDouble(main.get("temp").toString());
				this.TemperaturaMassima = Double.parseDouble(clouds.get("all").toString());
				this.Umidita = Integer.parseInt(main.get("umidita").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		public long getEpoch() {
			return epoch;
		}
		
}