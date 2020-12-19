package it.mustillopaganica.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SalvaFile {
	
	private JSONArray ja = null;
	
	public SalvaFile() {
		this.ja = new JSONArray();
	}
	
	public JSONArray getArray() {
		return ja;
	}

	public void setArray(JSONArray ja) {
		this.ja = ja;
	}
	
	public void parser(JSONObject main) {
		this.ja.add(main);
	}

	public void salvaFile(String nome_file) {
		try {
			PrintWriter file_output = new PrintWriter(new BufferedWriter(new FileWriter(nome_file)));
			
			file_output.println(this.ja);
			
			file_output.close();
			System.out.println("File salvato");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
