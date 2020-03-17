package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static final String Database_name = "MAIN.db";
    public  static final String table_name = "USER_TABLE";
    public  static final String col1 = "ID";
    public  static final String col2 = "USER_NAME";
    public  static final String col3 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_name +" (ID integer primary key autoincrement , USER_NAME text, PASSWORD text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }


    public  boolean insertdata(String USER_NAME, String PASSWORD){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, USER_NAME);
        contentValues.put(col3, PASSWORD);
        long result = db.insert(table_name, null, contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkvalid(String USER_NAME, String Password){
        String excuquery = "SELECT * FROM USER_TABLE WHERE USER_NAME  = '" + USER_NAME + "' AND PASSWORD = '" + Password +"'";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(excuquery,null);
        int count = 0;
        count = cursor.getCount();

        if (count == 1){
            return true;
        }else{
            return false;
        }
    }


}