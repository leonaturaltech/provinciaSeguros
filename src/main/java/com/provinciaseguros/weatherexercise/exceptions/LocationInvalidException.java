package com.provinciaseguros.weatherexercise.exceptions;

public class LocationInvalidException extends RuntimeException {

    public LocationInvalidException(String message) {
        super(message);
    }

    public LocationInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
