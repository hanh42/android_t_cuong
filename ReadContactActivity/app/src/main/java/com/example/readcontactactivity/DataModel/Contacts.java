package com.example.readcontactactivity.DataModel;

import android.net.Uri;
import android.provider.ContactsContract;

public class Contacts {
    Uri contactURI = ContactsContract.Contacts.CONTENT_URI;
    String[] projection = {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
    };
    Uri getContactURI = ContactsContract.Data.CONTENT_URI;
    String[] contactInfoProjection = {
            ContactsContract.Data.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
    };

    String contactInfoWhere = ContactsContract.Data.CONTACT_ID + " =? AND " +
            ContactsContract.Data.MIMETYPE + " =? ";
    String[] contactInfoWhereArg = {
//            contactID,
            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
    };


    Uri emailUri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    String[] emailProjecttion = null;
    String emailWhere = ContactsContract.CommonDataKinds.Email.CONTACT_ID +
            " =?";
//    String[] emailWhereArg = {contactID}

}
