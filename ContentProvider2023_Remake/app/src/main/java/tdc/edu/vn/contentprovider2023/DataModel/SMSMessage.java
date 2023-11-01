package tdc.edu.vn.contentprovider2023.DataModel;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

import java.util.Date;

public class SMSMessage {
    private String sender;
    private String body;
    private String date;

    public SMSMessage() {
    }

    public SMSMessage(String sender, String body, String date) {
        this.sender = sender;
        this.body = body;
        this.date = date;
    }

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

    @Override
    public String toString() {
        DateFormat d = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss");
        Date dateToConvert = new Date(Long.parseLong(date));
        return sender + " : " + body + " : " + d.format(dateToConvert);
    }
}
