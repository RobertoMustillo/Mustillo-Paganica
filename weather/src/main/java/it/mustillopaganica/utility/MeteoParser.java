/**
 * 
 */
package it.mustillopaganica.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

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
		private String epoch;
		private double Temperatura, TemperaturaPercepita;
		private double TemperaturaMinima;
		private double TemperaturaMassima;
		private int Umidita;

		private String sito = "http://api.openweathermap.org/data/2.5/forecast?q="+this.Citta+
								"&appid=1e16191367ab76e8faec0be2fb320e01&units=metric&lang=it"; 

		public MeteoParser(String Citta) {
			this.Citta=Citta;
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
		      try {
		    	  URL url = new URL(sito);
				  URLConnection conn = url.openConnection();
				  BufferedReader in = new BufferedReader(new InputStreamReader (conn.getInputStream()));
		          //Parsing the contents of the JSON file
		         
				  String inputLine;
		            while ((inputLine = in.readLine()) != null) { 
		            	
		            	JSONObject city = (JSONObject) parser.parse(inputLine);
		            	this.Citta = (String)city.get("name");
		            			            	
		                JSONArray a = (JSONArray) city.get("list"); 
		                for (Object o : a) {
		                    JSONObject main = (JSONObject) o;
		                    //JSONObject dt = (JSONObject) o;
		                    //this.epoch = (String) dt.get("dt_txt");
		                    this.Temperatura = (Double) main.get("temp");
		                    this.TemperaturaMinima = (Double) main.get("temp_min");
		                    this.TemperaturaMassima = (Double) main.get("temp_max");
		                    this.TemperaturaPercepita = (Double) main.get("feels_like");
		                    this.Umidita = (Integer) main.get("humidity");
		           

		                }
		            }
		            in.close();
		       } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
		}

		public double getTemperaturaPercepita() {
			return TemperaturaPercepita;
		}

		public String getEpoch() {
			return epoch;
		}
		
}