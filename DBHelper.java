package com.example.bloodbank;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioButton;
import android.widget.SpinnerAdapter;


public class DBHelper extends SQLiteOpenHelper{
    public static final String database_name = "Registration.db";
    public static final String table_name = "Register";
    public static final int versioncode = 1;
    //public static final String uid = "ID";
    public  static final String nname = "NAME";
    public static final String rbb = "MALE";
    public static final String rbb2 = "FEMALE";
    public static final String addresss = "ADDRESS";
    public static final String contactnumberr = "ContactNumber";
    public static final String spinner = "BloodType";
    public static final String uname = "USERNAME";
    public static final String pwd = "PASSWORD";



    public DBHelper(Context context)
    {
        super(context, database_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query= "CREATE TABLE IF NOT EXISTS " + table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MALE RADIOBUTTON,FEMALE RADIOBUTTON,ADDRESS TEXT,CONTACTNUMBER NUMERIC,USERNAME TEXT,PASSWORD TEXT)";
        database.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS " + table_name;
        database.execSQL(query);
        onCreate(database);

    }

    public boolean RegisterData(String name, String rb1, String  rb2, String address, String contactNumber, String bloodType, String username, String password) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(nname, name);
        cv.put(rbb, rb1);
        cv.put(rbb2, rb2);
        cv.put(addresss, address);
        cv.put(contactnumberr, contactNumber);
        cv.put(spinner, bloodType);
        cv.put(uname, username);
        cv.put(pwd, password);
        long result = db1.insert(table_name, null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db1 = this.getWritableDatabase();

        Cursor res = db1.rawQuery("select * from " + table_name, null);
        return res;
    }


}






