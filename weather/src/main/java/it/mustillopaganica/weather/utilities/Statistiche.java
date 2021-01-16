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

/**
 * @author rbtms
 *
 */
public class Statistiche {

	private double Temperatura, TemperaturaPercepita;
	
	private double TempMax=0.0;

	private double TempMin=0.0;

	private double TempPercMax=0.0;

	private double TempPercMin=0.0;
	
	private double media;
	
	private double media2;

	private double varianza;

	private double varianza2;

	private double contatore=1;

	private double accumulatore;
	
	private double accumulatore2;
	/*
	 *@param Citta indica il giorno da scegliere per le stats:
	 *{ Termoli = 0
	 *	Ancona = 1
	 *	Milano = 2
	 *	Bergamo = 3
	 *	Napoli = 4
	 *	Benevento = 5
	 *	Torino = 6 } 
	 */
	private Integer id=1;

	private Vector<Double> datiTemp = new Vector<Double>();
	
	private Vector<Double> datiTempPerc = new Vector<Double>();

	/**
	 * Costruttore di default
	 */
	public Statistiche() {
		
	}
	
	public void getSTATS() {
		 JSONParser parser = new JSONParser();

	        try (Reader reader = new FileReader("JSONConfig.txt")) {
	        	
	        	JSONArray jArray = (JSONArray) parser.parse(reader);
//	        	for(int i=0; i<jArray.size(); i++) {
	        	
	        	JSONArray jArray2 = (JSONArray) jArray.get(id);
	        	for(Object o : jArray2) {
	        		JSONObject obj = (JSONObject)o;
	        		this.Temperatura = Double.parseDouble(obj.get("Temperatura").toString());
	        		this.TemperaturaPercepita = Double.parseDouble(obj.get("TemperaturaPercepita").toString());

	        		//effettuo delle statistiche
	        		accumulatore  += Temperatura;
	        		accumulatore2 += TemperaturaPercepita;
	        		
	        		datiTemp.add(Temperatura);
	        		datiTempPerc.add(TemperaturaPercepita);
	        		
	        		if(this.Temperatura>TempMax) TempMax = Temperatura;
	        		if(this.Temperatura<TempMin) TempMin = Temperatura;
	        		if(this.TemperaturaPercepita>TempPercMax) TempPercMax = TemperaturaPercepita;
	        		if(this.TemperaturaPercepita<TempPercMin) TempPercMin = TemperaturaPercepita;
	        		contatore++;
	        	
	        		
	        	}
//	        }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	}

	/*
	 * @param x è una variabile che serve per verificare
	 * 			se i dati del campioni sono vuoti
	 * 
	 * @return se il campione è vuoto oppure no
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
	 * @return il massimo della TemperaturaPercepita
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
	public void setMedia(double media) {
		this.media = media;
	}

	public void setMedia2(double media2) {
		this.media2 = media2;
	}

	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}

	public void setVarianza2(double varianza2) {
		this.varianza2 = varianza2;
	}


	
	public double getTemperatura() {
		return Temperatura;
	}

	public void setTemperatura(double temperatura) {
		Temperatura = temperatura;
	}

	public double getTemperaturaPercepita() {
		return TemperaturaPercepita;
	}

	public void setTemperaturaPercepita(double temperaturaPercepita) {
		TemperaturaPercepita = temperaturaPercepita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
