package it.mustillopaganica.weather.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.service.MeteoParser;

/**
 * @author rbtms
 * @author aldop
 * @Component annotazione che definisce la classe come componente autogestito da Spring
 */
@Component
public class Archivio {
	
public static Vector<String> citta = new Vector<String>();
	
	@SuppressWarnings("resource")
	public static Vector<String> popola(){
		
		try {
			
			BufferedReader read = new BufferedReader(new FileReader("citta.txt"));
			
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
	
	public static void ScriviFile(Vector<Data> v, String nomefile) {
		try{
			BufferedWriter write =
					new BufferedWriter (new FileWriter (nomefile+".txt"));
			write.write(v.toString());
			write.close();
			}catch (Exception ex){
				ex.printStackTrace();;
			}
        }
	
	@Scheduled(fixedRate=10080*60*1000)
	public static void download() {
		for(String c: citta) {
			MeteoParser m = new MeteoParser(c);
			m.parser();
			ScriviFile(m.getArr(),"archivio");
		}
	}
	
	
}
