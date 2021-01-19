package it.mustillopaganica.weather.utilities;

import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.mustillopaganica.weather.model.Data;

/**
 * Classe necessaria per la conversione file
 * @author rbtms
 */
public class ParsingJSON {
	/**
	 * Metodo statico che passato il vector dei data , lo converta nel formato JSON.
	 * @param array Vettore contenente i dati del meteo.
	 * @return outFinal Contiene il nostro Vector convertito nel formato JSON, in modo che il web server possa conprenderlo.
	 */
	public static String ParsingToJSON(Vector<Data> array)
	{
		Gson out = new GsonBuilder().setPrettyPrinting().create();
		String outFinal = out.toJson(array);
		return outFinal;
	}
}
