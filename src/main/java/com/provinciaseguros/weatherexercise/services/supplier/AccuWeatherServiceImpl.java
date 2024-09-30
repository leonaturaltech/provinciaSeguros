package com.provinciaseguros.weatherexercise.services.supplier;

import com.provinciaseguros.weatherexercise.utils.WeatherMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provinciaseguros.weatherexercise.models.AccuWeatherCurrentConditions;
import com.provinciaseguros.weatherexercise.models.AccuWeatherLocation;
import com.provinciaseguros.weatherexercise.models.LocationWeather;
import com.provinciaseguros.weatherexercise.repository.LocationWeatherRepository;

@Service
public class AccuWeatherServiceImpl implements WeatherServiceProvider {

	@Autowired
	private LocationWeatherRepository weatherRepository;

	@Autowired
	private AccuWeatherRestClient accuWeatherClient;

	public LocationWeather getWeatherByLatLon(String latLon) {
		AccuWeatherLocation location = accuWeatherClient.fetchLocationByLatLon(latLon);
		String locationKey = location.getKey();

		AccuWeatherCurrentConditions currentConditions = accuWeatherClient.fetchCurrentConditionsByLocationKey(locationKey);

		LocationWeather lw = WeatherMappers.INSTANCE.toLocationWeather(currentConditions);
		lw.setLocationName(location.getLocalizedName());
		lw.setPostalCode(location.getPrimaryPostalCode());
		return lw;
	}


	public LocationWeather getWeatherByPostalCode(String postalCode) {
		AccuWeatherLocation[] locations = accuWeatherClient.fetchLocationByPostalCode(postalCode);
		// TODO: Para simplificar usamos el primero que encontremos
		AccuWeatherLocation location = locations[0];

		AccuWeatherCurrentConditions currentConditions = accuWeatherClient.fetchCurrentConditionsByLocationKey(location.getKey());

		LocationWeather lw = WeatherMappers.INSTANCE.toLocationWeather(currentConditions);
		lw.setLocationName(location.getLocalizedName());
		lw.setPostalCode(location.getPrimaryPostalCode());
		return lw;
	}


}
