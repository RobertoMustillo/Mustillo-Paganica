package it.mustillopaganica.weather.utilities;

import java.util.Collection;

import it.mustillopaganica.weather.model.Data;


public interface MeteoService {
	public abstract void createMeteo(Data meteo);
	public abstract Collection<Data> getData();

}