package com.example.WeatherCheck.webclient.weather.forecastDTO;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenWeatherWeatherDto {

    private List<OpenWeatherDailyDto> daily;
}
