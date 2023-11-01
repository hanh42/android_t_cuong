package tdc.edu.appbanhangbeta10.responstory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tdc.edu.appbanhangbeta10.models.CategoryModel;
import tdc.edu.appbanhangbeta10.retrofit.FoodAppAPI;
import tdc.edu.appbanhangbeta10.retrofit.RetrofitInstance;

public class CategoryResponstory {
    private FoodAppAPI foodAppAPI;

    public CategoryResponstory() {
        foodAppAPI = RetrofitInstance.getRetrofit().create(FoodAppAPI.class);
    }

    public MutableLiveData<CategoryModel> getCategory() {
        MutableLiveData<CategoryModel> data = new MutableLiveData<>();
        foodAppAPI.getCategory().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Log.d("TAG", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }

}
