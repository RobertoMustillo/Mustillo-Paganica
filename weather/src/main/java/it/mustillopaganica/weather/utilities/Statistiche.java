/**
 * 
 */
package it.mustillopaganica.weather.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.Previsione;
import it.mustillopaganica.weather.service.CostruisciArray;

/**
 * @author rbtms
 *
 */
public class Statistiche {
	
	private String path = "JSONConfig.txt";

	private String path2 = "correnti.txt";

	private double Temperatura, Temperatura2,TemperaturaPercepita;
	
	private double TempMax;

	private double TempMin;

	private double TempPercMax;

	private double TempPercMin;
	
	private double media;
	
	private double media2;

	private double varianza;

	private double varianza2;

	private double contatore=1;
	
	private String Citta;

	private long Umidita;
	
	private String units="metric";
	
	private double TemperaturaMinima;
	
	private double TemperaturaMassima;
	
	private String epoch;

	private double accumulatore;
	
	private double accumulatore2;
	/*
	 *@param Id indica il giorno da scegliere per le stats:
	 *{ Termoli = 0
	 *	Ancona = 1
	 *	Milano = 2
	 *	Bergamo = 3
	 *	Napoli = 4
	 *	Benevento = 5
	 *	Torino = 6 } 
	 */
	private Integer id=1;
	
	private Double eps;

	protected Vector<Double> datiTemp = new Vector<Double>();
	
	protected Vector<Double> datiEps = new Vector<Double>();

	protected Vector<String> epoche = new Vector<String>();

	private Vector<Double> datiTempPerc = new Vector<Double>();
	
	private Vector<Data> arr = new Vector<Data>();

	private CostruisciArray costruisciArray = new CostruisciArray();


	/**
	 * Costruttore di default
	 */
	public Statistiche() {
		
	}
	/*
	 * Necessaria nei TEST
	 */
	public void validate (String x) {	
		if (x != path) throw new NullPointerException ("path non presente");
	}

