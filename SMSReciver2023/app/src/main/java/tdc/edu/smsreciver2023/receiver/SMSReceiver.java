package tdc.edu.smsreciver2023.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import java.util.StringTokenizer;
import tdc.edu.smsreciver2023.SMSReciverAvtivity2023;
public class SMSReceiver extends BroadcastReceiver {
    private String DATA_KEY = "pdus";
    private String DATA_FORMAT = "format";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle smsData = intent.getExtras();
        if (smsData != null) {
            Object[] pdus = (Object[]) smsData.get(DATA_KEY);
            String format = smsData.getString(DATA_FORMAT);
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; ++i) {
                //Voi phien ban M (API 23 tro di) tro d
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                //Truoc phien ban M
                else {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                //Get phone number Which send this message
                String incomingPhone = smsMessages[i].getDisplayOriginatingAddress();
                //Get Content of the message
                String message = smsMessages[i].getMessageBody();
                //Log.d("SMSReceiver", "Sender:" + incomingPhone + "message:" + message);
                StringTokenizer stringTokenizer = new StringTokenizer(message);
                String key = stringTokenizer.nextToken(":");
                if (key.equalsIgnoreCase("print")) {
                    String msg = stringTokenizer.nextToken();
                    Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show();
                } else if (key.equalsIgnoreCase("call")) {
                    String callNumber = stringTokenizer.nextToken();
                    call(callNumber, context);
                } else if (key.equalsIgnoreCase("lock")) {
                    ((SMSReciverAvtivity2023) context).lock();
                } else {
                    Toast.makeText(context, "Invalid syntax!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    private void call(String callNumber, Context context) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + callNumber));
        context.startActivity(intent);
    }
}
