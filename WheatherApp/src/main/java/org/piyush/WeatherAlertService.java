package org.piyush;

import java.util.Map;

public class WeatherAlertService {

        private final double tempThreshold;

        public WeatherAlertService(double tempThreshold) {
            this.tempThreshold = tempThreshold;
        }

        public boolean checkThreshold(Map<String, Object> weatherData) {
            double currentTemp = (double) weatherData.get("temp");
            return currentTemp > tempThreshold;
        }


}
