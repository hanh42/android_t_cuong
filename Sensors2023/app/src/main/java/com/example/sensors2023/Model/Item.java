package com.example.sensors2023.Model;

public class Item {
    private String name;
    private String company;

    public Item(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", company='" + company + '\'';
    }
}
