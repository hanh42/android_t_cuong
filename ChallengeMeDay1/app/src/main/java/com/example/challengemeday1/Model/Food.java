package com.example.challengemeday1.Model;

import com.example.challengemeday1.Adapter.FoodAdapter;

public class Food {
    private String name;
    private Integer price;
    private int picture;

    public Food(String name, Integer price, int picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
