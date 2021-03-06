package it.mustillopaganica.weather.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.mustillopaganica.weather.exceptions.MeteoException;
import it.mustillopaganica.weather.model.CondizioniMeteo;
import it.mustillopaganica.weather.model.Data;
import it.mustillopaganica.weather.model.Previsione;
import it.mustillopaganica.weather.model.Stats;
import it.mustillopaganica.weather.service.MeteoParser;
import it.mustillopaganica.weather.service.ParserCondizioniMeteo;
import it.mustillopaganica.weather.service.Period;

/**
 * @author rbtms
 * @author aldop
 */
@Service
public class MeteoServiceImpl implements MeteoService{
	private Map<String, Vector<Data>> meteoRepo = new HashMap<>();
	private Map<String, Vector<CondizioniMeteo>> statsRepo = new HashMap<>();

	public MeteoServiceImpl() {
		
	}
	
	@Override
	public void createMeteo(Data meteo) {
		
		if(meteoRepo.containsKey(meteo.getCitta()) && meteoRepo.containsKey(meteo.getUnits())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Citta esistente...");
		}
		meteoRepo.clear();
		MeteoParser m = new MeteoParser(meteo.getCitta());
		m.setUnits(meteo.getUnits());
		m.parser();
		meteoRepo.put(meteo.getCitta(), m.getArr());
		
	}
	
	/*
	 * Riempie la Map con i dati dell'archivio
	 */
	public void getArchivio() {
		meteoRepo.clear();
		Statistiche statistiche = new Statistiche();
		statistiche.metadata();
		meteoRepo.put(statistiche.getEpoch(), statistiche.getArr());
		
		
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

	//metodo usato dal controller per filtrare il periodo richiesto!
		@Override
		public void getFilter(Filter fil) throws MeteoException{
			meteoRepo.clear();
			MeteoParser m = new MeteoParser(fil.getCitta());
			m.setUnits(fil.getUnits());
			m.parser();
			if(m.dataPresente(fil.getFrom()) && m.dataPresente(fil.getTo())) { //se la data è presente 
																			//effettua un parser filtrato			
				Period period = new Period(fil.getCitta());
				period.filter.setFrom(fil.getFrom());
				period.filter.setTo(fil.getTo());
				period.setUnits(fil.getUnits());
				period.parser();
				meteoRepo.put(period.getCitta(), period.getArr());
			}
			else throw new MeteoException("data non presente");
		}
		
		@Override
		public Stats getStats(Stats body) throws MeteoException{
			meteoRepo.clear();
			Statistiche statistiche = new Statistiche();
			statistiche.getSTATS();

			body.setTempMax(statistiche.getTempMax());
			body.setTempMin(statistiche.getTempMin());
			body.setTempPercMax(statistiche.getTempPercMax());
			body.setTempPercMin(statistiche.getTempPercMin());
			body.setMedia(statistiche.getMedia());
			body.setMediaPercepita(statistiche.getMedia2());
			body.setVarianza(statistiche.getVarianza());
			body.setVarianzaPercepita(statistiche.getVarianza2());
			
			if(!(statistiche.cittaPresente(body.getCitta()))) {

				body.setMessage("ATTENZIONE---Puoi scegliere una tra queste città: "
						+ "Termoli,Ancona,Milano,Bergamo,Napoli,Benevento,Torino");
				body.setTempMax(0);
				body.setTempMin(0);
				body.setTempPercMax(0);
				body.setTempPercMin(0);
				body.setMedia(0);
				body.setMediaPercepita(0);
				body.setVarianza(0);
				body.setVarianzaPercepita(0);
			}
			else 
				body.setMessage("Ecco le statistiche delle tue città!");
				return body;
		}
		
		@Override
		public Previsione statsPrevisione(Previsione previsione ) throws MeteoException {
			meteoRepo.clear();
			Statistiche statistiche = new Statistiche();
			statistiche.setId(previsione.getId());
			statistiche.getSTATS();
			previsione.setEps(statistiche.correnti());
			
			

			if(!(statistiche.cittaPresente(previsione.getCitta()))) {

				previsione.setMessage("ATTENZIONE---Puoi scegliere una tra queste città: "
						+ "Termoli,Ancona,Milano,Bergamo,Napoli,Benevento,Torino");
				previsione.setEps(null);
				previsione.setId(null);

			}
			else {
				previsione.setMessage("Ecco di quanto le previsioni sono state errate (°C)");
				previsione.setCorrette(statistiche.azzeccate(previsione.getSoglia()));
			}
				return previsione;
			
		}
	//metodo usato dal controller per passare al GET la citta per le stats!
		@Override
		public void getStatsCitta(String citta) {
			statsRepo.clear();
			ParserCondizioniMeteo p = new ParserCondizioniMeteo(citta);
			p.parser();
			statsRepo.put(p.getCitta(), p.getStats());
		}
		
		@Override
		public Collection<Vector<Data>> getData() {
			return meteoRepo.values();
		}
		
		@Override
		public Collection<Vector<CondizioniMeteo>> getDataStats(){
			return statsRepo.values();
		}
	
}

