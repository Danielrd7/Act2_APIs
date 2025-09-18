package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final String WEATHER_API  = "https://api.openweathermap.org/data/2.5/weather";
    private final String WEATHER_API2  = "http://api.openweathermap.org/geo/1.0/direct";
    private final String API_KEY      = "5a7876a58dcdee34f7cfd242e8126b33";
    private final String API_KEY2      = "1cf72e2aa3827afc2d268bc06fca99e7";

    @GetMapping()
    public String getMethodName(@RequestParam String latitude, @RequestParam String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String url = WEATHER_API + "?lat=" + latitude + "&lon=" + longitude 
            + "&units=metric" + "&appid=" + API_KEY;
        String result = restTemplate.getForObject(url, String.class);
        if (result != null) {
            return result;
        }    
        return "Error: Unable to fetch weather data.";
    }   

    @GetMapping("/{name}")
    public String climaLocal(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();

        // Llamada a la API de geocoding
        String url2 = WEATHER_API2 + "?q=" + name + "&limit=1&appid=" + API_KEY2;

        // Aquí le decimos a RestTemplate que espere un arreglo de objetos GeocodingResponse
        GeocodingResponse[] geocodeResponse = restTemplate.getForObject(url2, GeocodingResponse[].class);

        if (geocodeResponse == null || geocodeResponse.length == 0) {
            return "Error: City not found.";
        }

        // Tomamos la primera coincidencia
        double latitude = geocodeResponse[0].getLat();
        double longitude = geocodeResponse[0].getLon();

        // Llamada al API del clima
        String url = WEATHER_API + "?lat=" + latitude + "&lon=" + longitude 
                + "&units=metric&appid=" + API_KEY;

        String result = restTemplate.getForObject(url, String.class);

        if (result != null) {
            return result;
        }
        return "Error: Unable to fetch weather data.";
    }
 
}
