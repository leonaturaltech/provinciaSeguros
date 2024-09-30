package com.provinciaseguros.weatherexercise.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

// DB entity
@Entity
@Data
@Builder
public class LocationWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private String locationKey;
    private String postalCode;
    private String latLon;
    private String locationName;
    private Double temperatureValue;
    private String temperatureUnit;
    private String localObservationDateTime;
    private String weatherText;
    private Boolean hasPrecipitation;
    private LocalDateTime lastUpdatedTime;

}
