package com.example.smsreceiver2023.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;

import com.example.smsreceiver2023.R;
import com.example.smsreceiver2023.SMSReceiver2023Activity;
import com.example.smsreceiver2023.receivers.SMSReceiver;

public class SMSService extends Service {
    private String CHANNEL_ID = "SMS_RECEIVER_NOTIFICATION";
    private String CHANNEL_NAME = "SMS Receiver";
    private int REQ = 999;
    private String CONTENT_TITLE = "SMS Receiving";
    private String CONTENT_TEXT = "RETURN SMSRECEIVER ACTIVITY";
    private int SERVICE_ID = 100;
    SMSReceiver receiver;
    IntentFilter filter;
    public SMSService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // B1: Create notification channel
        createNotificationChannel();
        // B2: Tạo đối tượng Intent
        Intent notificationIntent = new Intent(this, SMSReceiver2023Activity.class);
        // B3: Tạo đối tượng IntentPending cho notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ, notificationIntent, PendingIntent.FLAG_IMMUTABLE);
        // B4: Tạo đối tượng notification
        Notification notification = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT)
                .setSmallIcon(R.drawable.sms_notification)
                .setContentIntent(pendingIntent)
                .build();
        // B5: Start service
        startForeground(SERVICE_ID, notification);
        // B6: Đăng kí cho SMS Receiver
        receiver = new SMSReceiver();
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        // Resgister for the SMSReceiver
        registerReceiver(receiver, filter);

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Khai báo notification channel object
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            // Lấy đối tượng quản lí notification của hệ thống
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            // Khởi tạo notification channel cho ứng dụng
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onDestroy() {
        // Từ bản 26 trở đi ta phải stop foreground
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            stopForeground(true);
        }
        // Hủy đăng kí Receiver
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}