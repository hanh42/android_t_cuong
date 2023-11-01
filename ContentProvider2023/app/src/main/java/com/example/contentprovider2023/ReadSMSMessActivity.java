package com.example.contentprovider2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.ViewManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contentprovider2023.models.CallLog;
import com.example.contentprovider2023.models.SMSMessage;

import java.util.ArrayList;

public class ReadSMSMessActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<SMSMessage> listSMS;
    private ArrayAdapter<SMSMessage> adapter;
    private int REQ = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_smsmess);

        listView = findViewById(R.id.listSMS);
        listSMS = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,listSMS);
        listView.setAdapter(adapter);
        if(turnOnPermission(Manifest.permission.READ_SMS)){
            performAction();
        }
    }

    public void performAction(){
        //Log.d("hdhd" , "dhdhd");
        readSMS(listSMS);
        adapter.notifyDataSetChanged();
    }

    public boolean turnOnPermission(String permission){
        if(checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            requestPermissions( new String[] {permission} , REQ);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQ && permissions.length == grantResults.length){
            int i;
            for (i = 0 ; i< permissions.length ; i++){
                if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    break;
                }
            }
            if(i == grantResults.length){
                performAction();
            }else {
                Toast.makeText(this , "failed",Toast.LENGTH_LONG);
            }
        }
    }

    public void readSMS(ArrayList<SMSMessage> listSMS){
        //get uri of provider CallLog
        Uri uri = Telephony.Sms.CONTENT_URI;

        //Definition of Projection
        String[] projection = new String[]{
                Telephony.Sms.ADDRESS,
                Telephony.Sms.BODY,
                Telephony.Sms.DATE_SENT
        };
        String selection = null;
        String[] selectionArg = null;

        //Query to get data from provider
        Cursor cursor = getContentResolver().query(uri , projection , selection , selectionArg , Telephony.Sms.DATE_SENT + " DESC");

        //Get call log data from cursor
        while (cursor.moveToNext()){
            SMSMessage sms = new SMSMessage();
            //Get data
            sms.setSender(cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.ADDRESS)));
            sms.setBody(cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.BODY)));
            sms.setDate(cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.DATE_SENT)));
            //add to listCallLog
            listSMS.add(sms);
        }
    }
}