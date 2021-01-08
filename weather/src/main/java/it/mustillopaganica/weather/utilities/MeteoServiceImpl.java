package it.mustillopaganica.weather.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.DataStats;
import it.mustillopaganica.weather.service.MeteoParser;
import it.mustillopaganica.weather.service.ParserStats;

/**
 * @author rbtms
 */
@Service
public class MeteoServiceImpl implements MeteoService{
	private Map<String, Vector<Data>> meteoRepo = new HashMap<>();
	private Map<String, Vector<DataStats>> statsRepo = new HashMap<>();

	public MeteoServiceImpl() {}
	
	@Override
	public void createMeteo(Data meteo) {
		// TODO Auto-generated method stub
		if(meteoRepo.containsKey(meteo.getCitta()) && meteoRepo.containsKey(meteo.getUnits())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Citta esistente...");
		}
		meteoRepo.clear();
		MeteoParser m = new MeteoParser(meteo.getCitta());
		m.setUnits(meteo.getUnits());
		m.parser();
		meteoRepo.put(meteo.getCitta(), m.getArr());
		
	}
	
	//metodo usato dal controller per passare al GET la citta e l'unità nel path!
	@Override
	public void getDataCittaUnits(String citta, String units) {
		meteoRepo.clear();
		MeteoParser m = new MeteoParser(citta);
		m.setUnits(units);
		m.parser();
		meteoRepo.put(m.getCitta(), m.getArr());
	}
	
	//metodo usato dal controller per passare al GET la citta per le stats!
		@Override
		public void getStatsCitta(String citta) {
			statsRepo.clear();
			ParserStats p = new ParserStats(citta);
			p.parser();
			statsRepo.put(p.getCitta(), p.getStats());
		}
		
		@Override
		public Collection<Vector<Data>> getData() {
			return meteoRepo.values();
		}
		
		@Override
		public Collection<Vector<DataStats>> getDataStats(){
			return statsRepo.values();
		}
	
}

