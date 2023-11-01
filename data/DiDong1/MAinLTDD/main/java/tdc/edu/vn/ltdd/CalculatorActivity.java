package tdc.edu.vn.ltdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    public static String DATA_KEY = "data";
    public static String A_KEY = "A";
    public static String B_KEY = "B";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        //Get views from layout
        final EditText edtA = findViewById(R.id.edtA);
        final EditText edtB = findViewById(R.id.edtB);
        final EditText edtResult = findViewById(R.id.edtResult);
        Button btnCalculator = findViewById(R.id.btnCalculator);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("test", "Called");

                //get the values of A and B
                String strValueA = edtA.getText().toString();
                String strValueB = edtB.getText().toString();
                //Prepair for transmit A and B to the ChooseOperationActivity
                Bundle data = new Bundle();
                data.putString(A_KEY, strValueA);
                data.putString(B_KEY, strValueB);

                // String strValueResult = edtResult.getText().toString();


                //Change activity: go to the Choose Operation
                Intent intent = new Intent(CalculatorActivity.this,ChooseOperationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra(DATA_KEY,data);
                startActivity(intent);
            }
        });
    }
}
