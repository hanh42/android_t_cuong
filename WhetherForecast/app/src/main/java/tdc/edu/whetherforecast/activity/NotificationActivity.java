package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.whetherforecast.R;
import tdc.edu.whetherforecast.adapter.MyNotificationRecyclerViewAdapter;
import tdc.edu.whetherforecast.model.Notification;

public class NotificationActivity extends AppCompatActivity {
    private ArrayList<Notification> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyNotificationRecyclerViewAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
        anhXa();
        fakeData();
    }

    public void anhXa() {
        recyclerView = findViewById(R.id.recyclerView_notification_screen);
        //Setup
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyNotificationRecyclerViewAdapter(this, R.layout.notification_layout_item, arrayList);
        recyclerView.setAdapter(myAdapter);
        clickEvent();
    }

    private void clickEvent() {
        myAdapter.setOnRecyclerViewOnClickListener(new MyNotificationRecyclerViewAdapter.onRecyclerViewOnClickListener() {
            @Override
            public void onItemRecyclerViewClickListener(int position, View cardView) {
                Toast.makeText(NotificationActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fakeData() {
        Notification notification1 = new Notification(R.drawable.ic_baseline_circle_notifications_24,
                "Đặt món thành công",
                1,
                " Đơn hàng bản đã được tiếp nhận và sẽ " +
                        "được giao trong khoảng thời gian sớm nhất" +
                        ". Xin chân thành cảm ơn.");
        Notification notification2 = new Notification(R.drawable.anh_nhopng,
                "Đặt món không thành công",
                1,
                " Đơn hàng bản đã không được tiếp nhận và sẽ " +
                        "được giao trong khoảng thời gian sớm nhất" +
                        ". Xin chân thành cảm ơn.");
        arrayList.add(notification1);
        arrayList.add(notification2);
        arrayList.add(notification1);
        arrayList.add(notification1);
        arrayList.add(notification1);
        arrayList.add(notification1);
    }
}