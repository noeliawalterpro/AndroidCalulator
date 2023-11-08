package com.noeliawalterpro.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;


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

        String[] Actions = {"ADD", "DIVISION", "MULTIPLY", "SUBTRACT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Actions);
        calculatorActions.setAdapter(adapter);

        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            int nro1 = Integer.parseInt(textInput1.getText().toString());
            int nro2 = Integer.parseInt(textInput2.getText().toString());
            String action = calculatorActions.getSelectedItem().toString();

            intent.putExtra("nro1",nro1 );
            intent.putExtra("nro2",nro2 );
            intent.putExtra("action",action );

            startActivity(intent);

        });

    }
}

