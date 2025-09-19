Act2_APIs

Debe installar las exenciones a coninuacion:

1. Language Support for Java(TM) by Red Hat
2. Maven for Java

De click izquierdo (el de la derecha que abre comandos como copiar y pegar) en el archivo "HelloWorldApplication.java"

El archivo se encentra en la ruta src\main\java\com\example\demo

Despues seleccionar la opcion "Run Proyect Without Debugging" para correr el programa de manera local

Se puede probar su funcionamiento en Postman con: http://localhost:8080/weather/London

Deberia aparecer lo siguiente:

{"coord":{"lon":-0.1278,"lat":51.5074},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"base":"stations","main":{"temp":16.69,"feels_like":16.71,"temp_min":15.53,"temp_max":17.29,"pressure":1021,"humidity":88,"sea_level":1021,"grnd_level":1016},"visibility":10000,"wind":{"speed":2.57,"deg":210},"clouds":{"all":100},"dt":1758239943,"sys":{"type":2,"id":2075535,"country":"GB","sunrise":1758260514,"sunset":1758305209},"timezone":3600,"id":2643743,"name":"London","cod":200}