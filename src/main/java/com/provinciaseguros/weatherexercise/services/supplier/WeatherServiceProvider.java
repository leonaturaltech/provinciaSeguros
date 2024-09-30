package com.provinciaseguros.weatherexercise.services.supplier;

import com.provinciaseguros.weatherexercise.models.LocationWeather;

public interface WeatherServiceProvider {

    public LocationWeather getWeatherByLatLon(String latLon);
    public LocationWeather getWeatherByPostalCode(String postalCode);
}
