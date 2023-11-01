package com.example.contentprovider2023.models;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SMSMessage {
    private String sender;
    private String body;
    private String date;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public SMSMessage(String sender, String body, String date) {
        this.sender = sender;
        this.body = body;
        this.date = date;
    }

    public SMSMessage() {
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
        Date newDate = new Date(Long.parseLong(date));
        return "Sender: " + sender + " - " + "Body: " + body + " - " + "Date: " + format.format(newDate);
    }
}
