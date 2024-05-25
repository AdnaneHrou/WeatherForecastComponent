
public class WeatherData {
    private double temperature;
    private double humidity;
    private String description;

    public WeatherData(double temperature, double humidity, String description) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature + "K, Humidity: " + humidity + "%, Description: " + description;
    }
}
