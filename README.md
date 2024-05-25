
# WeatherForecastComponent

WeatherForecastComponent provides easy access to current weather and 5-day forecasts for any location using the OpenWeatherMap API.

## Features
- Retrieve current weather information for any location.
- Retrieve 5-day weather forecasts.
- Simple and easy-to-use API.

## Installation
Download the WeatherForecastComponent.jar file and add it to your project's classpath.

## Usage

### Initialize the Component
```java
WeatherForecastComponent weatherComponent = new WeatherForecastComponent("your_api_key_here");
```

### Get Current Weather
```java
WeatherData currentWeather = weatherComponent.getCurrentWeather("London");
System.out.println("Current Weather: " + currentWeather);
```

### Get 5-Day Forecast
```java
List<WeatherData> forecast = weatherComponent.get5DayForecast("London");
System.out.println("5-Day Forecast:");
for (WeatherData weatherData : forecast) {
    System.out.println(weatherData);
}
```

## Documentation
Detailed API documentation can be found [here](link-to-api-docs).

## License
This component is licensed under the MIT License. See the [LICENSE](link-to-license) file for more details.
