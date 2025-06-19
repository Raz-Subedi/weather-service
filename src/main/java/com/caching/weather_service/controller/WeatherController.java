package com.caching.weather_service.controller;

import com.caching.weather_service.entity.Weather;
import com.caching.weather_service.repository.WeatherRepository;
import com.caching.weather_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping
    public String getWeather(@RequestParam String city){
        String weatherByCity = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
        return weatherRepository.save(weather);
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather(){
        return weatherRepository.findAll();
    }
}
