package headfirst._02_observer.self;

/**
 * Created by Gavin on 2017/2/13.
 */
public class WeatherStationHeatIndex {
    public static void main(String[] args){

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("--------------------------------------");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("--------------------------------------");
        weatherData.setMeasurements(78, 90, 29.2f);

        currentDisplay.close();
        statisticsDisplay.close();
        forecastDisplay.close();
        heatIndexDisplay.close();

    }
}
