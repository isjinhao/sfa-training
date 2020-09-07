package headfirst._13_proxy.remote;


/**
 * Created by Gavin on 2017/2/13.
 */
public class WeatherStationLocalClient {

    public static void main(String[] args) throws Exception {

        WeatherDataProxy weatherDataProxy = new WeatherDataProxy();

        new CurrentConditionsDisplay(weatherDataProxy);
        new StatisticsDisplay(weatherDataProxy);
        new ForecastDisplay(weatherDataProxy);
        new HeatIndexDisplay(weatherDataProxy);

        weatherDataProxy.listen();

    }
}
