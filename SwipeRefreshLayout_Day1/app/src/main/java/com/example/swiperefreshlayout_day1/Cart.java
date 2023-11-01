package com.example.swiperefreshlayout_day1;

public class Cart {
    private String name;

    public Cart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                '}';
    }
}
