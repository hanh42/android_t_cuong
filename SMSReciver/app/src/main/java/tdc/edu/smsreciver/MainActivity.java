package tdc.edu.smsreciver;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int REQ = 99;
    private TextView txt;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        if (checkPermission(Manifest.permission.SEND_SMS)) {
//            call(edt.getText().toString());
        } else {
            //B3 :Request to user grand the permission !.
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, REQ);
        }
    }


    //B2: Check permission function definitions
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean checkPermission(String permissions) {
        int check = checkSelfPermission(permissions);
        //grandted = allow.
        if (check == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


    //B4: User 'S permission Processing.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //gia tri tra ve phai cung -> da duoc dong y.
        if ((REQ == requestCode) && (permissions.length == grantResults.length)) {
            int i = 0;
            for (; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    break;
                }
            }
            if (i == grantResults.length) {
//                call(edt.getText().toString());
            }
        }
    }


    //goi cho nao cap quyen cho do!
    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

}