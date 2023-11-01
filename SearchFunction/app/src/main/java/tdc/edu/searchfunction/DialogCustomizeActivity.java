package tdc.edu.searchfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogCustomizeActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_customize_layout);
        btn = findViewById(R.id.main_btn_alert_dialog_screen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLogin();
            }
        });
    }


    public void dialogLogin() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custome_alert_dialog_item);
        dialog.show();

        //Anh xa
        Button button = (Button) dialog.findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogCustomizeActivity.this, "Login actions", Toast.LENGTH_SHORT).show();
            }
        });
    }
}