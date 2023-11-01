package com.example.testbundle.timer;

import com.example.testbundle.data.GetData;

import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {
    private static final long UPDATE_INTERVAL = 1000;
    private GetData getData;

    public TimerManager(GetData getData) {
        this.getData = getData;
    }

    public void startDataUpdateTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getData.getData();
            }
        }, 0, UPDATE_INTERVAL);
    }
}
