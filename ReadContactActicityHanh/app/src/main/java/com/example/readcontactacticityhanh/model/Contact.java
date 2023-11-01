package com.example.readcontactacticityhanh.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<String> number;
    private ArrayList<String> emails;
    private ArrayList<String> addresses;

    public Contact(String name, ArrayList<String> number, ArrayList<String> emails, ArrayList<String> addresses) {
        this.name = name;
        this.number = number;
        this.emails = emails;
        this.addresses = addresses;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getnumber() {
        return number;
    }

    public void setnumber(ArrayList<String> number) {
        this.number = number;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<String> addresses) {
        this.addresses = addresses;
    }

    @NonNull
    @Override
    public String toString() {
        return "name : " + name +
                " : number " + number +
                " : email " + emails +
                " : address " + addresses;
    }
}
