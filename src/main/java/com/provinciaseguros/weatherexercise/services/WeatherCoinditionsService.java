package com.provinciaseguros.weatherexercise.services;

import com.provinciaseguros.weatherexercise.dtos.WeatherResponseDTO;
import com.provinciaseguros.weatherexercise.models.LocationWeather;
import com.provinciaseguros.weatherexercise.repository.LocationWeatherRepository;
import com.provinciaseguros.weatherexercise.services.supplier.WeatherServiceProvider;
import com.provinciaseguros.weatherexercise.utils.WeatherMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherCoinditionsService {

    @Autowired
    WeatherServiceProvider weatherServiceProvider;

    @Autowired
    LocationWeatherRepository repo;

    public WeatherResponseDTO getWeatherByLatLon(String latLon){
        LocationWeather lw = weatherServiceProvider.getWeatherByLatLon(latLon);
        lw.setLatLon(latLon);

        repo.save(lw);// TODO : Se puede ajustar los campos a guardar en el mapper
        return WeatherMappers.INSTANCE.toDTO(lw);// TODO : Se puede ajustar los campos a devolver en el mapper
    }


    public WeatherResponseDTO getWeatherByPostalCode(String postalCode){
        LocationWeather lw = weatherServiceProvider.getWeatherByPostalCode(postalCode);
        lw.setPostalCode(postalCode);

        repo.save(lw);
        return WeatherMappers.INSTANCE.toDTO(lw);
    }
}
