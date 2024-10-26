package org.piyush;


import org.apache.hadoop.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.hadoop.shaded.org.apache.http.client.methods.HttpGet;
import org.apache.hadoop.shaded.org.apache.http.impl.client.CloseableHttpClient;
import org.apache.hadoop.shaded.org.apache.http.impl.client.HttpClients;
import org.apache.hadoop.shaded.org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeatherAPIClient {
        private String apiKey;

        public void WeatherAPIClient(String apiKey) {
            this.apiKey = apiKey;
        }

    public WeatherAPIClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String fetchWeatherData(String city) throws IOException {
            String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, apiKey);
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(apiUrl);
                try (CloseableHttpResponse response = client.execute(request)) {
                    return EntityUtils.toString(response.getEntity());
                }
            }
        }

}
