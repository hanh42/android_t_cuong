package tdc.edu.broadcastnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Send Masseger
//        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, "Message to send");
//        PackageManager packageManager = getPackageManager();
//        ComponentName componentName = intent.resolveActivity(packageManager);
//        if (componentName == null) {
//        } else {
//            startActivity(intent);
//        }

        //Call
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "0988244510");
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = intent.resolveActivity(packageManager);
        if (componentName == null) {
        } else {
            startActivity(intent);
        }


    }
}