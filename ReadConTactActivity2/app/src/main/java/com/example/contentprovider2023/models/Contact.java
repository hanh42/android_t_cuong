package com.example.contentprovider2023.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<String> numbers;
    private ArrayList<String> emails;
    private ArrayList<String> addresses;

    public Contact(String name, ArrayList<String> numbers, ArrayList<String> emails, ArrayList<String> addresses) {
        this.name = name;
        this.numbers = numbers;
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

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
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
        return "name: " + name + " , " +
                "number[" + arrayToSTring(numbers) + "]" + " , " +
                "email[" + arrayToSTring(emails) + "]" + " , " +
                "address[" + arrayToSTring(addresses) + "]";
    }

    private String arrayToSTring(ArrayList<String> arr){
        String result = "";
        for (int i = 0 ; i < arr.size() ; i++){
            if(i == arr.size() - 1){
                result += arr.get(i);
            }else {
                result += arr.get(i) + ", ";
            }
        }
        return result;
    }
}
