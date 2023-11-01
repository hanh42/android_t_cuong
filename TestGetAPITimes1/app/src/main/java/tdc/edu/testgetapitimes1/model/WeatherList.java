package tdc.edu.testgetapitimes1.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherList {
    @SerializedName("cod")
    public float returnCod;
    @SerializedName("message")
    public float numbeMessager;
    @SerializedName("cnt")
    public float numberOfItem;
    @SerializedName("list")
    public ArrayList<Weather> listItem;

    public WeatherList(float returnCod, float numbeMessager, float numberOfItem, ArrayList<Weather> listItem) {
        this.returnCod = returnCod;
        this.numbeMessager = numbeMessager;
        this.numberOfItem = numberOfItem;
        this.listItem = listItem;
    }

    public float getReturnCod() {
        return returnCod;
    }

    public void setReturnCod(float returnCod) {
        this.returnCod = returnCod;
    }

    public float getNumbeMessager() {
        return numbeMessager;
    }

    public void setNumbeMessager(float numbeMessager) {
        this.numbeMessager = numbeMessager;
    }

    public float getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(float numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public ArrayList<Weather> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Weather> listItem) {
        this.listItem = listItem;
    }

    public class city {
        @SerializedName("name")
        public String name;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "returnCod=" + returnCod +
                ", numbeMessager=" + numbeMessager +
                ", numberOfItem=" + numberOfItem +
                ", listItem=" + listItem +
                '}';
    }
}

