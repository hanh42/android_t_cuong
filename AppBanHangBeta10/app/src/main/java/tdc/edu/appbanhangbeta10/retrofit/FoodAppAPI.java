package tdc.edu.appbanhangbeta10.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tdc.edu.appbanhangbeta10.models.CategoryModel;
import tdc.edu.appbanhangbeta10.models.MealModel;
import tdc.edu.appbanhangbeta10.models.Meals;

public interface FoodAppAPI {
    @GET("category.php")
    Call<CategoryModel> getCategory();

    @FormUrlEncoded
    @POST("meal.php")
    Call<MealModel> getMeals(
            @Field("idcate") int idcate
    );
}
