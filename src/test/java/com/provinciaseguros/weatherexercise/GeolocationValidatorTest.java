package com.provinciaseguros.weatherexercise;

import static org.junit.jupiter.api.Assertions.*;

import com.provinciaseguros.weatherexercise.utils.Validations;
import org.junit.jupiter.api.Test;

public class GeolocationValidatorTest {

    @Test
    public void testValidGeolocation() {
        assertTrue(Validations.isValidGeolocation("-34.708729, -58.283100"));
    }

    @Test
    public void testInvalidGeolocationWithoutComma() {
        assertFalse(Validations.isValidGeolocation("-34.708729 -58.283100"));
    }

    @Test
    public void testInvalidGeolocationWithTooManyDecimalPlaces() {
        assertFalse(Validations.isValidGeolocation("-34.7087291, -58.283100"));
    }

    @Test
    public void testInvalidGeolocationWithExtraWhitespace() {
        assertFalse(Validations.isValidGeolocation("-34.708729,  -58.283100")); // Two spaces after comma
    }

    @Test
    public void testInvalidGeolocationOutOfRange() {
        assertFalse(Validations.isValidGeolocation("-95.000000, -58.283100")); // Latitude out of range
    }
}
