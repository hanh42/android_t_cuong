package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import tdc.edu.vn.tracnghiem2022.R;
import androidx.appcompat.app.AppCompatActivity;

import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class KetQuaActivity extends AppCompatActivity {

    private ArrayAdapter<AbstractQuestion> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen6);

        //Get views form layout
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);
        ListView listView = findViewById(R.id.listView);
        Button btnTinhDiem = findViewById(R.id.btnTinhDiem);


        adapter = new ArrayAdapter<AbstractQuestion>(this,android.R.layout.simple_list_item_1,Questions.questions);

        listView.setAdapter(adapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.state = false;
                Intent intent = new Intent(KetQuaActivity.this, TNKQActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.state = false;
                Intent intent = new Intent(KetQuaActivity.this, TNKQActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });
        btnTinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
