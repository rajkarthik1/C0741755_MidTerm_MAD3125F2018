package com.example.tony.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillDetails extends AppCompatActivity {


        Button logoutbutton;
        TextView customerid;
        TextView customername;
        TextView customeremail;
        TextView unitsconsumed;
        TextView totalTextView;

        String cid;
        String cname;
        String cemail;
        String cunits;
        String ctotal;





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bill_details);
            customerid = findViewById(R.id.detailsid);
            customername = findViewById(R.id.detailsname);
            customeremail = findViewById(R.id.detailsemail);
            unitsconsumed = findViewById(R.id.detailsunits);
            totalTextView = findViewById(R.id.detailstotal);



            cid = getIntent().getExtras().getString("gtcustomerid");

            customerid.setText(cid);
            cname = getIntent().getExtras().getString("customername");
            customername.setText(cname);
            cemail = getIntent().getExtras().getString("customeremail");
            customeremail.setText(cemail);

            cunits = getIntent().getExtras().getString("unitsconsumed");


            int units = Integer.parseInt(cunits);
            double total = ElectricityCalculation.calculation(units);
            totalTextView.setText(String.valueOf(total));
            unitsconsumed.setText(cunits);




            logoutbutton = (Button)findViewById(R.id.logoutbutton);


            logoutbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    takeMeToSingup();
                }
            });

        }
        public void takeMeToSingup(){

            Intent intent = new Intent();
            startActivity(new Intent(BillDetails.this,LoginActivity.class ));

        }

    }
