# Mustillo-Paganica
Il seguente programma implementa un servizio meteo che visualizza tutte le informazioni attuali relative alla temperatura e alle condizioni meteo delle città richieste, e le relative previsioni per i giorni successivi e infine genera delle statistiche sulle condizioni meteo nel tempo.

## Formato dei dati restituiti
In seguito ad una richiesta al servizio viene restituito come risultato un JSON rappresentante un array di oggetti rappresentanti i dati appartenenti al dataset. Il formato dell'oggetto rappresentante il singolo elemento, nello specifico è il seguente:
```
	                          
{
   "list":[
      {
         "dt":1487246400,
         "main":{
            "temp":286.67,
            "temp_min":281.556,
            "temp_max":286.67,
            "media":222.73,
            "varianza":654.46,
            "temp_real":270.73,
            "humidity":75,
            "temp_perc":275.11
         },
         "weather":[
            {
               "id":800,
               "main":"Clear",
               "description":"clear sky",
               "icon":"01d"
            }
         ],
         "clouds":{
            "all":0
         },
         "wind":{
            "speed":1.81,
            "deg":247.501
         },
         "sys":{
            "pod":"d"
         },
         "dt_txt":"2017-02-16 12:00:00"
      }
                          

```

# UML
## Use Case Diagram

<img src ="/Mustillo-Paganica Use Case Diagram.png"/>

# UML
## Class Diagram
<img src ="/Mustillo-Paganica Class Diagram1.png"/>

# Autori

- [Roberto Mustillo](https://github.com/RobertoMustillo) - Contributo 50%
- [Aldo Paganica](https://github.com/AldoPaganica) - Contributo 50%
