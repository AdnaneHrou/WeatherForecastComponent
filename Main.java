
public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the WeatherForecastComponent with your API key
            WeatherForecastComponent weatherComponent = new WeatherForecastComponent("your_api_key_here");

            // Get the current weather for London
            WeatherData currentWeather = weatherComponent.getCurrentWeather("London");
            System.out.println("Current Weather: " + currentWeather);

            // Get the 5-day weather forecast for London
            List<WeatherData> forecast = weatherComponent.get5DayForecast("London");
            System.out.println("5-Day Forecast:");
            for (WeatherData weatherData : forecast) {
                System.out.println(weatherData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
