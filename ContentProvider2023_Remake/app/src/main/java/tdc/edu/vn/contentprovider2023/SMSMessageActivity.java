package tdc.edu.vn.contentprovider2023;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contentprovider2023_remake.R;

import java.util.ArrayList;
import tdc.edu.vn.contentprovider2023.DataModel.SMSMessage;

public class SMSMessageActivity extends AppCompatActivity {
    private ArrayList<SMSMessage> list;
    private ArrayAdapter<SMSMessage> adapter;
    private int REQ = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smsmessage_layout);

        list = new ArrayList<SMSMessage>();

        ListView listMess = findViewById(R.id.listMess);

        adapter = new ArrayAdapter<SMSMessage>(this, android.R.layout.simple_list_item_1,list);
        listMess.setAdapter(adapter);

        //check request permission
        if(checkPermission(Manifest.permission.READ_SMS)){
            doWithPermission();
        }
        else {
            requestPermissions(new String[] {Manifest.permission.READ_SMS}, REQ);
        }
    }

    private boolean checkPermission(String permission){
        int check = checkSelfPermission(permission);
        if (check == PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            return false;
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if ((REQ == requestCode) && permissions.length == grantResults.length){
            int i = 0;
            for (; i < grantResults.length; ++i){
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    return;
                }
            }
        }
    }

    private void doWithPermission(){
        readMessage(list);
        adapter.notifyDataSetChanged();
    }

    private void readMessage(ArrayList<SMSMessage> smsMess) {
        //B1: Uri Definition
        Uri uri = Telephony.Sms.CONTENT_URI;
        //B2: Projection Definition
        String[] projection = new String[]{
                Telephony.Sms.ADDRESS,
                Telephony.Sms.BODY,
                Telephony.Sms.DATE
        };
        //B3: Selection Condition Definition
        String selection = null;
        String[] selectionArg = null;
        //B4: Query to get SMS content from SMS Provider
        Cursor cursor = getContentResolver().query(
                uri,
                projection,
                selection,
                selectionArg,
                Telephony.Sms.DATE + " DESC"
        );
        //B5: Get SMS content and fill from to sms array
        while (cursor.moveToNext()){
            SMSMessage mess = new SMSMessage();
            //get data
            mess.setSender(cursor.getString(cursor.getColumnIndexOrThrow( Telephony.Sms.ADDRESS)));
            mess.setBody(cursor.getString(cursor.getColumnIndexOrThrow( Telephony.Sms.BODY)));
            mess.setDate(cursor.getString(cursor.getColumnIndexOrThrow( Telephony.Sms.DATE)));
            smsMess.add(mess);
        }
    }
}
