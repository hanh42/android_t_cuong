package tdc.edu.a26_3_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tdc.edu.a26_3_2023.Model.Currency;
import tdc.edu.a26_3_2023.api.ApiService;

public class MainActivity extends AppCompatActivity {
    private TextView txt_term, txt_source,txt_usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_term = findViewById(R.id.txt_term);
        txt_source = findViewById(R.id.txt_source);
        txt_usd = findViewById(R.id.txt_usd);
        Button btn = findViewById(R.id.main_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAPI();
            }
        });
    }

    private void clickAPI() {
        //Link API :http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1

        ApiService.apiService.convertAPI("843d4d34ae72b3882e3db642c51e28e6",
                "VND",
                "USD",
                1).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this, "Call API succes", Toast.LENGTH_SHORT).show();
                Currency currency = response.body();
                if (currency != null) {
                   txt_usd.setText(currency.getHello()+"");
                    txt_term.setText(currency.getError().getCode()+"");
                    txt_source.setText(currency.getError().getInfo()+"");
                }else{
                    Toast.makeText(MainActivity.this, "Call API false", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call API error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ;

}