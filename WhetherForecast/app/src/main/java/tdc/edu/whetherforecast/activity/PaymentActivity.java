package tdc.edu.whetherforecast.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import tdc.edu.whetherforecast.R;

public class PaymentActivity extends AppCompatActivity {
    private Button buttonBack;
    private Button buttonBuy;
    private EditText edt_date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);
        anhXa();
        AnhXaDatePicket();
//        Catch event back click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "Quay lai", Toast.LENGTH_SHORT).show();
            }
        });
//        Catch event buy click
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "Mua", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void AnhXaDatePicket() {
        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(PaymentActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                m = m + 1;
                String dateValue = d + "/" + m + "/" + y;
                edt_date.setText(dateValue);
            }
        };
    }

    public void anhXa() {
        edt_date = findViewById(R.id.edt_date_receive_item_payment_screen);
        buttonBack = findViewById(R.id.btn_back_payment_screen);
        buttonBuy = findViewById(R.id.btn_buy_payment_screen);
    }
}