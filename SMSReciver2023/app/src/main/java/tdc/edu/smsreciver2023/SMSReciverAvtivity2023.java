package tdc.edu.smsreciver2023;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import tdc.edu.smsreciver2023.receiver.AdminReceiver;
import tdc.edu.smsreciver2023.receiver.SMSReceiver;

public class SMSReciverAvtivity2023 extends AppCompatActivity {

    private int REQ = 99;
    private SMSReceiver receiver;
    private IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    private boolean registerState = false;
    //Yeu cau quyen admin
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //B1: Khoi gan gia tri cho bien yeu cau quyen admin.
        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(this, AdminReceiver.class);
        setContentView(R.layout.activity_main);
        //check and require permission if neefed
        if ((!checkPermission(Manifest.permission.RECEIVE_SMS)) || (!checkPermission(Manifest.permission.CALL_PHONE))) {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.CALL_PHONE}, REQ);
        } else {
            performAction();
        }
    }

    public void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    //Method to check permission
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean checkPermission(String permission) {
        int check = checkSelfPermission(permission);
        return check == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ((REQ == requestCode) && (permissions.length == grantResults.length)) {
            for (int i = 0; i < grantResults.length; ++i) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
            }
            //Execute the function if all of permissions are granted
            performAction();
        }
    }

    private void performAction() {
        SMSReceiver receiver = new SMSReceiver();
        //Register for the SMSReceiver
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver, intentFilter);
        registerState = true;

        //Yeu cau quyen admin.
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (receiver != null) {
            unregisterReceiver(receiver);
            registerState = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Re-Register for SMSRceiver
        if (!registerState) {
            registerReceiver(receiver, intentFilter);
        }
    }

    public void lock() {
        boolean isAdminActive = devicePolicyManager.isAdminActive(componentName);
        if (isAdminActive) {
            devicePolicyManager.lockNow();
        } else {
            Toast.makeText(this, "Yeu cau cap quyen admin cho ung dung!", Toast.LENGTH_SHORT).show();
        }
    }
}
