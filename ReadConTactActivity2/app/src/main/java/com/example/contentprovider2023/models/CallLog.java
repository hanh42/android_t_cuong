package com.example.contentprovider2023.models;

import androidx.annotation.NonNull;

import java.util.Date;

public class CallLog {
    private String duration;
    private String number;
    private String country;
    private String type;
    private String date;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {
        return duration + " - " + number + " - " + country + " - " + type + " - " + date;
    }
}
