package com.example.WeatherCheck.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Forecast {

    private long sunrise;
    private long sunset;
    private double dayTemperature;
    private double nightTemperature;
    private double dayTempFeelsLike;
    private double nightTempFeelsLike;
    private long pressure;
    private long humidity;
    private double windSpeed;

}
