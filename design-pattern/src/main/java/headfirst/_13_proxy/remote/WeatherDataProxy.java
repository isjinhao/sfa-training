package headfirst._13_proxy.remote;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/17
 */
public class WeatherDataProxy implements Subject {

    private ArrayList<Observer> observers;
    Socket socket;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataProxy() throws IOException {
        observers = new ArrayList<>();
        socket = new Socket("127.0.0.1", 11000);
        System.out.println("Successfully connected to the server");
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void listen() throws IOException {
        byte[] bytes = new byte[1024 * 1024];
        while (true) {
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read(bytes);
            String s = new String(bytes, Charset.forName("UTF-8"));
            String[] split = s.split(",");
            this.temperature = Float.valueOf(split[0]);
            this.humidity =  Float.valueOf(split[1]);
            this.pressure =  Float.valueOf(split[2]);
            measurementsChanged();
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
