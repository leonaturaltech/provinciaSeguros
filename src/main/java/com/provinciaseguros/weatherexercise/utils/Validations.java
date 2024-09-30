package com.provinciaseguros.weatherexercise.utils;

public class Validations {


    public static  Boolean isValidGeolocation(String geo) {
        if (!geo.matches("^-?\\d{1,2}\\.\\d{6},\\s?-?\\d{1,3}\\.\\d{6}$")) {
            return false;
        }

        String[] parts = geo.split(",\\s*");
        double latitude = Double.parseDouble(parts[0]);
        double longitude = Double.parseDouble(parts[1]);

        return latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180;
    }

    public static boolean isValidatePostalCode(String postalCode) {
        try {
            int code = Integer.parseInt(postalCode);
            return code >= 1000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
