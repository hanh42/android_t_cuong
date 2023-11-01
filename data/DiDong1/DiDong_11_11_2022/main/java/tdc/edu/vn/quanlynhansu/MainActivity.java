package tdc.edu.vn.quanlynhansu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import tdc.edu.vn.quanlynhansu.view_models.MyRadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rd_TrungCap = findViewById(R.id.rd_TrungCap);
        RadioButton rd_CaoDang = findViewById(R.id.rd_Caodang);
        RadioButton rd_DaiHoc = findViewById(R.id.rd_Daihoc);

        Button btn_them = findViewById(R.id.btn_Them);
        Button btn_thoat = findViewById(R.id.btn_Thoat);

        MyRadioGroup radioGroup = new MyRadioGroup(rd_TrungCap,rd_CaoDang,rd_DaiHoc);

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onStop();
              onDestroy();
            }
        });
    }
}
