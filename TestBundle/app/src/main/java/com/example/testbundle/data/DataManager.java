package com.example.testbundle.data;

import android.util.Log;

public class DataManager implements GetData {
    @Override
    public void getData() {
        Log.d("TAG", "getData: get data from web service");
    }
}
