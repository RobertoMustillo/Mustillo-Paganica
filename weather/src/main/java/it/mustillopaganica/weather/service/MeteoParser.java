package it.mustillopaganica.weather.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import it.mustillopaganica.weather.model.Data;

@Service
public class MeteoParser {
	private String Citta;
	private String epoch;
	private double Temperatura, TemperaturaPercepita;
	private double TemperaturaMinima;
	private double TemperaturaMassima;
	private long Umidita;
	private String units="metric";
	private Vector<Data> arr = new Vector<Data>();

	private CostruisciArray costruisciArray = new CostruisciArray();
	
	public Vector<Data> getArr() {
		return arr;
	}

	public void arrClear() {
		arr.clear();
	}
	
	public MeteoParser(String Citta) {
		this.Citta=Citta;
	}

	public MeteoParser() {
		
	}
	
	public String getCitta() {
		return Citta;
	}

	public void setCitta(String citta) {
		Citta = citta;
	}

	public void setEpoch(String epoch) {
		this.epoch = epoch;
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

	public long getUmidita() {
		return Umidita;
	}
	
	// verifica se una certa citta e' presente per una data specifica
/*		public boolean presente ( Data a) {
		// contains usa il metodo equals di Data
		return arr.contains (a);
		}
*/	
	/*metodo che
	 * filtra il periodo richiesto in una possibile BodyRequest
	 */
	public boolean dataPresente( String d) {
	boolean trovato = false ;
	for ( Data a : arr )
	if (a.getEpoch(). equals (d)) trovato = true ;
	return trovato ;
	}
	
	/*
	 * metodo che prende le api di openweather e le parsa al model
	 * con le sole informazioni necessarie 
	 */
	public void parser() {
		JSONParser parser = new JSONParser();
		String sito = "http://api.openweathermap.org/data/2.5/forecast?q="+this.Citta+
				"&appid=1e16191367ab76e8faec0be2fb320e01&units="+this.units+"&lang=it";
	      try {
	    	  URL url = new URL(sito);
			  URLConnection conn = url.openConnection();
			  BufferedReader in = new BufferedReader(new InputStreamReader (conn.getInputStream()));
	         
			  String inputLine;
	            while ((inputLine = in.readLine()) != null) { 
	            	JSONObject meteo = (JSONObject) parser.parse(inputLine);

	            	JSONObject city = (JSONObject)meteo.get("city");
	            	this.Citta = (String)city.get("name");
	            			            	
	                JSONArray list = (JSONArray) meteo.get("list"); 
	                for (Object o : list) {
	                	
	                    JSONObject dt = (JSONObject) o;
	                    this.epoch = (String) dt.get("dt_txt");
	                    
	                    JSONObject meteo2 = (JSONObject) o;
	                    JSONObject main = (JSONObject) meteo2.get("main");
	                    
	                    this.Temperatura = Double.parseDouble(main.get("temp").toString());
	                    this.TemperaturaPercepita = Double.parseDouble( main.get("feels_like").toString());
	                    this.TemperaturaMinima = Double.parseDouble(main.get("temp_min").toString());
	                    this.TemperaturaMassima = Double.parseDouble(main.get("temp_max").toString());
	                    this.Umidita = Long.parseLong(main.get("humidity").toString());

	                    
	                    arr = costruisciArray.Costruisci(Citta, units,epoch, Temperatura, TemperaturaPercepita, TemperaturaMinima, TemperaturaMassima, Umidita);
	                  
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
	public double getTemperaturaPercepita() {
		return TemperaturaPercepita;
	}

	public String getEpoch() {
		return epoch;
	}
	
}