package com.caching.weather_service.service;

import com.caching.weather_service.entity.Weather;
import com.caching.weather_service.repository.WeatherRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    @Cacheable("weather")
    public String getWeatherByCity(String city){
        System.out.println("Fetching data from Db for city: " +city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return  weather.map(Weather::getForecast).orElse("Weather data not available");

    }
}
