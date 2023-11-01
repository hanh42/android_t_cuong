package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.adapter.MyCartRecycleViewAdapter;
import tdc.edu.whetherforecast.model.Cart;

public class CartScreenActivity extends AppCompatActivity {
    private MyCartRecycleViewAdapter myRecycleViewAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Cart> cartArrayList = new ArrayList<>();
    private TextView total_cart_screen;
    private Button order_btn_cart_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);
        CreateData();
        AnhXa();
        ClickEvent();
        CalculateAndAssign(cartArrayList);
        //Catch event click into Add btn
        order_btn_cart_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CartScreenActivity.this, "Ban muon dat hang u", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Calculate total and assign to TextViewTotal
    public void CalculateAndAssign(ArrayList<Cart> cartArrayList) {
        int sum = 0;
        for (int i = 0; i < cartArrayList.size(); i++) {
            sum += cartArrayList.get(i).getPrice() * cartArrayList.get(i).getQty();
        }
        String value = formatCurrentcy(sum+"");
        total_cart_screen.setText(value+" đồng ");
    }

    //Catch event click
    public void ClickEvent() {
        myRecycleViewAdapter.set_onRecyclerViewOnClickListener(new MyCartRecycleViewAdapter.onRecyclerViewOnClickListener() {
            @Override
            public void onItemRecyclerViewOnClickListener(int p, View CardView) {
                Toast.makeText(CartScreenActivity.this, "" + p, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Create fake data
    public void CreateData() {
        Cart cart = new Cart("ca chien", 12, 9999, R.drawable.anh_nhopng,1);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
        cartArrayList.add(cart);
    }

    //Anh xa
    public void AnhXa() {
        total_cart_screen = findViewById(R.id.total_cart_screen);
        order_btn_cart_screen = findViewById(R.id.btn_order_btn_cart_screen);
        recyclerView = findViewById(R.id.recyclerView_card_screen);
        //Setup
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myRecycleViewAdapter = new MyCartRecycleViewAdapter(this, R.layout.cart_layout_item, cartArrayList);
        recyclerView.setAdapter(myRecycleViewAdapter);
    }

    public String formatCurrentcy(String value) {
        int count = (value.length()) / 3;
        double flag = ((value.length()) / (3 * 1.0));
        String total = "";
        String temp = "";
        if (flag > 1) {
            for (int i = 1; i <= count; i++) {
                int node = (value.length()) - (i * 3);
                temp = value.substring(node, node + 3);
                if ((i == count) && (value.length() % 3 == 0)) {
                    total = temp + total;
                } else {
                    total = "," + temp + total;
                    if ((i == count) && (value.length() % 3 != 0)) {
                        temp = value.substring(0, value.length() - count * 3);
                        total = temp + total;
                    }
                }

            }
        } else {
            total = value;
        }
        return total;
    }
}