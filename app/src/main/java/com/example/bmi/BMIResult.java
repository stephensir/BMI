package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIResult extends AppCompatActivity {

    // Properties
    private String TAG = "BMIResult===>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        // make relationship
        TextView txtOuptut = findViewById(R.id.txtOutput);

        // offload bundle
        Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        double _dh = bundle.getDouble("HEIGHT");
        double _dw = bundle.getDouble("WEIGHT");

        // Log
        Log.d(TAG,"height=" + _dw + ",weight = "+_dw);

        // Caculate BMI
        double bmi = _dw / (_dh * _dh);

        // Number formatting
        java.text.NumberFormat numberFormat = new DecimalFormat("0.00");

        // Output
        String output = "";
        output += "Your height is " + _dh + " (cm)\n";
        output += "Your weight is " + _dw + " (kg)\n";
        output += "Your BMI figure is " + numberFormat.format(bmi) + "\n";

        // determimate
        if (bmi < 18.5) {
            output += "You are too thin !";
        } else if (bmi >= 24) {
            output += "You are too fat !";
        } else {
            output += "You are normal !";
        }

        txtOuptut.setText(output);
    }
}
