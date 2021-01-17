package it.mustillopaganica.weather.utilities;

import java.util.Collection;
import java.util.Vector;

import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.DataStats;
import it.mustillopaganica.weather.model.Previsione;
import it.mustillopaganica.weather.model.Stats;

/**
 * Questa è l'interfaccia di MeteoServiceImpl e contiene i metodi richiamati dal controller
 * @author aldop
 * @author rbtms
 * 
 *
 */
public interface MeteoService {
	public abstract void createMeteo(Data meteo);
	public abstract void getDataCittaUnits(String citta, String units);
	public abstract void getStatsCitta(String citta);
	public abstract void getFilter(Filter filter) throws MeteoException;
	public abstract Stats getStats(Stats body) throws MeteoException;
	public abstract Previsione statsPrevisione(Previsione previsione ) throws MeteoException;
	public abstract Collection<Vector<Data>> getData();
	public abstract Collection<Vector<DataStats>> getDataStats();
}