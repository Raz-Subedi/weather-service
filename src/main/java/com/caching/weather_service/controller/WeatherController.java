package com.caching.weather_service.controller;

import com.caching.weather_service.entity.Weather;
import com.caching.weather_service.repository.WeatherRepository;
import com.caching.weather_service.service.CacheInspectionService;
import com.caching.weather_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired
    CacheInspectionService cacheInspectionService;

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

    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("weather");
    }

    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city,@RequestParam String weatherUpdate){
        return weatherService.updateWeather(city,weatherUpdate);
    }
    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city){
        weatherService.deleteWeather(city);
        return "Weather dara for "+ city +" has been deleted and cache evicted.";
    }
}
