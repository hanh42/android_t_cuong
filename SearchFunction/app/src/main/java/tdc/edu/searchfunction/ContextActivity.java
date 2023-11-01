package tdc.edu.searchfunction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextActivity extends AppCompatActivity {
    private Button btn;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_layout);
        btn = findViewById(R.id.main_btn);
        constraintLayout = findViewById(R.id.main_screen);
        //Dang ky man hinh
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        menu.setHeaderTitle("Choose color");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.yellow_id:
                Toast.makeText(this, "Vang", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red_id:
                Toast.makeText(this, "Do", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue_id:
                Toast.makeText(this, "xanh", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}