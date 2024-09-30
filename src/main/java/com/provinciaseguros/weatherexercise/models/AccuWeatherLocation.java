package com.provinciaseguros.weatherexercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccuWeatherLocation {

	@JsonProperty("Key")
	private String key;

	@JsonProperty("LocalizedName")
	private String localizedName;

	@JsonProperty("PrimaryPostalCode")
	private String primaryPostalCode;

	@JsonProperty("EnglishName")
	private String englishName;

	@JsonProperty("Region")
	private Region region;

	@JsonProperty("Country")
	private Country country;

	@JsonProperty("AdministrativeArea")
	private AdministrativeArea administrativeArea;

	@JsonProperty("TimeZone")
	private TimeZone timeZone;

	@JsonProperty("GeoPosition")
	private GeoPosition geoPosition;

	@JsonProperty("DataSets")
	private String[] dataSets;

	@Data
	public static class Region {
		@JsonProperty("ID")
		private String id;

		@JsonProperty("LocalizedName")
		private String localizedName;
	}

	@Data
	public static class Country {
		@JsonProperty("ID")
		private String id;

		@JsonProperty("LocalizedName")
		private String localizedName;
	}

	@Data
	public static class AdministrativeArea {
		@JsonProperty("ID")
		private String id;

		@JsonProperty("LocalizedName")
		private String localizedName;
	}

	@Data
	public static class TimeZone {
		@JsonProperty("Code")
		private String code;

		@JsonProperty("GmtOffset")
		private double gmtOffset;
	}

	@Data
	public static class GeoPosition {
		@JsonProperty("Latitude")
		private double latitude;

		@JsonProperty("Longitude")
		private double longitude;

		@JsonProperty("Elevation")
		private Elevation elevation;

		@Data
		public static class Elevation {
			@JsonProperty("Metric")
			private UnitValue metric;

			@JsonProperty("Imperial")
			private UnitValue imperial;
		}
	}

	@Data
	public static class UnitValue {
		@JsonProperty("Value")
		private double value;

		@JsonProperty("Unit")
		private String unit;

		@JsonProperty("UnitType")
		private int unitType;
	}
}
