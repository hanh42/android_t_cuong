package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import tdc.edu.appbanhangbeta10.R;

public class LoadingPage extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}