package com.example.simranmhatre.currency_converter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    public void convert(View v){
        EditText r = findViewById(R.id.edit_rupees);
        String value_r = r.getText().toString();
        float x = Float.parseFloat(value_r);
        float ans = x * 0.015f;
        EditText d = findViewById(R.id.edit_dollars);
        d.setText(Float.toString(ans));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
