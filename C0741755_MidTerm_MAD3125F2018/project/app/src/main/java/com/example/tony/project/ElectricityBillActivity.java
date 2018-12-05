package com.example.tony.project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class ElectricityBillActivity extends AppCompatActivity {

    private static final String TAG = "EletrcityBillActivity";
    private TextView displaydate;
    private DatePickerDialog.OnDateSetListener mDateSetListner;



    private Button calculatebutton;
    EditText customerid;
    EditText customername;
    EditText customeremail;
    EditText customerunitsconsumed;
    String customerEmail;
    String customerName;
    String customerunitsConsumed;
    String gtcustomerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill);

        calculatebutton = (Button)findViewById(R.id.calculatebutton);
        customerid  = findViewById(R.id.customerid);
        customername = findViewById(R.id.customername);
        customeremail = findViewById(R.id.customeremail);
        customerunitsconsumed = findViewById(R.id.unitscosumed);



        calculatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectricityBillActivity.this, BillDetails.class);

                gtcustomerid = customerid.getText().toString();
                customerEmail = customeremail.getText().toString();
                customerName = customername.getText().toString();
                customerunitsConsumed = customerunitsconsumed.getText().toString();
                Log.d("CUSTOMERID", gtcustomerid);
                intent.putExtra("gtcustomerid",gtcustomerid);
                intent.putExtra("customername",customerName);
                intent.putExtra("customeremail",customerEmail);
                intent.putExtra("unitsconsumed",customerunitsConsumed);
                //ec.calculation();
                startActivity(intent);
                finish();

            }
        });




    }

}

