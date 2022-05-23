package com.example.WeatherCheck.controller;

import com.example.WeatherCheck.model.Forecast;
import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public Weather getWeather(){
        return weatherService.getWeather("dublin");
    }

    @GetMapping("/forecast")
    public List<Forecast> getForecast() {
        return weatherService.getForecast(50.05,19.94);
    }

}
