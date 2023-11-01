package tdc.edu.vn.contentprovider2023.DataModel;

import java.util.Date;

public class CallLog {
    private String duration;
    private String number;
    private String country;
    private String type;
    private String date;

    public CallLog(String duration, String number, String country, String type, String date) {
        this.duration = duration;
        this.number = number;
        this.country = country;
        this.type = type;
        this.date = date;
    }

    public CallLog() {

    }

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

    @Override
    public String toString() {
        Date d = new Date(Long.parseLong(date));
        return "CallLog{" +
                ", duration=" + duration +
                ", number=" + number +
                ", country=" + country +
                ", type=" + type +
                "date=" + d +
                '}';
    }
}
