package com.provinciaseguros.weatherexercise.exceptions;

public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException(String message) {
        super(message);
    }

    public WeatherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
