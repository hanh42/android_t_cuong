package tdc.edu.vn.ltdd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

public class ChooseOperationActivity extends AppCompatActivity {
private String strValueA, strValueB;
private SharedPreferences sharedPreferences;
private String PREF = "pref";
//public static String result;
public static String RESULT_KEY = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_operation_layout);
        sharedPreferences = getSharedPreferences(PREF,MODE_PRIVATE);

        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);

        Button cong = findViewById(R.id.btnCong);
        Button tru = findViewById(R.id.btnTru);
        Button nhan = findViewById(R.id.btnNhan);
        Button chia = findViewById(R.id.btnChia);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = strValueA + " + " + strValueB + " = " + String.valueOf(Double.parseDouble(strValueA) + Double.parseDouble(strValueB));
                sharedPreferences.edit().putString(RESULT_KEY,result);
                sharedPreferences.edit().commit();
                Log.d("test",result);

                Intent intent = new Intent(ChooseOperationActivity.this,CalculatorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = strValueA + " - " + strValueB + " = " + String.valueOf(Double.parseDouble(strValueA) - Double.parseDouble(strValueB));
                Intent intent = new Intent(ChooseOperationActivity.this,CalculatorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = strValueA + " * " + strValueB + " = " + String.valueOf(Double.parseDouble(strValueA) * Double.parseDouble(strValueB));
                Intent intent = new Intent(ChooseOperationActivity.this,CalculatorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = strValueA + " / " + strValueB + " = " + String.valueOf(Double.parseDouble(strValueA) / Double.parseDouble(strValueB));
                Intent intent = new Intent(ChooseOperationActivity.this,CalculatorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        //get data from CalculatorActivity
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra(CalculatorActivity.DATA_KEY);
        if(data != null){
            strValueA = data.getString(CalculatorActivity.A_KEY);
            strValueB = data.getString(CalculatorActivity.B_KEY);
            edtA.setText(strValueA);
            edtB.setText(strValueB);
        }
    }
}
