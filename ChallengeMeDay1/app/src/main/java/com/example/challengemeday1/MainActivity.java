package com.example.challengemeday1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.challengemeday1.Adapter.FoodAdapter;
import com.example.challengemeday1.Model.Food;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MainActivity extends AppCompatActivity {
    private LinearLayout previousCell;
    private int selectedCell = -1;
    private int originColor;

    private FoodAdapter foodAdapter;
    ImageSlider imageSlider;
    RecyclerView recyclerView;

    ArrayList<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        binding();
        List<SlideModel> banners = new ArrayList<>();
        banners.add(new SlideModel(R.drawable.banner_1, null));
        banners.add(new SlideModel(R.drawable.banner_1, null));
        banners.add(new SlideModel(R.drawable.banner_1, null));
        imageSlider.setImageList(banners, ScaleTypes.CENTER_CROP);
//        recyclerView.setFocusable(false);
//        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        foodAdapter = new FoodAdapter(this, R.layout.food_item, foods);
        recyclerView.setAdapter(foodAdapter);
        foodAdapter.setOnRecyclerItemViewClickListener(new FoodAdapter.OnRecyclerItemViewClickListener() {
            @Override
            public void onItemClickListener(int p, View cardView) {
                if (selectedCell == -1) {
                    LinearLayout originLayout = cardView.findViewById(R.id.linear_layout_item);
                    originColor = originLayout.getSolidColor();
                    originLayout.setBackgroundColor(getResources().getColor(R.color.green_rgba, getTheme()));
                    previousCell = originLayout;
                    selectedCell = p;
                } else {
                    if (selectedCell == p) {
                        previousCell.setBackgroundColor(originColor);
                        selectedCell = -1;
                        previousCell = null;
                    } else {
                        previousCell.setBackgroundColor(originColor);
                        LinearLayout originLayout = cardView.findViewById(R.id.linear_layout_item);
                        originColor = originLayout.getSolidColor();
                        originLayout.setBackgroundColor(getResources().getColor(R.color.green_rgba, getTheme()));
                        previousCell = originLayout;
                        selectedCell = p;
                    }
                }
            }

            @Override
            public void onItemLongClickListener(int p, View CardView) {
//                Toast.makeText(MainActivity.this, "longClick", Toast.LENGTH_SHORT).show();
            }
        });


        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPos = viewHolder.getAdapterPosition();
                int toPos = target.getAdapterPosition();
                List<Food> foodsList = foods;
                Collections.swap(foodsList, fromPos, toPos);
                foodAdapter.notifyItemMoved(fromPos, toPos);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int p = viewHolder.getAdapterPosition();
                Food deleteFood = foods.get(p);
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                        foods.remove(p);
                        foodAdapter.notifyDataSetChanged();
                        Snackbar.make(recyclerView, "Đã xóa " + deleteFood.getName(), Snackbar.LENGTH_SHORT)
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        foods.add(p, deleteFood);
                                        foodAdapter.notifyDataSetChanged();
                                    }
                                }).show();
                        break;
                    case ItemTouchHelper.RIGHT:
                        foods.remove(p);
                        foodAdapter.notifyDataSetChanged();
                        break;
                }
            }


            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addSwipeLeftBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.black))
                        .addSwipeRightBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green_rgba))
                        .addSwipeLeftActionIcon(R.drawable.chum_nho)
                        .addSwipeRightActionIcon(R.drawable.con_chim)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    void binding() {
        imageSlider = findViewById(R.id.image_slider);
        recyclerView = findViewById(R.id.recyclerViewId);
    }

    void createData() {
        foods = new ArrayList<>();
        foods.add(new Food("Food1", 1300, R.drawable.banner_1));
        foods.add(new Food("Food1", 1300, R.drawable.banner_2));
        foods.add(new Food("Food1", 1300, R.drawable.banner_3));
        foods.add(new Food("Food1", 1300, R.drawable.banner_4));
        foods.add(new Food("Food1", 1300, R.drawable.banner_5));
    }


}