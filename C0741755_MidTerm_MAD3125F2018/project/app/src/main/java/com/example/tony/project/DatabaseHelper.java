package com.example.tony.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "electricitybill.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Email";
    public static final String COL_6 = "phone";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null ,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +  TABLE_NAME  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , FirstName VARCHAR(10) NOT NULL ,LastName VARCHAR(10) ,Password VARCHAR(10) NOT NULL,Email VARCHAR(10) NOT NULL ,Phone VARCHAR(10) NOT NULL,Units DOUBLE,Total DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );//DROP OLDER TABLE
        onCreate(db);

    }
}

