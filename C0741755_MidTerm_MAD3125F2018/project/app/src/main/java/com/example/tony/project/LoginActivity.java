package com.example.tony.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    EditText loginemail,loginpassword;
    TextView logintextview;
    Button loginbutton;
    Cursor cursor ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        loginemail = (EditText)findViewById(R.id.entEmail);
        loginpassword = (EditText)findViewById(R.id.entpassword);
        loginbutton = (Button) findViewById(R.id.login);
        logintextview = (TextView)findViewById(R.id.textView3);



        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ElectricityBillActivity.class);

                String email = loginemail.getText().toString();
                String password = loginpassword.getText().toString();
                cursor = db.rawQuery(" SELECT *FROM  " +  DatabaseHelper.TABLE_NAME  + " WHERE " +  DatabaseHelper.COL_5  + " =?  AND " + DatabaseHelper.COL_4 + " =? " , new String[]{ email ,password});

                if (cursor != null){

                    if (cursor.getCount() > 0 ){

                        cursor.moveToNext();

                        Toast.makeText(getApplicationContext(), "LOGIN SUCESSFULL",Toast.LENGTH_SHORT).show();

                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(),"ERROR INVALID USERNAME OR PASSWORD",Toast.LENGTH_SHORT).show();
                    }
                }


            }


        });

        logintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
