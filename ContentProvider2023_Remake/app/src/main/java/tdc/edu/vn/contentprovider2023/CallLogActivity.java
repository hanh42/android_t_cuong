package tdc.edu.vn.contentprovider2023;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contentprovider2023_remake.R;

import java.util.ArrayList;

import tdc.edu.vn.contentprovider2023.DataModel.CallLog;

public class CallLogActivity extends AppCompatActivity {

    private ArrayList<CallLog> list;
    private ArrayAdapter<CallLog> adapter;
    private ListView listCall;
    private int REQ = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calllog_layout);

        list = new ArrayList<CallLog>();
//        list.add(new CallLog("dryt","vhj","fh","fh","fh"));
//        list.add(new CallLog("dryt","h","fh","fh","fh"));
//        list.add(new CallLog("dryt","vhjg","fh","fh","fh"));
//        list.add(new CallLog("dryt","h","fh","fh","fh"));
//        list.add(new CallLog("dryt","ghg","fh","fh","fh"));

        listCall = findViewById(R.id.listCall);

        adapter = new ArrayAdapter<CallLog>(this, android.R.layout.simple_list_item_1,list);
        listCall.setAdapter(adapter);

        //check request permission
        if(checkPermission(Manifest.permission.READ_CALL_LOG)){
            doWithPermission();
        }
        else {
            requestPermissions(new String[] {Manifest.permission.READ_CALL_LOG}, REQ);
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
                    break;
                }
            }
            if (i == grantResults.length){
                doWithPermission();
            }
            else {
                Toast.makeText(this,"",Toast.LENGTH_LONG);
            }
        }
    }

    private void doWithPermission(){
        readCallLogs(list);
        adapter.notifyDataSetChanged();
    }

    private void readCallLogs(ArrayList<CallLog> callLogs) {
        //B1: Get uri cua provider CallLog
        Uri uri = android.provider.CallLog.Calls.CONTENT_URI;
        //B2: Definication of Projection
        String[] projection = new String[]{
                android.provider.CallLog.Calls.DURATION,
                android.provider.CallLog.Calls.NUMBER,
                android.provider.CallLog.Calls.COUNTRY_ISO,
                android.provider.CallLog.Calls.TYPE,
                android.provider.CallLog.Calls.DATE
        };
        //B3: Definition of where condision
        String selection = null;
        String[] selectionArg = null;

        //B4: Query to get data from Callog Provider
        Cursor cursor = getContentResolver().query(
                uri,
                projection,
                selection,
                selectionArg,
                android.provider.CallLog.Calls.DATE + " DESC"
        );

        //Get call log data from cursor to calllog array
        while (cursor.moveToNext()){
            CallLog callLog = new CallLog();
            //Get data
            callLog.setDuration(cursor.getString(cursor.getColumnIndexOrThrow( android.provider.CallLog.Calls.DURATION)));
            callLog.setNumber(cursor.getString(cursor.getColumnIndexOrThrow( android.provider.CallLog.Calls.NUMBER)));
            callLog.setCountry(cursor.getString(cursor.getColumnIndexOrThrow( android.provider.CallLog.Calls.COUNTRY_ISO)));
            callLog.setType(cursor.getString(cursor.getColumnIndexOrThrow(android.provider.CallLog.Calls.TYPE)));
            callLog.setDate(cursor.getString(cursor.getColumnIndexOrThrow( android.provider.CallLog.Calls.DATE)));
            //Add to call log array
            callLogs.add(callLog);
        }
    }

}
