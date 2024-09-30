package com.provinciaseguros.weatherexercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class AccuWeatherCurrentConditions {

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;

    @JsonProperty("EpochTime")
    private long epochTime;

    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("WeatherIcon")
    private int weatherIcon;

    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;

    @JsonProperty("PrecipitationType")
    private String precipitationType;  // Could be null

    @JsonProperty("IsDayTime")
    private boolean isDayTime;

    @JsonProperty("Temperature")
    private UnitValue temperature;

    @JsonProperty("RealFeelTemperature")
    private UnitValue realFeelTemperature;

    @JsonProperty("RealFeelTemperatureShade")
    private UnitValue realFeelTemperatureShade;

    @JsonProperty("RelativeHumidity")
    private int relativeHumidity;

    @JsonProperty("IndoorRelativeHumidity")
    private int indoorRelativeHumidity;

    @JsonProperty("DewPoint")
    private UnitValue dewPoint;

    @JsonProperty("Wind")
    private Wind wind;

    @JsonProperty("WindGust")
    private WindGust windGust;

    @JsonProperty("UVIndex")
    private int uvIndex;

    @JsonProperty("UVIndexText")
    private String uvIndexText;

    @JsonProperty("Visibility")
    private UnitValue visibility;

    @JsonProperty("CloudCover")
    private int cloudCover;

    @JsonProperty("Ceiling")
    private UnitValue ceiling;

    @JsonProperty("Pressure")
    private UnitValue pressure;

    @JsonProperty("PressureTendency")
    private Map<String, String> pressureTendency;

    @JsonProperty("Past24HourTemperatureDeparture")
    private UnitValue past24HourTemperatureDeparture;

    @JsonProperty("ApparentTemperature")
    private UnitValue apparentTemperature;

    @JsonProperty("WindChillTemperature")
    private UnitValue windChillTemperature;

    @JsonProperty("WetBulbTemperature")
    private UnitValue wetBulbTemperature;

    @JsonProperty("WetBulbGlobeTemperature")
    private UnitValue wetBulbGlobeTemperature;

    @JsonProperty("Precip1hr")
    private UnitValue precip1hr;

    @JsonProperty("PrecipitationSummary")
    private PrecipitationSummary precipitationSummary;

    @JsonProperty("TemperatureSummary")
    private TemperatureSummary temperatureSummary;

    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonProperty("Link")
    private String link;

    // Inner class for metric/imperial units
    @Data
    public static class UnitValue {
        @JsonProperty("Metric")
        private MetricValue metric;

        @JsonProperty("Imperial")
        private MetricValue imperial;

        @Data
        public static class MetricValue {
            @JsonProperty("Value")
            private double value;

            @JsonProperty("Unit")
            private String unit;

            @JsonProperty("UnitType")
            private int unitType;

            @JsonProperty("Phrase")
            private String phrase;  // Some fields like RealFeelTemperature have this
        }
    }

    // Inner class for Wind
    @Data
    public static class Wind {
        @JsonProperty("Direction")
        private Direction direction;

        @JsonProperty("Speed")
        private UnitValue speed;

        @Data
        public static class Direction {
            @JsonProperty("Degrees")
            private int degrees;

            @JsonProperty("Localized")
            private String localized;

            @JsonProperty("English")
            private String english;
        }
    }

    // Inner class for Wind Gust
    @Data
    public static class WindGust {
        @JsonProperty("Speed")
        private UnitValue speed;
    }

    // Inner class for Precipitation Summary
    @Data
    public static class PrecipitationSummary {
        @JsonProperty("Precipitation")
        private UnitValue precipitation;

        @JsonProperty("PastHour")
        private UnitValue pastHour;

        @JsonProperty("Past3Hours")
        private UnitValue past3Hours;

        @JsonProperty("Past6Hours")
        private UnitValue past6Hours;

        @JsonProperty("Past9Hours")
        private UnitValue past9Hours;

        @JsonProperty("Past12Hours")
        private UnitValue past12Hours;

        @JsonProperty("Past18Hours")
        private UnitValue past18Hours;

        @JsonProperty("Past24Hours")
        private UnitValue past24Hours;
    }

    // Inner class for Temperature Summary
    @Data
    public static class TemperatureSummary {
        @JsonProperty("Past6HourRange")
        private TempRange past6HourRange;

        @JsonProperty("Past12HourRange")
        private TempRange past12HourRange;

        @JsonProperty("Past24HourRange")
        private TempRange past24HourRange;

        @Data
        public static class TempRange {
            @JsonProperty("Minimum")
            private UnitValue minimum;

            @JsonProperty("Maximum")
            private UnitValue maximum;
        }
    }
}
