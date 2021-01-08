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

import it.mustillopaganica.weather.model.DataStats;


/**
 * @author rbtms
 *
 */
public class ParserStats {
	private Vector<DataStats> stats = new Vector<DataStats>();
	private String Citta;
	private String epoch;
	private String Descrizione;
	private long Nuvole;
	private double Vento;
	private long Visibilita;
	private CostruisciArrayStats costruisciArray = new CostruisciArrayStats();

	public ParserStats() {
		
	}
	public ParserStats(String citta) {
		this.Citta=citta;
	}
	public String getCitta() {
		return Citta;
	}
	public void setCitta(String citta) {
		Citta = citta;
	}
	public Vector<DataStats> getStats() {
		return stats;
	}

	public void setStats(Vector<DataStats> stats) {
		this.stats = stats;
	}
	
	public void parser() {
		JSONParser parser = new JSONParser();
		String sito = "http://api.openweathermap.org/data/2.5/forecast?q="+this.Citta+
				"&appid=1e16191367ab76e8faec0be2fb320e01";

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
	                for(Object o : list) {
	                	
	                	JSONObject dt = (JSONObject) o;
	                    this.epoch = (String) dt.get("dt_txt");
	                    
	                    JSONObject m = (JSONObject) o;
	                    JSONArray weather = (JSONArray)m.get("weather");
	                    
	                    for(Object u: weather) {
	                    	JSONObject m1 = (JSONObject) u;
		                    this.Descrizione = (String)m1.get("description");
	                    }
	                    
	                    JSONObject clouds = (JSONObject)m.get("clouds");
	                    this.Nuvole = Long.parseLong(clouds.get("all").toString());
	                    
	                    JSONObject wind = (JSONObject)m.get("wind");
	                    this.Vento = Double.parseDouble(wind.get("speed").toString());
	                    
	                    this.Visibilita = Long.parseLong(m.get("visibility").toString());
	                    
	                    stats = costruisciArray.CostruisciStats(Citta, epoch,Descrizione, Nuvole, Vento, Visibilita);
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
}
