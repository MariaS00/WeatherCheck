package com.example.WeatherCheck.service;

import com.example.WeatherCheck.model.Forecast;
import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.webclient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public Weather getWeather(String city) {
        return weatherClient.getWeatherForOneCity(city);
    }

    public List<Forecast> getForecast(double lat, double lon) {
        return weatherClient.getForecast(lat, lon);
    }

}
