package com.noeliawalterpro.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


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

        TextView Hint= findViewById(R.id.text_hint);


        String[] Actions = {"ADD", "DIVISION", "MULTIPLY", "SUBTRACT", "PERCENTAGE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Actions);
        calculatorActions.setAdapter(adapter);

        btnCalculate = findViewById(R.id.btn_calculate);
        calculatorActions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String action = calculatorActions.getSelectedItem().toString();
                switch (action) {
                    case "ADD":
                        Hint.setText("Operation: a + b ");
                        break;
                    case "SUBTRACT":
                        Hint.setText("Operation: a - b ");
                        break;
                    case "MULTIPLY":
                        Hint.setText("Operation: a x b ");
                        break;
                    case "DIVISION":
                        Hint.setText("Operation: a / b ");
                        break;
                    case "PERCENTAGE":
                        Hint.setText("Operation: %b of a  ");
                        break;
                    default:
                        Hint.setText("Select an Operation ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                String action = calculatorActions.getSelectedItem().toString();
                Hint.setText("Select an Operation ");
            }


        });


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

