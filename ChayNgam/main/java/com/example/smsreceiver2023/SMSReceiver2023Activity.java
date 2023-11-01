package com.example.smsreceiver2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smsreceiver2023.receivers.AdminReceiver;
import com.example.smsreceiver2023.receivers.SMSReceiver;
import com.example.smsreceiver2023.services.SMSService;

public class SMSReceiver2023Activity extends AppCompatActivity {

    private int REQ = 99;
    SMSReceiver receiver;
    IntentFilter filter;
    private boolean registerStage = false;
    // Yêu cầu quyền admin
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;
    private Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Khởi gán giá trị cho biến yêu cầu quyền admin phải trước setContentView();
        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(this, AdminReceiver.class);

        setContentView(R.layout.sms_receiver_layout);
      /*  boolean c =  true;
          int check = checkSelfPermission(Manifest.permission.RECEIVE_SMS);

          if (check == PackageManager.PERMISSION_GRANTED){
              c = true;
          }
          Intent intent = new Intent(Intent.EXTRA_RESULT_RECEIVER);
          startActivity(intent);*/



        //Check and requin permission if needed
        if (!checkPermission(Manifest.permission.RECEIVE_SMS) || !checkPermission(Manifest.permission.CALL_PHONE)){
            requestPermissions(new String[] {Manifest.permission.RECEIVE_SMS, Manifest.permission.CALL_PHONE}, REQ);
        }else {
            performAction();
        }

    }

    private void performAction() {
        receiver = new SMSReceiver();
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        // Resgister for the SMSReceiver
        registerReceiver(receiver, filter);
        registerStage = true;

        // Yêu cầu quyền admin
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        startActivity(intent);

        // Khởi tạo đối tượng Service
        service = new Intent(this, SMSService.class);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ && permissions.length == grantResults.length){
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    return;
                }
            }

            //Execute the function if all of permissionn are granted
            performAction();

        }
    }


    //Method to check permission
    private boolean checkPermission(String permission){
        int check = checkSelfPermission(permission);
        return check == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (receiver != null) {
            unregisterReceiver(receiver);
            registerStage = false;
            // Bật Service
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(service);
            }
            else {
                startService(service);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!registerStage) {
            // Re-Reigister for SMSReceiver
            registerReceiver(receiver, filter);
            registerStage = true;


        }
        // Tắt service
        stopService(service);
    }
    public void lock(){
        boolean isAdminActive = devicePolicyManager.isAdminActive(componentName);
        if (isAdminActive){
            devicePolicyManager.lockNow();
        }
        else {
            Toast.makeText(this, "You no door", Toast.LENGTH_SHORT).show();
        }
    }
}