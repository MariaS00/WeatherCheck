package com.example.WeatherCheck.controller;

import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public Weather getWeather(){
        return weatherService.getWeather();
    }
}
