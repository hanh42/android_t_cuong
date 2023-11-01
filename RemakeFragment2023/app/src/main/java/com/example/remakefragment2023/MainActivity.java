package com.example.remakefragment2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    private int questionId;
    private AbstractFragment fragment = null;
    private BottomNavigationView bottomNavigationView;
    private ImageButton imageButton;

    //----------------------------------
    private static Activity mainActivitySave;

    public static void setMainActivitySave(Activity mainActivitySave) {
        MainActivity.mainActivitySave = mainActivitySave;
    }

    public static Activity getMainActivitySave() {
        return mainActivitySave;
    }
    //------------------------------------------

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //gan bien de no con biet duong de tai su dung
        questionId = 0;
        //---------Gan gia tri de xai o nhieu noi goi--------
        MainActivity.setMainActivitySave(MainActivity.this);
        //-----------Anh xa ------------------
        anhXa();
        //----------Set number-------//
        createNum(4, 1);
        //------------------------//
        //Set default selected
        updateUI(1);
        //Click to visiable navigationView left
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.HOME:
                        updateUI(1);
                        break;
                    case R.id.CART:
                        updateUI(2);
                        break;
                    case R.id.USER:
                        updateUI(3);
                        break;
                }
                return true;
            }
        });
    }

    private void anhXa() {
        imageButton = findViewById(R.id.img_btn_nav_left);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
    }

    private void updateUI(int abstractFragment) {
        questionId = abstractFragment;
        if (getSupportFragmentManager().findFragmentByTag(questionId + "") != null) {
            fragment = (AbstractFragment) getSupportFragmentManager().findFragmentByTag(questionId + "");
        } else {
            switch (abstractFragment) {
                case 1:
                    Log.d("TAG", "updateUI: 1");
                    fragment = new HomeFragment();
                    break;
                case 2:
                    Log.d("TAG", "updateUI: 2");
                    fragment = new CartFragment();
                    break;
                case 3:
                    Log.d("TAG", "updateUI: 3");
                    fragment = new UserFragment();
                    break;
            }
        }
        if (fragment != null) {
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, questionId + "");
            if (getSupportFragmentManager().findFragmentByTag(questionId + "") == null) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
    }


    public void createNum(int number, int menu) {
        Context context = MainActivity.getMainActivitySave();
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

            }
        });
        BadgeDrawable badgeExplorer = null;
        switch (menu) {
            case 1:
                badgeExplorer = bottomNavigationView.getOrCreateBadge(R.id.HOME);
                break;
            case 2:
                badgeExplorer = bottomNavigationView.getOrCreateBadge(R.id.CART);
                break;
            case 3:
                badgeExplorer = bottomNavigationView.getOrCreateBadge(R.id.USER);
                break;
        }
        if (number >= 1) {
            badgeExplorer.setVisible(true);
            badgeExplorer.setVerticalOffset(dpToPx(context, 1));
            badgeExplorer.setNumber(number);
            //MARK
            badgeExplorer.setBackgroundColor(getMainActivitySave().getColor(R.color.black));
            badgeExplorer.setBadgeTextColor(getMainActivitySave().getColor(R.color.white));
        } else {
            badgeExplorer.setVisible(false);
            badgeExplorer.setBackgroundColor(getMainActivitySave().getColor(R.color.white));
            badgeExplorer.setBadgeTextColor(getMainActivitySave().getColor(R.color.white));
        }
    }

    public static int dpToPx(Context context, int dp) {
        Resources resource = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ((Resources) resource).getDisplayMetrics()));
    }

}