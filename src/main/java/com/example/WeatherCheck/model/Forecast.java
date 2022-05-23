package com.example.WeatherCheck.model;

import lombok.Builder;
import lombok.Getter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@Getter
@Builder
public class Forecast {

    private String sunrise;
    private String sunset;
    private double dayTemperature;
    private double nightTemperature;
    private double dayTempFeelsLike;
    private double nightTempFeelsLike;
    private long pressure;
    private long humidity;
    private double windSpeed;

}
