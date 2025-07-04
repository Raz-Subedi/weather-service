package com.caching.weather_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Weather {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String forecast;

//    public Weather() {
//
//    }
//
//    public Weather(Long id, String city, String forecast) {
//        this.id = id;
//        this.city = city;
//        this.forecast = forecast;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
