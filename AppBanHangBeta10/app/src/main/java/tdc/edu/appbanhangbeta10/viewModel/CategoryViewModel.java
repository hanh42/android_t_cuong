package tdc.edu.appbanhangbeta10.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import tdc.edu.appbanhangbeta10.models.MealModel;
import tdc.edu.appbanhangbeta10.responstory.MealResponsive;

public class CategoryViewModel extends ViewModel {
    private MealResponsive mealResponsive;

    public CategoryViewModel() {
        mealResponsive = new MealResponsive();
    }
    public MutableLiveData<MealModel> getMealModelMutableLiveData(int id){
        return mealResponsive.getMeals(id);
    }
}
