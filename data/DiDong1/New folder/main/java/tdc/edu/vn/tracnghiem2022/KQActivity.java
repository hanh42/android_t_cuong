package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class KQActivity extends AppCompatActivity {
    private ArrayList<String> listResults = new ArrayList<>();
private ArrayAdapter<AbtracQuestion> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kq_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        ListView listResult = findViewById(R.id.listResult);
        listAdapter = new ArrayAdapter<AbtracQuestion>(this, android.R.layout.simple_list_item_1, Questions.questions);
        listResult.setAdapter(listAdapter);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.state = false;
                Intent intent = new Intent(KQActivity.this, TNKQActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.state = false;
                Intent intent = new Intent(KQActivity.this, TNKQActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        listAdapter.notifyDataSetChanged();
    }
}
