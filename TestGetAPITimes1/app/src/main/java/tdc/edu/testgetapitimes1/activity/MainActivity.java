package tdc.edu.testgetapitimes1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tdc.edu.testgetapitimes1.R;
import tdc.edu.testgetapitimes1.model.Weather;
import tdc.edu.testgetapitimes1.model.WeatherAPI;
import tdc.edu.testgetapitimes1.model.WeatherList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Weather> weatherInformationArrayList;
    private WeatherAPI weatherAPI;
    String key = "dd5b045f648ec36438e99e6cf0658f2e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeatherDate("London");
    }

    public void getWeatherDate(String city) {
        //Clear old data from the list!
        weatherInformationArrayList = new ArrayList<>();
        weatherInformationArrayList.clear();
        //B1: Creat a new object of retrofit.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ;
        //B2: Create the retrofit API (Weather API)
        weatherAPI = retrofit.create(tdc.edu.testgetapitimes1.model.WeatherAPI.class);
        //B3: Call the API method
        Call<WeatherList> call = weatherAPI.getWeather(city, key);
        Log.d("TAG", "getWeatherDate: " + call);
        //B4: Enqueue the call
        call.enqueue(new Callback<WeatherList>() {
            @Override
            public void onResponse(Call<WeatherList> call, Response<WeatherList> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", "onResponse: thanh cong");
                    WeatherList weatherList = response.body();
                    assert weatherList != null;
                    //Add to the recyclerView.
                    weatherInformationArrayList.addAll(weatherList.listItem);
                    // Notify to recyclerView
                    Log.d("TAG", "onResponse: " + weatherInformationArrayList);
                    Log.d("KQ", "onResponse: "+weatherList.toString());
                } else {
                    Log.d("TAG", "onResponse: khong thanh cong");
                }
            }

            @Override
            public void onFailure(Call<WeatherList> call, Throwable t) {
                Log.d("TAG", "onResponse: khong the lay thanh cong");
//                t.printStackTrace();
            }
        });
    }
}