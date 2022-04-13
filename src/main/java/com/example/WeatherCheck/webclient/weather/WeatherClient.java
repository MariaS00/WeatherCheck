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
        Forecast forecast = Forecast.builder()
                .sunrise(openForecastDto.getDaily().get(0).getSunrise())
                .sunset(openForecastDto.getDaily().get(0).getSunset())
                .dayTemperature(openForecastDto.getDaily().get(0).getTemp().getDay())
                .nightTemperature(openForecastDto.getDaily().get(0).getTemp().getNight())
                .dayTempFeelsLike(openForecastDto.getDaily().get(0).getFeels_like().getDay())
                .nightTempFeelsLike(openForecastDto.getDaily().get(0).getFeels_like().getNight())
                .pressure(openForecastDto.getDaily().get(0).getPressure())
                .humidity(openForecastDto.getDaily().get(0).getHumidity())
                .windSpeed(openForecastDto.getDaily().get(0).getWind_speed())
                .build();

        return new ArrayList<>();
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
