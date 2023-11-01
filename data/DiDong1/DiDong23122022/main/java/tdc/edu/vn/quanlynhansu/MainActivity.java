package tdc.edu.vn.quanlynhansu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import tdc.edu.vn.quanlynhansu.adapters.MyListViewAdapter;
import tdc.edu.vn.quanlynhansu.database_layer.PersionDatabase;

public class MainActivity extends AppCompatActivity {

    public static String DAIHOC = "University";
    public static String CAODANG = "College";
    public static String TRUNGCAP = "Tranning";
    public static String KHONGBANGCAP = "Non";
    private EditText edtName, edtOtherHoppies;
    private RadioButton radMedium, radCollect, radUniver;
    private CheckBox ckRead, ckTravel;
    private RadioGroup radGroup;
    private ArrayList<Persion> listMember = new ArrayList<Persion>();
    private MyListViewAdapter adapter;
    private PersionDatabase dao;
    private int selectedRow = -1;
    private int backColor;
    private LinearLayout previousItemGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlynhansu_contrain_layout);

        dao = new PersionDatabase(this);
        dao.getPersion(listMember);
        edtName = (EditText) findViewById(R.id.editTextName);
        radCollect = findViewById(R.id.radCollect);
        radMedium = findViewById(R.id.radMedium);
        radUniver = findViewById(R.id.radUniver);
        radGroup = findViewById(R.id.radioGroup);
        ckRead = findViewById(R.id.checkBoxRead);
        ckTravel = findViewById(R.id.checkBoxTravel);
        edtOtherHoppies = findViewById(R.id.editTextOtherHoppies);
        ListView listView = findViewById(R.id.listView);
        final Button btn_them = findViewById(R.id.btnAdd);
        Button btn_thoat = findViewById(R.id.btnCancer);

        adapter = new MyListViewAdapter(this, R.layout.imageview, listMember);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"List view item",Toast.LENGTH_LONG).show();
                if (selectedRow == -1) {
                    selectedRow = position;
                    disableAdd(btn_them);
                    setPersionToLayout(listMember.get(position));
                    LinearLayout bgrItem = view.findViewById(R.id.bgrListViewItem);
                    backColor = bgrItem.getSolidColor();// luu lai bgr cull
                    bgrItem.setBackgroundColor(getResources().getColor(R.color.btn_bgrColor, getTheme()));
                    previousItemGround = bgrItem;
                } else {
                    if(selectedRow == position){
                        selectedRow = -1;
                        clear();
                        previousItemGround.setBackgroundColor(backColor);
                    }
                    else {

                    }
                }
            }
        });


        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!edtName.getText().toString().isEmpty()) {
//                    Persion nhanSu = new Persion();
//                    nhanSu.setHoVaTen(edtName.getText().toString());
//                    int id = radGroup.getCheckedRadioButtonId();
//                    switch (id) {
//                        case R.id.radMedium:
//                            nhanSu.setBangCap(TRUNGCAP);
//                            break;
//                        case R.id.radCollect:
//                            nhanSu.setBangCap(CAODANG);
//                            break;
//                        case R.id.radUniver:
//                            nhanSu.setBangCap(DAIHOC);
//                            break;
//                        default:
//                            nhanSu.setBangCap(KHONGBANGCAP);
//                            break;
//                    }
//                    String hoppies = "";
//                    if (ckRead.isChecked()) {
//                        hoppies += ckRead.getText() + ";";
//                    }
//                    if (ckTravel.isChecked()) {
//                        hoppies += ckTravel.getText() + ";";
//                    }
//                    hoppies += edtOtherHoppies.getText();
//                    nhanSu.setSoThich(hoppies);
//                    listMember.add(nhanSu);
//                    dao.savePersion(nhanSu);
//                    adapter.notifyDataSetChanged();
//
//                    clear();
//                }
                Persion nhanSu = createPersionFromLayout();
                if (nhanSu != null) {
                    listMember.add(nhanSu);
                    dao.savePersion(nhanSu);
                    adapter.notifyDataSetChanged();
                    clear();
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
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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

    private void save() {
        dao.savePersions(listMember);
//        Toast.makeText(this,"The Persion are save",Toast.LENGTH_LONG).show();
    }

    private void edit() {
        if (selectedRow != -1) {
            Toast.makeText(this, "edit()", Toast.LENGTH_LONG).show();
        } else {
            showDialog("Update...", "You must select one row before delete", "Hide update");
        }

    }

    private void delete() {
        if (selectedRow != -1) {
            Toast.makeText(this, "delete()", Toast.LENGTH_LONG).show();
        } else {
            showDialog("Delete...", "You must select one row before update", "Hide delete");
        }
    }

    private void showDialog(String title, String message, String btnName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog;
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(btnName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog = builder.create();
        dialog.show();
    }

    private void enableAdd(Button add) {
        add.setEnabled(true);
    }

    private void disableAdd(Button add) {
        add.setEnabled(false);
    }

    private void setPersionToLayout(Persion persion) {
        clear();
        edtName.setText(persion.getHoVaTen());
        if (persion.getBangCap().equalsIgnoreCase(DAIHOC)) {
           radUniver.setChecked(true);
        }
        else if (persion.getBangCap().equalsIgnoreCase(CAODANG)) {
            radCollect.setChecked(true);
        }
        else if (persion.getBangCap().equalsIgnoreCase(TRUNGCAP)) {
            radMedium.setChecked(true);
        }
        StringTokenizer tokenizer = new StringTokenizer(persion.getSoThich());
        String other = "";
        if(persion.getSoThich().contains(ckRead.getText().toString())){
            ckRead.setChecked(true);
            tokenizer.nextToken(";");
        }
        if(persion.getSoThich().contains(ckTravel.getText().toString())){
            ckTravel.setChecked(true);
            tokenizer.nextToken(";");
        }
        if(tokenizer.hasMoreElements()){
            other = tokenizer.nextToken(";");
            edtOtherHoppies.setText(other);
        }
    }

    private void clear() {
        edtName.setText("");
        radGroup.clearCheck();
        ckRead.setChecked(false);
        ckTravel.setChecked(false);
        edtOtherHoppies.setText("");
        edtName.requestFocus();
    }

    private Persion createPersionFromLayout() {
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
            return nhanSu;
        }
        return null;
    }

}