	public void getSTATS() {
		 JSONParser parser = new JSONParser();

	        try (Reader reader = new FileReader(this.path)) {
	        	
	        	JSONArray jArray = (JSONArray) parser.parse(reader);
	        	
	        	JSONArray jArray2 = (JSONArray) jArray.get(id);
	        	for(Object o : jArray2) {
	        		JSONObject obj = (JSONObject)o;
	        		this.Temperatura = Double.parseDouble(obj.get("Temperatura").toString());
	        		this.TemperaturaPercepita = Double.parseDouble(obj.get("TemperaturaPercepita").toString());
	        		this.epoch = (String) obj.get("epoch");
	        	
	        		//effettuo delle statistiche
	        		accumulatore  += Temperatura;
	        		accumulatore2 += TemperaturaPercepita;
	        		
	        		datiTemp.add(Temperatura);
	        		datiTempPerc.add(TemperaturaPercepita);
	        		epoche.add(epoch);
	        		
	        		if(this.Temperatura>TempMax) TempMax = Temperatura;
	        		if(this.Temperatura<TempMin) TempMin = Temperatura;
	        		if(this.TemperaturaPercepita>TempPercMax) TempPercMax = TemperaturaPercepita;
	        		if(this.TemperaturaPercepita<TempPercMin) TempPercMin = TemperaturaPercepita;
	        		contatore++;
	        		Previsione.setCampione((int)contatore);
	        		
	        		
	        	}
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	}

	public Vector<Double> correnti() {
		JSONParser parser = new JSONParser();
		int num=1;
        try (Reader reader = new FileReader(this.path2)) {
        	
        	JSONArray jArray = (JSONArray) parser.parse(reader);
        	
        	JSONArray jArray2 = (JSONArray) jArray.get(id);
        	for(Object o : jArray2) {
        		JSONObject obj = (JSONObject)o;
        		String epochCorrente = (String) obj.get("epoch");
        		
        		for(String epoch2 : epoche) {
            		
            		if(epoch2.equals(epochCorrente)) {
        			
            			this.Temperatura2 = Double.parseDouble(obj.get("Temperatura").toString());
        		//effettuo delle statistiche
            			JSONParser parser2 = new JSONParser();

            	         Reader reader2 = new FileReader(this.path);
            	        	
            	        	JSONArray jArray3 = (JSONArray) parser2.parse(reader2);
            	        	
            	        	JSONArray jArray4 = (JSONArray) jArray3.get(id);
            	        	for(Object ob : jArray4) {
            	        		JSONObject obj2 = (JSONObject)ob;
            	        		String epochForecast = (String) obj2.get("epoch");
            	        		
            	            		
            	            		if(epoch2.equals(epochForecast)) {
            	        			
            	            			this.Temperatura = Double.parseDouble(obj2.get("Temperatura").toString());
            	        		//effettuo delle statistiche
            	            			eps = this.Temperatura2 - this.Temperatura;
            	            			eps=round(eps);
            	            			if(eps<0) eps *= (-1);
            	            			datiEps.add(eps);
            	            			
            	            			Previsione.setStudiate(num++);
            	        		}
            	        		
            	        	}
            
        		}
        		}
        	}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return datiEps;
	}

	public void metadata() {
		 JSONParser parser = new JSONParser();

	        try (Reader reader = new FileReader(this.path)) {
	        	
	        	JSONArray jArray = (JSONArray) parser.parse(reader);
	        	for(int i=0; i<jArray.size(); i++) {
	        	JSONArray jArray2 = (JSONArray) jArray.get(i);
	        	for(Object o : jArray2) {
	        		JSONObject obj = (JSONObject)o;
	        		this.Temperatura = Double.parseDouble(obj.get("Temperatura").toString());
	        		this.TemperaturaPercepita = Double.parseDouble(obj.get("TemperaturaPercepita").toString());
	        		this.epoch = (String) obj.get("epoch");
	        		this.Citta = (String)obj.get("Citta");
	        		this.Umidita = Long.parseLong(obj.get("Umidita").toString());
	        		this.TemperaturaMinima = Double.parseDouble(obj.get("TemperaturaMinima").toString());
                 	this.TemperaturaMassima = Double.parseDouble(obj.get("TemperaturaMassima").toString());
                 
                 	arr = (costruisciArray.Costruisci(Citta, units, epoch, Temperatura,
	        				TemperaturaPercepita, TemperaturaMinima, TemperaturaMassima, Umidita));
	        	
	        	}	
	        	}
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	}
	public Integer azzeccate(Double soglia) {
		Integer azzeccate = 0;
		for(Double x : datiEps) {
			if(x - soglia <= 0) ++azzeccate;
		}
		return azzeccate;
		
	}
	public boolean cittaPresente( String c) {
		boolean trovato = false ;
		Archivio.popola();
		
		for ( String a : (Archivio.citta) )
			if (a.equals(c)) trovato = true ;
		return trovato ;
		}
	
	/*
	 * @param x è una variabile che serve per verificare
	 * 			se i dati del campioni sono vuoti
	 * 
	 * @return false se il campione è vuoto
	 */
	public boolean trovato(Double x) {
		boolean trovato = false;
		for(double campioni : datiTemp) 
			if(campioni != 0.0) trovato = true;
		return trovato;
	}
	/**
	 * @return il massimo della Temperatura
	 * @throws MeteoException 
	 */
	public double getTempMax() throws MeteoException {
		if(!trovato(TempMax))
			throw new MeteoException("Assenza di campioni");
		else
			return TempMax;
	}

	/**
	 * @return il minimo della Temperatura
	 * @throws MeteoException 
	 */
	public double getTempMin() throws MeteoException {
		if(!trovato(TempMin))
			throw new MeteoException("Assenza di campioni");
		else
			return TempMin;
	}

	/**
	 * @return il massimo della TemperaturaPercepita
	 * @throws MeteoException 
	 */
	public double getTempPercMax() throws MeteoException {
		if(!trovato(TempPercMax))
			throw new MeteoException("Assenza di campioni");
		else
			return TempPercMax;
	}

	/**
	 * @return il minimo della TemperaturaPercepita
	 * @throws MeteoException 
	 */
	public double getTempPercMin() throws MeteoException {
		if(!trovato(TempPercMin))
			throw new MeteoException("Assenza di campioni");
		else
			return TempPercMin;
	}
	
	/**
	 * Metodo per effettuare arrotondamenti a due cifre decimali su tipi double
	 * @param val Valore da arrotondare
	 * @return the rounded value
	 */
	public double round(double val) {
		int rounder = (int) (val*100.0);
		return (double)rounder/100;
	}
	

	
	/**
	 * @return la media della Temperatura 
	 * @throws MeteoException 
	 */
	public double getMedia() throws MeteoException {
		if(!trovato(accumulatore))
			throw new MeteoException("Assenza di campioni");
		else
			media = round(accumulatore/contatore);
			return media;
	}
	
	/**
	 * @return la media della TemperaturaPercepita
	 * @throws MeteoException 
	 */
	public double getMedia2() throws MeteoException {
		if(!trovato(accumulatore2))
			throw new MeteoException("Assenza di campioni");
		else
			media2 = round(accumulatore2/contatore);

			return media2;
	}
	
	/**
	 * @return la varianza delle Temperature
	 * @throws MeteoException
	 */
	public Double getVarianza() throws MeteoException {
		if(TempMax==0.0)
			throw new MeteoException("Assenza di campioni");
		else {
			Double media = this.getMedia();
			Double temp = 0.0;
			for (Double dato : datiTemp) {
				temp += Math.pow((dato - media), 2);
			}
			varianza = round(temp/this.contatore - 1);
			return varianza;
		}
	}
	
	/**
	 * @return la varianza delle TemperaturePercepite
	 * @throws MeteoException 
	 */
	public Double getVarianza2() throws MeteoException {
		if(TempPercMax==0.0)
			throw new MeteoException("Assenza di campioni");
		else {
			Double media = this.getMedia2();
			Double temp = 0.0;
			for (Double dato : datiTempPerc) {
				temp += Math.pow((dato - media), 2);
			}
			varianza2 = round(temp/this.contatore - 1);
			return varianza2;
		}
	}
	/**
	 * 
	 * @param media
	 */
	public void setMedia(double media) {
		this.media = media;
	}
    /**
     * 
     * @param media2
     */
	public void setMedia2(double media2) {
		this.media2 = media2;
	}
    /**
     * 
     * @param varianza
     */
	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}
    /**
     * 
     * @param varianza2
     */
	public void setVarianza2(double varianza2) {
		this.varianza2 = varianza2;
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
     * @return id
     */
	public Integer getId() {
		return id;
	}
    /**
     * 
     * @param id
     */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return path
	 */
	public String getPath() {
		return path;
	}
    /**
     * 
     * @param path
     */
	public void setPath(String path) {
		this.path = path;
	}
    /**
     * 
     * @return path2
     */
	public String getPath2() {
		return path2;
	}
    /**
     * 
     * @param path2
     */
	public void setPath2(String path2) {
		this.path2 = path2;
	}

}
