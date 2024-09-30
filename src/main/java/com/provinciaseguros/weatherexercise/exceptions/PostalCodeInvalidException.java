package com.provinciaseguros.weatherexercise.exceptions;

public class PostalCodeInvalidException extends RuntimeException {

    public PostalCodeInvalidException(String message) {
        super(message);
    }

    public PostalCodeInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
