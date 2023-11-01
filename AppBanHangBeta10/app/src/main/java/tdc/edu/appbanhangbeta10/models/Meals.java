package tdc.edu.appbanhangbeta10.models;

import com.google.gson.annotations.SerializedName;

public class Meals {
    private int id;
    private String strMeal;
    @SerializedName("strMealThumb")
    private String strMealThum;
    private int idMeal, idCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThum() {
        return strMealThum;
    }

    public void setStrMealThum(String strMealThum) {
        this.strMealThum = strMealThum;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
