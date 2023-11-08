package com.noeliawalterpro.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    Button btnReturn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView Result = findViewById(R.id.text_result);
        Bundle data =getIntent().getExtras();

        int nro1 = data.getInt("nro1");
        int nro2 = data.getInt("nro2");
        String action = data.getString("action");

        switch(action) {
            case "ADD":
                int sum = nro1 + nro2;
                Result.setText( nro1+" + "+nro2+"="+ sum);
                break;
            case "SUBTRACT":
                int sub = nro1 - nro2;
                Result.setText( nro1+" - "+nro2+"="+ sub);
                break;
            case "MULTIPLY":
                int multiply = nro1 * nro2;
                Result.setText( nro1+" x "+nro2+"="+ multiply);
                break;
            case "DIVISION":
                int division = nro1 / nro2;
                Result.setText( nro1+" / "+nro2+"="+ division);
                break;
            case "PERCENTAGE":
                int percent = nro1 * nro2/100;
                Result.setText( "%"+nro2+" of "+nro1+"="+ percent);
                break;

        }

        btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}