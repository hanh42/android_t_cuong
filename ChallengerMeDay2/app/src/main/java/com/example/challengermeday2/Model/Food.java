package com.example.challengermeday2.Model;

public class Food {
    private String name;
    private int image;

    public Food(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
