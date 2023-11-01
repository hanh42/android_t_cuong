package com.example.readcontactacticityhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.readcontactacticityhanh.model.Contact;
import com.example.readcontactacticityhanh.model.Media;

import java.util.ArrayList;

public class ReadMediaActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Media> listContact;
    private ArrayAdapter<Media> adapter;
    private int REQ = 99;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_media_layout);
        listView = findViewById(R.id.list_contact);
        listContact = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listContact);
        listView.setAdapter(adapter);
        if (turnOnPermission(Manifest.permission.READ_CONTACTS)) {
            performAction();
        }
    }


    public void performAction() {
        readContact(listContact);
        adapter.notifyDataSetChanged();
    }

    public boolean turnOnPermission(String permission) {
        if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissions(new String[]{permission}, REQ);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ && permissions.length == grantResults.length) {
            int i;
            for (i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    break;
                }
            }
            if (i == grantResults.length) {
                performAction();
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_LONG);
            }
        }
    }

    public void readContact(ArrayList<Media> listContact) {
        //get uri of provider CallLog
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        //Definition of Projection
        String[] projection = new String[]{
                MediaStore.Audio.AudioColumns.ALBUM,
                MediaStore.Audio.AudioColumns.TITLE,
                MediaStore.Audio.AudioColumns.DURATION,
                MediaStore.Audio.AudioColumns.MIME_TYPE

        };
        String selection = null;
        String[] selectionArg = null;

        //Query to get data from provider
        Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArg, MediaStore.Audio.AudioColumns.ALBUM + " DESC");

        //Get call log data from cursor
        while (cursor.moveToNext()) {
            Media contact = new Media();
            contact.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM)));
            contact.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE)));
            //get duration
            contact.setDuration(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DURATION)));
            listContact.add(contact);
        }
    }

    public ArrayList<String> getNumbers(ArrayList<String> numbers, String id) {
        Uri numberURI = ContactsContract.Data.CONTENT_URI;
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };
        String selection = ContactsContract.Data.CONTACT_ID + " =? AND " + ContactsContract.Data.MIMETYPE + " =?";
        String[] selectionArg = {
                id,
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
        };

        Cursor cursor = getContentResolver().query(numberURI, projection, selection, selectionArg, null);

        while (cursor.moveToNext()) {
            numbers.add(cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)));
        }
        return numbers;
    }

    public ArrayList<String> getEmails(ArrayList<String> emails, String id) {
        Uri emailURI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String[] projection = null;
        String selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " =?";
        String[] selectionArg = {
                id
        };

        Cursor cursor = getContentResolver().query(emailURI, projection, selection, selectionArg, null);

        while (cursor.moveToNext()) {
            emails.add(cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Email.ADDRESS)));
        }
        return emails;
    }

    public ArrayList<String> getAddresses(ArrayList<String> addresses, String id) {
        Uri addressURI = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI;
        String[] projection = null;
        String selection = ContactsContract.CommonDataKinds.StructuredPostal.CONTACT_ID + " =?";
        String[] selectionArg = {
                id
        };

        Cursor cursor = getContentResolver().query(addressURI, projection, selection, selectionArg, null);

        while (cursor.moveToNext()) {
            addresses.add(cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS)));
        }
        return addresses;
    }

}