package tdc.edu.mymessage;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyMessageActivity extends AppCompatActivity {
    private int REQ = 99;
    private Button btn;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_layout);
        anhXa();
        Intent intent = getIntent();
        String msg = intent.getStringExtra(Intent.EXTRA_TEXT);
        edt.setText(msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                //The permission if alowed.
                if (checkPermission(Manifest.permission.CALL_PHONE)) {
                    call(edt.getText().toString());
                } else {
                    //B3 :Request to user grand the permission !.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQ);
                }
            }
        });
    }

    //goi cho nao cap quyen cho do!
    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
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
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    break;
                }
            }
            if(i == grantResults.length){
                call(edt.getText().toString());
            }
        }
    }

    //Call functions
    public void anhXa() {
        btn = findViewById(R.id.btn);
        edt = findViewById(R.id.edt);
    }
}