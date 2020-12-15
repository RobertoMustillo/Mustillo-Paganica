/**
 * 
 */
package it.mustillopaganica.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public class MeteoParser extends MeteoClass {
		/**
		 * Description of the property MeteoJsonArray.
		 */
		private JSONArray MeteoJsonArray = null;

		// Start of user code (user defined attributes for MeteoParser)

		// End of user code

		public MeteoParser() {
			this.MeteoJsonArray = new JSONArray();
		}
		/**
		 * Description of the method getArray.
		 */
		public JSONArray getArray() {
			// Start of user code for method getArray
			// End of user code
			return MeteoJsonArray;
		}

		/**
		 * Description of the method setArray.
		 * @param  
		 */
		public void setArray(JSONArray MeteoJsonArray ) {
			// Start of user code for method setArray
			// End of user code
			this.MeteoJsonArray = MeteoJsonArray;
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
		public void chiamataAPI(String url) {
			// Start of user code for method chiamataAPI
			// End of user code
		}

		// Start of user code (user defined methods for MeteoParser)

		// End of user code
		/**
		 * Returns MeteoJsonArray.
		 * @return MeteoJsonArray 
		 */
		public JSONArray getMeteoJsonArray() {
			return this.MeteoJsonArray;
		}

		/**
		 * Sets a value to attribute MeteoJsonArray. 
		 * @param newMeteoJsonArray 
		 */
		public void setMeteoJsonArray(JSONArray newMeteoJsonArray) {
			this.MeteoJsonArray = newMeteoJsonArray;
		}

	}
