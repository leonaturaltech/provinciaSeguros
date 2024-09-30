package com.provinciaseguros.weatherexercise.utils;

import com.provinciaseguros.weatherexercise.models.AccuWeatherCurrentConditions;
import com.provinciaseguros.weatherexercise.dtos.WeatherResponseDTO;
import com.provinciaseguros.weatherexercise.models.LocationWeather;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMappers {

    WeatherMappers INSTANCE = Mappers.getMapper(WeatherMappers.class);

    WeatherResponseDTO toDTO(LocationWeather locationWeather);

    default LocationWeather toLocationWeather(AccuWeatherCurrentConditions awcc) {
        AccuWeatherCurrentConditions.UnitValue.MetricValue metric = awcc.getTemperature().getMetric();
        return LocationWeather.builder() // TODO ver si falta algun campo
                .temperatureValue(metric.getValue())
                .temperatureUnit(metric.getUnit())
                .hasPrecipitation(awcc.isHasPrecipitation())
                .weatherText(awcc.getWeatherText())
                .localObservationDateTime(awcc.getLocalObservationDateTime()).build();
    }
}
