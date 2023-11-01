package tdc.edu.vn.quanlynhansu.database_layer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import tdc.edu.vn.quanlynhansu.Persion;
import tdc.edu.vn.quanlynhansu.R;

public class PersionDatabase extends SQLiteOpenHelper {
    //database properties
    private static String DD_NAME = "persions";
    private static int DB_VERSION = 1;
    private static Activity context;
    ///////////////////////////////////////////////
    //// Table properties
    //////////////////////////////////////////////

    //1.Persion table
    private String PER_TABLE_NAME = "persion";
    private String PER_ID = "_id";
    private String PER_NAME = "_name";
    private String PER_DEGREE = "_degree";
    private String PER_HOBBIES = "_hobbies";

    ///////////////////////////////////////////////
    //// Construstors
    //////////////////////////////////////////////
    public PersionDatabase(Activity context) {
        super(context, DD_NAME, null, DB_VERSION);
        PersionDatabase.context = context;
    }

    ///////////////////////////////////////////////
    //// Persion Database Primitives
    //////////////////////////////////////////////
    //2.Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        if (db != null) {
            //SQl statement
            String sql = "CREATE TABLE " + PER_TABLE_NAME + "("
                    + PER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + PER_NAME + " TEXT, "
                    + PER_DEGREE + " TEXT, "
                    + PER_HOBBIES + " TEXT);";
            //Execute the sql statement
            db.execSQL(sql);
//            db.close();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO when the database version changer;
    }

    ///////////////////////////////////////////////
    //// Persion Database APIs
    //////////////////////////////////////////////
    //1.Save Persion to persion Databse
    public void savePersion(Persion persion) {
        SQLiteDatabase database = getWritableDatabase();
        if (database != null) {
            ContentValues value = new ContentValues();
            value.put(PER_NAME, persion.getHoVaTen());
            value.put(PER_DEGREE, persion.getBangCap());
            value.put(PER_HOBBIES, persion.getSoThich());
            database.insert(PER_TABLE_NAME, null, value);
//            database.close();
        }

    }

    //2.Save Persion to persion Databse
    public void savePersions(ArrayList<Persion> people) {
        SQLiteDatabase database = getWritableDatabase();
        if (database != null) {
            for (Persion p : people) {
                ContentValues value = new ContentValues();
                value.put(PER_NAME, p.getHoVaTen());
                value.put(PER_DEGREE, p.getBangCap());
                value.put(PER_HOBBIES, p.getSoThich());
                database.insert(PER_TABLE_NAME, null, value);
            }
            //TODO Show dialog to user
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.lblDialogTitle));
            builder.setMessage("The persion are written in to the database");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();
//            builder.setNegativeButton("Cancer", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//            database.close();
        }
    }

    //3.Get persion from Persion Database
    public void getPersion(ArrayList<Persion> people) {
        SQLiteDatabase database = getWritableDatabase();
        if (database != null) {
            String[] selectionColunm = new String[]{PER_ID, PER_NAME, PER_DEGREE, PER_HOBBIES};
            String whereCondition = null;
            String[] whereArg = null;
            String groupBy = null;
            String having = null;
            Cursor cursor = database.query(PER_TABLE_NAME, selectionColunm, whereCondition, whereArg, groupBy, having, PER_NAME + " ASC");//DESC giam
            if(cursor.moveToFirst()){
                do {
                  Persion persion = new Persion();
                  //Read data from cursor and set to open object
                    String name = cursor.getString(cursor.getColumnIndex(PER_NAME));
                    String degree = cursor.getString(cursor.getColumnIndex(PER_DEGREE));
                    String hobbies = cursor.getString(cursor.getColumnIndex(PER_HOBBIES));
                     persion.setHoVaTen(name);
                     persion.setBangCap(degree);
                     persion.setSoThich(hobbies);
//                   persion.setSoThich(cursor.getString(cursor.getColumnIndex(PER_HOBBIES)));

                    //Add the new persion to the people
                    people.add(persion);
                }while (cursor.moveToNext());
            }
            database.close();
        }
    }

    //4.Save Persion to persion Databse
    public void updatePersion(Persion oldPersion, Persion newPersion) {
        SQLiteDatabase database = getWritableDatabase();
        if (database != null) {

            //TODO Show dialog to user
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.lblDialogTitle));
            builder.setMessage("The persion are written in to the database");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();
        }
    }

    //1.Save Persion to persion Databse
    public void daletePersion(Persion persion) {

    }

}
