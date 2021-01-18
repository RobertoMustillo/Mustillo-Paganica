package it.mustillopaganica.weather.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.mustillopaganica.weather.service.MeteoParser;

/**
 * @author rbtms
 * @author aldop
 * @Component annotazione che definisce la classe come componente autogestito da Spring
 */
@Component
@Service
public class Archivio {
	
public static Vector<String> citta = new Vector<String>();

private static String path = "citta.txt";


/*
 * Vettore che raccoglie i dati delle citta dell'archivio
 * sotto forma di JSONArray
 */
public static Vector<JSONArray> meteoRepo = new Vector<JSONArray>();

	@SuppressWarnings("resource")
	public static Vector<String> popola(){
		
		try {
			
			BufferedReader read = new BufferedReader(new FileReader(path));
			
			String city = read.readLine();
			while(city != null) {
				citta.add(city);
				city=read.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return citta;
	}
	
	public static void ScriviFile(Collection<JSONArray> collection, String nomefile) {
		try{
			BufferedWriter write =
					new BufferedWriter (new FileWriter (nomefile+".txt"));
			write.write(collection.toString());
			write.close();
			}catch (Exception e){
				e.printStackTrace();;
			}
        }
	
	@Scheduled(fixedRate=10080*60*1000) // scarica il meteo ogni ora
	public static void download() throws ParseException {
		for(String c: citta) {
			MeteoParser m = new MeteoParser(c);
			m.parser();
			meteoRepo.add(m.getJsonArray());

		}
		ScriviFile(meteoRepo,"file");

	}
	
	
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Archivio.path = path;
	}
	
}
