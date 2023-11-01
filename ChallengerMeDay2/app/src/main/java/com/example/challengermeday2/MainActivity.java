package com.example.challengermeday2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.admin.DeviceAdminService;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.challengermeday2.Adapter.FoodAdapter;
import com.example.challengermeday2.Model.Food;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int firstTime = -1;
    private LinearLayout linearLayoutPrevious;
    private int originColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recyclerViewMain);
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("1", R.drawable.ic_launcher_background));
        foods.add(new Food("2", R.drawable.ic_launcher_background));
        foods.add(new Food("3", R.drawable.ic_launcher_background));
        foods.add(new Food("4", R.drawable.ic_launcher_background));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        FoodAdapter foodAdapter = new FoodAdapter(R.layout.food_item, this, foods);
        recyclerView.setAdapter(foodAdapter);
        foodAdapter.setOnItemRecyclerViewListener(new FoodAdapter.OnItemRecyclerViewListener() {
            @Override
            public void itemClickListener(int pos, CardView cardView) {
                if (firstTime == -1) {
                    printColor(pos, cardView);
                } else {
                    if (firstTime == pos) {
                        linearLayoutPrevious.setBackgroundColor(originColor);
                        firstTime = -1;
                    } else {
                        linearLayoutPrevious.setBackgroundColor(originColor);
                        printColor(pos, cardView);
                    }
                }
            }

            void printColor(int pos, CardView cardView) {
                firstTime = pos;
                LinearLayout originLayout = cardView.findViewById(R.id.linearLayoutItem);
                originColor = originLayout.getSolidColor();
                linearLayoutPrevious = originLayout;
                originLayout.setBackgroundColor(getResources().getColor(R.color.black));
            }

            @Override
            public void itemLongLickListener(int pos, CardView cardView) {
                Toast.makeText(MainActivity.this, "longClick" + pos, Toast.LENGTH_SHORT).show();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN|ItemTouchHelper.UP,
                ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}