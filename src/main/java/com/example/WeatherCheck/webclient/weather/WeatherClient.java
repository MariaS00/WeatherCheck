package com.example.WeatherCheck.webclient.weather;

import com.example.WeatherCheck.model.Weather;
import com.example.WeatherCheck.webclient.weather.dto.OpenWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    public OpenWeatherDto getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apikey}&units=metric", OpenWeatherDto.class,
                lat,
                lon,
                API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
