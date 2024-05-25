
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecastComponent {

    private String apiKey;

    public WeatherForecastComponent(String apiKey) {
        this.apiKey = apiKey;
    }

    public WeatherData getCurrentWeather(String location) throws IOException {
        String response = fetchWeatherData("weather?q=" + location);
        JSONObject jsonObject = new JSONObject(response);
        return parseWeatherData(jsonObject);
    }

    public List<WeatherData> get5DayForecast(String location) throws IOException {
        String response = fetchWeatherData("forecast?q=" + location);
        JSONObject jsonObject = new JSONObject(response);
        JSONArray list = jsonObject.getJSONArray("list");
        List<WeatherData> forecast = new ArrayList<>();
        for (int i = 0; i < list.length(); i += 8) { // Skip to daily data
            forecast.add(parseWeatherData(list.getJSONObject(i)));
        }
        return forecast;
    }

    private String fetchWeatherData(String endpoint) throws IOException {
        String urlString = "http://api.openweathermap.org/data/2.5/" + endpoint + "&appid=" + apiKey;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }

        Scanner sc = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();
        return inline.toString();
    }

    private WeatherData parseWeatherData(JSONObject jsonObject) {
        JSONObject main = jsonObject.getJSONObject("main");
        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);

        double temperature = main.getDouble("temp");
        double humidity = main.getDouble("humidity");
        String description = weather.getString("description");

        return new WeatherData(temperature, humidity, description);
    }
}
