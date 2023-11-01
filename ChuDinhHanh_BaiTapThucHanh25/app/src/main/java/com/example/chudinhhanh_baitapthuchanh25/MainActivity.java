package com.example.chudinhhanh_baitapthuchanh25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACT_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;

    Button buttonRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDanhBa();
            }
        });
    }

    public void xuLyDanhBa(){
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.example.chudinhhanh_baitapthuchanh25","com.example.chudinhhanh_baitapthuchanh25.DanhBa");
        startActivities(new Intent[]{intent});
    }

    private void addControl() {
        buttonRead = findViewById(R.id.read_contact_btn);
    }
}