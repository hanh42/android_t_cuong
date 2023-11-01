package tdc.edu.vn.quanlynhansu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.adapters.MyListViewAdapter;

public class MainActivity extends AppCompatActivity {

    public static String DAIHOC = "University";
    public static String CAODANG = "College";
    public static String TRUNGCAP = "Tranning";
    public static String KHONGBANGCAP = "Non";

    private ArrayList<Persion> listMember = new ArrayList<Persion>();
    //    private ArrayAdapter<Persion> adapter;
    private MyListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlynhansu_contrain_layout);

        final EditText edtName = (EditText) findViewById(R.id.editTextName);
        final RadioGroup radGroup = findViewById(R.id.radioGroup);
        final CheckBox ckRead = findViewById(R.id.checkBoxRead);
        final CheckBox ckTravel = findViewById(R.id.checkBoxTravel);
        final EditText edtOtherHoppies = findViewById(R.id.editTextOtherHoppies);
        ListView listView = findViewById(R.id.listView);

        adapter = new MyListViewAdapter(this, R.layout.imageview, listMember);
        listView.setAdapter(adapter);

        Button btn_them = findViewById(R.id.btnAdd);
        Button btn_thoat = findViewById(R.id.btnCancer);

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtName.getText().toString().isEmpty()) {
                    Persion nhanSu = new Persion();
                    nhanSu.setHoVaTen(edtName.getText().toString());
                    int id = radGroup.getCheckedRadioButtonId();
                    switch (id) {
                        case R.id.radMedium:
                            nhanSu.setBangCap(TRUNGCAP);
                            break;
                        case R.id.radCollect:
                            nhanSu.setBangCap(CAODANG);
                            break;
                        case R.id.radUniver:
                            nhanSu.setBangCap(DAIHOC);
                            break;
                        default:
                            nhanSu.setBangCap(KHONGBANGCAP);
                            break;
                    }
                    String hoppies = "";
                    if (ckRead.isChecked()) {
                        hoppies += ckRead.getText() + ";";
                    }
                    if (ckTravel.isChecked()) {
                        hoppies += ckTravel.getText() + ";";
                    }
                    hoppies += edtOtherHoppies.getText();
                    nhanSu.setSoThich(hoppies);
                    listMember.add(nhanSu);
                    adapter.notifyDataSetChanged();

                    edtName.setText("");
                    radGroup.clearCheck();
                    ckRead.setChecked(false);
                    ckTravel.setChecked(false);
                    edtOtherHoppies.setText("");
                    edtName.requestFocus();
                }
            }
        });

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//             finishAffinity(); quay ve home cho nhieu man hinh
            }
        });
    }

    //Show the option menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuSave:
                save();
                break;
            case R.id.mnuEdit:
                edit();
                break;
            case R.id.mnuDelete:
                delete();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save(){
        Toast.makeText(this,"save()",Toast.LENGTH_LONG).show();
    }

    private void edit(){
        Toast.makeText(this,"edit()",Toast.LENGTH_LONG).show();
    }
    private void delete(){
        Toast.makeText(this,"delete()",Toast.LENGTH_LONG).show();
    }


}
