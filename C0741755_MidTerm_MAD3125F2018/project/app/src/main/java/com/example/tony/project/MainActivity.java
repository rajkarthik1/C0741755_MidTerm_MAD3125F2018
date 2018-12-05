package com.example.tony.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button registerbutton;
    EditText registername,registerlastname,registeremail,registerpassword,registerphone;
    private TextView registertextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registertextview = (TextView) findViewById(R.id.registertextview);

        registername = (EditText)findViewById(R.id.registername);
        registerlastname = (EditText)findViewById(R.id.registerlastname);
        registeremail = (EditText)findViewById(R.id.registeremail);
        registerpassword = (EditText)findViewById(R.id.registerpassword);
        registerphone = (EditText)findViewById(R.id.registerphone);
        registerbutton = (Button)findViewById(R.id.registerbutton);
        openHelper = new DatabaseHelper(this);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!filedsvalidate()) {
                    validate();
                    db = openHelper.getWritableDatabase();
                    String firstname = registername.getText().toString();
                    String lastname = registerlastname.getText().toString();
                    String email = registeremail.getText().toString();
                    String password = registerpassword.getText().toString();
                    String phone = registerphone.getText().toString();
                    inserdata(firstname, lastname, email, password, phone);
                    Toast.makeText(getApplicationContext(), "registrations sucessfull", Toast.LENGTH_LONG).show();
                }

            }
        });
        registertextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class ));
            }
        });
    }
    public void inserdata(String fname,String lname,String email, String pass, String phone){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,fname);
        contentValues.put(DatabaseHelper.COL_3,lname);
        contentValues.put(DatabaseHelper.COL_4,email);
        contentValues.put(DatabaseHelper.COL_5,pass);
        contentValues.put(DatabaseHelper.COL_6,phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);


    }
    public Boolean validate(){

        Boolean result = false;
        String fname = registername.getText().toString();
        String lname = registerlastname.getText().toString();
        String Email = registeremail.getText().toString();
        String Pass = registerpassword.getText().toString();
        String Phone = registerphone.getText().toString();


        if (fname.isEmpty() && lname.isEmpty() && Email.isEmpty() && Pass.isEmpty() && Phone.isEmpty()){
            Toast.makeText(this,"ALL FIELDS ARE REQUIRED",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            result = true;
        }
        return result;
    }
    public Boolean filedsvalidate() {
        if (registername.getText().toString().isEmpty() || registerlastname.getText().toString() == null || registeremail.getText().toString() == null || registerphone.getText().toString() == null || registerpassword.getText().toString() == null) {
            Toast.makeText(this, "ALL FIELDS ARE REQUIRED", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            validate();

        }
        return false;

    }
    @Override
    public void onClick(View view) {

    }
}
