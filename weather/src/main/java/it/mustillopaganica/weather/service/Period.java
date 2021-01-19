/**
 * 
 */
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
import it.mustillopaganica.weather.utilities.Filter;

/**
 * Classe che utilizza la classe Filter
 * per effettuare un parser filtrato
 * @author rbtms
 * @author aldop
 */
@Service
public class Period {
	private String Citta;
	private String epoch;
	private double Temperatura, TemperaturaPercepita;
	private double TemperaturaMinima;
	private double TemperaturaMassima;
	private long Umidita;
	private String units="metric";
	private Vector<Data> arr = new Vector<Data>();
	public Filter filter = new Filter();

	
	
	private CostruisciArray costruisciArray = new CostruisciArray();

	/*
	 * Metodo che verifica se una data 
	 * è presente tra le date disponibili
	 * 
	 */
	public boolean dataPresente( String d) {
	boolean trovato = false ;
	for ( Data a : arr )
	if (a.getEpoch(). equals (d)) trovato = true ;
	return trovato ;
	}
	
	/*
	 * metodo che prende le api di openweather e le parsa al model
	 * con le sole informazioni necessarie Filtrate
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
	                   
	                    //esegue il parser delle sole date richiste nel filter
	                    //cioè dalla data from alla data to
	                    if((epoch.compareTo(filter.getFrom()) >= 0)) {
	         //           if(dt.containsValue(filter.getFrom())) { //filtra il periodo

	                    JSONObject meteo2 = (JSONObject) o;
	                    JSONObject main = (JSONObject) meteo2.get("main");
	                    
	                    this.Temperatura = Double.parseDouble(main.get("temp").toString());
	                    this.TemperaturaPercepita = Double.parseDouble( main.get("feels_like").toString());
	                    this.TemperaturaMinima = Double.parseDouble(main.get("temp_min").toString());
	                    this.TemperaturaMassima = Double.parseDouble(main.get("temp_max").toString());
	                    this.Umidita = Long.parseLong(main.get("humidity").toString());

	                    arr = costruisciArray.Costruisci(Citta, units,epoch, Temperatura, 
	                    		TemperaturaPercepita, TemperaturaMinima, TemperaturaMassima, Umidita);
	                    if(dt.containsValue(filter.getTo()))  //filtra il periodo
	                    	break;// Esce all'ultima data
	                    } 
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
	/**
	 * 
	 * @return Citta
	 */
	public String getCitta() {
		return Citta;
	}
    /**
     * 
     * @param citta
     */
	public void setCitta(String citta) {
		Citta = citta;
	}
    /**
     * 
     * @return epoch
     */
	public String getEpoch() {
		return epoch;
	}
    /**
     * 
     * @param epoch
     */
	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}
    /**
     * 
     * @return Temperatura
     */
	public double getTemperatura() {
		return Temperatura;
	}
    /**
     * 
     * @param temperatura
     */
	public void setTemperatura(double temperatura) {
		Temperatura = temperatura;
	}
    /**
     * 
     * @return TemperaturaPercepita
     */
	public double getTemperaturaPercepita() {
		return TemperaturaPercepita;
	}
    /**
     * 
     * @param temperaturaPercepita
     */
	public void setTemperaturaPercepita(double temperaturaPercepita) {
		TemperaturaPercepita = temperaturaPercepita;
	}
    /**
     * 
     * @return TemperaturaMinima
     */
	public double getTemperaturaMinima() {
		return TemperaturaMinima;
	}
    /**
     * 
     * @param temperaturaMinima
     */
	public void setTemperaturaMinima(double temperaturaMinima) {
		TemperaturaMinima = temperaturaMinima;
	}
    /**
     * 
     * @return TemperaturaMassima
     */
	public double getTemperaturaMassima() {
		return TemperaturaMassima;
	}
    /**
     * 
     * @param temperaturaMassima
     */
	public void setTemperaturaMassima(double temperaturaMassima) {
		TemperaturaMassima = temperaturaMassima;
	}
    /**
     * 
     * @return Umidita
     */
	public long getUmidita() {
		return Umidita;
	}
    /**
     * 
     * @param umidita
     */
	public void setUmidita(long umidita) {
		Umidita = umidita;
	}
    /**
     * 
     * @return units
     */
	public String getUnits() {
		return units;
	}
    /**
     * 
     * @param units
     */
	public void setUnits(String units) {
		this.units = units;
	}
    /**
     * 
     * @return arr
     */
	public Vector<Data> getArr() {
		return arr;
	}
    /**
     * 
     * @param arr
     */
	public void setArr(Vector<Data> arr) {
		this.arr = arr;
	}
    /**
     * 
     * @return costruisciArray
     */
	public CostruisciArray getCostruisciArray() {
		return costruisciArray;
	}
    /**
     * 
     * @param costruisciArray
     */
	public void setCostruisciArray(CostruisciArray costruisciArray) {
		this.costruisciArray = costruisciArray;
	}
    /**
     * 
     * @param Citta
     */
	public Period(String Citta) {
		this.Citta=Citta;
	}
	
	public Period() {
		
	}
	
}
