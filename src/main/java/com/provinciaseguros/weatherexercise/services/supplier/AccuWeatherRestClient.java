package com.provinciaseguros.weatherexercise.services.supplier;

import com.provinciaseguros.weatherexercise.models.AccuWeatherCurrentConditions;
import com.provinciaseguros.weatherexercise.models.AccuWeatherLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AccuWeatherRestClient {

	@Value("${accuweather.api.base-url}")
	private String baseUrl;

	@Value("${accuweather.api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	public AccuWeatherLocation fetchLocationByLatLon(String latLon) {
		try {
			String url = buildGeopositionUrl(latLon);
			return restTemplate.getForObject(url, AccuWeatherLocation.class);
		} catch (RestClientException e) {
			throw new RuntimeException("Error fetching location data by lat/lon from AccuWeather: " + e.getMessage(), e);
		}
	}


	private String buildGeopositionUrl(String latLon) {
		return UriComponentsBuilder.fromHttpUrl(baseUrl + "/locations/v1/cities/geoposition/search")
				.queryParam("apikey", apiKey)
				.queryParam("q", latLon)
				.toUriString();
	}

	public AccuWeatherLocation[] fetchLocationByPostalCode(String postalCode) {
		String url = buildPostalCodeUrl(postalCode);

		try {
			return restTemplate.getForObject(url, AccuWeatherLocation[].class);
		} catch (RestClientException e) {
			throw new RuntimeException("Error fetching location data by postal code from AccuWeather: " + e.getMessage(), e);
		}
	}

	private String buildPostalCodeUrl(String postalCode) {
		return UriComponentsBuilder.fromHttpUrl(baseUrl + "/locations/v1/postalcodes/search")
				.queryParam("apikey", apiKey)
				.queryParam("q", postalCode)
				.toUriString();
	}

	public AccuWeatherCurrentConditions fetchCurrentConditionsByLocationKey(String locationKey) {
		try {
			String url = buildCurrentConditionsUrl(locationKey);

			AccuWeatherCurrentConditions[] response = restTemplate.getForObject(url, AccuWeatherCurrentConditions[].class);

			if (response != null && response.length > 0) {
				return response[0];  // Return the first element
			} else {
				throw new RuntimeException("No weather data found for location key: " + locationKey);
			}
		} catch (RestClientException e) {
			throw new RuntimeException("Error fetching weather data from AccuWeather: " + e.getMessage(), e);
		}
	}

	private String buildCurrentConditionsUrl(String locationKey) {
		return UriComponentsBuilder.fromHttpUrl(baseUrl + "/currentconditions/v1/" + locationKey)
				.queryParam("apikey", apiKey)
				.queryParam("details", "true")  // Add 'details' to fetch detailed weather info
				.toUriString();
	}
}
