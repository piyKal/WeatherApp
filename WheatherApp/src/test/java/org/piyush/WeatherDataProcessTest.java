package org.piyush;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataProcessTest {


    @Test
        public void testConvertToCelsius() {
            double kelvin = 300.0;
            double expectedCelsius = 26.85;
            double actualCelsius = WeatherDataProcessor.convertToCelsius(kelvin);
            assertEquals(expectedCelsius, actualCelsius, 0.1);
        }


}
