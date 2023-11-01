package com.example.smsreceiver2023.receivers;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.smsreceiver2023.SMSReceiver2023Activity;

import java.util.StringTokenizer;

public class SMSReceiver extends BroadcastReceiver {

    private String DATA_KEY = "pdus";
    private String DATA_FORMAT = "format";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Bundle smsData = intent.getExtras();
//        Log.d("999999", "onReceive: ");
        if (smsData != null){
            Object[] pdus = (Object[]) smsData.get(DATA_KEY);
            String format = smsData.getString(DATA_FORMAT);
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                // Voi phien ban M tro di
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                // Truoc phien ban M
                else {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                // Get phone number of sender
                String incommingPhone = smsMessages[i].getDisplayOriginatingAddress();
                // Get content of the message
                String message = smsMessages[i].getMessageBody();
                StringTokenizer tokenizer = new StringTokenizer(message);
                String key = tokenizer.nextToken(":");
                if (key.equalsIgnoreCase("print")){
                    String mes = tokenizer.nextToken(":");
                    Toast.makeText(context, mes, Toast.LENGTH_SHORT).show();
                }
                else if (key.equalsIgnoreCase("call")){
                    String phomeNumber = tokenizer.nextToken(":");
                    call(context, phomeNumber);
                }
                else if (key.equalsIgnoreCase("lock")){
                    ((SMSReceiver2023Activity) context).lock();
                }
                else {
                    Toast.makeText(context, "Invalid syntax", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void call(Context context, String phomeNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:"+phomeNumber));
        context.startActivity(intent);
    }


}