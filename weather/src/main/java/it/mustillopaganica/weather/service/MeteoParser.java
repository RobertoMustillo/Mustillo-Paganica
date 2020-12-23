package it.mustillopaganica.weather.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MeteoParser {
	private String Citta;
	private String epoch;
	private double Temperatura, TemperaturaPercepita;
	private double TemperaturaMinima;
	private double TemperaturaMassima;
	private long Umidita;
	private String units = "metric";

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

	public long getUmidita() {
		return Umidita;
	}
	
	//metodo che prende le api di openweather e le parsa al model
	public void parser() {
		JSONParser parser = new JSONParser();
		String sito = "http://api.openweathermap.org/data/2.5/forecast?q="+this.Citta+
				"&appid=1e16191367ab76e8faec0be2fb320e01&units="+this.units+"&lang=it";
	      try {
	    	  URL url = new URL(sito);
			  URLConnection conn = url.openConnection();
			  BufferedReader in = new BufferedReader(new InputStreamReader (conn.getInputStream()));
	          //Parsing the contents of the JSON file
	         
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