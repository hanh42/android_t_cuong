package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import tdc.edu.appbanhangbeta10.R;

public class MainActivity extends AppCompatActivity {
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), IntroducePageActivity1.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void anhXa(){
        btn_start = findViewById(R.id.btn_login);
    }
}