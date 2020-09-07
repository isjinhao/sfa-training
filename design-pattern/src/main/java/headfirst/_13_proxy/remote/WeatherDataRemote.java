package headfirst._13_proxy.remote;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/17
 */
public class WeatherDataRemote {

    private ServerSocket serverSocket;

    private List<Socket> socketList = new ArrayList<>();

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Boolean started = false;

    private WeatherDataRemote() {

    }

    private static class SingletonHolder {
        private static final WeatherDataRemote INSTANCE = new WeatherDataRemote();
    }

    public static WeatherDataRemote getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public void startServer() throws IOException {
        synchronized (started){
            if (!started) {
                serverSocket = new ServerSocket(11000);
                executorService.submit(() -> {
                    while (true) {
                        socketList.add(serverSocket.accept());
                    }
                });
                System.out.println("Server start");
                started = true;
            } else {
                System.out.println("server has started !");
            }
        }
    }

    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) throws IOException {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        for (Socket socket : socketList) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((temperature + "," + humidity + "," + pressure).getBytes());
        }
    }


    public static void main(String[] args) throws Exception {

        WeatherDataRemote weatherDataRemote = WeatherDataRemote.getInstance();
        weatherDataRemote.startServer();

        Thread.sleep(10000);
        weatherDataRemote.setMeasurements(80, 65, 30.4f);
        Thread.sleep(1000);
        weatherDataRemote.setMeasurements(82, 70, 29.2f);
        Thread.sleep(1000);
        weatherDataRemote.setMeasurements(78, 90, 29.2f);

    }

}
