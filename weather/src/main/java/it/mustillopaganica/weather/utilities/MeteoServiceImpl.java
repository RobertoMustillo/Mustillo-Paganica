package it.mustillopaganica.weather.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.mustillopaganica.weather.model.Data;


@Service
public class MeteoServiceImpl implements MeteoService{
	private static Map<String, Data> meteoRepo = new HashMap<>();

	public MeteoServiceImpl() {
		// TODO Auto-generated constructor stub
		Data meteo = new Data();
		meteo.getFromMeteoParser("ancona");
		meteoRepo.put(meteo.getCitta(), meteo);
	}
	@Override
	public void createMeteo(Data meteo) {
		// TODO Auto-generated method stub
		if(meteoRepo.containsKey(meteo.getCitta())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Citta esistente...");
		}
		meteo.getFromMeteoParser(meteo.getCitta());
		meteoRepo.put(meteo.getCitta(), meteo);
		
	}

	@Override
	public Collection<Data> getData() {
		// TODO Auto-generated method stub
		return meteoRepo.values();
	}
	
}

