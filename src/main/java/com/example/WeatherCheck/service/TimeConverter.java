package com.example.WeatherCheck.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {

    public static String convertTime(String localDateTime) {

        Date date = new Date(Long.parseLong(localDateTime) * 1000);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1"));

        return dateFormat.format(date);
    }

}
