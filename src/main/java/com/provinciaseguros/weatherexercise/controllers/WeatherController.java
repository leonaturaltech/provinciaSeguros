package com.provinciaseguros.weatherexercise.controllers;

import com.provinciaseguros.weatherexercise.exceptions.LocationInvalidException;
import com.provinciaseguros.weatherexercise.exceptions.PostalCodeInvalidException;
import com.provinciaseguros.weatherexercise.services.WeatherCoinditionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.provinciaseguros.weatherexercise.exceptions.WeatherNotFoundException;
import com.provinciaseguros.weatherexercise.utils.Validations;
import com.provinciaseguros.weatherexercise.dtos.WeatherResponseDTO;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherCoinditionsService weatherCoinditionsService;

    @GetMapping("/v1/cities/geoposition/search")
    public ResponseEntity<?> getWeatherByLatLon(@RequestParam String q) {
        try {
            log.info("getWeatherByLatLon request"); // FIXME agregar logs en otras clases
            if (!Validations.isValidGeolocation(q))
                throw new LocationInvalidException("Invalid lat/lon format. Expected format: -00.0000,-00.0000\", \"TODO : DOMAIN_CODE");

            WeatherResponseDTO weather = weatherCoinditionsService.getWeatherByLatLon(q);
            return ResponseEntity.ok(weather);
        } catch (LocationInvalidException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        } catch (WeatherNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching weather data");
        }
    }

    @GetMapping("/v1/postalcodes/search")
    public ResponseEntity<?> getWeatherByPostalCode(@RequestParam String q) {
        try {
            if (!Validations.isValidatePostalCode(q)) throw new PostalCodeInvalidException("Invalid postal code.");

            WeatherResponseDTO weather = weatherCoinditionsService.getWeatherByPostalCode(q);
            return ResponseEntity.ok(weather);
        } catch (PostalCodeInvalidException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (WeatherNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Weather data not found");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching weather data");
        }

    }

}

