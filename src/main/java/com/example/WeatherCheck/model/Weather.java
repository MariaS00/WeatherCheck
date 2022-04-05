package com.example.WeatherCheck.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Weather {

    private float temperature;
    private float feels_like;
    private int pressure;
    private int humidity;
    private float windSpeed;

}
