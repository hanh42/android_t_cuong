package tdc.edu.testbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0911436025"));
//        PackageManager packageManager = getPackageManager();
//        ComponentName componentName = intent.resolveActivity(packageManager);
//        if(componentName == null){
//            Toast.makeText(this, "The App doesnt contain", Toast.LENGTH_SHORT).show();
//        }else{
//            startActivity(intent);
//        }


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Message To send");
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = intent.resolveActivity(packageManager);
        if (componentName == null) {
            Toast.makeText(this, "The Apps arent install", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(intent);
        }

    }
}