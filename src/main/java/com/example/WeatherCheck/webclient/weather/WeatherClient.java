package com.example.WeatherCheck.webclient.weather;

import com.example.WeatherCheck.model.Forecast;
import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.webclient.weather.forecastDTO.OpenWeatherWeatherDto;
import com.example.WeatherCheck.webclient.weather.weatherDTO.OpenWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "";
    private RestTemplate restTemplate = new RestTemplate();


    public Weather getWeatherForOneCity(String city) {
        OpenWeatherDto openWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric", OpenWeatherDto.class, city, API_KEY);
        return Weather.builder()
                .temperature(openWeatherDto.getMain().getTemp())
                .feels_like(openWeatherDto.getMain().getFeels_like())
                .pressure(openWeatherDto.getMain().getPressure())
                .humidity(openWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();
    }

    public List<Forecast> getForecast(double lat, double lon) {
        OpenWeatherWeatherDto openForecastDto = callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric", OpenWeatherWeatherDto.class,
                lat,
                lon,
                API_KEY);
        List<Forecast> forecastList = new ArrayList<>();
        for (int days = 0; days<=7; days++) {
            Forecast forecast = Forecast.builder()
                    .sunrise(openForecastDto.getDaily().get(days).getSunrise())
                    .sunset(openForecastDto.getDaily().get(days).getSunset())
                    .dayTemperature(openForecastDto.getDaily().get(days).getTemp().getDay())
                    .nightTemperature(openForecastDto.getDaily().get(days).getTemp().getNight())
                    .dayTempFeelsLike(openForecastDto.getDaily().get(days).getFeels_like().getDay())
                    .nightTempFeelsLike(openForecastDto.getDaily().get(days).getFeels_like().getNight())
                    .pressure(openForecastDto.getDaily().get(days).getPressure())
                    .humidity(openForecastDto.getDaily().get(days).getHumidity())
                    .windSpeed(openForecastDto.getDaily().get(days).getWind_speed())
                    .build();
            forecastList.add(forecast);
        }
        return forecastList;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
