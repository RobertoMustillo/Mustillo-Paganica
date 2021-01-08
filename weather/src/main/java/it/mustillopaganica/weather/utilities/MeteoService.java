package it.mustillopaganica.weather.utilities;

import java.util.Collection;
import java.util.Vector;

import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.DataStats;


public interface MeteoService {
	public abstract void createMeteo(Data meteo);
	public abstract void getDataCittaUnits(String citta, String units);
	public abstract void getStatsCitta(String citta);
	public abstract void updateMeteo(Data meteo);
	public abstract Collection<Vector<Data>> getData();
	public abstract Collection<Vector<DataStats>> getDataStats();
}