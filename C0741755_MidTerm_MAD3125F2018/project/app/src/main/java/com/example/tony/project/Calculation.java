package com.example.tony.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

class ElectricityCalculation extends  BillDetails {

 //   double a = 0.0;

    public static void main(String[] args) {



    }
    public static double calculation(int units) {

        double result=0;
        if (units < 100) {
            result = units * 0.75;
        }
        if (units >= 100 && units <= 150) {
            double b = units - 100;
            result = (100 * 0.75) + (b * 1.25);
        }
        if (units > 150 && units <= 200) {
            double c = units - 150;
            result = (150 * 1.25) + (c * 1.75);
        }
        if (units > 200 && units <= 450) {

            result = units * 1.75;
        }
        if (units > 450) {
            result = units * 2.25;
        }
        return result;
    }
}
