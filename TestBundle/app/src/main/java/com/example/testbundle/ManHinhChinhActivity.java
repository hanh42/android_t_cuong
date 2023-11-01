package com.example.testbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testbundle.data.DataManager;
import com.example.testbundle.data.GetData;
import com.example.testbundle.timer.TimerManager;

public class ManHinhChinhActivity extends AppCompatActivity {
    private ListView listView;
    private String[] numbers = {"One", "Two", "Three", "Four", "Five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chinh_layout);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(adapter);

        DataManager dataManager = new DataManager();
        GetData a = new DataManager();
        TimerManager timerManager = new TimerManager(a);
        timerManager.startDataUpdateTimer();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedNumber = numbers[position];
                Intent intent = new Intent(ManHinhChinhActivity.this, ManHinhPhuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("number", selectedNumber);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Cập nhật dữ liệu ListView ở đây nếu cần thiết
    }
}