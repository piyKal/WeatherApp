package org.piyush;

import org.apache.hadoop.shaded.com.fasterxml.jackson.databind.JsonNode;
import org.apache.hadoop.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class WeatherDataProcessor {
        public static double convertToCelsius(double kelvin) {
            return kelvin - 273.15;
        }

        public static Map<String, Object> processWeatherData(String jsonData) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode weatherJson = mapper.readTree(jsonData);

            double temp = convertToCelsius(weatherJson.path("main").path("temp").asDouble());
            double feelsLike = convertToCelsius(weatherJson.path("main").path("feels_like").asDouble());
            String mainCondition = weatherJson.path("weather").get(0).path("main").asText();

            Map<String, Object> processedData = new HashMap<>();
            processedData.put("temp", temp);
            processedData.put("feels_like", feelsLike);
            processedData.put("main_condition", mainCondition);
            return processedData;
        }


}
