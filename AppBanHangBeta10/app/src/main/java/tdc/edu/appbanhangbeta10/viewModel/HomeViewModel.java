package tdc.edu.appbanhangbeta10.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import tdc.edu.appbanhangbeta10.models.Category;
import tdc.edu.appbanhangbeta10.models.CategoryModel;
import tdc.edu.appbanhangbeta10.models.MealModel;
import tdc.edu.appbanhangbeta10.responstory.CategoryResponstory;
import tdc.edu.appbanhangbeta10.responstory.MealResponsive;

public class HomeViewModel extends ViewModel {
    private final CategoryResponstory categoryResponstory;
    private MealResponsive mealResponsive;

    public HomeViewModel() {
        categoryResponstory = new CategoryResponstory();
        mealResponsive = new MealResponsive();
    }

    public MutableLiveData<CategoryModel> categoryModelMutableLiveData() {
        return categoryResponstory.getCategory();
    }

    public MutableLiveData<MealModel>mealModelMutableLiveData(int idcate){
        return mealResponsive.getMeals(idcate);
    }

}
