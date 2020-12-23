package it.mustillopaganica.weather.utilities;

import java.util.Collection;

import it.mustillopaganica.weather.model.Data;


public interface MeteoService {
	public abstract void createMeteo(Data meteo);
	public abstract void getDataCittaUnits(String citta, String units);
	public abstract void getDataUnits(String units);
	public abstract void getDataCitta(String q);
	public abstract Collection<Data> getData();

}