package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.adapter.MyDetailRecyclerViewAdapter;
import tdc.edu.whetherforecast.model.Cart;

public class DetailFoodActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyDetailRecyclerViewAdapter myRecycleViewAdapter;
    private ArrayList<Cart> arrayList = new ArrayList<>();
    private Button buttonBack;
    private Button buttonHeart;
    private Button buttonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        anhXa();
        createFakeData();
        ClickEvent();
        //Catch event click button back
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailFoodActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });
        //        Catch event click button back
        buttonHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailFoodActivity.this, "heart", Toast.LENGTH_SHORT).show();
            }
        });
        //        Catch event click button back
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailFoodActivity.this, "cart", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void anhXa() {
        buttonBack = findViewById(R.id.btn_back_detail_screen);
        buttonCart = findViewById(R.id.btn_cart_detail_screen);
        buttonHeart = findViewById(R.id.btn_heart_detail_screen);
        recyclerView = findViewById(R.id.recyclerView_detail_screen);
        //Setup
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        myRecycleViewAdapter = new MyDetailRecyclerViewAdapter(this, R.layout.detail_layout_item, arrayList);
        recyclerView.setAdapter(myRecycleViewAdapter);
    }

    public void createFakeData() {
        Cart cart = new Cart("ca chien", 12, 9999, R.drawable.anh_nhopng,1);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
        arrayList.add(cart);
    }

    //Catch event click
    public void ClickEvent() {
        myRecycleViewAdapter.set_OnRecyclerViewOnClickListener(new MyDetailRecyclerViewAdapter.onRecyclerViewOnClickListener() {
            @Override
            public void onItemRecyclerViewOnClickListener(int p, View CardView) {
                Toast.makeText(DetailFoodActivity.this, "" + p, Toast.LENGTH_SHORT).show();
            }
        });
    }

}