package com.example.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Properties
    private String TAG = "BMI===>";
    private EditText editText_height, editText_weight;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate()");

        // make relationship
        editText_height = findViewById(R.id.editText_height);
        editText_weight = findViewById(R.id.editText_weight);
        btnCal = findViewById(R.id.btnCal);

        // Set onClickListener
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get value
                String _h = editText_height.getText().toString();
                String _w = editText_weight.getText().toString();

                // Log
                Log.d(TAG,"height="+_h + ", weight="+_w);

                // data validation
                if (_h.matches("") || _w.matches("")){
                    Toast.makeText(MainActivity.this,
                            "Please input Height and Weight",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // data conversion
                double _dh = Double.parseDouble(_h);
                double _dw = Double.parseDouble(_w);

                // Define Intent and Bundle object
                Intent intent = new Intent(MainActivity.this,BMIResult.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("HEIGHT",_dh);
                bundle.putDouble("WEIGHT",_dw);

                // put Bundle into Intent object
                intent.putExtras(bundle);

                startActivity(intent);
                MainActivity.this.finish();
            }
        }); //setOnClickListener

    }

}
