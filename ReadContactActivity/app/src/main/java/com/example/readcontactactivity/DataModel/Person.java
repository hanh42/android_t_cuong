package com.example.readcontactactivity.DataModel;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<String> number;
    private ArrayList<String> email;
    private ArrayList<String> address;

    public Person(String name, ArrayList<String> number, ArrayList<String> email, ArrayList<String> address) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<String> number) {
        this.number = number;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " : " +
                " numberArray " + number +
                " : email " + email +
                " : address " + address;
    }
}
