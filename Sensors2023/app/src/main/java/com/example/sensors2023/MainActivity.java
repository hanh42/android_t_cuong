package com.example.sensors2023;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sensors2023.Model.Item;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private int REQ = 99;
    ArrayAdapter arrayAdapter;
    private EditText editText;

    private ArrayList<Item> arrayList = new ArrayList<>();
    private ListView listView;

    //B1 khai bao doi tuong sensor.
    private Sensor sensor = null;
    //B3 . Khai bao doi tuong dung de nghe ngong du kieu tra ve tu sensor.
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] value = event.values;
            float x = value[0];
            float y = value[1];
            float z = value[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //Khong dinh nghia viec doc du kieu tra ve tu sensor o day!
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors) {
            arrayList.add(new Item(sensor.getName(), sensor.getVendor()));
        }
        //B2:
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        //Set adapter!
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        // Check required permission
        if (checkPermission(Manifest.permission.BODY_SENSORS)) {
            doWithPermission();
        } else {
            requestPermissions(new String[]{Manifest.permission.BODY_SENSORS}, REQ);
        }
    }

    public void anhXa() {
        editText = findViewById(R.id.id_edt);
        listView = findViewById(R.id.id_liv);
        //Khoi tao sensors manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    private boolean checkPermission(String permission) {
        int check = checkSelfPermission(permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    // Processing Permission Dialog
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ && permissions.length == grantResults.length) {
            int i;
            for (i = 0; i < permissions.length; ++i) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    break;
                }
            }
            if (i == grantResults.length) {
                doWithPermission();
            } else {
                Toast.makeText(this, "The required permission must be allowed", Toast.LENGTH_LONG);
            }
        }
    }

    private void doWithPermission() {
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //B4 Dang ky de nghe ngon du lieu tra ve tu sensors!
        if(sensor != null){
                sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
//                new ComponentName(this, MyAdmin,class);
//                setContentView(R.layout.s);
        }else{
            Toast.makeText(this, "khong ho tro loai cam bien nay!", Toast.LENGTH_SHORT).show();
        }
    }
}