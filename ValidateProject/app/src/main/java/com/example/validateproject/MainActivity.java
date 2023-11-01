package com.example.validateproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt_name, edt_age, edt_phone;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        edt_phone = findViewById(R.id.edt_phone);
        submit_btn = findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull(String.valueOf(edt_name.getText()))) {
                    edt_name.setError("Email loi!");
                }
                if (checkNull(String.valueOf(edt_age.getText()))) {
                    edt_age.setError("Email loi!");
                }
                if (checkNull(String.valueOf(edt_phone.getText()))) {
                    edt_phone.setError("Email loi!");
                }
            }
        });
    }

    public boolean checkNull(String var) {
        boolean oke = false;
        if (var.trim().isEmpty()) {
            oke = true;
        }
        return oke;
    }
}