package headfirst._02_observer.self;

/**
 * Created by Gavin on 2017/2/13.
 */
public class WeatherStationClient {

    public static void main(String[] args) throws Exception {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);


        Thread.sleep(3000);
        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("-------------------------------------------");
        Thread.sleep(1000);
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("-------------------------------------------");
        Thread.sleep(1000);
        weatherData.setMeasurements(78, 90, 29.2f);

        currentConditionsDisplay.close();
        statisticsDisplay.close();
        forecastDisplay.close();
        heatIndexDisplay.close();

    }
}
