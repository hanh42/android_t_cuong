package com.example.swiperefreshlayout_day1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private boolean isLastPage;
    private boolean isLoading;
    private int currentPage = 1;
    private int totalPage = 5;
    private ArrayList<Cart> carts2;

    private ProgressBar progressBar;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fakeData();
        anhXa();
        drawLine();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAdapter = new MyAdapter(this, R.layout.home_item, fakeData());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnScrollListener(new PadginatioiScroll(linearLayoutManager) {
            @Override
            public void loadMoreitems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage();
            }


            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
        });

    }

    public void loadNextPage() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Cart> list = fakeData();
                carts2.addAll(list);
                myAdapter.notifyDataSetChanged();
                isLoading = false;
                if (currentPage == totalPage) {
                    isLastPage = true;
                }
            }
        }, 2000);
    }

    public void drawLine() {
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void anhXa() {
        progressBar = findViewById(R.id.progressbar_id);
        carts2 = fakeData();
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        recyclerView = findViewById(R.id.txt_recycler_view);
    }

    public ArrayList<Cart> fakeData() {
        ArrayList<Cart> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(new Cart("hanh" + i));
        }
        return arrayList;
    }
}