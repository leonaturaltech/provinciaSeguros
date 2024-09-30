package com.provinciaseguros.weatherexercise.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponseDTO {

    private Double temperatureValue;
    private String temperatureUnit;
    private String localObservationDateTime;
    private String weatherText;
    private Boolean hasPrecipitation;

}

