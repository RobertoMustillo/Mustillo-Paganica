# Mustillo-Paganica
# Weather
##  **Cosa puoi fare**
* [Introduzione](#intro)
* [Configurazione](#config)
* [Installazione](#install)
* [Diagrammi UML](#UML)
* [Rotte](#rotte)
* [Come si usa](#uso)
* [Formato dei dati restituiti](#formato)
* [Test](#test)
* [Software utilizzati](#software)
* [Autori](#Autori)


<a name="intro"></a>
##  Introduzione
Il seguente programma "Weather" implementa un servizio meteo che visualizza tutte le informazioni attuali relative alla temperatura e alle condizioni meteo delle città richieste, le relative previsioni per i giorni successivi, genera delle statistiche sulle condizioni meteo nel tempo come temperatura massima, minima, media e varianza e sulla quantità di previsioni azzeccate, in base ad una soglia di errore. 
In conclusione "Weather" (applicativo  RESTful Web Service) è in grado di verificare se le previsioni di un servizio meteo come https://openweathermap.org/ siano corrette esclusivamente per scopo didattico.

<a name="config"></a>
##  Configurazione
Per utilizzare l'applicazione sono necessari due file come nel caso mostrato: "JSONConfig.txt" e "correnti.txt" scaricabili  da questo servizio implementato  [Archivio](https://github.com/RobertoMustillo/Mustillo-Paganica/blob/master/weather/src/main/java/it/mustillopaganica/weather/utilities/Archivio.java) .
Il file "JSONConfig.txt" è un archivio contenente tutte le condizioni previsionali relative al meteo salvate dal 14-01-2021 15:00:00 al 19-01-2021 12:00:00. Il file "correnti" invece contiene le informazioni attuali da cui noi generiamo le statistiche confrontando i due file. Verificando, cioè, se le previsioni del 1° file (es."JSONConfig.txt")sono azzeccate rispetto a quelle del 2° file (es."correnti.txt").
Infine c'è bisogno del file "citta.txt" dove sono presenti le città di cui si vuole fare le statistiche, nel caso mostrato si può scegliere tra:
- Termoli
-  Ancona
- Milano
- Bergamo
- Napoli
- Benevento
- Torino
<a name="install"></a>
##  Installazione
Per intallare l'applicazione Weather digita sul Prompt dei Comandi:
```
git clone https://github.com/RobertoMustillo/Mustillo-Paganica
```

<a name="uml"></a>
# UML
## Use Case Diagram
<img src = "https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/Mustillo-Paganica%20Use%20Case%20Diagram.png"/>

## Class Diagram
<img src ="https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/Mustillo-Paganica%20Class%20Diagram1.png"/>

<a name="rotte"></a>
#  Rotte
Le richieste che l'utente può effettuare vanno eseguite tramite Postman ai seguenti indiritti in ---- localhost:8080 ----

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/data/{Milano}/{kelvin}` | *restituisce un JSONArray contenente le informazioni della città con l'unità di misura richiesta relative alla temperatura e alle condizioni meteo per i successivi giorni.*
[2](#2) | ` GET ` | `/data?citta=Pescara&units=metric` | *restituisce un JSONArray contenente le informazioni della città con l'unità di misura richiesta relative alla temperatura e alle condizioni meteo per i successivi giorni.*
[3](#3) | ` GET ` | `/tempo?citta=Ancona` | *restituisce un JSONArray contenente le informazioni della città richiesta relative alle condizioni meteo per i successivi giorni.*
[4](#4) | ` GET ` | `/metadata` | *restituisce un JSONArray contenente le informazioni delle città presenti nell'archivio nel periodo scaricato.*
[5](#5) | ` POST ` | `/data` | *restituisce un JSONArray contenente le informazioni della città con l'unità di misura richiesta nel body relative alla temperatura e alle condizioni meteo per i successivi giorni.*
[6](#6) | ` POST ` | `/filter` | *consente di effettuare un filtro del periodo in modo da restituire un JSONArray contenente le informazioni della città con l'unità di misura richiesta nel body relative alla temperatura e alle condizioni meteo per il solo periodo voluto.*
[7](#7) | ` POST ` | `/stats` | *consente di effettuare statistiche riguardanti valori minimi, massimi, media e varianza di temperature reali e percepite della città chiesta nel body.*
[8](#8) | ` POST ` | `/previsioni` | *consente di effettuare statistiche sulla quantità di previsioni azzeccate, in base ad una soglia di errore. Filtraggio modificando la soglia di errore.*
<a name="uso"></a>
# Come si usa
Per avere una corretta risposta bisogna effettuare le richieste in questo modo:
<a name="1"></a>
###  1. /data/{città}/{misurazione} 
Questa rotta permette di ottenere la temperatura e le condizioni meteo di una qualsiasi città con la misurazione voluta (kelvin, metric, imperial).
Le richieste vanno inserite nel path all'interno delle {-->x<--}.
<a name="2"></a>
###  2. /data?citta=Pescara&units=metric
Questa rotta permette di ottenere la temperatura e le condizioni meteo di una qualsiasi città con la misurazione voluta (kelvin, metric, imperial).
Le richieste vanno inserite come parametri.
<a name="3"></a>
###  3. /tempo?citta=Pescara
In questa rotta puoi scegliere una qualsiasi città.
La richiesta va inserita come parametro.
<a name="5"></a>
###  5. /data
Questa rotta permette di ottenere la temperatura e le condizioni meteo di una qualsiasi città con la misurazione voluta (kelvin, metric, imperial).
La richiesta va inserita nel body in questo modo
![alt_text](https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/Data.png)

<a name="6"></a>
###  6. /filter
Questa rotta permette di filtrare il periodo della richiesta ottendento la temperatura e le condizioni meteo di una qualsiasi città con la misurazione voluta (kelvin, metric, imperial).
La richiesta va inserita nel body in questo modo
![alt_text](https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/Filter.jpg)
<a name="7"></a>
###  7. /stats
Questa rotta permette di ottenere le statistiche della citta richiesta nel body in questo modo
![alt_text](https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/stats.jpg)

Infatti inserendo una città che non è presente nell'archivio verrà generato un messaggio di **errore**.
![alt_text](https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/errori.png)
<a name="8"></a>
###  8. /previsioni
Questa rotta permette di ottenere le statistiche sulle previsioni azzeccate di una citta. E' possibile filtrare una soglia di errore in base alla quale il programma verifica la quantità delle temperature azzeccate. La richiesta va inserita nel body in questo modo
![alt_text](https://raw.githubusercontent.com/RobertoMustillo/Mustillo-Paganica/master/previsioni.jpg)
<a name="formato"></a>
# Formato dei dati restituiti
In seguito ad una richiesta al servizio viene restituito come risultato un JSON rappresentante un array di oggetti rappresentanti i dati appartenenti al dataset. 

Il formato dell'oggetto rappresentante **l'archivio**, nello specifico è il seguente:
```	                          
[
	{
	"epoch":  "2021-01-14 15:00:00",
	"units":  "metric",
	"citta":  "Comune di Termoli",
	"temperatura":  11.62,
	"umidita":  59,
	"temperaturaMassima":  11.62,
	"temperaturaPercepita":  6.28,
	"temperaturaMinima":  11.57
	},
	....
	{
	"epoch":  "2021-01-14 18:00:00",
	"units":  "metric",
	"citta":  "Comune di Termoli",
	"temperatura":  10.13,
	"umidita":  83,
	"temperaturaMassima":  10.13,
	"temperaturaPercepita":  2.81,
	"temperaturaMinima":  9.7
	}
]
```
Significato dei campi della risposta ottenuta da Weather:
<ul>
	<li><code>epoch </code> Stringa della data </li>
	<li><code>units</code> Stringa dell'unità di misura.  (Kelvin, Metric: Celsius, Imperial: Fahrenheit).</li>
	<li><code>temperatura</code> Temperatura</li>
	<li><code>umidita</code> % </li>
</ul>

Il formato dell'oggetto rappresentante le **previsioni azzeccate**, è il seguente:
```	                          
{
	"id":  2,
	"corrette":  20,
	"soglia":  1.0,
	"eps":  [
			0.83,
			0.81,
			0.91,
			1.25,
			......
			0.95,
			0.64,
			0.81,
			0.89,
			0.43,
			0.7,
			],
	"message":  "Ecco di quanto le previsioni sono state errate (°C)",
	"citta":  "Milano",
	"campione":  41,
	"studiate":  22
}
```
Significato dei campi della risposta ottenuta da Weather:
<ul>
	<li><code>id</code> Id della città che si trova nell'archivio</li>
	<li><code>corrette</code> Numero temperature corrette in base alla soglia scelta</li>
	<li><code>soglia</code> Soglia di tolleranza per una temperatura corretta</li>
	<li><code>eps</code> Array contenente tutti gli errori tra la temperatura predetta e quella corrente </li>
	<li><code>campione</code> Campione dati  nell'archivio</li>
	<li><code>studiate</code> Numero delle temperature di cui è stato possibile fare statistica</li>
</ul>

<a name="test"></a>
# Test
I seguenti [test](https://github.com/RobertoMustillo/Mustillo-Paganica/tree/master/weather/src/test/java/it/mustillopaganica/weather) verificano il corretto funzionamento di alcune eccezioni e se sono presenti i file di config necessari per l'applicazione.

<a name="software"></a>
# Software utilizzati
Per la realizzazione di questo applicativo sono stati utilizzati i seguenti strumenti:

- Il framework [Spring](https://spring.io), implementando nello specifico i moduli:
	- [Spring Web](https://spring.io/guides/gs/serving-web-content/)
	- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools)
- La libreria [JSON.simple](https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm) per la parsificazione, la lettura e la scrittura di oggetti e array in formato JSON
- [Apache Maven](https://maven.apache.org) per la gestione delle dipendenze sia di Spring che di JSONSimple
- [Javadoc](https://www.oracle.com/it/technical-resources/articles/java/javadoc-tool.html) per la generazione automatica della documentazione del codice sorgente scritto in linguaggio Java
- Il framework [JUnit5](https://junit.org/junit5/) per lo unit testing
- L'applicativo [Postman](https://www.postman.com) per richiamare e testare le API esposte dal nostro servizio
- I sistemi [Git](https://git-scm.com) e [GitHub](https://github.com) per il versioning del codice
- L'IDE [Eclipse](https://www.eclipse.org/downloads/) per lo sviluppo di tutto l'applicativo scritto in java

<a name="autor"></a>
# Autori
- [Roberto Mustillo](https://github.com/RobertoMustillo) - Contributo 60%
- [Aldo Paganica](https://github.com/AldoPaganica) - Contributo 40%