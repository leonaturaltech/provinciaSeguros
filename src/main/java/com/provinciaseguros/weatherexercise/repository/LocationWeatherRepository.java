package com.provinciaseguros.weatherexercise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provinciaseguros.weatherexercise.models.LocationWeather;

@Repository
public interface LocationWeatherRepository extends JpaRepository<LocationWeather, Long> {
    Optional<LocationWeather> findByLatLon(String latLon);
    Optional<LocationWeather> findByPostalCode(String postalCode);
}
