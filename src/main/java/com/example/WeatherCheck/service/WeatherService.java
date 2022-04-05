package com.example.WeatherCheck.service;

import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.webclient.weather.WeatherClient;
import com.example.WeatherCheck.webclient.weather.dto.OpenWeatherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public Weather getWeather(){
        return weatherClient.getWeatherForOneCity("dublin");
    }


}
