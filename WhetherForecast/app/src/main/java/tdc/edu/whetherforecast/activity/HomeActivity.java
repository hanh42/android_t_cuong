package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.adapter.MyHomeMenuRecyclerViewAdapter;
import tdc.edu.whetherforecast.adapter.MySearchRecyclerViewAdapter;
import tdc.edu.whetherforecast.model.Cart;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private RecyclerView recyclerView_category;
    private RecyclerView recyclerView_menu;
    private MyHomeMenuRecyclerViewAdapter myAdapter;
    private ArrayList<Cart> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        fakeData();
        anhXa();
        ActionViewFlipper();
        recyclerView_menu.setFocusable(false);
        recyclerView_menu.setNestedScrollingEnabled(false);
    }

    public void fakeData() {
        Cart cart = new Cart("Com heo", 12, 2000, R.drawable.food2, 5);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
    }

    public void anhXa() {
        recyclerView_menu = findViewById(R.id.recyclerView_menu_home_screen);
        recyclerView_category = findViewById(R.id.recyclerView_category_home_screen);
        viewFlipper = findViewById(R.id.viewFlipper_home_screen);
        //Setup category recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView_category.setLayoutManager(layoutManager);
//        MySearchRecyclerViewAdapter mySearchRecyclerViewAdapter = new MySearchRecyclerViewAdapter(this, R.layout.home_layout_category_item, arrayList);
//        recyclerView_category.setAdapter(mySearchRecyclerViewAdapter);
        //Setup menu recyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_menu.setLayoutManager(gridLayoutManager);
        myAdapter = new MyHomeMenuRecyclerViewAdapter(this, R.layout.home_layout_menu_item, arrayList);
        recyclerView_menu.setAdapter(myAdapter);
    }

    private void ActionViewFlipper() {
        ArrayList<Integer> mangQuangCao = new ArrayList<Integer>();
        mangQuangCao.add(R.drawable.anh1);
        mangQuangCao.add(R.drawable.anh2);
        mangQuangCao.add(R.drawable.anh3);
        mangQuangCao.add(R.drawable.anh4);
        mangQuangCao.add(R.drawable.anh5);
        mangQuangCao.add(R.drawable.anh6);

        for (int i = 0; i < mangQuangCao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
        viewFlipper.setInAnimation(animation_in);
        viewFlipper.setOutAnimation(animation_out);
    }
}