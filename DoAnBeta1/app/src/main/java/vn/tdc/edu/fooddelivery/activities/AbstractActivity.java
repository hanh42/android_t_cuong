package vn.tdc.edu.fooddelivery.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import tdc.edu.doanbeta1.R;

public abstract class AbstractActivity extends AppCompatActivity {
    private Toolbar toolbar;

    protected void createActionBar() {
        setTitle(getIntent().getAction());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void switchActivity(Class<?> targetActivity, String action) {
        Intent intent = new Intent(this, targetActivity);
        intent.setAction(action);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
