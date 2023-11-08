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

        Result.setText( nro1+" "+nro2+" "+ action);

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