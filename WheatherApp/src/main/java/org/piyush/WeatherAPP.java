package org.piyush;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class WeatherAPP {

        public static void main(String[] args) {
            String apiKey = "YOUR_API_KEY";
            String city = "Delhi";

            WeatherAPIClient client = new WeatherAPIClient(apiKey);
            WeatherAlertService alertService = new WeatherAlertService(35.0); // threshold in Celsius

            try {
                String weatherData = client.fetchWeatherData(city);
                Map<String, Object> processedData = Collections.unmodifiableMap(WeatherDataProcessor.processWeatherData(weatherData));

                if (alertService.checkThreshold(processedData)) {
                    System.out.println("Alert: Temperature threshold exceeded!");
                } else {
                    System.out.println("Weather is normal.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
