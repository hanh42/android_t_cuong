package tdc.edu.testgetapitimes1.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    //    String BASE_URL = "https://api.openweathermap.org/";
//    Call<WeatherList> getWeather(@Query("q") String city, @Query("appid") String key);

    String BASE_URL = "https://api.openweathermap.org/";
    @GET("data/2.5/forecast?")
    Call<WeatherList> getWeather(@Query("q") String city, @Query("appid") String key);
}
