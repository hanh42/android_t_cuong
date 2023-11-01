package tdc.edu.appbanhangbeta10.responstory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tdc.edu.appbanhangbeta10.models.MealModel;
import tdc.edu.appbanhangbeta10.models.Meals;
import tdc.edu.appbanhangbeta10.retrofit.FoodAppAPI;
import tdc.edu.appbanhangbeta10.retrofit.RetrofitInstance;

public class MealResponsive {
    private FoodAppAPI api;

    public MealResponsive() {
        api = RetrofitInstance.getRetrofit().create(FoodAppAPI.class);
    }

    public MutableLiveData<MealModel> getMeals(int idcate) {
        MutableLiveData<MealModel> data = new MutableLiveData<>();
        api.getMeals(idcate).enqueue(new Callback<MealModel>() {
            @Override
            public void onResponse(Call<MealModel> call, Response<MealModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MealModel> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
                data.setValue(null);
            }

        });
        return data;
    }

    ;
}
