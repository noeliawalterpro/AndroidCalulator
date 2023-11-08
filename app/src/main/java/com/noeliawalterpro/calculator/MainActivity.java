package com.noeliawalterpro.calculator;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText textInput1,textInput2;
    Spinner calculatorActions;
    Button btnCalculate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput1 = findViewById(R.id.textInput1);
        textInput2 = findViewById(R.id.textInput2);
        calculatorActions =findViewById(R.id.calculatorActions);


        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }

        });
    }
}

