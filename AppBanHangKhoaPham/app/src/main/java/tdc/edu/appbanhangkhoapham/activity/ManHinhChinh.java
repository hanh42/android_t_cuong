package tdc.edu.appbanhangkhoapham.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import tdc.edu.appbanhangkhoapham.R;
import tdc.edu.appbanhangkhoapham.adapter.LoaiSanPhamAdapter;
import tdc.edu.appbanhangkhoapham.model.LoaiSanPham;

public class ManHinhChinh extends AppCompatActivity {
    Toolbar toolbar_ManHinhChinh;
    ViewFlipper viewFlipper_ManHinhChinh;
    RecyclerView recyclerView_ManHinhChinh;
    NavigationView navigationView_ManHinhChinh;
    ListView listView_ManHinhChinh;
    DrawerLayout drawerLayout;
    List<LoaiSanPham> mangLoaiSp;
    LoaiSanPhamAdapter loaiSanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        Actionbar();
        List<LoaiSanPham> mangLoaiSp;
        ActionViewFlipper();
        if (isConnected(this)) {
            Toast.makeText(this, "oke", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ko", Toast.LENGTH_SHORT).show();

        }
    }

    private void ActionViewFlipper() {
        ArrayList<Integer> mangQuangCao = new ArrayList<Integer>();
        mangQuangCao.add(R.drawable.anh1);
        mangQuangCao.add(R.drawable.anh2);
        mangQuangCao.add(R.drawable.anh3);
        mangQuangCao.add(R.drawable.anh4);
        mangQuangCao.add(R.drawable.anh5);
        mangQuangCao.add(R.drawable.anh6);
        mangQuangCao.add(R.drawable.anh5);

        for (int i = 0; i < mangQuangCao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper_ManHinhChinh.addView(imageView);
        }
        viewFlipper_ManHinhChinh.setFlipInterval(3000);
        viewFlipper_ManHinhChinh.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
        viewFlipper_ManHinhChinh.setInAnimation(animation_in);
        viewFlipper_ManHinhChinh.setOutAnimation(animation_out);
    }

    private void Actionbar() {
        setSupportActionBar(toolbar_ManHinhChinh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_ManHinhChinh.setNavigationIcon(R.drawable.left_menu);
//        Catch clip action
        toolbar_ManHinhChinh.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Move to center screnn
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }


    private boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (mobile != null && mobile.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    public void anhXa() {
        drawerLayout = findViewById(R.id.DrawerLayout_manhinhchinh);
        toolbar_ManHinhChinh = findViewById(R.id.Toolbar_manhinhchinh);
        viewFlipper_ManHinhChinh = findViewById(R.id.ViewFlipper_manhinhchinh);
        recyclerView_ManHinhChinh = findViewById(R.id.RecyclerView_manhinhchinh);
        navigationView_ManHinhChinh = findViewById(R.id.NavigationView_manhinhchinh);
        listView_ManHinhChinh = findViewById(R.id.ListView_manhinhchinh);
        //khoi tao List
        mangLoaiSp = new ArrayList<>();
        //Khoi tao adapter
        loaiSanPhamAdapter = new LoaiSanPhamAdapter(mangLoaiSp, getApplicationContext());
        listView_ManHinhChinh.setAdapter(loaiSanPhamAdapter);
    }
}