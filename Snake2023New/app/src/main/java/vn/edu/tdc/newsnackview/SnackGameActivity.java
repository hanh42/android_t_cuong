package vn.edu.tdc.newsnackview;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import vn.edu.tdc.newsnackview.views.Snake;

public class SnackGameActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create snack view
        Snake view = new Snake(this,getResources().getColor(R.color.bugColor, getTheme()), getResources().getColor(R.color.foodColor, getTheme()));
        view.setBackgroundColor(getResources().getColor(R.color.bgrMainView, getTheme()));
        setContentView(view);
    }
}