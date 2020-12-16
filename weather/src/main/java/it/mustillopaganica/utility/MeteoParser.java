/**
 * 
 */
package it.mustillopaganica.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public class MeteoParser extends MeteoClass {
		/**
		 * Description of the property MeteoJsonArray.
		 */
		private JSONObject jo = null;
		private JSONArray  ja = null;

		public MeteoParser(String Citta, double temp, double tempMin, double tempMax, int umidita, double tempReale, double tempPerc, double media, double varianza) {
			super(Citta,temp,tempMin,tempMax,umidita,tempReale,tempPerc,media,varianza);
			this.ja = new JSONArray();
		}
		/**
		 * Description of the method getArray.
		 */
		public JSONArray getArray() {
			// Start of user code for method getArray
			// End of user code
			return ja;
		}

		/**
		 * Description of the method setArray.
		 * @param  
		 */
		public void setArray(JSONArray MeteoJsonArray ) {
			// Start of user code for method setArray
			// End of user code
			this.ja = MeteoJsonArray;
		}

		/**
		 * Description of the method salvaFile.
		 * @param nome_file 
		 */
		public void salvaFile(String nome_file) {
			// Start of user code for method salvaFile
			// End of user code
		}

		/**
		 * Description of the method caricaFile.
		 * @param nome_file 
		 */
		public void caricaFile(String nome_file) {
			// Start of user code for method caricaFile
			// End of user code
		}

		/**
		 * Description of the method chiamataAPI.
		 * @param url 
		 */
		public void chiamataAPI(String url, boolean isObject) {
			try {
				URLConnection openConnection = new URL(url).openConnection();
				InputStream in = openConnection.getInputStream();
				
				String data = "";
				String line = "";
				try {
				   InputStreamReader inR = new InputStreamReader( in );
				   BufferedReader buf = new BufferedReader( inR );
				  
				   while ( ( line = buf.readLine() ) != null ) {
					   data+= line;
				   }
				} finally {
				   in.close();
				}
				//System.out.println("Dati scaricati: "+data);
				if(isObject) {
					this.jo = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
					System.out.println("JSONObject scaricato: "+ this.jo);
				} else {
					this.ja = (JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
					System.out.println("JSONArray scaricato: "+ this.ja);
					System.out.println("IL JSONArray scaricato ha "+ this.ja.size()+" elementi:");
				
					for(int i=0;i<this.ja.size();i++) {
						JSONObject jo = (JSONObject) this.ja.get(i);
						System.out.println(i+") "+jo.get("title"));
					}
				}
					
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Start of user code (user defined methods for MeteoParser)

		// End of user code
		/**
		 * Returns MeteoJsonArray.
		 * @return MeteoJsonArray 
		 */
		public JSONArray getMeteoJsonArray() {
			return this.ja;
		}

		/**
		 * Sets a value to attribute MeteoJsonArray. 
		 * @param newMeteoJsonArray 
		 */
		public void setMeteoJsonArray(JSONArray newMeteoJsonArray) {
			this.ja = newMeteoJsonArray;
		}

	}
