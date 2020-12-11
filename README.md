# Mustillo-Paganica
Implementa un servizio meteo che faccia visualizzare tutte le informazioni attuali relative alla temperatura e alle condizioni meteo, e le relative previsioni per i giorni successivi e infine dovrà generare delle statistiche.

## Formato dei dati restituiti
In seguito ad una richiesta al servizio viene restituito come risultato un JSON rappresentante un array di oggetti rappresentanti i dati appartenenti al dataset. Il formato dell'oggetto rappresentante il singolo elemento, nello specifico è il seguente:
```
	                          
{
   "cod":"200",
   "message":0.0032,
   "cnt":36,
   "list":[
      {
         "dt":1487246400,
         "main":{
            "temp":286.67,
            "temp_min":281.556,
            "temp_max":286.67,
            "pressure":972.73,
            "sea_level":1046.46,
            "grnd_level":972.73,
            "humidity":75,
            "temp_kf":5.11
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
      },
      {
         "dt":1487257200,
         "main":{
            "temp":285.66,
            "temp_min":281.821,
            "temp_max":285.66,
            "pressure":970.91,
            "sea_level":1044.32,
            "grnd_level":970.91,
            "humidity":70,
            "temp_kf":3.84
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
            "speed":1.59,
            "deg":290.501
         },
         "sys":{
            "pod":"d"
         },
         "dt_txt":"2017-02-16 15:00:00"
      },
      {
         "dt":1487268000,
         "main":{
            "temp":277.05,
            "temp_min":274.498,
            "temp_max":277.05,
            "pressure":970.44,
            "sea_level":1044.7,
            "grnd_level":970.44,
            "humidity":90,
            "temp_kf":2.56
         },
         "weather":[
            {
               "id":800,
               "main":"Clear",
               "description":"clear sky",
               "icon":"01n"
            }
         ],
         "clouds":{
            "all":0
         },
         "wind":{
            "speed":1.41,
            "deg":263.5
         },
         "sys":{
            "pod":"n"
         },
         "dt_txt":"2017-02-16 18:00:00"
      },
      ....
      {
         "dt":1487624400,
         "main":{
            "temp":272.424,
            "temp_min":272.424,
            "temp_max":272.424,
            "pressure":968.38,
            "sea_level":1043.17,
            "grnd_level":968.38,
            "humidity":85,
            "temp_kf":0
         },
         "weather":[
            {
               "id":801,
               "main":"Clouds",
               "description":"few clouds",
               "icon":"02n"
            }
         ],
         "clouds":{
            "all":20
         },
         "wind":{
            "speed":3.57,
            "deg":255.503
         },
         "rain":{

         },
         "snow":{

         },
         "sys":{
            "pod":"n"
         },
         "dt_txt":"2017-02-20 21:00:00"
      }
   ],
   "city":{
      "id":6940463,
      "name":"Altstadt",
      "coord":{
         "lat":48.137,
         "lon":11.5752
      },
      "country":"none"
   }
}
                          

```

# UML
## Use Case Diagram

<img src ="/Mustillo-Paganica Use Case Diagram.jpg"/>

# Autori

- [Roberto Mustillo](https://github.com/RobertoMustillo) - Contributo 50%
- [Aldo Paganica](https://github.com/AldoPaganica) - Contributo 50%