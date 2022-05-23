package com.example.WeatherCheck.webclient.weather.forecastDTO;

import lombok.Getter;


@Getter
public class OpenWeatherDailyDto {

    private String sunrise;
    private String sunset;
    private OpenTempDto temp;
    private OpenFeelsLikeDto feels_like;
    private long pressure;
    private long humidity;
    private double wind_speed;


}
